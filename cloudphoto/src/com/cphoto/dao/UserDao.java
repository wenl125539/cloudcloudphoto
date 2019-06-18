package com.cphoto.dao;

import java.sql.SQLException;
import java.util.List;

import com.cphoto.pojo.User;

public interface UserDao {

	/**
	 * 	添加用户（注册）
	 * @param user
	 * @return
	 * @throws SQLException 
	 */
	boolean insertUser(User user) throws Exception;
	/**
	 * 	删除用户
	 * @param user
	 * @return
	 * @throws SQLException 
	 */
	boolean deleteUser(User user) throws Exception;
	/**
	 * 	根据用户id查询用户（登陆）
	 * @param user
	 * @return
	 * @throws Exception 
	 */
	User selectUser(User user) throws Exception;
	/**
	 * 	修改用户信息
	 * @param user
	 * @return
	 * @throws Exception 
	 */
	boolean updateUser(User user) throws Exception;
	/**
	 * 	获取所有用户（管理员）
	 * @return
	 */
	List<User> selectAllUser() throws Exception;
	
	
	boolean updateUserHead(User user) throws Exception;
}
