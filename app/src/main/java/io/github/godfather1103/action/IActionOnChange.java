package io.github.godfather1103.action;

import org.aopalliance.intercept.MethodInvocation;

/**
 * <p>Title:        Godfather1103's GitHub</p>
 * <p>Copyright:    Copyright (c) 2024</p>
 * <p>Company:      <a href="https://github.com/godfather1103">Godfather1103 GitHub</a></p>
 * 类描述：
 *
 * @author 作者: Jack Chu E-mail: chuchuanbao@gmail.com
 * @version 1.0
 * @date 创建时间：2024/6/27 00:54
 * @since 1.0
 */
public interface IActionOnChange {

    /**
     * isActive<BR>
     *
     * @param changeTo   参数
     * @param invocation 参数
     * @return 结果
     * @author 作者: Jack Chu E-mail: chuchuanbao@gmail.com
     * @date 创建时间：2024/6/26 23:51
     */
    Boolean isActive(String changeTo, MethodInvocation invocation);

    /**
     * before<BR>
     *
     * @param changeTo   参数
     * @param invocation 参数
     * @return 结果
     * @author 作者: Jack Chu E-mail: chuchuanbao@gmail.com
     * @date 创建时间：2024/6/26 23:51
     */
    void before(String changeTo, MethodInvocation invocation);

    /**
     * after<BR>
     *
     * @param changeTo   参数
     * @param invocation 参数
     * @author 作者: Jack Chu E-mail: chuchuanbao@gmail.com
     * @date 创建时间：2024/6/26 23:51
     */
    void after(String changeTo, MethodInvocation invocation);

}
