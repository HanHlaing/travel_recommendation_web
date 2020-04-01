package com.hhm.tr.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.hhm.tr.base.BaseResponse;
import com.hhm.tr.dao.BookingDao;
import com.hhm.tr.model.Booking;
import com.hhm.tr.model.BookingList;

@Service("bookingService")
@Transactional
public class ApiBookingServiceImpl implements ApiBookingService {

	BookingDao bookingDao;
	
	@Autowired
	public void setTripDao(BookingDao bookingDao) {
		this.bookingDao = bookingDao;
	}

	@Override
	public BaseResponse createBooking(Booking booking) {
		// TODO Auto-generated method stub
		return bookingDao.createBooking(booking);
	}

	@Override
	public BookingList getAllBookingById(int id) {
		// TODO Auto-generated method stub
		return bookingDao.getAllBookingById(id);
	}

	@Override
	public BookingList getAllBookingByUserId(int userId) {
		// TODO Auto-generated method stub
		return bookingDao.getAllBookingByUserId(userId);
	}
}
