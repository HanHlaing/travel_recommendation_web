package com.hhm.tr.dao;

import java.util.List;

import com.hhm.tr.base.BaseResponse;
import com.hhm.tr.model.Review;

public interface ReviewDao {


	BaseResponse postReview(Review review);
	
	Review getAllReviewById(int rateTo,int rateBy);
	
	Review getTourAllReviewById(int rateTo,int rateBy);

	BaseResponse deleteReview(int id);

	List<Review> getAllReviews(int id);

	List<Review> getReviewsByUserId(int userId);

}
