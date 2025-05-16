package com.cognizant.hotel.util;

import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class ReadXML {
	public static final String xmlFilePath = "C:\\Users\\2080403\\Xml\\Customers.xml";
	public static final String xmlFilePath1 = "C:\\Users\\2080403\\Xml\\Rooms.xml";
	public static final String xmlFilePath2 = "C:\\Users\\2080403\\Xml\\Bookings.xml";
    
   public static void customerxml() {
	
		   
      try {
         File inputFile = new File(xmlFilePath);
         DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
         DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
         Document doc = dBuilder.parse(inputFile);
         doc.getDocumentElement().normalize();
         System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
         NodeList nList = doc.getElementsByTagName("Customer");
         System.out.println("----------------------------");

         for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);
            System.out.println("\nCurrent Element :" + nNode.getNodeName());

            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
               Element eElement = (Element) nNode;
               System.out.println("customerid :" 
                  + eElement.getAttribute("empId"));
               System.out.println("company name :"
               		+ eElement.getElementsByTagName("companyName").item(0).getTextContent());
               System.out.println("customer name: " 
                  + eElement
                  .getElementsByTagName("name")
                  .item(0)
                  .getTextContent());
               System.out.println("email : " 
                  + eElement
                  .getElementsByTagName("email")
                  .item(0)
                  .getTextContent());
               System.out.println("phone number: " 
                  + eElement
                  .getElementsByTagName("mblNum")
                  .item(0)
                  .getTextContent());
               System.out.println("passward " 
                  + eElement
                  .getElementsByTagName("passward")
                  .item(0)
                  .getTextContent());
            }
         }
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
   public static void roomXml() {
	   try {
           File inputFile = new File(xmlFilePath1);
           DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
           DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
           Document doc = dBuilder.parse(inputFile);
           doc.getDocumentElement().normalize();
           System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
           NodeList nList = doc.getElementsByTagName("Room");
           System.out.println("----------------------------");

           for (int temp = 0; temp < nList.getLength(); temp++) {
              Node nNode = nList.item(temp);
              System.out.println("\nCurrent Element :" + nNode.getNodeName());

              if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                 Element eElement = (Element) nNode;
                 System.out.println("roomId : " 
                + eElement.getAttribute("roomId"));
                 System.out.println("roomType: " 
                    + eElement
                    .getElementsByTagName("roomType")
                    .item(0)
                    .getTextContent());
                 System.out.println("TV :"
                 		+ eElement.getElementsByTagName("TV").item(0).getTextContent());
                 System.out.println("WIFI :"
                 		+eElement.getElementsByTagName("WIFI").item(0).getTextContent());
                 System.out.println("roomPrice: " 
                    + eElement
                    .getElementsByTagName("roomPrice")
                    .item(0)
                    .getTextContent());
                 System.out.println("specialFeatures: " 
                    + eElement
                    .getElementsByTagName("specialFeatures")
                    .item(0)
                    .getTextContent());
                
              }
           }
        } catch (Exception e) {
           e.printStackTrace();
        }
     }
   
   public static void bookingXml() {
   try {
       File inputFile = new File(xmlFilePath2);
       DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
       DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
       Document doc = dBuilder.parse(inputFile);
       doc.getDocumentElement().normalize();
       System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
       NodeList nList = doc.getElementsByTagName("Booking");
       System.out.println("----------------------------");

       for (int temp = 0; temp < nList.getLength(); temp++) {
          Node nNode = nList.item(temp);
          System.out.println("\nCurrent Element :" + nNode.getNodeName());

          if (nNode.getNodeType() == Node.ELEMENT_NODE) {
        	  
        	  Element eElement = (Element) nNode;
              System.out.println("Booking Id :"
              		   + eElement.getAttribute("bookingId"));
             System.out.println("room id : " 
                + eElement
                .getElementsByTagName("roomId").item(0).getTextContent());
             System.out.println("customer id : " 
                     + eElement
                     .getElementsByTagName("customer_id").item(0).getTextContent());
             System.out.println("customer name :"
             		+ eElement.getElementsByTagName("customer_name").item(0).getTextContent());
             System.out.println("checkInDate: " 
                + eElement
                .getElementsByTagName("checkInDate")
                .item(0)
                .getTextContent());
             System.out.println("checkOutDate :" 
                + eElement
                .getElementsByTagName("checkOutDate")
                .item(0)
                .getTextContent());
             System.out.println("totalCost :"
             		+ eElement.getElementsByTagName("totalCost").item(0).getTextContent());
          }
          }
    } catch (Exception e) {
       e.printStackTrace();
    }
 }
   
   
}