package com.hhm.tr.model;

import java.util.Date;

public class Reservation {

	int reservationId;    
	int tripId;
    int tourId;
    int userId;
    int totalSeats;
    int totalPassenger;
    int reserveAmountFrom;
    int reserveAmountTo;
    int amount;
    int discountPercent;
    Date departDate;
    Date returnDate;
    Date departTime;
    int nightStay;  
    int available;
    int costPerDay;
    int hotelPrice;
    int flightCarCost;
    int driveOrFly;
    int totalViews;
    Date createdDate;
    Date modifiedDate;
    
    
	public Reservation() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Reservation(int reservationId) {
		super();
		this.reservationId = reservationId;
	}


	public int getReservationId() {
		return reservationId;
	}
	public void setReservationId(int reservationId) {
		this.reservationId = reservationId;
	}
	public int getTripId() {
		return tripId;
	}
	public void setTripId(int tripId) {
		this.tripId = tripId;
	}
	public int getTourId() {
		return tourId;
	}
	public void setTourId(int tourId) {
		this.tourId = tourId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getTotalSeats() {
		return totalSeats;
	}
	public void setTotalSeats(int totalSeats) {
		this.totalSeats = totalSeats;
	}
	public int getTotalPassenger() {
		return totalPassenger;
	}
	public void setTotalPassenger(int totalPassenger) {
		this.totalPassenger = totalPassenger;
	}
	public int getReserveAmountFrom() {
		return reserveAmountFrom;
	}
	public void setReserveAmountFrom(int reserveAmountFrom) {
		this.reserveAmountFrom = reserveAmountFrom;
	}
	public int getReserveAmountTo() {
		return reserveAmountTo;
	}
	public void setReserveAmountTo(int reserveAmountTo) {
		this.reserveAmountTo = reserveAmountTo;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getDiscountPercent() {
		return discountPercent;
	}
	public void setDiscountPercent(int discountPercent) {
		this.discountPercent = discountPercent;
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
    
    
    
    
}
