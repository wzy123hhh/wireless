package team.wireless.entity;

import java.sql.Timestamp;

public class meetingRecord {
	private int meetingNo;
	private String teacherNo;
	private Timestamp checkinTime;
	private int isabsent;
	private int isaskforleave;
	private int askforleaveNo;
	
	
	public meetingRecord() {
		
	}
	public meetingRecord(int meetingNo, String teacherNo, Timestamp checkinTime, int isabsent, int isaskforleave,
			int askforleaveNo) {
		this.meetingNo = meetingNo;
		this.teacherNo = teacherNo;
		this.checkinTime = checkinTime;
		this.isabsent = isabsent;
		this.isaskforleave = isaskforleave;
		this.askforleaveNo = askforleaveNo;
	}
	public int getMeetingNo() {
		return meetingNo;
	}
	public void setMeetingNo(int meetingNo) {
		this.meetingNo = meetingNo;
	}
	public String getTeacherNo() {
		return teacherNo;
	}
	public void setTeacherNo(String teacherNo) {
		this.teacherNo = teacherNo;
	}
	public Timestamp getCheckinTime() {
		return checkinTime;
	}
	public void setCheckinTime(Timestamp checkinTime) {
		this.checkinTime = checkinTime;
	}
	public int getIsabsent() {
		return isabsent;
	}
	public void setIsabsent(int isabsent) {
		this.isabsent = isabsent;
	}
	public int getIsaskforleave() {
		return isaskforleave;
	}
	public void setIsaskforleave(int isaskforleave) {
		this.isaskforleave = isaskforleave;
	}
	public int getAskforleaveNo() {
		return askforleaveNo;
	}
	public void setAskforleaveNo(int askforleaveNo) {
		this.askforleaveNo = askforleaveNo;
	}
	
	
}
