package com.tms.vendorusecases;

import java.util.List;
import java.util.Scanner;

import com.tms.dao.AdministratorDao;
import com.tms.dao.AdministratorDaoImlp;
import com.tms.dao.VendorDao;
import com.tms.dao.VendorDaoImpl;
import com.tms.exceptions.TenderManagementSystemException;
import com.tms.model.Tender;
import com.tms.model.Vendor;

public class ViewAllTenders {
	
	public static void main(String[] args) {
		
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter 4 to view all Tenders");
			System.out.println("------------------------------------------------");
			int num = sc.nextInt();
			if(num == 4) {
		VendorDao dao = new VendorDaoImpl();
		try {
			List<Tender> list = dao.viewAllTenders();
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
