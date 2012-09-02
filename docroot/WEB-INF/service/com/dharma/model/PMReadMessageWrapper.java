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
 * This class is a wrapper for {@link PMReadMessage}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       PMReadMessage
 * @generated
 */
public class PMReadMessageWrapper implements PMReadMessage,
	ModelWrapper<PMReadMessage> {
	public PMReadMessageWrapper(PMReadMessage pmReadMessage) {
		_pmReadMessage = pmReadMessage;
	}

	public Class<?> getModelClass() {
		return PMReadMessage.class;
	}

	public String getModelClassName() {
		return PMReadMessage.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("readMessageId", getReadMessageId());
		attributes.put("messageId", getMessageId());
		attributes.put("readDate", getReadDate());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Long readMessageId = (Long)attributes.get("readMessageId");

		if (readMessageId != null) {
			setReadMessageId(readMessageId);
		}

		Long messageId = (Long)attributes.get("messageId");

		if (messageId != null) {
			setMessageId(messageId);
		}

		Date readDate = (Date)attributes.get("readDate");

		if (readDate != null) {
			setReadDate(readDate);
		}
	}

	/**
	* Returns the primary key of this p m read message.
	*
	* @return the primary key of this p m read message
	*/
	public long getPrimaryKey() {
		return _pmReadMessage.getPrimaryKey();
	}

	/**
	* Sets the primary key of this p m read message.
	*
	* @param primaryKey the primary key of this p m read message
	*/
	public void setPrimaryKey(long primaryKey) {
		_pmReadMessage.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the read message ID of this p m read message.
	*
	* @return the read message ID of this p m read message
	*/
	public long getReadMessageId() {
		return _pmReadMessage.getReadMessageId();
	}

	/**
	* Sets the read message ID of this p m read message.
	*
	* @param readMessageId the read message ID of this p m read message
	*/
	public void setReadMessageId(long readMessageId) {
		_pmReadMessage.setReadMessageId(readMessageId);
	}

	/**
	* Returns the message ID of this p m read message.
	*
	* @return the message ID of this p m read message
	*/
	public long getMessageId() {
		return _pmReadMessage.getMessageId();
	}

	/**
	* Sets the message ID of this p m read message.
	*
	* @param messageId the message ID of this p m read message
	*/
	public void setMessageId(long messageId) {
		_pmReadMessage.setMessageId(messageId);
	}

	/**
	* Returns the read date of this p m read message.
	*
	* @return the read date of this p m read message
	*/
	public java.util.Date getReadDate() {
		return _pmReadMessage.getReadDate();
	}

	/**
	* Sets the read date of this p m read message.
	*
	* @param readDate the read date of this p m read message
	*/
	public void setReadDate(java.util.Date readDate) {
		_pmReadMessage.setReadDate(readDate);
	}

	public boolean isNew() {
		return _pmReadMessage.isNew();
	}

	public void setNew(boolean n) {
		_pmReadMessage.setNew(n);
	}

	public boolean isCachedModel() {
		return _pmReadMessage.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_pmReadMessage.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _pmReadMessage.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _pmReadMessage.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_pmReadMessage.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _pmReadMessage.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_pmReadMessage.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new PMReadMessageWrapper((PMReadMessage)_pmReadMessage.clone());
	}

	public int compareTo(com.dharma.model.PMReadMessage pmReadMessage) {
		return _pmReadMessage.compareTo(pmReadMessage);
	}

	@Override
	public int hashCode() {
		return _pmReadMessage.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.dharma.model.PMReadMessage> toCacheModel() {
		return _pmReadMessage.toCacheModel();
	}

	public com.dharma.model.PMReadMessage toEscapedModel() {
		return new PMReadMessageWrapper(_pmReadMessage.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _pmReadMessage.toString();
	}

	public java.lang.String toXmlString() {
		return _pmReadMessage.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_pmReadMessage.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public PMReadMessage getWrappedPMReadMessage() {
		return _pmReadMessage;
	}

	public PMReadMessage getWrappedModel() {
		return _pmReadMessage;
	}

	public void resetOriginalValues() {
		_pmReadMessage.resetOriginalValues();
	}

	private PMReadMessage _pmReadMessage;
}