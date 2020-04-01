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

import com.hhm.tr.base.BaseResponse;
import com.hhm.tr.model.Booking;
import com.hhm.tr.model.BookingList;

@Repository
public class BookingDaoImpl implements BookingDao {

	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	
	private SqlParameterSource getSqlParameterByModel(Booking booking) {
		MapSqlParameterSource parameterSource = new MapSqlParameterSource();
		if (booking != null) {
			parameterSource.addValue("id", booking.getId());		
			parameterSource.addValue("tour_id",booking.getTourId());
			parameterSource.addValue("trip_id",booking.getTripId());
			parameterSource.addValue("user_id",booking.getUserId());
			parameterSource.addValue("total_seats", booking.getTotalSeats());
			parameterSource.addValue("total_passenger", booking.getTotalPassenger());
			parameterSource.addValue("depart_from", booking.getDepartFrom());
			parameterSource.addValue("depart_to",booking.getDepartTo());
			parameterSource.addValue("amount",booking.getAmount());
			parameterSource.addValue("per_amount", booking.getPerAmount());
			parameterSource.addValue("depart_date", booking.getDepartDate());
			parameterSource.addValue("return_date",booking.getReturnDate());
			parameterSource.addValue("created_date", booking.getCreatedDate());
			parameterSource.addValue("modified_date", booking.getModifiedDate());
			parameterSource.addValue("passenger_name", booking.getPassengerName());
			parameterSource.addValue("phone", booking.getPhone());
			parameterSource.addValue("address", booking.getAddress() );
			parameterSource.addValue("country", booking.getCountry());
			parameterSource.addValue("zip_code", booking.getZipCode());
			parameterSource.addValue("city", booking.getCity());
			parameterSource.addValue("state", booking.getState());
			parameterSource.addValue("card_type", booking.getCardType() );
			parameterSource.addValue("name_on_card", booking.getNameOnCard());
			parameterSource.addValue("card_number", booking.getCardNumber());
			parameterSource.addValue("expired_date", booking.getExpiredDate() );
			parameterSource.addValue("cvv", booking.getCvv());
			parameterSource.addValue("tour_name", booking.getTourName());
			parameterSource.addValue("trip_name", booking.getTripName());
			parameterSource.addValue("night_stay", booking.getNightStay());
			 
		}
		return parameterSource;
	}

	private static final class ReservationMapper implements RowMapper<Booking> {

		public Booking mapRow(ResultSet rs, int rowNum) throws SQLException {
			Booking booking = new Booking();
			booking.setId(rs.getInt("id"));
			booking.setTourId(rs.getInt("tour_id"));
			booking.setTripId(rs.getInt("trip_id"));
			booking.setUserId(rs.getInt("user_id"));
			booking.setTotalSeats(rs.getInt("total_seats"));
			booking.setTotalPassenger(rs.getInt("total_passenger"));
			booking.setDepartFrom(rs.getString("depart_from"));
			booking.setDepartTo(rs.getString("depart_to"));
			booking.setAmount(rs.getInt("amount"));
			booking.setPerAmount(rs.getInt("per_amount"));
			booking.setDepartDate(rs.getString("depart_date"));
			booking.setReturnDate(rs.getString("return_date"));
			booking.setPassengerName(rs.getString("passenger_name"));
			booking.setPhone(rs.getString("phone"));
			booking.setAddress(rs.getString("address"));
			booking.setCountry(rs.getString("country"));
			booking.setZipCode(rs.getString("zip_code"));
			booking.setCity(rs.getString("city"));
			booking.setState(rs.getString("state"));
			booking.setCardType(rs.getString("card_type"));
			booking.setNameOnCard(rs.getString("name_on_card"));
			booking.setCardNumber(rs.getString("card_number"));
			booking.setExpiredDate(rs.getString("expired_date"));
			booking.setCvv(rs.getString("cvv"));
			booking.setTourName(rs.getString("tour_name"));
			booking.setTripName(rs.getString("trip_name"));
			booking.setCreatedDate(rs.getString("created_date"));
			booking.setModifiedDate(rs.getString("modified_date"));
			booking.setNightStay(rs.getInt("night_stay"));

			return booking;
		}

	}
	
	@Override
	public BookingList getAllBookingById(int id) {
		
		String sql = "SELECT * FROM booking  WHERE id = :id";
		List<Booking> list = namedParameterJdbcTemplate.query(sql, getSqlParameterByModel(new Booking(id)), new ReservationMapper());
		BookingList booking = new BookingList();
		booking.setBookingList(list);
		booking.setMesssageCode("000");
		
		return booking;
	}
	
	@Override
	public BookingList getAllBookingByUserId(int userId) {
		
		String sql = "SELECT * FROM booking  WHERE user_id = :user_id";
		List<Booking> list = namedParameterJdbcTemplate.query(sql, getSqlParameterByModel(new Booking(userId,"")), new ReservationMapper());
		BookingList booking = new BookingList();
		booking.setBookingList(list);
		booking.setMesssageCode("000");
		
		return booking;
	}
	
	@Override
	public BaseResponse createBooking(Booking booking) {

		BaseResponse res = new BaseResponse();
		try {
			
				book(booking);
				res.setMesssageCode("000");
				res.setMessage("Booking Successful!");

		} catch (Exception e) {
			System.out.println("Error in create trip => " + e.getMessage());
			res.setMesssageCode("003");
			res.setMessage(e.getMessage());
		}

		return res;
	}
	
	public void book(Booking booking) {
		String sql = "INSERT INTO booking(tour_id,trip_id,user_id,total_seats,total_passenger,depart_from,depart_to,amount,per_amount,depart_date,return_date,passenger_name,phone,"
						+ "address,country,zip_code,city,state,card_type,name_on_card,card_number,expired_date,cvv,tour_name,trip_name,created_date,modified_date,night_stay)"
						+ " VALUES(:tour_id,:trip_id,:user_id,:total_seats,:total_passenger,:depart_from,:depart_to,:amount,:per_amount,:depart_date,:return_date,:passenger_name,:phone," 
						+ ":address,:country,:zip_code,:city,:state,:card_type,:name_on_card,:card_number,:expired_date,:cvv,:tour_name,:trip_name,:created_date,:modified_date,:night_stay)";

		namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(booking));

	}

}
