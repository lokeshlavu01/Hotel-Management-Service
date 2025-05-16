package com.cognizant.hotel.util;

import java.io.File;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.cognizant.hotel.beans.Bookings;
import com.cognizant.hotel.beans.Customers;
import com.cognizant.hotel.beans.Rooms;

public class GenerateXML {
	
	public static final String xmlFilePath = "C:\\Users\\2080403\\Xml\\Customers.xml";
	public static final String xmlFilePath1 = "C:\\Users\\2080403\\Xml\\Rooms.xml";
	public static final String xmlFilePath2 = "C:\\Users\\2080403\\Xml\\Bookings.xml";

	public static void XMLCustomers(List<Customers> customers) {
		
		try {

            DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();

            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();

            Document document = documentBuilder.newDocument();

            // root element
            Element root = document.createElement("Customers");
            document.appendChild(root);
   
            for (Customers cs : customers ) {
				 // employee element
				 Element customer = document.createElement("Customer");

				 root.appendChild(customer);

       
				 // set an attribute to  element
				 Attr empId = document.createAttribute("empId");
				 empId.setValue(String.valueOf(cs.getEmpId()));
				 customer.setAttributeNode(empId);

				 //you can also use staff.setAttribute("id", "1") for this

				 Element companyName = document.createElement("companyName");
				 companyName.appendChild(document.createTextNode(cs.getCompanyName()));
				 customer.appendChild(companyName);

       
				 Element name = document.createElement("name");
				 name.appendChild(document.createTextNode(cs.getName()));
				 customer.appendChild(name);

       
				 Element email = document.createElement("email");
				 email.appendChild(document.createTextNode(cs.getEmail()));
				 customer.appendChild(email);

       
				 Element mblNum = document.createElement("mblNum");
				 mblNum.appendChild(document.createTextNode(String.valueOf(cs.getMblNum())));
				 customer.appendChild(mblNum);

				 Element passward = document.createElement("passward");
				 passward.appendChild(document.createTextNode(cs.getPassward()));
				 customer.appendChild(passward);
				 }
            
            // create the xml file
            //transform the DOM Object to an XML File
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource domSource = new DOMSource(document);
            StreamResult streamResult = new StreamResult(new File(xmlFilePath));

            // If you use
            // StreamResult result = new StreamResult(System.out);
            // the output will be pushed to the standard output ...
            // You can use that for debugging 

            transformer.transform(domSource, streamResult);

            System.out.println("Done creating Customers XML File");

        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (TransformerException tfe) {
            tfe.printStackTrace();
        }
    }
	
	public static void XMLRooms(List<Rooms> rooms) {
		
		try {

            DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();

            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();

            Document document = documentBuilder.newDocument();

            // root element
            Element root = document.createElement("Rooms");
            document.appendChild(root);
   
            for (Rooms rx : rooms ) {
				 // employee element
				 Element room = document.createElement("Room");

				 root.appendChild(room);

       
				 // set an attribute to  element
				 Attr roomId = document.createAttribute("roomId");
				 roomId.setValue(String.valueOf(rx.getRoomId()));
				 room.setAttributeNode(roomId);

				 //you can also use staff.setAttribute("id", "1") for this

				 Element roomType = document.createElement("roomType");
				 roomType.appendChild(document.createTextNode(rx.getRoomType()));
				 room.appendChild(roomType);

       
				 Element tv = document.createElement("TV");
				 tv.appendChild(document.createTextNode(rx.getTV()));
				 room.appendChild(tv);

       
				 Element wifi = document.createElement("WIFI");
				 wifi.appendChild(document.createTextNode(rx.getWIFI()));
				 room.appendChild(wifi);

       
				 Element roomPrice = document.createElement("roomPrice");
				 roomPrice.appendChild(document.createTextNode(String.valueOf(rx.getRoomPrice())));
				 room.appendChild(roomPrice);

				 Element spfeatures = document.createElement("specialFeatures");
				 spfeatures.appendChild(document.createTextNode(rx.getSpecialFeatures()));
				 room.appendChild(spfeatures);
				 }
            
            // create the xml file
            //transform the DOM Object to an XML File
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource domSource = new DOMSource(document);
            StreamResult streamResult = new StreamResult(new File(xmlFilePath1));

            // If you use
            // StreamResult result = new StreamResult(System.out);
            // the output will be pushed to the standard output ...
            // You can use that for debugging 

            transformer.transform(domSource, streamResult);

            System.out.println("Done creating Rooms XML File");

        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (TransformerException tfe) {
            tfe.printStackTrace();
        }
    }
	
public static void XMLBookings(List<Bookings> bookings) {
	
		
		try {

            DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();

            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();

            Document document = documentBuilder.newDocument();

            // root element
            Element root = document.createElement("Bookings");
            document.appendChild(root);
   
           
            
				 
            
            for(Bookings b : bookings) {
            	
            	Element booklist = document.createElement("Booking");
                root.appendChild(booklist);
				
                
                Attr id = document.createAttribute("bookingId");
                id.setValue(String.valueOf(b.getBookingId()));
                booklist.setAttributeNode(id);
                
                 Element roomId = document.createElement("roomId");
				 roomId.appendChild(document.createTextNode(String.valueOf(b.getRoom_id())));
				 booklist.appendChild(roomId);
                 
				 Element customerId = document.createElement("customer_id");
				 customerId.appendChild(document.createTextNode(String.valueOf(b.getEmp_id())));
				 booklist.appendChild(customerId);
                 
				 Element empName = document.createElement("customer_name");
				 empName.appendChild(document.createTextNode(String.valueOf(b.getEmp_name())));
				 booklist.appendChild(empName);

       
				 Element indate = document.createElement("checkInDate");
				 indate.appendChild(document.createTextNode(b.getCheckInDate().toString()));
				 booklist.appendChild(indate);

       
				 Element outdate = document.createElement("checkOutDate");
				 outdate.appendChild(document.createTextNode(b.getCheckOutDate().toString()));
				 booklist.appendChild(outdate);

       
				 Element cost = document.createElement("totalCost");
				 cost.appendChild(document.createTextNode(String.valueOf(b.getTotalCost())));
				 booklist.appendChild(cost);
            	 }
                 
            
            	 
            // create the xml file
            //transform the DOM Object to an XML File
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource domSource = new DOMSource(document);
            StreamResult streamResult = new StreamResult(new File(xmlFilePath2));

            // If you use
            // StreamResult result = new StreamResult(System.out);
            // the output will be pushed to the standard output ...
            // You can use that for debugging 

            transformer.transform(domSource, streamResult);

            System.out.println("Done creating Bookings XML File");

        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (TransformerException tfe) {
            tfe.printStackTrace();
        }
    }
	
	}

