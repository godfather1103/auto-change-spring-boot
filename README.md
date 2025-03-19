# ChangeTo注解

mybaits-plus中可以通过[DS注解](https://github.com/baomidou/dynamic-datasource)来动态切换数据源，受到这个启发实现了一个通用的注解ChangeTo。在对应类或方法中增加对应ChangeTo注解，通过DynamicChangeToContextHolder.peek()获取对应ChangeTo注解的value字段值，并根据相关字段值觉得不同的处理逻辑。

### 源码地址

- [GitHub](https://github.com/godfather1103/auto-change-spring-boot)  
- [Gitee](https://gitee.com/godfather1103/auto-change-spring-boot)  

### 依赖坐标

#### maven

```xml

<dependency>
    <groupId>io.github.godfather1103</groupId>
    <artifactId>auto-change-spring-boot-starter</artifactId>
    <version>LATEST</version>
</dependency>
```

### 示例代码

```java

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
```