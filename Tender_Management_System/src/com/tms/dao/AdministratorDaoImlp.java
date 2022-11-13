package com.tms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.mysql.cj.protocol.Message;
import com.tms.dbconnection.GetConnection;
import com.tms.exceptions.TenderManagementSystemException;
import com.tms.model.Bid;
import com.tms.model.Tender;
import com.tms.model.Vendor;

public class AdministratorDaoImlp implements AdministratorDao{
	
	
	@Override
	public String administratorLogin(String email, String password)throws TenderManagementSystemException {

		
		String message = "We can not login please check the email or password";
		
		try(Connection conn = GetConnection.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("select * from administrator");
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				if(rs.getString("adminemail").equals(email) && rs.getString("adminpassword").equals(password))
				message = "Login Successful";	
				
				PreparedStatement ps1 = conn.prepareStatement("truncate table AdminLoginCredentials ");
				int x = ps1.executeUpdate();
				

				PreparedStatement ps2 = conn.prepareStatement("insert into AdminLoginCredentials values(?,?)");
				ps2.setString(1, email);
				ps2.setString(2, password);
//				
				int x1 = ps2.executeUpdate();
				
				
			}
			
			if(message.equals("We cannot find your account")){
				throw new TenderManagementSystemException(message);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return message;
	}
	
	
//	-----------------------------------------------------------------

	@Override
	public String RegisterNewVendor(Vendor vendor) throws TenderManagementSystemException {
		
		
		
		try(Connection conn = GetConnection.provideConnection()) {
			
			PreparedStatement ps1 = conn.prepareStatement("select * from AdminLoginCredentials ");
			
			ResultSet rs1 = ps1.executeQuery();
					
	if(rs1.next()) {
			
	if("sudarshan@gmail.com".equals(rs1.getString("email")) && "1234".equals(rs1.getString("password")))  {
		
		String message = "Vendor Not Registered";

				
				PreparedStatement ps = conn.prepareStatement("insert into vendor values(?,?,?,?,?,?)");
				ps.setInt(1, vendor.getVenid());
				ps.setString(2, vendor.getVenname());
				ps.setString(3, vendor.getVenmobile());
				ps.setString(4, vendor.getVenemail());
				ps.setString(5, vendor.getVencompany());
				ps.setString(6, vendor.getVenpassword());

				int x = ps.executeUpdate();
				
				if(x>0) {
					message = "Vendor Registerd Successfully";
				}else {
					throw new TenderManagementSystemException(message);
				}
				
			return message;
		
		
	}
	
			}else {
				throw new TenderManagementSystemException("Please Login As Administrator Before Proceed");
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return "vendor not registered";
		
	}

//-----------------------------------------------------------------------
	
	@Override
	public List<Vendor> viewAllVendors() throws TenderManagementSystemException {
		
		List<Vendor> list = new ArrayList<>();
		
		try(Connection conn = GetConnection.provideConnection()) {
			
			PreparedStatement ps1 = conn.prepareStatement("select * from AdminLoginCredentials ");
			
			ResultSet rs1 = ps1.executeQuery();
					
	if(rs1.next()) {
			
	if("sudarshan@gmail.com".equals(rs1.getString("email")) && "1234".equals(rs1.getString("password")))  {			
				
				PreparedStatement ps = conn.prepareStatement("select * from vendor");
				
				ResultSet rs = ps.executeQuery();
				
				while(rs.next()) {
				list.add(new Vendor(rs.getInt("venid"), rs.getString("Venname"), rs.getString("venmobile"), rs.getString("venemail"), rs.getString("vencompany"), rs.getString("venpassword")));
				}
				
				if(list.size()==0)
					throw new TenderManagementSystemException("No tender registered");
				
				
			
			
			return list;
			
	}
			}else {
				throw new TenderManagementSystemException("Please Login As Administrator Before Proceed");
			}
			
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
			
		}
//
////-----------------------------------------------------------------------------
//
	@Override
	public String createNewTender(Tender tender) throws TenderManagementSystemException {
		

			String message = "Tender Not Registered";
			
			try(Connection conn = GetConnection.provideConnection()) {
				
				PreparedStatement ps1 = conn.prepareStatement("select * from AdminLoginCredentials ");
				
				ResultSet rs1 = ps1.executeQuery();
						
		if(rs1.next()) {
				
		if("sudarshan@gmail.com".equals(rs1.getString("email")) && "1234".equals(rs1.getString("password")))  {

				PreparedStatement ps = conn.prepareStatement("insert into tender values(?,?,?)");
				
				ps.setInt(1, tender.getTendid());
				ps.setString(2, tender.getTendname());
				ps.setInt(3, tender.getBidamount());

				
				int x = ps.executeUpdate();
				
				if(x>0) {
					message = "Tender Registerd Successfully";
				}else {
					throw new TenderManagementSystemException(message);
				}
				
			
			
			return message;
		
		}
		
				}else {
					throw new TenderManagementSystemException("Please Login As Administrator Before Proceed");
				}
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return message;
	}

////	----------------------------------------------------
//
	@Override
	public List<Tender> viewAllTenders() throws TenderManagementSystemException {
		
			List<Tender> list = new ArrayList<>();
			
			
			try(Connection conn = GetConnection.provideConnection()) {
				
				PreparedStatement ps1 = conn.prepareStatement("select * from AdminLoginCredentials ");
				
				ResultSet rs1 = ps1.executeQuery();
						
		if(rs1.next()) {
				
		if("sudarshan@gmail.com".equals(rs1.getString("email")) && "1234".equals(rs1.getString("password")))  {

				PreparedStatement ps = conn.prepareStatement("select * from tender");
				
				ResultSet rs = ps.executeQuery();
				
				while(rs.next()) {
				list.add(new Tender(rs.getInt("tendid"), rs.getString("tendname"), rs.getInt("bidamount")));
				}
				
				if(list.size()==0)
					throw new TenderManagementSystemException("No tender registered");
				
				
			
			
			return list;
			
		}
		
				}else {
					throw new TenderManagementSystemException("Please Login As Administrator Before Proceed");
				}
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return list;
			
		

		
	}
//
////	-----------------------------------------------
//
	@Override
	public String acceptBids(Bid bid) throws TenderManagementSystemException {
			String message = "Bid not accepted";
		
			try(Connection conn = GetConnection.provideConnection()) {
				
				PreparedStatement ps1 = conn.prepareStatement("select * from AdminLoginCredentials ");
				
				ResultSet rs1 = ps1.executeQuery();
						
		if(rs1.next()) {
				
		if("sudarshan@gmail.com".equals(rs1.getString("email")) && "1234".equals(rs1.getString("password")))  {
			
			
				PreparedStatement ps = conn.prepareStatement("insert into bid values(?,?,?,?)");
				
				ps.setInt(1, bid.getBidid());
				ps.setInt(2, bid.getVendorid());
				ps.setInt(3, bid.getTenderid());
				ps.setInt(4, bid.getBidAmount());
				
				int x = ps.executeUpdate();
				
				if(x>0) {
					message = "Bid Accepted Successfully";
				}else {
					throw new TenderManagementSystemException(message);
				}
			
			return message;
		}
				}else {
					throw new TenderManagementSystemException("Please Login As Administrator Before Proceed");
				}
				
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return message;
			
		
		
	}
//
////	-------------------------------------------------------------
//
	@Override
	public List<Bid> viewAllBids() throws TenderManagementSystemException {


			List<Bid> list = new ArrayList<>();
			
			try(Connection conn = GetConnection.provideConnection()) {
				
				PreparedStatement ps1 = conn.prepareStatement("select * from AdminLoginCredentials ");
				
				ResultSet rs1 = ps1.executeQuery();
						
		if(rs1.next()) {
				
		if("sudarshan@gmail.com".equals(rs1.getString("email")) && "1234".equals(rs1.getString("password")))  {
			
				
				PreparedStatement ps = conn.prepareStatement("select * from Bid");
				
				ResultSet rs = ps.executeQuery();
				
				while(rs.next()) {
				list.add(new Bid(rs.getInt("bidid"), rs.getInt("vendorid"), rs.getInt("tenderid"),rs.getInt("bidAmount")));
				}
				
				if(list.size()==0)
					throw new TenderManagementSystemException("No Bid Found");
				
				
			
			return list;
			
		}
		
				}else {
					throw new TenderManagementSystemException("Please Login As Administrator Before Proceed");
				}
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return list;
			
	}

////------------------------------------------------------------------------
	
	@Override
	public String assignATenderToAVendor() throws TenderManagementSystemException {

		String message = "Tender not Assigned";

		try(Connection conn = GetConnection.provideConnection()) {
			
			PreparedStatement ps1 = conn.prepareStatement("select * from AdminLoginCredentials ");
			
			ResultSet rs1 = ps1.executeQuery();
					
	if(rs1.next()) {
			
	if("sudarshan@gmail.com".equals(rs1.getString("email")) && "1234".equals(rs1.getString("password")))  {
		
				PreparedStatement ps = conn.prepareStatement("select vendorid from bid where bidamount = (select min(bidamount) from bid)");
			
				ResultSet rs = ps.executeQuery();
				
				if(rs.next()) {
					
					int venid = rs.getInt("vendorid");
					
					PreparedStatement ps2 = conn.prepareStatement("select * from vendor where venid = ?");
					ps2.setInt(1, venid);
					
			
					ResultSet rs2 = ps2.executeQuery();
					
					if(rs2.next())					
						 message = "Tendor Assigned to " + ": "+ "vendor id =" + rs2.getInt("venid") +", vendor name =" + rs2.getString("Venname")
								+ ", vendor mobile =" + rs2.getString("venmobile") + ", vendor email =" + rs2.getString("venemail") + ", vendor company =" + rs2.getString("vencompany") ;
					else
						throw new TenderManagementSystemException(message);
					
				}else {
					throw new TenderManagementSystemException(message);
				}
			
			return message;
			
	}
	}else {
		throw new TenderManagementSystemException("Please Login As Administrator Before Proceed");
	}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return message;
			
		
	}


	@Override
	public String administratorLogOut() throws TenderManagementSystemException {
		
		String message = "Please login first to LogOut";
		
		try(Connection conn = GetConnection.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("select * from AdminLoginCredentials");
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				if(rs.getString("email").equals("sudarshan@gmail.com") && rs.getString("password").equals("1234"))
				message = "LogOut Successful";	

				PreparedStatement ps1 = conn.prepareStatement("truncate table AdminLoginCredentials ");
				int x = ps1.executeUpdate();				
				
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return message;
		
	}

}
