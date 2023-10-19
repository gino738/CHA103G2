package com.cha103g2.roomNum.service;

import java.util.List;
import java.util.Map;

import com.cha103g2.roomNum.entity.RoomNum;


public interface RoomNumService {

	RoomNum addRoomNum(RoomNum roomNum);
	
	RoomNum updateRoomNum(RoomNum roomnum);
	
	void deleteRoomNum(Integer rnum);
	
	RoomNum getRoomNumByRoomNumno(Integer rnum);
	
	List<RoomNum> getAllRoomNums(int currentPage);
	
	int getPageTotal();
	
	List<RoomNum> getRoomNumsByCompositeQuery(Map<String, String[]> map);
	
}
