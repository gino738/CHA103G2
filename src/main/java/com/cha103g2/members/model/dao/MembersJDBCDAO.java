package com.cha103g2.members.model.dao;

import java.util.*;
import java.sql.*;

public class MembersJDBCDAO implements MembersDAO_interface {

	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/cha103g2?serverTimezone=Asia/Taipei";
	String userid = "root";
	String passwd = "Cha103_11";

	private static final String INSERT_STMT = "INSERT INTO members(mem_no,mem_status,mem_name,mem_mail,mem_account,mem_pass,mem_gender,mem_id,mem_bir, mem_phone,mem_address,mem_date) VALUES (?, ?, ?, ?, ?, ?, ? ,?, ?, ?,?, ?)";
	private static final String UPDATE_STMT = "UPDATE members SET mem_status = ?, mem_name = ?, mem_mail = ?, mem_account = ?, mempass = ?, mem_gender = ?, mem_id = ?, mem_bir = ? , mem_phone = ?,memaddress = ?, mem_date = ? WHERE mem_no = ?";
	private static final String FIND_BY_PK = "SELECT * FROM members WHERE mem_no = ?";
	private static final String GET_ALL = "SELECT * FROM members";
	private static final String DELETE = "DELETE FROM members where mem_no = ?";

	@Override
	public void insert(MembersVO mVo) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setInt(1, mVo.getMemno());
			pstmt.setBoolean(2, mVo.getMemstatus());
			pstmt.setString(3, mVo.getMemname());
			pstmt.setString(4, mVo.getMemmail());
			pstmt.setString(5, mVo.getMemaccount());
			pstmt.setString(6, mVo.getMempass());
			pstmt.setInt(7, mVo.getMemgender());
			pstmt.setString(8, mVo.getMemid());
			pstmt.setDate(9, mVo.getMembir());
			pstmt.setString(10, mVo.getMemaddress());
			pstmt.setDate(11, mVo.getMemdate());

			pstmt.executeUpdate();
			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
		} finally {
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

	}

	@Override
	public void update(MembersVO mVo) {
		Connection con = null;// 連線宣告在方法內(為區域變數)，避免共用連線的問題(講義P40上)
		PreparedStatement pstmt = null;// 一個使用者一個連線

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE_STMT);

			pstmt.setInt(1, mVo.getMemno());
			pstmt.setBoolean(2, mVo.getMemstatus());
			pstmt.setString(3, mVo.getMemname());
			pstmt.setString(4, mVo.getMemmail());
			pstmt.setString(5, mVo.getMemaccount());
			pstmt.setString(6, mVo.getMempass());
			pstmt.setInt(7, mVo.getMemgender());
			pstmt.setString(8, mVo.getMemid());
			pstmt.setDate(9, mVo.getMembir());
			pstmt.setString(10, mVo.getMemphone());
			pstmt.setString(11, mVo.getMemaddress());
			pstmt.setDate(12, mVo.getMemdate());

			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
		} finally {
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
	}

	@Override
	public void delete(Integer memno) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(DELETE);
			pstmt.setInt(1, memno);

			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
		} finally {
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
	}

	@Override
	public MembersVO findByPK(Integer memno) {
		MembersVO mVo = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(FIND_BY_PK);
			pstmt.setInt(1, memno);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				mVo = new MembersVO();
				mVo.setMemno(rs.getInt("mem_no"));
				mVo.setMemstatus(rs.getBoolean("mem_status"));
				mVo.setMemname(rs.getString("mem_name"));
				mVo.setMemmail(rs.getString("mem_mail"));
				mVo.setMemaccount(rs.getString("mem_account"));
				mVo.setMempass(rs.getString("mem_pass"));
				mVo.setMemgender(rs.getInt("mem_gender"));
				mVo.setMemid(rs.getString("mem_id"));
				mVo.setMembir(rs.getDate("mem_bir"));
				mVo.setMemaddress(rs.getString("mem_address"));
				mVo.setMemdate(rs.getDate("mem_date"));
			}
			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
		} finally {
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
		return mVo;
	}

	@Override
	public List<MembersVO> getAll() {
		List<MembersVO> list = new ArrayList<MembersVO>();
		MembersVO mVo = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ALL);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				mVo = new MembersVO();
				mVo.setMemno(rs.getInt("mem_no"));
				mVo.setMemstatus(rs.getBoolean("mem_status"));
				mVo.setMemname(rs.getString("mem_name"));
				mVo.setMemmail(rs.getString("mem_mail"));
				mVo.setMemaccount(rs.getString("mem_account"));
				mVo.setMempass(rs.getString("mem_pass"));
				mVo.setMemgender(rs.getInt("mem_gender"));
				mVo.setMemid(rs.getString("mem_id"));
				mVo.setMembir(rs.getDate("mem_bir"));
				mVo.setMemaddress(rs.getString("mem_address"));
				mVo.setMemdate(rs.getDate("mem_date"));
				list.add(mVo);
			}
			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
		} finally {
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
		return list;
	}

	public static void main(String[] args) {
		MembersJDBCDAO dao = new MembersJDBCDAO();

		List<MembersVO> list = dao.getAll();
		for (MembersVO mvo : list) {
			System.out.println("會員編號："+mvo.getMemno() + ",");
			System.out.println("帳號狀態："+mvo.getMemstatus() + ",");
			System.out.println("會員姓名："+mvo.getMemname() + ",");
			System.out.println("會員信箱："+mvo.getMemmail() + ",");
			System.out.println("會員帳號："+mvo.getMemaccount() + ",");
			System.out.println("會員密碼："+mvo.getMempass() + ",");
			System.out.println("會員性別："+mvo.getMemgender() + ",");
			System.out.println("會員身分證字號："+mvo.getMemid() + ",");
			System.out.println("會員生日："+mvo.getMembir() + ",");
			System.out.println("會員電話："+mvo.getMemphone() + ",");
			System.out.println("會員地址："+mvo.getMemaddress() + ",");
			System.out.println("會員註冊日："+mvo.getMemdate() + ",");
			System.out.println("=====================");
		}
	}
}
