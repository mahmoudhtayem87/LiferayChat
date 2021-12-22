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

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Message}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Message
 * @generated
 */
public class MessageWrapper
	extends BaseModelWrapper<Message>
	implements Message, ModelWrapper<Message> {

	public MessageWrapper(Message message) {
		super(message);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("messageId", getMessageId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("toUserId", getToUserId());
		attributes.put("fromUserId", getFromUserId());
		attributes.put("messageType", getMessageType());
		attributes.put("messageText", getMessageText());
		attributes.put("seen", isSeen());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long messageId = (Long)attributes.get("messageId");

		if (messageId != null) {
			setMessageId(messageId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long toUserId = (Long)attributes.get("toUserId");

		if (toUserId != null) {
			setToUserId(toUserId);
		}

		Long fromUserId = (Long)attributes.get("fromUserId");

		if (fromUserId != null) {
			setFromUserId(fromUserId);
		}

		String messageType = (String)attributes.get("messageType");

		if (messageType != null) {
			setMessageType(messageType);
		}

		String messageText = (String)attributes.get("messageText");

		if (messageText != null) {
			setMessageText(messageText);
		}

		Boolean seen = (Boolean)attributes.get("seen");

		if (seen != null) {
			setSeen(seen);
		}
	}

	@Override
	public Message cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the company ID of this message.
	 *
	 * @return the company ID of this message
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this message.
	 *
	 * @return the create date of this message
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the from user ID of this message.
	 *
	 * @return the from user ID of this message
	 */
	@Override
	public long getFromUserId() {
		return model.getFromUserId();
	}

	/**
	 * Returns the from user uuid of this message.
	 *
	 * @return the from user uuid of this message
	 */
	@Override
	public String getFromUserUuid() {
		return model.getFromUserUuid();
	}

	/**
	 * Returns the group ID of this message.
	 *
	 * @return the group ID of this message
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the message ID of this message.
	 *
	 * @return the message ID of this message
	 */
	@Override
	public long getMessageId() {
		return model.getMessageId();
	}

	/**
	 * Returns the message text of this message.
	 *
	 * @return the message text of this message
	 */
	@Override
	public String getMessageText() {
		return model.getMessageText();
	}

	/**
	 * Returns the message type of this message.
	 *
	 * @return the message type of this message
	 */
	@Override
	public String getMessageType() {
		return model.getMessageType();
	}

	/**
	 * Returns the modified date of this message.
	 *
	 * @return the modified date of this message
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this message.
	 *
	 * @return the primary key of this message
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the seen of this message.
	 *
	 * @return the seen of this message
	 */
	@Override
	public boolean getSeen() {
		return model.getSeen();
	}

	/**
	 * Returns the to user ID of this message.
	 *
	 * @return the to user ID of this message
	 */
	@Override
	public long getToUserId() {
		return model.getToUserId();
	}

	/**
	 * Returns the to user uuid of this message.
	 *
	 * @return the to user uuid of this message
	 */
	@Override
	public String getToUserUuid() {
		return model.getToUserUuid();
	}

	/**
	 * Returns the user ID of this message.
	 *
	 * @return the user ID of this message
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this message.
	 *
	 * @return the user name of this message
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this message.
	 *
	 * @return the user uuid of this message
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns <code>true</code> if this message is seen.
	 *
	 * @return <code>true</code> if this message is seen; <code>false</code> otherwise
	 */
	@Override
	public boolean isSeen() {
		return model.isSeen();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the company ID of this message.
	 *
	 * @param companyId the company ID of this message
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this message.
	 *
	 * @param createDate the create date of this message
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the from user ID of this message.
	 *
	 * @param fromUserId the from user ID of this message
	 */
	@Override
	public void setFromUserId(long fromUserId) {
		model.setFromUserId(fromUserId);
	}

	/**
	 * Sets the from user uuid of this message.
	 *
	 * @param fromUserUuid the from user uuid of this message
	 */
	@Override
	public void setFromUserUuid(String fromUserUuid) {
		model.setFromUserUuid(fromUserUuid);
	}

	/**
	 * Sets the group ID of this message.
	 *
	 * @param groupId the group ID of this message
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the message ID of this message.
	 *
	 * @param messageId the message ID of this message
	 */
	@Override
	public void setMessageId(long messageId) {
		model.setMessageId(messageId);
	}

	/**
	 * Sets the message text of this message.
	 *
	 * @param messageText the message text of this message
	 */
	@Override
	public void setMessageText(String messageText) {
		model.setMessageText(messageText);
	}

	/**
	 * Sets the message type of this message.
	 *
	 * @param messageType the message type of this message
	 */
	@Override
	public void setMessageType(String messageType) {
		model.setMessageType(messageType);
	}

	/**
	 * Sets the modified date of this message.
	 *
	 * @param modifiedDate the modified date of this message
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this message.
	 *
	 * @param primaryKey the primary key of this message
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets whether this message is seen.
	 *
	 * @param seen the seen of this message
	 */
	@Override
	public void setSeen(boolean seen) {
		model.setSeen(seen);
	}

	/**
	 * Sets the to user ID of this message.
	 *
	 * @param toUserId the to user ID of this message
	 */
	@Override
	public void setToUserId(long toUserId) {
		model.setToUserId(toUserId);
	}

	/**
	 * Sets the to user uuid of this message.
	 *
	 * @param toUserUuid the to user uuid of this message
	 */
	@Override
	public void setToUserUuid(String toUserUuid) {
		model.setToUserUuid(toUserUuid);
	}

	/**
	 * Sets the user ID of this message.
	 *
	 * @param userId the user ID of this message
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this message.
	 *
	 * @param userName the user name of this message
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this message.
	 *
	 * @param userUuid the user uuid of this message
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected MessageWrapper wrap(Message message) {
		return new MessageWrapper(message);
	}

}