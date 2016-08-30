package com.learn.utils.graduation;

import java.util.TimerTask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
             //执行任务的类，即每隔一段时间要做的事情在这里
public class MyTimeTask extends TimerTask {
	private static final Logger logger = LoggerFactory.getLogger(MyTimeTask.class);
	@Override
	public void run(){
		logger.info("================************************定时生成RSA密钥对");
		try {
			RSAUtil.generateKeyPair().getPublic();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
