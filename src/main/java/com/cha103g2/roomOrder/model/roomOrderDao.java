package com.cha103g2.roomOrder.model;

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

public class roomOrderDao {
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
        "INSERT INTO room_order (room_order_date, checkin_date, checkout_date, room_type_no, mem_no, room_amount, price, payment_method, pay_status, order_status) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String GET_ALL_STMT = 
        "SELECT room_order_no, room_order_date, checkin_date, checkout_date, room_type_no, mem_no, room_amount, price, payment_method, pay_status, order_status FROM room_order ORDER BY room_order_no";
    private static final String GET_ONE_STMT = 
        "SELECT room_order_no, room_order_date, checkin_date, checkout_date, room_type_no, mem_no, room_amount, price, payment_method, pay_status, order_status FROM room_order WHERE room_order_no = ?";
    private static final String DELETE = 
        "DELETE FROM room_order WHERE room_order_no = ?";
    private static final String UPDATE = 
        "UPDATE room_order SET room_order_date=?, checkin_date=?, checkout_date=?, room_type_no=?, mem_no=?, room_amount=?, price=?, payment_method=?, pay_status=?, order_status=? WHERE room_order_no = ?";

    public void insert(roomOrderVo roomOrderVO) {
        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = ds.getConnection();
            pstmt = con.prepareStatement(INSERT_STMT);

            pstmt.setDate(1, roomOrderVO.getRoomOrderDate());
            pstmt.setDate(2, roomOrderVO.getCheckinDate());
            pstmt.setDate(3, roomOrderVO.getCheckoutDate());
            pstmt.setInt(4, roomOrderVO.getRoomTypeNo());
            pstmt.setInt(5, roomOrderVO.getMemNo());
            pstmt.setInt(6, roomOrderVO.getRoomAmount());
            pstmt.setInt(7, roomOrderVO.getPrice());
            pstmt.setByte(8, roomOrderVO.getPaymentMethod());
            pstmt.setBoolean(9, roomOrderVO.isPayStatus());
            pstmt.setByte(10, roomOrderVO.getOrderStatus());

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

    public void update(roomOrderVo roomOrderVO) {
        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = ds.getConnection();
            pstmt = con.prepareStatement(UPDATE);

            pstmt.setDate(1, roomOrderVO.getRoomOrderDate());
            pstmt.setDate(2, roomOrderVO.getCheckinDate());
            pstmt.setDate(3, roomOrderVO.getCheckoutDate());
            pstmt.setInt(4, roomOrderVO.getRoomTypeNo());
            pstmt.setInt(5, roomOrderVO.getMemNo());
            pstmt.setInt(6, roomOrderVO.getRoomAmount());
            pstmt.setInt(7, roomOrderVO.getPrice());
            pstmt.setByte(8, roomOrderVO.getPaymentMethod());
            pstmt.setBoolean(9, roomOrderVO.isPayStatus());
            pstmt.setByte(10, roomOrderVO.getOrderStatus());
            pstmt.setInt(11, roomOrderVO.getRoomOrderNo());

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

    public void delete(Integer roomOrderNo) {
        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = ds.getConnection();
            pstmt = con.prepareStatement(DELETE);

            pstmt.setInt(1, roomOrderNo);

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

    public roomOrderVo findByPrimaryKey(Integer roomOrderNo) {
        roomOrderVo roomOrderVO = null;
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            con = ds.getConnection();
            pstmt = con.prepareStatement(GET_ONE_STMT);

            pstmt.setInt(1, roomOrderNo);

            rs = pstmt.executeQuery();

            while (rs.next()) {
                roomOrderVO = new roomOrderVo();
                roomOrderVO.setRoomOrderNo(rs.getInt("room_order_no"));
                roomOrderVO.setRoomOrderDate(rs.getDate("room_order_date"));
                roomOrderVO.setCheckinDate(rs.getDate("checkin_date"));
                roomOrderVO.setCheckoutDate(rs.getDate("checkout_date"));
                roomOrderVO.setRoomTypeNo(rs.getInt("room_type_no"));
                roomOrderVO.setMemNo(rs.getInt("mem_no"));
                roomOrderVO.setRoomAmount(rs.getInt("room_amount"));
                roomOrderVO.setPrice(rs.getInt("price"));
                roomOrderVO.setPaymentMethod(rs.getByte("payment_method"));
                roomOrderVO.setPayStatus(rs.getBoolean("pay_status"));
                roomOrderVO.setOrderStatus(rs.getByte("order_status"));
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
        return roomOrderVO;
    }

    public List<roomOrderVo> getAll() {
        List<roomOrderVo> list = new ArrayList<>();
        roomOrderVo roomOrderVO = null;

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            con = ds.getConnection();
            pstmt = con.prepareStatement(GET_ALL_STMT);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                roomOrderVO = new roomOrderVo();
                roomOrderVO.setRoomOrderNo(rs.getInt("room_order_no"));
                roomOrderVO.setRoomOrderDate(rs.getDate("room_order_date"));
                roomOrderVO.setCheckinDate(rs.getDate("checkin_date"));
                roomOrderVO.setCheckoutDate(rs.getDate("checkout_date"));
                roomOrderVO.setRoomTypeNo(rs.getInt("room_type_no"));
                roomOrderVO.setMemNo(rs.getInt("mem_no"));
                roomOrderVO.setRoomAmount(rs.getInt("room_amount"));
                roomOrderVO.setPrice(rs.getInt("price"));
                roomOrderVO.setPaymentMethod(rs.getByte("payment_method"));
                roomOrderVO.setPayStatus(rs.getBoolean("pay_status"));
                roomOrderVO.setOrderStatus(rs.getByte("order_status"));
                list.add(roomOrderVO);
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
