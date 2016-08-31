package com.learn.web.test.schedulingTasks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by liulinhui on 16-8-31.
 */
@Component
public class ScheduledTasks {
    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

    public void taskA() {
        log.info("The time is TaskA");
    }

    public void taskB() {
        log.info("The time is TaskB");
    }
}
