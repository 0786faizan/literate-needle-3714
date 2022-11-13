package com.tms.administratorusecases;

import java.util.Scanner;

import com.tms.dao.AdministratorDao;
import com.tms.dao.AdministratorDaoImlp;
import com.tms.exceptions.TenderManagementSystemException;
import com.tms.model.Vendor;

public class RegisterNewVendor {
	
	public static void main(String[] args) {
		
		
		try (Scanner sc = new Scanner(System.in)) {
			
			System.out.println("Enter the following details to register new vendor");
			System.out.println("------------------------------------------------");
			
			System.out.println("Enter Vendor id");
			int venid = sc.nextInt();
			
			System.out.println("Enter Vendor name");
			String Venname = sc.next();
			
			System.out.println("Enter Vendor mobile");
			String mobile = sc.next();
			
			System.out.println("Enter Vendor email");
			String venemail = sc.next();
			
			System.out.println("Enter Vendor company name");
			String vencompany = sc.next();
			
			System.out.println("Enter Vendor password");
			String venpassword = sc.next();
			
			Vendor vendor = new Vendor(venid, Venname, mobile, venemail, vencompany, venpassword);
			
			AdministratorDao dao = new AdministratorDaoImlp();
			
			try {
				String message = dao.RegisterNewVendor(vendor);
				System.out.println(message);
			} catch (TenderManagementSystemException e) {
				e.printStackTrace();
			}
		}catch (Exception e) {
			System.out.println("please enter the correct details");
		}	
	}

}
