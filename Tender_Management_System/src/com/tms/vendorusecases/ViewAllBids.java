package com.tms.vendorusecases;

import java.util.List;
import java.util.Scanner;

import com.tms.dao.VendorDao;
import com.tms.dao.VendorDaoImpl;
import com.tms.exceptions.TenderManagementSystemException;
import com.tms.model.Bid;


public class ViewAllBids {
	
	public static void main(String[] args) {
		
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter 3 to view all Bids");
			System.out.println("------------------------------------------------");
			int num = sc.nextInt();
			if(num == 3) {
				
			
		VendorDao dao = new VendorDaoImpl();
		
		try {
			List<Bid> list = dao.viewAllBids();
			list.forEach(i -> System.out.println(list));
		} catch (TenderManagementSystemException e) {
			// TODO Auto-generated catch block
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
