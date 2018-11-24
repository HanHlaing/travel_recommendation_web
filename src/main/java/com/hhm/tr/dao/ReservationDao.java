package com.hhm.tr.dao;

import java.util.List;

import com.hhm.tr.model.Reservation;

public interface ReservationDao {

	List<Reservation> getAllReservationById(int id);

}
