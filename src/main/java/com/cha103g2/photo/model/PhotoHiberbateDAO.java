package com.cha103g2.photo.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.tool.schema.internal.exec.GenerationTargetToScript;

import com.cha103g2.department.entity.DeptVO;



public class PhotoHiberbateDAO implements PhotoDAO_Interface{
	private SessionFactory factory;
	
	public PhotoHiberbateDAO(SessionFactory factory) {
		this.factory = factory;
	}
	
	private Session getSession() {
		return factory.getCurrentSession();
	}

	@Override
	public void insert(PhotoVO photoVO) {
		getSession().save(photoVO);

	}

	@Override
	public void update(PhotoVO photoVO) {
		getSession().update(photoVO);

	}

	@Override
	public void delete(Integer photoNO) {
		PhotoVO photo = getSession().get(PhotoVO.class, photoNO);
		if (photo != null) {
			getSession().delete(photo);
		}

	}

	@Override
	public PhotoVO findByPrimaryKey(Integer photoNO) {
		return getSession().get(PhotoVO.class, photoNO);
	}

	@Override//用來顯示下拉選單
	public List<PhotoVO> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PhotoVO> getAll(int currentPage) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getTotal() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<PhotoVO> getPhotosList() {
		return getSession().createQuery("from PhotoVO", PhotoVO.class).list();
	}


}
