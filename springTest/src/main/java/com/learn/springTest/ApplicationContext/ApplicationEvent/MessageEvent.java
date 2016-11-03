package com.learn.springTest.ApplicationContext.ApplicationEvent;

import org.springframework.context.ApplicationEvent;

/**
 * MessageEvent类继承了ApplicationEvent类，一个事件。
 * Created by linkage on 2016-11-03.
 */
public class MessageEvent extends ApplicationEvent {
    private static final long serialVersionUID = 1L;

    private String messageContent;

    public MessageEvent(Object source) {
        super(source);
    }

    public MessageEvent(Object source, String messageContent) {
        super(source);
        this.messageContent = messageContent;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }
}
