package com.hhm.tr.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.hhm.tr.base.BaseResponse;
import com.hhm.tr.dao.TripDao;
import com.hhm.tr.model.MoreTrip;
import com.hhm.tr.model.RecommendTrip;
import com.hhm.tr.model.ResponseTripSearchData;
import com.hhm.tr.model.Trip;
import com.hhm.tr.model.TripSearchData;

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
	public RecommendTrip getAllTrips() {
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

	@Override
	public MoreTrip getMoreTrips(int tripType) {
		// TODO Auto-generated method stub
		return tripDao.getMoreTrips(tripType);
	}

	@Override
	public MoreTrip getTripsByTour(int tourId) {
		// TODO Auto-generated method stub
		return tripDao.getTripsByTour(tourId);
	}

	@Override
	public ResponseTripSearchData searchTrip(TripSearchData trip) {
		// TODO Auto-generated method stub
		return tripDao.searchTrip(trip);
	}

 
	 
}
