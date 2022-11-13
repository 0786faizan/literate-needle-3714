package com.tms.model;

public class Tender {
	
	private int tendid;
	private String tendname;
	private int bidamount;
	
	public int getTendid() {
		return tendid;
	}
	public void setTendid(int tendid) {
		this.tendid = tendid;
	}
	public String getTendname() {
		return tendname;
	}
	public void setTendname(String tendname) {
		this.tendname = tendname;
	}
	public int getBidamount() {
		return bidamount;
	}
	public void setBidamount(int bidamount) {
		this.bidamount = bidamount;
	}
	public Tender(int tendid, String tendname, int bidamount) {
		super();
		this.tendid = tendid;
		this.tendname = tendname;
		this.bidamount = bidamount;
	}
	@Override
	public String toString() {
		return "Tender [tendid=" + tendid + ", tendname=" + tendname + ", bidamount=" + bidamount + "]";
	} 
	
	public Tender() {
		// TODO Auto-generated constructor stub
	}

}
