package com.learn.web.test.ThreadTest;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by liulinhui on 2016/11/26.
 */
public interface IThreadPoolMonitorService extends Runnable {

    public void monitorThreadPool();

    public ThreadPoolExecutor getExecutor();

    public void setExecutor(ThreadPoolExecutor executor);
}
