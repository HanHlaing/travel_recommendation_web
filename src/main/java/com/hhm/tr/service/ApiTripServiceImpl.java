package com.hhm.tr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hhm.tr.base.BaseResponse;
import com.hhm.tr.dao.TripDao;
import com.hhm.tr.model.Trip;

@Service("tripService")
@Transactional
public class ApiTripServiceImpl implements ApiTripService {

	
	TripDao tripDao;

	@Autowired
	public void setTripDao(TripDao tripDao) {
		this.tripDao = tripDao;
	}
	
	@Override
	public BaseResponse createTrip(Trip trip) {
		// TODO Auto-generated method stub
		return tripDao.createTrip(trip);
	}

	@Override
	public List<Trip> getAllTrips() {
		// TODO Auto-generated method stub
		return tripDao.getAllTrips();
	}

	@Override
	public BaseResponse updateTrip(Trip trip) {
		// TODO Auto-generated method stub
		return tripDao.updateTrip(trip);
	}

	@Override
	public BaseResponse deleteTrip(int id) {
		// TODO Auto-generated method stub
		return tripDao.deleteTrip(id);
	}

 
	 
}