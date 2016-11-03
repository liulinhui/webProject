package com.learn.springTest.ApplicationContextAware;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * Created by linkage on 2016-11-03.
 */
public class LiuLinHui implements Person, ApplicationContextAware {
    private MessageService service;

    public void setService(MessageService service) {
        this.service = service;
    }

    /**
     * 实现person接口中的方法
     */
    @Override
    public void sendMessage() {
        this.service.printMessage();
    }

    /**
     * 实现ApplicationContextAware中的方法
     */
    @Override
    public void setApplicationContext(ApplicationContext context)
            throws BeansException {
        this.service = context.getBean("messageService", MessageService.class);
    }
}
