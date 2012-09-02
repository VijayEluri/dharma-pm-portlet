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
 * This class is a wrapper for {@link PMDeletedMessage}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       PMDeletedMessage
 * @generated
 */
public class PMDeletedMessageWrapper implements PMDeletedMessage,
	ModelWrapper<PMDeletedMessage> {
	public PMDeletedMessageWrapper(PMDeletedMessage pmDeletedMessage) {
		_pmDeletedMessage = pmDeletedMessage;
	}

	public Class<?> getModelClass() {
		return PMDeletedMessage.class;
	}

	public String getModelClassName() {
		return PMDeletedMessage.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("deletedMessageId", getDeletedMessageId());
		attributes.put("messageId", getMessageId());
		attributes.put("ownerId", getOwnerId());
		attributes.put("deletedDate", getDeletedDate());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Long deletedMessageId = (Long)attributes.get("deletedMessageId");

		if (deletedMessageId != null) {
			setDeletedMessageId(deletedMessageId);
		}

		Long messageId = (Long)attributes.get("messageId");

		if (messageId != null) {
			setMessageId(messageId);
		}

		Long ownerId = (Long)attributes.get("ownerId");

		if (ownerId != null) {
			setOwnerId(ownerId);
		}

		Date deletedDate = (Date)attributes.get("deletedDate");

		if (deletedDate != null) {
			setDeletedDate(deletedDate);
		}
	}

	/**
	* Returns the primary key of this p m deleted message.
	*
	* @return the primary key of this p m deleted message
	*/
	public long getPrimaryKey() {
		return _pmDeletedMessage.getPrimaryKey();
	}

	/**
	* Sets the primary key of this p m deleted message.
	*
	* @param primaryKey the primary key of this p m deleted message
	*/
	public void setPrimaryKey(long primaryKey) {
		_pmDeletedMessage.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the deleted message ID of this p m deleted message.
	*
	* @return the deleted message ID of this p m deleted message
	*/
	public long getDeletedMessageId() {
		return _pmDeletedMessage.getDeletedMessageId();
	}

	/**
	* Sets the deleted message ID of this p m deleted message.
	*
	* @param deletedMessageId the deleted message ID of this p m deleted message
	*/
	public void setDeletedMessageId(long deletedMessageId) {
		_pmDeletedMessage.setDeletedMessageId(deletedMessageId);
	}

	/**
	* Returns the message ID of this p m deleted message.
	*
	* @return the message ID of this p m deleted message
	*/
	public long getMessageId() {
		return _pmDeletedMessage.getMessageId();
	}

	/**
	* Sets the message ID of this p m deleted message.
	*
	* @param messageId the message ID of this p m deleted message
	*/
	public void setMessageId(long messageId) {
		_pmDeletedMessage.setMessageId(messageId);
	}

	/**
	* Returns the owner ID of this p m deleted message.
	*
	* @return the owner ID of this p m deleted message
	*/
	public long getOwnerId() {
		return _pmDeletedMessage.getOwnerId();
	}

	/**
	* Sets the owner ID of this p m deleted message.
	*
	* @param ownerId the owner ID of this p m deleted message
	*/
	public void setOwnerId(long ownerId) {
		_pmDeletedMessage.setOwnerId(ownerId);
	}

	/**
	* Returns the deleted date of this p m deleted message.
	*
	* @return the deleted date of this p m deleted message
	*/
	public java.util.Date getDeletedDate() {
		return _pmDeletedMessage.getDeletedDate();
	}

	/**
	* Sets the deleted date of this p m deleted message.
	*
	* @param deletedDate the deleted date of this p m deleted message
	*/
	public void setDeletedDate(java.util.Date deletedDate) {
		_pmDeletedMessage.setDeletedDate(deletedDate);
	}

	public boolean isNew() {
		return _pmDeletedMessage.isNew();
	}

	public void setNew(boolean n) {
		_pmDeletedMessage.setNew(n);
	}

	public boolean isCachedModel() {
		return _pmDeletedMessage.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_pmDeletedMessage.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _pmDeletedMessage.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _pmDeletedMessage.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_pmDeletedMessage.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _pmDeletedMessage.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_pmDeletedMessage.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new PMDeletedMessageWrapper((PMDeletedMessage)_pmDeletedMessage.clone());
	}

	public int compareTo(com.dharma.model.PMDeletedMessage pmDeletedMessage) {
		return _pmDeletedMessage.compareTo(pmDeletedMessage);
	}

	@Override
	public int hashCode() {
		return _pmDeletedMessage.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.dharma.model.PMDeletedMessage> toCacheModel() {
		return _pmDeletedMessage.toCacheModel();
	}

	public com.dharma.model.PMDeletedMessage toEscapedModel() {
		return new PMDeletedMessageWrapper(_pmDeletedMessage.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _pmDeletedMessage.toString();
	}

	public java.lang.String toXmlString() {
		return _pmDeletedMessage.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_pmDeletedMessage.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public PMDeletedMessage getWrappedPMDeletedMessage() {
		return _pmDeletedMessage;
	}

	public PMDeletedMessage getWrappedModel() {
		return _pmDeletedMessage;
	}

	public void resetOriginalValues() {
		_pmDeletedMessage.resetOriginalValues();
	}

	private PMDeletedMessage _pmDeletedMessage;
}