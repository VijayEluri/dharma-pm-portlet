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

import com.dharma.model.PMBlockedUser;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing PMBlockedUser in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see PMBlockedUser
 * @generated
 */
public class PMBlockedUserCacheModel implements CacheModel<PMBlockedUser>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{blockedUserId=");
		sb.append(blockedUserId);
		sb.append(", ownerId=");
		sb.append(ownerId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", blockedDate=");
		sb.append(blockedDate);
		sb.append("}");

		return sb.toString();
	}

	public PMBlockedUser toEntityModel() {
		PMBlockedUserImpl pmBlockedUserImpl = new PMBlockedUserImpl();

		pmBlockedUserImpl.setBlockedUserId(blockedUserId);
		pmBlockedUserImpl.setOwnerId(ownerId);
		pmBlockedUserImpl.setUserId(userId);

		if (blockedDate == Long.MIN_VALUE) {
			pmBlockedUserImpl.setBlockedDate(null);
		}
		else {
			pmBlockedUserImpl.setBlockedDate(new Date(blockedDate));
		}

		pmBlockedUserImpl.resetOriginalValues();

		return pmBlockedUserImpl;
	}

	public long blockedUserId;
	public long ownerId;
	public long userId;
	public long blockedDate;
}