package com.tms.model;

public class Administrator {
	
	private String adminname;
	private String adminaddress;
	private String adminemail;
	private String adminpassword;
	public String getAdminname() {
		return adminname;
	}
	public void setAdminname(String adminname) {
		this.adminname = adminname;
	}
	public String getAdminaddress() {
		return adminaddress;
	}
	public void setAdminaddress(String adminaddress) {
		this.adminaddress = adminaddress;
	}
	public String getAdminemail() {
		return adminemail;
	}
	public void setAdminemail(String adminemail) {
		this.adminemail = adminemail;
	}
	public String getAdminpassword() {
		return adminpassword;
	}
	public void setAdminpassword(String adminpassword) {
		this.adminpassword = adminpassword;
	}
	@Override
	public String toString() {
		return "Administrator [adminname=" + adminname + ", adminaddress=" + adminaddress + ", adminemail=" + adminemail
				+ ", adminpassword=" + adminpassword + "]";
	}
	
	public Administrator(String adminname, String adminaddress, String adminemail, String adminpassword) {
		super();
		this.adminname = adminname;
		this.adminaddress = adminaddress;
		this.adminemail = adminemail;
		this.adminpassword = adminpassword;
	}
	
	public Administrator() {
		// TODO Auto-generated constructor stub
	}
			


}
