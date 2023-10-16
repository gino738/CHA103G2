package com.cha103g2.photoAlbum;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class TestPAHibernateDAO {
	
	public static void main(String[] args) throws IOException {
		//介面                               實作介面的物件
		PhotoAlbumDAO_interface dao = new PhotoAlbumHibernateDAO();
		
		//==新增=================================
		PhotoAlbumVO pa1 = new PhotoAlbumVO();
		pa1.setAlbName("2023全家旅行");
		pa1.setAlbNo(4);
		pa1.setMemNo(104);
		pa1.setAlbDate(java.sql.Date.valueOf("2016-01-01"));
		byte[] pic = getPictureByteArray("./items/family.png");
		pa1.setAlbPhoto(pic);
	
		dao.insert(pa1);
		
		//==修改=================================
//		PhotoAlbumVO pa2 = new PhotoAlbumVO();
//		pa2.setAlbName("2022全家旅行");
//		pa2.setAlbNo(4);
//		pa2.setMemNo(105);
//		pa2.setAlbDate(java.sql.Date.valueOf("2022-01-01"));
//		byte[] pic2 = getPictureByteArray("./items/family2.png");
//		pa2.setAlbPhoto(pic2);
//		
//		dao.update(pa2);
//		System.out.println("更新完成");
		
		//==刪除=================================
//		dao.delete(4);
//		System.out.print(dao.delete(4)); //刪除成功回傳1; 刪除失敗則回傳-1
		
		//==查單筆=================================
//		PhotoAlbumVO pa3 = dao.findByPrimaryKey(1);
//		System.out.println("===========================================================");
//		System.out.print(pa3.getAlbNo() + ",");
//		System.out.print(pa3.getMemNo() + ",");
//		System.out.print(pa3.getAlbName() + ",");
//		System.out.print(pa3.getAlbPhoto() + ",");
//		System.out.print(pa3.getAlbDate());
			
		//==查多筆=================================
//		List<PhotoAlbumVO> list = dao.getAll();
//		System.out.println("===========================================================");
//		for (PhotoAlbumVO pha : list) {
//			System.out.print(pha.getAlbNo() + ",");
//			System.out.print(pha.getMemNo() + ",");
//			System.out.print(pha.getAlbName() + ",");
//			System.out.print(pha.getAlbPhoto() + ",");
//			System.out.print(pha.getAlbDate());
//			System.out.println();			
//		}	
		
	}
	
	//新增圖片的方法============================================================
	public static byte[] getPictureByteArray(String path) throws IOException {
		FileInputStream fis = new FileInputStream(path);
//		byte[] buffer = new byte[fis.available()];
//		fis.read(buffer);
		//JDK 9 上面兩行可以簡化如下一行
		byte[] buffer = fis.readAllBytes();
		
		fis.close();
		return buffer;
	}

}
