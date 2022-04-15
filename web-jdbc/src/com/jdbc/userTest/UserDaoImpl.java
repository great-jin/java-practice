package com.jdbc.userTest;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.itheima.jdbc.Account;

public class UserDaoImpl implements UserDao {

	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public int addUser(User user) {
		// 定义SQL
		String sql = "insert into User(ID,UserName,UserPwd) value(?,?,?)";
		// 定义数组来存放SQL语句中的参数
		Object[] obj = new Object[] { user.getId(), user.getUsername(), user.getUserpwd() };
		// 执行添加操作，返回的是受SQL语句影响的记录条数
		int num = this.jdbcTemplate.update(sql, obj);
		return num;
	}

	@Override
	public User findUserById(int id) {
		String sql = "select * from User where id = ?";
		
		// 创建一个新的BeanPropertyRowMapper对象
		RowMapper<User> rowMapper = new BeanPropertyRowMapper<User>(User.class);
		
		// 将id绑定到SQL语句中，并通过RowMapper返回一个Object类型的单行记录
		return this.jdbcTemplate.queryForObject(sql, rowMapper, id);
	}

}
