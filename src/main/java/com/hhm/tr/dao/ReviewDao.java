package com.hhm.tr.dao;

import java.util.List;

import com.hhm.tr.base.BaseResponse;
import com.hhm.tr.model.Review;

public interface ReviewDao {


	BaseResponse postReview(Review review);
	
	List<Review> getAllReviewById(int id);

	BaseResponse deleteReview(int id);

}
