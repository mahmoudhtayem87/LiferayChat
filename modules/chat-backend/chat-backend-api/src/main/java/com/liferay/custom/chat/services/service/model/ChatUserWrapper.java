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

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ChatUser}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ChatUser
 * @generated
 */
public class ChatUserWrapper
	extends BaseModelWrapper<ChatUser>
	implements ChatUser, ModelWrapper<ChatUser> {

	public ChatUserWrapper(ChatUser chatUser) {
		super(chatUser);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("userId", getUserId());
		attributes.put("fullName", getFullName());
		attributes.put("avatar", getAvatar());
		attributes.put("badge", getBadge());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String fullName = (String)attributes.get("fullName");

		if (fullName != null) {
			setFullName(fullName);
		}

		String avatar = (String)attributes.get("avatar");

		if (avatar != null) {
			setAvatar(avatar);
		}

		Integer badge = (Integer)attributes.get("badge");

		if (badge != null) {
			setBadge(badge);
		}
	}

	@Override
	public ChatUser cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the avatar of this chat user.
	 *
	 * @return the avatar of this chat user
	 */
	@Override
	public String getAvatar() {
		return model.getAvatar();
	}

	/**
	 * Returns the badge of this chat user.
	 *
	 * @return the badge of this chat user
	 */
	@Override
	public int getBadge() {
		return model.getBadge();
	}

	/**
	 * Returns the full name of this chat user.
	 *
	 * @return the full name of this chat user
	 */
	@Override
	public String getFullName() {
		return model.getFullName();
	}

	/**
	 * Returns the primary key of this chat user.
	 *
	 * @return the primary key of this chat user
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the user ID of this chat user.
	 *
	 * @return the user ID of this chat user
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user uuid of this chat user.
	 *
	 * @return the user uuid of this chat user
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the avatar of this chat user.
	 *
	 * @param avatar the avatar of this chat user
	 */
	@Override
	public void setAvatar(String avatar) {
		model.setAvatar(avatar);
	}

	/**
	 * Sets the badge of this chat user.
	 *
	 * @param badge the badge of this chat user
	 */
	@Override
	public void setBadge(int badge) {
		model.setBadge(badge);
	}

	/**
	 * Sets the full name of this chat user.
	 *
	 * @param fullName the full name of this chat user
	 */
	@Override
	public void setFullName(String fullName) {
		model.setFullName(fullName);
	}

	/**
	 * Sets the primary key of this chat user.
	 *
	 * @param primaryKey the primary key of this chat user
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the user ID of this chat user.
	 *
	 * @param userId the user ID of this chat user
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user uuid of this chat user.
	 *
	 * @param userUuid the user uuid of this chat user
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected ChatUserWrapper wrap(ChatUser chatUser) {
		return new ChatUserWrapper(chatUser);
	}

}