package io.github.godfather1103.config;

import lombok.Data;
import org.springframework.core.Ordered;

/**
 * <p>Title:        Godfather1103's GitHub</p>
 * <p>Copyright:    Copyright (c) 2025</p>
 * <p>Company:      <a href="https://github.com/godfather1103">Godfather1103 GitHub</a></p>
 * 类描述：
 *
 * @author 作者: Jack Chu E-mail: chuchuanbao@gmail.com
 * @version 1.0
 * @date 创建时间：2025/3/18 17:55
 * @since 1.0
 */
@Data
public class DynamicChangeToAopProperties {

    /**
     * enabled default ChangeTo annotation default true
     */
    private Boolean enabled = true;

    /**
     * aop order
     */
    private Integer order = Ordered.HIGHEST_PRECEDENCE;

    /**
     * aop allowedPublicOnly
     */
    private boolean allowedPublicOnly = true;

}
