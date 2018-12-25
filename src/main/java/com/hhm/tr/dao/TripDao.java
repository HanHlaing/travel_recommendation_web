package com.hhm.tr.dao;


import com.hhm.tr.base.BaseResponse;
import com.hhm.tr.model.MoreTrip;
import com.hhm.tr.model.RecommendTrip;
import com.hhm.tr.model.Trip;

public interface TripDao {

	BaseResponse createTrip(Trip trip);

	RecommendTrip getAllTrips();

	BaseResponse updateTrip(Trip trip);

	BaseResponse deleteTrip(int id);

	MoreTrip getMoreTrips(int tripType);

	MoreTrip getTripsByTour(int tourId);

}
