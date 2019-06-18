package com.cphoto.test;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.junit.Before;
import org.junit.Test;

import com.cphoto.dao.UserDao;
import com.cphoto.dao.impl.UserDaoImpl;
import com.cphoto.pojo.User;
import com.cphoto.service.UserService;
import com.cphoto.service.impl.UserServiceImpl;
import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConTest {
	private ComboPooledDataSource cpds;
	
	@Before
	public void before() {
		cpds = new ComboPooledDataSource();
	}
	
	@Test
	public void getCon() {
		
		try {	
			QueryRunner r = new QueryRunner(cpds);
			/**
			 *    备注：DbUtils给我们提供了10个ResultSetHandler实现类，分别是：
			
			     ①ArrayHandler：     将查询结果的第一行数据，保存到Object数组中
			
			     ②ArrayListHandler     将查询的结果，每一行先封装到Object数组中，然后将数据存入List集合
			
			     ③BeanHandler     将查询结果的第一行数据，封装到user对象
			
			     ④BeanListHandler     将查询结果的每一行封装到user对象，然后再存入List集合
			
			     ⑤ColumnListHandler     将查询结果的指定列的数据封装到List集合中
			
			     ⑥MapHandler     将查询结果的第一行数据封装到map结合（key==列名，value==列值）
			
			     ⑦MapListHandler     将查询结果的每一行封装到map集合（key==列名，value==列值），再将map集合存入List集合
			
			     ⑧BeanMapHandler     将查询结果的每一行数据，封装到User对象，再存入mao集合中（key==列名，value==列值）
			
			     ⑨KeyedHandler     将查询的结果的每一行数据，封装到map1（key==列名，value==列值 ），然后将map1集合（有多个）存入map2集合（只有一个）
			
			     ⑩ScalarHandler     封装类似count、avg、max、min、sum......函数的执行结果
			
			 
			
			 
			
			    以上10个ResultSetHandler实现类，常用的是BeanHandler、BeanListHandler和ScalarHandler，下面将对这三个实现类，写测试类
			 */
			
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		
	}
	
	
	@Test
	public void addUser() {
		User user  = new User();
		user.setPassword("aaaaa");
		user.setUserid("vvvvv");
		
		UserService service = new UserServiceImpl();
		boolean flag;
		try {
			flag = service.addUser(user);
			System.out.println(flag);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void login() {
		User user  = new User();
		user.setUserid("a");
		user.setPassword("123456");
		UserService service = new UserServiceImpl();
	
		try {
			User user2 =  service.findUser(user);
			if(user2 == null) {
				System.out.println("用户不存在");
			}else {
				System.out.println(user2.toString());
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void deleteUser() {
		User user  = new User();
		user.setUserid("assad");
		UserDao dao = new UserDaoImpl();
		boolean flag;
		try {
			flag = dao.deleteUser(user);
			System.out.println(flag);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void selectUser() {
		User user  = new User();
		user.setUserid("a");
		UserDao dao = new UserDaoImpl();
	
		try {
			User user2 =  dao.selectUser(user);
			if(user2 == null) {
				System.out.println("用户不存在");
			}else {
				System.out.println(user2.toString());
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	@Test
	public void updateUser() {
		User user  = new User();
		user.setUserid("aa");
		user.setPassword("123456");
		UserDao dao = new UserDaoImpl();

		try {
			System.out.println(dao.updateUser(user));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	@Test
	public void updateUserHead() {
		User user  = new User();
		user.setUserid("a");
		user.setHead("123456");
		UserDao dao = new UserDaoImpl();

		try {
			System.out.println(dao.updateUserHead(user));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
