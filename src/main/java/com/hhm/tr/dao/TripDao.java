package com.hhm.tr.dao;

import java.util.List;

import com.hhm.tr.base.BaseResponse;
import com.hhm.tr.model.Trip;

public interface TripDao {

	BaseResponse createTrip(Trip trip);

	List<Trip> getAllTrips();

	BaseResponse updateTrip(Trip trip);

	BaseResponse deleteTrip(int id);

}
