package com.cphoto.dao;

import java.util.List;

import com.cphoto.pojo.Photo;
import com.cphoto.pojo.User;
import com.cphoto.pojo.Video;

public interface VideoDao {
	/**
	 *	 添加照片
	 * @param vd
	 */
	boolean insertPhoto(Video vd);
	/**
	 *  	修改照片
	 * @param pt
	 * @return
	 */
	boolean updateVideo(Video vd);
	/**
	 * 	根据照片id 删除照片
	 * @param pg
	 * @return
	 */
	boolean deleteVideo(Video vd);
	/**
	 * 	根据用户id获取该用户所有视频
	 * @param pg
	 * @return
	 */
	List<Photo> selectAllVd(User user);
	/**
	 * 	根据id 批量删除视频
	 * @param list
	 * @return
	 */
	boolean deleteVideo(List<Integer> list);
	
}
