package com.itheima.jdbc;

import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcTemplateTest {

	private static String path = "com/itheima/jdbc/account.xml";

	public static void main(String[] args) {
		
		// createTable();

		// addAccountTest();

		// updateAccountTest();

		// findAccountByIdTest();

		// findAllAcount();

		 deleteAccountTest();

		// ������
		// annotationTest();
	}

	public static void createTable() {
		// ���������ļ�
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(path);
		// ��ȡJdbcTemplateʵ��
		JdbcTemplate jdTemplate = (JdbcTemplate) applicationContext.getBean("jdbcTemplate");

		// ʹ��execute()����ִ��SQL��䣬�����û��˻������account
		jdTemplate.execute("create table account(id int primary key auto_increment," + "username varchar(50),"
				+ "balance double)");
		System.out.println("�˻���account�����ɹ���");
	}

	public static void addAccountTest() {
		// ���������ļ�
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(path);
		// ��ȡAccountDaoʵ��
		AccountDao accountDao = (AccountDao) applicationContext.getBean("accountDao");

		// ����Account���󣬲���Account�������������
		Account account = new Account();
		account.setUsername("tom");
		account.setBalance(1000.00);

		// ִ��addAccount()����������ȡ���ؽ��
		int num = accountDao.addAccount(account);
		if (num > 0) {
			System.out.println("�ɹ�������" + num + "�����ݣ�");
		} else {
			System.out.println("�������ִ��ʧ�ܣ�");
		}
	}

	public static void updateAccountTest() {
		// ���������ļ�
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(path);
		// ��ȡAccountDaoʵ��
		AccountDao accountDao = (AccountDao) applicationContext.getBean("accountDao");

		// ����Account���󣬲���Account�������������
		Account account = new Account();
		account.setId(1);
		account.setUsername("tom");
		account.setBalance(2000.00);

		// ִ��updateAccount()����������ȡ���ؽ��
		int num = accountDao.updateAccount(account);
		if (num > 0) {
			System.out.println("�ɹ��޸���" + num + "�����ݣ�");
		} else {
			System.out.println("�޸Ĳ���ִ��ʧ�ܣ�");
		}
	}

	public static void deleteAccountTest() {
		// ���������ļ�
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(path);
		// ��ȡAccountDaoʵ��
		AccountDao accountDao = (AccountDao) applicationContext.getBean("accountDao");

		// ִ��deleteAccount()����������ȡ���ؽ��
		int num = accountDao.deleteAccount(2);
		if (num > 0) {
			System.out.println("�ɹ�ɾ����" + num + "�����ݣ�");
		} else {
			System.out.println("ɾ������ִ��ʧ�ܣ�");
		}
	}

	public static void findAccountByIdTest() {
		// ���������ļ�
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(path);
		// ��ȡAccountDaoʵ��
		AccountDao accountDao = (AccountDao) applicationContext.getBean("accountDao");
		// ִ��findAccountById()����
		Account account = accountDao.findAccountById(1);
		System.out.println(account);
	}

	private static void findAllAcount() {
		List<Account> list = null;
		
		List list1 = null;
		
		// ���������ļ�
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(path);
		// ��ȡAccountDaoʵ��
		AccountDao accountDao = (AccountDao) applicationContext.getBean("accountDao");
		
		// ִ��findAllAccount()����
		list = accountDao.findAllAccount();
		System.out.println("this is list:"+list);
		
		if (list != null && list.size() > 0) {
			for(Account account : list){
				System.out.println(account.getUsername());
			}
		}
	}

	public static void annotationTest() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(path);

		// ��ȡAccountDaoʵ��
		AccountDao accountDao = (AccountDao) applicationContext.getBean("accountDao");

		// ����Account���󣬲���Account�������������
		Account account = new Account();
		account.setUsername("Jack");
		account.setBalance(1500.00);

		// ִ��addAccount()����������ȡ���ؽ��
		int num = accountDao.addAccount(account);
		if (num > 0) {
			System.out.println("�ɹ�������" + num + "�����ݣ�");
		} else {
			System.out.println("�������ִ��ʧ�ܣ�");
		}

		// ����Account���󣬲���Account�������������
		Account account2 = new Account();
		account2.setUsername("Rose");
		account2.setBalance(1000.00);

		// ִ��addAccount()����������ȡ���ؽ��
		num = accountDao.addAccount(account2);
		if (num > 0) {
			System.out.println("�ɹ�������" + num + "�����ݣ�");
		} else {
			System.out.println("�������ִ��ʧ�ܣ�");
		}

		// ����ʵ���е�ת�˷���
		accountDao.Transfer("Jack", "Rose", 100.0);
		// �����ʾ��Ϣ
		System.out.println("ת�˳ɹ���");
	}

}
