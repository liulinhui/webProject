package com.learn.servletTest.listener;

import org.apache.log4j.Logger;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by linkage on 2016-12-14.
 */
public class OnLineCount {
    private static Logger logger = Logger.getLogger(ServletContextListenerDemo.class);
    public static AtomicInteger count;
    public static List<HttpSession> sessionList;

    public static void getSessionList(HttpSession session) {
        logger.info("当前在线" + addCount(session) + "人，session的样子:" + PrintSession());
    }

    public static String PrintSession() {
        StringBuffer sb = new StringBuffer();
        for (HttpSession session : sessionList) {
            sb.append(session.getId());
        }
        return sb.toString();
    }

    public static int addCount(HttpSession session){
        sessionList.add(session);
        return count.addAndGet(1);
    }

    public static void init(){
        count=new AtomicInteger(0);
        sessionList=new ArrayList<>();
    }
}
