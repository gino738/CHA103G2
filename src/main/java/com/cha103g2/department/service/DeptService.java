package com.cha103g2.department.service;

import java.util.List;
import java.util.Map;

import com.cha103g2.department.entity.DeptVO;
import com.cha103g2.photoAlbum.PhotoAlbumVO;


public interface DeptService {
	DeptVO addDept(DeptVO dept);
	
	DeptVO updateDept(DeptVO dept);
	
	void deleteDept(Integer deptno);
	
	DeptVO getDeptByDeptno(Integer deptno);
	
	List<DeptVO> getAll();

	List<DeptVO> getAllDepts(int currentPage);

	int getPageTotal();
	

}
