package com.tms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tms.dbconnection.GetConnection;
import com.tms.exceptions.TenderManagementSystemException;
import com.tms.model.Bid;
import com.tms.model.Tender;

public class VendorDaoImpl implements VendorDao{

	@Override
	public String vendorLogin(String email, String password) throws TenderManagementSystemException {
		
			String message = "We cannot find your account please contact your admin";
				
			int count= 0;

			try(Connection conn = GetConnection.provideConnection()) {
				
				PreparedStatement ps1 = conn.prepareStatement("select * from vendor");
				
				ResultSet rs1 = ps1.executeQuery();
			
						
		while(rs1.next()) {
				
		if(rs1.getString("venemail").equals(email) && rs1.getString("venpassword").equals(password))  {
		message = "Vendor login successful";
			count++;
			
			PreparedStatement ps3 = conn.prepareStatement("truncate table vendorCredentials");
			int x3 = ps3.executeUpdate();

			PreparedStatement ps2 = conn.prepareStatement("insert into vendorCredentials values(?,?,?,?)");
			ps2.setString(1, rs1.getString("venid"));
			ps2.setString(2,rs1.getString("venemail"));
			ps2.setString(3,rs1.getString("venpassword"));
			ps2.setString(4, "Success");
			
			ps2.executeUpdate();
			
		}
		
		}
		
		return message;
		
				} catch (SQLException e) {
					e.printStackTrace();
				}
			
			if(count == 0){
				throw new TenderManagementSystemException("Please Login As Administrator Before Proceed");
			}
			
				return message;
		
	}
	
//	--------------------------------------------------------------------

	@Override
	public List<Tender> viewAllTenders() throws TenderManagementSystemException {
		
			List<Tender> list = new ArrayList<>();
			
			try(Connection conn = GetConnection.provideConnection()) {
				
				PreparedStatement ps1 = conn.prepareStatement("select * from vendorCredentials ");
				
				ResultSet rs1 = ps1.executeQuery();
						
		if(rs1.next()) {
				
		if("Success".equals(rs1.getString("result")))  {
			
				PreparedStatement ps = conn.prepareStatement("select * from tender");
				
				ResultSet rs = ps.executeQuery();
				
				while(rs.next()) {
				list.add(new Tender(rs.getInt("tendid"), rs.getString("tendname"), rs.getInt("bidamount")));
				}

				
				if(list.size()==0)
					throw new TenderManagementSystemException("No tender found");

			return list;
		}
				}
		else {
			throw new TenderManagementSystemException("Please Login As Vendor Before Proceed");
		}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return list;
	}
	
//	---------------------------------------------------------------------.
	

	@Override
	public String acceptBids(Bid bid) throws TenderManagementSystemException {

		String message = "Bid not accepted";
		
		try(Connection conn = GetConnection.provideConnection()) {
			
			PreparedStatement ps1 = conn.prepareStatement("select * from vendorCredentials ");
			
			ResultSet rs1 = ps1.executeQuery();
					
			if(rs1.next()) {
			
				if("Success".equals(rs1.getString("result")))  {
			
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
			}else{
				throw new TenderManagementSystemException("Please Login As Vendor Before Proceed");
			}
						
			} catch (SQLException e) {
				e.printStackTrace();
		  }
						
		return message;
	}

//	-------------------------------------------------
	
	@Override
	public String checkStatusOfBid(int vendorid) throws TenderManagementSystemException {

	String message = "Tender not Selected";
		
			try(Connection conn = GetConnection.provideConnection()) {
				
				PreparedStatement ps1 = conn.prepareStatement("select * from vendorCredentials ");
				
				ResultSet rs1 = ps1.executeQuery();
						
		if(rs1.next()) {
				
		if("Success".equals(rs1.getString("result")))  {
			
			PreparedStatement ps = conn.prepareStatement("select vendorid from bid where bidamount = (select min(bidamount) from bid)");
		
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				
				int venid = rs.getInt("vendorid");
				
				PreparedStatement ps2 = conn.prepareStatement("select * from vendor where venid = ?");
				ps2.setInt(1, venid);
				
		
				ResultSet rs2 = ps2.executeQuery();
				
				if(rs2.next())	
				{
					if(rs2.getInt("venid") == vendorid) {
						 message = "Congratulations your is Tender selected";
					}
				}
					else
					throw new TenderManagementSystemException(message);
				
			}else {
				throw new TenderManagementSystemException(message);
			}
			
		return message;
		
	 }
		}else {
			throw new TenderManagementSystemException("Please Login As Vendor Before Proceed");
		}
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return message;
	}

//	---------------------------------------------------------------
	
	@Override
	public List<Bid> viewAllBids() throws TenderManagementSystemException {
	
			List<Bid> list = new ArrayList<>();
			
			try(Connection conn = GetConnection.provideConnection()) {
				
				PreparedStatement ps1 = conn.prepareStatement("select * from vendorCredentials");
				
				ResultSet rs1 = ps1.executeQuery();
						
		if(rs1.next()) {
				
		if("Success".equals(rs1.getString("result"))) {
							
				PreparedStatement ps = conn.prepareStatement("select * from Bid where vendorid = ?" );
				ps.setString(1, rs1.getString("venid"));
				ResultSet rs = ps.executeQuery();
				
				while(rs.next()) {
				list.add(new Bid(rs.getInt("bidid"), rs.getInt("vendorid"), rs.getInt("tenderid"),rs.getInt("bidAmount")));
				}
				
				if(list.size()==0)
					throw new TenderManagementSystemException("No Bid Found");
				
			return list;
			
		}
		}else {
			throw new TenderManagementSystemException("Please Login As Vendor Before Proceed");
		}
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return list;
			
	}

	@Override
	public String vendorLogOut() throws TenderManagementSystemException {
		
		String message = " please login first to LogOut";
		
		try(Connection conn = GetConnection.provideConnection()) {
			
			PreparedStatement ps4 = conn.prepareStatement("select * from vendorCredentials");
			
			ResultSet rs = ps4.executeQuery();
			int count = 0;
			
			if(rs.next()) {
				count++;
			}
			
			if(count!=0) {
				
				PreparedStatement ps3 = conn.prepareStatement("truncate table vendorCredentials");
				int x3 = ps3.executeUpdate();
				message = "Vendor Logout successul";
			}
	
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
			return message;
	}

}
