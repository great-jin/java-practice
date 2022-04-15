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
		// ����SQL
		String sql = "insert into User(ID,UserName,UserPwd) value(?,?,?)";
		// �������������SQL����еĲ���
		Object[] obj = new Object[] { user.getId(), user.getUsername(), user.getUserpwd() };
		// ִ����Ӳ��������ص�����SQL���Ӱ��ļ�¼����
		int num = this.jdbcTemplate.update(sql, obj);
		return num;
	}

	@Override
	public User findUserById(int id) {
		String sql = "select * from User where id = ?";
		
		// ����һ���µ�BeanPropertyRowMapper����
		RowMapper<User> rowMapper = new BeanPropertyRowMapper<User>(User.class);
		
		// ��id�󶨵�SQL����У���ͨ��RowMapper����һ��Object���͵ĵ��м�¼
		return this.jdbcTemplate.queryForObject(sql, rowMapper, id);
	}

}
