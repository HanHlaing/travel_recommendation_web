package com.hhm.tr.controller;
 
import java.util.ArrayList;
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.hhm.tr.model.User;
import com.hhm.tr.model.UserBean;
import com.hhm.tr.service.ApiUserService;



@RestController
public class HelloWorldRestController  {
 
	
    @Autowired
    ApiUserService service;  //Service which will do all data retrieval/manipulation work
 
     
    //-------------------Retrieve All Users--------------------------------------------------------
     
    @RequestMapping(value = "/api/users", method = RequestMethod.GET)
    public ResponseEntity<List<UserBean>> listAllUsers() {
    	/*Role role=new Role();
    	role.setRole("ADMIN");
    	role.setId(1);
        List<User> users = userService.findUserbyRole(role);
        if(users.isEmpty()){
            return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }*/
    	/*List<User> users=new ArrayList<>();
    	users.add(new User(1,"bb","bb","bb",1));
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);*/
    	List<UserBean> users = service.findAllUsers();
    	 return new ResponseEntity<List<UserBean>>(users, HttpStatus.OK);
    }
 
 
    //-------------------Retrieve Single User--------------------------------------------------------
    
}