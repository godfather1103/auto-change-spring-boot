package io.github.godfather1103.aop;

import io.github.godfather1103.action.IActionOnChange;
import io.github.godfather1103.context.DynamicChangeToContextHolder;
import io.github.godfather1103.support.ClassResolver;
import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * <p>Title:        Godfather1103's GitHub</p>
 * <p>Copyright:    Copyright (c) 2024</p>
 * <p>Company:      <a href="https://github.com/godfather1103">Godfather1103 GitHub</a></p>
 * 类描述：动态切换的切口
 *
 * @author 作者: Jack Chu E-mail: chuchuanbao@gmail.com
 * @version 1.0
 * @date 创建时间：2024/6/27 00:22
 * @since 1.0
 */
@Slf4j
public class DynamicChangeToAnnotationInterceptor implements MethodInterceptor {

    private final ClassResolver classResolver;

    private final List<IActionOnChange> actionOnChanges;

    public DynamicChangeToAnnotationInterceptor(
            Boolean allowedPublicOnly,
            List<IActionOnChange> actionOnChanges
    ) {
        this.classResolver = new ClassResolver(allowedPublicOnly);
        this.actionOnChanges = Optional.ofNullable(actionOnChanges).orElse(Collections.emptyList());
    }

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        String changeTo = classResolver.findKey(invocation.getMethod(), invocation.getThis());
        List<IActionOnChange> action = actionOnChanges
                .stream()
                .filter(it -> it.isActive(changeTo, invocation))
                .collect(Collectors.toList());
        DynamicChangeToContextHolder.push(changeTo);
        try {
            for (IActionOnChange change : action) {
                try {
                    change.before(changeTo, invocation);
                } catch (Throwable e) {
                    log.warn("[{}]前置执行出错！", change.getClass().getName(), e);
                }
            }
            return invocation.proceed();
        } finally {
            for (IActionOnChange change : action) {
                try {
                    change.after(changeTo, invocation);
                } catch (Throwable e) {
                    log.warn("[{}]后置执行出错！", change.getClass().getName(), e);
                }
            }
            DynamicChangeToContextHolder.poll();
        }
    }
}
