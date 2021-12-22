/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.custom.chat.services.service.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.liferay.custom.chat.services.service.service.http.ChatUserServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class ChatUserSoap implements Serializable {

	public static ChatUserSoap toSoapModel(ChatUser model) {
		ChatUserSoap soapModel = new ChatUserSoap();

		soapModel.setUserId(model.getUserId());
		soapModel.setFullName(model.getFullName());
		soapModel.setAvatar(model.getAvatar());
		soapModel.setBadge(model.getBadge());

		return soapModel;
	}

	public static ChatUserSoap[] toSoapModels(ChatUser[] models) {
		ChatUserSoap[] soapModels = new ChatUserSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ChatUserSoap[][] toSoapModels(ChatUser[][] models) {
		ChatUserSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ChatUserSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ChatUserSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ChatUserSoap[] toSoapModels(List<ChatUser> models) {
		List<ChatUserSoap> soapModels = new ArrayList<ChatUserSoap>(
			models.size());

		for (ChatUser model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ChatUserSoap[soapModels.size()]);
	}

	public ChatUserSoap() {
	}

	public long getPrimaryKey() {
		return _userId;
	}

	public void setPrimaryKey(long pk) {
		setUserId(pk);
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getFullName() {
		return _fullName;
	}

	public void setFullName(String fullName) {
		_fullName = fullName;
	}

	public String getAvatar() {
		return _avatar;
	}

	public void setAvatar(String avatar) {
		_avatar = avatar;
	}

	public int getBadge() {
		return _badge;
	}

	public void setBadge(int badge) {
		_badge = badge;
	}

	private long _userId;
	private String _fullName;
	private String _avatar;
	private int _badge;

}