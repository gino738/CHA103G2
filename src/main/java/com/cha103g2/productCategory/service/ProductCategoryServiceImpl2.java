package com.cha103g2.productCategory.service;

import java.util.List;
import java.util.Map;

import com.cha103g2.productCategory.dao.ProductCategoryDAO;
import com.cha103g2.productCategory.entity.ProductCategory;

public class ProductCategoryServiceImpl2 implements ProductCategoryService {
	// 一個 service 實體對應一個 dao 實體
	private ProductCategoryDAO dao; // DAO 物件
	
	// 建構子
	public ProductCategoryServiceImpl2() {
//		dao = new ProductCategoryDAOImpl(HibernateUtil.getSessionFactory());
	}
	@Override
	public ProductCategory addProductCategory(ProductCategory productCategory) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductCategory updateProductCategory(ProductCategory productCategory) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteProductCategory(Integer productCategoryno) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ProductCategory getProductCategoryByProductCategoryno(Integer productCategoryno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductCategory> getAllProductCategorys(int currentPage) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getPageTotal() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<ProductCategory> getProductCategorysByCompositeQuery(Map<String, String[]> map) {
		// TODO Auto-generated method stub
		return null;
	}

}
