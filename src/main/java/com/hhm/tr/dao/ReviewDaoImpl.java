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
			parameterSource.addValue("rating", review.getRating());
			parameterSource.addValue("comment", review.getComment());
			parameterSource.addValue("type", review.getType());

		}
		return parameterSource;
	}

	private static final class ReviewMapper implements RowMapper<Review> {

		public Review mapRow(ResultSet rs, int rowNum) throws SQLException {
			Review review = new Review();
			review.setReviewId(rs.getInt("id"));
			review.setRateTo(rs.getInt("rate_to"));
			review.setRateBy(rs.getInt("rate_by"));
			review.setRating(rs.getInt("rating"));
			review.setComment(rs.getString("comment"));
			review.setType(rs.getInt("type"));
			review.setCreatedDate(rs.getDate("created_date"));
			review.setModifiedDate(rs.getDate("modified_date"));

			return review;
		}

	}

	@Override
	public List<Review> getAllReviewById(int id) {
		String sql = "SELECT * FROM review  WHERE id = :id";

		List<Review> list = namedParameterJdbcTemplate.query(sql, getSqlParameterByModel(new Review(id)), new ReviewMapper());

		return list;
	}

	@Override
	public BaseResponse postReview(Review review) {

		String sql = "INSERT INTO review(rate_to, rate_by, rating, comment, type) VALUES(:rate_to, :rate_by, :rating, :comment, :type)";

		BaseResponse res = new BaseResponse();
		int response = namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(review));

		if (response > 0) {
			res.setMesssageCode("000");
			res.setMessage("Post review successful!");
		} else {
			res.setMesssageCode("002");
			res.setMessage("Post review fail!");
		}

		return res;

	}
	
	@Override
	public BaseResponse deleteReview(int id) {
		String sql = "UPDATE trip SET status=0 WHERE id = :id";
		BaseResponse res = new BaseResponse();
		int response =namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(new Review(id)));
		if (response > 0)
			 res.setMesssageCode("000");
			else
				res.setMesssageCode("002");
			
			return res;
	}
	

}
