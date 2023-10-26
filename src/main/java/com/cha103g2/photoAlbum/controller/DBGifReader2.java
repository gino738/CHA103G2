package com.cha103g2.photoAlbum.controller;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.cha103g2.photoAlbum.service.PhotoAlbumServiceImpl;
import com.cha103g2.photoAlbum.service.PhotoAlbumService_interface;

@WebServlet("/dbg.do")
public class DBGifReader2 extends HttpServlet {
	
//	private PhotoAlbumService_interface phaSvc; 
//	
//	public void init() throws ServletException{
//		phaSvc = new PhotoAlbumServiceImpl();
//	}
//	
//	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//		doPost(req, res);
//	}
	Connection con;

	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		
		//req.setCharacterEncoding("UTF-8");
		res.setContentType("image/gif");
		ServletOutputStream out = res.getOutputStream();

		try {
			Statement stmt = con.createStatement();
			String albNo = req.getParameter("id"); //照片的id(PK)
			ResultSet rs = stmt.executeQuery(
				"select alb_photo from photo_album where id =" +albNo);

			if (rs.next()) {
				BufferedInputStream in = new BufferedInputStream(rs.getBinaryStream("alb_photo"));
				byte[] buf = new byte[4 * 1024]; // 4K buffer
				int len;
				while ((len = in.read(buf)) != -1) {
					out.write(buf, 0, len);
				}
				in.close();
			} else {
				res.sendError(HttpServletResponse.SC_NOT_FOUND); //404 p324, 方法p134
			}
			rs.close();
			stmt.close();
		} catch (Exception e) {
			System.out.println(e); //直接印出錯誤訊息
		}
	}

	public void init() throws ServletException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cha10312?serverTimezone=Asia/Taipei", "root", "cha10312");
		} catch (ClassNotFoundException e) {
			throw new UnavailableException("Couldn't load JdbcOdbcDriver");
		} catch (SQLException e) {
			throw new UnavailableException("Couldn't get db connection");
		}
	}

	public void destroy() {
		try {
			if (con != null) con.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

}