package com.cha103g2.roomNum.service;

import static com.cha103g2.util.Constants.PAGE_MAX_RESULT;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.cha103g2.roomNum.dao.RoomNumDAO;
import com.cha103g2.roomNum.dao.RoomNumDAOImpl;
import com.cha103g2.roomNum.entity.RoomNum;
import com.cha103g2.util.HibernateUtil;

// 搭配 JSP / Thymeleaf 後端渲染畫面，將交易動作至於 view filter
public class RoomNumServiceImpl implements RoomNumService {
	// 一個 service 實體對應一個 dao 實體
	private RoomNumDAO dao;
	
	public RoomNumServiceImpl() {
		dao = new RoomNumDAOImpl(HibernateUtil.getSessionFactory());
	}
	
	@Override
	public RoomNum addRoomNum(RoomNum roomnum) {
		
		return null;
	}

	@Override
	public RoomNum updateRoomNum(RoomNum roomnum) {
		
		return null;
	}

	@Override
	public void deleteRoomNum(Integer rnum) {
				
	}

	@Override
	public RoomNum getRoomNumByRoomNumno(Integer rumn) {
		
		return null;
	}

	@Override
	public List<RoomNum> getAllRoomNums(int currentPage) {
		return dao.getAll(currentPage);
	}

	@Override
	public List<RoomNum> getRoomNumsByCompositeQuery(Map<String, String[]> map) {
		for(String s : map.keySet()) {
			System.out.println(s + "");
			for(String[] ar : map.values()) {
				System.out.println(Arrays.toString(ar));
			}
		}	
		
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
			if (value == null || value.isEmpty()) {   //此寫較好
		//if (value.isRoomNumty() || value == null) { //此寫法有可能變數本身就是null會出現500
				continue;
			}
			query.put(key, value);
		}
		
		System.out.println(query);
		
		return dao.getByCompositeQuery(query);
	}

	@Override
	public int getPageTotal() {
		long total = dao.getTotal();
		// 計算RoomNum數量每頁3筆的話總共有幾頁
		int pageQty = (int)(total % PAGE_MAX_RESULT == 0 ? (total / PAGE_MAX_RESULT) : (total / PAGE_MAX_RESULT + 1));
		return pageQty;
	}

}
