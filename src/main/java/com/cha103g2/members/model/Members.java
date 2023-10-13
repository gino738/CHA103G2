package com.cha103g2.members.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "members")
public class Members {
	
	@Id
	@Column(name = "mem_no") // 若變數名稱和欄位名稱相同可以不用寫，但建議還是要寫
	private Integer memno;

	@Column(name = "mem_status")
	private Boolean memstatus;

	@Column(name = "mem_name")
	private String memname;
	
	@Column(name = "mem_mail")
	private String memmail;

	@Column(name = "mem_account")
	private String memaccount;
	
	@Column(name = "mem_pass")
	private String mempass;

	@Column(name = "mem_gender")
	private Integer memgender;
	
	@Column(name = "mem_id")
	private String memid;

	@Column(name = "mem_bir")
	private Date membir;

	@Column(name = "mem_phone")
	private String memphone;

	@Column(name = "mem_address")
	private String memaddress;
	
	@Column(name = "mem_date")
	private Date memdate;
	
	public Members() {
		super();
	}

	public Members(Integer memno, boolean memstatus, String memname, String memmail, String memaccount, String mempass,
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

	public Boolean getMemstatus() {
		return memstatus;
	}

	public void setMemstatus(Boolean memstatus) {
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