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

import com.liferay.custom.chat.services.service.model.Message;
import com.liferay.custom.chat.services.service.service.base.MessageServiceBaseImpl;
import com.liferay.portal.aop.AopService;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;
import org.osgi.service.component.annotations.Component;
import java.util.List;
/**
 * @author Mahmoud Hussein Tayem
 */
@Component(
	property = {
		"json.web.service.context.name=chat",
		"json.web.service.context.path=Message"
	},
	service = AopService.class
)
public class MessageServiceImpl extends MessageServiceBaseImpl {
	public Message addMessage(String fromUserId, String toUserId, String messageText, String messageType) throws PortalException
	{
		return this.messageLocalService.addMessage( fromUserId,  toUserId,  messageText,  messageType);
	}
	public List<Object> getUnreadMessagesWith(long userId)
	{
		return this.messageLocalService.getMessagesWith(userId,false);
	}
	public  List<Message> getMessagesBetween(long fromUserId, long toUserId)
	{
		return this.messageLocalService.getMessagesBetween(fromUserId,toUserId);
	}
	public Message markMessageSeen(long messageId, ServiceContext serviceContext) throws PortalException
	{
		return this.messageLocalService.markMessageSeen(messageId,serviceContext);
	}
}