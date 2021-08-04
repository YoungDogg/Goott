package com.goot6.jspbasicvo;

import java.util.Date;

public class MemberVo {
	private String userid;
	private String userPwd;
	private String userName;
	private String gender;
	private String email;
	private int point;
	private Date registerDate;
	
	
	public MemberVo() {
		
	}
	
	public MemberVo(String userid, String userPwd, String userName, String gender, String email, int point,
			Date registerDate) {
		super();
		this.userid = userid;
		this.userPwd = userPwd;
		this.userName = userName;
		this.gender = gender;
		this.email = email;
		this.point = point;
		this.registerDate = registerDate;
	}
	
	
	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public Date getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}
	public String getUserid() {
		return userid;
	}
	@Override
	public String toString() {
		return "MemberVo [userid=" + userid + ", userPwd=" + userPwd + ", userName=" + userName + ", gender=" + gender
				+ ", email=" + email + ", point=" + point + ", registerDate=" + registerDate + "]";
	}
	
	
	
	
}
