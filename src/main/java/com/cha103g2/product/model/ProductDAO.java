package com.cha103g2.product.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import javax.naming.NamingException;
import javax.sql.DataSource;

public class ProductDAO implements ProductDAO_interface{
	private static DataSource ds = null;
//	static {
//		try {
//			Context ctx = new InitialContext();
//			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/TestDB2");
//		} catch (NamingException e) {
//			e.printStackTrace();
//		}
//	}

	private static final String INSERT_STMT = 
			"INSERT INTO product(productcategoryno, productname, productprice, productquantity, productstatus, producttotalreviewcount, producttotalreviewstatus) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String UPDATE = 
			"UPDATE product set productcategoryno=?, productname=?, productprice=?, productquantity=?, productstatus=?, producttotalreviewcount=?, producttotalreviewstatus=? where productno = ?";
	private static final String DELETE = 
			"DELETE FROM product where productno = ?";
	private static final String GET_ONE_STMT = 
			"SELECT productno,productcategoryno,productname,productprice,productquantity,productstatus,producttotalreviewcount,producttotalreviewstatus FROM product where productno = ?";
	private static final String GET_ALL_STMT = 
			"SELECT productno,productcategoryno,productname,productprice,productquantity,productstatus,producttotalreviewcount,producttotalreviewstatus FROM product order by productno";
	
	@Override
	public void insert(ProductVO productVO) {
		// TODO Auto-generated method stub
		//新增資料
		Connection con = null;
		PreparedStatement pstmt = null;
		
		
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT_STMT);
			
			pstmt.setInt(1, productVO.getProductcategoryno());
			pstmt.setString(2, productVO.getProductname());
			pstmt.setInt(3, productVO.getProductprice());
			pstmt.setInt(4, productVO.getProductquantity());
			pstmt.setInt(5, productVO.getProductstatus());
			pstmt.setInt(6, productVO.getProducttotalreviewcount());
			pstmt.setInt(7, productVO.getProducttotalreviewstatus());
			
			pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(pstmt != null) {
				try {
					pstmt.close();
				}catch(SQLException se){
					se.printStackTrace(System.err);
				}
			}
			if(con != null) {
				try {
					con.close();
				}catch(Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		
	}

	@Override
	public void update(ProductVO productVO) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(UPDATE);
			
			pstmt.setInt(1, productVO.getProductcategoryno());
			pstmt.setString(2, productVO.getProductname());
			pstmt.setInt(3, productVO.getProductprice());
			pstmt.setInt(4, productVO.getProductquantity());
			pstmt.setInt(5, productVO.getProductstatus());
			pstmt.setInt(6, productVO.getProducttotalreviewcount());
			pstmt.setInt(7, productVO.getProducttotalreviewstatus());
			
			pstmt.executeUpdate();
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		}finally {
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
	public void delete(Integer productno) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, productno);

			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
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
	public ProductVO findByPrimaryKey(Integer productno) {
		// TODO Auto-generated method stub
		ProductVO productVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ONE_STMT);
			
			pstmt.setInt(1, productno);

			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				// productVo 也稱為 Domain objects
				productVO = new ProductVO();
				productVO.setProductno(rs.getInt("productno"));
				productVO.setProductcategoryno(rs.getInt("productcategoryno"));
				productVO.setProductname(rs.getString("productname"));
				productVO.setProductprice(rs.getInt("productprice"));
				productVO.setProductquantity(rs.getInt("productquantity"));
				productVO.setProductstatus(rs.getInt("productstatus"));
				productVO.setProducttotalreviewcount(rs.getInt("producttotalreviewcount"));
				productVO.setProducttotalreviewstatus(rs.getInt("producttotalreviewstatus"));
			}
				
		} catch (SQLException se) {
			// TODO Auto-generated catch block
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		}finally {
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
		}return productVO;
	}

	@Override
	public List<ProductVO> getAll() {
		// TODO Auto-generated method stub
		List<ProductVO> list = new ArrayList<ProductVO>();
		ProductVO productVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				// productVo 也稱為 Domain objects
				productVO = new ProductVO();
				productVO.setProductno(rs.getInt("productno"));
				productVO.setProductcategoryno(rs.getInt("productcategoryno"));
				productVO.setProductname(rs.getString("productname"));
				productVO.setProductprice(rs.getInt("productprice"));
				productVO.setProductquantity(rs.getInt("productquantity"));
				productVO.setProductstatus(rs.getInt("productstatus"));
				productVO.setProducttotalreviewcount(rs.getInt("producttotalreviewcount"));
				productVO.setProducttotalreviewstatus(rs.getInt("producttotalreviewstatus"));
				list.add(productVO); // Store the row in the list
			}
			
		} catch (SQLException se) {
			// TODO Auto-generated catch block
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		}finally {
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
		}return list;
	}
	
}
