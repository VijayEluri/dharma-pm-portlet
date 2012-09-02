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

import com.dharma.service.PMBlockedUserLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Brian Wing Shun Chan
 */
public class PMBlockedUserClp extends BaseModelImpl<PMBlockedUser>
	implements PMBlockedUser {
	public PMBlockedUserClp() {
	}

	public Class<?> getModelClass() {
		return PMBlockedUser.class;
	}

	public String getModelClassName() {
		return PMBlockedUser.class.getName();
	}

	public long getPrimaryKey() {
		return _blockedUserId;
	}

	public void setPrimaryKey(long primaryKey) {
		setBlockedUserId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_blockedUserId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("blockedUserId", getBlockedUserId());
		attributes.put("ownerId", getOwnerId());
		attributes.put("userId", getUserId());
		attributes.put("blockedDate", getBlockedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long blockedUserId = (Long)attributes.get("blockedUserId");

		if (blockedUserId != null) {
			setBlockedUserId(blockedUserId);
		}

		Long ownerId = (Long)attributes.get("ownerId");

		if (ownerId != null) {
			setOwnerId(ownerId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Date blockedDate = (Date)attributes.get("blockedDate");

		if (blockedDate != null) {
			setBlockedDate(blockedDate);
		}
	}

	public long getBlockedUserId() {
		return _blockedUserId;
	}

	public void setBlockedUserId(long blockedUserId) {
		_blockedUserId = blockedUserId;
	}

	public String getBlockedUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getBlockedUserId(), "uuid",
			_blockedUserUuid);
	}

	public void setBlockedUserUuid(String blockedUserUuid) {
		_blockedUserUuid = blockedUserUuid;
	}

	public long getOwnerId() {
		return _ownerId;
	}

	public void setOwnerId(long ownerId) {
		_ownerId = ownerId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	public Date getBlockedDate() {
		return _blockedDate;
	}

	public void setBlockedDate(Date blockedDate) {
		_blockedDate = blockedDate;
	}

	public BaseModel<?> getPMBlockedUserRemoteModel() {
		return _pmBlockedUserRemoteModel;
	}

	public void setPMBlockedUserRemoteModel(
		BaseModel<?> pmBlockedUserRemoteModel) {
		_pmBlockedUserRemoteModel = pmBlockedUserRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			PMBlockedUserLocalServiceUtil.addPMBlockedUser(this);
		}
		else {
			PMBlockedUserLocalServiceUtil.updatePMBlockedUser(this);
		}
	}

	@Override
	public PMBlockedUser toEscapedModel() {
		return (PMBlockedUser)Proxy.newProxyInstance(PMBlockedUser.class.getClassLoader(),
			new Class[] { PMBlockedUser.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		PMBlockedUserClp clone = new PMBlockedUserClp();

		clone.setBlockedUserId(getBlockedUserId());
		clone.setOwnerId(getOwnerId());
		clone.setUserId(getUserId());
		clone.setBlockedDate(getBlockedDate());

		return clone;
	}

	public int compareTo(PMBlockedUser pmBlockedUser) {
		int value = 0;

		value = DateUtil.compareTo(getBlockedDate(),
				pmBlockedUser.getBlockedDate());

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

		PMBlockedUserClp pmBlockedUser = null;

		try {
			pmBlockedUser = (PMBlockedUserClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = pmBlockedUser.getPrimaryKey();

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

		sb.append("{blockedUserId=");
		sb.append(getBlockedUserId());
		sb.append(", ownerId=");
		sb.append(getOwnerId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", blockedDate=");
		sb.append(getBlockedDate());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(16);

		sb.append("<model><model-name>");
		sb.append("com.dharma.model.PMBlockedUser");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>blockedUserId</column-name><column-value><![CDATA[");
		sb.append(getBlockedUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ownerId</column-name><column-value><![CDATA[");
		sb.append(getOwnerId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>blockedDate</column-name><column-value><![CDATA[");
		sb.append(getBlockedDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _blockedUserId;
	private String _blockedUserUuid;
	private long _ownerId;
	private long _userId;
	private String _userUuid;
	private Date _blockedDate;
	private BaseModel<?> _pmBlockedUserRemoteModel;
}