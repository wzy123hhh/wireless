package team.wireless.entity;

public class stuInfo {
	private String stuName;
	private String stuNum;
	private String stuImg;
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public String getStuNum() {
		return stuNum;
	}
	public void setStuNum(String stuNum) {
		this.stuNum = stuNum;
	}
	public String getStuImg() {
		return stuImg;
	}
	public void setStuImg(String stuImg) {
		this.stuImg = stuImg;
	}
	public stuInfo(String stuName, String stuNum, String stuImg) {
		super();
		this.stuName = stuName;
		this.stuNum = stuNum;
		this.stuImg = stuImg;
	}
	public stuInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
