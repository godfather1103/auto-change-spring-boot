package io.github.godfather1103.spring.boot.autoconfigure;

import io.github.godfather1103.action.IActionOnChange;
import io.github.godfather1103.annotation.ChangeTo;
import io.github.godfather1103.aop.DynamicChangeToAnnotationAdvisor;
import io.github.godfather1103.aop.DynamicChangeToAnnotationInterceptor;
import io.github.godfather1103.config.DynamicChangeToAopProperties;
import io.github.godfather1103.config.DynamicChangeToProperties;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.aop.Advisor;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Role;

import java.util.List;

/**
 * <p>Title:        Godfather1103's GitHub</p>
 * <p>Copyright:    Copyright (c) 2024</p>
 * <p>Company:      <a href="https://github.com/godfather1103">Godfather1103 GitHub</a></p>
 * 类描述：
 *
 * @author 作者: Jack Chu E-mail: chuchuanbao@gmail.com
 * @version 1.0
 * @date 创建时间：2024/6/27 00:44
 * @since 1.0
 */
@Configuration
@EnableConfigurationProperties(DynamicChangeToProperties.class)
@ConditionalOnProperty(prefix = DynamicChangeToProperties.PREFIX, name = "enabled", havingValue = "true", matchIfMissing = true)
public class DynamicChangeToAutoConfiguration implements InitializingBean {

    private final DynamicChangeToProperties properties;

    private final List<IActionOnChange> changes;

    public DynamicChangeToAutoConfiguration(
            DynamicChangeToProperties properties,
            ObjectProvider<List<IActionOnChange>> objectProvider
    ) {
        this.properties = properties;
        this.changes = objectProvider.getIfAvailable();
    }

    @Pointcut("@annotation(io.github.godfather1103.annotation.ChangeTo)")
    public void changeToAnnotation() {
    }

    @Role(BeanDefinition.ROLE_INFRASTRUCTURE)
    @Bean
    @ConditionalOnProperty(prefix = DynamicChangeToProperties.PREFIX + ".aop", name = "enabled", havingValue = "true", matchIfMissing = true)
    public Advisor dynamicChangeToAnnotationAdvisor() {
        DynamicChangeToAopProperties aop = properties.getAop();
        DynamicChangeToAnnotationInterceptor interceptor = new DynamicChangeToAnnotationInterceptor(aop.isAllowedPublicOnly(), changes);
        DynamicChangeToAnnotationAdvisor advisor = new DynamicChangeToAnnotationAdvisor(interceptor, ChangeTo.class);
        advisor.setOrder(aop.getOrder());
        return advisor;
    }

    @Override
    public void afterPropertiesSet() {

    }
}
