package com.cha103g2.productCategory.service;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.cha103g2.productCategory.dao.ProductCategoryDAO;
import com.cha103g2.productCategory.entity.ProductCategory;



//搭配 JSP / Thymeleaf 後端渲染畫面，將交易動作至於 view filter
//定義 ProductCategoryServiceImpl 類別，並實作 ProductCategoryService 介面
public class ProductCategoryServiceImpl implements ProductCategoryService {
	// 一個 service 實體對應一個 dao 實體
	private ProductCategoryDAO dao; // DAO 物件
	
	// 建構子
	public ProductCategoryServiceImpl() {
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
		return dao.getAll(currentPage); // 從 DAO 取得所有的 ProductCategory
	}

	@Override
	public int getPageTotal() {
//		long total = dao.getTotal();
//		// 計算ProductCategory數量每頁3筆的話總共有幾頁
//		int pageQty = (int)(total % PAGE_MAX_RESULT == 0 ? (total / PAGE_MAX_RESULT) : (total / PAGE_MAX_RESULT + 1));
//		return pageQty; // 計算總頁數
		return 0;
	}

	@Override
	public List<ProductCategory> getProductCategorysByCompositeQuery(Map<String, String[]> map) {
//		Map<String, String> query = new HashMap<>();
//		// Map.Entry即代表一組key-value
//		Set<Map.Entry<String, String[]>> entry = map.entrySet();
//		
//		for (Map.Entry<String, String[]> row : entry) {
//			String key = row.getKey();
//			// 因為請求參數裡包含了action，做個去除動作
//			if ("action".equals(key)) {
//				continue;
//			}
//			// 若是value為空即代表沒有查詢條件，做個去除動作
//			String value = row.getValue()[0];
//			if (value == null || value.isEmpty()) {
//				continue;
//			}
//			query.put(key, value);
//		}
//		
//		System.out.println(query);
//		
//		return dao.getByCompositeQuery(query);
		return null;
	}

}
