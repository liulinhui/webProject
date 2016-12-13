package com.learn.servletTest.listener;

import org.apache.log4j.Logger;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * 对ServletContext（Servlet上下文）监听
 * Created by linkage on 2016-12-13.
 */
public class ServletContextListenerDemo implements ServletContextListener {
    private static Logger logger = Logger.getLogger(ServletContextListenerDemo.class);

    public void contextInitialized(ServletContextEvent event) {    // 上下文初始化时触发
        logger.info("** 容器初始化 --> " + event.getServletContext().getContextPath());
    }

    public void contextDestroyed(ServletContextEvent event) {        // 上下文销毁时触发
        logger.info("** 容器销毁 --> " + event.getServletContext().getContextPath());
    }
}
