package com.cphoto.service;

import java.util.List;

import com.cphoto.pojo.Photo;
import com.cphoto.pojo.User;
import com.cphoto.pojo.Video;

public interface VideoService {
	/**
	 *	 添加照片
	 * @param vd
	 */
	boolean addPhoto(Video vd);
	/**
	 *  	修改照片
	 * @param pt
	 * @return
	 */
	boolean editVideo(Video vd);
	/**
	 * 	根据照片id 删除照片
	 * @param pg
	 * @return
	 */
	boolean removeVideo(Video vd);
	/**
	 * 	根据用户id获取该用户所有视频
	 * @param pg
	 * @return
	 */
	List<Photo> findAllVd(User user);
	/**
	 * 	根据id 批量删除视频
	 * @param list
	 * @return
	 */
	boolean removeVideo(List<Integer> list);
	
}
