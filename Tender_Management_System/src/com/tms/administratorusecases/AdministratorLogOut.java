package com.tms.administratorusecases;

import java.util.Scanner;

import com.tms.dao.AdministratorDao;
import com.tms.dao.AdministratorDaoImlp;
import com.tms.exceptions.TenderManagementSystemException;

public class AdministratorLogOut {
	
	public static void main(String[] args) {
		
	try (Scanner sc = new Scanner(System.in)) {
		System.out.println("Enter 2 To Logout As Administrator.");
		
		int num = sc.nextInt();		
		
		if(num ==2) {
			AdministratorDao dao =  new AdministratorDaoImlp();
			try {
				String message = dao.administratorLogOut();
				System.out.println(message);
				} catch (TenderManagementSystemException e) {
		e.printStackTrace();
		}
			
		}else {
			System.out.println("Invalid Number. Enter 1 to LogOut.");
		}
	}catch(Exception e) {
		System.out.println("Invalid data");
	}
		
	}

}
