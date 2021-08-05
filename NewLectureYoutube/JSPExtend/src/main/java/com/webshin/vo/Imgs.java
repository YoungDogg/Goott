package com.webshin.vo;

public class Imgs {
	private int no;

	public Imgs(int no, String imgName, String userId, String nickName) {
		super();
		this.no = no;
		ImgName = imgName;
		this.userId = userId;
		this.nickName = nickName;
	}

	
	private String ImgName;
	private String userId;
	private String nickName;

	public Imgs(String imgName, String userId, String nickName) {
		this(0, imgName, userId, nickName);
	}
	
	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getImgName() {
		return ImgName;
	}

	public void setImgName(String imgName) {
		ImgName = imgName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
}
