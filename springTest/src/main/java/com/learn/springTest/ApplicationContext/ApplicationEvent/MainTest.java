package com.learn.springTest.ApplicationContext.ApplicationEvent;

import javafx.application.Application;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 打印的信息中我们看到，打印出来我们监听到的事件的同时，也监听到了内置的事件的消息。
 * spring的内置事件：
 * 1. ContextRefreshedEvent:ApplicationContext容器初始化或者刷新的时候会触发这个事件。
 * 2. ContextStartedEvent:当使用ConfigurableApplicationContext(applicationContext的子接口)接口的start方法启动ApplicationContext容器的时候触发这个事件。
 * 3. ContextClosedEvent:当使用ConfigurableApplicationContext(applicationContext的子接口)接口的close方法启动ApplicationContext容器的时候触发这个事件。
 * 4. ContextStoppedEvent:当使用ConfigurableApplicationContext(applicationContext的子接口)接口的stop方法启动ApplicationContext容器的时候触发这个事件。
 * 5. RequestHandledEvent:web相关的事件，只能用在DispatcherServlet的web应用中，在使用spring作为mvc控制器的时候，处理完用户的请求后，系统会自动的调用。
 * 另外webSocket服务中，还有，SessionConnectedEvent、SessionConnectEvent、SessionDisconnectEvent三个事件。
 * Created by linkage on 2016-11-03.
 */
public class MainTest {
    public static void main(String[] args) {
        ApplicationContext contest = new ClassPathXmlApplicationContext("applicationContext.xml");
        MessageEvent messageEvent = new MessageEvent("", "MessageEventTest success!!");
        contest.publishEvent(messageEvent);
    }
}
