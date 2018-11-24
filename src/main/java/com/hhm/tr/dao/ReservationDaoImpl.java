package com.hhm.tr.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import com.hhm.tr.model.Reservation;

@Repository
public class ReservationDaoImpl implements ReservationDao {

	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	
	private SqlParameterSource getSqlParameterByModel(Reservation reservation) {
		MapSqlParameterSource parameterSource = new MapSqlParameterSource();
		if (reservation != null) {
			parameterSource.addValue("id", reservation.getReservationId());		
			parameterSource.addValue("tour_id",reservation.getTourId());
			parameterSource.addValue("user_id",reservation.getUserId());
			parameterSource.addValue("total_seats", reservation.getTotalSeats());
			parameterSource.addValue("total_passenger", reservation.getTotalPassenger());
			parameterSource.addValue("reserve_amount_from", reservation.getReserveAmountFrom());
			parameterSource.addValue("reserve_amount_to",reservation.getReserveAmountTo());
			parameterSource.addValue("amount",reservation.getAmount());
			parameterSource.addValue("discount_percent", reservation.getDiscountPercent());
			parameterSource.addValue("depart_date", reservation.getDepartDate());
			parameterSource.addValue("return_date",reservation.getReturnDate());
			parameterSource.addValue("created_date", reservation.getCreatedDate());
			parameterSource.addValue("modified_date", reservation.getModifiedDate());
			 
		}
		return parameterSource;
	}

	private static final class ReservationMapper implements RowMapper<Reservation> {

		public Reservation mapRow(ResultSet rs, int rowNum) throws SQLException {
			Reservation reservation = new Reservation();
			reservation.setReservationId(rs.getInt("id"));
			reservation.setTourId(rs.getInt("tour_id"));
			reservation.setUserId(rs.getInt("user_id"));
			reservation.setTotalSeats(rs.getInt("total_seats"));
			reservation.setTotalPassenger(rs.getInt("total_passenger"));
			reservation.setReserveAmountFrom(rs.getInt("reserve_amount_from"));
			reservation.setReserveAmountTo(rs.getInt("reserve_amount_to"));
			reservation.setAmount(rs.getInt("amount"));
			reservation.setDiscountPercent(rs.getInt("discount_percent"));
			reservation.setDepartDate(rs.getDate("depart_date"));
			reservation.setReturnDate(rs.getDate("return_date"));
			reservation.setCreatedDate(rs.getDate("created_date"));
			reservation.setModifiedDate(rs.getDate("modified_date"));

			return reservation;
		}

	}
	
	@Override
	public List<Reservation> getAllReservationById(int id) {
		String sql = "SELECT * FROM reservation  WHERE id = :id";
		List<Reservation> list = namedParameterJdbcTemplate.query(sql, getSqlParameterByModel(new Reservation(id)), new ReservationMapper());
		return list;
	}
	

	
}
