package com.cha103g2.productCategory.dao;

//import static idv.david.util.Constants.PAGE_MAX_RESULT;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.cha103g2.productCategory.entity.ProductCategory;

//import idv.david.emp.entity.Emp;

public class ProductCategoryDAOImpl implements ProductCategoryDAO {
	private static final int PAGE_MAX_RESULT = 0;
	// SessionFactory 為 thread-safe，可宣告為屬性讓請求執行緒們共用
	private SessionFactory factory;
	
	public ProductCategoryDAOImpl(SessionFactory factory) {
		this.factory = factory;
	}
	
	// Session 為 not thread-safe，所以此方法在各個增刪改查方法裡呼叫
	// 以避免請求執行緒共用了同個 Session
	private Session getSession() {
		return factory.getCurrentSession();
	}
	
	@Override
	public int insert(ProductCategory entity) {
		// 回傳給 service 剛新增成功的自增主鍵值
		return (Integer) getSession().save(entity);
	}

	@Override
	public int update(ProductCategory entity) {
		try {
			getSession().update(entity);
			return 1;
		} catch (Exception e) {
			return -1;
		}
	}

	@Override
	public int delete(Integer id) {
		ProductCategory productCategory = getSession().get(ProductCategory.class, id);
		if (productCategory != null) {
			getSession().delete(productCategory);
			// 回傳給 service，1代表刪除成功
			return 1;
		} else {
			// 回傳給 service，-1代表刪除失敗
			return -1;
		}
	}

	@Override
	public ProductCategory getById(Integer id) {
		return getSession().get(ProductCategory.class, id);
	}

	@Override
	public List<ProductCategory> getAll() {
		return getSession().createQuery("from Emp", ProductCategory.class).list();
	}

	@Override
	public List<ProductCategory> getAll(int currentPage) {
		int first = (currentPage - 1) * PAGE_MAX_RESULT;
		return getSession().createQuery("from ProductCategory", ProductCategory.class)
				.setFirstResult(first)
				.setMaxResults(PAGE_MAX_RESULT)
				.list();
	}

	@Override
	public long getTotal() {
		return getSession().createQuery("select count(*) from ProductCategory", Long.class).uniqueResult();
	}

}
