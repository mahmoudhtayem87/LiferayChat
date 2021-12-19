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

package com.liferay.custom.chat.services.service.service.persistence;

import com.liferay.custom.chat.services.service.model.ChatUser;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the chat user service. This utility wraps <code>com.liferay.custom.chat.services.service.service.persistence.impl.ChatUserPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ChatUserPersistence
 * @generated
 */
public class ChatUserUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(ChatUser chatUser) {
		getPersistence().clearCache(chatUser);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, ChatUser> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ChatUser> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ChatUser> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ChatUser> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ChatUser> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ChatUser update(ChatUser chatUser) {
		return getPersistence().update(chatUser);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ChatUser update(
		ChatUser chatUser, ServiceContext serviceContext) {

		return getPersistence().update(chatUser, serviceContext);
	}

	/**
	 * Caches the chat user in the entity cache if it is enabled.
	 *
	 * @param chatUser the chat user
	 */
	public static void cacheResult(ChatUser chatUser) {
		getPersistence().cacheResult(chatUser);
	}

	/**
	 * Caches the chat users in the entity cache if it is enabled.
	 *
	 * @param chatUsers the chat users
	 */
	public static void cacheResult(List<ChatUser> chatUsers) {
		getPersistence().cacheResult(chatUsers);
	}

	/**
	 * Creates a new chat user with the primary key. Does not add the chat user to the database.
	 *
	 * @param userId the primary key for the new chat user
	 * @return the new chat user
	 */
	public static ChatUser create(long userId) {
		return getPersistence().create(userId);
	}

	/**
	 * Removes the chat user with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userId the primary key of the chat user
	 * @return the chat user that was removed
	 * @throws NoSuchChatUserException if a chat user with the primary key could not be found
	 */
	public static ChatUser remove(long userId)
		throws com.liferay.custom.chat.services.service.exception.
			NoSuchChatUserException {

		return getPersistence().remove(userId);
	}

	public static ChatUser updateImpl(ChatUser chatUser) {
		return getPersistence().updateImpl(chatUser);
	}

	/**
	 * Returns the chat user with the primary key or throws a <code>NoSuchChatUserException</code> if it could not be found.
	 *
	 * @param userId the primary key of the chat user
	 * @return the chat user
	 * @throws NoSuchChatUserException if a chat user with the primary key could not be found
	 */
	public static ChatUser findByPrimaryKey(long userId)
		throws com.liferay.custom.chat.services.service.exception.
			NoSuchChatUserException {

		return getPersistence().findByPrimaryKey(userId);
	}

	/**
	 * Returns the chat user with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param userId the primary key of the chat user
	 * @return the chat user, or <code>null</code> if a chat user with the primary key could not be found
	 */
	public static ChatUser fetchByPrimaryKey(long userId) {
		return getPersistence().fetchByPrimaryKey(userId);
	}

	/**
	 * Returns all the chat users.
	 *
	 * @return the chat users
	 */
	public static List<ChatUser> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the chat users.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChatUserModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of chat users
	 * @param end the upper bound of the range of chat users (not inclusive)
	 * @return the range of chat users
	 */
	public static List<ChatUser> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the chat users.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChatUserModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of chat users
	 * @param end the upper bound of the range of chat users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of chat users
	 */
	public static List<ChatUser> findAll(
		int start, int end, OrderByComparator<ChatUser> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the chat users.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChatUserModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of chat users
	 * @param end the upper bound of the range of chat users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of chat users
	 */
	public static List<ChatUser> findAll(
		int start, int end, OrderByComparator<ChatUser> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the chat users from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of chat users.
	 *
	 * @return the number of chat users
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ChatUserPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<ChatUserPersistence, ChatUserPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(ChatUserPersistence.class);

		ServiceTracker<ChatUserPersistence, ChatUserPersistence>
			serviceTracker =
				new ServiceTracker<ChatUserPersistence, ChatUserPersistence>(
					bundle.getBundleContext(), ChatUserPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}