package com.hhm.tr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.hhm.tr.service.ApiReservationService;

@RestController
public class ApiReservationController {

	@Autowired
	ApiReservationService reservationService;

}
