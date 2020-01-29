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
import com.hhm.tr.model.Tours;
import com.hhm.tr.model.UserBean;

@Repository
public class UserDaoImpl implements UserDao {

	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	public List<UserBean> listAllUsers() {
		String sql = "SELECT id, email, username,full_name FROM user where user_type=1";

		List<UserBean> list = namedParameterJdbcTemplate.query(sql, getSqlParameterByModel(null), new UserMapper());

		return list;
	}

	@Override
	public Tours listAllTours() {

		String sql = "SELECT * FROM user where user_type=2";
		Tours res = new Tours();
		try {
			List<UserBean> list = namedParameterJdbcTemplate.query(sql, getSqlParameterByModel(null), new UserMapper());
			res.setMesssageCode("000");
			res.setMessage("Successful !");
			res.setTourList(list);
		} catch (Exception e) {
			res.setMesssageCode("003");
			res.setMessage(e.getMessage());
		}
		return res;
	}

	private SqlParameterSource getSqlParameterByModel(UserBean user) {
		MapSqlParameterSource parameterSource = new MapSqlParameterSource();
		if (user != null) {
			parameterSource.addValue("id", user.getId());
			parameterSource.addValue("email", user.getEmail());
			parameterSource.addValue("username", user.getUserName());
			parameterSource.addValue("password", user.getPassword());
			parameterSource.addValue("full_name", user.getFullName());
			parameterSource.addValue("dob", user.getDob());
			parameterSource.addValue("gender", user.getGender());
			parameterSource.addValue("mobile_number", user.getMobileNumber());
			parameterSource.addValue("hobbies", user.getHobbies());
			parameterSource.addValue("user_type", user.getUserType());
			parameterSource.addValue("address", user.getAddress());
			parameterSource.addValue("rating", user.getRating());
			parameterSource.addValue("review_count", user.getReviewCount());
		}
		return parameterSource;
	}

	private static final class UserMapper implements RowMapper<UserBean> {

		public UserBean mapRow(ResultSet rs, int rowNum) throws SQLException {
			UserBean user = new UserBean();
			user.setId(rs.getInt("id"));
			user.setEmail(rs.getString("email"));
			user.setUserName(rs.getString("username"));
			user.setPassword(rs.getString("password"));
			user.setFullName(rs.getString("full_name"));
			user.setDob(rs.getDate("dob"));
			user.setGender(rs.getString("gender"));
			user.setMobileNumber(rs.getString("mobile_number"));
			user.setHobbies(rs.getString("hobbies"));
			user.setUserType(rs.getInt("user_type"));
			user.setAddress(rs.getString("address"));
			user.setRating(rs.getDouble("rating"));
			user.setReviewCount(rs.getInt("review_count"));

			return user;
		}

	}

	@Override
	public void addUser(UserBean user) {
		String sql = "INSERT INTO user(email,username,password, full_name,dob,gender,mobile_number,hobbies,user_type, address) VALUES(:email,:username,:password,:full_name,:dob,:gender,:mobile_number,:hobbies,:user_type,:address)";

		namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(user));

	}

	@Override
	public BaseResponse updateUser(UserBean user) {
		
		String sql = "UPDATE user SET "
				+ " email=:email,username=:username,password=:password,full_name=:full_name,dob=:dob,gender=:gender,mobile_number=:mobile_number,hobbies=:hobbies,"
				+ "user_type=:user_type,address=:address "
				+ " WHERE id = :id";
		
		UserBean res = new UserBean();
		int response = namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(user));

		if (response > 0)
			res.setMesssageCode("000");
		else
			res.setMesssageCode("002");

		return res;
	}

	@Override
	public void deleteUser(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public BaseResponse createUser(UserBean user) {

		String sql = "SELECT * FROM user WHERE username = :username";
		UserBean res = new UserBean();
		try {
			List<UserBean> list = namedParameterJdbcTemplate.query(sql,
					getSqlParameterByModel(new UserBean(user.getUserName())), new UserMapper());
			if (list.size() > 0) {
				list.get(0).setMesssageCode("002");
				list.get(0).setMessage("User already exist !");
				res = list.get(0);
			} else {
				addUser(user);
				res.setMesssageCode("000");
				res.setMessage("Successful !");

			}
		} catch (Exception e) {
			res.setMesssageCode("003");
			res.setMessage(e.getMessage());
		}

		return res;

	}

	@Override
	public UserBean login(UserBean user) {

		String sql = "SELECT * FROM user WHERE username = :username and password = :password";

		UserBean res = new UserBean();
		try {
			List<UserBean> list = namedParameterJdbcTemplate.query(sql, getSqlParameterByModel(user), new UserMapper());
			if (list.size() > 0) {

				list.get(0).setMesssageCode("000");
				list.get(0).setMessage("Successful !");
				return list.get(0);
			} else {
				res.setMesssageCode("002");
				res.setMessage("Invalid username or password");
			}
		} catch (Exception e) {
			res.setMesssageCode("003");
			res.setMessage(e.getMessage());
		}

		return res;
	}

}