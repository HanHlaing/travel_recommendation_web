package com.hhm.tr.service;

import java.util.List;

import com.hhm.tr.base.BaseResponse;
import com.hhm.tr.model.Favourite;

public interface ApiFavouriteService {

	List<Favourite> getAllFavouriteById(int id);

	BaseResponse saveFavourite(Favourite favourite);
}
