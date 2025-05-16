package com.cognizant.hotel.util;

import java.sql.Date;

import com.cognizant.hotel.exception.UserException;

public class ValidationsUtil {

	public static boolean emailValidation(String emailId) throws UserException {
		// TODO Auto-generated method stub
		String arg0 = "[A-Za-z0-9.]+@[a-z.]+$";
		if(emailId.matches(arg0))
		{
			return true;
		}
		else {
				throw new UserException("enter the email in correct format :");
		}
	}
		public static boolean nameValidation(String name) throws UserException {
		// TODO Auto-generated method stub
		String arg0 = "[A-Za-z]+";
		if(name.matches(arg0)) {
			return true;
		}
		else {
				throw new UserException("Enter the name in Alphabets only :");
			}
			
		}
		
		public static boolean DateComparison(Date dte) throws UserException {
			long now = System.currentTimeMillis();
	        Date sqlDate = new Date(now);
	        if(dte.compareTo(sqlDate)>=0) {
	        	return true;
	        }
	        else {
	        	throw new UserException("Date is not in range.\nEnter the correct date");
	        }
		}
}
