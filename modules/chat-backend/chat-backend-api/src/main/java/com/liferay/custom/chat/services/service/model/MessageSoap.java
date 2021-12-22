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
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.liferay.custom.chat.services.service.service.http.MessageServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class MessageSoap implements Serializable {

	public static MessageSoap toSoapModel(Message model) {
		MessageSoap soapModel = new MessageSoap();

		soapModel.setMessageId(model.getMessageId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setToUserId(model.getToUserId());
		soapModel.setFromUserId(model.getFromUserId());
		soapModel.setMessageType(model.getMessageType());
		soapModel.setMessageText(model.getMessageText());
		soapModel.setSeen(model.isSeen());

		return soapModel;
	}

	public static MessageSoap[] toSoapModels(Message[] models) {
		MessageSoap[] soapModels = new MessageSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static MessageSoap[][] toSoapModels(Message[][] models) {
		MessageSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new MessageSoap[models.length][models[0].length];
		}
		else {
			soapModels = new MessageSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static MessageSoap[] toSoapModels(List<Message> models) {
		List<MessageSoap> soapModels = new ArrayList<MessageSoap>(
			models.size());

		for (Message model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new MessageSoap[soapModels.size()]);
	}

	public MessageSoap() {
	}

	public long getPrimaryKey() {
		return _messageId;
	}

	public void setPrimaryKey(long pk) {
		setMessageId(pk);
	}

	public long getMessageId() {
		return _messageId;
	}

	public void setMessageId(long messageId) {
		_messageId = messageId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public long getToUserId() {
		return _toUserId;
	}

	public void setToUserId(long toUserId) {
		_toUserId = toUserId;
	}

	public long getFromUserId() {
		return _fromUserId;
	}

	public void setFromUserId(long fromUserId) {
		_fromUserId = fromUserId;
	}

	public String getMessageType() {
		return _messageType;
	}

	public void setMessageType(String messageType) {
		_messageType = messageType;
	}

	public String getMessageText() {
		return _messageText;
	}

	public void setMessageText(String messageText) {
		_messageText = messageText;
	}

	public boolean getSeen() {
		return _seen;
	}

	public boolean isSeen() {
		return _seen;
	}

	public void setSeen(boolean seen) {
		_seen = seen;
	}

	private long _messageId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _toUserId;
	private long _fromUserId;
	private String _messageType;
	private String _messageText;
	private boolean _seen;

}