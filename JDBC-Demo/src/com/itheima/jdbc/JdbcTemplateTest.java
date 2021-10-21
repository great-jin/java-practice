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

		// 事务处理
		// annotationTest();
	}

	public static void createTable() {
		// 加载配置文件
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(path);
		// 获取JdbcTemplate实例
		JdbcTemplate jdTemplate = (JdbcTemplate) applicationContext.getBean("jdbcTemplate");

		// 使用execute()方法执行SQL语句，创建用户账户管理表account
		jdTemplate.execute("create table account(id int primary key auto_increment," + "username varchar(50),"
				+ "balance double)");
		System.out.println("账户表account创建成功！");
	}

	public static void addAccountTest() {
		// 加载配置文件
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(path);
		// 获取AccountDao实例
		AccountDao accountDao = (AccountDao) applicationContext.getBean("accountDao");

		// 创建Account对象，并向Account对象中添加数据
		Account account = new Account();
		account.setUsername("tom");
		account.setBalance(1000.00);

		// 执行addAccount()方法，并获取返回结果
		int num = accountDao.addAccount(account);
		if (num > 0) {
			System.out.println("成功插入了" + num + "条数据！");
		} else {
			System.out.println("插入操作执行失败！");
		}
	}

	public static void updateAccountTest() {
		// 加载配置文件
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(path);
		// 获取AccountDao实例
		AccountDao accountDao = (AccountDao) applicationContext.getBean("accountDao");

		// 创建Account对象，并向Account对象中添加数据
		Account account = new Account();
		account.setId(1);
		account.setUsername("tom");
		account.setBalance(2000.00);

		// 执行updateAccount()方法，并获取返回结果
		int num = accountDao.updateAccount(account);
		if (num > 0) {
			System.out.println("成功修改了" + num + "条数据！");
		} else {
			System.out.println("修改操作执行失败！");
		}
	}

	public static void deleteAccountTest() {
		// 加载配置文件
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(path);
		// 获取AccountDao实例
		AccountDao accountDao = (AccountDao) applicationContext.getBean("accountDao");

		// 执行deleteAccount()方法，并获取返回结果
		int num = accountDao.deleteAccount(2);
		if (num > 0) {
			System.out.println("成功删除了" + num + "条数据！");
		} else {
			System.out.println("删除操作执行失败！");
		}
	}

	public static void findAccountByIdTest() {
		// 加载配置文件
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(path);
		// 获取AccountDao实例
		AccountDao accountDao = (AccountDao) applicationContext.getBean("accountDao");
		// 执行findAccountById()方法
		Account account = accountDao.findAccountById(1);
		System.out.println(account);
	}

	private static void findAllAcount() {
		List<Account> list = null;
		
		List list1 = null;
		
		// 加载配置文件
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(path);
		// 获取AccountDao实例
		AccountDao accountDao = (AccountDao) applicationContext.getBean("accountDao");
		
		// 执行findAllAccount()方法
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

		// 获取AccountDao实例
		AccountDao accountDao = (AccountDao) applicationContext.getBean("accountDao");

		// 创建Account对象，并向Account对象中添加数据
		Account account = new Account();
		account.setUsername("Jack");
		account.setBalance(1500.00);

		// 执行addAccount()方法，并获取返回结果
		int num = accountDao.addAccount(account);
		if (num > 0) {
			System.out.println("成功插入了" + num + "条数据！");
		} else {
			System.out.println("插入操作执行失败！");
		}

		// 创建Account对象，并向Account对象中添加数据
		Account account2 = new Account();
		account2.setUsername("Rose");
		account2.setBalance(1000.00);

		// 执行addAccount()方法，并获取返回结果
		num = accountDao.addAccount(account2);
		if (num > 0) {
			System.out.println("成功插入了" + num + "条数据！");
		} else {
			System.out.println("插入操作执行失败！");
		}

		// 调用实例中的转账方法
		accountDao.Transfer("Jack", "Rose", 100.0);
		// 输出提示信息
		System.out.println("转账成功！");
	}

}
