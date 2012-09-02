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

import com.dharma.model.PMBlockedUser;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the p m blocked user service. This utility wraps {@link PMBlockedUserPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PMBlockedUserPersistence
 * @see PMBlockedUserPersistenceImpl
 * @generated
 */
public class PMBlockedUserUtil {
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
	public static void clearCache(PMBlockedUser pmBlockedUser) {
		getPersistence().clearCache(pmBlockedUser);
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
	public static List<PMBlockedUser> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<PMBlockedUser> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<PMBlockedUser> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static PMBlockedUser update(PMBlockedUser pmBlockedUser,
		boolean merge) throws SystemException {
		return getPersistence().update(pmBlockedUser, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static PMBlockedUser update(PMBlockedUser pmBlockedUser,
		boolean merge, ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(pmBlockedUser, merge, serviceContext);
	}

	/**
	* Caches the p m blocked user in the entity cache if it is enabled.
	*
	* @param pmBlockedUser the p m blocked user
	*/
	public static void cacheResult(com.dharma.model.PMBlockedUser pmBlockedUser) {
		getPersistence().cacheResult(pmBlockedUser);
	}

	/**
	* Caches the p m blocked users in the entity cache if it is enabled.
	*
	* @param pmBlockedUsers the p m blocked users
	*/
	public static void cacheResult(
		java.util.List<com.dharma.model.PMBlockedUser> pmBlockedUsers) {
		getPersistence().cacheResult(pmBlockedUsers);
	}

	/**
	* Creates a new p m blocked user with the primary key. Does not add the p m blocked user to the database.
	*
	* @param blockedUserId the primary key for the new p m blocked user
	* @return the new p m blocked user
	*/
	public static com.dharma.model.PMBlockedUser create(long blockedUserId) {
		return getPersistence().create(blockedUserId);
	}

	/**
	* Removes the p m blocked user with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param blockedUserId the primary key of the p m blocked user
	* @return the p m blocked user that was removed
	* @throws com.dharma.NoSuchPMBlockedUserException if a p m blocked user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.dharma.model.PMBlockedUser remove(long blockedUserId)
		throws com.dharma.NoSuchPMBlockedUserException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(blockedUserId);
	}

	public static com.dharma.model.PMBlockedUser updateImpl(
		com.dharma.model.PMBlockedUser pmBlockedUser, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(pmBlockedUser, merge);
	}

	/**
	* Returns the p m blocked user with the primary key or throws a {@link com.dharma.NoSuchPMBlockedUserException} if it could not be found.
	*
	* @param blockedUserId the primary key of the p m blocked user
	* @return the p m blocked user
	* @throws com.dharma.NoSuchPMBlockedUserException if a p m blocked user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.dharma.model.PMBlockedUser findByPrimaryKey(
		long blockedUserId)
		throws com.dharma.NoSuchPMBlockedUserException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(blockedUserId);
	}

	/**
	* Returns the p m blocked user with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param blockedUserId the primary key of the p m blocked user
	* @return the p m blocked user, or <code>null</code> if a p m blocked user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.dharma.model.PMBlockedUser fetchByPrimaryKey(
		long blockedUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(blockedUserId);
	}

	/**
	* Returns all the p m blocked users where ownerId = &#63; and userId = &#63;.
	*
	* @param ownerId the owner ID
	* @param userId the user ID
	* @return the matching p m blocked users
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.dharma.model.PMBlockedUser> findByOwnerAndUser(
		long ownerId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByOwnerAndUser(ownerId, userId);
	}

	/**
	* Returns a range of all the p m blocked users where ownerId = &#63; and userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ownerId the owner ID
	* @param userId the user ID
	* @param start the lower bound of the range of p m blocked users
	* @param end the upper bound of the range of p m blocked users (not inclusive)
	* @return the range of matching p m blocked users
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.dharma.model.PMBlockedUser> findByOwnerAndUser(
		long ownerId, long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByOwnerAndUser(ownerId, userId, start, end);
	}

	/**
	* Returns an ordered range of all the p m blocked users where ownerId = &#63; and userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ownerId the owner ID
	* @param userId the user ID
	* @param start the lower bound of the range of p m blocked users
	* @param end the upper bound of the range of p m blocked users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching p m blocked users
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.dharma.model.PMBlockedUser> findByOwnerAndUser(
		long ownerId, long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByOwnerAndUser(ownerId, userId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first p m blocked user in the ordered set where ownerId = &#63; and userId = &#63;.
	*
	* @param ownerId the owner ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching p m blocked user
	* @throws com.dharma.NoSuchPMBlockedUserException if a matching p m blocked user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.dharma.model.PMBlockedUser findByOwnerAndUser_First(
		long ownerId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.dharma.NoSuchPMBlockedUserException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByOwnerAndUser_First(ownerId, userId, orderByComparator);
	}

	/**
	* Returns the first p m blocked user in the ordered set where ownerId = &#63; and userId = &#63;.
	*
	* @param ownerId the owner ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching p m blocked user, or <code>null</code> if a matching p m blocked user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.dharma.model.PMBlockedUser fetchByOwnerAndUser_First(
		long ownerId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByOwnerAndUser_First(ownerId, userId, orderByComparator);
	}

	/**
	* Returns the last p m blocked user in the ordered set where ownerId = &#63; and userId = &#63;.
	*
	* @param ownerId the owner ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching p m blocked user
	* @throws com.dharma.NoSuchPMBlockedUserException if a matching p m blocked user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.dharma.model.PMBlockedUser findByOwnerAndUser_Last(
		long ownerId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.dharma.NoSuchPMBlockedUserException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByOwnerAndUser_Last(ownerId, userId, orderByComparator);
	}

	/**
	* Returns the last p m blocked user in the ordered set where ownerId = &#63; and userId = &#63;.
	*
	* @param ownerId the owner ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching p m blocked user, or <code>null</code> if a matching p m blocked user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.dharma.model.PMBlockedUser fetchByOwnerAndUser_Last(
		long ownerId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByOwnerAndUser_Last(ownerId, userId, orderByComparator);
	}

	/**
	* Returns the p m blocked users before and after the current p m blocked user in the ordered set where ownerId = &#63; and userId = &#63;.
	*
	* @param blockedUserId the primary key of the current p m blocked user
	* @param ownerId the owner ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next p m blocked user
	* @throws com.dharma.NoSuchPMBlockedUserException if a p m blocked user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.dharma.model.PMBlockedUser[] findByOwnerAndUser_PrevAndNext(
		long blockedUserId, long ownerId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.dharma.NoSuchPMBlockedUserException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByOwnerAndUser_PrevAndNext(blockedUserId, ownerId,
			userId, orderByComparator);
	}

	/**
	* Returns all the p m blocked users where ownerId = &#63;.
	*
	* @param ownerId the owner ID
	* @return the matching p m blocked users
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.dharma.model.PMBlockedUser> findByOwner(
		long ownerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByOwner(ownerId);
	}

	/**
	* Returns a range of all the p m blocked users where ownerId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ownerId the owner ID
	* @param start the lower bound of the range of p m blocked users
	* @param end the upper bound of the range of p m blocked users (not inclusive)
	* @return the range of matching p m blocked users
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.dharma.model.PMBlockedUser> findByOwner(
		long ownerId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByOwner(ownerId, start, end);
	}

	/**
	* Returns an ordered range of all the p m blocked users where ownerId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ownerId the owner ID
	* @param start the lower bound of the range of p m blocked users
	* @param end the upper bound of the range of p m blocked users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching p m blocked users
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.dharma.model.PMBlockedUser> findByOwner(
		long ownerId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByOwner(ownerId, start, end, orderByComparator);
	}

	/**
	* Returns the first p m blocked user in the ordered set where ownerId = &#63;.
	*
	* @param ownerId the owner ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching p m blocked user
	* @throws com.dharma.NoSuchPMBlockedUserException if a matching p m blocked user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.dharma.model.PMBlockedUser findByOwner_First(
		long ownerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.dharma.NoSuchPMBlockedUserException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByOwner_First(ownerId, orderByComparator);
	}

	/**
	* Returns the first p m blocked user in the ordered set where ownerId = &#63;.
	*
	* @param ownerId the owner ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching p m blocked user, or <code>null</code> if a matching p m blocked user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.dharma.model.PMBlockedUser fetchByOwner_First(
		long ownerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByOwner_First(ownerId, orderByComparator);
	}

	/**
	* Returns the last p m blocked user in the ordered set where ownerId = &#63;.
	*
	* @param ownerId the owner ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching p m blocked user
	* @throws com.dharma.NoSuchPMBlockedUserException if a matching p m blocked user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.dharma.model.PMBlockedUser findByOwner_Last(
		long ownerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.dharma.NoSuchPMBlockedUserException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByOwner_Last(ownerId, orderByComparator);
	}

	/**
	* Returns the last p m blocked user in the ordered set where ownerId = &#63;.
	*
	* @param ownerId the owner ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching p m blocked user, or <code>null</code> if a matching p m blocked user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.dharma.model.PMBlockedUser fetchByOwner_Last(
		long ownerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByOwner_Last(ownerId, orderByComparator);
	}

	/**
	* Returns the p m blocked users before and after the current p m blocked user in the ordered set where ownerId = &#63;.
	*
	* @param blockedUserId the primary key of the current p m blocked user
	* @param ownerId the owner ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next p m blocked user
	* @throws com.dharma.NoSuchPMBlockedUserException if a p m blocked user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.dharma.model.PMBlockedUser[] findByOwner_PrevAndNext(
		long blockedUserId, long ownerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.dharma.NoSuchPMBlockedUserException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByOwner_PrevAndNext(blockedUserId, ownerId,
			orderByComparator);
	}

	/**
	* Returns all the p m blocked users.
	*
	* @return the p m blocked users
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.dharma.model.PMBlockedUser> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the p m blocked users.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of p m blocked users
	* @param end the upper bound of the range of p m blocked users (not inclusive)
	* @return the range of p m blocked users
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.dharma.model.PMBlockedUser> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the p m blocked users.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of p m blocked users
	* @param end the upper bound of the range of p m blocked users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of p m blocked users
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.dharma.model.PMBlockedUser> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the p m blocked users where ownerId = &#63; and userId = &#63; from the database.
	*
	* @param ownerId the owner ID
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByOwnerAndUser(long ownerId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByOwnerAndUser(ownerId, userId);
	}

	/**
	* Removes all the p m blocked users where ownerId = &#63; from the database.
	*
	* @param ownerId the owner ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByOwner(long ownerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByOwner(ownerId);
	}

	/**
	* Removes all the p m blocked users from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of p m blocked users where ownerId = &#63; and userId = &#63;.
	*
	* @param ownerId the owner ID
	* @param userId the user ID
	* @return the number of matching p m blocked users
	* @throws SystemException if a system exception occurred
	*/
	public static int countByOwnerAndUser(long ownerId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByOwnerAndUser(ownerId, userId);
	}

	/**
	* Returns the number of p m blocked users where ownerId = &#63;.
	*
	* @param ownerId the owner ID
	* @return the number of matching p m blocked users
	* @throws SystemException if a system exception occurred
	*/
	public static int countByOwner(long ownerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByOwner(ownerId);
	}

	/**
	* Returns the number of p m blocked users.
	*
	* @return the number of p m blocked users
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static PMBlockedUserPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (PMBlockedUserPersistence)PortletBeanLocatorUtil.locate(com.dharma.service.ClpSerializer.getServletContextName(),
					PMBlockedUserPersistence.class.getName());

			ReferenceRegistry.registerReference(PMBlockedUserUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(PMBlockedUserPersistence persistence) {
	}

	private static PMBlockedUserPersistence _persistence;
}