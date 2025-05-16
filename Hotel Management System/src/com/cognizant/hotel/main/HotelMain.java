package com.cognizant.hotel.main;




import java.sql.Date;

import java.util.Scanner;

import com.cognizan.hotel.services.CustomerServiceImpl;
import com.cognizan.hotel.services.EmployeeServiceImpl;
import com.cognizant.hotel.beans.Bookings;
import com.cognizant.hotel.beans.Customers;
import com.cognizant.hotel.beans.Rooms;
import com.cognizant.hotel.exception.UserException;
import com.cognizant.hotel.util.GenerateXML;
import com.cognizant.hotel.util.ReadXML;
import com.cognizant.hotel.util.ValidationsUtil;
import com.cognizant.hotel.util.XMLValidations;


public class HotelMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		Customers c = new Customers();
		Rooms r = new Rooms();
		Bookings b = new Bookings();

		while(true) {
		System.out.println("Enter 1 for Employee \n Enter 2 for Customer \n Enter 3 to exit");
		int option = sc.nextInt();

		switch(option) {

		case 1 : System.out.println("Welcome Employee");
		         EmployeeServiceImpl esImpl = new EmployeeServiceImpl();
		         boolean employee =true;
		         while(employee) {
		        	 System.out.println("Enter 1 to add a room "
		        			 + "\nEnter 2 to update the room "
		        			 + "\nEnter 3 to delete a room "
		        			 + "\n Enter 4 to show all rooms "
		        			 + "\nEnter 5 to show all customers "
		        			 + "\nEnter 6 to show all bookings "
		        			 + "\nEnter 7 for room CheckOut"
		        			 + "\nEnter 8 for XML"
		        			 + "\nEnter 9 to login as different user ");
		        	 int eops = sc.nextInt();

		        	 switch(eops) {
		
		        	 	case 1 : 
		        	 			 System.out.println("Enter the room type :");
		        	 			 String type = sc.next();
		        	 			 r.setRoomType(type);
		        	 			 System.out.println("Enter yes or no for TV :");
		        	 			 String tv =sc.next();
		        	 			 r.setTV(tv);
		        	 			 System.out.println("Enter yes or no for Wifi :");
		        	 			 String wf = sc.next();
		        	 			 r.setWIFI(wf);
		        	 			 System.out.println("Enter the Room Price :");
		        	 			 double price = sc.nextDouble();
		        	 			 r.setRoomPrice(price);
		        	 			 System.out.println("Special features room had :");
		        	 			 sc.nextLine();
		        	 			 String feature = sc.nextLine();
		        	 			 r.setSpecialFeatures(feature);
		        	 			 System.out.println(esImpl.addRooms(r));
		        	 			 break;
		         
		        	 	case 2 : 
		        	 			 System.out.println("Enter the room id :");
		        	 			 long id = sc.nextLong();
		        	 			 r.setRoomId(id);
		        	 			 System.out.println("Enter the room type to change");
		        	 			 String sf = sc.next();
		        	 			 r.setRoomType(sf);
		        	 			 System.out.println("Enter yes or no for TV :");
		        	 			 String t = sc.next();
		        	 			 r.setTV(t);
		        	 			 System.out.println("Enter yes or no for WIFI :");
		        	 			 String w = sc.next();
		        	 			 r.setWIFI(w);
		        	 			 System.out.println("Enter the Room Price :");
		        	 			 double cost = sc.nextDouble();
		        	 			 r.setRoomPrice(cost);
		        	 			 System.out.println(esImpl.updateRoom(r));
		        	 			 break;
		         
		        	 	case 3 : 
		        	 			 System.out.println("Enter the room id :");     
		        	 			 long rid = sc.nextLong();
		        	 			 r.setRoomId(rid);
		        	 			 System.out.println(esImpl.deleteRoom(r));
		        	 			 break;
		         
		         
		        	 	case 4 : System.out.println("Showing all the rooms");
		        	 			 System.out.println(esImpl.showAllRooms());
		        	 			 break;

		        	 	case 5 : System.out.println("Showing all the customers");
		        	 			 System.out.println(esImpl.showAllCustomers());
		        	 			 break;
		        	 			 
		        	 	case 6 : System.out.println("Showing all the bookings");
		        	 			 System.out.println(esImpl.showAllBookings());
		        	 			 break;
		 
		        	 	case 7 : 
		        	 		     System.out.println("Enter the room id");	
		        	 			 long ri = sc.nextLong();
		        	 			 b.setRoom_id(ri);
		        	 			 System.out.println("Enter the empId");
		        	 			 long eid = sc.nextLong();
		        	 			 b.setEmp_id(eid);
		                         System.out.println("Enter checkout date");
		                         String dt = sc.next();
					             Date dte = Date.valueOf(dt);
					             b.setCheckOutDate(dte);
					             esImpl.updateRoomStatus(b);
		                         break;
		
		        	 	case 9 : employee = false;
		        	 			 break;
		        	 	
		        	 	case 8 : System.out.println("XML");
		        	 	         boolean x = true;
		        	 	         while(x) {
		        	 	        	System.out.println("Enter 1 for Customers XML \nEnter 2 for Rooms XML \nENter 3 for Bookings XML \nEnter 4 to go back to previous menu"); 
		        	 	            int m = sc.nextInt();
		        	 	            switch(m) {
		        	 	            case 1 :
		        	 	            	    while(true) {
		        	 	            		System.out.println("Enter 1 to generate XML for customers "
		        	 	        	 		+ "\nEnter 2 to read XML of customers \nEnter 3 to previous menu");
		        	 	            		int mc = sc.nextInt();
		        	 	            		switch(mc) {
		        	 	            		case 1 : GenerateXML.XMLCustomers(esImpl.showAllCustomers());
		        	 	            			     System.out.println(XMLValidations.CustomerValidation());
		        	 	        	          	     break;
		        	 	            		case 2 : ReadXML.customerxml();
		        	 	        	          		break;
		        	 	            		case 3 : 
		        	 	            				break;
		        	 	            			} break;} break;
		        	 	            case 2 : 
		        	 	            	      while(true) {
	        	 	            		      System.out.println("Enter 1 to generate XML for Rooms "
	        	 	        	 		      + "\nEnter 2 to read XML of Rooms \nEnter 3 to previous menu");
	        	 	            		      int mc = sc.nextInt();
	        	 	            		      switch(mc) {
	        	 	            		      case 1 :  GenerateXML.XMLRooms(esImpl.showAllRooms());
	        	 	            		      			System.out.println(XMLValidations.RoomsValidation());
	        	 	        	          				break;
	        	 	            		      case 2 : ReadXML.roomXml();
	        	 	        	          			break;
	        	 	            		      case 3 : 
	        	 	            		    	       break;
	        	 	            		      } break; } break;
		        	 	            case 3 : 
		        	 	            	      while(true) {
	        	 	            				System.out.println("Enter 1 to generate XML for Bookings "
	        	 	            						+ "\nEnter 2 to read XML of Bookings \nEnter 3 to previous menu");
	        	 	            				int mc = sc.nextInt();
	        	 	            				switch(mc) {
	        	 	            				case 1 : GenerateXML.XMLBookings(esImpl.showAllBookings());
	        	 	            						 System.out.println(XMLValidations.BookingsValidation());
	        	 	            				         break;
	        	 	            				case 2 : ReadXML.bookingXml();
	        	 	        	          				break;
	        	 	            				case 3 :
	        	 	            						break;
	        	 	            					} break;} break;
		        	 	            case 4 : x = false;
		        	 	            	     break;
	        	 	            			} break; }break;
		        	 }}

		case 2 : System.out.println("Welcome Customer");
		         CustomerServiceImpl csImpl = new CustomerServiceImpl();
	             boolean Customer =true;
	             while(Customer) {
	             System.out.println("Enter 1 to register an account \nEnter 2 to login into account \nEnter 3 to login as different role");
	             int cops = sc.nextInt();
	             switch(cops) {
	             	case 1 : 
	             	         System.out.println("Enter the employee id of your organisation");
	             	         long eid = sc.nextLong();
	             	         c.setEmpId(eid);
	             	         System.out.println("Enter your organisation name");
	             	         sc.nextLine();
	             	         String oname = sc.nextLine();
	             	         c.setCompanyName(oname);
	             			while(true) {
	             				System.out.println("Enter your name");
	             				String name = sc.next();
	             				try {
	             					if(ValidationsUtil.nameValidation(name))
	             						c.setName(name);
	             					     break;
	             							} catch (UserException e) {
	             									// TODO Auto-generated catch block
	             									e.printStackTrace();
	             								}
	             						}
	             			while(true) {
	             			System.out.println("Enter your email id");
	             			String emailId = sc.next();
	             				try {
	             					if(ValidationsUtil.emailValidation(emailId))
	             						c.setEmail(emailId);
	             					    break;
	             				} catch (UserException e) {
	             					// TODO Auto-generated catch block
	             					e.printStackTrace();
	             				}
	             				}
	             			System.out.println("Enter your mobile number");
	             				long phoneNum = sc.nextLong();
	             				c.setMblNum(phoneNum);
	             				System.out.println("Enter passward");
	             				String passward = sc.next();
	             				c.setPassward(passward);
	             				csImpl.registerAccount(c);
	             				break;

	             	case 2 : System.out.println("Welcome User");
	             			 while(true) {
	             				    
	             					System.out.println("Enter EmailId");
	             						String email = sc.next();
	             						c.setEmail(email);
	             						System.out.println("enter passward");
	             						String pass = sc.next();
	             						c.setPassward(pass);
	             						int lci = csImpl.logIn(c);
	             						if(lci==1) {
	             							System.out.println("Login Succeful");
	             							   boolean cusops = true;
	             								while(cusops) {
	             									System.out.println("Enter 1 to book a room \nEnter 2 to update details \nEnter 3 to logout");
	             									int custOps = sc.nextInt();
	             									switch(custOps) {
	             									
	             									        case 1 :           									        	    
	             									                 while(true) {
	             									                 System.out.println("Enter the CheckIn date ");
	             									                 String dt = sc.next();
														             Date dte = Date.valueOf(dt);
														             try {
																		if(ValidationsUtil.DateComparison(dte)) {
																		 b.setCheckInDate(dte);
																		 break;
																		 }
																	} catch (UserException e) {
																		// TODO Auto-generated catch block
																		e.printStackTrace();
																	}
														            
														             }
	             									                 while(true) {
														             System.out.println("Enter the CheckOut date");
														             String dt1 = sc.next();
														             Date dte1 = Date.valueOf(dt1);
														             try {
																		if(ValidationsUtil.DateComparison(dte1)) {
																			 b.setCheckOutDate(dte1);
																			 break;
																		 }
																	} catch (UserException e) {
																		// TODO Auto-generated catch block
																		e.printStackTrace();
																	}
														             }
	             									                 
	             									                System.out.println(csImpl.searchRoom(b));
	             									                
	             									                System.out.println("Enter the room number you want to book");
	             									                 int brid = sc.nextInt();
	             									                 r.setRoomId(brid);
	             									                 b.setRoom_id(brid);
	             									                 double rp = csImpl.fetchPrice(b);
	             									                 b.setPrice(rp);
	             									                 java.util.Date  endDate = new java.util.Date(b.getCheckOutDate().getTime());
														             java.util.Date  startDate = new java.util.Date(b.getCheckInDate().getTime());
														             long diff = endDate.getTime() - startDate.getTime();
														             long dateDiff = (diff/(1000 * 60 * 60 * 24)) % 365;
														             double price = dateDiff*b.getPrice();
														             b.setTotalCost(price);
														             System.out.println("Enter your employee id to confirm booking");
														             long epid = sc.nextLong();
														             b.setEmp_id(epid);
														             csImpl.bookAroom(b);
														             break;
	             									        
	             									        
	             											case 2 :   
	             												      while(true) {
	             					             									System.out.println("Enter your name");
	             					             									String name = sc.next();
	             					             									try {
	             					             										if(ValidationsUtil.nameValidation(name))
	             					             											c.setName(name);
	             					             										break;
	             					             									} catch (UserException e) {
	             					             										// TODO Auto-generated catch block
	             					             											e.printStackTrace();
	             					             									}
	             					             									
	             					             										}
	             					             								while(true) {
	             					             										System.out.println("Enter your email id");
	             					             										String emailId = sc.next();
	             					             											try {
	             					             													if(ValidationsUtil.emailValidation(emailId))
	             					             														c.setEmail(emailId);
	             					             													     break;
	             					             											} catch (UserException e) {
	             					             												// TODO Auto-generated catch block
	             					             												e.printStackTrace();
	             					             											}
	             					             											
	             					             										}
	             					             									System.out.println("Enter your mobile number");
	             					             									long phoneNum1 = sc.nextLong();
	             					             									c.setMblNum(phoneNum1);
	             					             									System.out.println("Enter passward");
	             					             									String passward1 = sc.next();
	             					             									c.setPassward(passward1);
	             					             									System.out.println("Enter your employee id");
	             					             									long empid = sc.nextLong();
	             					             									c.setEmpId(empid);
	             					             									csImpl.updateProfile(c);
	             					             									break;
	             											         
	             											         
	             											   case 3 : cusops = false;
	             												        break;
	             														}}
	             								                    }
	             												else {
	             														System.out.println("Invalid Details");
	             													}
	             									              break;}
	             			                                     break;


	             										 case 3 : Customer = false;
	             													break;
	             												}} break;

		case 3 : System.exit(1);
		break;

		}}}}
