package com.tms.administratorusecases;

import java.util.List;
import java.util.Scanner;

import com.tms.dao.AdministratorDao;
import com.tms.dao.AdministratorDaoImlp;
import com.tms.exceptions.TenderManagementSystemException;
import com.tms.model.Vendor;

public class ViewAllVendors {
	
	public static void main(String[] args) {
		
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter 5 to view all Vendors");
			System.out.println("------------------------------------------------");
			int num = sc.nextInt();
			if(num == 5) {
				AdministratorDao dao = new AdministratorDaoImlp();
				
				try {
					List<Vendor> list = dao.viewAllVendors();
					list.forEach(i -> System.out.println(i));
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
