package team.wireless.entity;

public class meetingTime {
	
	private String time;
	private String date;
	
	
	
	public meetingTime(String time, String date) {
		super();
		this.time = time;
		this.date = date;
	}
	public meetingTime() {
		super();
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	
}
