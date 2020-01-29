package com.hhm.tr.dao;

import java.util.List;

import com.hhm.tr.base.BaseResponse;
import com.hhm.tr.model.Tours;
import com.hhm.tr.model.UserBean;


public interface UserDao {
 
 public List<UserBean> listAllUsers();
 
 public Tours listAllTours();
 
 public void addUser(UserBean user);
 
 public BaseResponse updateUser(UserBean user);
 
 public void deleteUser(int id);
 
 public BaseResponse createUser(UserBean user);

 public BaseResponse login(UserBean user);

}