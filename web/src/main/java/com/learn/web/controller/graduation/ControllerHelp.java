package com.learn.web.controller.graduation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ControllerHelp {
	
	
	//获取当前系统时间
	String Reg_time(){
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString=df.format(new Date());
		return dateString;
	}
	//获取当前系统时间
	String Reg_time_(){
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
		String dateString=df.format(new Date());
		return dateString;
	}
	
	 /**  
     * 计算两个日期之间相差的天数  
     * @param smdate 较小的时间 
     * @param bdate  较大的时间 
     * @return 相差天数 
     * @throws java.text.ParseException
     */  
	 public String daysBetween(String smdate,String bdate) throws ParseException{  
	        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");  
	        Calendar cal = Calendar.getInstance();    
	        cal.setTime(sdf.parse(smdate));    
	        long time1 = cal.getTimeInMillis();                 
	        cal.setTime(sdf.parse(bdate));    
	        long time2 = cal.getTimeInMillis();         
	        long between_days=(time2-time1)/(1000*3600*24);  	            
	       return String.valueOf(between_days);     
	    }  
}
