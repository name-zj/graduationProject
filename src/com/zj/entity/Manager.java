package com.zj.entity;

public class Manager {

	private int id;
	private String mname;
	private String mpassword;
	private String mimgurl;
	
	public String getMimgurl() {
		return mimgurl;
	}
	public void setMimgurl(String mimgurl) {
		this.mimgurl = mimgurl;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getMpassword() {
		return mpassword;
	}
	public void setMpassword(String mpassword) {
		this.mpassword = mpassword;
	}
	@Override
	public String toString() {
		return "Manager [id=" + id + ", mname=" + mname + ", mpassword=" + mpassword + ", mimgurl=" + mimgurl + "]";
	}
	
	
	
}
