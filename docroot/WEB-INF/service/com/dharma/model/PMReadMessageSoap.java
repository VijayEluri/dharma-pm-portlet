/**
 * Copyright (c) 2000-2010 Liferay, Inc. All rights reserved.
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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <a href="PMReadMessageSoap.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * {@link com.dharma.service.http.PMReadMessageServiceSoap}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       com.dharma.service.http.PMReadMessageServiceSoap
 * @generated
 */
public class PMReadMessageSoap implements Serializable {
	public static PMReadMessageSoap toSoapModel(PMReadMessage model) {
		PMReadMessageSoap soapModel = new PMReadMessageSoap();

		soapModel.setReadMessageId(model.getReadMessageId());
		soapModel.setMessageId(model.getMessageId());
		soapModel.setReadDate(model.getReadDate());

		return soapModel;
	}

	public static PMReadMessageSoap[] toSoapModels(PMReadMessage[] models) {
		PMReadMessageSoap[] soapModels = new PMReadMessageSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PMReadMessageSoap[][] toSoapModels(PMReadMessage[][] models) {
		PMReadMessageSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new PMReadMessageSoap[models.length][models[0].length];
		}
		else {
			soapModels = new PMReadMessageSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PMReadMessageSoap[] toSoapModels(List<PMReadMessage> models) {
		List<PMReadMessageSoap> soapModels = new ArrayList<PMReadMessageSoap>(models.size());

		for (PMReadMessage model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PMReadMessageSoap[soapModels.size()]);
	}

	public PMReadMessageSoap() {
	}

	public long getPrimaryKey() {
		return _readMessageId;
	}

	public void setPrimaryKey(long pk) {
		setReadMessageId(pk);
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

	private long _readMessageId;
	private long _messageId;
	private Date _readDate;
}