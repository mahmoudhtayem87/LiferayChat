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

import com.liferay.custom.chat.services.service.exception.NoSuchMessageException;
import com.liferay.custom.chat.services.service.model.Message;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the message service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MessageUtil
 * @generated
 */
@ProviderType
public interface MessagePersistence extends BasePersistence<Message> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link MessageUtil} to access the message persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the messages where toUserId = &#63; and fromUserId = &#63;.
	 *
	 * @param toUserId the to user ID
	 * @param fromUserId the from user ID
	 * @return the matching messages
	 */
	public java.util.List<Message> findByMessagesBetween(
		long toUserId, long fromUserId);

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
	public java.util.List<Message> findByMessagesBetween(
		long toUserId, long fromUserId, int start, int end);

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
	public java.util.List<Message> findByMessagesBetween(
		long toUserId, long fromUserId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Message>
			orderByComparator);

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
	public java.util.List<Message> findByMessagesBetween(
		long toUserId, long fromUserId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Message>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first message in the ordered set where toUserId = &#63; and fromUserId = &#63;.
	 *
	 * @param toUserId the to user ID
	 * @param fromUserId the from user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching message
	 * @throws NoSuchMessageException if a matching message could not be found
	 */
	public Message findByMessagesBetween_First(
			long toUserId, long fromUserId,
			com.liferay.portal.kernel.util.OrderByComparator<Message>
				orderByComparator)
		throws NoSuchMessageException;

	/**
	 * Returns the first message in the ordered set where toUserId = &#63; and fromUserId = &#63;.
	 *
	 * @param toUserId the to user ID
	 * @param fromUserId the from user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching message, or <code>null</code> if a matching message could not be found
	 */
	public Message fetchByMessagesBetween_First(
		long toUserId, long fromUserId,
		com.liferay.portal.kernel.util.OrderByComparator<Message>
			orderByComparator);

	/**
	 * Returns the last message in the ordered set where toUserId = &#63; and fromUserId = &#63;.
	 *
	 * @param toUserId the to user ID
	 * @param fromUserId the from user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching message
	 * @throws NoSuchMessageException if a matching message could not be found
	 */
	public Message findByMessagesBetween_Last(
			long toUserId, long fromUserId,
			com.liferay.portal.kernel.util.OrderByComparator<Message>
				orderByComparator)
		throws NoSuchMessageException;

	/**
	 * Returns the last message in the ordered set where toUserId = &#63; and fromUserId = &#63;.
	 *
	 * @param toUserId the to user ID
	 * @param fromUserId the from user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching message, or <code>null</code> if a matching message could not be found
	 */
	public Message fetchByMessagesBetween_Last(
		long toUserId, long fromUserId,
		com.liferay.portal.kernel.util.OrderByComparator<Message>
			orderByComparator);

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
	public Message[] findByMessagesBetween_PrevAndNext(
			long messageId, long toUserId, long fromUserId,
			com.liferay.portal.kernel.util.OrderByComparator<Message>
				orderByComparator)
		throws NoSuchMessageException;

	/**
	 * Removes all the messages where toUserId = &#63; and fromUserId = &#63; from the database.
	 *
	 * @param toUserId the to user ID
	 * @param fromUserId the from user ID
	 */
	public void removeByMessagesBetween(long toUserId, long fromUserId);

	/**
	 * Returns the number of messages where toUserId = &#63; and fromUserId = &#63;.
	 *
	 * @param toUserId the to user ID
	 * @param fromUserId the from user ID
	 * @return the number of matching messages
	 */
	public int countByMessagesBetween(long toUserId, long fromUserId);

	/**
	 * Returns the message where messageId = &#63; or throws a <code>NoSuchMessageException</code> if it could not be found.
	 *
	 * @param messageId the message ID
	 * @return the matching message
	 * @throws NoSuchMessageException if a matching message could not be found
	 */
	public Message findByMessageId(long messageId)
		throws NoSuchMessageException;

	/**
	 * Returns the message where messageId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param messageId the message ID
	 * @return the matching message, or <code>null</code> if a matching message could not be found
	 */
	public Message fetchByMessageId(long messageId);

	/**
	 * Returns the message where messageId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param messageId the message ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching message, or <code>null</code> if a matching message could not be found
	 */
	public Message fetchByMessageId(long messageId, boolean useFinderCache);

	/**
	 * Removes the message where messageId = &#63; from the database.
	 *
	 * @param messageId the message ID
	 * @return the message that was removed
	 */
	public Message removeByMessageId(long messageId)
		throws NoSuchMessageException;

	/**
	 * Returns the number of messages where messageId = &#63;.
	 *
	 * @param messageId the message ID
	 * @return the number of matching messages
	 */
	public int countByMessageId(long messageId);

	/**
	 * Caches the message in the entity cache if it is enabled.
	 *
	 * @param message the message
	 */
	public void cacheResult(Message message);

	/**
	 * Caches the messages in the entity cache if it is enabled.
	 *
	 * @param messages the messages
	 */
	public void cacheResult(java.util.List<Message> messages);

	/**
	 * Creates a new message with the primary key. Does not add the message to the database.
	 *
	 * @param messageId the primary key for the new message
	 * @return the new message
	 */
	public Message create(long messageId);

	/**
	 * Removes the message with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param messageId the primary key of the message
	 * @return the message that was removed
	 * @throws NoSuchMessageException if a message with the primary key could not be found
	 */
	public Message remove(long messageId) throws NoSuchMessageException;

	public Message updateImpl(Message message);

	/**
	 * Returns the message with the primary key or throws a <code>NoSuchMessageException</code> if it could not be found.
	 *
	 * @param messageId the primary key of the message
	 * @return the message
	 * @throws NoSuchMessageException if a message with the primary key could not be found
	 */
	public Message findByPrimaryKey(long messageId)
		throws NoSuchMessageException;

	/**
	 * Returns the message with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param messageId the primary key of the message
	 * @return the message, or <code>null</code> if a message with the primary key could not be found
	 */
	public Message fetchByPrimaryKey(long messageId);

	/**
	 * Returns all the messages.
	 *
	 * @return the messages
	 */
	public java.util.List<Message> findAll();

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
	public java.util.List<Message> findAll(int start, int end);

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
	public java.util.List<Message> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Message>
			orderByComparator);

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
	public java.util.List<Message> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Message>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the messages from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of messages.
	 *
	 * @return the number of messages
	 */
	public int countAll();

}