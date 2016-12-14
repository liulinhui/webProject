package com.learn.servletTest.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**Java中的Filter 并不是一个标准的Servlet ，
 * 它不能处理用户请求，也不能对客户端生成响应。
 * 主要用于对HttpServletRequest 进行预处理，
 * 也可以对HttpServletResponse 进行后处理，是个典型的处理链。
 * 优点：过滤链的好处是，执行过程中任何时候都可以打断，
 * 只要不执行chain.doFilter()就不会再执行后面的过滤器和请求的内容。
 * 而在实际使用时，就要特别注意过滤链的执行顺序问题
 * Created by linkage on 2016-12-13.
 */
public class LogFilter implements Filter {
    FilterConfig config;

    public void destroy() {
        this.config = null;
    }

    public void doFilter(ServletRequest req, ServletResponse res,
                         FilterChain chain) throws IOException, ServletException {
        // 获取ServletContext 对象，用于记录日志
        ServletContext context = this.config.getServletContext();
        //long before = System.currentTimeMillis();
        System.out.println("before the log filter!");
        //context.log("开始过滤");
        // 将请求转换成HttpServletRequest 请求
        HttpServletRequest hreq = (HttpServletRequest) req;
        // 记录日志
        System.out.println("Log Filter已经截获到用户的请求的地址:"+hreq.getServletPath() );
        //context.log("Filter已经截获到用户的请求的地址: " + hreq.getServletPath());
        try {
            // Filter 只是链式处理，请求依然转发到目的地址。
            chain.doFilter(req, res);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("after the log filter!");
        //long after = System.currentTimeMillis();
        // 记录日志
        //context.log("过滤结束");
        // 再次记录日志
        //context.log(" 请求被定位到" + ((HttpServletRequest) req).getRequestURI()
        //      + "所花的时间为: " + (after - before));
    }

    public void init(FilterConfig config) throws ServletException {
        System.out.println("begin do the log filter!");
        this.config = config;
    }

}