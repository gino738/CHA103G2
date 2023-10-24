package com.cha103g2.department.dao;

import java.util.List;

import com.cha103g2.department.entity.DeptVO;

public interface DeptDAO_interface {
	//此介面定義增刪改查方法
	public Integer insert(DeptVO deptVO);
	
	public Integer update(DeptVO deptVO);
	
	public Integer delete(Integer deptNo);
	
	public DeptVO findByPrimaryKey(Integer deptNo);
	
	public List<DeptVO> getAll(); //宣告泛型<DeptVO>
	
	List<DeptVO> getAll(int currentPage);
	
	long getTotal();
	
	List<DeptVO> getDeptsList();

}