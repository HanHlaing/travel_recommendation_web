package com.hhm.tr.service;

import com.hhm.tr.base.BaseResponse;
import com.hhm.tr.model.Booking;
import com.hhm.tr.model.BookingList;

public interface ApiBookingService {
	
	BookingList getAllBookingById(int id);
	
	BookingList getAllBookingByUserId(int userId);
	
	BaseResponse createBooking(Booking booking);

}
