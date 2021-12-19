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

import com.liferay.custom.chat.services.service.exception.NoSuchMessageException;
import com.liferay.custom.chat.services.service.model.Message;
import com.liferay.custom.chat.services.service.model.MessageTable;
import com.liferay.custom.chat.services.service.model.impl.MessageImpl;
import com.liferay.custom.chat.services.service.model.impl.MessageModelImpl;
import com.liferay.custom.chat.services.service.service.persistence.MessagePersistence;
import com.liferay.custom.chat.services.service.service.persistence.impl.constants.CHATPersistenceConstants;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the message service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = {MessagePersistence.class, BasePersistence.class})
public class MessagePersistenceImpl
	extends BasePersistenceImpl<Message> implements MessagePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>MessageUtil</code> to access the message persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		MessageImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByMessagesBetween;
	private FinderPath _finderPathWithoutPaginationFindByMessagesBetween;
	private FinderPath _finderPathCountByMessagesBetween;

	/**
	 * Returns all the messages where toUserId = &#63; and fromUserId = &#63;.
	 *
	 * @param toUserId the to user ID
	 * @param fromUserId the from user ID
	 * @return the matching messages
	 */
	@Override
	public List<Message> findByMessagesBetween(long toUserId, long fromUserId) {
		return findByMessagesBetween(
			toUserId, fromUserId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Message> findByMessagesBetween(
		long toUserId, long fromUserId, int start, int end) {

		return findByMessagesBetween(toUserId, fromUserId, start, end, null);
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
	@Override
	public List<Message> findByMessagesBetween(
		long toUserId, long fromUserId, int start, int end,
		OrderByComparator<Message> orderByComparator) {

		return findByMessagesBetween(
			toUserId, fromUserId, start, end, orderByComparator, true);
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
	@Override
	public List<Message> findByMessagesBetween(
		long toUserId, long fromUserId, int start, int end,
		OrderByComparator<Message> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByMessagesBetween;
				finderArgs = new Object[] {toUserId, fromUserId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByMessagesBetween;
			finderArgs = new Object[] {
				toUserId, fromUserId, start, end, orderByComparator
			};
		}

		List<Message> list = null;

		if (useFinderCache) {
			list = (List<Message>)finderCache.getResult(finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (Message message : list) {
					if ((toUserId != message.getToUserId()) ||
						(fromUserId != message.getFromUserId())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_MESSAGE_WHERE);

			sb.append(_FINDER_COLUMN_MESSAGESBETWEEN_TOUSERID_2);

			sb.append(_FINDER_COLUMN_MESSAGESBETWEEN_FROMUSERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(MessageModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(toUserId);

				queryPos.add(fromUserId);

				list = (List<Message>)QueryUtil.list(
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
	 * Returns the first message in the ordered set where toUserId = &#63; and fromUserId = &#63;.
	 *
	 * @param toUserId the to user ID
	 * @param fromUserId the from user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching message
	 * @throws NoSuchMessageException if a matching message could not be found
	 */
	@Override
	public Message findByMessagesBetween_First(
			long toUserId, long fromUserId,
			OrderByComparator<Message> orderByComparator)
		throws NoSuchMessageException {

		Message message = fetchByMessagesBetween_First(
			toUserId, fromUserId, orderByComparator);

		if (message != null) {
			return message;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("toUserId=");
		sb.append(toUserId);

		sb.append(", fromUserId=");
		sb.append(fromUserId);

		sb.append("}");

		throw new NoSuchMessageException(sb.toString());
	}

	/**
	 * Returns the first message in the ordered set where toUserId = &#63; and fromUserId = &#63;.
	 *
	 * @param toUserId the to user ID
	 * @param fromUserId the from user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching message, or <code>null</code> if a matching message could not be found
	 */
	@Override
	public Message fetchByMessagesBetween_First(
		long toUserId, long fromUserId,
		OrderByComparator<Message> orderByComparator) {

		List<Message> list = findByMessagesBetween(
			toUserId, fromUserId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Message findByMessagesBetween_Last(
			long toUserId, long fromUserId,
			OrderByComparator<Message> orderByComparator)
		throws NoSuchMessageException {

		Message message = fetchByMessagesBetween_Last(
			toUserId, fromUserId, orderByComparator);

		if (message != null) {
			return message;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("toUserId=");
		sb.append(toUserId);

		sb.append(", fromUserId=");
		sb.append(fromUserId);

		sb.append("}");

		throw new NoSuchMessageException(sb.toString());
	}

	/**
	 * Returns the last message in the ordered set where toUserId = &#63; and fromUserId = &#63;.
	 *
	 * @param toUserId the to user ID
	 * @param fromUserId the from user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching message, or <code>null</code> if a matching message could not be found
	 */
	@Override
	public Message fetchByMessagesBetween_Last(
		long toUserId, long fromUserId,
		OrderByComparator<Message> orderByComparator) {

		int count = countByMessagesBetween(toUserId, fromUserId);

		if (count == 0) {
			return null;
		}

		List<Message> list = findByMessagesBetween(
			toUserId, fromUserId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Message[] findByMessagesBetween_PrevAndNext(
			long messageId, long toUserId, long fromUserId,
			OrderByComparator<Message> orderByComparator)
		throws NoSuchMessageException {

		Message message = findByPrimaryKey(messageId);

		Session session = null;

		try {
			session = openSession();

			Message[] array = new MessageImpl[3];

			array[0] = getByMessagesBetween_PrevAndNext(
				session, message, toUserId, fromUserId, orderByComparator,
				true);

			array[1] = message;

			array[2] = getByMessagesBetween_PrevAndNext(
				session, message, toUserId, fromUserId, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Message getByMessagesBetween_PrevAndNext(
		Session session, Message message, long toUserId, long fromUserId,
		OrderByComparator<Message> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_MESSAGE_WHERE);

		sb.append(_FINDER_COLUMN_MESSAGESBETWEEN_TOUSERID_2);

		sb.append(_FINDER_COLUMN_MESSAGESBETWEEN_FROMUSERID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(MessageModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(toUserId);

		queryPos.add(fromUserId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(message)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Message> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the messages where toUserId = &#63; and fromUserId = &#63; from the database.
	 *
	 * @param toUserId the to user ID
	 * @param fromUserId the from user ID
	 */
	@Override
	public void removeByMessagesBetween(long toUserId, long fromUserId) {
		for (Message message :
				findByMessagesBetween(
					toUserId, fromUserId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(message);
		}
	}

	/**
	 * Returns the number of messages where toUserId = &#63; and fromUserId = &#63;.
	 *
	 * @param toUserId the to user ID
	 * @param fromUserId the from user ID
	 * @return the number of matching messages
	 */
	@Override
	public int countByMessagesBetween(long toUserId, long fromUserId) {
		FinderPath finderPath = _finderPathCountByMessagesBetween;

		Object[] finderArgs = new Object[] {toUserId, fromUserId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_MESSAGE_WHERE);

			sb.append(_FINDER_COLUMN_MESSAGESBETWEEN_TOUSERID_2);

			sb.append(_FINDER_COLUMN_MESSAGESBETWEEN_FROMUSERID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(toUserId);

				queryPos.add(fromUserId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
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

	private static final String _FINDER_COLUMN_MESSAGESBETWEEN_TOUSERID_2 =
		"message.toUserId = ? AND ";

	private static final String _FINDER_COLUMN_MESSAGESBETWEEN_FROMUSERID_2 =
		"message.fromUserId = ?";

	public MessagePersistenceImpl() {
		setModelClass(Message.class);

		setModelImplClass(MessageImpl.class);
		setModelPKClass(long.class);

		setTable(MessageTable.INSTANCE);
	}

	/**
	 * Caches the message in the entity cache if it is enabled.
	 *
	 * @param message the message
	 */
	@Override
	public void cacheResult(Message message) {
		entityCache.putResult(
			MessageImpl.class, message.getPrimaryKey(), message);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the messages in the entity cache if it is enabled.
	 *
	 * @param messages the messages
	 */
	@Override
	public void cacheResult(List<Message> messages) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (messages.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Message message : messages) {
			if (entityCache.getResult(
					MessageImpl.class, message.getPrimaryKey()) == null) {

				cacheResult(message);
			}
		}
	}

	/**
	 * Clears the cache for all messages.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(MessageImpl.class);

		finderCache.clearCache(MessageImpl.class);
	}

	/**
	 * Clears the cache for the message.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Message message) {
		entityCache.removeResult(MessageImpl.class, message);
	}

	@Override
	public void clearCache(List<Message> messages) {
		for (Message message : messages) {
			entityCache.removeResult(MessageImpl.class, message);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(MessageImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(MessageImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new message with the primary key. Does not add the message to the database.
	 *
	 * @param messageId the primary key for the new message
	 * @return the new message
	 */
	@Override
	public Message create(long messageId) {
		Message message = new MessageImpl();

		message.setNew(true);
		message.setPrimaryKey(messageId);

		message.setCompanyId(CompanyThreadLocal.getCompanyId());

		return message;
	}

	/**
	 * Removes the message with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param messageId the primary key of the message
	 * @return the message that was removed
	 * @throws NoSuchMessageException if a message with the primary key could not be found
	 */
	@Override
	public Message remove(long messageId) throws NoSuchMessageException {
		return remove((Serializable)messageId);
	}

	/**
	 * Removes the message with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the message
	 * @return the message that was removed
	 * @throws NoSuchMessageException if a message with the primary key could not be found
	 */
	@Override
	public Message remove(Serializable primaryKey)
		throws NoSuchMessageException {

		Session session = null;

		try {
			session = openSession();

			Message message = (Message)session.get(
				MessageImpl.class, primaryKey);

			if (message == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchMessageException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(message);
		}
		catch (NoSuchMessageException noSuchEntityException) {
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
	protected Message removeImpl(Message message) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(message)) {
				message = (Message)session.get(
					MessageImpl.class, message.getPrimaryKeyObj());
			}

			if (message != null) {
				session.delete(message);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (message != null) {
			clearCache(message);
		}

		return message;
	}

	@Override
	public Message updateImpl(Message message) {
		boolean isNew = message.isNew();

		if (!(message instanceof MessageModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(message.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(message);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in message proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Message implementation " +
					message.getClass());
		}

		MessageModelImpl messageModelImpl = (MessageModelImpl)message;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (message.getCreateDate() == null)) {
			if (serviceContext == null) {
				message.setCreateDate(date);
			}
			else {
				message.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!messageModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				message.setModifiedDate(date);
			}
			else {
				message.setModifiedDate(serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(message);
			}
			else {
				message = (Message)session.merge(message);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(MessageImpl.class, messageModelImpl, false, true);

		if (isNew) {
			message.setNew(false);
		}

		message.resetOriginalValues();

		return message;
	}

	/**
	 * Returns the message with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the message
	 * @return the message
	 * @throws NoSuchMessageException if a message with the primary key could not be found
	 */
	@Override
	public Message findByPrimaryKey(Serializable primaryKey)
		throws NoSuchMessageException {

		Message message = fetchByPrimaryKey(primaryKey);

		if (message == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchMessageException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return message;
	}

	/**
	 * Returns the message with the primary key or throws a <code>NoSuchMessageException</code> if it could not be found.
	 *
	 * @param messageId the primary key of the message
	 * @return the message
	 * @throws NoSuchMessageException if a message with the primary key could not be found
	 */
	@Override
	public Message findByPrimaryKey(long messageId)
		throws NoSuchMessageException {

		return findByPrimaryKey((Serializable)messageId);
	}

	/**
	 * Returns the message with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param messageId the primary key of the message
	 * @return the message, or <code>null</code> if a message with the primary key could not be found
	 */
	@Override
	public Message fetchByPrimaryKey(long messageId) {
		return fetchByPrimaryKey((Serializable)messageId);
	}

	/**
	 * Returns all the messages.
	 *
	 * @return the messages
	 */
	@Override
	public List<Message> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Message> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<Message> findAll(
		int start, int end, OrderByComparator<Message> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<Message> findAll(
		int start, int end, OrderByComparator<Message> orderByComparator,
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

		List<Message> list = null;

		if (useFinderCache) {
			list = (List<Message>)finderCache.getResult(finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_MESSAGE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_MESSAGE;

				sql = sql.concat(MessageModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Message>)QueryUtil.list(
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
	 * Removes all the messages from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Message message : findAll()) {
			remove(message);
		}
	}

	/**
	 * Returns the number of messages.
	 *
	 * @return the number of messages
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_MESSAGE);

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
		return "messageId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_MESSAGE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return MessageModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the message persistence.
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

		_finderPathWithPaginationFindByMessagesBetween = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByMessagesBetween",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"toUserId", "fromUserId"}, true);

		_finderPathWithoutPaginationFindByMessagesBetween = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByMessagesBetween",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"toUserId", "fromUserId"}, true);

		_finderPathCountByMessagesBetween = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByMessagesBetween",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"toUserId", "fromUserId"}, false);
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(MessageImpl.class.getName());
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

	private static final String _SQL_SELECT_MESSAGE =
		"SELECT message FROM Message message";

	private static final String _SQL_SELECT_MESSAGE_WHERE =
		"SELECT message FROM Message message WHERE ";

	private static final String _SQL_COUNT_MESSAGE =
		"SELECT COUNT(message) FROM Message message";

	private static final String _SQL_COUNT_MESSAGE_WHERE =
		"SELECT COUNT(message) FROM Message message WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "message.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Message exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Message exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		MessagePersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private MessageModelArgumentsResolver _messageModelArgumentsResolver;

}