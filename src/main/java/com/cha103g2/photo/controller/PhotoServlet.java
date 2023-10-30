package com.cha103g2.photo.controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.cha103g2.photo.service.PhotoService;
import com.cha103g2.photo.service.PhotoServiceImpl;
import com.cha103g2.photo.model.PhotoVO;

@WebServlet("/pho.do")
public class PhotoServlet {
	private PhotoService photoSvc;
	
	public void init() throws ServletException {
		photoSvc = new PhotoServiceImpl();
	}
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		String forwardPath = "";
		
		//新增相片===================================================
		if("insert".equals(action)) {
			//錯誤處理
			Integer albNo = null;
			String photoName = null;
			byte[] photo = null;
			
			Part part = req.getPart("albPhoto");
			InputStream is = part.getInputStream();
			photo = new byte[is.available()];
			is.read(photo);
			is.close();
			
			Date photoDate = null;
			//開始打包物件
			PhotoVO photoVO1 = new PhotoVO(albNo, photoName, photo, photoDate);
		}
		
		
	}//dopost
	

}
