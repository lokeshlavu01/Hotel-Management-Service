package com.cognizant.hotel.util;


import java.io.File;
import java.io.IOException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;

public class XMLValidations {



public static boolean CustomerValidation() {
            SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            try {
            	Schema schema = schemaFactory.newSchema(new File("C:\\Users\\2080403\\Xml\\Customers.xsd"));

            	Validator validator = schema.newValidator();
            	validator.validate(new StreamSource(new File("C:\\Users\\2080403\\Xml\\Customers.xml")));
            	return true;
            } catch (SAXException | IOException e) {
            	e.printStackTrace();
            	return false;
            }}


public static boolean RoomsValidation() {
       SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
       try {
       	Schema schema = schemaFactory.newSchema(new File("C:\\Users\\2080403\\Xml\\Rooms.xsd"));

       	Validator validator = schema.newValidator();
       	validator.validate(new StreamSource(new File("C:\\Users\\2080403\\Xml\\Rooms.xml")));
       	return true;
       } catch (SAXException | IOException e) {
       	e.printStackTrace();
       	return false;
       }}

   
public static boolean BookingsValidation() {
       SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
       try {
       	Schema schema = schemaFactory.newSchema(new File("C:\\Users\\2080403\\Xml\\Bookings.xsd"));

       	Validator validator = schema.newValidator();
       	validator.validate(new StreamSource(new File("C:\\Users\\2080403\\Xml\\Bookings.xml")));
       	return true;
       } catch (SAXException | IOException e) {
       	e.printStackTrace();
       	return false;
       }}
}