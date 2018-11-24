package com.hhm.tr.service;

import java.util.List;

import com.hhm.tr.base.BaseResponse;
import com.hhm.tr.model.Trip;

public interface ApiTripService {

	BaseResponse createTrip(Trip trip);

	List<Trip> getAllTrips();

	BaseResponse updateTrip(Trip trip);

	BaseResponse deleteTrip(int id);
}
