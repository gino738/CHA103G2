package com.cha103g2.roomCalendar;

import java.util.*;

public interface RoomCalendarDAO_interface {
	public void insert(RoomCalendarVO rcvo);
	public void update(RoomCalendarVO rcvo);
	public void delete(Integer rcvo);
	public RoomCalendarVO findByPrimaryKey(Integer rcvo);
	public List<RoomCalendarVO> getAll();	
}
