package com.jdbc.userTest;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.itheima.jdbc.Account;
import com.itheima.jdbc.AccountDao;

public class UserInstance {
	private static String path="com/jdbc/userTest/user.xml";

	public static void main(String[] args) {
		
		int id,search;
		String name,pwd;

		Scanner scanf = new Scanner(System.in);
        System.out.print("Please type your ID£º"); 
        id = scanf.nextInt();
        System.out.print("Please type your Name£º"); 
        name = scanf.next(); 
        System.out.print("Please type your Password£º");
        pwd = scanf.next(); 
        
        InsertUser(id,name,pwd);
        
        System.out.print("Please type your ID£º"); 
        search = scanf.nextInt();
        scanf.close();
        
        findUserById(search);
        
	}
	
	public static void createTable(){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(path);
		
		// »ñÈ¡JdbcTemplateÊµÀý
		JdbcTemplate jdTemplate = (JdbcTemplate) applicationContext.getBean("jdbcTemplate");
				
		jdTemplate.execute("create table User(ID int primary key,"
				+" UserName varchar(20),"
				+"UserPwd varchar(30))");
	}
	
	public static void InsertUser(int id,String name,String pwd) {

	    ApplicationContext applicationContext = new ClassPathXmlApplicationContext(path);
	    UserDao userDao = (UserDao) applicationContext.getBean("userDao");
	    
	    User user = new User();
	    user.setId(id);
	    user.setUsername(name);
	    user.setUserpwd(pwd);

	    int num = userDao.addUser(user);
	    if (num > 0) {
	    	System.out.println("Register Success!");
	    } else {
	    	System.out.println("Register faild!");
	    }
	}
	
	public static void findUserById(int id) {
	    ApplicationContext applicationContext = new ClassPathXmlApplicationContext(path);
	    UserDao userDao = (UserDao) applicationContext.getBean("userDao");

	    User user = userDao.findUserById(id);
		System.out.print(user); 
	}
	
}
