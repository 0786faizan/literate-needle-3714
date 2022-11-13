package com.tms.dao;

import java.util.List;

import com.tms.exceptions.TenderManagementSystemException;
import com.tms.model.Bid;
import com.tms.model.Tender;
import com.tms.model.Vendor;

public interface AdministratorDao {

	public String administratorLogin(String email,String pasword) throws TenderManagementSystemException;
	
	public String RegisterNewVendor(Vendor vendor) throws TenderManagementSystemException;

	public List<Vendor> viewAllVendors() throws TenderManagementSystemException;

	public String createNewTender(Tender tender) throws TenderManagementSystemException;
	
	public List<Tender> viewAllTenders() throws TenderManagementSystemException;

	public  String acceptBids(Bid bid) throws TenderManagementSystemException;

	public List<Bid> viewAllBids() throws TenderManagementSystemException;
	
	public String assignATenderToAVendor() throws TenderManagementSystemException;
	
	public String administratorLogOut() throws TenderManagementSystemException;

	
	
	
	
	
}
