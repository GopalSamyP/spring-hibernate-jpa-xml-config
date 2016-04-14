package com.app.model;

import java.io.Serializable;
import java.util.Date;

public class UserModel implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long userIntId;
	
	private String userName;
	
	private String password;
	
	private Date createdDate;
	
	private Date updatedDate;

	public Long getUserIntId() {
		return userIntId;
	}

	public void setUserIntId(Long userIntId) {
		this.userIntId = userIntId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	
	

}
