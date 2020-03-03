package com.hhm.tr.service;

import java.util.List;

import com.hhm.tr.base.BaseResponse;
import com.hhm.tr.model.Review;

public interface ApiReviewService {

	BaseResponse postReview(Review review);
	
	Review getAllReviewById(int rateTo,int rateBy);
	
	Review getTourAllReviewById(int rateTo,int rateBy);
	
	List<Review> getAllReviews(int id);

	BaseResponse deleteReview(int id);

	List<Review> getReviewsByUserId(int userid);

}
