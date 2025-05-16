package com.cognizant.hotel.beans;

import java.sql.Date;

public class Bookings {

	private long bookingId;
	private long emp_id;
	private long room_id;
	private String emp_name;
	private Date checkInDate;
	private Date checkOutDate;
	private double price;
	private double totalCost;
	private String rStatus;
	
	
	public Bookings() {
		super();
	}

	public long getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(long emp_id) {
		this.emp_id = emp_id;
	}

	public long getRoom_id() {
		return room_id;
	}

	public void setRoom_id(long room_id) {
		this.room_id = room_id;
	}

	public Date getCheckInDate() {
		return checkInDate;
	}

	public void setCheckInDate(Date checkInDate) {
		this.checkInDate = checkInDate;
	}

	public Date getCheckOutDate() {
		return checkOutDate;
	}

	public void setCheckOutDate(Date checkOutDate) {
		this.checkOutDate = checkOutDate;
	}

	public double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getEmp_name() {
		return emp_name;
	}

	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}

	public String getrStatus() {
		return rStatus;
	}

	public void setrStatus(String rStatus) {
		this.rStatus = rStatus;
	}

	public long getBookingId() {
		return bookingId;
	}

	public void setBookingId(long bookingId) {
		this.bookingId = bookingId;
	}

	@Override
	public String toString() {
		return "Bookings [bookingId=" + bookingId + ", emp_id=" + emp_id + ", room_id=" + room_id + ", emp_name="
				+ emp_name + ", checkInDate=" + checkInDate + ", checkOutDate=" + checkOutDate + ", totalCost="
				+ totalCost + ", rStatus=" + rStatus + "]";
	}

	

	
	
	


	
	
	
}
