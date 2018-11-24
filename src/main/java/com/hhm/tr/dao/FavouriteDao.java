package com.hhm.tr.dao;

import java.util.List;

import com.hhm.tr.base.BaseResponse;
import com.hhm.tr.model.Favourite;

public interface FavouriteDao {

	List<Favourite> getAllFavouriteById(int id);

	BaseResponse saveFavourite(Favourite favourite);

}
