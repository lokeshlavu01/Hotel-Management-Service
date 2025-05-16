package com.cognizant.hotel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cognizant.hotel.beans.Bookings;
import com.cognizant.hotel.beans.Customers;
import com.cognizant.hotel.beans.Rooms;
import com.cognizant.hotel.util.ConnectionUtil;

public class RoomsDAO {

	Connection cn = ConnectionUtil.getConnected();

	public String addRooms(Rooms r) {
		// TODO Auto-generated method stub
		
		String isql = "insert into rooms values(?,?,?,?,?,?)";
		try {
			PreparedStatement ips = cn.prepareStatement(isql);
			ips.setInt(1, (int) r.getRoomId());
			ips.setString(2, r.getRoomType());
			ips.setString(3, r.getTV() );
			ips.setString(4, r.getWIFI());
			ips.setDouble(5, r.getRoomPrice());
			ips.setString(6, r.getSpecialFeatures());
			
			System.out.println(ips.executeUpdate());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Success";
	}
	
	public String updateRoom(Rooms r) {
		// TODO Auto-generated method stub
		 String usql = " update rooms set roomType=?, TV=?, WiFi=?, roomPrice=? where roomId=?";
         try {
        	 PreparedStatement ups = cn.prepareStatement(usql);
        	 ups.setString(1, r.getRoomType());
        	 ups.setString(2, r.getTV());
        	 ups.setString(3, r.getWIFI());
        	 ups.setDouble(4, r.getRoomPrice());
        	 ups.setLong(5, r.getRoomId());
        	 System.out.println(ups.executeUpdate());
         } catch (SQLException e1) {
        	 // TODO Auto-generated catch block
        	 e1.printStackTrace();
         	}
		return "Success";
	}
	
	public String deleteRoom(Rooms r) {
		// TODO Auto-generated method stub
		String dsql = "delete from rooms where roomId =?";
	     try {
	    	 PreparedStatement dps = cn.prepareStatement(dsql);
	    	 dps.setLong(1, (int) r.getRoomId());
	    	 System.out.println(dps.executeUpdate());
	    	 
	     	} catch (SQLException e) {
	     		// TODO Auto-generated catch block
	     		e.printStackTrace();
	     	}
		return "Success";
	}
	
	public List<Rooms> showAllRooms() {
		// TODO Auto-generated method stub
		
		List<Rooms> rl = new ArrayList<Rooms>();
		
		 String ssql = "select * from rooms";
         try {
        	 PreparedStatement sp = cn.prepareStatement(ssql);
        	 ResultSet rs = sp.executeQuery();
             while (rs.next()) {
            	 Rooms r = new Rooms();
            	 r.setRoomId(rs.getInt(1));
            	 r.setRoomType(rs.getString(2));
            	 r.setTV(rs.getString(3));
            	 r.setWIFI(rs.getString(4));
            	 r.setRoomPrice(rs.getDouble(5));
            	 r.setSpecialFeatures(rs.getString(6));
            	 rl.add(r);
             }
         } catch (SQLException e) {
        	 // TODO Auto-generated catch block
        	 e.printStackTrace();
         	}
		return rl;
	}
	
	public List<Customers> showAllCustomers() {
		// TODO Auto-generated method stub
		
		List<Customers> cl = new ArrayList<Customers>();
		String ssql = "select * from customers";
        try {
       	 PreparedStatement sp = cn.prepareStatement(ssql);
       	 ResultSet rs = sp.executeQuery();
            while (rs.next()) {
           	Customers c = new Customers();
           	c.setEmpId(rs.getInt(1));
           	c.setCompanyName(rs.getString(2));
           	c.setName(rs.getString(3));
           	c.setEmail(rs.getString(4));
           	c.setMblNum(rs.getInt(5));
           	c.setPassward(rs.getString(6));
           	cl.add(c);
            }
        } catch (SQLException e) {
       	 // TODO Auto-generated catch block
       	 e.printStackTrace();
        	}
		return cl;
	}
	
	public List<Bookings> showAllBookings() {
		// TODO Auto-generated method stub
		
		List<Bookings> cbl = new ArrayList<Bookings>();
		String ssql = "select bookingId, roomId, booking.empId, empName, checkInDate, checkOutDate, totalCost, roomStatus from booking inner join customers where booking.empId = customers.empId";
        try {
       	 PreparedStatement sp = cn.prepareStatement(ssql);
       	 ResultSet rs = sp.executeQuery();
            while (rs.next()) {
           	Bookings b = new Bookings();
           	b.setBookingId(rs.getLong(1));
           	b.setRoom_id(rs.getLong(2));
           	b.setEmp_id(rs.getLong(3));
           	b.setEmp_name(rs.getString(4));
           	b.setCheckInDate(rs.getDate(5));
           	b.setCheckOutDate(rs.getDate(6));
           	b.setTotalCost(rs.getDouble(7));
           	b.setrStatus(rs.getString(8));
           	
           	cbl.add(b);
            }
        } catch (SQLException e) {
       	 // TODO Auto-generated catch block
       	 e.printStackTrace();
        	}
		return cbl;
	}
	
	public String updateRoomStatus(Bookings b) {
		String usql = " update booking set roomStatus =? where roomId=? and empId =? and checkOutDate = ?";
         try {
        	 PreparedStatement ups = cn.prepareStatement(usql);
        	 ups.setString(1, "Left");
        	 ups.setInt(2, (int) b.getRoom_id());
        	 ups.setInt(3, (int) b.getEmp_id());
        	 ups.setDate(4, b.getCheckOutDate());
        	 System.out.println(ups.executeUpdate());
         } catch (SQLException e1) {
        	 // TODO Auto-generated catch block
        	 e1.printStackTrace();
         	}
		return "Success";
	}
	
}
