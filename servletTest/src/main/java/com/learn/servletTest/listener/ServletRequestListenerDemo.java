package com.learn.servletTest.listener;

import org.apache.log4j.Logger;

import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

/**
 * Created by linkage on 2016-12-14.
 */
public class ServletRequestListenerDemo implements ServletRequestListener {
    private static Logger logger = Logger.getLogger(ServletRequestListener.class);

    @Override
    public void requestDestroyed(ServletRequestEvent event) {
        logger.info("** request初始化。http://"
                + event.getServletRequest().getRemoteAddr()
                + event.getServletContext().getContextPath());
    }

    @Override
    public void requestInitialized(ServletRequestEvent event) {
        logger.info("** request销毁。http://"
                + event.getServletRequest().getRemoteAddr()
                + event.getServletContext().getContextPath());
    }
}
