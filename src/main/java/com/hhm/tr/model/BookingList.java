package com.hhm.tr.model;

import java.util.List;

import com.hhm.tr.base.BaseResponse;

public class BookingList extends BaseResponse {

	List<Booking> bookingList;

	public List<Booking> getBookingList() {
		return bookingList;
	}

	public void setBookingList(List<Booking> bookingList) {
		this.bookingList = bookingList;
	}
	
}
