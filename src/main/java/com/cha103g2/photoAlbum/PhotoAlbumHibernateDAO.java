package com.cha103g2.photoAlbum;

import java.util.List;

import org.hibernate.Session;


import com.cha103g2.util.HibernateUtil;

public class PhotoAlbumHibernateDAO implements PhotoAlbumDAO_interface{
	//不用再下SQL指令, 載入驅動, 關閉連線
	//不用再pstmt裡set參數
	
	//===新增===============================================

	@Override
	public void insert(PhotoAlbumVO photoAlbumVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			Integer id = (Integer) session.save(photoAlbumVO);
			session.getTransaction().commit();
	
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}

	}

	@Override
	public void update(PhotoAlbumVO photoAlbumVO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer albNo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PhotoAlbumVO findByPrimaryKey(Integer albNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PhotoAlbumVO> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
