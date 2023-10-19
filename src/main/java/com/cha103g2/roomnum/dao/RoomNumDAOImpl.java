package com.cha103g2.roomNum.dao;

import static  com.cha103g2.util.Constants.PAGE_MAX_RESULT;


import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.cha103g2.roomNum.entity.RoomNum;
import com.cha103g2.util.HibernateUtil;




public class RoomNumDAOImpl implements RoomNumDAO{
	// SessionFactory 為 thread-safe，可宣告為屬性讓請求執行緒們共用
	private SessionFactory factory;
	
	public RoomNumDAOImpl(SessionFactory factory) {
		this.factory = factory;
	}
	// Session 為 not thread-safe，所以此方法在各個增刪改查方法裡呼叫
	// 以避免請求執行緒共用了同個 Session
	private Session getSession() {
		return factory.getCurrentSession();
	}
	//新增資料
	@Override
	public int insert(RoomNum entity) {		
		// 回傳給 service 剛新增成功的自增主鍵值
		return (Integer) getSession().save(entity);
	}
	//更新資料
	@Override
	public int update(RoomNum entity) {
		try {
			getSession().update(entity);
			return 1;
		} catch (Exception e) {
			return -1;
		}
	}
	//刪除資料
	@Override
	public int delete(Integer id) {
		RoomNum rn = getSession().get(RoomNum.class, id);
		if (rn != null) {
			getSession().delete(rn);
			// 回傳給 service，1代表刪除成功
			return 1;
		} else {
			// 回傳給 service，-1代表刪除失敗
			return -1;
		}
		
	}
	//傳回單筆資料
	@Override
	public RoomNum getById(Integer id) {
		return getSession().get(RoomNum.class, id);
	}
	//查詢全部資料
	@Override
	public List<RoomNum> getAll() {
		//from RoomNum (★★★注意這裡的RoomNum指的是類別名稱而不是資料庫名稱)
		return getSession().createQuery("from RoomNum",RoomNum.class).list();
	}
	
	@Override
	public List<RoomNum> getByCompositeQuery(Map<String, String> map) {
		if(map.size()==0) {
			//若前端表單無輸入任何資料表查詢全部資料
			return getAll();
		}
		
		
		
		return null;
	}

	@Override
	public List<RoomNum> getAll(int currentPage) {
		int first = ( currentPage -1) * PAGE_MAX_RESULT;
		return getSession().createQuery("from RoomNum", RoomNum.class)
				.setFirstResult(first)
				.setMaxResults(PAGE_MAX_RESULT)
				.list();
	}

	@Override
	public long getTotal() {
		
		return getSession().createQuery("select count(*) from RoomNum", Long.class).uniqueResult();
	}

}
