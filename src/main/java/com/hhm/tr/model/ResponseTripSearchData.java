package com.hhm.tr.model;

import java.util.List;

import com.hhm.tr.base.BaseResponse;

public class ResponseTripSearchData extends BaseResponse {

	List<Trip> tripList;

	public List<Trip> getTripList() {
		return tripList;
	}

	public void setTripList(List<Trip> tripList) {
		this.tripList = tripList;
	}
	
}
