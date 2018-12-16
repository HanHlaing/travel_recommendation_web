package com.hhm.tr.model;

import java.util.List;

import com.hhm.tr.base.BaseResponse;

public class Tours extends BaseResponse {
	
	List<UserBean> tourList;

	public List<UserBean> getTourList() {
		return tourList;
	}

	public void setTourList(List<UserBean> tourList) {
		this.tourList = tourList;
	}
	
	

}
