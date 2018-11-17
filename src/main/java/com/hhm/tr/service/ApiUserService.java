package com.hhm.tr.service;

import java.util.List;

import com.hhm.tr.base.BaseResponse;
import com.hhm.tr.model.UserBean;

public interface ApiUserService {

	List<UserBean> findAllUsers(); 
	
	 public void addUser(UserBean user);
	 
	 public void updateUser(UserBean user);
	 
	 public void deleteUser(int id);
	 
	 public BaseResponse createUser(UserBean user);
}
