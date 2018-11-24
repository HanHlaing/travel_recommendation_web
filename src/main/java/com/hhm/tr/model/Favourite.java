package com.hhm.tr.model;

import java.util.Date;

public class Favourite {

	private int favouriteId;
	private int tripId;
	private int saveBy;
	private Date createdDate;
	private Date modifiedDate;
	
	
	
	public Favourite() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Favourite(int favouriteId) {
		super();
		this.favouriteId = favouriteId;
	}
	public int getFavouriteId() {
		return favouriteId;
	}
	public void setFavouriteId(int favouriteId) {
		this.favouriteId = favouriteId;
	}
	public int getTripId() {
		return tripId;
	}
	public void setTripId(int tripId) {
		this.tripId = tripId;
	}
	public int getSaveBy() {
		return saveBy;
	}
	public void setSaveBy(int saveBy) {
		this.saveBy = saveBy;
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
