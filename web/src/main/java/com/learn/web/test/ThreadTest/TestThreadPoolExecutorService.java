package com.learn.web.test.ThreadTest;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by liulinhui on 2016/11/26.
 */
public class TestThreadPoolExecutorService implements ITestThreadPoolExecutorService {

    private int corePoolSize;
    private int maxPoolSize;
    private long keepAliveTime;
    private int queueCapacity;
    TestRejectedExecutionHandler testRejectedExecutionHandler;

    public ThreadPoolExecutor createNewThreadPool() {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(getCorePoolSize(),
                getMaxPoolSize(),
                getKeepAliveTime(),
                TimeUnit.SECONDS,
                new ArrayBlockingQueue(getQueueCapacity()),
                getTestRejectedExecutionHandler());
        return executor;
    }

    public int getCorePoolSize() {
        return corePoolSize;
    }

    public void setCorePoolSize(int corePoolSize) {
        this.corePoolSize = corePoolSize;
    }

    public int getMaxPoolSize() {
        return maxPoolSize;
    }

    public void setMaxPoolSize(int maxPoolSize) {
        this.maxPoolSize = maxPoolSize;
    }

    public long getKeepAliveTime() {
        return keepAliveTime;
    }

    public void setKeepAliveTime(long keepAliveTime) {
        this.keepAliveTime = keepAliveTime;
    }

    public int getQueueCapacity() {
        return queueCapacity;
    }

    public void setQueueCapacity(int queueCapacity) {
        this.queueCapacity = queueCapacity;
    }

    public TestRejectedExecutionHandler getTestRejectedExecutionHandler() {
        return testRejectedExecutionHandler;
    }

    public void setTestRejectedExecutionHandler(TestRejectedExecutionHandler testRejectedExecutionHandler) {
        this.testRejectedExecutionHandler = testRejectedExecutionHandler;
    }
}

