package com.hhm.tr.model;

import java.util.Date;

public class Review {

	int reviewId;
    int rateTo;
    int rateBy;
    int rating;
    String comment;
    int type;
    Date createdDate;
    Date modifiedDate;  
    
	public Review() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Review(int reviewId) {
		super();
		this.reviewId = reviewId;
	}
	public Review(int rateTo, int rateBy, int rating, String comment,int type) {
		super();
		this.rateTo = rateTo;
		this.rateBy = rateBy;
		this.rating = rating;
		this.comment = comment;
		this.type = type;
	}
	public int getReviewId() {
		return reviewId;
	}
	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}
	public int getRateTo() {
		return rateTo;
	}
	public void setRateTo(int rateTo) {
		this.rateTo = rateTo;
	}
	public int getRateBy() {
		return rateBy;
	}
	public void setRateBy(int rateBy) {
		this.rateBy = rateBy;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
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
