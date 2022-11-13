package com.tms.vendorusecases;

import java.util.Scanner;

import com.tms.dao.AdministratorDao;
import com.tms.dao.AdministratorDaoImlp;
import com.tms.dao.VendorDao;
import com.tms.dao.VendorDaoImpl;
import com.tms.exceptions.TenderManagementSystemException;
import com.tms.model.Bid;

public class RegisterBid {
	
	
	public static void main(String[] args) {
		
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter the following details to Register a bid");
			System.out.println("----------------------------------------------");
			
			System.out.println("Enter bid id");
			int bidid = sc.nextInt();
			
			System.out.println("Enter vendor id");
			int vendorid = sc.nextInt();
			
			System.out.println("Enter tender id");
			int tenderid  = sc.nextInt();
			
			System.out.println("Enter Amount  id");
			int bidAmount  = sc.nextInt();
			
			VendorDao dao = new VendorDaoImpl();
			try {
				String message = dao.acceptBids(new Bid(bidid, vendorid, tenderid, bidAmount));
				System.out.println(message);
			} catch (TenderManagementSystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
