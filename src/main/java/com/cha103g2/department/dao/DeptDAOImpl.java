package com.cha103g2.department.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.cha103g2.department.entity.DeptVO;

public class DeptDAOImpl implements DeptDAO_interface{
	private SessionFactory factory;
	
	public DeptDAOImpl(SessionFactory factory) {
		this.factory = factory;
	}
	
	private Session getSession() {
		return factory.getCurrentSession();
	}
	
	@Override
	public Integer insert(DeptVO deptVO) {
		// 回傳給 service 剛新增成功的自增主鍵值
		return (Integer) getSession().save(deptVO);		
	}

	@Override
	public Integer update(DeptVO deptVO) {
		try {
			getSession().update(deptVO);
			return 1;
		} catch (Exception e) {
			return -1;
		}		
	}

	@Override
	public Integer delete(Integer deptNo) {
		DeptVO dept = getSession().get(DeptVO.class, deptNo);
		if (dept != null) {
			getSession().delete(dept);
			// 回傳給 service，1代表刪除成功
			return 1;
		} else {
			// 回傳給 service，-1代表刪除失敗
			return -1;
		}		
	}

	@Override
	public DeptVO findByPrimaryKey(Integer deptNo) {
		return getSession().get(DeptVO.class, deptNo);
	}

	@Override
	public List<DeptVO> getAll() {
		return getSession().createQuery("from DeptVO", DeptVO.class).list();
	}

	@Override
	public List<DeptVO> getAll(int currentPage) {
		// TODO Auto-generated method stub
		return null;
	}


}
