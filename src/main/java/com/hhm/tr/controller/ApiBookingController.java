package com.hhm.tr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hhm.tr.base.BaseResponse;
import com.hhm.tr.model.Booking;
import com.hhm.tr.model.BookingList;
import com.hhm.tr.service.ApiBookingService;

@RestController
public class ApiBookingController {

	@Autowired
	ApiBookingService bookingService;

	
	@RequestMapping(value = "/api/booking/create", method = RequestMethod.POST)
    public BaseResponse createTrip(@RequestBody Booking booking) {   	
    	return bookingService.createBooking(booking);
    }
	
	@RequestMapping(value = "/api/booking/getAllBookingById/{id}",method = RequestMethod.GET)
	public BookingList getAllBookingById(@PathVariable("id") int id) {
    	return bookingService.getAllBookingById(id);
    }
	
	@RequestMapping(value = "/api/booking/getAllBookingByUserId/{userId}",method = RequestMethod.GET)
	public BookingList getAllBookingByUserId(@PathVariable("userId") int userId) {
    	return bookingService.getAllBookingByUserId(userId);
    }
}
