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

import com.liferay.custom.chat.services.service.model.ChatUser;
import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing ChatUser in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ChatUserCacheModel
	implements CacheModel<ChatUser>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ChatUserCacheModel)) {
			return false;
		}

		ChatUserCacheModel chatUserCacheModel = (ChatUserCacheModel)object;

		if (userId == chatUserCacheModel.userId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, userId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{userId=");
		sb.append(userId);
		sb.append(", fullName=");
		sb.append(fullName);
		sb.append(", avatar=");
		sb.append(avatar);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ChatUser toEntityModel() {
		ChatUserImpl chatUserImpl = new ChatUserImpl();

		chatUserImpl.setUserId(userId);

		if (fullName == null) {
			chatUserImpl.setFullName("");
		}
		else {
			chatUserImpl.setFullName(fullName);
		}

		if (avatar == null) {
			chatUserImpl.setAvatar("");
		}
		else {
			chatUserImpl.setAvatar(avatar);
		}

		chatUserImpl.resetOriginalValues();

		return chatUserImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		userId = objectInput.readLong();
		fullName = objectInput.readUTF();
		avatar = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(userId);

		if (fullName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(fullName);
		}

		if (avatar == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(avatar);
		}
	}

	public long userId;
	public String fullName;
	public String avatar;

}