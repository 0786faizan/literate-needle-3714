package com.tms.model;

public class Bid {
	
	private int bidid;
	private int vendorid;
	private int tenderid;
	private int bidAmount;
	public int getBidid() {
		return bidid;
	}
	public void setBidid(int bidid) {
		this.bidid = bidid;
	}
	public int getVendorid() {
		return vendorid;
	}
	public void setVendorid(int vendorid) {
		this.vendorid = vendorid;
	}
	public int getTenderid() {
		return tenderid;
	}
	public void setTenderid(int tenderid) {
		this.tenderid = tenderid;
	}
	public int getBidAmount() {
		return bidAmount;
	}
	public void setBidAmount(int bidAmount) {
		this.bidAmount = bidAmount;
	}
	public Bid(int bidid, int vendorid, int tenderid, int bidAmount) {
		super();
		this.bidid = bidid;
		this.vendorid = vendorid;
		this.tenderid = tenderid;
		this.bidAmount = bidAmount;
	}
	@Override
	public String toString() {
		return "Bid [bidid=" + bidid + ", vendorid=" + vendorid + ", tenderid=" + tenderid + ", bidAmount=" + bidAmount
				+ "]";
	}

	
	public Bid() {
		// TODO Auto-generated constructor stub
	}
}
