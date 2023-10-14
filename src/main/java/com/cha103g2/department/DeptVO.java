package com.cha103g2.department;

public class DeptVO implements java.io.Serializable{
	private int deptNo;
	private String deptName;
	
	public DeptVO() {
		
	}
	
	public DeptVO(int deptNo, String deptName) {
		this.deptNo = deptNo;
		this.deptName = deptName;
	}
	
	public int getDeptNo() {
		return deptNo;
	}
	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}


}
