package com.cha103g2.department;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


public class DeptJDBCDAO implements DeptDAO_interface{
	private static final String INSERT_STMT = "INSERT INTO department(deptno, deptname) VALUES (?, ?)";
	private static final String UPDATE_STMT = "UPDATE department SET deptno = ?, deptname = ?WHERE deptno = ?";
	private static final String DELETE_STMT = "DELETE FROM department WHERE deptno = ?";
	private static final String FIND_BY_PK = "SELECT * FROM department WHERE deptno = ?";
	private static final String GET_ALL = "SELECT * FROM department";
	
	static String driver = "com.mysql.cj.jdbc.Driver";
	static String url = "jdbc:mysql://localhost:3306/cha103g2?serverTimezone=Asia/Taipei";
	static String userid = "root";
	static String passwd = "cha10312";
	
//	static {
//		try {
//			Class.forName(driver);
//		} catch (ClassNotFoundException ce) {
//			ce.printStackTrace();
//		}
//	}
	
	@Override
	public void insert(DeptVO deptVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setInt(1, deptVO.getDeptNo());
			pstmt.setString(2, deptVO.getDeptName());

			pstmt.executeUpdate();
		}catch (SQLException | ClassNotFoundException se) {
			se.printStackTrace();
			// Clean up JDBC resources
		} finally {
			closeResources(con, pstmt, null);
		}
		
	}
	@Override
	public void update(DeptVO deptVO) {
		System.out.println("yy");
		// TODO Auto-generated method stub
		
	}
	@Override
	public void delete(DeptVO deptVO) {
		// TODO Auto-generated method stub
		System.out.println("yy");
	}
	@Override
	public DeptVO findByPrimartKey(int deptNo) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<DeptVO> getAll() {
		// TODO Auto-generated method stub
		return null;
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
	
	//===============main方法===============================
	public static void main(String[] args) {
		DeptDAO_interface dao = new DeptJDBCDAO();

		// 新增
		DeptVO deptVO1 = new DeptVO();
		deptVO1.setDeptNo(105);
		deptVO1.setDeptName("採購部");

		dao.insert(deptVO1);
	}
	
}
