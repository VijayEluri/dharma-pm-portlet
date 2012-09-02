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

import com.dharma.model.PMDeletedMessage;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing PMDeletedMessage in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see PMDeletedMessage
 * @generated
 */
public class PMDeletedMessageCacheModel implements CacheModel<PMDeletedMessage>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{deletedMessageId=");
		sb.append(deletedMessageId);
		sb.append(", messageId=");
		sb.append(messageId);
		sb.append(", ownerId=");
		sb.append(ownerId);
		sb.append(", deletedDate=");
		sb.append(deletedDate);
		sb.append("}");

		return sb.toString();
	}

	public PMDeletedMessage toEntityModel() {
		PMDeletedMessageImpl pmDeletedMessageImpl = new PMDeletedMessageImpl();

		pmDeletedMessageImpl.setDeletedMessageId(deletedMessageId);
		pmDeletedMessageImpl.setMessageId(messageId);
		pmDeletedMessageImpl.setOwnerId(ownerId);

		if (deletedDate == Long.MIN_VALUE) {
			pmDeletedMessageImpl.setDeletedDate(null);
		}
		else {
			pmDeletedMessageImpl.setDeletedDate(new Date(deletedDate));
		}

		pmDeletedMessageImpl.resetOriginalValues();

		return pmDeletedMessageImpl;
	}

	public long deletedMessageId;
	public long messageId;
	public long ownerId;
	public long deletedDate;
}