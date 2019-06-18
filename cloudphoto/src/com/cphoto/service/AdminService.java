package com.cphoto.service;

import java.util.List;

import com.cphoto.pojo.User;

public interface AdminService {

	
	/**
	 * 	管理员登陆
	 * @param user
	 * @return
	 */
	User findUser(User user);
	
	/**
	 * 	获取所有用户（管理员）
	 * @return
	 */
	List<User> findAllUser();
}
