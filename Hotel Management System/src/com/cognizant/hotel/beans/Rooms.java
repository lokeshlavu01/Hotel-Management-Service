package com.cognizant.hotel.beans;

public class Rooms {

	private long roomId;
	private String roomType;
	private String TV;
	private String WIFI;
	private double roomPrice;
	private String specialFeatures;
	
	
	public Rooms() {
		super();
	}


	public long getRoomId() {
		return roomId;
	}


	public void setRoomId(long roomId) {
		this.roomId = roomId;
	}


	public String getRoomType() {
		return roomType;
	}


	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}


	public String getTV() {
		return TV;
	}


	public void setTV(String tV) {
		TV = tV;
	}


	public String getWIFI() {
		return WIFI;
	}


	public void setWIFI(String wIFI) {
		WIFI = wIFI;
	}


	public double getRoomPrice() {
		return roomPrice;
	}


	public void setRoomPrice(double roomPrice) {
		this.roomPrice = roomPrice;
	}


	public String getSpecialFeatures() {
		return specialFeatures;
	}


	public void setSpecialFeatures(String specialFeatures) {
		this.specialFeatures = specialFeatures;
	}


	@Override
	public String toString() {
		return "Rooms [roomId=" + roomId + ", roomType=" + roomType + ", TV=" + TV + ", WIFI=" + WIFI + ", roomPrice="
				+ roomPrice + ", specialFeatures=" + specialFeatures + "]"+"\n";
	}

	
	
}
