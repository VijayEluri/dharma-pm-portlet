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
 * This class is a wrapper for {@link PMMessage}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       PMMessage
 * @generated
 */
public class PMMessageWrapper implements PMMessage, ModelWrapper<PMMessage> {
	public PMMessageWrapper(PMMessage pmMessage) {
		_pmMessage = pmMessage;
	}

	public Class<?> getModelClass() {
		return PMMessage.class;
	}

	public String getModelClassName() {
		return PMMessage.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("messageId", getMessageId());
		attributes.put("subject", getSubject());
		attributes.put("body", getBody());
		attributes.put("parentMessageId", getParentMessageId());
		attributes.put("ownerId", getOwnerId());
		attributes.put("ownerName", getOwnerName());
		attributes.put("postedDate", getPostedDate());
		attributes.put("recepients", getRecepients());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Long messageId = (Long)attributes.get("messageId");

		if (messageId != null) {
			setMessageId(messageId);
		}

		String subject = (String)attributes.get("subject");

		if (subject != null) {
			setSubject(subject);
		}

		String body = (String)attributes.get("body");

		if (body != null) {
			setBody(body);
		}

		Long parentMessageId = (Long)attributes.get("parentMessageId");

		if (parentMessageId != null) {
			setParentMessageId(parentMessageId);
		}

		Long ownerId = (Long)attributes.get("ownerId");

		if (ownerId != null) {
			setOwnerId(ownerId);
		}

		String ownerName = (String)attributes.get("ownerName");

		if (ownerName != null) {
			setOwnerName(ownerName);
		}

		Date postedDate = (Date)attributes.get("postedDate");

		if (postedDate != null) {
			setPostedDate(postedDate);
		}

		String recepients = (String)attributes.get("recepients");

		if (recepients != null) {
			setRecepients(recepients);
		}
	}

	/**
	* Returns the primary key of this p m message.
	*
	* @return the primary key of this p m message
	*/
	public long getPrimaryKey() {
		return _pmMessage.getPrimaryKey();
	}

	/**
	* Sets the primary key of this p m message.
	*
	* @param primaryKey the primary key of this p m message
	*/
	public void setPrimaryKey(long primaryKey) {
		_pmMessage.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the message ID of this p m message.
	*
	* @return the message ID of this p m message
	*/
	public long getMessageId() {
		return _pmMessage.getMessageId();
	}

	/**
	* Sets the message ID of this p m message.
	*
	* @param messageId the message ID of this p m message
	*/
	public void setMessageId(long messageId) {
		_pmMessage.setMessageId(messageId);
	}

	/**
	* Returns the subject of this p m message.
	*
	* @return the subject of this p m message
	*/
	public java.lang.String getSubject() {
		return _pmMessage.getSubject();
	}

	/**
	* Sets the subject of this p m message.
	*
	* @param subject the subject of this p m message
	*/
	public void setSubject(java.lang.String subject) {
		_pmMessage.setSubject(subject);
	}

	/**
	* Returns the body of this p m message.
	*
	* @return the body of this p m message
	*/
	public java.lang.String getBody() {
		return _pmMessage.getBody();
	}

	/**
	* Sets the body of this p m message.
	*
	* @param body the body of this p m message
	*/
	public void setBody(java.lang.String body) {
		_pmMessage.setBody(body);
	}

	/**
	* Returns the parent message ID of this p m message.
	*
	* @return the parent message ID of this p m message
	*/
	public long getParentMessageId() {
		return _pmMessage.getParentMessageId();
	}

	/**
	* Sets the parent message ID of this p m message.
	*
	* @param parentMessageId the parent message ID of this p m message
	*/
	public void setParentMessageId(long parentMessageId) {
		_pmMessage.setParentMessageId(parentMessageId);
	}

	/**
	* Returns the owner ID of this p m message.
	*
	* @return the owner ID of this p m message
	*/
	public long getOwnerId() {
		return _pmMessage.getOwnerId();
	}

	/**
	* Sets the owner ID of this p m message.
	*
	* @param ownerId the owner ID of this p m message
	*/
	public void setOwnerId(long ownerId) {
		_pmMessage.setOwnerId(ownerId);
	}

	/**
	* Returns the owner name of this p m message.
	*
	* @return the owner name of this p m message
	*/
	public java.lang.String getOwnerName() {
		return _pmMessage.getOwnerName();
	}

	/**
	* Sets the owner name of this p m message.
	*
	* @param ownerName the owner name of this p m message
	*/
	public void setOwnerName(java.lang.String ownerName) {
		_pmMessage.setOwnerName(ownerName);
	}

	/**
	* Returns the posted date of this p m message.
	*
	* @return the posted date of this p m message
	*/
	public java.util.Date getPostedDate() {
		return _pmMessage.getPostedDate();
	}

	/**
	* Sets the posted date of this p m message.
	*
	* @param postedDate the posted date of this p m message
	*/
	public void setPostedDate(java.util.Date postedDate) {
		_pmMessage.setPostedDate(postedDate);
	}

	/**
	* Returns the recepients of this p m message.
	*
	* @return the recepients of this p m message
	*/
	public java.lang.String getRecepients() {
		return _pmMessage.getRecepients();
	}

	/**
	* Sets the recepients of this p m message.
	*
	* @param recepients the recepients of this p m message
	*/
	public void setRecepients(java.lang.String recepients) {
		_pmMessage.setRecepients(recepients);
	}

	public boolean isNew() {
		return _pmMessage.isNew();
	}

	public void setNew(boolean n) {
		_pmMessage.setNew(n);
	}

	public boolean isCachedModel() {
		return _pmMessage.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_pmMessage.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _pmMessage.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _pmMessage.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_pmMessage.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _pmMessage.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_pmMessage.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new PMMessageWrapper((PMMessage)_pmMessage.clone());
	}

	public int compareTo(com.dharma.model.PMMessage pmMessage) {
		return _pmMessage.compareTo(pmMessage);
	}

	@Override
	public int hashCode() {
		return _pmMessage.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.dharma.model.PMMessage> toCacheModel() {
		return _pmMessage.toCacheModel();
	}

	public com.dharma.model.PMMessage toEscapedModel() {
		return new PMMessageWrapper(_pmMessage.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _pmMessage.toString();
	}

	public java.lang.String toXmlString() {
		return _pmMessage.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_pmMessage.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public PMMessage getWrappedPMMessage() {
		return _pmMessage;
	}

	public PMMessage getWrappedModel() {
		return _pmMessage;
	}

	public void resetOriginalValues() {
		_pmMessage.resetOriginalValues();
	}

	private PMMessage _pmMessage;
}