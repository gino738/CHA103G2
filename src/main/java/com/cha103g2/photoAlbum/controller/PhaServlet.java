package com.cha103g2.photoAlbum.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cha103g2.photoAlbum.entity.PhotoAlbumVO;
import com.cha103g2.photoAlbum.service.PhotoAlbumServiceImpl;
import com.cha103g2.photoAlbum.service.PhotoAlbumService_interface;

/**
 * Servlet implementation class phaService
 */

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
		
		//查全部或複合查詢
		switch (action) {
			case "getAll":
				forwardPath = getAllPha(req, res);
				break;
//			case "compositeQuery":
//				forwardPath = getPhaByCompositeQuery(req, res);
//				break;
			default:
				forwardPath = "/select_phoalb.jsp";
		}	
		res.setContentType("text/html; charset=UTF-8");
		RequestDispatcher dispatcher = req.getRequestDispatcher(forwardPath);
		dispatcher.forward(req, res);
		
		
	}//doPost
	
	private String getAllPha(HttpServletRequest req, HttpServletResponse res) {
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

}
