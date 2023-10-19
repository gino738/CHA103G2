package com.cha103g2.roomOrder.model;

import java.sql.Date;

public class roomOrderVo {
	private Integer roomOrderNo;
	private Date roomOrderDate;
	private Date checkinDate;
	private Date checkoutDate;
	private Integer roomTypeNo;
	private Integer memNo;
	private Integer roomAmount;
	public Integer getRoomOrderNo() {
		return roomOrderNo;
	}
	public void setRoomOrderNo(Integer roomOrderNo) {
		this.roomOrderNo = roomOrderNo;
	}
	public Date getRoomOrderDate() {
		return roomOrderDate;
	}
	public void setRoomOrderDate(Date roomOrderDate) {
		this.roomOrderDate = roomOrderDate;
	}
	public Date getCheckinDate() {
		return checkinDate;
	}
	public void setCheckinDate(Date checkinDate) {
		this.checkinDate = checkinDate;
	}
	public Date getCheckoutDate() {
		return checkoutDate;
	}
	public void setCheckoutDate(Date checkoutDate) {
		this.checkoutDate = checkoutDate;
	}
	public Integer getRoomTypeNo() {
		return roomTypeNo;
	}
	public void setRoomTypeNo(Integer roomTypeNo) {
		this.roomTypeNo = roomTypeNo;
	}
	public Integer getMemNo() {
		return memNo;
	}
	public void setMemNo(Integer memNo) {
		this.memNo = memNo;
	}
	public Integer getRoomAmount() {
		return roomAmount;
	}
	public void setRoomAmount(Integer roomAmount) {
		this.roomAmount = roomAmount;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public byte getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(byte paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public boolean isPayStatus() {
		return payStatus;
	}
	public void setPayStatus(boolean payStatus) {
		this.payStatus = payStatus;
	}
	public byte getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(byte orderStatus) {
		this.orderStatus = orderStatus;
	}
	private Integer price;
	private byte paymentMethod;
	private boolean payStatus;
	private byte orderStatus;
	
	

}
