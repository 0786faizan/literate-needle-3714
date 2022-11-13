package com.tms.administratorusecases;

import java.util.Scanner;

import com.tms.dao.AdministratorDao;
import com.tms.dao.AdministratorDaoImlp;
import com.tms.exceptions.TenderManagementSystemException;

public class AdministratorLogin {
	
	public static void main(String[] args) {
		
		try (Scanner sc = new Scanner(System.in)) {
			
			System.out.println("Enter 1 To Login As Administrator");
			
			int num = sc.nextInt();		
			
			if(num ==1) {
				System.out.println("Enter administrator email");
				String email = sc.next();
				
				System.out.println("Enter administrator password");
				String password = sc.next();
			
			
			AdministratorDao dao = new AdministratorDaoImlp();
			
			try {
				
				String message = dao.administratorLogin(email, password);
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
