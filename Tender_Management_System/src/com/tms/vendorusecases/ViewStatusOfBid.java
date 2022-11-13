package com.tms.vendorusecases;

import java.util.Scanner;

import com.tms.dao.AdministratorDao;
import com.tms.dao.AdministratorDaoImlp;
import com.tms.dao.VendorDao;
import com.tms.dao.VendorDaoImpl;
import com.tms.exceptions.TenderManagementSystemException;

public class ViewStatusOfBid {
	
	public static void main(String[] args) {
		
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter 5 to view status of Tender");
			System.out.println("------------------------------------------------");
			int num = sc.nextInt();
			if(num == 5) {
				
		System.out.println("Enter vendor id");
		int vid = sc.nextInt();
		
		VendorDao dao = new VendorDaoImpl();
		try {
			String message = dao.checkStatusOfBid(vid);
			System.out.println(message);
		} catch (TenderManagementSystemException e) {
			e.printStackTrace();
		}
			}else {
				System.out.println("Please enter the correct number");
			}
		}catch (Exception e) {
			System.out.println("Please enter the correct number");
		}
		
	}

}
