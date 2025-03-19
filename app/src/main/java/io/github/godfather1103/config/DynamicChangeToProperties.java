package io.github.godfather1103.config;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

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
@ConfigurationProperties(prefix = DynamicChangeToProperties.PREFIX)
@Data
public class DynamicChangeToProperties {

    public static final String PREFIX = "spring.auto.change";

    @NestedConfigurationProperty
    private DynamicChangeToAopProperties aop = new DynamicChangeToAopProperties();

}
