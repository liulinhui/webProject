package com.learn.bean.graduation;

import java.io.Serializable;

public class FuzzyMatch implements Serializable{
	private static final long serialVersionUID = 1L;
	private String product_code;//产品代码
	private String product_name;//产品名称
	private String id;  //id
	private char state;//购买状态
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
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public char getState() {
		return state;
	}
	public void setState(char state) {
		this.state = state;
	}
	
}
