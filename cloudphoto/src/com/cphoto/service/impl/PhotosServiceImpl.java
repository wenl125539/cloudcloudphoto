package com.cphoto.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.cphoto.dao.PhotoDao;
import com.cphoto.dao.PhotosDao;
import com.cphoto.dao.impl.PhotoDaoImpl;
import com.cphoto.dao.impl.PhotosDaoImpl;
import com.cphoto.pojo.PhotoGraphs;
import com.cphoto.pojo.User;
import com.cphoto.service.PhotosService;

public class PhotosServiceImpl implements PhotosService {

	private PhotosDao photosDao = null;
	private PhotoDao photoDao = null;
	
	public PhotosServiceImpl() {
		
		photosDao = new PhotosDaoImpl();
		photoDao = new PhotoDaoImpl();
	}
	
	@Override
	public boolean addPhotos(PhotoGraphs pg) throws Exception {
		return photosDao.insertPhotos(pg);
	}

	@Override
	public boolean editPhotos(PhotoGraphs pg) throws Exception {
		return photosDao.updatePhotos(pg);
	}

	@Override
	public boolean removePhotos(PhotoGraphs pg) throws Exception {
		photoDao.deletePhotoByPhotosId(pg.getPhotosid());
		boolean flag = photosDao.deletePhotos(pg);
		return flag;
	}

	@Override
	public List<PhotoGraphs> findAllPG(User user)  throws Exception{
		
		List<PhotoGraphs> ps = new ArrayList<>();
		ps = photosDao.selectAllPG(user);
		
		return ps;
	}

}
