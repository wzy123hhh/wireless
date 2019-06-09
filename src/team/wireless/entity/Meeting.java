package team.wireless.entity;

import java.sql.Timestamp;

public class Meeting {
	
	private String meetingNo;
	private String Address;
	private Timestamp startTime;
	private int laterTime;
	private int saveno;
	private String meetingName;
	private String meetingIntroduce;
	private String createrNo;
	
	
	
	public Meeting() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Meeting(String meetingNo, String address, Timestamp startTime, int laterTime, int saveno, String meetingName,
			String meetingIntroduce,String createrNo) {
		super();
		this.meetingNo = meetingNo;
		Address = address;
		this.startTime = startTime;
		this.laterTime = laterTime;
		this.saveno = saveno;
		this.meetingName = meetingName;
		this.meetingIntroduce = meetingIntroduce;
		this.createrNo = createrNo;
	}
	
	public Meeting(String address, Timestamp startTime, String meetingName, String meetingIntroduce) {
		super();
		Address = address;
		this.startTime = startTime;
		this.meetingName = meetingName;
	}
	
	public String getCreaterNo() {
		return createrNo;
	}
	public void setCreaterNo(String createrNo) {
		this.createrNo = createrNo;
	}
	public String getMeetingNo() {
		return meetingNo;
	}
	public void setMeetingNo(String meetingNo) {
		this.meetingNo = meetingNo;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public Timestamp getStartTime() {
		return startTime;
	}
	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}
	public int getLaterTime() {
		return laterTime;
	}
	public void setLaterTime(int laterTime) {
		this.laterTime = laterTime;
	}
	public int getSaveno() {
		return saveno;
	}
	public void setSaveno(int saveno) {
		this.saveno = saveno;
	}
	public String getMeetingName() {
		return meetingName;
	}
	public void setMeetingName(String meetingName) {
		this.meetingName = meetingName;
	}
	public String getMeetingIntroduce() {
		return meetingIntroduce;
	}
	public void setMeetingIntroduce(String meetingIntroduce) {
		this.meetingIntroduce = meetingIntroduce;
	}
	
	
	
}
