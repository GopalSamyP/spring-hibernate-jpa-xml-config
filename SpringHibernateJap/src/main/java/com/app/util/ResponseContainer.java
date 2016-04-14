package com.app.util;

import java.io.Serializable;

public class ResponseContainer implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String sucMsg;
	
	private String errMsg;
	
	private String desc;

	public String getSucMsg() {
		return sucMsg;
	}

	public void setSucMsg(String sucMsg) {
		this.sucMsg = sucMsg;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	

}
