package com.cha103g2.product.model;

import java.util.List;

public class ProductService {
	private ProductDAO_interface dao;

	public ProductService() {
		dao = new ProductDAO();
	}
	
	public ProductVO addProduct(Integer productno, String productname, 
			Integer productprice, Integer productquantity, Integer productstatus, 
			Integer producttotalreviewcount, Integer producttotalreviewstatus, Integer productcategoryno) {

		ProductVO productVO = new ProductVO();

		productVO.setProductname(productname);
		productVO.setProductprice(productprice);
		productVO.setProductquantity(productquantity);
		productVO.setProductstatus(productstatus);
		productVO.setProducttotalreviewcount(producttotalreviewcount);
		productVO.setProducttotalreviewstatus(producttotalreviewstatus);
		
		productVO.setProductcategoryno(productcategoryno);
		dao.insert(productVO);

		return productVO;
	}

	// 預留給 Struts 2 或 Spring MVC 用
	public void addProduct(ProductVO productVO) {
		dao.insert(productVO);
	}

	public ProductVO updateProduct(Integer productno, String productname, 
			Integer productprice, Integer productquantity, Integer productstatus, 
			Integer producttotalreviewcount, Integer producttotalreviewstatus, Integer productcategoryno) {

		ProductVO productVO = new ProductVO();

		productVO.setProductno(productno);
		productVO.setProductname(productname);
		productVO.setProductprice(productprice);
		productVO.setProductquantity(productquantity);
		productVO.setProductstatus(productstatus);
		productVO.setProducttotalreviewcount(producttotalreviewcount);
		productVO.setProducttotalreviewstatus(producttotalreviewstatus);
		
		productVO.setProductcategoryno(productcategoryno);
		
		dao.update(productVO);

		return dao.findByPrimaryKey(productno);
	}

	// 預留給 Struts 2 用的
	public void updateEmp(ProductVO productVO) {
		dao.update(productVO);
	}

	public void deleteProduct(Integer productno) {
		dao.delete(productno);
	}

	public ProductVO getOneProduct(Integer productno) {
		// TODO Auto-generated method stub
		return dao.findByPrimaryKey(productno);
	}

	public List<ProductVO> getAll() {
		return dao.getAll();
	}

}
