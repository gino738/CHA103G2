package com.cha103g2.photo.controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.util.List;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.cha103g2.photo.service.PhotoService;
import com.cha103g2.photo.service.PhotoServiceImpl;
import com.cha103g2.photoAlbum.entity.PhotoAlbumVO;
import com.cha103g2.photo.model.PhotoVO;


@WebServlet("/pho.do")
@MultipartConfig
public class PhotoServlet extends HttpServlet {
	private PhotoService photoSvc;
	//private PhotoAlbumService phaSvc;
	// 一個 servlet 實體對應一個 service 實體
	public void init() throws ServletException {
		photoSvc = new PhotoServiceImpl();
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		String forwardPath = "";
		
		//新增相片===================================================
		if("insert".equals(action)) {
			//待處理錯誤處理
			
			
			
			/***************************1.接收請求參數****************************************/
			Integer albNo = Integer.valueOf(req.getParameter("albNo"));
			Date photoDate = Date.valueOf(req.getParameter("photoDate"));

			System.out.println("**servlet===================="+albNo);//***
			String photoName1 = req.getParameter("photoName1").trim();		
			String photoName2 = req.getParameter("photoName2").trim();
			byte[] photo1 = null;
			byte[] photo2 = null;
			
			Part part1 = req.getPart("photo1");
			InputStream is1 = part1.getInputStream();
			photo1 = new byte[is1.available()];
			is1.read(photo1);
			is1.close();
			
			Part part2 = req.getPart("photo2");
			InputStream is2 = part2.getInputStream();
			photo2 = new byte[is2.available()];
			is2.read(photo2);
			is2.close();
			
			//開始打包物件
			PhotoVO photoVO1 = new PhotoVO();
			photoVO1.setAlbNo(albNo);
			photoVO1.setPhotoDate(photoDate);
			photoVO1.setPhotoName(photoName1);
			photoVO1.setPhoto(photo1);
			
			//PhotoVO photoVO2 = new PhotoVO(albNo, photoDate);
			PhotoVO photoVO2 = new PhotoVO();
			photoVO2.setAlbNo(albNo);
			photoVO2.setPhotoDate(photoDate);
			photoVO2.setPhotoName(photoName2);
			photoVO2.setPhoto(photo2);
			
			List<PhotoVO> photoList = new ArrayList<PhotoVO>();//ArrayList長度動態改變
			photoList.add(photoVO1);
			photoList.add(photoVO2);
			System.out.println("**servlet===================="+photoVO1.getPhotoName());//***
			/***************************2.開始新增資料***************************************/
			photoSvc.addPhoto(photoList);
			
			/***************************3.新增完成,準備轉交(Send the Success view)***********/
			forwardPath = "/photo/addPhoto.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(forwardPath); // 新增成功後轉交
			successView.forward(req, res);
			
		}
		
		
	}//dopost
	

}
