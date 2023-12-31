package com.cha103g2.members.model.dao;

import java.sql.Date;

public class MembersVO implements java.io.Serializable{
	private Integer memno;
	private boolean memstatus;
	private String memname;
	private String memmail;
	private String memaccount;
	private String mempass;
	private Integer memgender;
	private String memid;
	private Date membir;
	private String memphone;
	private String memaddress;
	private Date memdate;
	
	public MembersVO() {

	}

	public MembersVO(Integer memno, boolean memstatus, String memname, String memmail, String memaccount, String mempass,
			Integer memgender, String memid, Date membir,String memphone ,String memaddress, Date memdate) {
		this.memno = memno;
		this.memstatus = memstatus;
		this.memname = memname;
		this.memmail = memmail;
		this.memaccount = memaccount;
		this.mempass = mempass;
		this.memgender = memgender;
		this.memid = memid;
		this.membir = membir;
		this.memphone = memphone;
		this.memaddress = memaddress;
		this.memdate = memdate;
	}

	public Integer getMemno() {
		return memno;
	}

	public void setMemno(Integer memno) {
		this.memno = memno;
	}

	public boolean getMemstatus() {
		return memstatus;
	}

	public void setMemstatus(boolean memstatus) {
		this.memstatus = memstatus;
	}

	public String getMemname() {
		return memname;
	}

	public void setMemname(String memname) {
		this.memname = memname;
	}

	public String getMemmail() {
		return memmail;
	}

	public void setMemmail(String memmail) {
		this.memmail = memmail;
	}

	public String getMemaccount() {
		return memaccount;
	}

	public void setMemaccount(String memaccount) {
		this.memaccount = memaccount;
	}

	public String getMempass() {
		return mempass;
	}

	public void setMempass(String mempass) {
		this.mempass = mempass;
	}

	public Integer getMemgender() {
		return memgender;
	}

	public void setMemgender(Integer memgender) {
		this.memgender = memgender;
	}

	public String getMemid() {
		return memid;
	}

	public void setMemid(String memid) {
		this.memid = memid;
	}

	public Date getMembir() {
		return membir;
	}

	public void setMembir(Date membir) {
		this.membir = membir;
	}

	public String getMemphone() {
		return memphone;
	}
	
	
	public void setMemphone(String memphone) {
		this.memphone = memphone;
	}

	public String getMemaddress() {
		return memaddress;
	}

	public void setMemaddress(String memaddress) {
		this.memaddress = memaddress;
	}

	public Date getMemdate() {
		return memdate;
	}

	public void setMemdate(Date memdate) {
		this.memdate = memdate;
	}

}
