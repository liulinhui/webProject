package com.learn.bean.graduation;

import java.io.Serializable;

public class OldProduct implements Serializable {
	private static final long serialVersionUID = 1L;
	private String user_code;//用户代码
	private String product_code;//产品代码
	private String product_name;//产品名称
	private double plan_income;//原预期年化收益率
	private double reference_income;//买入后参考年化收益率
	private String limit_time;//剩余期限	
	private int transfer_account;//转让份额
	private int rest_account;//剩余份额
	private int transfer_capital;//转让金额
	private char risk;//风险     1:低风险   2:高风险
	private String public_date;//发布时间
	private char state;//购买状态
	private String id;  //id
	private double transfer_price;  //单价
	private String lastdate;  //剩余时间
	
	public double getTransfer_price() {
		return transfer_price;
	}
	public void setTransfer_price(double transfer_price) {
		this.transfer_price = transfer_price;
	}
	public int getRest_account() {
		return rest_account;
	}
	public void setRest_account(int rest_account) {
		this.rest_account = rest_account;
	}
	public String getLastdate() {
		return lastdate;
	}
	public void setLastdate(String lastdate) {
		this.lastdate = lastdate;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLimit_time() {
		return limit_time;
	}
	public void setLimit_time(String limit_time) {
		this.limit_time = limit_time;
	}
	public String getUser_code() {
		return user_code;
	}
	public void setUser_code(String user_code) {
		this.user_code = user_code;
	}
	public String getPublic_date() {
		return public_date;
	}
	public void setPublic_date(String public_date) {
		this.public_date = public_date;
	}
	
	public String getProduct_code() {
		return product_code;
	}
	public void setProduct_code(String product_code) {
		this.product_code = product_code;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public double getPlan_income() {
		return plan_income;
	}
	public void setPlan_income(double plan_income) {
		this.plan_income = plan_income;
	}
	public double getReference_income() {
		return reference_income;
	}
	public void setReference_income(double reference_income) {
		this.reference_income = reference_income;
	}
	public int getTransfer_account() {
		return transfer_account;
	}
	public void setTransfer_account(int transfer_account) {
		this.transfer_account = transfer_account;
	}
	public int getTransfer_capital() {
		return transfer_capital;
	}
	public void setTransfer_capital(int transfer_capital) {
		this.transfer_capital = transfer_capital;
	}
	public char getRisk() {
		return risk;
	}
	public void setRisk(char risk) {
		this.risk = risk;
	}
	
	public char getState() {
		return state;
	}
	public void setState(char state) {
		this.state = state;
	}
	

	
}
