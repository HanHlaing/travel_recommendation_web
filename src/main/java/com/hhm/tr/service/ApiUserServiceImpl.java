package com.hhm.tr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hhm.tr.base.BaseResponse;
import com.hhm.tr.dao.UserDao;
import com.hhm.tr.model.Tours;
import com.hhm.tr.model.UserBean;

@Service("service")
@Transactional
public class ApiUserServiceImpl implements ApiUserService {

	UserDao userDao;

	@Autowired
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public List<UserBean> listAllUsers() {
		return userDao.listAllUsers();
	}

	public void addUser(UserBean user) {
		userDao.addUser(user);
	}

	public void updateUser(UserBean user) {
		userDao.updateUser(user);
	}

	public void deleteUser(int id) {
		userDao.deleteUser(id);
	}

	public BaseResponse createUser(UserBean user) {
		return userDao.createUser(user);
	}
	
	public BaseResponse login(UserBean user) {
		return userDao.login(user);
	}

	public List<UserBean> findAllUsers() {
		// TODO Auto-generated method stub
		return userDao.listAllUsers();
	}

	@Override
	public Tours findAllTours() {
		// TODO Auto-generated method stub
		return userDao.listAllTours();
	}

 

}
