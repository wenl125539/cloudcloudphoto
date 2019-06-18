package com.cphoto.dao.impl;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.cphoto.dao.UserDao;
import com.cphoto.pojo.User;
import com.cphoto.utils.JDBCUtils;

public class UserDaoImpl implements UserDao {

	QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
	
	@Override
	public boolean insertUser(User user) throws Exception {
		
		
		String sql = "insert into tuser (userid,password) values(?,?)";
		Object[] params = new Object[]{user.getUserid(),user.getPassword()};
			long i = qr.insert(sql, new ScalarHandler<Long>(), params);
			if(i != 0) {
				return true;
			}else {
				return false;
			}
	}

	@Override
	public boolean deleteUser(User user) throws Exception {
		
			String sql = "delete from tuser where userid=?";
			long i = qr.update(sql,user.getUserid());
			if(i != 0) {
				return true;
			}else {
				return false;
			}
	}

	@Override
	public User selectUser(User user) throws Exception {
		
		String sql = "select id,userid,password,head from tuser where userid=?";
		return qr.query(sql, new BeanHandler<User>(User.class),user.getUserid());
	}

	@Override
	public boolean updateUser(User user)  throws Exception{
		
		String sql = "update tuser set password=? where userid=?";
		long i = qr.update(sql,user.getPassword(),user.getUserid());
		if(i != 0) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public List<User> selectAllUser() throws Exception {
		String sql = "select id,userid,password,head from tuser";
		return qr.query(sql, new BeanListHandler<User>(User.class));
		
	}

	@Override
	public boolean updateUserHead(User user)  throws Exception{
		
		String sql = "update tuser set head=? where userid=?";
		long i = qr.update(sql,user.getHead(),user.getUserid());
		if(i != 0) {
			return true;
		}else {
			return false;
		}
	}
}
