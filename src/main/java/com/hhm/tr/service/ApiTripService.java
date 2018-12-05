package com.hhm.tr.service;


import com.hhm.tr.base.BaseResponse;
import com.hhm.tr.model.RecommendTrip;
import com.hhm.tr.model.Trip;

public interface ApiTripService {

	BaseResponse createTrip(Trip trip);

	RecommendTrip getAllTrips();

	BaseResponse updateTrip(Trip trip);

	BaseResponse deleteTrip(int id);
}
