package com.cognizant.hotel.beans;



public class Customers {

	private long empId;
	private String companyName;
	private String name;
	private String email;
	private long mblNum;
	private String passward;
	
	
	public Customers() {
		super();
	}


	public long getEmpId() {
		return empId;
	}


	public void setEmpId(long empId) {
		this.empId = empId;
	}


	public String getCompanyName() {
		return companyName;
	}


	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public long getMblNum() {
		return mblNum;
	}


	public void setMblNum(long mblNum) {
		this.mblNum = mblNum;
	}


	public String getPassward() {
		return passward;
	}


	public void setPassward(String passward) {
		this.passward = passward;
	}


	@Override
	public String toString() {
		return "Customers [empId=" + empId + ", companyName=" + companyName + ", name=" + name + ", email=" + email
				+ ", mblNum=" + mblNum + ", passward=" + passward + "]"+"\n";
	}
	
	


	





	
	
	
}
