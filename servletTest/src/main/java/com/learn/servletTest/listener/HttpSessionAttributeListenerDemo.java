package com.learn.servletTest.listener;

import org.apache.log4j.Logger;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

/**
 * 对session的属性操作进行监听
 * Created by linkage on 2016-12-14.
 */
public class HttpSessionAttributeListenerDemo implements HttpSessionAttributeListener {
    private static Logger logger = Logger.getLogger(HttpSessionAttributeListenerDemo.class);

    /**
     * 属性增加时调用
     *
     * @param event
     */
    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        logger.info(event.getSession().getId() + "，增加属性 --> 属性名称："
                + event.getName() + "，属性内容：" + event.getValue());
    }

    /**
     * 属性删除时调用
     *
     * @param event
     */
    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {
        logger.info(event.getSession().getId() + "，删除属性 --> 属性名称："
                + event.getName() + "，属性内容：" + event.getValue());
    }

    /**
     * 属性替换时调用
     *
     * @param event
     */
    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {
        logger.info(event.getSession().getId() + "，替换属性 --> 属性名称："
                + event.getName() + "，属性内容：" + event.getValue());
    }
}
