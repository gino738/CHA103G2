package com.cha103g2.roomNum;

import java.sql.*;
import java.util.*;

public class RoomNumJDBCDAO implements RoomNumDAO_Interface{

		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/cha103g2?serverTimezone=Asia/Taipei";
		String userid = "root";
		String passwd = "cha103";

		private static final String Inser_STMT = "INSERT INTO room_calender(calendar_no,room_type_no,cdate,room_total,room_booking,available) VALUES(?,?,?,?,?,?) ";
		private static final String GET_ALL_STMT = "SELECT r_num,room_type_no,room_order_no,checkin_name,room_status from room_num order by r_num";
		private static final String GET_ONE_STMT = "SELECT r_num,room_type_no,room_order_no,checkin_name,room_status FROM room_calender where cdate = ?";
		private static final String DELETE = "DELETE FROM room_calender where calendar_no = ?";
		private static final String UPDATE = "UPDATE room_calender set room_type_no=?,cdate=?,room_total=?,room_booking=?,available=?";


	@Override //新增資料
	public void insert(RoomNumVO rnvo) {
		Connection con =null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,userid,passwd);
			pstmt = con.prepareStatement(Inser_STMT);
			
			pstmt.setInt(1, rnvo.getrNum());
			pstmt.setInt(2, rnvo.getRoomTypeNo());
			pstmt.setInt(3, rnvo.getRoomOrderNo());
			pstmt.setString(4, rnvo.getCheckInName());
			pstmt.setByte(5, rnvo.getRoomStatus());
			pstmt.executeQuery();
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver." + e.getMessage());
		} catch (SQLException se) {
			throw new RuntimeException("A datebase error occured." + se.getMessage());
		}finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
		}
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace(System.err);
			}
		}	
	}

	@Override //更新資料
	public void update(RoomNumVO rnvo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,userid,passwd);
			pstmt = con.prepareStatement(UPDATE);
			
			pstmt.setInt(1, rnvo.getrNum());
			pstmt.setInt(2, rnvo.getRoomTypeNo());
			pstmt.setInt(3, rnvo.getRoomOrderNo());
			pstmt.setString(4, rnvo.getCheckInName());
			pstmt.setByte(5, rnvo.getRoomStatus());
			pstmt.executeQuery();
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver." + e.getMessage());
		} catch (SQLException se) {
			throw new RuntimeException("A datebase error occured." + se.getMessage());
		}finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
		}
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace(System.err);
			}
		}	
		
	}

	@Override
	public void delete(Integer rNum) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,userid,passwd);
			pstmt = con.prepareStatement(DELETE);
			pstmt.setInt(1,rNum);
			pstmt.executeQuery();
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

	@Override //尋找PK
	public RoomNumVO findByPrimaryKey(Integer rNum) {
		RoomNumVO rnVo = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName(driver);
			con =DriverManager.getConnection(url,userid,passwd);
			pstmt = con.prepareStatement(GET_ONE_STMT);
			
			pstmt.setInt(1,rNum);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				rnVo = new RoomNumVO();
				
				rnVo.setrNum(rs.getInt(1));
				rnVo.setRoomTypeNo(rs.getInt(2));
				rnVo.setRoomOrderNo(rs.getInt(3));
				rnVo.setCheckInName(rs.getString(4));
				rnVo.setRoomStatus(rs.getByte(5));
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
			return rnVo;	
	}

	@Override //查詢全部資料
	public List<RoomNumVO> getAll() {
		List<RoomNumVO> list = new ArrayList<RoomNumVO>();		
		RoomNumVO rnVo = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,userid,passwd);
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				rnVo = new RoomNumVO();
				rnVo.setrNum(rs.getInt(1));
				rnVo.setRoomTypeNo(rs.getInt(2));
				rnVo.setRoomOrderNo(rs.getInt(3));
				rnVo.setCheckInName(rs.getString(4));
				rnVo.setRoomStatus(rs.getByte(5));
				list.add(rnVo); 
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
		RoomNumJDBCDAO dao = new RoomNumJDBCDAO();
		int i =0;
		List<RoomNumVO> list = dao.getAll();
		
		for (RoomNumVO rnvo : list) {		
			System.out.print(rnvo.getrNum()+",");
			System.out.print(rnvo.getRoomTypeNo()+",");
			System.out.print(rnvo.getRoomOrderNo()+",");
			System.out.print(rnvo.getCheckInName()+",");
			System.out.println(rnvo.getRoomStatus()+",");
			
		}
	}
}
