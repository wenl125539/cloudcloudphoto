package com.cphoto.dao.impl;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;

import com.cphoto.dao.PhotoDao;
import com.cphoto.pojo.Photo;
import com.cphoto.pojo.PhotoGraphs;
import com.cphoto.utils.JDBCUtils;

public class PhotoDaoImpl implements PhotoDao {

	private QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
	@Override
	public boolean insertPhoto(Photo pt) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updatePhoto(Photo pt) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deletePhoto(Photo pt) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Photo> selectAllPt(PhotoGraphs pg) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deletePhoto(List<Integer> list) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deletePhotoByPhotosId(Long id) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
}
