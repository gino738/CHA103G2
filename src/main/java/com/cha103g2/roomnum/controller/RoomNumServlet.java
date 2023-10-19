package com.cha103g2.roomNum.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.cha103g2.roomNum.service.RoomNumService;
import com.cha103g2.roomNum.entity.RoomNum;
import com.cha103g2.roomNum.service.RoomNumServiceImpl;

public class RoomNumServlet extends HttpServlet {
	// 一個 servlet 實體對應一個 service 實體
	private RoomNumService roomnumService;

	@Override
	public void init() throws ServletException {
		roomnumService = new RoomNumServiceImpl();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		String forwardPath = "";
		switch (action) {
			case "getAll":
				forwardPath = getAllRoomNums(req, res);
				break;
			case "compositeQuery":
				forwardPath = getCompositeRoomNumsQuery(req, res);
				break;
			default:
				forwardPath = "/index.jsp";
		}
		
		res.setContentType("text/html; charset=UTF-8");
		RequestDispatcher dispatcher = req.getRequestDispatcher(forwardPath);
		dispatcher.forward(req, res);
	}

	private String getAllRoomNums(HttpServletRequest req, HttpServletResponse res) {
		String page = req.getParameter("page");
		int currentPage = (page == null) ? 1 : Integer.parseInt(page);
		
		List<RoomNum> roomnumList = roomnumService.getAllRoomNums(currentPage);

		if (req.getSession().getAttribute("roomnumPageQty") == null) {
			int roomnumPageQty = roomnumService.getPageTotal();
			req.getSession().setAttribute("roomnumPageQty", roomnumPageQty);
		}
		
		req.setAttribute("roomnumList", roomnumList);
		req.setAttribute("currentPage", currentPage);
		
		return "/roomnum/listAllRoomNums.jsp";
	}
	
	private String getCompositeRoomNumsQuery(HttpServletRequest req, HttpServletResponse res) {
		Map<String, String[]> map = req.getParameterMap();
		if (map != null) {
			List<RoomNum> roomnumList = roomnumService.getRoomNumsByCompositeQuery(map);
			req.setAttribute("roomnumList", roomnumList);
		} else {
			return "/index.jsp";
		}
		return "/roomnum/listCompositeQueryRoomNums.jsp";
	}
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}
}
