package com.learn.bean.graduation;

import java.io.Serializable;

public class RealUser implements Serializable{
	private static final long serialVersionUID = 1L;
	private String user_name;//用户名
	private String user_code;//资金账号
	private String user_password;//用户密码
	private double user_asset;//用户资产
	private String reg_time;//注册时间


	public String getReg_time() {
		return reg_time;
	}

	public void setReg_time(String reg_time) {
		this.reg_time = reg_time;
	}

	public double getUser_asset() {
		return user_asset;
	}

	public void setUser_asset(double user_asset) {
		this.user_asset = user_asset;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_code() {
		return user_code;
	}

	public void setUser_code(String user_code) {
		this.user_code = user_code;
	}

	public String getUser_password() {
		return user_password;
	}

	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}

	
}
