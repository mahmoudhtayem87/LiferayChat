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
 * Provides a wrapper for {@link ChatUserLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ChatUserLocalService
 * @generated
 */
public class ChatUserLocalServiceWrapper
	implements ChatUserLocalService, ServiceWrapper<ChatUserLocalService> {

	public ChatUserLocalServiceWrapper(
		ChatUserLocalService chatUserLocalService) {

		_chatUserLocalService = chatUserLocalService;
	}

	/**
	 * Adds the chat user to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ChatUserLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param chatUser the chat user
	 * @return the chat user that was added
	 */
	@Override
	public com.liferay.custom.chat.services.service.model.ChatUser addChatUser(
		com.liferay.custom.chat.services.service.model.ChatUser chatUser) {

		return _chatUserLocalService.addChatUser(chatUser);
	}

	/**
	 * Creates a new chat user with the primary key. Does not add the chat user to the database.
	 *
	 * @param userId the primary key for the new chat user
	 * @return the new chat user
	 */
	@Override
	public com.liferay.custom.chat.services.service.model.ChatUser
		createChatUser(long userId) {

		return _chatUserLocalService.createChatUser(userId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _chatUserLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the chat user from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ChatUserLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param chatUser the chat user
	 * @return the chat user that was removed
	 */
	@Override
	public com.liferay.custom.chat.services.service.model.ChatUser
		deleteChatUser(
			com.liferay.custom.chat.services.service.model.ChatUser chatUser) {

		return _chatUserLocalService.deleteChatUser(chatUser);
	}

	/**
	 * Deletes the chat user with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ChatUserLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param userId the primary key of the chat user
	 * @return the chat user that was removed
	 * @throws PortalException if a chat user with the primary key could not be found
	 */
	@Override
	public com.liferay.custom.chat.services.service.model.ChatUser
			deleteChatUser(long userId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _chatUserLocalService.deleteChatUser(userId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _chatUserLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _chatUserLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _chatUserLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _chatUserLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _chatUserLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.custom.chat.services.service.model.impl.ChatUserModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _chatUserLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.custom.chat.services.service.model.impl.ChatUserModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _chatUserLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _chatUserLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _chatUserLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.liferay.custom.chat.services.service.model.ChatUser
		fetchChatUser(long userId) {

		return _chatUserLocalService.fetchChatUser(userId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _chatUserLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the chat user with the primary key.
	 *
	 * @param userId the primary key of the chat user
	 * @return the chat user
	 * @throws PortalException if a chat user with the primary key could not be found
	 */
	@Override
	public com.liferay.custom.chat.services.service.model.ChatUser getChatUser(
			long userId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _chatUserLocalService.getChatUser(userId);
	}

	/**
	 * Returns a range of all the chat users.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.custom.chat.services.service.model.impl.ChatUserModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of chat users
	 * @param end the upper bound of the range of chat users (not inclusive)
	 * @return the range of chat users
	 */
	@Override
	public java.util.List
		<com.liferay.custom.chat.services.service.model.ChatUser> getChatUsers(
			int start, int end) {

		return _chatUserLocalService.getChatUsers(start, end);
	}

	/**
	 * Returns the number of chat users.
	 *
	 * @return the number of chat users
	 */
	@Override
	public int getChatUsersCount() {
		return _chatUserLocalService.getChatUsersCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _chatUserLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _chatUserLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _chatUserLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public java.util.List
		<com.liferay.custom.chat.services.service.model.ChatUser> getUsers(
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
			throws com.liferay.portal.kernel.exception.PortalException {

		return _chatUserLocalService.getUsers(serviceContext);
	}

	/**
	 * Updates the chat user in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ChatUserLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param chatUser the chat user
	 * @return the chat user that was updated
	 */
	@Override
	public com.liferay.custom.chat.services.service.model.ChatUser
		updateChatUser(
			com.liferay.custom.chat.services.service.model.ChatUser chatUser) {

		return _chatUserLocalService.updateChatUser(chatUser);
	}

	@Override
	public ChatUserLocalService getWrappedService() {
		return _chatUserLocalService;
	}

	@Override
	public void setWrappedService(ChatUserLocalService chatUserLocalService) {
		_chatUserLocalService = chatUserLocalService;
	}

	private ChatUserLocalService _chatUserLocalService;

}