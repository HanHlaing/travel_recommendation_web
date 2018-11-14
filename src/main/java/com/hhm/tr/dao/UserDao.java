package com.hhm.tr.dao;

import java.util.List;

import com.hhm.tr.model.User;
import com.hhm.tr.model.UserBean;


public interface UserDao {
 
 public List<UserBean> listAllUsers();
 
 public void addUser(UserBean user);
 
 public void updateUser(UserBean user);
 
 public void deleteUser(int id);
 
 public UserBean findUserById(int id);
}