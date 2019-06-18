package com.cphoto.dao;

import java.util.List;

import com.cphoto.pojo.Photo;
import com.cphoto.pojo.PhotoGraphs;

public interface PhotoDao {
	/**
	 *	 添加照片
	 * @param pt
	 */
	boolean insertPhoto(Photo pt);
	/**
	 *  	根据照片id修改照片
	 * @param pt
	 * @return
	 */
	boolean updatePhoto(Photo pt);
	/**
	 * 	根据照片id 删除照片
	 * @param pg
	 * @return
	 */
	boolean deletePhoto(Photo pt);
	/**
	 * 	根据相册id获取该相册所有照片
	 * @param pg
	 * @return
	 */
	List<Photo> selectAllPt(PhotoGraphs pg);
	/**
	 * 	根据id 批量删除照片
	 * @param list
	 * @return
	 */
	boolean deletePhoto(List<Integer> list);
	
	
	/**
	 *  	根据相册id修改照片
	 * @param id
	 * @return
	 */
	boolean deletePhotoByPhotosId(Long id);
	
}
