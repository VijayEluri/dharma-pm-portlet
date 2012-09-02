/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
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

package com.dharma.service.persistence;

import com.dharma.NoSuchPMMessageException;

import com.dharma.model.PMMessage;
import com.dharma.model.impl.PMMessageImpl;
import com.dharma.model.impl.PMMessageModelImpl;

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the p m message service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PMMessagePersistence
 * @see PMMessageUtil
 * @generated
 */
public class PMMessagePersistenceImpl extends BasePersistenceImpl<PMMessage>
	implements PMMessagePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link PMMessageUtil} to access the p m message persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = PMMessageImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_OWNERID = new FinderPath(PMMessageModelImpl.ENTITY_CACHE_ENABLED,
			PMMessageModelImpl.FINDER_CACHE_ENABLED, PMMessageImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByOwnerId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OWNERID =
		new FinderPath(PMMessageModelImpl.ENTITY_CACHE_ENABLED,
			PMMessageModelImpl.FINDER_CACHE_ENABLED, PMMessageImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByOwnerId",
			new String[] { Long.class.getName() },
			PMMessageModelImpl.OWNERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_OWNERID = new FinderPath(PMMessageModelImpl.ENTITY_CACHE_ENABLED,
			PMMessageModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByOwnerId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PARENTMESSAGEID =
		new FinderPath(PMMessageModelImpl.ENTITY_CACHE_ENABLED,
			PMMessageModelImpl.FINDER_CACHE_ENABLED, PMMessageImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByParentMessageId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTMESSAGEID =
		new FinderPath(PMMessageModelImpl.ENTITY_CACHE_ENABLED,
			PMMessageModelImpl.FINDER_CACHE_ENABLED, PMMessageImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByParentMessageId",
			new String[] { Long.class.getName() },
			PMMessageModelImpl.PARENTMESSAGEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PARENTMESSAGEID = new FinderPath(PMMessageModelImpl.ENTITY_CACHE_ENABLED,
			PMMessageModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByParentMessageId", new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(PMMessageModelImpl.ENTITY_CACHE_ENABLED,
			PMMessageModelImpl.FINDER_CACHE_ENABLED, PMMessageImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(PMMessageModelImpl.ENTITY_CACHE_ENABLED,
			PMMessageModelImpl.FINDER_CACHE_ENABLED, PMMessageImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(PMMessageModelImpl.ENTITY_CACHE_ENABLED,
			PMMessageModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the p m message in the entity cache if it is enabled.
	 *
	 * @param pmMessage the p m message
	 */
	public void cacheResult(PMMessage pmMessage) {
		EntityCacheUtil.putResult(PMMessageModelImpl.ENTITY_CACHE_ENABLED,
			PMMessageImpl.class, pmMessage.getPrimaryKey(), pmMessage);

		pmMessage.resetOriginalValues();
	}

	/**
	 * Caches the p m messages in the entity cache if it is enabled.
	 *
	 * @param pmMessages the p m messages
	 */
	public void cacheResult(List<PMMessage> pmMessages) {
		for (PMMessage pmMessage : pmMessages) {
			if (EntityCacheUtil.getResult(
						PMMessageModelImpl.ENTITY_CACHE_ENABLED,
						PMMessageImpl.class, pmMessage.getPrimaryKey()) == null) {
				cacheResult(pmMessage);
			}
			else {
				pmMessage.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all p m messages.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(PMMessageImpl.class.getName());
		}

		EntityCacheUtil.clearCache(PMMessageImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the p m message.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(PMMessage pmMessage) {
		EntityCacheUtil.removeResult(PMMessageModelImpl.ENTITY_CACHE_ENABLED,
			PMMessageImpl.class, pmMessage.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<PMMessage> pmMessages) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (PMMessage pmMessage : pmMessages) {
			EntityCacheUtil.removeResult(PMMessageModelImpl.ENTITY_CACHE_ENABLED,
				PMMessageImpl.class, pmMessage.getPrimaryKey());
		}
	}

	/**
	 * Creates a new p m message with the primary key. Does not add the p m message to the database.
	 *
	 * @param messageId the primary key for the new p m message
	 * @return the new p m message
	 */
	public PMMessage create(long messageId) {
		PMMessage pmMessage = new PMMessageImpl();

		pmMessage.setNew(true);
		pmMessage.setPrimaryKey(messageId);

		return pmMessage;
	}

	/**
	 * Removes the p m message with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param messageId the primary key of the p m message
	 * @return the p m message that was removed
	 * @throws com.dharma.NoSuchPMMessageException if a p m message with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PMMessage remove(long messageId)
		throws NoSuchPMMessageException, SystemException {
		return remove(Long.valueOf(messageId));
	}

	/**
	 * Removes the p m message with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the p m message
	 * @return the p m message that was removed
	 * @throws com.dharma.NoSuchPMMessageException if a p m message with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PMMessage remove(Serializable primaryKey)
		throws NoSuchPMMessageException, SystemException {
		Session session = null;

		try {
			session = openSession();

			PMMessage pmMessage = (PMMessage)session.get(PMMessageImpl.class,
					primaryKey);

			if (pmMessage == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPMMessageException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(pmMessage);
		}
		catch (NoSuchPMMessageException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected PMMessage removeImpl(PMMessage pmMessage)
		throws SystemException {
		pmMessage = toUnwrappedModel(pmMessage);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, pmMessage);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(pmMessage);

		return pmMessage;
	}

	@Override
	public PMMessage updateImpl(com.dharma.model.PMMessage pmMessage,
		boolean merge) throws SystemException {
		pmMessage = toUnwrappedModel(pmMessage);

		boolean isNew = pmMessage.isNew();

		PMMessageModelImpl pmMessageModelImpl = (PMMessageModelImpl)pmMessage;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, pmMessage, merge);

			pmMessage.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !PMMessageModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((pmMessageModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OWNERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(pmMessageModelImpl.getOriginalOwnerId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_OWNERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OWNERID,
					args);

				args = new Object[] {
						Long.valueOf(pmMessageModelImpl.getOwnerId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_OWNERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OWNERID,
					args);
			}

			if ((pmMessageModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTMESSAGEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(pmMessageModelImpl.getOriginalParentMessageId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PARENTMESSAGEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTMESSAGEID,
					args);

				args = new Object[] {
						Long.valueOf(pmMessageModelImpl.getParentMessageId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PARENTMESSAGEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTMESSAGEID,
					args);
			}
		}

		EntityCacheUtil.putResult(PMMessageModelImpl.ENTITY_CACHE_ENABLED,
			PMMessageImpl.class, pmMessage.getPrimaryKey(), pmMessage);

		return pmMessage;
	}

	protected PMMessage toUnwrappedModel(PMMessage pmMessage) {
		if (pmMessage instanceof PMMessageImpl) {
			return pmMessage;
		}

		PMMessageImpl pmMessageImpl = new PMMessageImpl();

		pmMessageImpl.setNew(pmMessage.isNew());
		pmMessageImpl.setPrimaryKey(pmMessage.getPrimaryKey());

		pmMessageImpl.setMessageId(pmMessage.getMessageId());
		pmMessageImpl.setSubject(pmMessage.getSubject());
		pmMessageImpl.setBody(pmMessage.getBody());
		pmMessageImpl.setParentMessageId(pmMessage.getParentMessageId());
		pmMessageImpl.setOwnerId(pmMessage.getOwnerId());
		pmMessageImpl.setOwnerName(pmMessage.getOwnerName());
		pmMessageImpl.setPostedDate(pmMessage.getPostedDate());
		pmMessageImpl.setRecepients(pmMessage.getRecepients());

		return pmMessageImpl;
	}

	/**
	 * Returns the p m message with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the p m message
	 * @return the p m message
	 * @throws com.liferay.portal.NoSuchModelException if a p m message with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PMMessage findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the p m message with the primary key or throws a {@link com.dharma.NoSuchPMMessageException} if it could not be found.
	 *
	 * @param messageId the primary key of the p m message
	 * @return the p m message
	 * @throws com.dharma.NoSuchPMMessageException if a p m message with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PMMessage findByPrimaryKey(long messageId)
		throws NoSuchPMMessageException, SystemException {
		PMMessage pmMessage = fetchByPrimaryKey(messageId);

		if (pmMessage == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + messageId);
			}

			throw new NoSuchPMMessageException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				messageId);
		}

		return pmMessage;
	}

	/**
	 * Returns the p m message with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the p m message
	 * @return the p m message, or <code>null</code> if a p m message with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PMMessage fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the p m message with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param messageId the primary key of the p m message
	 * @return the p m message, or <code>null</code> if a p m message with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PMMessage fetchByPrimaryKey(long messageId)
		throws SystemException {
		PMMessage pmMessage = (PMMessage)EntityCacheUtil.getResult(PMMessageModelImpl.ENTITY_CACHE_ENABLED,
				PMMessageImpl.class, messageId);

		if (pmMessage == _nullPMMessage) {
			return null;
		}

		if (pmMessage == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				pmMessage = (PMMessage)session.get(PMMessageImpl.class,
						Long.valueOf(messageId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (pmMessage != null) {
					cacheResult(pmMessage);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(PMMessageModelImpl.ENTITY_CACHE_ENABLED,
						PMMessageImpl.class, messageId, _nullPMMessage);
				}

				closeSession(session);
			}
		}

		return pmMessage;
	}

	/**
	 * Returns all the p m messages where ownerId = &#63;.
	 *
	 * @param ownerId the owner ID
	 * @return the matching p m messages
	 * @throws SystemException if a system exception occurred
	 */
	public List<PMMessage> findByOwnerId(long ownerId)
		throws SystemException {
		return findByOwnerId(ownerId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the p m messages where ownerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param ownerId the owner ID
	 * @param start the lower bound of the range of p m messages
	 * @param end the upper bound of the range of p m messages (not inclusive)
	 * @return the range of matching p m messages
	 * @throws SystemException if a system exception occurred
	 */
	public List<PMMessage> findByOwnerId(long ownerId, int start, int end)
		throws SystemException {
		return findByOwnerId(ownerId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the p m messages where ownerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param ownerId the owner ID
	 * @param start the lower bound of the range of p m messages
	 * @param end the upper bound of the range of p m messages (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching p m messages
	 * @throws SystemException if a system exception occurred
	 */
	public List<PMMessage> findByOwnerId(long ownerId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OWNERID;
			finderArgs = new Object[] { ownerId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_OWNERID;
			finderArgs = new Object[] { ownerId, start, end, orderByComparator };
		}

		List<PMMessage> list = (List<PMMessage>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (PMMessage pmMessage : list) {
				if ((ownerId != pmMessage.getOwnerId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_PMMESSAGE_WHERE);

			query.append(_FINDER_COLUMN_OWNERID_OWNERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(PMMessageModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(ownerId);

				list = (List<PMMessage>)QueryUtil.list(q, getDialect(), start,
						end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first p m message in the ordered set where ownerId = &#63;.
	 *
	 * @param ownerId the owner ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching p m message
	 * @throws com.dharma.NoSuchPMMessageException if a matching p m message could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PMMessage findByOwnerId_First(long ownerId,
		OrderByComparator orderByComparator)
		throws NoSuchPMMessageException, SystemException {
		PMMessage pmMessage = fetchByOwnerId_First(ownerId, orderByComparator);

		if (pmMessage != null) {
			return pmMessage;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("ownerId=");
		msg.append(ownerId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPMMessageException(msg.toString());
	}

	/**
	 * Returns the first p m message in the ordered set where ownerId = &#63;.
	 *
	 * @param ownerId the owner ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching p m message, or <code>null</code> if a matching p m message could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PMMessage fetchByOwnerId_First(long ownerId,
		OrderByComparator orderByComparator) throws SystemException {
		List<PMMessage> list = findByOwnerId(ownerId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last p m message in the ordered set where ownerId = &#63;.
	 *
	 * @param ownerId the owner ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching p m message
	 * @throws com.dharma.NoSuchPMMessageException if a matching p m message could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PMMessage findByOwnerId_Last(long ownerId,
		OrderByComparator orderByComparator)
		throws NoSuchPMMessageException, SystemException {
		PMMessage pmMessage = fetchByOwnerId_Last(ownerId, orderByComparator);

		if (pmMessage != null) {
			return pmMessage;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("ownerId=");
		msg.append(ownerId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPMMessageException(msg.toString());
	}

	/**
	 * Returns the last p m message in the ordered set where ownerId = &#63;.
	 *
	 * @param ownerId the owner ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching p m message, or <code>null</code> if a matching p m message could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PMMessage fetchByOwnerId_Last(long ownerId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByOwnerId(ownerId);

		List<PMMessage> list = findByOwnerId(ownerId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the p m messages before and after the current p m message in the ordered set where ownerId = &#63;.
	 *
	 * @param messageId the primary key of the current p m message
	 * @param ownerId the owner ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next p m message
	 * @throws com.dharma.NoSuchPMMessageException if a p m message with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PMMessage[] findByOwnerId_PrevAndNext(long messageId, long ownerId,
		OrderByComparator orderByComparator)
		throws NoSuchPMMessageException, SystemException {
		PMMessage pmMessage = findByPrimaryKey(messageId);

		Session session = null;

		try {
			session = openSession();

			PMMessage[] array = new PMMessageImpl[3];

			array[0] = getByOwnerId_PrevAndNext(session, pmMessage, ownerId,
					orderByComparator, true);

			array[1] = pmMessage;

			array[2] = getByOwnerId_PrevAndNext(session, pmMessage, ownerId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected PMMessage getByOwnerId_PrevAndNext(Session session,
		PMMessage pmMessage, long ownerId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PMMESSAGE_WHERE);

		query.append(_FINDER_COLUMN_OWNERID_OWNERID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		else {
			query.append(PMMessageModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(ownerId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(pmMessage);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PMMessage> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the p m messages where parentMessageId = &#63;.
	 *
	 * @param parentMessageId the parent message ID
	 * @return the matching p m messages
	 * @throws SystemException if a system exception occurred
	 */
	public List<PMMessage> findByParentMessageId(long parentMessageId)
		throws SystemException {
		return findByParentMessageId(parentMessageId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the p m messages where parentMessageId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param parentMessageId the parent message ID
	 * @param start the lower bound of the range of p m messages
	 * @param end the upper bound of the range of p m messages (not inclusive)
	 * @return the range of matching p m messages
	 * @throws SystemException if a system exception occurred
	 */
	public List<PMMessage> findByParentMessageId(long parentMessageId,
		int start, int end) throws SystemException {
		return findByParentMessageId(parentMessageId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the p m messages where parentMessageId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param parentMessageId the parent message ID
	 * @param start the lower bound of the range of p m messages
	 * @param end the upper bound of the range of p m messages (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching p m messages
	 * @throws SystemException if a system exception occurred
	 */
	public List<PMMessage> findByParentMessageId(long parentMessageId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTMESSAGEID;
			finderArgs = new Object[] { parentMessageId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PARENTMESSAGEID;
			finderArgs = new Object[] {
					parentMessageId,
					
					start, end, orderByComparator
				};
		}

		List<PMMessage> list = (List<PMMessage>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (PMMessage pmMessage : list) {
				if ((parentMessageId != pmMessage.getParentMessageId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_PMMESSAGE_WHERE);

			query.append(_FINDER_COLUMN_PARENTMESSAGEID_PARENTMESSAGEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(PMMessageModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(parentMessageId);

				list = (List<PMMessage>)QueryUtil.list(q, getDialect(), start,
						end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first p m message in the ordered set where parentMessageId = &#63;.
	 *
	 * @param parentMessageId the parent message ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching p m message
	 * @throws com.dharma.NoSuchPMMessageException if a matching p m message could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PMMessage findByParentMessageId_First(long parentMessageId,
		OrderByComparator orderByComparator)
		throws NoSuchPMMessageException, SystemException {
		PMMessage pmMessage = fetchByParentMessageId_First(parentMessageId,
				orderByComparator);

		if (pmMessage != null) {
			return pmMessage;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("parentMessageId=");
		msg.append(parentMessageId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPMMessageException(msg.toString());
	}

	/**
	 * Returns the first p m message in the ordered set where parentMessageId = &#63;.
	 *
	 * @param parentMessageId the parent message ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching p m message, or <code>null</code> if a matching p m message could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PMMessage fetchByParentMessageId_First(long parentMessageId,
		OrderByComparator orderByComparator) throws SystemException {
		List<PMMessage> list = findByParentMessageId(parentMessageId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last p m message in the ordered set where parentMessageId = &#63;.
	 *
	 * @param parentMessageId the parent message ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching p m message
	 * @throws com.dharma.NoSuchPMMessageException if a matching p m message could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PMMessage findByParentMessageId_Last(long parentMessageId,
		OrderByComparator orderByComparator)
		throws NoSuchPMMessageException, SystemException {
		PMMessage pmMessage = fetchByParentMessageId_Last(parentMessageId,
				orderByComparator);

		if (pmMessage != null) {
			return pmMessage;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("parentMessageId=");
		msg.append(parentMessageId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPMMessageException(msg.toString());
	}

	/**
	 * Returns the last p m message in the ordered set where parentMessageId = &#63;.
	 *
	 * @param parentMessageId the parent message ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching p m message, or <code>null</code> if a matching p m message could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PMMessage fetchByParentMessageId_Last(long parentMessageId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByParentMessageId(parentMessageId);

		List<PMMessage> list = findByParentMessageId(parentMessageId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the p m messages before and after the current p m message in the ordered set where parentMessageId = &#63;.
	 *
	 * @param messageId the primary key of the current p m message
	 * @param parentMessageId the parent message ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next p m message
	 * @throws com.dharma.NoSuchPMMessageException if a p m message with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PMMessage[] findByParentMessageId_PrevAndNext(long messageId,
		long parentMessageId, OrderByComparator orderByComparator)
		throws NoSuchPMMessageException, SystemException {
		PMMessage pmMessage = findByPrimaryKey(messageId);

		Session session = null;

		try {
			session = openSession();

			PMMessage[] array = new PMMessageImpl[3];

			array[0] = getByParentMessageId_PrevAndNext(session, pmMessage,
					parentMessageId, orderByComparator, true);

			array[1] = pmMessage;

			array[2] = getByParentMessageId_PrevAndNext(session, pmMessage,
					parentMessageId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected PMMessage getByParentMessageId_PrevAndNext(Session session,
		PMMessage pmMessage, long parentMessageId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PMMESSAGE_WHERE);

		query.append(_FINDER_COLUMN_PARENTMESSAGEID_PARENTMESSAGEID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		else {
			query.append(PMMessageModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(parentMessageId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(pmMessage);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PMMessage> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the p m messages.
	 *
	 * @return the p m messages
	 * @throws SystemException if a system exception occurred
	 */
	public List<PMMessage> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the p m messages.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of p m messages
	 * @param end the upper bound of the range of p m messages (not inclusive)
	 * @return the range of p m messages
	 * @throws SystemException if a system exception occurred
	 */
	public List<PMMessage> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the p m messages.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of p m messages
	 * @param end the upper bound of the range of p m messages (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of p m messages
	 * @throws SystemException if a system exception occurred
	 */
	public List<PMMessage> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = new Object[] { start, end, orderByComparator };

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<PMMessage> list = (List<PMMessage>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_PMMESSAGE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PMMESSAGE.concat(PMMessageModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<PMMessage>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<PMMessage>)QueryUtil.list(q, getDialect(),
							start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the p m messages where ownerId = &#63; from the database.
	 *
	 * @param ownerId the owner ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByOwnerId(long ownerId) throws SystemException {
		for (PMMessage pmMessage : findByOwnerId(ownerId)) {
			remove(pmMessage);
		}
	}

	/**
	 * Removes all the p m messages where parentMessageId = &#63; from the database.
	 *
	 * @param parentMessageId the parent message ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByParentMessageId(long parentMessageId)
		throws SystemException {
		for (PMMessage pmMessage : findByParentMessageId(parentMessageId)) {
			remove(pmMessage);
		}
	}

	/**
	 * Removes all the p m messages from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (PMMessage pmMessage : findAll()) {
			remove(pmMessage);
		}
	}

	/**
	 * Returns the number of p m messages where ownerId = &#63;.
	 *
	 * @param ownerId the owner ID
	 * @return the number of matching p m messages
	 * @throws SystemException if a system exception occurred
	 */
	public int countByOwnerId(long ownerId) throws SystemException {
		Object[] finderArgs = new Object[] { ownerId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_OWNERID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PMMESSAGE_WHERE);

			query.append(_FINDER_COLUMN_OWNERID_OWNERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(ownerId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_OWNERID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of p m messages where parentMessageId = &#63;.
	 *
	 * @param parentMessageId the parent message ID
	 * @return the number of matching p m messages
	 * @throws SystemException if a system exception occurred
	 */
	public int countByParentMessageId(long parentMessageId)
		throws SystemException {
		Object[] finderArgs = new Object[] { parentMessageId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_PARENTMESSAGEID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PMMESSAGE_WHERE);

			query.append(_FINDER_COLUMN_PARENTMESSAGEID_PARENTMESSAGEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(parentMessageId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PARENTMESSAGEID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of p m messages.
	 *
	 * @return the number of p m messages
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_PMMESSAGE);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the p m message persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.dharma.model.PMMessage")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<PMMessage>> listenersList = new ArrayList<ModelListener<PMMessage>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<PMMessage>)InstanceFactory.newInstance(
							listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(PMMessageImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = PMBlockedUserPersistence.class)
	protected PMBlockedUserPersistence pmBlockedUserPersistence;
	@BeanReference(type = PMDeletedMessagePersistence.class)
	protected PMDeletedMessagePersistence pmDeletedMessagePersistence;
	@BeanReference(type = PMMessagePersistence.class)
	protected PMMessagePersistence pmMessagePersistence;
	@BeanReference(type = PMReadMessagePersistence.class)
	protected PMReadMessagePersistence pmReadMessagePersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_PMMESSAGE = "SELECT pmMessage FROM PMMessage pmMessage";
	private static final String _SQL_SELECT_PMMESSAGE_WHERE = "SELECT pmMessage FROM PMMessage pmMessage WHERE ";
	private static final String _SQL_COUNT_PMMESSAGE = "SELECT COUNT(pmMessage) FROM PMMessage pmMessage";
	private static final String _SQL_COUNT_PMMESSAGE_WHERE = "SELECT COUNT(pmMessage) FROM PMMessage pmMessage WHERE ";
	private static final String _FINDER_COLUMN_OWNERID_OWNERID_2 = "pmMessage.ownerId = ?";
	private static final String _FINDER_COLUMN_PARENTMESSAGEID_PARENTMESSAGEID_2 =
		"pmMessage.parentMessageId = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "pmMessage.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No PMMessage exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No PMMessage exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(PMMessagePersistenceImpl.class);
	private static PMMessage _nullPMMessage = new PMMessageImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<PMMessage> toCacheModel() {
				return _nullPMMessageCacheModel;
			}
		};

	private static CacheModel<PMMessage> _nullPMMessageCacheModel = new CacheModel<PMMessage>() {
			public PMMessage toEntityModel() {
				return _nullPMMessage;
			}
		};
}