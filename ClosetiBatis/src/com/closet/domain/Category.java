package com.closet.domain;

public class Category {
	int categCode;
	String categName;
	
	public Category(){}
	
	public Category(int categCode, String categName){
		this.categCode=categCode;
		this.categName=categName;
	}
	
	public int getCategCode() {
		return categCode;
	}
	public void setCategCode(int categCode) {
		this.categCode = categCode;
	}
	public String getCategName() {
		return categName;
	}
	public void setCategName(String categName) {
		this.categName = categName;
	}
	
	
}
