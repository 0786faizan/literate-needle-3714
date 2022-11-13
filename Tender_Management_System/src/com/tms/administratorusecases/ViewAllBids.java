package com.tms.administratorusecases;

import java.util.List;
import java.util.Scanner;

import com.tms.dao.AdministratorDao;
import com.tms.dao.AdministratorDaoImlp;
import com.tms.exceptions.TenderManagementSystemException;
import com.tms.model.Bid;
import com.tms.model.Vendor;

public class ViewAllBids {
	
	public static void main(String[] args) {
		
		
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter 3 to view all Bids");
			System.out.println("------------------------------------------------");
			int num = sc.nextInt();
			if(num == 3) {
				AdministratorDao dao = new AdministratorDaoImlp();
				
				try {
					List<Bid> list = dao.viewAllBids();
					list.forEach(i -> System.out.println(i));
				} catch (TenderManagementSystemException e) {
					e.printStackTrace();
				}
			}
			
			
			else {
				System.out.println("Please enter the correct number");
			}
		}catch (Exception e) {
			System.out.println("Please enter the correct number");
		}
		
		
		
		
	}

}
