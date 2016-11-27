package com.learn.web.test.ThreadTest;

import org.apache.log4j.Logger;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by liulinhui on 2016/11/26.
 */
public class Starter {

    private static Logger log = Logger.getLogger(TestRejectedExecutionHandler.class);

    IThreadPoolMonitorService threadPoolMonitorService;
    ITestThreadPoolExecutorService testThreadPoolExecutorService;

    public void start() {

        // A new thread pool is created...
        ThreadPoolExecutor executor = testThreadPoolExecutorService.createNewThreadPool();
        executor.allowCoreThreadTimeOut(true);

        // Created executor is set to ThreadPoolMonitorService...
        threadPoolMonitorService.setExecutor(executor);

        // ThreadPoolMonitorService is started...
        Thread monitor = new Thread(threadPoolMonitorService);
        monitor.start();

        // New tasks are executed...
        for(int i=0;i<100;i++) {
            executor.execute(new TestTask("Task"+i));
        }

        try {
            Thread.sleep(4000);
        } catch (Exception e)   {
            log.error(e.getMessage());
        }
        log.info("休息寺庙中");
        for(int i=100;i<190;i++) {
            executor.execute(new TestTask("Task"+i));
        }

        // executor is shutdown...
        executor.shutdown();
    }

    public IThreadPoolMonitorService getThreadPoolMonitorService() {
        return threadPoolMonitorService;
    }

    public void setThreadPoolMonitorService(IThreadPoolMonitorService threadPoolMonitorService) {
        this.threadPoolMonitorService = threadPoolMonitorService;
    }

    public ITestThreadPoolExecutorService getTestThreadPoolExecutorService() {
        return testThreadPoolExecutorService;
    }

    public void setTestThreadPoolExecutorService(ITestThreadPoolExecutorService testThreadPoolExecutorService) {
        this.testThreadPoolExecutorService = testThreadPoolExecutorService;
    }
}
