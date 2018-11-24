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
import com.hhm.tr.model.Favourite;
import com.hhm.tr.service.ApiFavouriteService;

@RestController
public class ApiFavouriteController {
	
	@Autowired
	ApiFavouriteService favouriteService;
	
	@RequestMapping(value = "/api/favourite/getFavouriteById/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<Favourite>> getFavouriteById(@PathVariable("id") int id) {
    	List<Favourite> favourite = favouriteService.getAllFavouriteById(id); 	
   	 return new ResponseEntity<List<Favourite>>(favourite, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/api/favourite/saveFavourite", method = RequestMethod.POST)
    public BaseResponse postReview(@RequestBody Favourite favourite) {   	
    	return favouriteService.saveFavourite(favourite);
    }
    
    
}
