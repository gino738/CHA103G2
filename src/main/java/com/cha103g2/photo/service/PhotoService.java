package com.cha103g2.photo.service;

import java.util.List;

import com.cha103g2.photo.model.PhotoVO;


public interface PhotoService {
	void addPhoto(PhotoVO photo);
	
	void updatePhoto(PhotoVO photo);
	
	void deletePhoto(Integer photoNo);
	
	PhotoVO getPhotoByPK(Integer photoNo);

	List<PhotoVO> getAllPhoto(int currentPage);

	int getPageTotal();
	
	void addPhoto(List<PhotoVO> photoList);
	

}
