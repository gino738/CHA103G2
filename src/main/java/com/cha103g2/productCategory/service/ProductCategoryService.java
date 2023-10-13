package com.cha103g2.productCategory.service;

import java.util.List;
import java.util.Map;

import com.cha103g2.productCategory.entity.ProductCategory;

public interface ProductCategoryService {
	
	ProductCategory addProductCategory(ProductCategory productCategory);
	
	ProductCategory updateProductCategory(ProductCategory productCategory);
	
	void deleteProductCategory(Integer productCategoryno);
	
	ProductCategory getProductCategoryByProductCategoryno(Integer productCategoryno);
	
	List<ProductCategory> getAllProductCategorys(int currentPage);
	
	int getPageTotal();
	
	List<ProductCategory> getProductCategorysByCompositeQuery(Map<String, String[]> map);
}
