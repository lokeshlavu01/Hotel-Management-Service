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



public class CustomersDAO {

	Connection cn = ConnectionUtil.getConnected();
	
	public String registerAccount(Customers ic) {
		// TODO Auto-generated method stub
		String isql = "insert into customers values(?,?,?,?,?,?)";
		try {
			PreparedStatement ips = cn.prepareStatement(isql);
			ips.setInt(1, (int) ic.getEmpId());
			ips.setString(2, ic.getCompanyName());
			ips.setString(3, ic.getName() );
			ips.setString(4, ic.getEmail());
			ips.setInt(5, (int) ic.getMblNum());
			ips.setString(6, ic.getPassward());
			
			System.out.println(ips.executeUpdate());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Success";
	}

	public String bookAroom(Bookings br) {
		
		String isql = "insert into booking values(?,?,?,?,?,?)";
		try {
			PreparedStatement ips = cn.prepareStatement(isql);
			ips.setInt(1, (int) br.getRoom_id());
			ips.setInt(2, (int) br.getEmp_id());
			ips.setDate(3, br.getCheckInDate());
			ips.setDate(4, br.getCheckOutDate());
			ips.setDouble(5, br.getTotalCost());
			ips.setString(6, "Booked");
			ips.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Success";
	
		
	}
	
	public String updateProfile(Customers uc) {
		// TODO Auto-generated method stub
		
		String usql = "update customers set empName =?, email =?, mblNum =?, passward =? where empId =?";
		try {
			PreparedStatement ups = cn.prepareStatement(usql);
			ups.setString(1, uc.getName());
			ups.setString(2, uc.getEmail());
			ups.setInt(3, (int) uc.getMblNum());
			ups.setString(4, uc.getPassward());
			ups.setInt(5, (int) uc.getEmpId());
			
			System.out.println(ups.executeUpdate());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Success";
	}
	
	public int logIn(Customers lc) {
		
		int l = 0;
		String lsql = "select count(*) from customers where email =? and passward = ?";
		try {
			PreparedStatement lps = cn.prepareStatement(lsql);
			lps.setString(1, lc.getEmail());
			lps.setString(2, lc.getPassward());
			
			ResultSet rs = lps.executeQuery();
			rs.next();
		    l = rs.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;
		
	}
	
	public List<Rooms> searchRoom(Bookings b) {
		List<Rooms> rl = new ArrayList<Rooms>();
		
		 String ssql = "select  rooms.roomId, roomType, TV, WIFI, roomPrice, specialFeatures from rooms where rooms.roomId  not in (select roomId from booking where checkOutDate > ?) ";
        try {
       	 PreparedStatement sp = cn.prepareStatement(ssql);
       	 sp.setDate(1, b.getCheckInDate());
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

	 
	 public double fetchPrice(Bookings br) {
		 
		 double price = 0;
		 String ssql = "select roomPrice from rooms where roomId =? ";
		 try {
        	 PreparedStatement sps = cn.prepareStatement(ssql);
        	 sps.setInt(1, (int) br.getRoom_id());
        	 ResultSet rs = sps.executeQuery();
        	 rs.next();
        	 price = rs.getDouble(1);
        	  
		 } catch (SQLException e1) {
        	 // TODO Auto-generated catch block
        	 e1.printStackTrace();
         	}
		 return price;
	 }
	  
}
