package com.zj.entity;

public class Goods {
	private int id;
	private String gname;
	private String gdescribe;
	private String gnum;
	private String gprice;
	private String gowner;
	private String gimgurl;
	private String gifaduiting;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getGname() {
		return gname;
	}
	public void setGname(String gname) {
		this.gname = gname;
	}
	public String getGdescribe() {
		return gdescribe;
	}
	public void setGdescribe(String gdescribe) {
		this.gdescribe = gdescribe;
	}
	public String getGnum() {
		return gnum;
	}
	public void setGnum(String gnum) {
		this.gnum = gnum;
	}
	public String getGprice() {
		return gprice;
	}
	public void setGprice(String gprice) {
		this.gprice = gprice;
	}
	public String getGowner() {
		return gowner;
	}
	public void setGowner(String gowner) {
		this.gowner = gowner;
	}
	public String getGimgurl() {
		return gimgurl;
	}
	public void setGimgurl(String gimgurl) {
		this.gimgurl = gimgurl;
	}
	public String getGifaduiting() {
		return gifaduiting;
	}
	public void setGifaduiting(String gifaduiting) {
		this.gifaduiting = gifaduiting;
	}
	@Override
	public String toString() {
		return "Goods [id=" + id + ", gname=" + gname + ", gdescribe=" + gdescribe + ", gnum=" + gnum + ", gprice="
				+ gprice + ", gowner=" + gowner + ", gimgurl=" + gimgurl + ", gifaduiting=" + gifaduiting + "]";
	}
	
	
}
