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
import com.hhm.tr.model.Trip;

@Repository
public class TripDaoImpl implements TripDao{
	
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	
	private SqlParameterSource getSqlParameterByModel(Trip trip) {
		MapSqlParameterSource parameterSource = new MapSqlParameterSource();
		if (trip != null) {
			parameterSource.addValue("id", trip.getTripId());
			parameterSource.addValue("user_id", trip.getUserId());
			parameterSource.addValue("trip_name", trip.getTripName());
			parameterSource.addValue("trip_details",trip.getTripDetails());
			parameterSource.addValue("total_amount", trip.getTotalAmount());
			parameterSource.addValue("discount_passenger_limit", trip.getDiscountPassengerLimit());
			parameterSource.addValue("discount_percent", trip.getDiscountPercent());
			parameterSource.addValue("depart_from",trip.getDepartFrom());
			parameterSource.addValue("depart_date", trip.getDepartDate());
			parameterSource.addValue("return_date", trip.getReturnDate());
			parameterSource.addValue("depart_time", trip.getDepartTime());
			parameterSource.addValue("night_stay", trip.getNightStay());
			parameterSource.addValue("total_seats", trip.getTotalSeats());
			parameterSource.addValue("available", trip.getAvailable());
			parameterSource.addValue("cost_per_day", trip.getCostPerDay());
			parameterSource.addValue("hotel_price", trip.getHotelPrice());
			parameterSource.addValue("flight_car_cost", trip.getFlightCarCost());
			parameterSource.addValue("drive_or_fly", trip.getDriveOrFly());
			parameterSource.addValue("total_views", trip.getTotalViews());
			parameterSource.addValue("created_date", trip.getCreatedDate());
			parameterSource.addValue("modified_date", trip.getModifiedDate());
		}
		return parameterSource;
	}

	private static final class TripMapper implements RowMapper<Trip> {

		public Trip mapRow(ResultSet rs, int rowNum) throws SQLException {
			Trip trip = new Trip();
			trip.setTripId(rs.getInt("id"));
			trip.setUserId(rs.getInt("user_id"));
			trip.setTripName(rs.getString("trip_name"));
			trip.setTripDetails(rs.getString("trip_details"));
			trip.setTotalAmount(rs.getInt("total_amount"));
			trip.setDiscountPassengerLimit(rs.getInt("discount_passenger_limit"));
			trip.setDiscountPercent(rs.getInt("discount_percent"));
			trip.setDepartFrom(rs.getString("depart_from"));
			trip.setDepartDate(rs.getDate("depart_date"));
			trip.setReturnDate(rs.getDate("return_date"));
			trip.setNightStay(rs.getInt("night_stay"));
			trip.setTotalSeats(rs.getInt("total_seats"));
			trip.setAvailable(rs.getInt("available"));
			trip.setCostPerDay(rs.getInt("cost_per_day"));
			trip.setHotelPrice(rs.getInt("hotel_price"));
			trip.setFlightCarCost(rs.getInt("flight_car_cost"));
			trip.setDriveOrFly(rs.getInt("drive_or_fly"));
			trip.setTotalViews(rs.getInt("total_views"));
			trip.setCreatedDate(rs.getDate("created_date"));
			trip.setModifiedDate(rs.getDate("modified_date"));

			return trip;
		}

	}
	
	@Override
	public List<Trip> getAllTrips() {
		String sql = "SELECT * FROM trip";

		List<Trip> list = namedParameterJdbcTemplate.query(sql, getSqlParameterByModel(null), new TripMapper());

		return list;
	}


	@Override
	public BaseResponse createTrip(Trip trip) {

		String sql = "SELECT * FROM trip WHERE trip_name = :trip_name";
		BaseResponse res = new BaseResponse();
		try {
			List<Trip> list = namedParameterJdbcTemplate.query(sql,
					getSqlParameterByModel(new Trip(trip.getTripName())), new TripMapper());
			if (list.size() > 0) {
				res.setMesssageCode("002");
				res.setMessage("Trip name already exist!");
			} else {
				insertTrip(trip);
				res.setMesssageCode("000");
				res.setMessage("Successful !");

			}
		} catch (Exception e) {
			res.setMesssageCode("003");
			res.setMessage(e.getMessage());
		}

		return res;

	}
	
	public void insertTrip(Trip trip) {
		String sql = "INSERT INTO trip(user_id, trip_name, trip_details, total_amount, discount_passenger_limit, discount_percent, depart_from, depart_date, return_date, depart_time, night_stay, total_seats, available, cost_per_day, hotel_price, flight_car_cost, drive_or_fly, total_views)"+
				" VALUES(:user_id,: trip_name,: trip_details,: total_amount,: discount_passenger_limit,: discount_percent,: depart_from,: depart_date,: return_date,: depart_time,: night_stay,: total_seats,: available,: cost_per_day,: hotel_price,: flight_car_cost,: drive_or_fly,: total_views)";

		namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(trip));
	
	}
	
	@Override
	public BaseResponse updateTrip(Trip trip) {
		String sql = "UPDATE trip SET "+
				" user_id=:user_id,trip_name=: trip_name,trip_details=: trip_details,total_amount=: total_amount,discount_passenger_limit=: discount_passenger_limit,discount_percent=: discount_percent,depart_from=: depart_from,"+
				"depart_date=: depart_date,return_date=: return_date,depart_time=: depart_time,night_stay=: night_stay,total_seats=: total_seats,available=: available,cost_per_day=: cost_per_day,hotel_price=: hotel_price,flight_car_cost=: flight_car_cost,drive_or_fly=: drive_or_fly,total_views=: total_views "+
				" WHERE id = :id";
		BaseResponse res = new BaseResponse();
		int response =namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(trip));

		if (response > 0)
		 res.setMesssageCode("000");
		else
			res.setMesssageCode("002");
		
		return res;
	}
	
	@Override
	public BaseResponse deleteTrip(int id) {
		String sql = "UPDATE trip SET status=0 WHERE id = :id";
		BaseResponse res = new BaseResponse();
		int response =namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(new Trip(id)));
		if (response > 0)
			 res.setMesssageCode("000");
			else
				res.setMesssageCode("002");
			
			return res;
	}
	
	
	
}
