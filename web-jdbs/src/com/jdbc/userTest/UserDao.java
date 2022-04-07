package com.jdbc.userTest;

import com.jdbc.userTest.User;

public interface UserDao {

	// 添加
	public int addUser(User user);

	// 通过id查询
	public User findUserById(int id);
	
	
}
