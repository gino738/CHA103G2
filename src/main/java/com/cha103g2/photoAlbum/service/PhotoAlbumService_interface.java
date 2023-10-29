package com.cha103g2.photoAlbum.service;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import com.cha103g2.photoAlbum.entity.PhotoAlbumVO;

public interface PhotoAlbumService_interface {
	int addPha(PhotoAlbumVO phaVO);
	
	PhotoAlbumVO updatePha(PhotoAlbumVO phaVO);
	
	void deletePha(Integer albNo);
	
	PhotoAlbumVO getPhaByPK(Integer albNo);
	
	List<PhotoAlbumVO> getAllPha(int currentPage);
	
	int getPageTotal();
	
	List<PhotoAlbumVO> getPhaByCompositeQuery(Map<String, String[]> map);

}
