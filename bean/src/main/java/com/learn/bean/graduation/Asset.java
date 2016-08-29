package com.learn.bean.graduation;

import java.io.Serializable;

public class Asset implements Serializable{
	private static final long serialVersionUID = 1L;
	private String id;      //id
	private String user_name;  //用户名
	private String user_code;  //用户代碼
	private String product_name;  //产品名称
	private String product_code;   //产品代码
	private String limit_time;       //到期时间
	private int account;       //数量
	private char risk;               //风险    1:低风险   2:高风险
	private char status;             //付款状态   1:已经拥有  2：正在装让
	private String buy_time;       //买入时间
	private Double plan_income;            //年化收益率
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getProduct_code() {
		return product_code;
	}
	public void setProduct_code(String product_code) {
		this.product_code = product_code;
	}
	public String getLimit_time() {
		return limit_time;
	}
	public void setLimit_time(String limit_time) {
		this.limit_time = limit_time;
	}
	public int getAccount() {
		return account;
	}
	public void setAccount(int account) {
		this.account = account;
	}
	public char getRisk() {
		return risk;
	}
	public void setRisk(char risk) {
		this.risk = risk;
	}
	public char getStatus() {
		return status;
	}
	public void setStatus(char status) {
		this.status = status;
	}
	public String getBuy_time() {
		return buy_time;
	}
	public void setBuy_time(String buy_time) {
		this.buy_time = buy_time;
	}
	public Double getPlan_income() {
		return plan_income;
	}
	public void setPlan_income(Double plan_income) {
		this.plan_income = plan_income;
	}

}
