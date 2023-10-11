package com.cha103g2.members;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.Util;

public class MembersDAOImpl implements MembersDAO{
	private static final String INSERT_STMT = "INSERT INTO members(memno,memstatus,memname,memmail,memaccount,mempass,memgender,memid,membir, memaddress,memdate) VALUES (?, ?, ?, ?, ?, ?, ? ,?, ?, ?, ?)";
	private static final String UPDATE_STMT = "UPDATE membersSET memstatus = ?, memname = ?, memmail = ?, memaccount = ?, mempass = ?, memgender = ?, memid = ?, membir = ?, memaddress = ? , memdate = ?WHERE memno = ?";
	private static final String FIND_BY_PK = "SELECT * FROM members WHERE memno = ?";
	private static final String GET_ALL = "SELECT * FROM members";
	
	static {
		try {
			Class.forName(Util.DRIVER);
		} catch (ClassNotFoundException ce) {
			ce.printStackTrace();
		}
	}

	@Override
	public void add(Members members) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setInt(1, members.getMemno());
			pstmt.setBoolean(2, members.getMemstatus());
			pstmt.setString(3, members.getMemname());
			pstmt.setString(4, members.getMemmail());
			pstmt.setString(5, members.getMemaccount());
			pstmt.setString(6, members.getMempass());
			pstmt.setInt(7, members.getMemgender());
			pstmt.setInt(8, members.getMemid());
			pstmt.setDate(9, members.getMembir());
			pstmt.setInt(10, members.getMemphone());

			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (SQLException se) {
			se.printStackTrace();
			// Clean up JDBC resources
		} finally {
			closeResources(con, pstmt, null);
		}
	}

	@Override
	public void update(Members members) {
		Connection con = null;//連線宣告在方法內(為區域變數)，避免共用連線的問題(講義P40上)
		PreparedStatement pstmt = null;//一個使用者一個連線

		try {

			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(UPDATE_STMT);

			pstmt.setInt(1, members.getMemno());
			pstmt.setBoolean(2, members.getMemstatus());
			pstmt.setString(3, members.getMemname());
			pstmt.setString(4, members.getMemmail());
			pstmt.setString(5, members.getMemaccount());
			pstmt.setString(6, members.getMempass());
			pstmt.setInt(7, members.getMemgender());
			pstmt.setInt(8, members.getMemid());
			pstmt.setDate(9, members.getMembir());
			pstmt.setInt(10, members.getMemphone());
			
			
			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (SQLException se) {
			se.printStackTrace();
			// Clean up JDBC resources
		} finally {
			closeResources(con, pstmt, null);
		}
	}

	

	@Override
	public Members findByPK(Integer mempno) {
		Members mem = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(FIND_BY_PK);
			pstmt.setInt(1, memno);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				
				mem.setInt(rs.getMemno("memno"));
				mem.setBoolean(rs.getMemstatus("memstatus"));
				mem.setString(rs.getMemname("memname"));
				mem.setString(rs.getMemmail("memmail"));
				mem.setString(rs.getMemaccount("memaccount"));
				mem.setString(rs.getMempass("mempass"));
				mem.setInt(rs.getMemgender("memgender"));
				mem.setInt(rs.getMemid("memid"));
				mem.setDate(rs.getMembir("membir"));
				mem.setInt(rs.getMemphone("memphone"));

			}

		} catch (SQLException se) {
			se.printStackTrace();
			// Clean up JDBC resources
		} finally {
			closeResources(con, pstmt, rs);
		}
		return mem;
	}

	@Override
	public List<Members> getAll() {
		List<Members> empList = new ArrayList<>();
		Members mem = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(GET_ALL);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				mem = new Members();
				mem.setInt(rs.getMemno("memno"));
				mem.setBoolean(rs.getMemstatus("memstatus"));
				mem.setString(rs.getMemname("memname"));
				mem.setString(rs.getMemmail("memmail"));
				mem.setString(rs.getMemaccount("memaccount"));
				mem.setString(rs.getMempass("mempass"));
				mem.setInt(rs.getMemgender("memgender"));
				mem.setInt(rs.getMemid("memid"));
				mem.setDate(rs.getMembir("membir"));
				mem.setInt(rs.getMemphone("memphone"));

			}

		} catch (SQLException se) {
			se.printStackTrace();
			// Clean up JDBC resources
		} finally {
			closeResources(con, pstmt, rs);
		}
		return memList;
	}
	
	private void closeResources(Connection con, PreparedStatement pstmt, ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException se) {
				se.printStackTrace(System.err);
			}
		}
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException se) {
				se.printStackTrace(System.err);
			}
		}
		if (con != null) {
			try {
				con.close();
			} catch (Exception e) {
				e.printStackTrace(System.err);
			}
		}
	}
	
	
	
	
