package com.liferay.custom.chat.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.websocket.Session;

public class ActiveUser {

	public ActiveUser(String userId, String fullName)
	{
		this.fullName = fullName;
		this.userId = userId;
	}
    @JsonProperty("userId")
	private String userId;
    @JsonProperty("fullName")
    private String fullName;
    @JsonProperty("avatar")
    private String avatar;

	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String bs) {
		this.avatar = bs;
	}
	private String getFullName() {
		return fullName;
	}
	private void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	
	
	
}
