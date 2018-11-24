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
import com.hhm.tr.model.Favourite;

@Repository
public class FavouriteDaoImpl implements FavouriteDao {

	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}
	
	private SqlParameterSource getSqlParameterByModel(Favourite favourite) {

		MapSqlParameterSource parameterSource = new MapSqlParameterSource();
		if (favourite != null) {
			parameterSource.addValue("id", favourite.getFavouriteId());
			parameterSource.addValue("trip_id", favourite.getTripId());
			parameterSource.addValue("save_by",favourite.getSaveBy());

		}
		return parameterSource;
	}

	private static final class FavouriteMapper implements RowMapper<Favourite> {

		public Favourite mapRow(ResultSet rs, int rowNum) throws SQLException {
			Favourite favourite = new Favourite();
			favourite.setFavouriteId(rs.getInt("id"));
			favourite.setTripId(rs.getInt("trip_id"));
			favourite.setSaveBy(rs.getInt("save_by"));		
			return favourite;
		}

	}
	
	@Override
	public List<Favourite> getAllFavouriteById(int id) {
		String sql = "SELECT * FROM favourite  WHERE id = :id";
		List<Favourite> list = namedParameterJdbcTemplate.query(sql, getSqlParameterByModel(new Favourite(id)), new FavouriteMapper());
		return list;
	}
	
	@Override
	public BaseResponse saveFavourite(Favourite favourite) {

		String sql = "SELECT * FROM favourite WHERE id = :id";
		BaseResponse res = new BaseResponse();
		try {
			List<Favourite> list = namedParameterJdbcTemplate.query(sql,
					getSqlParameterByModel(new Favourite(favourite.getFavouriteId())), new FavouriteMapper());
			if (list.size() > 0) {
				res.setMesssageCode("002");
				res.setMessage("Unsave favourite!");
			} else {
				insertFavourite(favourite);
				res.setMesssageCode("000");
				res.setMessage("Save successful !");

			}
		} catch (Exception e) {
			res.setMesssageCode("003");
			res.setMessage(e.getMessage());
		}

		return res;
	}
	
	public BaseResponse insertFavourite(Favourite favourite) {

		String sql = "INSERT INTO favourite(rate_to, rate_by, rating, comment, type) VALUES(:rate_to, :rate_by, :rating, :comment, :type)";

		BaseResponse res = new BaseResponse();
		int response=namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(favourite));

		if (response > 0) {
			res.setMesssageCode("000");
			res.setMessage("Post review successful!");
		} else {
			res.setMesssageCode("002");
			res.setMessage("Post review fail!");
		}

		return res;

	}

}
