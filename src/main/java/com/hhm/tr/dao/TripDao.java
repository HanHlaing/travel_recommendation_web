package com.hhm.tr.dao;


import com.hhm.tr.base.BaseResponse;
import com.hhm.tr.model.MoreTrip;
import com.hhm.tr.model.RecommendTrip;
import com.hhm.tr.model.ResponseTripSearchData;
import com.hhm.tr.model.Trip;
import com.hhm.tr.model.TripSearchData;

public interface TripDao {

	BaseResponse createTrip(Trip trip);
	
	ResponseTripSearchData searchTrip(TripSearchData trip);

	RecommendTrip getAllTrips();

	BaseResponse updateTrip(Trip trip);

	BaseResponse deleteTrip(int id);

	MoreTrip getMoreTrips(int tripType);

	MoreTrip getTripsByTour(int tourId);

}
