package com.tms.administratorusecases;

import java.util.Scanner;

import com.tms.dao.AdministratorDao;
import com.tms.dao.AdministratorDaoImlp;
import com.tms.exceptions.TenderManagementSystemException;
import com.tms.model.Tender;

public class CreateNewTender {
	
	
	public static void main(String[] args) {
		
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter the following details to create new tender");
			System.out.println("------------------------------------------------");
			
			System.out.println("Enter tendor id");
			int tendid = sc.nextInt();	
			
			
			System.out.println("Enter tendor name");
			String Venname = sc.next();

			System.out.println("Enter tendor amount");
			int bidamount = sc.nextInt();
			
			Tender tender = new Tender(tendid, Venname, bidamount);
			
			AdministratorDao dao = new AdministratorDaoImlp();
			
			try {
				String message = dao.createNewTender(tender);
				System.out.println(message);
			} catch (TenderManagementSystemException e) {
				e.printStackTrace();
			}
		}catch (Exception e) {
			System.out.println("Please enter the correct details.");
		}
		
		
		
		
		
		
		
		
		
	}

}
