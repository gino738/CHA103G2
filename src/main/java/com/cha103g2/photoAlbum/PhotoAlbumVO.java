package com.cha103g2.photoAlbum;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "photo_album")
//@NamedQuery(name = "getAllEmps", query = "from Emp where empno > :empno order by empno desc")
public class PhotoAlbumVO implements java.io.Serializable{
	@Id
	@Column(name = "alb_no")
	private Integer albNo;
	
	@Column(name = "mem_no")
	private Integer memNo;
	
	@Column(name = "alb_name")
	private String albName;

	@Column(name = "albphoto")
	private Byte albPhoto;
	
	@Column(name = "albdate")
	private Date albDate;
	
	
	public Integer getAlbNo() {
		return albNo;
	}
	public void setAlbNo(Integer albNo) {
		this.albNo = albNo;
	}
	public Integer getMemNo() {
		return memNo;
	}
	public void setMemNo(Integer memNo) {
		this.memNo = memNo;
	}
	public String getAlbName() {
		return albName;
	}
	public void setAlbName(String albName) {
		this.albName = albName;
	}
	public Byte getAlbPhoto() {
		return albPhoto;
	}
	public void setAlbPhoto(Byte albPhoto) {
		this.albPhoto = albPhoto;
	}
	public Date getAlbDate() {
		return albDate;
	}
	public void setAlbDate(Date albDate) {
		this.albDate = albDate;
	}


}
