package com.learn.web.test.ThreadTest;

import org.apache.log4j.Logger;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * ThreadPoolMonitorService类实现了IThreadPoolMonitorService接口。
 * 这个类用来监控已创建的线程池。
 * Created by liulinhui on 2016/11/26.
 */
public class ThreadPoolMonitorService implements IThreadPoolMonitorService {

    private static Logger log = Logger.getLogger(ThreadPoolMonitorService.class);
    ThreadPoolExecutor executor;
    private long monitoringPeriod;

    public void run() {
        try {
            while (true) {
                monitorThreadPool();
                Thread.sleep(monitoringPeriod * 1000);
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    public void monitorThreadPool() {
        StringBuffer strBuff = new StringBuffer();
        strBuff.append("CurrentPoolSize : ").append(executor.getPoolSize());
        strBuff.append(" - CorePoolSize : ").append(executor.getCorePoolSize());
        strBuff.append(" - MaximumPoolSize : ").append(executor.getMaximumPoolSize());
        strBuff.append(" - ActiveTaskCount : ").append(executor.getActiveCount());
        strBuff.append(" - CompletedTaskCount : ").append(executor.getCompletedTaskCount());
        strBuff.append(" - TotalTaskCount : ").append(executor.getTaskCount());
        strBuff.append(" - isTerminated : ").append(executor.isTerminated());

        log.info(strBuff.toString());
    }

    public ThreadPoolExecutor getExecutor() {
        return executor;
    }

    public void setExecutor(ThreadPoolExecutor executor) {
        this.executor = executor;
    }

    public long getMonitoringPeriod() {
        return monitoringPeriod;
    }

    public void setMonitoringPeriod(long monitoringPeriod) {
        this.monitoringPeriod = monitoringPeriod;
    }
}
