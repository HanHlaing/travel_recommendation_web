package com.hhm.tr.model;

import java.util.Date;

public class Booking {

	int id;    
	int tripId;
    int tourId;
    int userId;
    int totalSeats;
    int totalPassenger;
    String departFrom;
    String departTo;
    int amount;
    int perAmount;
    Date departDate;
    Date returnDate;
    Date departTime;
    Date createdDate;
    Date modifiedDate;
    String passengerName;
    String phone;
    String address;
    String country;
    String zipCode;
    String city;
    String state;
    String cardType;
    String nameOnCard;
    String cardNumber;
    String expiredDate;
    String cvv;
    String tourName;
    
    
    public Booking() {
		super();
	}
    
	public Booking(int id) {
		super();
		this.id = id;
	}
	
	public Booking(int userId,String other) {
		super();
		this.userId = userId;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getDepartFrom() {
		return departFrom;
	}
	public void setDepartFrom(String departFrom) {
		this.departFrom = departFrom;
	}
	public String getDepartTo() {
		return departTo;
	}
	public void setDepartTo(String departTo) {
		this.departTo = departTo;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getPerAmount() {
		return perAmount;
	}
	public void setPerAmount(int perAmount) {
		this.perAmount = perAmount;
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
	public String getPassengerName() {
		return passengerName;
	}
	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	public String getNameOnCard() {
		return nameOnCard;
	}
	public void setNameOnCard(String nameOnCard) {
		this.nameOnCard = nameOnCard;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getExpiredDate() {
		return expiredDate;
	}
	public void setExpiredDate(String expiredDate) {
		this.expiredDate = expiredDate;
	}

	public String getCvv() {
		return cvv;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}

	public String getTourName() {
		return tourName;
	}

	public void setTourName(String tourName) {
		this.tourName = tourName;
	}
   
	
 }
