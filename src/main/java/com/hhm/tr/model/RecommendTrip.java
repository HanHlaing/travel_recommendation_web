package com.hhm.tr.model;

import java.util.List;

import com.hhm.tr.base.BaseResponse;

public class RecommendTrip extends BaseResponse {

	List<Trip> popularList;
	
	List<Trip> recommendList;
	
	List<Trip> recentList;

	public List<Trip> getPopularList() {
		return popularList;
	}

	public void setPopularList(List<Trip> popularList) {
		this.popularList = popularList;
	}

	public List<Trip> getRecommendList() {
		return recommendList;
	}

	public void setRecommendList(List<Trip> recommendList) {
		this.recommendList = recommendList;
	}

	public List<Trip> getRecentList() {
		return recentList;
	}

	public void setRecentList(List<Trip> recentList) {
		this.recentList = recentList;
	}

	 
	 
	
	
}
