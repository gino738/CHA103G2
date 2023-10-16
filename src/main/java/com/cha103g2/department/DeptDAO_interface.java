package com.cha103g2.department;

import java.util.List;

public interface DeptDAO_interface {
	//此介面定義增刪改查方法
	public void insert(DeptVO deptVO);
	public void update(DeptVO deptVO);
	public void delete(int deptNo);
	public DeptVO findByPrimartKey(int deptNo);
	public List<DeptVO> getAll(); //宣告泛型<DeptVO>

}
