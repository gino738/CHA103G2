package com.cha103g2.roomCalendar;

import java.sql.Date;

public class RoomCalendarVO implements java.io.Serializable{
	private Integer calendarNo;
	private Integer roomTypeno;
	private Date cDate;
	private Integer roomTotal;
	private Integer roomBooking;
	private Boolean available;	
	public Integer getCalendarNo() {
		return calendarNo;
	}
	public void setCalendarNO(Integer calendarNO) {
		this.calendarNo = calendarNO;
	}
	public Integer getRoomTypeno() {
		return roomTypeno;
	}
	public void setRoomTypeno(Integer roomTypeno) {
		this.roomTypeno = roomTypeno;
	}
	public Date getcDate() {
		return cDate;
	}
	public void setcDate(Date cDate) {
		this.cDate = cDate;
	}
	public Integer getRoomTotal() {
		return roomTotal;
	}
	public void setRoomTotal(Integer roomTotal) {
		this.roomTotal = roomTotal;
	}
	public Integer getRoomBooking() {
		return roomBooking;
	}
	public void setRoomBooking(Integer roomBooking) {
		this.roomBooking = roomBooking;
	}
	public Boolean getAvailable() {
		return available;
	}
	public void setAvailable(Boolean available) {
		this.available = available;
	}	
}
