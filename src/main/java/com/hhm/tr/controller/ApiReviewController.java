package com.hhm.tr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hhm.tr.base.BaseResponse;
import com.hhm.tr.model.Review;
import com.hhm.tr.service.ApiReviewService;

@RestController
public class ApiReviewController {
	
	@Autowired
	ApiReviewService reviewService;

	@RequestMapping(value = "/api/review/getReviewById/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<Review>> getReviewById(@PathVariable("id") int id) {
    	List<Review> reviews = reviewService.getAllReviewById(id); 	
   	 return new ResponseEntity<List<Review>>(reviews, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/api/review/postReview", method = RequestMethod.POST)
    public BaseResponse postReview(@RequestBody Review review) {   	
    	return reviewService.postReview(review);
    }
    
   
    @RequestMapping(value = "/api/review/delete/{id}", method = RequestMethod.GET)
	public BaseResponse deleteReview(@PathVariable("id") int id) {
    	return reviewService.deleteReview(id);
    }
}
