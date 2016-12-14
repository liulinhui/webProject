package com.learn.servletTest.listener;

import org.apache.log4j.Logger;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * 对创建或销毁session的操作进行监听
 * 状态监听
 * Created by linkage on 2016-12-14.
 */
public class HttpSessionListenerDemo implements HttpSessionListener {
    private static Logger logger = Logger.getLogger(HttpSessionListenerDemo.class);

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        logger.info("** SESSION创建，SESSION ID = " + httpSessionEvent.getSession().getId());
        OnLineCount.getSessionList(httpSessionEvent.getSession());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        logger.info("** SESSION销毁，SESSION ID = " + httpSessionEvent.getSession().getId());
        OnLineCount.getSessionList(httpSessionEvent.getSession());
    }
}
