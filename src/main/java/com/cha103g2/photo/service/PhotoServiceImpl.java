package com.cha103g2.photo.service;

import java.util.List;

import com.cha103g2.photo.model.PhotoDAO_Interface;
import com.cha103g2.photo.model.PhotoHiberbateDAO;
import com.cha103g2.photo.model.PhotoVO;
import com.cha103g2.util.HibernateUtil;

public class PhotoServiceImpl implements PhotoService{
	private PhotoDAO_Interface dao;
	
	public PhotoServiceImpl() {
		dao = new PhotoHiberbateDAO(HibernateUtil.getSessionFactory());
	}

	@Override
	public void addPhoto(PhotoVO photo) {
		dao.insert(photo);
	}

	@Override
	public void updatePhoto(PhotoVO photo) {
		dao.update(photo);
	}

	@Override
	public void deletePhoto(Integer photoNo) {
		dao.delete(photoNo);
		
	}

	@Override
	public PhotoVO getPhotoByPK(Integer photoNo) {
		return dao.findByPrimaryKey(photoNo);
	}

	@Override
	public List<PhotoVO> getAllPhoto(int currentPage) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getPageTotal() {
		// TODO Auto-generated method stub
		return 0;
	}

}
