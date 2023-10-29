package com.cha103g2.photoAlbum.dao;

import static com.cha103g2.department.service.Constants.PAGE_MAX_RESULT;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.cha103g2.photoAlbum.entity.PhotoAlbumVO;
import com.cha103g2.util.HibernateUtil;
import com.cha103g2.filter.OpenSessionInViewFilter;



public class PhotoAlbumHibernateDAO implements PhotoAlbumDAO_interface{
	//不用再下SQL指令, 載入驅動, 關閉連線
	//不用再pstmt裡set參數
	private SessionFactory factory;

	public PhotoAlbumHibernateDAO(SessionFactory factory) {
		this.factory = factory;
	}
	
	private Session getSession() {
		return factory.getCurrentSession();
	}

	
	//===新增===============================================

	@Override
	public int insert(PhotoAlbumVO phaVO) {
		try {
			getSession().save(phaVO);
			return 1;
		} catch (Exception e) {
			return -1;
		}		 	
	}
	//===修改===============================================
	@Override
	public int update(PhotoAlbumVO phaVO) {
		try {
			getSession().update(phaVO);
			return 1;
		} catch (Exception e) {
			return -1;
		}		
	}
	//===刪除===============================================
	@Override
	public int delete(Integer albNo) {
		PhotoAlbumVO phaVO = getSession().get(PhotoAlbumVO.class, albNo);
		if (phaVO != null) {
			getSession().delete(phaVO);
			// 回傳給 service，1代表刪除成功
			return 1;
		} else {
			// 回傳給 service，-1代表刪除失敗
			return -1;
		}
		
	}
	//===查單筆===============================================
	@Override
	public PhotoAlbumVO findByPrimaryKey(Integer albNo) {
		return getSession().get(PhotoAlbumVO.class, albNo);
	}
	//下拉式選單在用的getAll
	@Override
	public List<PhotoAlbumVO> getAll() {
		List phaList = getSession().createQuery("from PhotoAlbumVO", PhotoAlbumVO.class).list();
		return phaList;
	}
	//===查多筆===============================================
	@Override
	public List<PhotoAlbumVO> getAll(int currentPage) {
		int first = (currentPage - 1) * PAGE_MAX_RESULT;
		return getSession().createQuery("from PhotoAlbumVO", PhotoAlbumVO.class)
				.setFirstResult(first)
				.setMaxResults(PAGE_MAX_RESULT)
				.list();
	}
	
	@Override
	public long getTotal() {
		return getSession().createQuery("select count(*) from PhotoAlbumVO", Long.class).uniqueResult();
	}

	

}
