package com.zj.entity;

public class Customer {
	
	private int id;
	private String cname;
	private String cpassword;
	private String cimgurl;
	private String cphone;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCpassword() {
		return cpassword;
	}
	public void setCpassword(String cpassword) {
		this.cpassword = cpassword;
	}
	public String getCimgurl() {
		return cimgurl;
	}
	public void setCimgurl(String cimgurl) {
		this.cimgurl = cimgurl;
	}
	public String getCphone() {
		return cphone;
	}
	public void setCphone(String cphone) {
		this.cphone = cphone;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", cname=" + cname + ", cpassword=" + cpassword + ", cimgurl=" + cimgurl
				+ ", cphone=" + cphone + "]";
	}
	
	

}
