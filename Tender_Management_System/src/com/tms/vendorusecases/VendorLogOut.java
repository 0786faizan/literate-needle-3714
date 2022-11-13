package com.tms.vendorusecases;

import java.util.Scanner;

import com.tms.dao.VendorDao;
import com.tms.dao.VendorDaoImpl;
import com.tms.exceptions.TenderManagementSystemException;

public class VendorLogOut {
	
	public static void main(String[] args) {
		
		

		try (Scanner sc = new Scanner(System.in)) {
			
			System.out.println(
					"Enter 2 To LogOut As vendor");
			
			int num = sc.nextInt();		
			
			if(num ==2) {
				
		VendorDao dao = new VendorDaoImpl();
		
		try {
			String message = dao.vendorLogOut();
			System.out.println(message);
		} catch (TenderManagementSystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
			}else {
				System.out.println("Invalid Number");
			}
		}catch (Exception e) {
			System.out.println("Invalid Number");
		}
	}
}
	
