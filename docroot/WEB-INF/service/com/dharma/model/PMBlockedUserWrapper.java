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

package com.dharma.model;

import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link PMBlockedUser}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       PMBlockedUser
 * @generated
 */
public class PMBlockedUserWrapper implements PMBlockedUser,
	ModelWrapper<PMBlockedUser> {
	public PMBlockedUserWrapper(PMBlockedUser pmBlockedUser) {
		_pmBlockedUser = pmBlockedUser;
	}

	public Class<?> getModelClass() {
		return PMBlockedUser.class;
	}

	public String getModelClassName() {
		return PMBlockedUser.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("blockedUserId", getBlockedUserId());
		attributes.put("ownerId", getOwnerId());
		attributes.put("userId", getUserId());
		attributes.put("blockedDate", getBlockedDate());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Long blockedUserId = (Long)attributes.get("blockedUserId");

		if (blockedUserId != null) {
			setBlockedUserId(blockedUserId);
		}

		Long ownerId = (Long)attributes.get("ownerId");

		if (ownerId != null) {
			setOwnerId(ownerId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Date blockedDate = (Date)attributes.get("blockedDate");

		if (blockedDate != null) {
			setBlockedDate(blockedDate);
		}
	}

	/**
	* Returns the primary key of this p m blocked user.
	*
	* @return the primary key of this p m blocked user
	*/
	public long getPrimaryKey() {
		return _pmBlockedUser.getPrimaryKey();
	}

	/**
	* Sets the primary key of this p m blocked user.
	*
	* @param primaryKey the primary key of this p m blocked user
	*/
	public void setPrimaryKey(long primaryKey) {
		_pmBlockedUser.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the blocked user ID of this p m blocked user.
	*
	* @return the blocked user ID of this p m blocked user
	*/
	public long getBlockedUserId() {
		return _pmBlockedUser.getBlockedUserId();
	}

	/**
	* Sets the blocked user ID of this p m blocked user.
	*
	* @param blockedUserId the blocked user ID of this p m blocked user
	*/
	public void setBlockedUserId(long blockedUserId) {
		_pmBlockedUser.setBlockedUserId(blockedUserId);
	}

	/**
	* Returns the blocked user uuid of this p m blocked user.
	*
	* @return the blocked user uuid of this p m blocked user
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getBlockedUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _pmBlockedUser.getBlockedUserUuid();
	}

	/**
	* Sets the blocked user uuid of this p m blocked user.
	*
	* @param blockedUserUuid the blocked user uuid of this p m blocked user
	*/
	public void setBlockedUserUuid(java.lang.String blockedUserUuid) {
		_pmBlockedUser.setBlockedUserUuid(blockedUserUuid);
	}

	/**
	* Returns the owner ID of this p m blocked user.
	*
	* @return the owner ID of this p m blocked user
	*/
	public long getOwnerId() {
		return _pmBlockedUser.getOwnerId();
	}

	/**
	* Sets the owner ID of this p m blocked user.
	*
	* @param ownerId the owner ID of this p m blocked user
	*/
	public void setOwnerId(long ownerId) {
		_pmBlockedUser.setOwnerId(ownerId);
	}

	/**
	* Returns the user ID of this p m blocked user.
	*
	* @return the user ID of this p m blocked user
	*/
	public long getUserId() {
		return _pmBlockedUser.getUserId();
	}

	/**
	* Sets the user ID of this p m blocked user.
	*
	* @param userId the user ID of this p m blocked user
	*/
	public void setUserId(long userId) {
		_pmBlockedUser.setUserId(userId);
	}

	/**
	* Returns the user uuid of this p m blocked user.
	*
	* @return the user uuid of this p m blocked user
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _pmBlockedUser.getUserUuid();
	}

	/**
	* Sets the user uuid of this p m blocked user.
	*
	* @param userUuid the user uuid of this p m blocked user
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_pmBlockedUser.setUserUuid(userUuid);
	}

	/**
	* Returns the blocked date of this p m blocked user.
	*
	* @return the blocked date of this p m blocked user
	*/
	public java.util.Date getBlockedDate() {
		return _pmBlockedUser.getBlockedDate();
	}

	/**
	* Sets the blocked date of this p m blocked user.
	*
	* @param blockedDate the blocked date of this p m blocked user
	*/
	public void setBlockedDate(java.util.Date blockedDate) {
		_pmBlockedUser.setBlockedDate(blockedDate);
	}

	public boolean isNew() {
		return _pmBlockedUser.isNew();
	}

	public void setNew(boolean n) {
		_pmBlockedUser.setNew(n);
	}

	public boolean isCachedModel() {
		return _pmBlockedUser.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_pmBlockedUser.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _pmBlockedUser.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _pmBlockedUser.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_pmBlockedUser.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _pmBlockedUser.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_pmBlockedUser.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new PMBlockedUserWrapper((PMBlockedUser)_pmBlockedUser.clone());
	}

	public int compareTo(com.dharma.model.PMBlockedUser pmBlockedUser) {
		return _pmBlockedUser.compareTo(pmBlockedUser);
	}

	@Override
	public int hashCode() {
		return _pmBlockedUser.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.dharma.model.PMBlockedUser> toCacheModel() {
		return _pmBlockedUser.toCacheModel();
	}

	public com.dharma.model.PMBlockedUser toEscapedModel() {
		return new PMBlockedUserWrapper(_pmBlockedUser.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _pmBlockedUser.toString();
	}

	public java.lang.String toXmlString() {
		return _pmBlockedUser.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_pmBlockedUser.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public PMBlockedUser getWrappedPMBlockedUser() {
		return _pmBlockedUser;
	}

	public PMBlockedUser getWrappedModel() {
		return _pmBlockedUser;
	}

	public void resetOriginalValues() {
		_pmBlockedUser.resetOriginalValues();
	}

	private PMBlockedUser _pmBlockedUser;
}