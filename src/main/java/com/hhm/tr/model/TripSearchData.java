package com.hhm.tr.model;


public class TripSearchData {

	private String departFrom;
	private String departDate;
	private String returnDate;
	private int totalPassenger;
	private int minPrice;
	private int maxPrice;
	private String thingsTodo;
	private int weatherStatus;
	private int isDrive;
	
	public String getDepartFrom() {
		return departFrom;
	}
	public void setDepartFrom(String departFrom) {
		this.departFrom = departFrom;
	}
	public String getDepartDate() {
		return departDate;
	}
	public void setDepartDate(String departDate) {
		this.departDate = departDate;
	}
	public int getTotalPassenger() {
		return totalPassenger;
	}
	public void setTotalPassenger(int totalPassenger) {
		this.totalPassenger = totalPassenger;
	}
	public int getMinPrice() {
		return minPrice;
	}
	public void setMinPrice(int minPrice) {
		this.minPrice = minPrice;
	}
	public int getMaxPrice() {
		return maxPrice;
	}
	public void setMaxPrice(int maxPrice) {
		this.maxPrice = maxPrice;
	}
	public String getThingsTodo() {
		return thingsTodo;
	}
	public void setThingsTodo(String thingsTodo) {
		this.thingsTodo = thingsTodo;
	}
	public int getWeatherStatus() {
		return weatherStatus;
	}
	public void setWeatherStatus(int weatherStatus) {
		this.weatherStatus = weatherStatus;
	}
	public int getIsDrive() {
		return isDrive;
	}
	public void setIsDrive(int isDrive) {
		this.isDrive = isDrive;
	}
	public String getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}
	
	
	
}
