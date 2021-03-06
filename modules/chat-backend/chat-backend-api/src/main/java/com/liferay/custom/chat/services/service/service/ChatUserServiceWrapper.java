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
 * Provides a wrapper for {@link ChatUserService}.
 *
 * @author Brian Wing Shun Chan
 * @see ChatUserService
 * @generated
 */
public class ChatUserServiceWrapper
	implements ChatUserService, ServiceWrapper<ChatUserService> {

	public ChatUserServiceWrapper(ChatUserService chatUserService) {
		_chatUserService = chatUserService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _chatUserService.getOSGiServiceIdentifier();
	}

	@Override
	public java.util.Map
		<String, com.liferay.custom.chat.services.service.model.ChatUser>
				getUsers(
					long groupId,
					com.liferay.portal.kernel.service.ServiceContext
						serviceContext)
			throws com.liferay.portal.kernel.exception.PortalException {

		return _chatUserService.getUsers(groupId, serviceContext);
	}

	@Override
	public ChatUserService getWrappedService() {
		return _chatUserService;
	}

	@Override
	public void setWrappedService(ChatUserService chatUserService) {
		_chatUserService = chatUserService;
	}

	private ChatUserService _chatUserService;

}