package com.cha103g2.productCategory.dao;

import java.util.List;
import java.util.Map;

import com.cha103g2.productCategory.entity.ProductCategory;

public interface ProductCategoryDAO {
	
	int insert(ProductCategory entity);

	int update(ProductCategory entity);
	
	int delete(Integer id);
	 
	ProductCategory getById(Integer id);
	
	List<ProductCategory> getAll();
	
//	List<ProductCategory> getByCompositeQuery(Map<String, String> map);
	
	List<ProductCategory> getAll(int currentPage);
	
	long getTotal();
}
