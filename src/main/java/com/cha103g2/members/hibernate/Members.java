package com.cha103g2.members.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="department")


public class Members {
	@Id
	@Column(name="deptno")//若變數名稱和欄位名稱相同可以不用寫，但建議還是要寫
	private Integer deptno;
	
	@Column(name="dname")
	private String dname;
	
	@Column(name="loc")
	private String loc;
	
	public Dept() {
		super();
	}
	
	public Members(Integer deptno, String dname, String loc) {
	super();
	this.deptno = deptno;
	this.dname = dname;
	this.loc = loc;
	}
	
	public Integer getDeptno() {
		return deptno;
	}
	public void setDeptno(Integer deptno) {
		this.deptno = deptno;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	
	
}