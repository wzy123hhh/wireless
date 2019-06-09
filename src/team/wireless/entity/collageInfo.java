package team.wireless.entity;

public class collageInfo {
	private int collageNo;
	private String collageName;
	
	
	public collageInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public collageInfo(int collageNo, String collageName) {
		super();
		this.collageNo = collageNo;
		this.collageName = collageName;
	}
	public int getCollageNo() {
		return collageNo;
	}
	public void setCollageNo(int collageNo) {
		this.collageNo = collageNo;
	}
	public String getCollageName() {
		return collageName;
	}
	public void setCollageName(String collageName) {
		this.collageName = collageName;
	}
	
	
	
}
