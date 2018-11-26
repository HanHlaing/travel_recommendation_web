package com.hhm.tr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.hhm.tr.base.BaseResponse;
import com.hhm.tr.dao.ReviewDao;
import com.hhm.tr.model.Review;

@Service("reviewService")
@Transactional
public class ApiReviewServiceImpl implements ApiReviewService {

	ReviewDao reviewDao;

	@Autowired
	public void setReviewDao(ReviewDao reviewDao) {
		this.reviewDao = reviewDao;
	}
	
	@Override
	public BaseResponse postReview(Review review) {
		// TODO Auto-generated method stub
		return reviewDao.postReview(review);
	}

	@Override
	public List<Review> getAllReviewById(int id) {
		// TODO Auto-generated method stub
		return reviewDao.getAllReviewById(id);
	}

	@Override
	public BaseResponse deleteReview(int id) {
		// TODO Auto-generated method stub
		return reviewDao.deleteReview(id);
	}

}