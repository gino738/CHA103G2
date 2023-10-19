package com.cha103g2.roomNum.dao;

import java.util.List;
import java.util.Map;

import com.cha103g2.roomNum.entity.RoomNum;

public interface RoomNumDAO {
	
	int insert(RoomNum entity);
	
	int update(RoomNum entity);
	
	int delete(Integer id);
	
	RoomNum getById(Integer id);
		
	List<RoomNum> getAll();
	
	List<RoomNum> getByCompositeQuery(Map<String, String> map);
	
	List<RoomNum> getAll(int currentPage);	
	
	long getTotal();
	
}

