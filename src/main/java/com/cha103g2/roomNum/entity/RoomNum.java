package com.cha103g2.roomNum.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "room_num")
public class RoomNum implements java.io.Serializable{
	

	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="r_num")
	private Integer rNum;
	
	@Column(name="room_type_no")
	private Integer roomTypeNo;
	
	@Column(name="room_order_no")
	private Integer roomOrderNo;
	
	@Column(name="checkin_name")
	private String checkInName;
	
	@Column(name="room_status")
	private byte roomStatus;
	
	public RoomNum() {
		super();		
	}

	public RoomNum(Integer rNum, Integer roomTypeNo, Integer roomOrderNo, String checkInName, byte roomStatus) {
		super();
		this.rNum = rNum;
		this.roomTypeNo = roomTypeNo;
		this.roomOrderNo = roomOrderNo;
		this.checkInName = checkInName;
		this.roomStatus = roomStatus;
	}
	
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

	@Override
	public String toString() {
		return "RoomNum [rNum=" + rNum + ", roomTypeNo=" + roomTypeNo + ", roomOrderNo=" + roomOrderNo
				+ ", checkInName=" + checkInName + ", roomStatus=" + roomStatus + "]";
	}
	
}
