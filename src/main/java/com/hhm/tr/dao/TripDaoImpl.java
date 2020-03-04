package com.hhm.tr.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import com.hhm.tr.base.BaseResponse;
import com.hhm.tr.model.MoreTrip;
import com.hhm.tr.model.RecommendTrip;
import com.hhm.tr.model.ResponseTripSearchData;
import com.hhm.tr.model.Trip;
import com.hhm.tr.model.TripSearchData;

@Repository
public class TripDaoImpl implements TripDao {

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
			parameterSource.addValue("breakfast", trip.isHaveBreakfast() ? 1 : 0);
			parameterSource.addValue("lunch", trip.isHaveLunch() ? 1 : 0);
			parameterSource.addValue("dinner", trip.isHaveDinner() ? 1 : 0);
			parameterSource.addValue("hotel_type", trip.getHotelType());
			parameterSource.addValue("trip_details", trip.getTripDetails());
			parameterSource.addValue("image", trip.getImage());
			parameterSource.addValue("created_by", trip.getCreatedBy());
			parameterSource.addValue("thing_todo", trip.getThingTodo());
			parameterSource.addValue("trip_price", trip.getTripPrice());
			parameterSource.addValue("discount_passenger_limit", trip.getDiscountPassengerLimit());
			parameterSource.addValue("discount_percent", trip.getDiscountPercent());
			parameterSource.addValue("depart_from", trip.getDepartFrom());
			parameterSource.addValue("arrival", trip.getArrival());
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
			parameterSource.addValue("rating", trip.getRating());
			parameterSource.addValue("total_views", trip.getTotalViews());
			parameterSource.addValue("created_date", new Date());
			parameterSource.addValue("modified_date", new Date());
		}
		return parameterSource;
	}

	private static final class TripMapper implements RowMapper<Trip> {

		public Trip mapRow(ResultSet rs, int rowNum) throws SQLException {
			Trip trip = new Trip();
			trip.setTripId(rs.getInt("id"));
			trip.setUserId(rs.getInt("user_id"));
			trip.setTripName(rs.getString("trip_name"));
			trip.setHaveBreakfast(rs.getInt("breakfast") == 0 ? false : true);
			trip.setHaveLunch(rs.getInt("lunch") == 0 ? false : true);
			trip.setHaveDinner(rs.getInt("dinner") == 0 ? false : true);
			trip.setHotelType(rs.getInt("hotel_type"));
			trip.setTripDetails(rs.getString("trip_details"));
			trip.setImage(rs.getString("image"));
			trip.setCreatedBy(rs.getString("created_by"));
			trip.setThingTodo(rs.getString("thing_todo"));
			trip.setTripPrice(rs.getInt("trip_price"));
			trip.setDiscountPassengerLimit(rs.getInt("discount_passenger_limit"));
			trip.setDiscountPercent(rs.getInt("discount_percent"));
			trip.setDepartFrom(rs.getString("depart_from"));
			trip.setArrival(rs.getString("arrival"));
			trip.setDepartDate(rs.getDate("depart_date"));
			trip.setReturnDate(rs.getDate("return_date"));
			trip.setNightStay(rs.getInt("night_stay"));
			trip.setTotalSeats(rs.getInt("total_seats"));
			trip.setAvailable(rs.getInt("available"));
			trip.setCostPerDay(rs.getInt("cost_per_day"));
			trip.setHotelPrice(rs.getInt("hotel_price"));
			trip.setFlightCarCost(rs.getInt("flight_car_cost"));
			trip.setDriveOrFly(rs.getInt("drive_or_fly"));
			trip.setRating(rs.getDouble("rating"));
			trip.setTotalViews(rs.getInt("total_views"));
			trip.setCreatedDate(rs.getDate("created_date"));
			trip.setModifiedDate(rs.getDate("modified_date"));

			return trip;
		}

	}

	@Override
	public RecommendTrip getAllTrips() {

		RecommendTrip trips = new RecommendTrip();
		String sql = "SELECT * FROM trip where status!=0 order by rating desc LIMIT 5";

		String sql1 = "SELECT * FROM trip where status!=0 order by created_date desc LIMIT 5";

		String sql2 = "SELECT * FROM trip where status!=0 ORDER BY RAND() LIMIT 5";
		try {
			List<Trip> popularList = namedParameterJdbcTemplate.query(sql, getSqlParameterByModel(null),
					new TripMapper());

			List<Trip> recentList = namedParameterJdbcTemplate.query(sql1, getSqlParameterByModel(null),
					new TripMapper());

			List<Trip> recommendList = namedParameterJdbcTemplate.query(sql2, getSqlParameterByModel(null),
					new TripMapper());

			trips.setPopularList(popularList);
			trips.setRecommendList(recommendList);
			trips.setRecentList(recentList);
			trips.setMesssageCode("000");
			trips.setMessage("You are welcome!");
		} catch (Exception e) {
			System.out.println("Error in get all trip trip => " + e.getMessage());
			trips.setMesssageCode("003");
			trips.setMessage(e.getMessage());
		}
		return trips;
	}

	@Override
	public MoreTrip getMoreTrips(int tripType) {

		String sql = "";
		MoreTrip trips = new MoreTrip();
		if (tripType == 1)
			sql = "SELECT * FROM trip where status!=0 order by rating desc";
		else if (tripType == 2)
			sql = "SELECT * FROM trip where status!=0 order by created_date desc";
		else
			sql = "SELECT * FROM trip where status!=0 ORDER BY RAND()";

		try {
			List<Trip> moreList = namedParameterJdbcTemplate.query(sql, getSqlParameterByModel(null), new TripMapper());
			trips.setMoreList(moreList);
			trips.setMesssageCode("000");
			trips.setMessage("You are welcome!");
		} catch (Exception e) {
			System.out.println("Error in more trip => " + e.getMessage());
			trips.setMesssageCode("003");
			trips.setMessage(e.getMessage());
		}
		return trips;
	}

	@Override
	public MoreTrip getTripsByTour(int tourId) {

		MoreTrip trips = new MoreTrip();

		String sql = "SELECT * FROM trip where status!=0 and user_id=" + tourId + " order by created_date desc";

		try {
			// Trip trip = new Trip();
			// trip.setUserId(tourId);
			List<Trip> moreList = namedParameterJdbcTemplate.query(sql, getSqlParameterByModel(null), new TripMapper());
			trips.setMoreList(moreList);
			trips.setMesssageCode("000");
			trips.setMessage("You are welcome!");
		} catch (Exception e) {
			System.out.println("Error in more trip => " + e.getMessage());
			trips.setMesssageCode("003");
			trips.setMessage(e.getMessage());
		}
		return trips;
	}

	@Override
	public ResponseTripSearchData searchTrip(TripSearchData trip) {

		ResponseTripSearchData trips = new ResponseTripSearchData();

		String sql = "";
		String priceQuery = "";
		String thingToDo = "";
		String[] thingToDoArr;

		if (trip.getMinPrice() > 0 && trip.getMaxPrice() > 0)
			priceQuery = "and trip_price >=" + trip.getMinPrice() + " and trip_price <=" + trip.getMaxPrice();
		else if (trip.getMinPrice() > 0)
			priceQuery = "and trip_price >=" + trip.getMinPrice();
		else if (trip.getMaxPrice() > 0)
			priceQuery = "and trip_price <=" + trip.getMaxPrice();

		if (trip.getThingsTodo().length() > 0) {

			thingToDoArr = trip.getThingsTodo().split("#");
			for (int i = 0; i < thingToDoArr.length; i++) {

				if (i == 1) {

					thingToDo = " and ( thing_todo like '%" + thingToDoArr[i] + "%'";
				} else if (i > 1) {

					thingToDo += " or thing_todo like '%" + thingToDoArr[i] + "%'";
				}

			}

			if (thingToDoArr.length > 0)
				thingToDo += " )";
		}

		if (trip.getIsDrive() == 0) {

			sql = "SELECT * FROM trip where status!=0 and drive_or_fly!=2 and depart_date >='"+trip.getDepartDate()+"' and return_date <='"+trip.getReturnDate()+"' and depart_from=:depart_from "
					+ priceQuery + thingToDo + " order by created_date desc";
		} else {

			sql = "SELECT * FROM trip where status!=0 and drive_or_fly=2 and depart_date >='"+trip.getDepartDate()+"' and return_date <='"+trip.getReturnDate()+"' and depart_from=:depart_from "
					+ priceQuery + thingToDo + " order by created_date desc";
		}

		try {
			MapSqlParameterSource parameterSource = new MapSqlParameterSource();
			//parameterSource.addValue("depart_date", trip.getDepartDate());
			//parameterSource.addValue("return_date", trip.getReturnDate());
			parameterSource.addValue("depart_from", trip.getDepartFrom());

			List<Trip> moreList = namedParameterJdbcTemplate.query(sql, parameterSource, new TripMapper());
			trips.setTripList(moreList);
			trips.setMesssageCode("000");
			trips.setMessage("You are welcome!");
		} catch (Exception e) {
			System.out.println("Error in search package => " + e.getMessage());
			trips.setMesssageCode("003");
			trips.setMessage(e.getMessage());
		}
		return trips;
	}

	@Override
	public BaseResponse createTrip(Trip trip) {

		//String sql = "SELECT * FROM trip WHERE status!=0 and trip_name = :trip_name";
		BaseResponse res = new BaseResponse();
		try {
			/*List<Trip> list = namedParameterJdbcTemplate.query(sql,
					getSqlParameterByModel(new Trip(trip.getTripName())), new TripMapper());
			if (list.size() > 0) {
				res.setMesssageCode("002");
				res.setMessage("Trip name already exist!");
			} else {*/
				insertTrip(trip);
				res.setMesssageCode("000");
				res.setMessage("Successful !");

			//}
		} catch (Exception e) {
			System.out.println("Error in create trip => " + e.getMessage());
			res.setMesssageCode("003");
			res.setMessage(e.getMessage());
		}

		return res;

	}

	public void insertTrip(Trip trip) {
		String sql = "INSERT INTO trip(user_id, trip_name, trip_details,image,created_by,thing_todo, trip_price, discount_passenger_limit, discount_percent, depart_from,arrival, depart_date, return_date, depart_time, night_stay,breakfast,lunch,dinner,hotel_type, total_seats, available, cost_per_day, hotel_price, flight_car_cost, drive_or_fly, total_views,created_date)"
				+ " VALUES(:user_id,:trip_name,:trip_details,:image,:created_by,:thing_todo,:trip_price,:discount_passenger_limit,:discount_percent,:depart_from,:arrival,:depart_date,:return_date,:depart_time,:night_stay,:breakfast,:lunch,:dinner,:hotel_type,:total_seats,:available,:cost_per_day,:hotel_price,:flight_car_cost,:drive_or_fly,:total_views,:created_date)";

		namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(trip));

	}

	@Override
	public BaseResponse updateTrip(Trip trip) {
		String sql = "UPDATE trip SET "
				+ " user_id=:user_id,trip_name=:trip_name,trip_details=:trip_details,trip_price=:trip_price,discount_passenger_limit=:discount_passenger_limit,discount_percent=:discount_percent,depart_from=:depart_from,arrival=:arrival,"
				+ "depart_date=:depart_date,return_date=:return_date,depart_time=:depart_time,night_stay=:night_stay,breakfast=:breakfast,lunch=:lunch,dinner=:dinner,hotel_type=:hotel_type,total_seats=:total_seats,available=:available,cost_per_day=:cost_per_day,hotel_price=:hotel_price,flight_car_cost=:flight_car_cost,drive_or_fly=:drive_or_fly,total_views=:total_views "
				+ " WHERE id = :id";
		BaseResponse res = new BaseResponse();
		int response = namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(trip));

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
		int response = namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(new Trip(id)));
		if (response > 0)
			res.setMesssageCode("000");
		else
			res.setMesssageCode("002");

		return res;
	}

}
