package com.tms.model;

public class Vendor {
	
	private int venid;
	private String Venname; 
	private String venmobile;
	private String venemail;
	private String vencompany;
	private String venpassword;
	
	public int getVenid() {
		return venid;
	}
	public void setVenid(int venid) {
		this.venid = venid;
	}
	public String getVenname() {
		return Venname;
	}
	public void setVenname(String venname) {
		Venname = venname;
	}
	public String getVenmobile() {
		return venmobile;
	}
	public void setVenmobile(String venmobile) {
		this.venmobile = venmobile;
	}
	public String getVenemail() {
		return venemail;
	}
	public void setVenemail(String venemail) {
		this.venemail = venemail;
	}
	public String getVencompany() {
		return vencompany;
	}
	public void setVencompany(String vencompany) {
		this.vencompany = vencompany;
	}
	public String getVenpassword() {
		return venpassword;
	}
	public void setVenpassword(String venpassword) {
		this.venpassword = venpassword;
	}
	@Override
	public String toString() {
		return "vendor id = " + venid + ", vendor name = " + Venname + ", vendor mobile = " + venmobile + ", vendor email = " + venemail
				+ ", vendor company = " + vencompany + ", vendor password = " + venpassword ;
	}
	public Vendor(int venid, String venname, String venmobile, String venemail, String vencompany, String venpassword) {
		super();
		this.venid = venid;
		Venname = venname;
		this.venmobile = venmobile;
		this.venemail = venemail;
		this.vencompany = vencompany;
		this.venpassword = venpassword;
	}
	
	public Vendor() {
	
	}

}
