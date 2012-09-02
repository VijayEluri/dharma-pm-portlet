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

package com.dharma.service;

import com.dharma.model.PMBlockedUserClp;
import com.dharma.model.PMDeletedMessageClp;
import com.dharma.model.PMMessageClp;
import com.dharma.model.PMReadMessageClp;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayInputStream;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayOutputStream;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ClassLoaderObjectInputStream;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModel;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class ClpSerializer {
	public static String getServletContextName() {
		if (Validator.isNotNull(_servletContextName)) {
			return _servletContextName;
		}

		synchronized (ClpSerializer.class) {
			if (Validator.isNotNull(_servletContextName)) {
				return _servletContextName;
			}

			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Class<?> portletPropsClass = classLoader.loadClass(
						"com.liferay.util.portlet.PortletProps");

				Method getMethod = portletPropsClass.getMethod("get",
						new Class<?>[] { String.class });

				String portletPropsServletContextName = (String)getMethod.invoke(null,
						"dharma-pm-portlet-deployment-context");

				if (Validator.isNotNull(portletPropsServletContextName)) {
					_servletContextName = portletPropsServletContextName;
				}
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info(
						"Unable to locate deployment context from portlet properties");
				}
			}

			if (Validator.isNull(_servletContextName)) {
				try {
					String propsUtilServletContextName = PropsUtil.get(
							"dharma-pm-portlet-deployment-context");

					if (Validator.isNotNull(propsUtilServletContextName)) {
						_servletContextName = propsUtilServletContextName;
					}
				}
				catch (Throwable t) {
					if (_log.isInfoEnabled()) {
						_log.info(
							"Unable to locate deployment context from portal properties");
					}
				}
			}

			if (Validator.isNull(_servletContextName)) {
				_servletContextName = "dharma-pm-portlet";
			}

			return _servletContextName;
		}
	}

	public static Object translateInput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(PMBlockedUserClp.class.getName())) {
			return translateInputPMBlockedUser(oldModel);
		}

		if (oldModelClassName.equals(PMDeletedMessageClp.class.getName())) {
			return translateInputPMDeletedMessage(oldModel);
		}

		if (oldModelClassName.equals(PMMessageClp.class.getName())) {
			return translateInputPMMessage(oldModel);
		}

		if (oldModelClassName.equals(PMReadMessageClp.class.getName())) {
			return translateInputPMReadMessage(oldModel);
		}

		return oldModel;
	}

	public static Object translateInput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateInput(curObj));
		}

		return newList;
	}

	public static Object translateInputPMBlockedUser(BaseModel<?> oldModel) {
		PMBlockedUserClp oldClpModel = (PMBlockedUserClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getPMBlockedUserRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputPMDeletedMessage(BaseModel<?> oldModel) {
		PMDeletedMessageClp oldClpModel = (PMDeletedMessageClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getPMDeletedMessageRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputPMMessage(BaseModel<?> oldModel) {
		PMMessageClp oldClpModel = (PMMessageClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getPMMessageRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputPMReadMessage(BaseModel<?> oldModel) {
		PMReadMessageClp oldClpModel = (PMReadMessageClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getPMReadMessageRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateInput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateInput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Object translateOutput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals("com.dharma.model.impl.PMBlockedUserImpl")) {
			return translateOutputPMBlockedUser(oldModel);
		}

		if (oldModelClassName.equals(
					"com.dharma.model.impl.PMDeletedMessageImpl")) {
			return translateOutputPMDeletedMessage(oldModel);
		}

		if (oldModelClassName.equals("com.dharma.model.impl.PMMessageImpl")) {
			return translateOutputPMMessage(oldModel);
		}

		if (oldModelClassName.equals("com.dharma.model.impl.PMReadMessageImpl")) {
			return translateOutputPMReadMessage(oldModel);
		}

		return oldModel;
	}

	public static Object translateOutput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateOutput(curObj));
		}

		return newList;
	}

	public static Object translateOutput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateOutput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateOutput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Throwable translateThrowable(Throwable throwable) {
		if (_useReflectionToTranslateThrowable) {
			try {
				UnsyncByteArrayOutputStream unsyncByteArrayOutputStream = new UnsyncByteArrayOutputStream();
				ObjectOutputStream objectOutputStream = new ObjectOutputStream(unsyncByteArrayOutputStream);

				objectOutputStream.writeObject(throwable);

				objectOutputStream.flush();
				objectOutputStream.close();

				UnsyncByteArrayInputStream unsyncByteArrayInputStream = new UnsyncByteArrayInputStream(unsyncByteArrayOutputStream.unsafeGetByteArray(),
						0, unsyncByteArrayOutputStream.size());

				Thread currentThread = Thread.currentThread();

				ClassLoader contextClassLoader = currentThread.getContextClassLoader();

				ObjectInputStream objectInputStream = new ClassLoaderObjectInputStream(unsyncByteArrayInputStream,
						contextClassLoader);

				throwable = (Throwable)objectInputStream.readObject();

				objectInputStream.close();

				return throwable;
			}
			catch (SecurityException se) {
				if (_log.isInfoEnabled()) {
					_log.info("Do not use reflection to translate throwable");
				}

				_useReflectionToTranslateThrowable = false;
			}
			catch (Throwable throwable2) {
				_log.error(throwable2, throwable2);

				return throwable2;
			}
		}

		Class<?> clazz = throwable.getClass();

		String className = clazz.getName();

		if (className.equals(PortalException.class.getName())) {
			return new PortalException();
		}

		if (className.equals(SystemException.class.getName())) {
			return new SystemException();
		}

		if (className.equals("com.dharma.NoSuchPMBlockedUserException")) {
			return new com.dharma.NoSuchPMBlockedUserException();
		}

		if (className.equals("com.dharma.NoSuchPMDeletedMessageException")) {
			return new com.dharma.NoSuchPMDeletedMessageException();
		}

		if (className.equals("com.dharma.NoSuchPMMessageException")) {
			return new com.dharma.NoSuchPMMessageException();
		}

		if (className.equals("com.dharma.NoSuchPMReadMessageException")) {
			return new com.dharma.NoSuchPMReadMessageException();
		}

		return throwable;
	}

	public static Object translateOutputPMBlockedUser(BaseModel<?> oldModel) {
		PMBlockedUserClp newModel = new PMBlockedUserClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setPMBlockedUserRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputPMDeletedMessage(BaseModel<?> oldModel) {
		PMDeletedMessageClp newModel = new PMDeletedMessageClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setPMDeletedMessageRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputPMMessage(BaseModel<?> oldModel) {
		PMMessageClp newModel = new PMMessageClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setPMMessageRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputPMReadMessage(BaseModel<?> oldModel) {
		PMReadMessageClp newModel = new PMReadMessageClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setPMReadMessageRemoteModel(oldModel);

		return newModel;
	}

	private static Log _log = LogFactoryUtil.getLog(ClpSerializer.class);
	private static String _servletContextName;
	private static boolean _useReflectionToTranslateThrowable = true;
}