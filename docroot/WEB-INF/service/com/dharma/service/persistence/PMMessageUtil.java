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

import com.dharma.model.PMMessage;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the p m message service. This utility wraps {@link PMMessagePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PMMessagePersistence
 * @see PMMessagePersistenceImpl
 * @generated
 */
public class PMMessageUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(PMMessage pmMessage) {
		getPersistence().clearCache(pmMessage);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<PMMessage> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<PMMessage> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<PMMessage> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static PMMessage update(PMMessage pmMessage, boolean merge)
		throws SystemException {
		return getPersistence().update(pmMessage, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static PMMessage update(PMMessage pmMessage, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(pmMessage, merge, serviceContext);
	}

	/**
	* Caches the p m message in the entity cache if it is enabled.
	*
	* @param pmMessage the p m message
	*/
	public static void cacheResult(com.dharma.model.PMMessage pmMessage) {
		getPersistence().cacheResult(pmMessage);
	}

	/**
	* Caches the p m messages in the entity cache if it is enabled.
	*
	* @param pmMessages the p m messages
	*/
	public static void cacheResult(
		java.util.List<com.dharma.model.PMMessage> pmMessages) {
		getPersistence().cacheResult(pmMessages);
	}

	/**
	* Creates a new p m message with the primary key. Does not add the p m message to the database.
	*
	* @param messageId the primary key for the new p m message
	* @return the new p m message
	*/
	public static com.dharma.model.PMMessage create(long messageId) {
		return getPersistence().create(messageId);
	}

	/**
	* Removes the p m message with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param messageId the primary key of the p m message
	* @return the p m message that was removed
	* @throws com.dharma.NoSuchPMMessageException if a p m message with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.dharma.model.PMMessage remove(long messageId)
		throws com.dharma.NoSuchPMMessageException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(messageId);
	}

	public static com.dharma.model.PMMessage updateImpl(
		com.dharma.model.PMMessage pmMessage, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(pmMessage, merge);
	}

	/**
	* Returns the p m message with the primary key or throws a {@link com.dharma.NoSuchPMMessageException} if it could not be found.
	*
	* @param messageId the primary key of the p m message
	* @return the p m message
	* @throws com.dharma.NoSuchPMMessageException if a p m message with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.dharma.model.PMMessage findByPrimaryKey(long messageId)
		throws com.dharma.NoSuchPMMessageException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(messageId);
	}

	/**
	* Returns the p m message with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param messageId the primary key of the p m message
	* @return the p m message, or <code>null</code> if a p m message with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.dharma.model.PMMessage fetchByPrimaryKey(long messageId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(messageId);
	}

	/**
	* Returns all the p m messages where ownerId = &#63;.
	*
	* @param ownerId the owner ID
	* @return the matching p m messages
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.dharma.model.PMMessage> findByOwnerId(
		long ownerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByOwnerId(ownerId);
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
	public static java.util.List<com.dharma.model.PMMessage> findByOwnerId(
		long ownerId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByOwnerId(ownerId, start, end);
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
	public static java.util.List<com.dharma.model.PMMessage> findByOwnerId(
		long ownerId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByOwnerId(ownerId, start, end, orderByComparator);
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
	public static com.dharma.model.PMMessage findByOwnerId_First(long ownerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.dharma.NoSuchPMMessageException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByOwnerId_First(ownerId, orderByComparator);
	}

	/**
	* Returns the first p m message in the ordered set where ownerId = &#63;.
	*
	* @param ownerId the owner ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching p m message, or <code>null</code> if a matching p m message could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.dharma.model.PMMessage fetchByOwnerId_First(
		long ownerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByOwnerId_First(ownerId, orderByComparator);
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
	public static com.dharma.model.PMMessage findByOwnerId_Last(long ownerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.dharma.NoSuchPMMessageException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByOwnerId_Last(ownerId, orderByComparator);
	}

	/**
	* Returns the last p m message in the ordered set where ownerId = &#63;.
	*
	* @param ownerId the owner ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching p m message, or <code>null</code> if a matching p m message could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.dharma.model.PMMessage fetchByOwnerId_Last(long ownerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByOwnerId_Last(ownerId, orderByComparator);
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
	public static com.dharma.model.PMMessage[] findByOwnerId_PrevAndNext(
		long messageId, long ownerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.dharma.NoSuchPMMessageException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByOwnerId_PrevAndNext(messageId, ownerId,
			orderByComparator);
	}

	/**
	* Returns all the p m messages where parentMessageId = &#63;.
	*
	* @param parentMessageId the parent message ID
	* @return the matching p m messages
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.dharma.model.PMMessage> findByParentMessageId(
		long parentMessageId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByParentMessageId(parentMessageId);
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
	public static java.util.List<com.dharma.model.PMMessage> findByParentMessageId(
		long parentMessageId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByParentMessageId(parentMessageId, start, end);
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
	public static java.util.List<com.dharma.model.PMMessage> findByParentMessageId(
		long parentMessageId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByParentMessageId(parentMessageId, start, end,
			orderByComparator);
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
	public static com.dharma.model.PMMessage findByParentMessageId_First(
		long parentMessageId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.dharma.NoSuchPMMessageException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByParentMessageId_First(parentMessageId,
			orderByComparator);
	}

	/**
	* Returns the first p m message in the ordered set where parentMessageId = &#63;.
	*
	* @param parentMessageId the parent message ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching p m message, or <code>null</code> if a matching p m message could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.dharma.model.PMMessage fetchByParentMessageId_First(
		long parentMessageId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByParentMessageId_First(parentMessageId,
			orderByComparator);
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
	public static com.dharma.model.PMMessage findByParentMessageId_Last(
		long parentMessageId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.dharma.NoSuchPMMessageException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByParentMessageId_Last(parentMessageId,
			orderByComparator);
	}

	/**
	* Returns the last p m message in the ordered set where parentMessageId = &#63;.
	*
	* @param parentMessageId the parent message ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching p m message, or <code>null</code> if a matching p m message could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.dharma.model.PMMessage fetchByParentMessageId_Last(
		long parentMessageId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByParentMessageId_Last(parentMessageId,
			orderByComparator);
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
	public static com.dharma.model.PMMessage[] findByParentMessageId_PrevAndNext(
		long messageId, long parentMessageId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.dharma.NoSuchPMMessageException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByParentMessageId_PrevAndNext(messageId,
			parentMessageId, orderByComparator);
	}

	/**
	* Returns all the p m messages.
	*
	* @return the p m messages
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.dharma.model.PMMessage> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<com.dharma.model.PMMessage> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
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
	public static java.util.List<com.dharma.model.PMMessage> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the p m messages where ownerId = &#63; from the database.
	*
	* @param ownerId the owner ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByOwnerId(long ownerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByOwnerId(ownerId);
	}

	/**
	* Removes all the p m messages where parentMessageId = &#63; from the database.
	*
	* @param parentMessageId the parent message ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByParentMessageId(long parentMessageId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByParentMessageId(parentMessageId);
	}

	/**
	* Removes all the p m messages from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of p m messages where ownerId = &#63;.
	*
	* @param ownerId the owner ID
	* @return the number of matching p m messages
	* @throws SystemException if a system exception occurred
	*/
	public static int countByOwnerId(long ownerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByOwnerId(ownerId);
	}

	/**
	* Returns the number of p m messages where parentMessageId = &#63;.
	*
	* @param parentMessageId the parent message ID
	* @return the number of matching p m messages
	* @throws SystemException if a system exception occurred
	*/
	public static int countByParentMessageId(long parentMessageId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByParentMessageId(parentMessageId);
	}

	/**
	* Returns the number of p m messages.
	*
	* @return the number of p m messages
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static PMMessagePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (PMMessagePersistence)PortletBeanLocatorUtil.locate(com.dharma.service.ClpSerializer.getServletContextName(),
					PMMessagePersistence.class.getName());

			ReferenceRegistry.registerReference(PMMessageUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(PMMessagePersistence persistence) {
	}

	private static PMMessagePersistence _persistence;
}