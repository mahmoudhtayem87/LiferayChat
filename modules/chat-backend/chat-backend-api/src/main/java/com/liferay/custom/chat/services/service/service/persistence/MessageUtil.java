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

import com.liferay.custom.chat.services.service.model.Message;
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
 * The persistence utility for the message service. This utility wraps <code>com.liferay.custom.chat.services.service.service.persistence.impl.MessagePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MessagePersistence
 * @generated
 */
public class MessageUtil {

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
	public static void clearCache(Message message) {
		getPersistence().clearCache(message);
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
	public static Map<Serializable, Message> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Message> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Message> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Message> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Message> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Message update(Message message) {
		return getPersistence().update(message);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Message update(
		Message message, ServiceContext serviceContext) {

		return getPersistence().update(message, serviceContext);
	}

	/**
	 * Returns all the messages where toUserId = &#63; and fromUserId = &#63;.
	 *
	 * @param toUserId the to user ID
	 * @param fromUserId the from user ID
	 * @return the matching messages
	 */
	public static List<Message> findByMessagesBetween(
		long toUserId, long fromUserId) {

		return getPersistence().findByMessagesBetween(toUserId, fromUserId);
	}

	/**
	 * Returns a range of all the messages where toUserId = &#63; and fromUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MessageModelImpl</code>.
	 * </p>
	 *
	 * @param toUserId the to user ID
	 * @param fromUserId the from user ID
	 * @param start the lower bound of the range of messages
	 * @param end the upper bound of the range of messages (not inclusive)
	 * @return the range of matching messages
	 */
	public static List<Message> findByMessagesBetween(
		long toUserId, long fromUserId, int start, int end) {

		return getPersistence().findByMessagesBetween(
			toUserId, fromUserId, start, end);
	}

	/**
	 * Returns an ordered range of all the messages where toUserId = &#63; and fromUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MessageModelImpl</code>.
	 * </p>
	 *
	 * @param toUserId the to user ID
	 * @param fromUserId the from user ID
	 * @param start the lower bound of the range of messages
	 * @param end the upper bound of the range of messages (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching messages
	 */
	public static List<Message> findByMessagesBetween(
		long toUserId, long fromUserId, int start, int end,
		OrderByComparator<Message> orderByComparator) {

		return getPersistence().findByMessagesBetween(
			toUserId, fromUserId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the messages where toUserId = &#63; and fromUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MessageModelImpl</code>.
	 * </p>
	 *
	 * @param toUserId the to user ID
	 * @param fromUserId the from user ID
	 * @param start the lower bound of the range of messages
	 * @param end the upper bound of the range of messages (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching messages
	 */
	public static List<Message> findByMessagesBetween(
		long toUserId, long fromUserId, int start, int end,
		OrderByComparator<Message> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByMessagesBetween(
			toUserId, fromUserId, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first message in the ordered set where toUserId = &#63; and fromUserId = &#63;.
	 *
	 * @param toUserId the to user ID
	 * @param fromUserId the from user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching message
	 * @throws NoSuchMessageException if a matching message could not be found
	 */
	public static Message findByMessagesBetween_First(
			long toUserId, long fromUserId,
			OrderByComparator<Message> orderByComparator)
		throws com.liferay.custom.chat.services.service.exception.
			NoSuchMessageException {

		return getPersistence().findByMessagesBetween_First(
			toUserId, fromUserId, orderByComparator);
	}

	/**
	 * Returns the first message in the ordered set where toUserId = &#63; and fromUserId = &#63;.
	 *
	 * @param toUserId the to user ID
	 * @param fromUserId the from user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching message, or <code>null</code> if a matching message could not be found
	 */
	public static Message fetchByMessagesBetween_First(
		long toUserId, long fromUserId,
		OrderByComparator<Message> orderByComparator) {

		return getPersistence().fetchByMessagesBetween_First(
			toUserId, fromUserId, orderByComparator);
	}

	/**
	 * Returns the last message in the ordered set where toUserId = &#63; and fromUserId = &#63;.
	 *
	 * @param toUserId the to user ID
	 * @param fromUserId the from user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching message
	 * @throws NoSuchMessageException if a matching message could not be found
	 */
	public static Message findByMessagesBetween_Last(
			long toUserId, long fromUserId,
			OrderByComparator<Message> orderByComparator)
		throws com.liferay.custom.chat.services.service.exception.
			NoSuchMessageException {

		return getPersistence().findByMessagesBetween_Last(
			toUserId, fromUserId, orderByComparator);
	}

	/**
	 * Returns the last message in the ordered set where toUserId = &#63; and fromUserId = &#63;.
	 *
	 * @param toUserId the to user ID
	 * @param fromUserId the from user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching message, or <code>null</code> if a matching message could not be found
	 */
	public static Message fetchByMessagesBetween_Last(
		long toUserId, long fromUserId,
		OrderByComparator<Message> orderByComparator) {

		return getPersistence().fetchByMessagesBetween_Last(
			toUserId, fromUserId, orderByComparator);
	}

	/**
	 * Returns the messages before and after the current message in the ordered set where toUserId = &#63; and fromUserId = &#63;.
	 *
	 * @param messageId the primary key of the current message
	 * @param toUserId the to user ID
	 * @param fromUserId the from user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next message
	 * @throws NoSuchMessageException if a message with the primary key could not be found
	 */
	public static Message[] findByMessagesBetween_PrevAndNext(
			long messageId, long toUserId, long fromUserId,
			OrderByComparator<Message> orderByComparator)
		throws com.liferay.custom.chat.services.service.exception.
			NoSuchMessageException {

		return getPersistence().findByMessagesBetween_PrevAndNext(
			messageId, toUserId, fromUserId, orderByComparator);
	}

	/**
	 * Removes all the messages where toUserId = &#63; and fromUserId = &#63; from the database.
	 *
	 * @param toUserId the to user ID
	 * @param fromUserId the from user ID
	 */
	public static void removeByMessagesBetween(long toUserId, long fromUserId) {
		getPersistence().removeByMessagesBetween(toUserId, fromUserId);
	}

	/**
	 * Returns the number of messages where toUserId = &#63; and fromUserId = &#63;.
	 *
	 * @param toUserId the to user ID
	 * @param fromUserId the from user ID
	 * @return the number of matching messages
	 */
	public static int countByMessagesBetween(long toUserId, long fromUserId) {
		return getPersistence().countByMessagesBetween(toUserId, fromUserId);
	}

	/**
	 * Returns the message where messageId = &#63; or throws a <code>NoSuchMessageException</code> if it could not be found.
	 *
	 * @param messageId the message ID
	 * @return the matching message
	 * @throws NoSuchMessageException if a matching message could not be found
	 */
	public static Message findByMessageId(long messageId)
		throws com.liferay.custom.chat.services.service.exception.
			NoSuchMessageException {

		return getPersistence().findByMessageId(messageId);
	}

	/**
	 * Returns the message where messageId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param messageId the message ID
	 * @return the matching message, or <code>null</code> if a matching message could not be found
	 */
	public static Message fetchByMessageId(long messageId) {
		return getPersistence().fetchByMessageId(messageId);
	}

	/**
	 * Returns the message where messageId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param messageId the message ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching message, or <code>null</code> if a matching message could not be found
	 */
	public static Message fetchByMessageId(
		long messageId, boolean useFinderCache) {

		return getPersistence().fetchByMessageId(messageId, useFinderCache);
	}

	/**
	 * Removes the message where messageId = &#63; from the database.
	 *
	 * @param messageId the message ID
	 * @return the message that was removed
	 */
	public static Message removeByMessageId(long messageId)
		throws com.liferay.custom.chat.services.service.exception.
			NoSuchMessageException {

		return getPersistence().removeByMessageId(messageId);
	}

	/**
	 * Returns the number of messages where messageId = &#63;.
	 *
	 * @param messageId the message ID
	 * @return the number of matching messages
	 */
	public static int countByMessageId(long messageId) {
		return getPersistence().countByMessageId(messageId);
	}

	/**
	 * Caches the message in the entity cache if it is enabled.
	 *
	 * @param message the message
	 */
	public static void cacheResult(Message message) {
		getPersistence().cacheResult(message);
	}

	/**
	 * Caches the messages in the entity cache if it is enabled.
	 *
	 * @param messages the messages
	 */
	public static void cacheResult(List<Message> messages) {
		getPersistence().cacheResult(messages);
	}

	/**
	 * Creates a new message with the primary key. Does not add the message to the database.
	 *
	 * @param messageId the primary key for the new message
	 * @return the new message
	 */
	public static Message create(long messageId) {
		return getPersistence().create(messageId);
	}

	/**
	 * Removes the message with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param messageId the primary key of the message
	 * @return the message that was removed
	 * @throws NoSuchMessageException if a message with the primary key could not be found
	 */
	public static Message remove(long messageId)
		throws com.liferay.custom.chat.services.service.exception.
			NoSuchMessageException {

		return getPersistence().remove(messageId);
	}

	public static Message updateImpl(Message message) {
		return getPersistence().updateImpl(message);
	}

	/**
	 * Returns the message with the primary key or throws a <code>NoSuchMessageException</code> if it could not be found.
	 *
	 * @param messageId the primary key of the message
	 * @return the message
	 * @throws NoSuchMessageException if a message with the primary key could not be found
	 */
	public static Message findByPrimaryKey(long messageId)
		throws com.liferay.custom.chat.services.service.exception.
			NoSuchMessageException {

		return getPersistence().findByPrimaryKey(messageId);
	}

	/**
	 * Returns the message with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param messageId the primary key of the message
	 * @return the message, or <code>null</code> if a message with the primary key could not be found
	 */
	public static Message fetchByPrimaryKey(long messageId) {
		return getPersistence().fetchByPrimaryKey(messageId);
	}

	/**
	 * Returns all the messages.
	 *
	 * @return the messages
	 */
	public static List<Message> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the messages.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MessageModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of messages
	 * @param end the upper bound of the range of messages (not inclusive)
	 * @return the range of messages
	 */
	public static List<Message> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the messages.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MessageModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of messages
	 * @param end the upper bound of the range of messages (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of messages
	 */
	public static List<Message> findAll(
		int start, int end, OrderByComparator<Message> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the messages.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MessageModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of messages
	 * @param end the upper bound of the range of messages (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of messages
	 */
	public static List<Message> findAll(
		int start, int end, OrderByComparator<Message> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the messages from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of messages.
	 *
	 * @return the number of messages
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static MessagePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<MessagePersistence, MessagePersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(MessagePersistence.class);

		ServiceTracker<MessagePersistence, MessagePersistence> serviceTracker =
			new ServiceTracker<MessagePersistence, MessagePersistence>(
				bundle.getBundleContext(), MessagePersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}