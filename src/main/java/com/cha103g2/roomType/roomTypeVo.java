package com.cha103g2.roomType;

import java.sql.Date;

public class roomTypeVo {
	private Integer roomTypeNo;
	private String roomName;
	private String rtype;
	private Integer roomTotal;
	private Integer price;
	private Integer normalPrice;
	private Integer holidayPrice;
	private Integer bridgeHolidayPrice;
	private String notice;
	private String facility;
	private boolean rTypeStatus;
	
	public Integer getRoomTypeNo() {
		return roomTypeNo;
	}
	public void setRoomTypeNo(Integer roomTypeNo) {
		this.roomTypeNo = roomTypeNo;
	}
	public String getRoomName() {
		return roomName;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	public String getRtype() {
		return rtype;
	}
	public void setRtype(String rtype) {
		this.rtype = rtype;
	}
	public Integer getRoomTotal() {
		return roomTotal;
	}
	public void setRoomTotal(Integer roomTotal) {
		this.roomTotal = roomTotal;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Integer getNormalPrice() {
		return normalPrice;
	}
	public void setNormalPrice(Integer normalPrice) {
		this.normalPrice = normalPrice;
	}
	public Integer getHolidayPrice() {
		return holidayPrice;
	}
	public void setHolidayPrice(Integer holidayPrice) {
		this.holidayPrice = holidayPrice;
	}
	public Integer getBridgeHolidayPrice() {
		return bridgeHolidayPrice;
	}
	public void setBridgeHolidayPrice(Integer bridgeHolidayPrice) {
		this.bridgeHolidayPrice = bridgeHolidayPrice;
	}
	public String getNotice() {
		return notice;
	}
	public void setNotice(String notice) {
		this.notice = notice;
	}
	public String getFacility() {
		return facility;
	}
	public void setFacility(String facility) {
		this.facility = facility;
	}
	public boolean isrTypeStatus() {
		return rTypeStatus;
	}
	public void setrTypeStatus(boolean rTypeStatus) {
		this.rTypeStatus = rTypeStatus;
	}
	
	
}
