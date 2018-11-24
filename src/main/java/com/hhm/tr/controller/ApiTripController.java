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
import com.hhm.tr.model.Trip;
import com.hhm.tr.service.ApiTripService;

@RestController
public class ApiTripController {
	
	@Autowired
	ApiTripService tripService;

	@RequestMapping(value = "/api/trips", method = RequestMethod.GET)
    public ResponseEntity<List<Trip>> getAllTrips() {
    	List<Trip> trips = tripService.getAllTrips(); 	
   	 return new ResponseEntity<List<Trip>>(trips, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/api/trip/create", method = RequestMethod.POST)
    public BaseResponse createTrip(@RequestBody Trip trip) {   	
    	return tripService.createTrip(trip);
    }
    
    @RequestMapping(value = "/api/trip/update", method = RequestMethod.POST)
    public BaseResponse login(@RequestBody Trip trip) {   
    	return tripService.updateTrip(trip);
    }

    @RequestMapping(value = "/api/trip/delete/{id}", method = RequestMethod.GET)
	public BaseResponse deleteTrip(@PathVariable("id") int id) {
    	return tripService.deleteTrip(id);
    }
}
