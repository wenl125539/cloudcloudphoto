package com.cphoto.service.impl;

import java.util.List;

import com.cphoto.cphotoExc.UserException;
import com.cphoto.dao.UserDao;
import com.cphoto.dao.impl.UserDaoImpl;
import com.cphoto.pojo.User;
import com.cphoto.service.UserService;

public class UserServiceImpl implements UserService {

	private UserDao userDao = new UserDaoImpl();
	@Override
	public boolean addUser(User user) throws Exception{
		List<User> users = userDao.selectAllUser();
		for(User user2 : users) {
			if(user2.getUserid().equals(user.getUserid())) {
				throw new UserException("用户名已经存在");
			}
		}
		return userDao.insertUser(user);
	}

	@Override
	public boolean removeUser(User user) throws Exception {
		return userDao.deleteUser(user);
	}

	@Override
	public User findUser(User user) throws Exception {

		 User user2  = userDao.selectUser(user);
		 if(user2 == null) {
			 return null;
		 }else if(user.getPassword().equals(user2.getPassword())) {
			 return user2;	 
		 }
		 return null;
	}

	@Override
	public boolean editUser(User user) throws Exception {
		return userDao.updateUser(user);
	}

	@Override
	public List<User> findAllUser() throws Exception {
		return userDao.selectAllUser();
	}

	@Override
	public boolean updateUserHead(User user) throws Exception {
		return userDao.updateUserHead(user);
	}

	

	
}
