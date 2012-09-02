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

import com.dharma.NoSuchPMDeletedMessageException;

import com.dharma.model.PMDeletedMessage;
import com.dharma.model.impl.PMDeletedMessageImpl;
import com.dharma.model.impl.PMDeletedMessageModelImpl;

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
 * The persistence implementation for the p m deleted message service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PMDeletedMessagePersistence
 * @see PMDeletedMessageUtil
 * @generated
 */
public class PMDeletedMessagePersistenceImpl extends BasePersistenceImpl<PMDeletedMessage>
	implements PMDeletedMessagePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link PMDeletedMessageUtil} to access the p m deleted message persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = PMDeletedMessageImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_OWNERID = new FinderPath(PMDeletedMessageModelImpl.ENTITY_CACHE_ENABLED,
			PMDeletedMessageModelImpl.FINDER_CACHE_ENABLED,
			PMDeletedMessageImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByOwnerId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OWNERID =
		new FinderPath(PMDeletedMessageModelImpl.ENTITY_CACHE_ENABLED,
			PMDeletedMessageModelImpl.FINDER_CACHE_ENABLED,
			PMDeletedMessageImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByOwnerId",
			new String[] { Long.class.getName() },
			PMDeletedMessageModelImpl.OWNERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_OWNERID = new FinderPath(PMDeletedMessageModelImpl.ENTITY_CACHE_ENABLED,
			PMDeletedMessageModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByOwnerId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_MESSAGEID =
		new FinderPath(PMDeletedMessageModelImpl.ENTITY_CACHE_ENABLED,
			PMDeletedMessageModelImpl.FINDER_CACHE_ENABLED,
			PMDeletedMessageImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByMessageId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MESSAGEID =
		new FinderPath(PMDeletedMessageModelImpl.ENTITY_CACHE_ENABLED,
			PMDeletedMessageModelImpl.FINDER_CACHE_ENABLED,
			PMDeletedMessageImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByMessageId",
			new String[] { Long.class.getName() },
			PMDeletedMessageModelImpl.MESSAGEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_MESSAGEID = new FinderPath(PMDeletedMessageModelImpl.ENTITY_CACHE_ENABLED,
			PMDeletedMessageModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByMessageId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(PMDeletedMessageModelImpl.ENTITY_CACHE_ENABLED,
			PMDeletedMessageModelImpl.FINDER_CACHE_ENABLED,
			PMDeletedMessageImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(PMDeletedMessageModelImpl.ENTITY_CACHE_ENABLED,
			PMDeletedMessageModelImpl.FINDER_CACHE_ENABLED,
			PMDeletedMessageImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(PMDeletedMessageModelImpl.ENTITY_CACHE_ENABLED,
			PMDeletedMessageModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the p m deleted message in the entity cache if it is enabled.
	 *
	 * @param pmDeletedMessage the p m deleted message
	 */
	public void cacheResult(PMDeletedMessage pmDeletedMessage) {
		EntityCacheUtil.putResult(PMDeletedMessageModelImpl.ENTITY_CACHE_ENABLED,
			PMDeletedMessageImpl.class, pmDeletedMessage.getPrimaryKey(),
			pmDeletedMessage);

		pmDeletedMessage.resetOriginalValues();
	}

	/**
	 * Caches the p m deleted messages in the entity cache if it is enabled.
	 *
	 * @param pmDeletedMessages the p m deleted messages
	 */
	public void cacheResult(List<PMDeletedMessage> pmDeletedMessages) {
		for (PMDeletedMessage pmDeletedMessage : pmDeletedMessages) {
			if (EntityCacheUtil.getResult(
						PMDeletedMessageModelImpl.ENTITY_CACHE_ENABLED,
						PMDeletedMessageImpl.class,
						pmDeletedMessage.getPrimaryKey()) == null) {
				cacheResult(pmDeletedMessage);
			}
			else {
				pmDeletedMessage.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all p m deleted messages.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(PMDeletedMessageImpl.class.getName());
		}

		EntityCacheUtil.clearCache(PMDeletedMessageImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the p m deleted message.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(PMDeletedMessage pmDeletedMessage) {
		EntityCacheUtil.removeResult(PMDeletedMessageModelImpl.ENTITY_CACHE_ENABLED,
			PMDeletedMessageImpl.class, pmDeletedMessage.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<PMDeletedMessage> pmDeletedMessages) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (PMDeletedMessage pmDeletedMessage : pmDeletedMessages) {
			EntityCacheUtil.removeResult(PMDeletedMessageModelImpl.ENTITY_CACHE_ENABLED,
				PMDeletedMessageImpl.class, pmDeletedMessage.getPrimaryKey());
		}
	}

	/**
	 * Creates a new p m deleted message with the primary key. Does not add the p m deleted message to the database.
	 *
	 * @param deletedMessageId the primary key for the new p m deleted message
	 * @return the new p m deleted message
	 */
	public PMDeletedMessage create(long deletedMessageId) {
		PMDeletedMessage pmDeletedMessage = new PMDeletedMessageImpl();

		pmDeletedMessage.setNew(true);
		pmDeletedMessage.setPrimaryKey(deletedMessageId);

		return pmDeletedMessage;
	}

	/**
	 * Removes the p m deleted message with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param deletedMessageId the primary key of the p m deleted message
	 * @return the p m deleted message that was removed
	 * @throws com.dharma.NoSuchPMDeletedMessageException if a p m deleted message with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PMDeletedMessage remove(long deletedMessageId)
		throws NoSuchPMDeletedMessageException, SystemException {
		return remove(Long.valueOf(deletedMessageId));
	}

	/**
	 * Removes the p m deleted message with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the p m deleted message
	 * @return the p m deleted message that was removed
	 * @throws com.dharma.NoSuchPMDeletedMessageException if a p m deleted message with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PMDeletedMessage remove(Serializable primaryKey)
		throws NoSuchPMDeletedMessageException, SystemException {
		Session session = null;

		try {
			session = openSession();

			PMDeletedMessage pmDeletedMessage = (PMDeletedMessage)session.get(PMDeletedMessageImpl.class,
					primaryKey);

			if (pmDeletedMessage == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPMDeletedMessageException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(pmDeletedMessage);
		}
		catch (NoSuchPMDeletedMessageException nsee) {
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
	protected PMDeletedMessage removeImpl(PMDeletedMessage pmDeletedMessage)
		throws SystemException {
		pmDeletedMessage = toUnwrappedModel(pmDeletedMessage);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, pmDeletedMessage);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(pmDeletedMessage);

		return pmDeletedMessage;
	}

	@Override
	public PMDeletedMessage updateImpl(
		com.dharma.model.PMDeletedMessage pmDeletedMessage, boolean merge)
		throws SystemException {
		pmDeletedMessage = toUnwrappedModel(pmDeletedMessage);

		boolean isNew = pmDeletedMessage.isNew();

		PMDeletedMessageModelImpl pmDeletedMessageModelImpl = (PMDeletedMessageModelImpl)pmDeletedMessage;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, pmDeletedMessage, merge);

			pmDeletedMessage.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !PMDeletedMessageModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((pmDeletedMessageModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OWNERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(pmDeletedMessageModelImpl.getOriginalOwnerId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_OWNERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OWNERID,
					args);

				args = new Object[] {
						Long.valueOf(pmDeletedMessageModelImpl.getOwnerId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_OWNERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OWNERID,
					args);
			}

			if ((pmDeletedMessageModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MESSAGEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(pmDeletedMessageModelImpl.getOriginalMessageId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MESSAGEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MESSAGEID,
					args);

				args = new Object[] {
						Long.valueOf(pmDeletedMessageModelImpl.getMessageId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MESSAGEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MESSAGEID,
					args);
			}
		}

		EntityCacheUtil.putResult(PMDeletedMessageModelImpl.ENTITY_CACHE_ENABLED,
			PMDeletedMessageImpl.class, pmDeletedMessage.getPrimaryKey(),
			pmDeletedMessage);

		return pmDeletedMessage;
	}

	protected PMDeletedMessage toUnwrappedModel(
		PMDeletedMessage pmDeletedMessage) {
		if (pmDeletedMessage instanceof PMDeletedMessageImpl) {
			return pmDeletedMessage;
		}

		PMDeletedMessageImpl pmDeletedMessageImpl = new PMDeletedMessageImpl();

		pmDeletedMessageImpl.setNew(pmDeletedMessage.isNew());
		pmDeletedMessageImpl.setPrimaryKey(pmDeletedMessage.getPrimaryKey());

		pmDeletedMessageImpl.setDeletedMessageId(pmDeletedMessage.getDeletedMessageId());
		pmDeletedMessageImpl.setMessageId(pmDeletedMessage.getMessageId());
		pmDeletedMessageImpl.setOwnerId(pmDeletedMessage.getOwnerId());
		pmDeletedMessageImpl.setDeletedDate(pmDeletedMessage.getDeletedDate());

		return pmDeletedMessageImpl;
	}

	/**
	 * Returns the p m deleted message with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the p m deleted message
	 * @return the p m deleted message
	 * @throws com.liferay.portal.NoSuchModelException if a p m deleted message with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PMDeletedMessage findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the p m deleted message with the primary key or throws a {@link com.dharma.NoSuchPMDeletedMessageException} if it could not be found.
	 *
	 * @param deletedMessageId the primary key of the p m deleted message
	 * @return the p m deleted message
	 * @throws com.dharma.NoSuchPMDeletedMessageException if a p m deleted message with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PMDeletedMessage findByPrimaryKey(long deletedMessageId)
		throws NoSuchPMDeletedMessageException, SystemException {
		PMDeletedMessage pmDeletedMessage = fetchByPrimaryKey(deletedMessageId);

		if (pmDeletedMessage == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + deletedMessageId);
			}

			throw new NoSuchPMDeletedMessageException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				deletedMessageId);
		}

		return pmDeletedMessage;
	}

	/**
	 * Returns the p m deleted message with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the p m deleted message
	 * @return the p m deleted message, or <code>null</code> if a p m deleted message with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PMDeletedMessage fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the p m deleted message with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param deletedMessageId the primary key of the p m deleted message
	 * @return the p m deleted message, or <code>null</code> if a p m deleted message with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PMDeletedMessage fetchByPrimaryKey(long deletedMessageId)
		throws SystemException {
		PMDeletedMessage pmDeletedMessage = (PMDeletedMessage)EntityCacheUtil.getResult(PMDeletedMessageModelImpl.ENTITY_CACHE_ENABLED,
				PMDeletedMessageImpl.class, deletedMessageId);

		if (pmDeletedMessage == _nullPMDeletedMessage) {
			return null;
		}

		if (pmDeletedMessage == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				pmDeletedMessage = (PMDeletedMessage)session.get(PMDeletedMessageImpl.class,
						Long.valueOf(deletedMessageId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (pmDeletedMessage != null) {
					cacheResult(pmDeletedMessage);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(PMDeletedMessageModelImpl.ENTITY_CACHE_ENABLED,
						PMDeletedMessageImpl.class, deletedMessageId,
						_nullPMDeletedMessage);
				}

				closeSession(session);
			}
		}

		return pmDeletedMessage;
	}

	/**
	 * Returns all the p m deleted messages where ownerId = &#63;.
	 *
	 * @param ownerId the owner ID
	 * @return the matching p m deleted messages
	 * @throws SystemException if a system exception occurred
	 */
	public List<PMDeletedMessage> findByOwnerId(long ownerId)
		throws SystemException {
		return findByOwnerId(ownerId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the p m deleted messages where ownerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param ownerId the owner ID
	 * @param start the lower bound of the range of p m deleted messages
	 * @param end the upper bound of the range of p m deleted messages (not inclusive)
	 * @return the range of matching p m deleted messages
	 * @throws SystemException if a system exception occurred
	 */
	public List<PMDeletedMessage> findByOwnerId(long ownerId, int start, int end)
		throws SystemException {
		return findByOwnerId(ownerId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the p m deleted messages where ownerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param ownerId the owner ID
	 * @param start the lower bound of the range of p m deleted messages
	 * @param end the upper bound of the range of p m deleted messages (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching p m deleted messages
	 * @throws SystemException if a system exception occurred
	 */
	public List<PMDeletedMessage> findByOwnerId(long ownerId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
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

		List<PMDeletedMessage> list = (List<PMDeletedMessage>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (PMDeletedMessage pmDeletedMessage : list) {
				if ((ownerId != pmDeletedMessage.getOwnerId())) {
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

			query.append(_SQL_SELECT_PMDELETEDMESSAGE_WHERE);

			query.append(_FINDER_COLUMN_OWNERID_OWNERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(PMDeletedMessageModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(ownerId);

				list = (List<PMDeletedMessage>)QueryUtil.list(q, getDialect(),
						start, end);
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
	 * Returns the first p m deleted message in the ordered set where ownerId = &#63;.
	 *
	 * @param ownerId the owner ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching p m deleted message
	 * @throws com.dharma.NoSuchPMDeletedMessageException if a matching p m deleted message could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PMDeletedMessage findByOwnerId_First(long ownerId,
		OrderByComparator orderByComparator)
		throws NoSuchPMDeletedMessageException, SystemException {
		PMDeletedMessage pmDeletedMessage = fetchByOwnerId_First(ownerId,
				orderByComparator);

		if (pmDeletedMessage != null) {
			return pmDeletedMessage;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("ownerId=");
		msg.append(ownerId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPMDeletedMessageException(msg.toString());
	}

	/**
	 * Returns the first p m deleted message in the ordered set where ownerId = &#63;.
	 *
	 * @param ownerId the owner ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching p m deleted message, or <code>null</code> if a matching p m deleted message could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PMDeletedMessage fetchByOwnerId_First(long ownerId,
		OrderByComparator orderByComparator) throws SystemException {
		List<PMDeletedMessage> list = findByOwnerId(ownerId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last p m deleted message in the ordered set where ownerId = &#63;.
	 *
	 * @param ownerId the owner ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching p m deleted message
	 * @throws com.dharma.NoSuchPMDeletedMessageException if a matching p m deleted message could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PMDeletedMessage findByOwnerId_Last(long ownerId,
		OrderByComparator orderByComparator)
		throws NoSuchPMDeletedMessageException, SystemException {
		PMDeletedMessage pmDeletedMessage = fetchByOwnerId_Last(ownerId,
				orderByComparator);

		if (pmDeletedMessage != null) {
			return pmDeletedMessage;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("ownerId=");
		msg.append(ownerId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPMDeletedMessageException(msg.toString());
	}

	/**
	 * Returns the last p m deleted message in the ordered set where ownerId = &#63;.
	 *
	 * @param ownerId the owner ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching p m deleted message, or <code>null</code> if a matching p m deleted message could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PMDeletedMessage fetchByOwnerId_Last(long ownerId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByOwnerId(ownerId);

		List<PMDeletedMessage> list = findByOwnerId(ownerId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the p m deleted messages before and after the current p m deleted message in the ordered set where ownerId = &#63;.
	 *
	 * @param deletedMessageId the primary key of the current p m deleted message
	 * @param ownerId the owner ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next p m deleted message
	 * @throws com.dharma.NoSuchPMDeletedMessageException if a p m deleted message with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PMDeletedMessage[] findByOwnerId_PrevAndNext(long deletedMessageId,
		long ownerId, OrderByComparator orderByComparator)
		throws NoSuchPMDeletedMessageException, SystemException {
		PMDeletedMessage pmDeletedMessage = findByPrimaryKey(deletedMessageId);

		Session session = null;

		try {
			session = openSession();

			PMDeletedMessage[] array = new PMDeletedMessageImpl[3];

			array[0] = getByOwnerId_PrevAndNext(session, pmDeletedMessage,
					ownerId, orderByComparator, true);

			array[1] = pmDeletedMessage;

			array[2] = getByOwnerId_PrevAndNext(session, pmDeletedMessage,
					ownerId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected PMDeletedMessage getByOwnerId_PrevAndNext(Session session,
		PMDeletedMessage pmDeletedMessage, long ownerId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PMDELETEDMESSAGE_WHERE);

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
			query.append(PMDeletedMessageModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(ownerId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(pmDeletedMessage);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PMDeletedMessage> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the p m deleted messages where messageId = &#63;.
	 *
	 * @param messageId the message ID
	 * @return the matching p m deleted messages
	 * @throws SystemException if a system exception occurred
	 */
	public List<PMDeletedMessage> findByMessageId(long messageId)
		throws SystemException {
		return findByMessageId(messageId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the p m deleted messages where messageId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param messageId the message ID
	 * @param start the lower bound of the range of p m deleted messages
	 * @param end the upper bound of the range of p m deleted messages (not inclusive)
	 * @return the range of matching p m deleted messages
	 * @throws SystemException if a system exception occurred
	 */
	public List<PMDeletedMessage> findByMessageId(long messageId, int start,
		int end) throws SystemException {
		return findByMessageId(messageId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the p m deleted messages where messageId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param messageId the message ID
	 * @param start the lower bound of the range of p m deleted messages
	 * @param end the upper bound of the range of p m deleted messages (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching p m deleted messages
	 * @throws SystemException if a system exception occurred
	 */
	public List<PMDeletedMessage> findByMessageId(long messageId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MESSAGEID;
			finderArgs = new Object[] { messageId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_MESSAGEID;
			finderArgs = new Object[] { messageId, start, end, orderByComparator };
		}

		List<PMDeletedMessage> list = (List<PMDeletedMessage>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (PMDeletedMessage pmDeletedMessage : list) {
				if ((messageId != pmDeletedMessage.getMessageId())) {
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

			query.append(_SQL_SELECT_PMDELETEDMESSAGE_WHERE);

			query.append(_FINDER_COLUMN_MESSAGEID_MESSAGEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(PMDeletedMessageModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(messageId);

				list = (List<PMDeletedMessage>)QueryUtil.list(q, getDialect(),
						start, end);
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
	 * Returns the first p m deleted message in the ordered set where messageId = &#63;.
	 *
	 * @param messageId the message ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching p m deleted message
	 * @throws com.dharma.NoSuchPMDeletedMessageException if a matching p m deleted message could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PMDeletedMessage findByMessageId_First(long messageId,
		OrderByComparator orderByComparator)
		throws NoSuchPMDeletedMessageException, SystemException {
		PMDeletedMessage pmDeletedMessage = fetchByMessageId_First(messageId,
				orderByComparator);

		if (pmDeletedMessage != null) {
			return pmDeletedMessage;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("messageId=");
		msg.append(messageId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPMDeletedMessageException(msg.toString());
	}

	/**
	 * Returns the first p m deleted message in the ordered set where messageId = &#63;.
	 *
	 * @param messageId the message ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching p m deleted message, or <code>null</code> if a matching p m deleted message could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PMDeletedMessage fetchByMessageId_First(long messageId,
		OrderByComparator orderByComparator) throws SystemException {
		List<PMDeletedMessage> list = findByMessageId(messageId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last p m deleted message in the ordered set where messageId = &#63;.
	 *
	 * @param messageId the message ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching p m deleted message
	 * @throws com.dharma.NoSuchPMDeletedMessageException if a matching p m deleted message could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PMDeletedMessage findByMessageId_Last(long messageId,
		OrderByComparator orderByComparator)
		throws NoSuchPMDeletedMessageException, SystemException {
		PMDeletedMessage pmDeletedMessage = fetchByMessageId_Last(messageId,
				orderByComparator);

		if (pmDeletedMessage != null) {
			return pmDeletedMessage;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("messageId=");
		msg.append(messageId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPMDeletedMessageException(msg.toString());
	}

	/**
	 * Returns the last p m deleted message in the ordered set where messageId = &#63;.
	 *
	 * @param messageId the message ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching p m deleted message, or <code>null</code> if a matching p m deleted message could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PMDeletedMessage fetchByMessageId_Last(long messageId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByMessageId(messageId);

		List<PMDeletedMessage> list = findByMessageId(messageId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the p m deleted messages before and after the current p m deleted message in the ordered set where messageId = &#63;.
	 *
	 * @param deletedMessageId the primary key of the current p m deleted message
	 * @param messageId the message ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next p m deleted message
	 * @throws com.dharma.NoSuchPMDeletedMessageException if a p m deleted message with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PMDeletedMessage[] findByMessageId_PrevAndNext(
		long deletedMessageId, long messageId,
		OrderByComparator orderByComparator)
		throws NoSuchPMDeletedMessageException, SystemException {
		PMDeletedMessage pmDeletedMessage = findByPrimaryKey(deletedMessageId);

		Session session = null;

		try {
			session = openSession();

			PMDeletedMessage[] array = new PMDeletedMessageImpl[3];

			array[0] = getByMessageId_PrevAndNext(session, pmDeletedMessage,
					messageId, orderByComparator, true);

			array[1] = pmDeletedMessage;

			array[2] = getByMessageId_PrevAndNext(session, pmDeletedMessage,
					messageId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected PMDeletedMessage getByMessageId_PrevAndNext(Session session,
		PMDeletedMessage pmDeletedMessage, long messageId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PMDELETEDMESSAGE_WHERE);

		query.append(_FINDER_COLUMN_MESSAGEID_MESSAGEID_2);

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
			query.append(PMDeletedMessageModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(messageId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(pmDeletedMessage);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PMDeletedMessage> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the p m deleted messages.
	 *
	 * @return the p m deleted messages
	 * @throws SystemException if a system exception occurred
	 */
	public List<PMDeletedMessage> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the p m deleted messages.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of p m deleted messages
	 * @param end the upper bound of the range of p m deleted messages (not inclusive)
	 * @return the range of p m deleted messages
	 * @throws SystemException if a system exception occurred
	 */
	public List<PMDeletedMessage> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the p m deleted messages.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of p m deleted messages
	 * @param end the upper bound of the range of p m deleted messages (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of p m deleted messages
	 * @throws SystemException if a system exception occurred
	 */
	public List<PMDeletedMessage> findAll(int start, int end,
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

		List<PMDeletedMessage> list = (List<PMDeletedMessage>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_PMDELETEDMESSAGE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PMDELETEDMESSAGE.concat(PMDeletedMessageModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<PMDeletedMessage>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<PMDeletedMessage>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Removes all the p m deleted messages where ownerId = &#63; from the database.
	 *
	 * @param ownerId the owner ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByOwnerId(long ownerId) throws SystemException {
		for (PMDeletedMessage pmDeletedMessage : findByOwnerId(ownerId)) {
			remove(pmDeletedMessage);
		}
	}

	/**
	 * Removes all the p m deleted messages where messageId = &#63; from the database.
	 *
	 * @param messageId the message ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByMessageId(long messageId) throws SystemException {
		for (PMDeletedMessage pmDeletedMessage : findByMessageId(messageId)) {
			remove(pmDeletedMessage);
		}
	}

	/**
	 * Removes all the p m deleted messages from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (PMDeletedMessage pmDeletedMessage : findAll()) {
			remove(pmDeletedMessage);
		}
	}

	/**
	 * Returns the number of p m deleted messages where ownerId = &#63;.
	 *
	 * @param ownerId the owner ID
	 * @return the number of matching p m deleted messages
	 * @throws SystemException if a system exception occurred
	 */
	public int countByOwnerId(long ownerId) throws SystemException {
		Object[] finderArgs = new Object[] { ownerId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_OWNERID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PMDELETEDMESSAGE_WHERE);

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
	 * Returns the number of p m deleted messages where messageId = &#63;.
	 *
	 * @param messageId the message ID
	 * @return the number of matching p m deleted messages
	 * @throws SystemException if a system exception occurred
	 */
	public int countByMessageId(long messageId) throws SystemException {
		Object[] finderArgs = new Object[] { messageId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_MESSAGEID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PMDELETEDMESSAGE_WHERE);

			query.append(_FINDER_COLUMN_MESSAGEID_MESSAGEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(messageId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_MESSAGEID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of p m deleted messages.
	 *
	 * @return the number of p m deleted messages
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_PMDELETEDMESSAGE);

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
	 * Initializes the p m deleted message persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.dharma.model.PMDeletedMessage")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<PMDeletedMessage>> listenersList = new ArrayList<ModelListener<PMDeletedMessage>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<PMDeletedMessage>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(PMDeletedMessageImpl.class.getName());
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
	private static final String _SQL_SELECT_PMDELETEDMESSAGE = "SELECT pmDeletedMessage FROM PMDeletedMessage pmDeletedMessage";
	private static final String _SQL_SELECT_PMDELETEDMESSAGE_WHERE = "SELECT pmDeletedMessage FROM PMDeletedMessage pmDeletedMessage WHERE ";
	private static final String _SQL_COUNT_PMDELETEDMESSAGE = "SELECT COUNT(pmDeletedMessage) FROM PMDeletedMessage pmDeletedMessage";
	private static final String _SQL_COUNT_PMDELETEDMESSAGE_WHERE = "SELECT COUNT(pmDeletedMessage) FROM PMDeletedMessage pmDeletedMessage WHERE ";
	private static final String _FINDER_COLUMN_OWNERID_OWNERID_2 = "pmDeletedMessage.ownerId = ?";
	private static final String _FINDER_COLUMN_MESSAGEID_MESSAGEID_2 = "pmDeletedMessage.messageId = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "pmDeletedMessage.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No PMDeletedMessage exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No PMDeletedMessage exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(PMDeletedMessagePersistenceImpl.class);
	private static PMDeletedMessage _nullPMDeletedMessage = new PMDeletedMessageImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<PMDeletedMessage> toCacheModel() {
				return _nullPMDeletedMessageCacheModel;
			}
		};

	private static CacheModel<PMDeletedMessage> _nullPMDeletedMessageCacheModel = new CacheModel<PMDeletedMessage>() {
			public PMDeletedMessage toEntityModel() {
				return _nullPMDeletedMessage;
			}
		};
}