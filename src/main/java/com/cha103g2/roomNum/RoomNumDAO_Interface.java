package com.cha103g2.roomNum;

import java.util.*;

public interface RoomNumDAO_Interface {
	public void insert(RoomNumVO rnvo);
	public void update(RoomNumVO rnvo);
	public void delete(Integer rnvo);
	public RoomNumVO findByPrimaryKey(Integer rnvo);
	public List<RoomNumVO> getAll();	
}
