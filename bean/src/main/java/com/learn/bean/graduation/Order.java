package com.learn.bean.graduation;
import java.io.Serializable;
public class Order implements Serializable {
	private static final long serialVersionUID = 1L;
	private String id;  //产品ID
	private String user_code;  //用户名
	private String product_name;  //产品名称
	private String product_code;   //产品代码
	private Double reference_income;  //预计年化收益率
	private String limit_time;       //到期时间
	private int buy_amount;       //购买数量
	private Double price;            //单价  
	private String buy_time;           //购买时间
	private char risk;               //风险    1:低风险   2:高风险
	private char status;             //付款状态   1:未付款   2：已付清  3:已经过期了 
	private Double total_money;    //总价格

	public Double getTotal_money() {
		return total_money;
	}
	public void setTotal_money(Double total_money) {
		this.total_money = total_money;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public Double getReference_income() {
		return reference_income;
	}
	public void setReference_income(Double reference_income) {
		this.reference_income = reference_income;
	}
	public String getLimit_time() {
		return limit_time;
	}
	public void setLimit_time(String limit_time) {
		this.limit_time = limit_time;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getBuy_time() {
		return buy_time;
	}
	public void setBuy_time(String buy_time) {
		this.buy_time = buy_time;
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
	public int getBuy_amount() {
		return buy_amount;
	}
	public void setBuy_amount(int buy_amount) {
		this.buy_amount = buy_amount;
	}
	

}
