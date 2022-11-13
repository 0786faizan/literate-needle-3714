package com.tms.administratorusecases;

import java.util.Scanner;

import com.tms.dao.AdministratorDao;
import com.tms.dao.AdministratorDaoImlp;
import com.tms.exceptions.TenderManagementSystemException;
import com.tms.model.Bid;

public class RegisterBid {
	
	
	public static void main(String[] args) {
		
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter the following details to register a Bid");
			System.out.println("------------------------------------------------");
			
			System.out.println("Enter bid id");
			int bidid = sc.nextInt();
			
			System.out.println("Enter vendor id");
			int vendorid = sc.nextInt();
			
			System.out.println("Enter tender id");
			int tenderid  = sc.nextInt();
			
			System.out.println("Enter Amount  id");
			int bidAmount  = sc.nextInt();
			
			AdministratorDao dao = new AdministratorDaoImlp();
			try {
				String message = dao.acceptBids(new Bid(bidid, vendorid, tenderid, bidAmount));
				System.out.println(message);
			} catch (TenderManagementSystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}catch (Exception e) {
			System.out.println("Plese enter the correct details");
		}
	}

}
