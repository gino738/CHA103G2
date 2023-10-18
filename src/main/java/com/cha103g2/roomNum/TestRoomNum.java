package com.cha103g2.roomNum;

import java.util.List;
import java.util.Set;
import org.hibernate.Session;

import com.cha103g2.roomNum.entity.RoomNum;
import com.cha103g2.util.HibernateUtil;

 public class TestRoomNum {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {			
			session.beginTransaction();			
//			//雙引號內的RoomNum要對映的是類別名稱，而不是資料庫名稱
			//使用hibernate做查詢
//			List<RoomNum> list = session.createQuery("from RoomNum", RoomNum.class).list();
//			for (RoomNum room : list) {
//				System.out.println(
//					room.getrNum() + "-" + 
//					room.getRoomOrderNo() + "-" +
//					room.getCheckInName() + "-" +
//					room.getRoomStatus()					
//				);
//				System.out.println("===================");	
			//使用原生資料庫語法指令查詢
//			List<RoomNum> list = session.createNativeQuery("SELECT * FROM room_num", RoomNum.class).list();
//			for (RoomNum room : list) {
//				System.out.println(
//					room.getrNum() + "-" + 
//					room.getRoomTypeNo() + "-" +		
//					room.getRoomOrderNo() + "-" +
//					room.getCheckInName() + "-" +
//					room.getRoomStatus()					
//				);			
//			}		
			//使用原生資料庫語法指令查詢
			List<Object[]> resultList = session.createNativeQuery("SELECT * FROM room_num").getResultList();
			for (Object[] row : resultList) {
				
					int rnum = (int) row[0];
					int roomTypeno = (int) row[1];
					int roomOrderno = (int) row[2];
					String checkInname = (String) row[3];
					int roomStatus = (byte) row[4];								
					System.out.println(rnum + ":" + roomTypeno + ":" + roomOrderno +":" + checkInname + ":" + roomStatus);
			}		
			session.getTransaction().commit();			
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			HibernateUtil.shutdown();
		}

	}

}
