package com.cha103g2.photoAlbum.dao;

import java.util.List;

import org.hibernate.Session;

import com.cha103g2.photoAlbum.entity.PhotoAlbumVO;
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
	//===修改===============================================
	@Override
	public void update(PhotoAlbumVO photoAlbumVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.update(photoAlbumVO);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}	
	}
	//===刪除===============================================
	@Override
	public Integer delete(Integer albNo) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			PhotoAlbumVO paVO = session.get(PhotoAlbumVO.class, albNo);
			if (paVO != null) { //PK找的到這筆資料
				session.delete(paVO);
				System.out.println("成功刪除");
			}
			session.getTransaction().commit();
			return 1; //可以用1 or -1 搭配if涵式看要印回傳成功or失敗
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return -1;
		
	}
	//===查單筆===============================================
	@Override
	public PhotoAlbumVO findByPrimaryKey(Integer albNo) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			PhotoAlbumVO photoAlbumVO = session.get(PhotoAlbumVO.class, albNo); //在PhotoAlbumVO(已設定好Column對應table)中找對應PK是albNo資料
			session.getTransaction().commit();
			return photoAlbumVO;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return null;//找不到PK
	}
	//===查多筆===============================================
	@Override
	public List<PhotoAlbumVO> getAll() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			List<PhotoAlbumVO> list = session.createQuery("from PhotoAlbumVO", PhotoAlbumVO.class).list(); //(createQuery: SQL指令 from 哪個class,類別名稱)
			session.getTransaction().commit();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return null;
	}

	

}
