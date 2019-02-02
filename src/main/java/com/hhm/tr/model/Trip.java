package com.hhm.tr.model;

import java.util.Date;

public class Trip {
	
	private int tripId;
	private int userId;
	private String tripName;
	private String tripDetails;
	private String image;
	private String createdBy;
	private String thingTodo;
	private int totalAmount;
	private int tripPrice;
	private int discountPassengerLimit;
	private int discountPercent;
	private String departFrom;
	private Date departDate;
	private Date returnDate;
	private Date departTime;
	private int nightStay;
	private int totalSeats;
	private int available;
	private int costPerDay;
	private int hotelPrice;
	private int flightCarCost;
	private int driveOrFly;
	private double rating;
	private int totalViews;
	private Date createdDate;
	private Date modifiedDate;
	private boolean haveBreakfast;
	private boolean haveLunch;
	private boolean haveDinner;
	public Trip() {
		super();
	}
	
	
	public Trip(String tripName) {
		super();
		this.tripName = tripName;
	}

	public Trip(int tripId) {
		super();
		this.tripId = tripId;
	}

	public Trip(int userId, String tripName, String tripDetails, int amount, int discountPassengerLimit,
			int discountPercent, String departFrom, Date departDate, Date returnDate, Date departTime, int nightStay,
			int totalSeats, int available, int costPerDay, int hotelPrice, int flightCarCost, int driveOrFly,
			int totalViews) {
		
		this.userId = userId;
		this.tripName = tripName;
		this.tripDetails = tripDetails;
		this.totalAmount = amount;
		this.discountPassengerLimit = discountPassengerLimit;
		this.discountPercent = discountPercent;
		this.departFrom = departFrom;
		this.departDate = departDate;
		this.returnDate = returnDate;
		this.departTime = departTime;
		this.nightStay = nightStay;
		this.totalSeats = totalSeats;
		this.available = available;
		this.costPerDay = costPerDay;
		this.hotelPrice = hotelPrice;
		this.flightCarCost = flightCarCost;
		this.driveOrFly = driveOrFly;
		this.totalViews = totalViews;
	}
	
	
	public int getTripPrice() {
		return tripPrice;
	}


	public void setTripPrice(int tripPrice) {
		this.tripPrice = tripPrice;
	}
	

	public String getCreatedBy() {
		return createdBy;
	}


	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}


	public int getTripId() {
		return tripId;
	}
	public void setTripId(int tripId) {
		this.tripId = tripId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getTripName() {
		return tripName;
	}
	public void setTripName(String tripName) {
		this.tripName = tripName;
	}
	public String getTripDetails() {
		return tripDetails;
	}
	public void setTripDetails(String tripDetails) {
		this.tripDetails = tripDetails;
	}
	 
	
	public int getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}
	public int getDiscountPassengerLimit() {
		return discountPassengerLimit;
	}
	public void setDiscountPassengerLimit(int discountPassengerLimit) {
		this.discountPassengerLimit = discountPassengerLimit;
	}
	public int getDiscountPercent() {
		return discountPercent;
	}
	public void setDiscountPercent(int discountPercent) {
		this.discountPercent = discountPercent;
	}
	public String getDepartFrom() {
		return departFrom;
	}
	public void setDepartFrom(String departFrom) {
		this.departFrom = departFrom;
	}
	public Date getDepartDate() {
		return departDate;
	}
	public void setDepartDate(Date departDate) {
		this.departDate = departDate;
	}
	public Date getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}
	public Date getDepartTime() {
		return departTime;
	}
	public void setDepartTime(Date departTime) {
		this.departTime = departTime;
	}
	public int getNightStay() {
		return nightStay;
	}
	public void setNightStay(int nightStay) {
		this.nightStay = nightStay;
	}
	public int getTotalSeats() {
		return totalSeats;
	}
	public void setTotalSeats(int totalSeats) {
		this.totalSeats = totalSeats;
	}
	public int getAvailable() {
		return available;
	}
	public void setAvailable(int available) {
		this.available = available;
	}
	public int getCostPerDay() {
		return costPerDay;
	}
	public void setCostPerDay(int costPerDay) {
		this.costPerDay = costPerDay;
	}
	public int getHotelPrice() {
		return hotelPrice;
	}
	public void setHotelPrice(int hotelPrice) {
		this.hotelPrice = hotelPrice;
	}
	public int getFlightCarCost() {
		return flightCarCost;
	}
	public void setFlightCarCost(int flightCarCost) {
		this.flightCarCost = flightCarCost;
	}
	public int getDriveOrFly() {
		return driveOrFly;
	}
	public void setDriveOrFly(int driveOrFly) {
		this.driveOrFly = driveOrFly;
	}
	public int getTotalViews() {
		return totalViews;
	}
	public void setTotalViews(int totalViews) {
		this.totalViews = totalViews;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}


	public boolean isHaveBreakfast() {
		return haveBreakfast;
	}


	public void setHaveBreakfast(boolean haveBreakfast) {
		this.haveBreakfast = haveBreakfast;
	}


	public boolean isHaveLunch() {
		return haveLunch;
	}


	public void setHaveLunch(boolean haveLunch) {
		this.haveLunch = haveLunch;
	}


	public boolean isHaveDinner() {
		return haveDinner;
	}


	public void setHaveDinner(boolean haveDinner) {
		this.haveDinner = haveDinner;
	}


	public double getRating() {
		return rating;
	}


	public void setRating(double rating) {
		this.rating = rating;
	}


	public String getThingTodo() {
		return thingTodo;
	}


	public void setThingTodo(String thingTodo) {
		this.thingTodo = thingTodo;
	}


	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}
	
	
	

}
