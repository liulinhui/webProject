package com.learn.springTest.ApplicationContext.ApplicationEvent;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * 监听器类实现ApplicationListener接口实现需要实现的这个方法，发生事件的时候会被触发。
 * Created by linkage on 2016-11-03.
 */
//@Component
public class MessageListener implements ApplicationListener<ApplicationEvent> {
    // 容器事件发生的时候触发方法的执行
    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        if(event instanceof MessageEvent){
            MessageEvent messageEvent = (MessageEvent) event;
            System.out.println("信息内容是:" + messageEvent.getMessageContent());
        }else{
            System.out.println("其他的信息！" + event.toString());
        }

    }
}
