package com.jdbc.userTest;

import com.jdbc.userTest.User;

public interface UserDao {

	// ���
	public int addUser(User user);

	// ͨ��id��ѯ
	public User findUserById(int id);
	
	
}
