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
import com.liferay.custom.chat.services.service.service.base.ChatUserServiceBaseImpl;
import com.liferay.portal.aop.AopService;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;
import org.osgi.service.component.annotations.Component;

import java.util.List;
import java.util.Map;

/**
 * @author Mahmoud Hussein Tayem
 */
@Component(
	property = {
		"json.web.service.context.name=chat",
		"json.web.service.context.path=ChatUser"
	},
	service = AopService.class
)
public class ChatUserServiceImpl extends ChatUserServiceBaseImpl {
	public Map<String, ChatUser> getUsers(long groupId, ServiceContext serviceContext) throws PortalException
	{
		return this.chatUserLocalService.getUsers(groupId,serviceContext);
	}
}