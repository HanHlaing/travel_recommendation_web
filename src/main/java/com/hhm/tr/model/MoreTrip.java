package com.hhm.tr.model;

import java.util.List;

import com.hhm.tr.base.BaseResponse;

public class MoreTrip extends BaseResponse {
	
	List<Trip> moreList;

	public List<Trip> getMoreList() {
		return moreList;
	}

	public void setMoreList(List<Trip> moreList) {
		this.moreList = moreList;
	}


}
