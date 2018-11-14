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

import com.hhm.tr.model.User;
import com.hhm.tr.model.UserBean;


@Repository
public class UserDaoImpl implements UserDao {

	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	public List<UserBean> listAllUsers() {
		String sql = "SELECT id, email, name FROM user";

		List list = namedParameterJdbcTemplate.query(sql, getSqlParameterByModel(null), new UserMapper());

		return list;
	}

	private SqlParameterSource getSqlParameterByModel(User user) {
		MapSqlParameterSource parameterSource = new MapSqlParameterSource();
		if (user != null) {
			parameterSource.addValue("id", user.getId());
			parameterSource.addValue("email", user.getEmail());
			parameterSource.addValue("name", user.getName());	
		}
		return parameterSource;
	}

	private static final class UserMapper implements RowMapper {

		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			User user = new User();
			user.setId(rs.getInt("id"));
			user.setEmail(rs.getString("email"));
			user.setName(rs.getString("name"));

			return user;
		}

	}

	@Override
	public void addUser(UserBean user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateUser(UserBean user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUser(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public UserBean findUserById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	 

 
	 

}