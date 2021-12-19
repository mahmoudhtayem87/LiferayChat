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

package com.liferay.custom.chat.services.service.service;

import com.liferay.custom.chat.services.service.model.Message;
import com.liferay.portal.kernel.exception.PortalException;

import java.util.List;

/**
 * Provides the remote service utility for Message. This utility wraps
 * <code>com.liferay.custom.chat.services.service.service.impl.MessageServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see MessageService
 * @generated
 */
public class MessageServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.custom.chat.services.service.service.impl.MessageServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static Message addMessage(
			String fromUserId, String toUserId, String messageText,
			String messageType)
		throws PortalException {

		return getService().addMessage(
			fromUserId, toUserId, messageText, messageType);
	}

	public static List<Message> getMessagesBetween(
		long fromUserId, long toUserId) {

		return getService().getMessagesBetween(fromUserId, toUserId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static MessageService getService() {
		return _service;
	}

	private static volatile MessageService _service;

}