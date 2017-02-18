package com.entity;

import java.io.Serializable;

/**
 * 用户实体类
 * @author dhc
 * @version V1.0
 */
public class UserInfo implements Serializable{

	private static final long serialVersionUID = -1582797880159282371L;
	private int userId;
	private String userName;
	private String userPwd;
	

	public UserInfo() {
		super();
	}
	
	public UserInfo(String userName, String userPwd) {
		super();
		this.userName = userName;
		this.userPwd = userPwd;
	}
	
	public UserInfo(int userId, String userName, String userPwd) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPwd = userPwd;
	}

	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	
	
}
