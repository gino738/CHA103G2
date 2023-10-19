package com.cha103g2.roomCalendar;

import java.sql.*;
import java.util.*;

public class RoomCalendarJDBCDAO implements RoomCalendarDAO_interface {
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/cha103g2?serverTimezone=Asia/Taipei";
	String userid = "root";
	String passwd = "cha103";

	private static final String Inser_STMT = "INSERT INTO room_calender(calendar_no,room_type_no,cdate,room_total,room_booking,available) VALUES(?,?,?,?,?,?) ";
	//private static final String GET_ALL_STMT = "SELECT calendar_no,room_type_no,cdate,room_total,room_booking,available from room_calendar order by cdate";
	private static final String GET_ALL_STMT = "WITH RECURSIVE dates (v_date) AS "+
												"(SELECT CURDATE() "+
												"UNION ALL "+
												"SELECT v_date + INTERVAL 1 DAY "+
												"FROM dates "+
												"WHERE v_date + INTERVAL 1 DAY <= ADDDATE(CURDATE(), INTERVAL 60 DAY))"+
												"select t.room_type_no ,"+  //as '房型編號'
												"d.v_date ,"+               //as '日期'
												"t.room_total ,"+           //as '房間總數量'
												"c.room_booking ,"+         //as '已預約數量'
												"c.available "+             //as '可預約狀態'
												"from dates as d "+
												"CROSS JOIN room_type as t "+
												"left join room_calendar as c on (d.v_date = c.cdate and t.room_type_no = c.room_type_no)";
	private static final String GET_ONE_STMT = "SELECT calendar_no,room_type_no,cdate,room_total,room_booking,available FROM room_calender where cdate = ?";
	private static final String DELETE = "DELETE FROM room_calender where calendar_no = ?";
	private static final String UPDATE = "UPDATE room_calender set room_type_no=?,cdate=?,room_total=?,room_booking=?,available=?";

	@Override // 新增資料
	public void insert(RoomCalendarVO rcvo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(Inser_STMT);

			pstmt.setInt(1, rcvo.getRoomTypeno());
			pstmt.setDate(2, rcvo.getcDate());
			pstmt.setInt(3, rcvo.getRoomTotal());
			pstmt.setInt(4, rcvo.getRoomBooking());
			pstmt.setBoolean(5, rcvo.getAvailable());

			pstmt.executeUpdate();

		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver." + e.getMessage());
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured." + se.getMessage());
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
				} catch (SQLException e) {
					e.printStackTrace(System.err);
				}
			}
		}
	}

	@Override
	public void update(RoomCalendarVO rcvo) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setInt(1, rcvo.getRoomTypeno());
			pstmt.setDate(2, rcvo.getcDate());
			pstmt.setInt(3, rcvo.getRoomTotal());
			pstmt.setInt(4, rcvo.getRoomBooking());
			pstmt.setBoolean(5, rcvo.getAvailable());

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
	public void delete(Integer calendarNo) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(DELETE);
			pstmt.setInt(1, calendarNo);

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
	public RoomCalendarVO findByPrimaryKey(Integer calendarNo) {
		RoomCalendarVO rcVo = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, calendarNo);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				rcVo = new RoomCalendarVO();
//				rcVo.setCalendarNO(rs.getInt("calendar_no"));  //雙引號內的資料要對應資料庫欄位名稱
//				rcVo.setRoomTypeno(rs.getInt("room_type_no")); //雙引號內的資料要對應資料庫欄位名稱
//				rcVo.setcDate(rs.getDate("cdate"));            //雙引號內的資料要對應資料庫欄位名稱
//				rcVo.setRoomTotal(rs.getInt("room_total"));    //雙引號內的資料要對應資料庫欄位名稱
//				rcVo.setRoomBooking(rs.getInt("room_booking"));//雙引號內的資料要對應資料庫欄位名稱 
//				rcVo.setAvailable(rs.getBoolean("available")); //雙引號內的資料要對應資料庫欄位名稱
				
//				rcVo.setCalendarNO(rs.getInt("calendar_no"));  //雙引號內的資料要對應資料庫欄位名稱
				rcVo.setRoomTypeno(rs.getInt(1)); //雙引號內的資料要對應資料庫欄位名稱
				rcVo.setcDate(rs.getDate(2));            //雙引號內的資料要對應資料庫欄位名稱
				rcVo.setRoomTotal(rs.getInt(3));    //雙引號內的資料要對應資料庫欄位名稱
				rcVo.setRoomBooking(rs.getInt(4));//雙引號內的資料要對應資料庫欄位名稱
				boolean available=rs.getBoolean(5);
				if(rs.wasNull()) {
					available=true;
				}
				rcVo.setAvailable(available); //雙引號內的資料要對應資料庫欄位名稱
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
		return rcVo;
	}

	@Override
	public List<RoomCalendarVO> getAll() {
		List<RoomCalendarVO> list = new ArrayList<RoomCalendarVO>();
		RoomCalendarVO rcVo = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,userid,passwd);
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				rcVo = new RoomCalendarVO();
			//	System.out.print(rs.getInt("room_type_no"));
//				rcVo.setRoomTypeno(rs.getInt("room_type_no"));
//				rcVo.setcDate(rs.getDate("cdate"));
//				rcVo.setRoomTotal(rs.getInt("room_total"));
//				rcVo.setRoomBooking(rs.getInt("room_booking"));
//				rcVo.setAvailable(rs.getBoolean("available"));
				
//				rcVo.setCalendarNO(rs.getInt("calendar_no"));  //雙引號內的資料要對應資料庫欄位名稱
				rcVo.setRoomTypeno(rs.getInt(1)); //雙引號內的資料要對應資料庫欄位名稱
				rcVo.setcDate(rs.getDate(2));            //雙引號內的資料要對應資料庫欄位名稱
				rcVo.setRoomTotal(rs.getInt(3));    //雙引號內的資料要對應資料庫欄位名稱
				rcVo.setRoomBooking(rs.getInt(4));//雙引號內的資料要對應資料庫欄位名稱 
				boolean available=rs.getBoolean(5);
				if(rs.wasNull()) {
					available=true;
				}
				rcVo.setAvailable(available); //雙引號內的資料要對應資料庫欄位名稱
				list.add(rcVo);				
			}
			// Handle any driver errors
					} catch (ClassNotFoundException e) {
						throw new RuntimeException("Couldn't load database driver. "
								+ e.getMessage());
						// Handle any SQL errors
					} catch (SQLException se) {
						throw new RuntimeException("A database error occured. "
								+ se.getMessage());
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
		RoomCalendarJDBCDAO dao = new RoomCalendarJDBCDAO();

		List<RoomCalendarVO> list = dao.getAll();
		for (RoomCalendarVO rcvo : list) {
			System.out.print(rcvo.getRoomTypeno()+",");
			System.out.print(rcvo.getcDate()+",");
			System.out.print(rcvo.getRoomTotal()+",");
			System.out.print(rcvo.getRoomBooking()+",");
			System.out.println(rcvo.getAvailable()+",");
		}
	}
}