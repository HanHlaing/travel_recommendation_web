package com.hhm.tr.dao;

import com.hhm.tr.base.BaseResponse;
import com.hhm.tr.model.Booking;
import com.hhm.tr.model.BookingList;

public interface BookingDao {

	BookingList getAllBookingById(int id);
	
	BookingList getAllBookingByUserId(int userId);

	BaseResponse createBooking(Booking booking);
}
