package com.hhm.tr.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hhm.tr.model.User;
import com.hhm.tr.model.UserBean;

public interface ApiUserService {

	List<UserBean> findAllUsers(); 
	
	 public void addUser(UserBean user);
	 
	 public void updateUser(UserBean user);
	 
	 public void deleteUser(int id);
	 
	 public UserBean findUserById(int id);
}
