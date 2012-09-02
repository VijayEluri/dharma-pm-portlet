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

import com.dharma.model.PMMessage;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing PMMessage in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see PMMessage
 * @generated
 */
public class PMMessageCacheModel implements CacheModel<PMMessage>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{messageId=");
		sb.append(messageId);
		sb.append(", subject=");
		sb.append(subject);
		sb.append(", body=");
		sb.append(body);
		sb.append(", parentMessageId=");
		sb.append(parentMessageId);
		sb.append(", ownerId=");
		sb.append(ownerId);
		sb.append(", ownerName=");
		sb.append(ownerName);
		sb.append(", postedDate=");
		sb.append(postedDate);
		sb.append(", recepients=");
		sb.append(recepients);
		sb.append("}");

		return sb.toString();
	}

	public PMMessage toEntityModel() {
		PMMessageImpl pmMessageImpl = new PMMessageImpl();

		pmMessageImpl.setMessageId(messageId);

		if (subject == null) {
			pmMessageImpl.setSubject(StringPool.BLANK);
		}
		else {
			pmMessageImpl.setSubject(subject);
		}

		if (body == null) {
			pmMessageImpl.setBody(StringPool.BLANK);
		}
		else {
			pmMessageImpl.setBody(body);
		}

		pmMessageImpl.setParentMessageId(parentMessageId);
		pmMessageImpl.setOwnerId(ownerId);

		if (ownerName == null) {
			pmMessageImpl.setOwnerName(StringPool.BLANK);
		}
		else {
			pmMessageImpl.setOwnerName(ownerName);
		}

		if (postedDate == Long.MIN_VALUE) {
			pmMessageImpl.setPostedDate(null);
		}
		else {
			pmMessageImpl.setPostedDate(new Date(postedDate));
		}

		if (recepients == null) {
			pmMessageImpl.setRecepients(StringPool.BLANK);
		}
		else {
			pmMessageImpl.setRecepients(recepients);
		}

		pmMessageImpl.resetOriginalValues();

		return pmMessageImpl;
	}

	public long messageId;
	public String subject;
	public String body;
	public long parentMessageId;
	public long ownerId;
	public String ownerName;
	public long postedDate;
	public String recepients;
}