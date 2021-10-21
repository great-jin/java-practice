package com.itheima.jdbc;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class AccountDaoImpl implements AccountDao {

	// ����JdbcTemplate���Լ���setter����
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	// ����˻�
	public int addAccount(Account account) {
		// ����SQL
		String sql = "insert into account(username,balance) value(?,?)";
		// �������������SQL����еĲ���
		Object[] obj = new Object[] { account.getUsername(), account.getBalance() };
		// ִ����Ӳ��������ص�����SQL���Ӱ��ļ�¼����

		int num = this.jdbcTemplate.update(sql, obj);
		return num;
	}

	// �����˻�
	public int updateAccount(Account account) {
		// ����SQL
		String sql = "update account set username=?,balance=? where id = ?";
		// �������������SQL����еĲ���
		Object[] params = new Object[] { account.getUsername(), account.getBalance(), account.getId() };
		// ִ����Ӳ��������ص�����SQL���Ӱ��ļ�¼����

		int num = this.jdbcTemplate.update(sql, params);
		return num;
	}

	// ɾ���˻�
	public int deleteAccount(int id) {
		// ����SQL
		String sql = "delete  from account where id = ? ";
		// ִ����Ӳ��������ص�����SQL���Ӱ��ļ�¼����

		int num = this.jdbcTemplate.update(sql, id);
		return num;
	}

	// ͨ��id��ѯ�˻�������Ϣ
	public Account findAccountById(int id) {
		// ����SQL���
		String sql = "select * from account where id = ?";
		// ����һ���µ�BeanPropertyRowMapper����
		RowMapper<Account> rowMapper = new BeanPropertyRowMapper<Account>(Account.class);

		// ��id�󶨵�SQL����У���ͨ��RowMapper����һ��Object���͵ĵ��м�¼
		return this.jdbcTemplate.queryForObject(sql, rowMapper, id);
	}

	// ��ѯ�����˻���Ϣ
	public List<Account> findAllAccount() {
		// ����SQL���
		String sql = "select * from account";
		// ����һ���µ�BeanPropertyRowMapper����
		RowMapper<Account> rowMapper = new BeanPropertyRowMapper<Account>(Account.class);

		// ִ�о�̬��SQL��ѯ����ͨ��RowMapper���ؽ��
		return this.jdbcTemplate.query(sql, rowMapper);
	}
	
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false)
	public void Transfer(String outUser, String inUser, Double money) {
	    // �տ�ʱ���տ��û������ = ������� + ������
	    this.jdbcTemplate.update("update account set balance = balance +? "
	                                       + "where username = ?",money, inUser);
	    // ģ��ϵͳ����ʱ��ͻ��������
	    int i = 1/0;
	    // ���ʱ������û������ = ������� - ������
	    this.jdbcTemplate.update("update account set balance = balance-? " +
	    		"where username = ?", money, outUser );
	}
}
