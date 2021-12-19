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

import com.liferay.custom.chat.services.service.exception.NoSuchChatUserException;
import com.liferay.custom.chat.services.service.model.ChatUser;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the chat user service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ChatUserUtil
 * @generated
 */
@ProviderType
public interface ChatUserPersistence extends BasePersistence<ChatUser> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ChatUserUtil} to access the chat user persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the chat user in the entity cache if it is enabled.
	 *
	 * @param chatUser the chat user
	 */
	public void cacheResult(ChatUser chatUser);

	/**
	 * Caches the chat users in the entity cache if it is enabled.
	 *
	 * @param chatUsers the chat users
	 */
	public void cacheResult(java.util.List<ChatUser> chatUsers);

	/**
	 * Creates a new chat user with the primary key. Does not add the chat user to the database.
	 *
	 * @param userId the primary key for the new chat user
	 * @return the new chat user
	 */
	public ChatUser create(long userId);

	/**
	 * Removes the chat user with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userId the primary key of the chat user
	 * @return the chat user that was removed
	 * @throws NoSuchChatUserException if a chat user with the primary key could not be found
	 */
	public ChatUser remove(long userId) throws NoSuchChatUserException;

	public ChatUser updateImpl(ChatUser chatUser);

	/**
	 * Returns the chat user with the primary key or throws a <code>NoSuchChatUserException</code> if it could not be found.
	 *
	 * @param userId the primary key of the chat user
	 * @return the chat user
	 * @throws NoSuchChatUserException if a chat user with the primary key could not be found
	 */
	public ChatUser findByPrimaryKey(long userId)
		throws NoSuchChatUserException;

	/**
	 * Returns the chat user with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param userId the primary key of the chat user
	 * @return the chat user, or <code>null</code> if a chat user with the primary key could not be found
	 */
	public ChatUser fetchByPrimaryKey(long userId);

	/**
	 * Returns all the chat users.
	 *
	 * @return the chat users
	 */
	public java.util.List<ChatUser> findAll();

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
	public java.util.List<ChatUser> findAll(int start, int end);

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
	public java.util.List<ChatUser> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ChatUser>
			orderByComparator);

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
	public java.util.List<ChatUser> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ChatUser>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the chat users from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of chat users.
	 *
	 * @return the number of chat users
	 */
	public int countAll();

}