package com.hhm.tr.service;


import com.hhm.tr.base.BaseResponse;
import com.hhm.tr.model.MoreTrip;
import com.hhm.tr.model.RecommendTrip;
import com.hhm.tr.model.Trip;

public interface ApiTripService {

	BaseResponse createTrip(Trip trip);

	RecommendTrip getAllTrips();
	
	MoreTrip getMoreTrips(int tripType);

	BaseResponse updateTrip(Trip trip);

	BaseResponse deleteTrip(int id);
}
