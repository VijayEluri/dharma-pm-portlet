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

import com.dharma.service.PMDeletedMessageLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Brian Wing Shun Chan
 */
public class PMDeletedMessageClp extends BaseModelImpl<PMDeletedMessage>
	implements PMDeletedMessage {
	public PMDeletedMessageClp() {
	}

	public Class<?> getModelClass() {
		return PMDeletedMessage.class;
	}

	public String getModelClassName() {
		return PMDeletedMessage.class.getName();
	}

	public long getPrimaryKey() {
		return _deletedMessageId;
	}

	public void setPrimaryKey(long primaryKey) {
		setDeletedMessageId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_deletedMessageId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("deletedMessageId", getDeletedMessageId());
		attributes.put("messageId", getMessageId());
		attributes.put("ownerId", getOwnerId());
		attributes.put("deletedDate", getDeletedDate());

		return attributes;
	}

	@Override
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

	public long getDeletedMessageId() {
		return _deletedMessageId;
	}

	public void setDeletedMessageId(long deletedMessageId) {
		_deletedMessageId = deletedMessageId;
	}

	public long getMessageId() {
		return _messageId;
	}

	public void setMessageId(long messageId) {
		_messageId = messageId;
	}

	public long getOwnerId() {
		return _ownerId;
	}

	public void setOwnerId(long ownerId) {
		_ownerId = ownerId;
	}

	public Date getDeletedDate() {
		return _deletedDate;
	}

	public void setDeletedDate(Date deletedDate) {
		_deletedDate = deletedDate;
	}

	public BaseModel<?> getPMDeletedMessageRemoteModel() {
		return _pmDeletedMessageRemoteModel;
	}

	public void setPMDeletedMessageRemoteModel(
		BaseModel<?> pmDeletedMessageRemoteModel) {
		_pmDeletedMessageRemoteModel = pmDeletedMessageRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			PMDeletedMessageLocalServiceUtil.addPMDeletedMessage(this);
		}
		else {
			PMDeletedMessageLocalServiceUtil.updatePMDeletedMessage(this);
		}
	}

	@Override
	public PMDeletedMessage toEscapedModel() {
		return (PMDeletedMessage)Proxy.newProxyInstance(PMDeletedMessage.class.getClassLoader(),
			new Class[] { PMDeletedMessage.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		PMDeletedMessageClp clone = new PMDeletedMessageClp();

		clone.setDeletedMessageId(getDeletedMessageId());
		clone.setMessageId(getMessageId());
		clone.setOwnerId(getOwnerId());
		clone.setDeletedDate(getDeletedDate());

		return clone;
	}

	public int compareTo(PMDeletedMessage pmDeletedMessage) {
		int value = 0;

		value = DateUtil.compareTo(getDeletedDate(),
				pmDeletedMessage.getDeletedDate());

		value = value * -1;

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		PMDeletedMessageClp pmDeletedMessage = null;

		try {
			pmDeletedMessage = (PMDeletedMessageClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = pmDeletedMessage.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{deletedMessageId=");
		sb.append(getDeletedMessageId());
		sb.append(", messageId=");
		sb.append(getMessageId());
		sb.append(", ownerId=");
		sb.append(getOwnerId());
		sb.append(", deletedDate=");
		sb.append(getDeletedDate());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(16);

		sb.append("<model><model-name>");
		sb.append("com.dharma.model.PMDeletedMessage");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>deletedMessageId</column-name><column-value><![CDATA[");
		sb.append(getDeletedMessageId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>messageId</column-name><column-value><![CDATA[");
		sb.append(getMessageId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ownerId</column-name><column-value><![CDATA[");
		sb.append(getOwnerId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>deletedDate</column-name><column-value><![CDATA[");
		sb.append(getDeletedDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _deletedMessageId;
	private long _messageId;
	private long _ownerId;
	private Date _deletedDate;
	private BaseModel<?> _pmDeletedMessageRemoteModel;
}