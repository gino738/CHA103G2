package com.cha103g2.photoAlbum.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import java.io.FileInputStream;

import com.cha103g2.photoAlbum.entity.PhotoAlbumVO;
import com.cha103g2.photoAlbum.service.PhotoAlbumServiceImpl;
import com.cha103g2.photoAlbum.service.PhotoAlbumService_interface;

/**
 * Servlet implementation class phaService
 */
@MultipartConfig
public class PhaServlet extends HttpServlet {
	
	private PhotoAlbumService_interface phaSvc; 
	
	public void init() throws ServletException{
		phaSvc = new PhotoAlbumServiceImpl();
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		String forwardPath = "";

		
		if("getAll".equals(action)) {
			forwardPath = getAllPha(req, res);
			res.setContentType("text/html; charset=UTF-8");
			RequestDispatcher dispatcher = req.getRequestDispatcher(forwardPath);
			dispatcher.forward(req, res);
		}
		if("compositeQuery".equals(action)) {
//			forwardPath = getPhaByCompositeQuery(req, res);
//			res.setContentType("text/html; charset=UTF-8");
//			RequestDispatcher dispatcher = req.getRequestDispatcher(forwardPath);
//			dispatcher.forward(req, res);
		}
		//新增==========================================================
		if("insert".equals(action)) {
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
			Integer albNo = null;
			try {
				albNo = Integer.valueOf(req.getParameter("albNo").trim());
			}catch(Exception e) {
				errorMsgs.add("相簿編號請勿空白");
			}
			
			Integer memNo = null;
			try {
				memNo = Integer.valueOf(req.getParameter("memNo").trim());
			}catch(Exception e) {
				errorMsgs.add("會員編號請勿空白");
			}
			
			String albName = req.getParameter("albName").trim();
			if(albName == null || albName.trim().length() == 0) {
				errorMsgs.add("相簿名稱請勿空白");
			}
		
			
			java.sql.Date albDate = null;
			try {
				albDate = java.sql.Date.valueOf(req.getParameter("albDate").trim());
			}catch(Exception e) {
				errorMsgs.add("相簿建立日期請勿空白");
			}
			//開始打包成物件
			PhotoAlbumVO phaVO = new PhotoAlbumVO();
			phaVO.setAlbNo(albNo);
			phaVO.setMemNo(memNo);
			phaVO.setAlbName(albName);
			phaVO.setAlbDate(albDate);
			
			//圖片需轉換成byte
			byte[] albPhoto = null;
			Part part = req.getPart("albPhoto");
			InputStream is = part.getInputStream();
			albPhoto = new byte[is.available()];
			is.read(albPhoto);
			is.close();
			phaVO.setAlbPhoto(albPhoto);
			
			
			//如果有錯誤處理輸出
			if (!errorMsgs.isEmpty()) {
				req.setAttribute("phaVO", phaVO); // 含有輸入格式錯誤的empVO物件,也存入req
				RequestDispatcher failureView = req
						.getRequestDispatcher("/pha/select_phoalb.jsp");
				failureView.forward(req, res);
				return;
			}
			/***************************2.開始新增資料***************************************/
			phaSvc.addPha(phaVO);

			/***************************3.新增完成,準備轉交(Send the Success view)***********/
			forwardPath = getAllPha(req, res);
			RequestDispatcher successView = req.getRequestDispatcher(forwardPath); // 新增成功後轉交
			successView.forward(req, res);
		}
		
		
	}//doPost
	//查全部可瀏覽的頁數===========================================================
	private String getAllPha(HttpServletRequest req, HttpServletResponse res) { //從ListAll請求
		String page = req.getParameter("page"); //網址列會有page=空(第一頁) or 第幾頁
		int currentPage = (page == null) ? 1 : Integer.parseInt(page); //如果第一次跳轉則page會是空值, 把1存進currentPage
		
		List<PhotoAlbumVO> phaList = phaSvc.getAllPha(currentPage);

		if (req.getSession().getAttribute("phaPageQty") == null) {
			int phaPageQty = phaSvc.getPageTotal();
			req.getSession().setAttribute("phaPageQty", phaPageQty);
		}
		
		req.setAttribute("phaList", phaList);
		req.setAttribute("currentPage", currentPage);

		return "/pha/listAllPha.jsp";

	}
	//新增完會跳轉最後一頁===========================================================
	private String getAllPha(HttpServletRequest req, HttpServletResponse res, int targetPage) {
		String page = req.getParameter("page"); //網址列會有page=空(第一頁) or 第幾頁
		int currentPage = (page == null) ? 1 : Integer.parseInt(page); //如果第一次跳轉則page會是空值, 把1存進currentPage
		
	    if (targetPage == -1) {
	        targetPage = (int) req.getSession().getAttribute("phaPageQty");
	    }		
		
		List<PhotoAlbumVO> phaList = phaSvc.getAllPha(currentPage);

		if (req.getSession().getAttribute("phaPageQty") == null) {
			int phaPageQty = phaSvc.getPageTotal();
			req.getSession().setAttribute("phaPageQty", phaPageQty);
		}
		
		req.setAttribute("phaList", phaList);
		req.setAttribute("currentPage", currentPage);

		return "/pha/listAllPha.jsp";
	}
		
//		byte[] byteArray = null;
//
//		Part filePart = req.getPart("memImage");
//		   if(filePart != null &&  filePart.getSize() > 0) {
//		    InputStream inputStream = filePart.getInputStream();
//		          ByteArrayOutputStream buffer = new ByteArrayOutputStream();
//		          int nRead;		          byte[] data = new byte[1024];
//		          while ((nRead = inputStream.read(data, 0, data.length)) != -1) {
//		              buffer.write(data, 0, nRead);
//		          }
//		          buffer.flush();
//		          byteArray = buffer.toByteArray();
//		          inputStream.close();
//		          buffer.close();
//	}

}//class
