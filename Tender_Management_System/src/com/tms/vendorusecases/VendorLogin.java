package com.tms.vendorusecases;

import java.util.Scanner;

import com.tms.dao.AdministratorDao;
import com.tms.dao.AdministratorDaoImlp;
import com.tms.dao.VendorDao;
import com.tms.dao.VendorDaoImpl;
import com.tms.exceptions.TenderManagementSystemException;

public class VendorLogin {
	
	public static void main(String[] args) {
		
		try (Scanner sc = new Scanner(System.in)) {
			
			System.out.println("Enter 1 To Login As vendor");
			
			int num = sc.nextInt();		
			
			if(num ==1) {
				
			System.out.println("Enter vendor email");
			String email = sc.next();
			
			System.out.println("Enter vendor password");
			String password = sc.next();
			
			VendorDao dao = new VendorDaoImpl();
			
			try {
				String message = dao.vendorLogin(email, password);
				System.out.println(message);
			} catch (TenderManagementSystemException e) {
				e.printStackTrace();
			}
			}else {
				System.out.println("Invalid Number");
			}
		}catch(Exception e){
			System.out.println("Invalid Number");
		}
			
		
				
	}
	
}


