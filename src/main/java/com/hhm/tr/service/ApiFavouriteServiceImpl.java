package com.hhm.tr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.hhm.tr.base.BaseResponse;
import com.hhm.tr.dao.FavouriteDao;
import com.hhm.tr.model.Favourite;

@Service("favouriteService")
@Transactional
public class ApiFavouriteServiceImpl implements ApiFavouriteService {

	FavouriteDao favouriteDao;

	@Autowired
	public void setFavouriteDao(FavouriteDao favouriteDao) {
		this.favouriteDao = favouriteDao;
	}
	
	@Override
	public List<Favourite> getAllFavouriteById(int id) {
		// TODO Auto-generated method stub
		return favouriteDao.getAllFavouriteById(id);
	}

	@Override
	public BaseResponse saveFavourite(Favourite favourite) {
		// TODO Auto-generated method stub
		return favouriteDao.saveFavourite(favourite);
	}

}
