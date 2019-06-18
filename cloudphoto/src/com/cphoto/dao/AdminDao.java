package com.cphoto.dao;

import java.util.List;

import com.cphoto.pojo.User;

public interface AdminDao {

	
	/**
	 * 	管理员登陆
	 * @param user
	 * @return
	 */
	User selectUser(User user) throws Exception;
	
	/**
	 * 	获取所有用户（管理员）
	 * @return
	 */
	List<User> findAllUser() throws Exception;
}
