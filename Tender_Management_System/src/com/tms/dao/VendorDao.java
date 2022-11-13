package com.tms.dao;

import java.util.List;

import com.tms.exceptions.TenderManagementSystemException;
import com.tms.model.Bid;
import com.tms.model.Tender;
import com.tms.model.Vendor;

public interface VendorDao {

	public String vendorLogin(String email,String pasword) throws TenderManagementSystemException;
	
	public List<Tender> viewAllTenders() throws TenderManagementSystemException;

	public  String acceptBids(Bid bid) throws TenderManagementSystemException;

	public String checkStatusOfBid(int vendorid) throws TenderManagementSystemException;

	public List<Bid> viewAllBids() throws TenderManagementSystemException;

	public String vendorLogOut() throws TenderManagementSystemException;

	
	
	
}
