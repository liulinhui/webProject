package com.learn.utils.graduation;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
        /***以下是出发定时操作的类，该类继承了ServletContextListener****/
public class MyTimerListener implements ServletContextListener  {
	private static final Logger logger = LoggerFactory.getLogger(MyTimerListener.class);
	private Time  mytimer = new Time();
	 public void contextInitialized(ServletContextEvent event) {
	        mytimer.timerStart();
	     logger.info("=========================================定时器打开");   
	    }
	 public void contextDestroyed(ServletContextEvent event) {
	        mytimer.timerStop();
	        logger.info("=========================================定时器关闭"); 
	    }
}
