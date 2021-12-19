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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link MessageService}.
 *
 * @author Brian Wing Shun Chan
 * @see MessageService
 * @generated
 */
public class MessageServiceWrapper
	implements MessageService, ServiceWrapper<MessageService> {

	public MessageServiceWrapper(MessageService messageService) {
		_messageService = messageService;
	}

	@Override
	public com.liferay.custom.chat.services.service.model.Message addMessage(
			String fromUserId, String toUserId, String messageText,
			String messageType)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _messageService.addMessage(
			fromUserId, toUserId, messageText, messageType);
	}

	@Override
	public java.util.List
		<com.liferay.custom.chat.services.service.model.Message>
			getMessagesBetween(long fromUserId, long toUserId) {

		return _messageService.getMessagesBetween(fromUserId, toUserId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _messageService.getOSGiServiceIdentifier();
	}

	@Override
	public MessageService getWrappedService() {
		return _messageService;
	}

	@Override
	public void setWrappedService(MessageService messageService) {
		_messageService = messageService;
	}

	private MessageService _messageService;

}