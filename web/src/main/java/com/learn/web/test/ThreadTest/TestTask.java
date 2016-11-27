package com.learn.web.test.ThreadTest;

import org.apache.log4j.Logger;

/**
 * Created by liulinhui on 2016/11/26.
 */
public class TestTask implements Runnable {

    private static Logger log = Logger.getLogger(TestTask.class);
    String taskName;

    public TestTask() {
    }

    public TestTask(String taskName) {
        log.info("======新创建好多线程============");
        this.taskName = taskName;
    }

    public void run() {
        try {
            log.info(this.taskName + " : is started.");
            Thread.sleep(1000);
            log.info(this.taskName + " : is completed.");
        } catch (InterruptedException e) {
            log.error(this.taskName + " : is not completed!");
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return (getTaskName());
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }
}
