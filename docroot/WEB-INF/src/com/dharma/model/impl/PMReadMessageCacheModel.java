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

package com.dharma.model.impl;

import com.dharma.model.PMReadMessage;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing PMReadMessage in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see PMReadMessage
 * @generated
 */
public class PMReadMessageCacheModel implements CacheModel<PMReadMessage>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{readMessageId=");
		sb.append(readMessageId);
		sb.append(", messageId=");
		sb.append(messageId);
		sb.append(", readDate=");
		sb.append(readDate);
		sb.append("}");

		return sb.toString();
	}

	public PMReadMessage toEntityModel() {
		PMReadMessageImpl pmReadMessageImpl = new PMReadMessageImpl();

		pmReadMessageImpl.setReadMessageId(readMessageId);
		pmReadMessageImpl.setMessageId(messageId);

		if (readDate == Long.MIN_VALUE) {
			pmReadMessageImpl.setReadDate(null);
		}
		else {
			pmReadMessageImpl.setReadDate(new Date(readDate));
		}

		pmReadMessageImpl.resetOriginalValues();

		return pmReadMessageImpl;
	}

	public long readMessageId;
	public long messageId;
	public long readDate;
}