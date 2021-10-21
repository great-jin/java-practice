package com.itheima.jdbc;

import java.util.List;

public interface AccountDao {

	public int addAccount(Account account);

	public int updateAccount(Account account);

	public int deleteAccount(int id);

	public Account findAccountById(int id);

	public List<Account> findAllAccount();

	public void Transfer(String outUser, String inUser, Double money);

}
