package com.cha103g2.department.dao;

import static com.cha103g2.department.service.Constants.PAGE_MAX_RESULT;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.cha103g2.util.HibernateUtil;
import com.cha103g2.department.entity.DeptVO;
import com.cha103g2.employee.entity.EmpVO;
import com.cha103g2.filter.OpenSessionInViewFilter;

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

	@Override//用來顯示部門下拉選單
	public List<DeptVO> getAll() {
		List deptList = getSession().createQuery("from DeptVO", DeptVO.class).list();
		return deptList;

	}

	@Override//顯示在查全部頁面
	public List<DeptVO> getAll(int currentPage) {
		int first = (currentPage - 1) * PAGE_MAX_RESULT;
		return getSession().createQuery("from DeptVO", DeptVO.class)
				.setFirstResult(first)
				.setMaxResults(PAGE_MAX_RESULT)
				.list();
	}

	@Override
	public long getTotal() {
		return getSession().createQuery("select count(*) from DeptVO", Long.class).uniqueResult();
	}
	
	public List<DeptVO> getDeptsList(){
//		Session session = getSession();
//		session.beginTransaction();
		return getSession().createQuery("from DeptVO", DeptVO.class).list();
	}
	
	public void getEmpJoin(){
		 //使用原生資料庫語法指令查詢

		//Session session = getSession();
		List<Object[]> resultList = getSession().createNativeQuery("SELECT dept_no, dept_name FROM department WHERE emp_no = ? ").getResultList();
		for (Object[] row : resultList) { 
			int a = (int) row[0];
			int b = (int) row[1];
			int c = (int) row[2];
			String checkInname = (String) row[3];
			int roomStatus = (byte) row[4];
			System.out.println(
					a + ":" + b + ":" + c + ":" );
		}
			
	}//SELECT dept_no, dept_name FROM department WHERE emp_no = ? 
	public static void main(String[] args) {

	}
}

	
	
	
	


	




