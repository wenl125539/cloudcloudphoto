package com.cphoto.service;

import java.util.List;

import com.cphoto.pojo.User;

public interface UserService {

	/**
	 * 	添加用户（注册）
	 * @param user
	 * @return
	 * @throws Exception 
	 */
	boolean addUser(User user) throws Exception;
	/**
	 * 	删除用户
	 * @param user
	 * @return
	 * @throws Exception 
	 */
	boolean removeUser(User user) throws Exception;
	/**
	 * 	根据用户id查询用户（登陆）
	 * @param user
	 * @return
	 * @throws Exception 
	 */
	User findUser(User user) throws Exception;
	/**
	 * 	修改用户信息
	 * @param user
	 * @return
	 * @throws Exception 
	 */
	boolean editUser(User user) throws Exception;
	/**
	 * 	获取所有用户（管理员）
	 * @return
	 * @throws Exception 
	 */
	List<User> findAllUser() throws Exception;
	
	
	boolean updateUserHead(User user) throws Exception;
}
