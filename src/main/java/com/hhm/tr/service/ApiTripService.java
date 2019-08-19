package com.hhm.tr.service;


import com.hhm.tr.base.BaseResponse;
import com.hhm.tr.model.MoreTrip;
import com.hhm.tr.model.RecommendTrip;
import com.hhm.tr.model.ResponseTripSearchData;
import com.hhm.tr.model.Trip;
import com.hhm.tr.model.TripSearchData;

public interface ApiTripService {

	BaseResponse createTrip(Trip trip);
	
	ResponseTripSearchData searchTrip(TripSearchData trip);

	RecommendTrip getAllTrips();
	
	MoreTrip getMoreTrips(int tripType);

	BaseResponse updateTrip(Trip trip);

	BaseResponse deleteTrip(int id);
	
	MoreTrip getTripsByTour(int tourId);
}
