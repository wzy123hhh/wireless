package team.wireless.entity;

public class User {
	private int id;
	private String userName;
	private String userNum;
	private String userPwd;
	private String userPhone;
	private String userImg;
	
	private String identity;
	private String Mac;
	
	public User(Integer id ,String userName, String userNum, String userPwd, String userPhone, String userImg) {
		super();
		this.id = id;
		this.userName = userName;
		this.userNum = userNum;
		this.userPwd = userPwd;
		this.userPhone = userPhone;
		this.userImg = userImg;
	}

	public User(Integer id ,String userName, String userNum, String userPwd, String userPhone) {
		super();
		this.id = id;
		this.userName = userName;
		this.userNum = userNum;
		this.userPwd = userPwd;
		this.userPhone = userPhone;
	}

	public User() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserNum() {
		return userNum;
	}

	public void setUserNum(String userNum) {
		this.userNum = userNum;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserImg() {
		return userImg;
	}

	public void setUserImg(String userImg) {
		this.userImg = userImg;
	}

	public String getIdentity() {
		return identity;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}

	public String getMac() {
		return Mac;
	}

	public void setMac(String mac) {
		Mac = mac;
	}
	
	
	

	
	
	
	
}
