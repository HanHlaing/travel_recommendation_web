package com.hhm.tr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hhm.tr.base.BaseResponse;
import com.hhm.tr.model.UserBean;
import com.hhm.tr.service.ApiUserService;

@RestController
public class ApiUserController {
	
    @Autowired
    ApiUserService service; 
    
    @RequestMapping(value = "/api/users", method = RequestMethod.GET)
    public ResponseEntity<List<UserBean>> listAllUsers() {
    	List<UserBean> users = service.findAllUsers();
    	
   	 return new ResponseEntity<List<UserBean>>(users, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/api/users/registration", method = RequestMethod.POST)
    public BaseResponse registerUser(@RequestBody UserBean user) {
    	
    	return service.createUser(user);
    }
    
    @RequestMapping(value = "/api/users/login", method = RequestMethod.POST)
    public BaseResponse login(@RequestBody UserBean user) {
    	
    	return service.login(user);
    }

}
