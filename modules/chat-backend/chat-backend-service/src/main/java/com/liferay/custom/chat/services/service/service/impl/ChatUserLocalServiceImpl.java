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

package com.liferay.custom.chat.services.service.service.impl;

import com.liferay.custom.chat.services.service.model.ChatUser;
import com.liferay.custom.chat.services.service.service.MessageService;
import com.liferay.custom.chat.services.service.service.base.ChatUserLocalServiceBaseImpl;
import com.liferay.portal.aop.AopService;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.UserConstants;
import com.liferay.portal.kernel.service.ServiceContext;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Mahmoud Hussein Tayem
 */
@Component(
	property = "model.class.name=com.liferay.custom.chat.services.service.model.ChatUser",
	service = AopService.class
)
public class ChatUserLocalServiceImpl extends ChatUserLocalServiceBaseImpl {
	public Map<String, ChatUser> getUsers(long groupId,ServiceContext serviceContext) throws PortalException, PortalException {

		Map<String, ChatUser> users_map = new HashMap<String, ChatUser>();
		long _userId = serviceContext.getUserId();
		List<Object> badges = messageService.getUnreadMessagesWith(_userId);
		long[] users = userLocalService.getGroupUserIds(groupId);
		for (long userId: users
		) {
			User user = userLocalService.getUser(userId);
			ChatUser chatUser = createChatUser(userId);
			String userAvatar = "/image/"+
					UserConstants.getPortraitURL
							("",user.isMale(),user.getPortraitId(),user.getUserUuid());
			chatUser.setFullName(user.getFullName());
			chatUser.setAvatar(userAvatar);
			users_map.put(userId+"",chatUser);
		}
		for(Object badge : badges)
		{
			System.out.println(badge.toString());
			Object[] info = (Object[])badge;
			users_map.get(info[0].toString()).setBadge(Integer.parseInt(info[1].toString()));
		}

		return users_map;
	}
	@Reference
	MessageService messageService;
}