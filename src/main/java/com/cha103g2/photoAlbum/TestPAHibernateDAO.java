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
		
//		try {
//			pa1.setAlbDate((Date) new SimpleDateFormat("yyyy-MM-dd").parse("2016-08-07"));
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		byte[] pic = getPictureByteArray("items/family.png");
//		pa1.setAlbPhoto(pic);
		
		dao.insert(pa1);
		
		//==查詢=================================
		List<PhotoAlbumVO> list = dao.getAll();
		for (PhotoAlbumVO pha : list) {
			System.out.print(pha.getAlbNo() + ",");
			System.out.print(pha.getMemNo() + ",");
			System.out.print(pha.getAlbName() + ",");
			//System.out.print(pha.getAlbPhoto() + ",");
			System.out.print(pha.getAlbDate() + ",");

			System.out.println();
		}
		
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
