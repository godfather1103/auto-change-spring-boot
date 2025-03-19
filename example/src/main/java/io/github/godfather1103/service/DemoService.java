package io.github.godfather1103.service;

import io.github.godfather1103.annotation.ChangeTo;
import io.github.godfather1103.context.DynamicChangeToContextHolder;
import org.springframework.stereotype.Service;

/**
 * <p>Title:        Godfather1103's GitHub</p>
 * <p>Copyright:    Copyright (c) 2025</p>
 * <p>Company:      <a href="https://github.com/godfather1103">Godfather1103 GitHub</a></p>
 * 类描述：
 *
 * @author 作者: Jack Chu E-mail: chuchuanbao@gmail.com
 * @version 1.0
 * @date 创建时间：2025/3/18 17:28
 * @since 1.0
 */
@Service
@ChangeTo("en")
public class DemoService {
    public void sayHello() {
        System.out.println("sayHello:" + DynamicChangeToContextHolder.peek());
        System.out.println("sayHello:" + DynamicChangeToContextHolder.peek());
    }

    @ChangeTo("zh")
    public void sayZhHello() {
        System.out.println("sayZhHello:" + DynamicChangeToContextHolder.peek());
        System.out.println("sayZhHello:" + DynamicChangeToContextHolder.peek());
    }
}
