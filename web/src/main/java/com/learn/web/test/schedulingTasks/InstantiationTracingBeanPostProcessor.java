package com.learn.web.test.schedulingTasks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

/**
 * 当spring 容器初始化完成后执行某个方法
 * Created by liulinhui on 16-9-1.
 */

public class InstantiationTracingBeanPostProcessor implements ApplicationListener<ContextRefreshedEvent> {
    private static final Logger log = LoggerFactory.getLogger(InstantiationTracingBeanPostProcessor.class);

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        /*
        避免onApplicationEvent方法被执行两次,
        在web 项目中（spring mvc），系统会存在两个容器，一个是root application context ,
        另一个就是我们自己的 projectName-servlet  context（作为root application context的子容器）
         */
        if(event.getApplicationContext().getParent() == null){
            log.info("===============spring 容器初始化完成后执行此方法==============");
        }
    }
}
