package com.learn.web.test.ThreadTest;

/**
 * Created by liulinhui on 2016/11/26.
 */
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 创建ITestThreadPoolExecutorService接口
 * 这个接口的主要功能是通过设置的参数创建一个线程池
 */
public interface ITestThreadPoolExecutorService {

    public ThreadPoolExecutor createNewThreadPool();

    public int getCorePoolSize();

    public void setCorePoolSize(int corePoolSize);

    public int getMaxPoolSize();

    public void setMaxPoolSize(int maximumPoolSize);

    public long getKeepAliveTime();

    public void setKeepAliveTime(long keepAliveTime);

    public int getQueueCapacity();

    public void setQueueCapacity(int queueCapacity);

    public TestRejectedExecutionHandler getTestRejectedExecutionHandler();

    public void setTestRejectedExecutionHandler(TestRejectedExecutionHandler testRejectedExecutionHandler);

}
