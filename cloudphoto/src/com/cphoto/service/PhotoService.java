package com.cphoto.service;

import java.util.List;

import com.cphoto.pojo.Photo;
import com.cphoto.pojo.PhotoGraphs;

public interface PhotoService {
	/**
	 *	 添加照片
	 * @param pt
	 */
	boolean addPhoto(Photo pt);
	/**
	 *  	修改照片
	 * @param pt
	 * @return
	 */
	boolean editPhoto(Photo pt);
	/**
	 * 	根据照片id 删除照片
	 * @param pg
	 * @return
	 */
	boolean removePhoto(Photo pt);
	/**
	 * 	根据相册id获取该相册所有照片
	 * @param pg
	 * @return
	 */
	List<Photo> findAllPt(PhotoGraphs pg);
	/**
	 * 	根据id 批量删除照片
	 * @param list
	 * @return
	 */
	boolean removePhoto(List<Integer> list);
	
}
