package com.cphoto.service;

import java.util.List;

import com.cphoto.pojo.PhotoGraphs;
import com.cphoto.pojo.User;

public interface PhotosService {
	/**
	 *	 添加相册
	 * @param pg
	 * @throws Exception 
	 */
	boolean addPhotos(PhotoGraphs pg) throws Exception;
	/**
	 *  	修改相册
	 * @param pg
	 * @return
	 */
	boolean editPhotos(PhotoGraphs pg) throws Exception;
	/**
	 * 	删除相册
	 * @param pg
	 * @return
	 */
	boolean removePhotos(PhotoGraphs pg) throws Exception;
	/**
	 * 	根据用户id获取该用户锁有相册
	 * @param user
	 * @return
	 */
	List<PhotoGraphs> findAllPG(User user) throws Exception;
}
