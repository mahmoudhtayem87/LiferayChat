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

package com.liferay.custom.chat.services.service.service.persistence.impl;

import com.liferay.custom.chat.services.service.exception.NoSuchChatUserException;
import com.liferay.custom.chat.services.service.model.ChatUser;
import com.liferay.custom.chat.services.service.model.ChatUserTable;
import com.liferay.custom.chat.services.service.model.impl.ChatUserImpl;
import com.liferay.custom.chat.services.service.model.impl.ChatUserModelImpl;
import com.liferay.custom.chat.services.service.service.persistence.ChatUserPersistence;
import com.liferay.custom.chat.services.service.service.persistence.impl.constants.CHATPersistenceConstants;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the chat user service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = {ChatUserPersistence.class, BasePersistence.class})
public class ChatUserPersistenceImpl
	extends BasePersistenceImpl<ChatUser> implements ChatUserPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ChatUserUtil</code> to access the chat user persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ChatUserImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public ChatUserPersistenceImpl() {
		setModelClass(ChatUser.class);

		setModelImplClass(ChatUserImpl.class);
		setModelPKClass(long.class);

		setTable(ChatUserTable.INSTANCE);
	}

	/**
	 * Caches the chat user in the entity cache if it is enabled.
	 *
	 * @param chatUser the chat user
	 */
	@Override
	public void cacheResult(ChatUser chatUser) {
		entityCache.putResult(
			ChatUserImpl.class, chatUser.getPrimaryKey(), chatUser);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the chat users in the entity cache if it is enabled.
	 *
	 * @param chatUsers the chat users
	 */
	@Override
	public void cacheResult(List<ChatUser> chatUsers) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (chatUsers.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (ChatUser chatUser : chatUsers) {
			if (entityCache.getResult(
					ChatUserImpl.class, chatUser.getPrimaryKey()) == null) {

				cacheResult(chatUser);
			}
		}
	}

	/**
	 * Clears the cache for all chat users.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ChatUserImpl.class);

		finderCache.clearCache(ChatUserImpl.class);
	}

	/**
	 * Clears the cache for the chat user.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ChatUser chatUser) {
		entityCache.removeResult(ChatUserImpl.class, chatUser);
	}

	@Override
	public void clearCache(List<ChatUser> chatUsers) {
		for (ChatUser chatUser : chatUsers) {
			entityCache.removeResult(ChatUserImpl.class, chatUser);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(ChatUserImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(ChatUserImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new chat user with the primary key. Does not add the chat user to the database.
	 *
	 * @param userId the primary key for the new chat user
	 * @return the new chat user
	 */
	@Override
	public ChatUser create(long userId) {
		ChatUser chatUser = new ChatUserImpl();

		chatUser.setNew(true);
		chatUser.setPrimaryKey(userId);

		return chatUser;
	}

	/**
	 * Removes the chat user with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userId the primary key of the chat user
	 * @return the chat user that was removed
	 * @throws NoSuchChatUserException if a chat user with the primary key could not be found
	 */
	@Override
	public ChatUser remove(long userId) throws NoSuchChatUserException {
		return remove((Serializable)userId);
	}

	/**
	 * Removes the chat user with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the chat user
	 * @return the chat user that was removed
	 * @throws NoSuchChatUserException if a chat user with the primary key could not be found
	 */
	@Override
	public ChatUser remove(Serializable primaryKey)
		throws NoSuchChatUserException {

		Session session = null;

		try {
			session = openSession();

			ChatUser chatUser = (ChatUser)session.get(
				ChatUserImpl.class, primaryKey);

			if (chatUser == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchChatUserException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(chatUser);
		}
		catch (NoSuchChatUserException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected ChatUser removeImpl(ChatUser chatUser) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(chatUser)) {
				chatUser = (ChatUser)session.get(
					ChatUserImpl.class, chatUser.getPrimaryKeyObj());
			}

			if (chatUser != null) {
				session.delete(chatUser);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (chatUser != null) {
			clearCache(chatUser);
		}

		return chatUser;
	}

	@Override
	public ChatUser updateImpl(ChatUser chatUser) {
		boolean isNew = chatUser.isNew();

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(chatUser);
			}
			else {
				chatUser = (ChatUser)session.merge(chatUser);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(ChatUserImpl.class, chatUser, false, true);

		if (isNew) {
			chatUser.setNew(false);
		}

		chatUser.resetOriginalValues();

		return chatUser;
	}

	/**
	 * Returns the chat user with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the chat user
	 * @return the chat user
	 * @throws NoSuchChatUserException if a chat user with the primary key could not be found
	 */
	@Override
	public ChatUser findByPrimaryKey(Serializable primaryKey)
		throws NoSuchChatUserException {

		ChatUser chatUser = fetchByPrimaryKey(primaryKey);

		if (chatUser == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchChatUserException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return chatUser;
	}

	/**
	 * Returns the chat user with the primary key or throws a <code>NoSuchChatUserException</code> if it could not be found.
	 *
	 * @param userId the primary key of the chat user
	 * @return the chat user
	 * @throws NoSuchChatUserException if a chat user with the primary key could not be found
	 */
	@Override
	public ChatUser findByPrimaryKey(long userId)
		throws NoSuchChatUserException {

		return findByPrimaryKey((Serializable)userId);
	}

	/**
	 * Returns the chat user with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param userId the primary key of the chat user
	 * @return the chat user, or <code>null</code> if a chat user with the primary key could not be found
	 */
	@Override
	public ChatUser fetchByPrimaryKey(long userId) {
		return fetchByPrimaryKey((Serializable)userId);
	}

	/**
	 * Returns all the chat users.
	 *
	 * @return the chat users
	 */
	@Override
	public List<ChatUser> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<ChatUser> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<ChatUser> findAll(
		int start, int end, OrderByComparator<ChatUser> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<ChatUser> findAll(
		int start, int end, OrderByComparator<ChatUser> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<ChatUser> list = null;

		if (useFinderCache) {
			list = (List<ChatUser>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_CHATUSER);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_CHATUSER;

				sql = sql.concat(ChatUserModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<ChatUser>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the chat users from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ChatUser chatUser : findAll()) {
			remove(chatUser);
		}
	}

	/**
	 * Returns the number of chat users.
	 *
	 * @return the number of chat users
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_CHATUSER);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "userId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_CHATUSER;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ChatUserModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the chat user persistence.
	 */
	@Activate
	public void activate() {
		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		_finderPathWithPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(ChatUserImpl.class.getName());
	}

	@Override
	@Reference(
		target = CHATPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = CHATPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = CHATPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_CHATUSER =
		"SELECT chatUser FROM ChatUser chatUser";

	private static final String _SQL_COUNT_CHATUSER =
		"SELECT COUNT(chatUser) FROM ChatUser chatUser";

	private static final String _ORDER_BY_ENTITY_ALIAS = "chatUser.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No ChatUser exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		ChatUserPersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private ChatUserModelArgumentsResolver _chatUserModelArgumentsResolver;

}