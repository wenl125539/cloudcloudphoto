package com.cphoto.dao.impl;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.cphoto.dao.PhotosDao;
import com.cphoto.pojo.PhotoGraphs;
import com.cphoto.pojo.User;
import com.cphoto.utils.JDBCUtils;

public class PhotosDaoImpl implements PhotosDao {

	private QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
	@Override
	public boolean insertPhotos(PhotoGraphs pg) {
		 try { 
	         String sql = "insert into photographs(userid,photosname,createtime,photosdesc)"
	         		+ "values(?,?,?,?)";
	         int rows = runner.update(sql,pg.getUserid(),pg.getPhotosname(),pg.getCreatetime(),pg.getPhotosdesc());
	        if(rows>0) {
	        	 return true;
	        }
	         
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		return false;
	}

	@Override
	public boolean updatePhotos(PhotoGraphs pg) {
		 try {
		 String sql = "update photographs set photosname=?,photosdesc=? where photosid=?";
		 int rows = runner.update(sql,pg.getPhotosname(),pg.getPhotosdesc(),pg.getPhotosid());
	        if(rows>0) {
	        	 return true;
	        }
	         
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		return false;
	}

	@Override
	public boolean deletePhotos(PhotoGraphs pg) throws Exception {
		 
			 String sql = "delete from photographs where photosid=?";
			 int rows = runner.update(sql,pg.getPhotosid());
		        if(rows>0) {
		        	 return true;
		        }
		      
		return false;
	}

	@Override
	public List<PhotoGraphs> selectAllPG(User user) {
		
        try {
        	String sql = "select * from photographs where userid=?";
            ResultSetHandler<List<PhotoGraphs>> handler = new BeanListHandler<PhotoGraphs>(PhotoGraphs.class);
            List<PhotoGraphs> phoGraphs = runner.query(sql,handler,user.getId());
            return phoGraphs;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
		return null;
	}

}
