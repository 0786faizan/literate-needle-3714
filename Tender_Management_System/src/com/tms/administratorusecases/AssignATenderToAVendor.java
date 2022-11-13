package com.tms.administratorusecases;

import java.util.Scanner;

import com.tms.dao.AdministratorDao;
import com.tms.dao.AdministratorDaoImlp;
import com.tms.exceptions.TenderManagementSystemException;

public class AssignATenderToAVendor {
	
	public static void main(String[] args) {
		

		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter 5 to Assign a tender to vendor");
			System.out.println("------------------------------------------------");
			int num = sc.nextInt();
			if(num == 5) {
				
		AdministratorDao dao = new AdministratorDaoImlp();
		try {
			
			String message = dao.assignATenderToAVendor();
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


