package com.learn.web.test.ThreadTest;

import org.apache.log4j.Logger;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * TestRejectedExecutionHandler类实现了RejectedExecutionHandler接口。如果没有空闲线程并且队列超出限制，任务会被拒绝。这个类处理被拒绝的任务。
 */
public class TestRejectedExecutionHandler implements RejectedExecutionHandler {

    private static Logger log = Logger.getLogger(TestRejectedExecutionHandler.class);

    public void rejectedExecution(Runnable runnable, ThreadPoolExecutor executor) {
        log.info(runnable.toString() + " : has been rejected");
    }
}

