package com.cphoto.dao;

import java.util.List;

import com.cphoto.pojo.PhotoGraphs;
import com.cphoto.pojo.User;

public interface PhotosDao {
	/**
	 *	 添加相册
	 * @param pg
	 */
	boolean insertPhotos(PhotoGraphs pg)throws Exception;
	/**
	 *  	修改相册
	 * @param pg
	 * @return
	 */
	boolean updatePhotos(PhotoGraphs pg)throws Exception;
	/**
	 * 	删除相册
	 * @param pg
	 * @return
	 * @throws Exception 
	 */
	boolean deletePhotos(PhotoGraphs pg) throws Exception;
	/**
	 * 	根据用户id获取该用户锁有相册
	 * @param user
	 * @return
	 */
	List<PhotoGraphs> selectAllPG(User user)throws Exception;
}
