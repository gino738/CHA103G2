package com.cha103g2.roomPicture.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class roomPictureDao {
    private static DataSource ds = null;
    
    static {
        try {
            Context ctx = new InitialContext();
            ds = (DataSource) ctx.lookup("java:comp/env/jdbc/TestDB2");
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    private static final String INSERT_STMT = 
        "INSERT INTO room_picture (room_typeNo, pic) VALUES (?, ?)";
    private static final String GET_ALL_STMT = 
        "SELECT pictureNo, room_typeNo, pic FROM room_picture";
    private static final String GET_ONE_STMT = 
        "SELECT pictureNo, room_typeNo, pic FROM room_picture where pictureNo = ?";
    private static final String DELETE = 
        "DELETE FROM room_picture where pictureNo = ?";
    private static final String UPDATE = 
        "UPDATE room_picture set room_typeNo=?, pic=? where pictureNo = ?";

    public void insert(roomPictureVo roomPictureVO) {
        Connection con = null;
        PreparedStatement pstmt = null;
        
        try {
            con = ds.getConnection();
            pstmt = con.prepareStatement(INSERT_STMT);
            
            pstmt.setInt(1, roomPictureVO.getRoom_typeNo());
            pstmt.setBytes(2, roomPictureVO.getPic());
            
            pstmt.executeUpdate();
        } catch (SQLException se) {
            throw new RuntimeException("A database error occurred: " + se.getMessage());
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

    public void update(roomPictureVo roomPictureVO) {
        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = ds.getConnection();
            pstmt = con.prepareStatement(UPDATE);

            pstmt.setInt(1, roomPictureVO.getRoom_typeNo());
            pstmt.setBytes(2, roomPictureVO.getPic());
            pstmt.setInt(3, roomPictureVO.getPictureNo());

            pstmt.executeUpdate();
        } catch (SQLException se) {
            throw new RuntimeException("A database error occurred: " + se.getMessage());
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

    public void delete(Integer pictureNo) {
        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = ds.getConnection();
            pstmt = con.prepareStatement(DELETE);

            pstmt.setInt(1, pictureNo);

            pstmt.executeUpdate();
        } catch (SQLException se) {
            throw new RuntimeException("A database error occurred: " + se.getMessage());
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

    public roomPictureVo findByPrimaryKey(Integer pictureNo) {
        roomPictureVo roomPictureVO = null;
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            con = ds.getConnection();
            pstmt = con.prepareStatement(GET_ONE_STMT);

            pstmt.setInt(1, pictureNo);

            rs = pstmt.executeQuery();

            while (rs.next()) {
                roomPictureVO = new roomPictureVo();
                roomPictureVO.setPictureNo(rs.getInt("pictureNo"));
                roomPictureVO.setRoom_typeNo(rs.getInt("room_typeNo"));
                roomPictureVO.setPic(rs.getBytes("pic"));
            }
        } catch (SQLException se) {
            throw new RuntimeException("A database error occurred: " + se.getMessage());
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
        return roomPictureVO;
    }

    public List<roomPictureVo> getAll() {
        List<roomPictureVo> list = new ArrayList<>();
        roomPictureVo roomPictureVO;

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            con = ds.getConnection();
            pstmt = con.prepareStatement(GET_ALL_STMT);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                roomPictureVO = new roomPictureVo();
                roomPictureVO.setPictureNo(rs.getInt("pictureNo"));
                roomPictureVO.setRoom_typeNo(rs.getInt("room_typeNo"));
                roomPictureVO.setPic(rs.getBytes("pic"));
                list.add(roomPictureVO);
            }
        } catch (SQLException se) {
            throw new RuntimeException("A database error occurred: " + se.getMessage());
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
}
