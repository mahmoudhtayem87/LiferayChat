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

package com.liferay.custom.chat.services.service.model.impl;

import com.liferay.custom.chat.services.service.model.Message;
import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Message in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class MessageCacheModel implements CacheModel<Message>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof MessageCacheModel)) {
			return false;
		}

		MessageCacheModel messageCacheModel = (MessageCacheModel)object;

		if (messageId == messageCacheModel.messageId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, messageId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{messageId=");
		sb.append(messageId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", toUserId=");
		sb.append(toUserId);
		sb.append(", fromUserId=");
		sb.append(fromUserId);
		sb.append(", messageType=");
		sb.append(messageType);
		sb.append(", messageText=");
		sb.append(messageText);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Message toEntityModel() {
		MessageImpl messageImpl = new MessageImpl();

		messageImpl.setMessageId(messageId);
		messageImpl.setGroupId(groupId);
		messageImpl.setCompanyId(companyId);
		messageImpl.setUserId(userId);

		if (userName == null) {
			messageImpl.setUserName("");
		}
		else {
			messageImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			messageImpl.setCreateDate(null);
		}
		else {
			messageImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			messageImpl.setModifiedDate(null);
		}
		else {
			messageImpl.setModifiedDate(new Date(modifiedDate));
		}

		messageImpl.setToUserId(toUserId);
		messageImpl.setFromUserId(fromUserId);

		if (messageType == null) {
			messageImpl.setMessageType("");
		}
		else {
			messageImpl.setMessageType(messageType);
		}

		if (messageText == null) {
			messageImpl.setMessageText("");
		}
		else {
			messageImpl.setMessageText(messageText);
		}

		messageImpl.resetOriginalValues();

		return messageImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		messageId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		toUserId = objectInput.readLong();

		fromUserId = objectInput.readLong();
		messageType = objectInput.readUTF();
		messageText = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(messageId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(toUserId);

		objectOutput.writeLong(fromUserId);

		if (messageType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(messageType);
		}

		if (messageText == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(messageText);
		}
	}

	public long messageId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long toUserId;
	public long fromUserId;
	public String messageType;
	public String messageText;

}