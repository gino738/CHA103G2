package com.cha103g2.roomType;

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

public class roomTypeDao {
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
        "INSERT INTO room_type (room_name, rtype, room_total, price, normal_price, holiday_price, bridge_holiday_price, notice, facility, rtype_status) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String GET_ALL_STMT = 
        "SELECT room_type_no, room_name, rtype, room_total, price, normal_price, holiday_price, bridge_holiday_price, notice, facility, rtype_status FROM room_type ORDER BY room_type_no";
    private static final String GET_ONE_STMT = 
        "SELECT room_type_no, room_name, rtype, room_total, price, normal_price, holiday_price, bridge_holiday_price, notice, facility, rtype_status FROM room_type WHERE room_type_no = ?";
    private static final String DELETE = 
        "DELETE FROM room_type WHERE room_type_no = ?";
    private static final String UPDATE = 
        "UPDATE room_type SET room_name=?, rtype=?, room_total=?, price=?, normal_price=?, holiday_price=?, bridge_holiday_price=?, notice=?, facility=?, rtype_status=? WHERE room_type_no = ?";

    public void insert(roomTypeVo roomTypeVO) {
        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = ds.getConnection();
            pstmt = con.prepareStatement(INSERT_STMT);

            pstmt.setString(1, roomTypeVO.getRoomName());
            pstmt.setString(2, roomTypeVO.getRtype());
            pstmt.setInt(3, roomTypeVO.getRoomTotal());
            pstmt.setInt(4, roomTypeVO.getPrice());
            pstmt.setInt(5, roomTypeVO.getNormalPrice());
            pstmt.setInt(6, roomTypeVO.getHolidayPrice());
            pstmt.setInt(7, roomTypeVO.getBridgeHolidayPrice());
            pstmt.setString(8, roomTypeVO.getNotice());
            pstmt.setString(9, roomTypeVO.getFacility());
            pstmt.setBoolean(10, roomTypeVO.isrTypeStatus());

            pstmt.executeUpdate();
        } catch (SQLException se) {
            throw new RuntimeException("A database error occurred: " + se.getMessage());
        } finally {
            closeResources(con, pstmt, null);
        }
    }

    public void update(roomTypeVo roomTypeVO) {
        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = ds.getConnection();
            pstmt = con.prepareStatement(UPDATE);

            pstmt.setString(1, roomTypeVO.getRoomName());
            pstmt.setString(2, roomTypeVO.getRtype());
            pstmt.setInt(3, roomTypeVO.getRoomTotal());
            pstmt.setInt(4, roomTypeVO.getPrice());
            pstmt.setInt(5, roomTypeVO.getNormalPrice());
            pstmt.setInt(6, roomTypeVO.getHolidayPrice());
            pstmt.setInt(7, roomTypeVO.getBridgeHolidayPrice());
            pstmt.setString(8, roomTypeVO.getNotice());
            pstmt.setString(9, roomTypeVO.getFacility());
            pstmt.setBoolean(10, roomTypeVO.isrTypeStatus());
            pstmt.setInt(11, roomTypeVO.getRoomTypeNo());

            pstmt.executeUpdate();
        } catch (SQLException se) {
            throw new RuntimeException("A database error occurred: " + se.getMessage());
        } finally {
            closeResources(con, pstmt, null);
        }
    }

    public void delete(Integer roomTypeNo) {
        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = ds.getConnection();
            pstmt = con.prepareStatement(DELETE);

            pstmt.setInt(1, roomTypeNo);

            pstmt.executeUpdate();
        } catch (SQLException se) {
            throw new RuntimeException("A database error occurred: " + se.getMessage());
        } finally {
            closeResources(con, pstmt, null);
        }
    }

    public roomTypeVo findByPrimaryKey(Integer roomTypeNo) {
        roomTypeVo roomTypeVO = null;
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            con = ds.getConnection();
            pstmt = con.prepareStatement(GET_ONE_STMT);

            pstmt.setInt(1, roomTypeNo);

            rs = pstmt.executeQuery();

            while (rs.next()) {
                roomTypeVO = new roomTypeVo();
                roomTypeVO.setRoomTypeNo(rs.getInt("room_type_no"));
                roomTypeVO.setRoomName(rs.getString("room_name"));
                roomTypeVO.setRtype(rs.getString("rtype"));
                roomTypeVO.setRoomTotal(rs.getInt("room_total"));
                roomTypeVO.setPrice(rs.getInt("price"));
                roomTypeVO.setNormalPrice(rs.getInt("normal_price"));
                roomTypeVO.setHolidayPrice(rs.getInt("holiday_price"));
                roomTypeVO.setBridgeHolidayPrice(rs.getInt("bridge_holiday_price"));
                roomTypeVO.setNotice(rs.getString("notice"));
                roomTypeVO.setFacility(rs.getString("facility"));
                roomTypeVO.setrTypeStatus(rs.getBoolean("rtype_status"));
            }
        } catch (SQLException se) {
            throw new RuntimeException("A database error occurred: " + se.getMessage());
        } finally {
            closeResources(con, pstmt, rs);
        }
        return roomTypeVO;
    }

    public List<roomTypeVo> getAll() {
        List<roomTypeVo> list = new ArrayList<>();
        roomTypeVo roomTypeVO;

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            con = ds.getConnection();
            pstmt = con.prepareStatement(GET_ALL_STMT);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                roomTypeVO = new roomTypeVo();
                roomTypeVO.setRoomTypeNo(rs.getInt("room_type_no"));
                roomTypeVO.setRoomName(rs.getString("room_name"));
                roomTypeVO.setRtype(rs.getString("rtype"));
                roomTypeVO.setRoomTotal(rs.getInt("room_total"));
                roomTypeVO.setPrice(rs.getInt("price"));
                roomTypeVO.setNormalPrice(rs.getInt("normal_price"));
                roomTypeVO.setHolidayPrice(rs.getInt("holiday_price"));
                roomTypeVO.setBridgeHolidayPrice(rs.getInt("bridge_holiday_price"));
                roomTypeVO.setNotice(rs.getString("notice"));
                roomTypeVO.setFacility(rs.getString("facility"));
                roomTypeVO.setrTypeStatus(rs.getBoolean("rtype_status"));
                list.add(roomTypeVO);
            }
        } catch (SQLException se) {
            throw new RuntimeException("A database error occurred: " + se.getMessage());
        } finally {
            closeResources(con, pstmt, rs);
        }
        return list;
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
}
