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
import com.hhm.tr.model.Review;

@Repository
public class ReviewDaoImpl implements ReviewDao {

	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	private SqlParameterSource getSqlParameterByModel(Review review) {

		MapSqlParameterSource parameterSource = new MapSqlParameterSource();
		if (review != null) {
			parameterSource.addValue("id", review.getReviewId());
			parameterSource.addValue("rate_to", review.getRateTo());
			parameterSource.addValue("rate_by", review.getRateBy());
			parameterSource.addValue("rate_by_name", review.getRateByName());
			parameterSource.addValue("rating", review.getRating());		
			parameterSource.addValue("comment", review.getComment());
			parameterSource.addValue("type", review.getType());
			parameterSource.addValue("created_date", review.getCreatedDate());
			parameterSource.addValue("modified_date", review.getModifiedDate());

		}
		return parameterSource;
	}

	private static final class ReviewMapper implements RowMapper<Review> {

		public Review mapRow(ResultSet rs, int rowNum) throws SQLException {
			Review review = new Review();
			review.setReviewId(rs.getInt("id"));
			review.setRateTo(rs.getInt("rate_to"));
			review.setRateBy(rs.getInt("rate_by"));
			review.setRateByName(rs.getString("rate_by_name"));
			review.setRating(rs.getInt("rating"));
			review.setComment(rs.getString("comment"));
			review.setType(rs.getInt("type"));
			review.setCreatedDate(rs.getDate("created_date"));
			review.setModifiedDate(rs.getDate("modified_date"));

			return review;
		}

	}
	
	private static final class ReviewTripMapper implements RowMapper<Review> {

		public Review mapRow(ResultSet rs, int rowNum) throws SQLException {
			Review review = new Review();
			review.setTotalRating(rs.getDouble("rating"));
			review.setRow(rs.getInt("row"));
	
			return review;
		}

	}

	private SqlParameterSource getSqlParameterByTripModel(Review review,int tripId) {

		MapSqlParameterSource parameterSource = new MapSqlParameterSource();
		if (review != null) {
			parameterSource.addValue("id", tripId);
			parameterSource.addValue("rating", review.getTotalRating());
			parameterSource.addValue("total_views", review.getRow());	

		}
		return parameterSource;
	}

	
	@Override
	public Review getAllReviewById(int rateTo,int rateBy) {
		String sql = "SELECT * FROM review  WHERE rate_by = :rate_by and rate_to=:rate_to and type=0";

		List<Review> list = namedParameterJdbcTemplate.query(sql, getSqlParameterByModel(new Review(rateTo,rateBy)),
				new ReviewMapper());
		Review empty=new Review();
		empty.setReviewId(0);
		return list.size() > 0 ? list.get(0) : empty;
	}
	
	@Override
	public Review getTourAllReviewById(int rateTo,int rateBy) {
		String sql = "SELECT * FROM review  WHERE rate_by = :rate_by and rate_to=:rate_to and type=1";

		List<Review> list = namedParameterJdbcTemplate.query(sql, getSqlParameterByModel(new Review(rateTo,rateBy)),
				new ReviewMapper());
		Review empty=new Review();
		empty.setReviewId(0);
		return list.size() > 0 ? list.get(0) : empty;
	}

	@Override
	public List<Review> getAllReviews(int id) {
		String sql = "SELECT * FROM review  where status=1 and rate_to=:rate_to and type=0 order by created_date desc";

		List<Review> list = namedParameterJdbcTemplate.query(sql, getSqlParameterByModel(new Review(id)), new ReviewMapper());

		return list;
	}
	
	@Override
	public List<Review> getReviewsByUserId(int userId) {
		String sql = "SELECT * FROM review  where status=1 and rate_by=:rate_by and type=0 order by created_date desc";
		
		Review review = new Review();
		review.setRateBy(userId);
		List<Review> list = namedParameterJdbcTemplate.query(sql, getSqlParameterByModel(review), new ReviewMapper());

		return list;
	}

	@Override
	public BaseResponse postReview(Review review) {

		if (isExistingReview(review) == null) {
			String sql = "INSERT INTO review(rate_to, rate_by,rate_by_name, rating, comment, type,created_date,modified_date) VALUES(:rate_to, :rate_by,:rate_by_name, :rating, :comment, :type,:created_date,:modified_date)";

			BaseResponse res = new BaseResponse();
			int response = namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(review));

			if (response > 0) {
				triggerTrip(review);
				res.setMesssageCode("000");
				res.setMessage("Post review successful!");
			} else {
				res.setMesssageCode("002");
				res.setMessage("Post review fail!");
			}

			return res;
		} else {
			String sql = "UPDATE review SET rating=:rating,comment=:comment,rate_by_name=:rate_by_name,created_date=:created_date WHERE rate_by = :rate_by";
			BaseResponse res = new BaseResponse();
			int response = namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(review));
			if (response > 0) {
				triggerTrip(review);
				res.setMesssageCode("000");
				res.setMessage("Post review successful!");
			} else
				res.setMesssageCode("002");

			return res;
		}

	}

	public Review isExistingReview(Review review) {
		String sql = "SELECT * FROM review  WHERE rate_by = :rate_by and rate_to = :rate_to and type=0";

		List<Review> list = namedParameterJdbcTemplate.query(sql,
				getSqlParameterByModel(new Review(review.getRateTo(),review.getRateBy())), new ReviewMapper());
			

		return list.size() > 0 ? list.get(0) :null;
	}
	
	public void triggerTrip(Review review) {
		String sql = "SELECT count(*) as row,SUM(rating)/count(*) as rating FROM review  WHERE rate_to = :rate_to and type=0";

		List<Review> list = namedParameterJdbcTemplate.query(sql,
				getSqlParameterByModel(new Review(review.getRateTo(),review.getRateBy())), new ReviewTripMapper());
			
		if(list.size()>0) {
			Review result=list.get(0);
			String tripSql = "UPDATE trip SET rating=:rating,total_views=:total_views WHERE id = :id";
			 namedParameterJdbcTemplate.update(tripSql, getSqlParameterByTripModel(result,review.getRateTo()));
		}
		
	}


	@Override
	public BaseResponse deleteReview(int id) {
		String sql = "UPDATE trip SET status=0 WHERE id = :id";
		BaseResponse res = new BaseResponse();
		int response = namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(new Review(id)));
		if (response > 0)
			res.setMesssageCode("000");
		else
			res.setMesssageCode("002");

		return res;
	}

}
