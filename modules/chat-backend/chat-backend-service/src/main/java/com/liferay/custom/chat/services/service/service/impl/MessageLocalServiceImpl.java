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
import com.liferay.custom.chat.services.service.service.base.MessageLocalServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionList;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.User;
import org.osgi.service.component.annotations.Component;

import java.util.Date;
import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.liferay.custom.chat.services.service.model.Message",
	service = AopService.class
)
public class MessageLocalServiceImpl extends MessageLocalServiceBaseImpl {
	public Message addMessage(String fromUserId, String toUserId, String message, String messageType) throws PortalException {
		long _fromUserId = Long.parseLong(fromUserId);
		long _toUserId = Long.parseLong(toUserId);
		User user = userLocalService.getUser(_fromUserId);
		Group group = groupLocalService.getGroup(user.getGroupId());

		// Generate primary key for the assignment.
		long messageId = counterLocalService.increment(Message.class.getName());
		Message msg = createMessage(messageId);
		msg.setCreateDate(new Date(System.currentTimeMillis()));
		msg.setFromUserId(_fromUserId);
		msg.setToUserId(_toUserId);
		msg.setMessageText(message);
		msg.setMessageType(messageType);
		return super.addMessage(msg);
	}

	private DynamicQuery getMessagesBetweenDynamicQuery(Object[] participants) {
		DynamicQuery dynamicQuery = super.dynamicQuery();
		dynamicQuery.add(RestrictionsFactoryUtil.in("fromUserId", participants));
		dynamicQuery.add(RestrictionsFactoryUtil.in("toUserId", participants));
		ProjectionList projectionList = ProjectionFactoryUtil.projectionList();
		projectionList.add(ProjectionFactoryUtil.groupProperty("fromUserId"));
		projectionList.add(ProjectionFactoryUtil.rowCount());
		//dynamicQuery.setProjection(projectionList);
		dynamicQuery.addOrder(OrderFactoryUtil.asc("createDate"));
		return dynamicQuery;
	}

	public List<Message> getMessagesBetween(long fromUserId, long toUserId)
	{
		Object[] data = new Object[2];
		data[0] = fromUserId;
		data[1] = toUserId;
		return  super.dynamicQuery(getMessagesBetweenDynamicQuery(data));
	}
}