package com.cha103g2.roomNum.service;

import static com.cha103g2.util.Constants.PAGE_MAX_RESULT;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Session;

import com.cha103g2.roomNum.dao.RoomNumDAO;
import com.cha103g2.roomNum.dao.RoomNumDAOImpl;
import com.cha103g2.roomNum.entity.RoomNum;
import com.cha103g2.util.HibernateUtil;
// 沒有使用 JSP / Thymeleaf 等後端渲染畫面模板時，Transaction 置於 Service 商業邏輯層
public class RoomNumServiceImpl2 implements RoomNumService {
	// 一個 service 實體對應一個 dao 實體
	private RoomNumDAO dao;
	
	public RoomNumServiceImpl2() {
		dao = new RoomNumDAOImpl(HibernateUtil.getSessionFactory());
	}
	
	@Override
	public RoomNum addRoomNum(RoomNum RoomNum) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RoomNum updateRoomNum(RoomNum RoomNum) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteRoomNum(Integer RoomNumno) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public RoomNum getRoomNumByRoomNumno(Integer RoomNumno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RoomNum> getAllRoomNums(int currentPage) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			List<RoomNum> list = dao.getAll(currentPage);
			session.getTransaction().commit();
			return list;
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<RoomNum> getRoomNumsByCompositeQuery(Map<String, String[]> map) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Map<String, String> query = new HashMap<>();
		// Map.Entry即代表一組key-value
		Set<Map.Entry<String, String[]>> entry = map.entrySet();
		
		for (Map.Entry<String, String[]> row : entry) {
			String key = row.getKey();
			// 因為請求參數裡包含了action，做個去除動作
			if ("action".equals(key)) {
				continue;
			}
			// 若是value為空即代表沒有查詢條件，做個去除動作
			String value = row.getValue()[0];
			if (value.isEmpty() || value == null) {
				continue;
			}
			query.put(key, value);
		}
		
		System.out.println(query);
		
		try {
			session.beginTransaction();
			List<RoomNum> list = dao.getByCompositeQuery(query);
			session.getTransaction().commit();
			return list;
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
			return null;
		}
	}

	// 計算RoomNum數量每頁3筆的話總共有幾頁
	@Override
	public int getPageTotal() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		int pageQty;
		try {
			session.beginTransaction();
			long total = dao.getTotal();
			pageQty = (int)(total % PAGE_MAX_RESULT == 0 ? (total / PAGE_MAX_RESULT) : (total / PAGE_MAX_RESULT + 1));
			session.getTransaction().commit();
		} catch (Exception e) {
			pageQty = 1;
			session.getTransaction().rollback();
			e.printStackTrace();
		}
		return pageQty;
	}

}
