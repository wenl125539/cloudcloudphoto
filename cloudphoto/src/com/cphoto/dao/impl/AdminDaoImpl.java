package com.cphoto.dao.impl;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.cphoto.dao.AdminDao;
import com.cphoto.pojo.PhotoGraphs;
import com.cphoto.pojo.User;
import com.cphoto.utils.JDBCUtils;

public class AdminDaoImpl implements AdminDao {

	private QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
	
	@Override
	public User selectUser(User user)  throws Exception{

		String sql = "select id,userid,password,head from tuser where userid=?";
		return qr.query(sql, new BeanHandler<User>(User.class),user.getUserid());
		
	}

	@Override
	public List<User> findAllUser() throws Exception {
		String sql = "select id,userid,password,head from tuser";
		return qr.query(sql, new BeanListHandler<User>(User.class));
	}

	
	
}
