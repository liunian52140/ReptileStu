package com.liunian.bean;

import com.liunian.Util.Utils;

/**
 * @version 0.99
 * @author liunian
 */
public class UserInfo {
	
	private String username;
	private String password;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = Utils.EncryptShaOne(password);
	}

}
