package com.cha103g2.roomNum;

public class RoomNumVO implements java.io.Serializable{
	private Integer rNum;
	private Integer roomTypeNo;
	private Integer roomOrderNo;
	private String checkInName;
	private byte roomStatus;
	
	public Integer getrNum() {
		return rNum;
	}
	public void setrNum(Integer rNum) {
		this.rNum = rNum;
	}
	public Integer getRoomTypeNo() {
		return roomTypeNo;
	}
	public void setRoomTypeNo(Integer roomTypeNO) {
		this.roomTypeNo = roomTypeNO;
	}
	public Integer getRoomOrderNo() {
		return roomOrderNo;
	}
	public void setRoomOrderNo(Integer roomOrderNo) {
		this.roomOrderNo = roomOrderNo;
	}
	public String getCheckInName() {
		return checkInName;
	}
	public void setCheckInName(String checkInName) {
		this.checkInName = checkInName;
	}
	public byte getRoomStatus() {
		return roomStatus;
	}
	public void setRoomStatus(byte roomStatus) {
		this.roomStatus = roomStatus;
	}
	
}
