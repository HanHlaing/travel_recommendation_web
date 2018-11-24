package com.hhm.tr.service;

import java.util.List;

import com.hhm.tr.base.BaseResponse;
import com.hhm.tr.model.Review;

public interface ApiReviewService {

	BaseResponse postReview(Review review);
	
	List<Review> getAllReviewById(int id);

	BaseResponse deleteReview(int id);

}
