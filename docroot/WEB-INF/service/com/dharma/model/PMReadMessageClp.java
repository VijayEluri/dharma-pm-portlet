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

import com.dharma.service.PMReadMessageLocalServiceUtil;

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
public class PMReadMessageClp extends BaseModelImpl<PMReadMessage>
	implements PMReadMessage {
	public PMReadMessageClp() {
	}

	public Class<?> getModelClass() {
		return PMReadMessage.class;
	}

	public String getModelClassName() {
		return PMReadMessage.class.getName();
	}

	public long getPrimaryKey() {
		return _readMessageId;
	}

	public void setPrimaryKey(long primaryKey) {
		setReadMessageId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_readMessageId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("readMessageId", getReadMessageId());
		attributes.put("messageId", getMessageId());
		attributes.put("readDate", getReadDate());

		return attributes;
	}

	@Override
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

	public long getReadMessageId() {
		return _readMessageId;
	}

	public void setReadMessageId(long readMessageId) {
		_readMessageId = readMessageId;
	}

	public long getMessageId() {
		return _messageId;
	}

	public void setMessageId(long messageId) {
		_messageId = messageId;
	}

	public Date getReadDate() {
		return _readDate;
	}

	public void setReadDate(Date readDate) {
		_readDate = readDate;
	}

	public BaseModel<?> getPMReadMessageRemoteModel() {
		return _pmReadMessageRemoteModel;
	}

	public void setPMReadMessageRemoteModel(
		BaseModel<?> pmReadMessageRemoteModel) {
		_pmReadMessageRemoteModel = pmReadMessageRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			PMReadMessageLocalServiceUtil.addPMReadMessage(this);
		}
		else {
			PMReadMessageLocalServiceUtil.updatePMReadMessage(this);
		}
	}

	@Override
	public PMReadMessage toEscapedModel() {
		return (PMReadMessage)Proxy.newProxyInstance(PMReadMessage.class.getClassLoader(),
			new Class[] { PMReadMessage.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		PMReadMessageClp clone = new PMReadMessageClp();

		clone.setReadMessageId(getReadMessageId());
		clone.setMessageId(getMessageId());
		clone.setReadDate(getReadDate());

		return clone;
	}

	public int compareTo(PMReadMessage pmReadMessage) {
		int value = 0;

		value = DateUtil.compareTo(getReadDate(), pmReadMessage.getReadDate());

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

		PMReadMessageClp pmReadMessage = null;

		try {
			pmReadMessage = (PMReadMessageClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = pmReadMessage.getPrimaryKey();

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
		StringBundler sb = new StringBundler(7);

		sb.append("{readMessageId=");
		sb.append(getReadMessageId());
		sb.append(", messageId=");
		sb.append(getMessageId());
		sb.append(", readDate=");
		sb.append(getReadDate());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("com.dharma.model.PMReadMessage");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>readMessageId</column-name><column-value><![CDATA[");
		sb.append(getReadMessageId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>messageId</column-name><column-value><![CDATA[");
		sb.append(getMessageId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>readDate</column-name><column-value><![CDATA[");
		sb.append(getReadDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _readMessageId;
	private long _messageId;
	private Date _readDate;
	private BaseModel<?> _pmReadMessageRemoteModel;
}