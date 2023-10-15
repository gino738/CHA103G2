package com.cha103g2.productCategory.dao;

import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.cha103g2.productCategory.entity.ProductCategory;

import util.HibernateUtil;


public class ProductCategoryDAOImpl implements ProductCategoryDAO {
	
	// SessionFactory 為 thread-safe，可宣告為屬性讓請求執行緒們共用
	private SessionFactory sessionFactory;
	
	public ProductCategoryDAOImpl() {
		this.sessionFactory = HibernateUtil.getSessionFactory();
	}
	
//	// Session 為 not thread-safe，所以此方法在各個增刪改查方法裡呼叫
//	// 以避免請求執行緒共用了同個 Session
//	private Session getSession() {
//		return factory.getCurrentSession();
//	}
	
	@Override
	public int insert(ProductCategory entity) {
		// 回傳給 service 剛新增成功的自增主鍵值
		Session session = sessionFactory.getCurrentSession();
		session.save(entity);
		return 1;
	}

	@Override
	public int update(ProductCategory entity) {
		Session session = sessionFactory.getCurrentSession();
		session.save(entity);
		return 1;
	}

	@Override
	public int delete(ProductCategory id) {
		try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(id);
            transaction.commit();
        }
        return 1;
	}

	@Override
	public ProductCategory getById(Integer id) {
		Session session = sessionFactory.getCurrentSession();
        return session.get(ProductCategory.class, id);
	}

	@Override
	public List<ProductCategory> getAll() {
		Session session = sessionFactory.getCurrentSession();
        Query<ProductCategory> query = session.createQuery("from product_category", ProductCategory.class);
        return query.list();
	}
	
//	 @Override
//	    public List<ProductCategory> getByCompositeQuery(Map<String, String> map) {
//	        // 實現複合查詢的邏輯
//	        return null;
//	    }

	@Override
	public List<ProductCategory> getAll(int currentPage) {
		Session session = sessionFactory.getCurrentSession();
        Query<ProductCategory> query = session.createQuery("from product_category", ProductCategory.class);
        query.setFirstResult((currentPage - 1) * 10);
        query.setMaxResults(10);
        return query.list();
	}

	@Override
	public long getTotal() {
		Session session = sessionFactory.getCurrentSession();
        Query<Long> query = session.createQuery("select count(*) from product_category", Long.class);
        return query.uniqueResult();	}

	@Override
	public List<ProductCategory> getByCompositeQuery(Map<String, String> map) {
		// TODO Auto-generated method stub
		return null;
	}

}
