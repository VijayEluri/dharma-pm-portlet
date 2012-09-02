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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * The utility for the p m message local service. This utility wraps {@link com.dharma.service.impl.PMMessageLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PMMessageLocalService
 * @see com.dharma.service.base.PMMessageLocalServiceBaseImpl
 * @see com.dharma.service.impl.PMMessageLocalServiceImpl
 * @generated
 */
public class PMMessageLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.dharma.service.impl.PMMessageLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the p m message to the database. Also notifies the appropriate model listeners.
	*
	* @param pmMessage the p m message
	* @return the p m message that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.dharma.model.PMMessage addPMMessage(
		com.dharma.model.PMMessage pmMessage)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addPMMessage(pmMessage);
	}

	/**
	* Creates a new p m message with the primary key. Does not add the p m message to the database.
	*
	* @param messageId the primary key for the new p m message
	* @return the new p m message
	*/
	public static com.dharma.model.PMMessage createPMMessage(long messageId) {
		return getService().createPMMessage(messageId);
	}

	/**
	* Deletes the p m message with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param messageId the primary key of the p m message
	* @return the p m message that was removed
	* @throws PortalException if a p m message with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.dharma.model.PMMessage deletePMMessage(long messageId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deletePMMessage(messageId);
	}

	/**
	* Deletes the p m message from the database. Also notifies the appropriate model listeners.
	*
	* @param pmMessage the p m message
	* @return the p m message that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.dharma.model.PMMessage deletePMMessage(
		com.dharma.model.PMMessage pmMessage)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deletePMMessage(pmMessage);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	public static com.dharma.model.PMMessage fetchPMMessage(long messageId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchPMMessage(messageId);
	}

	/**
	* Returns the p m message with the primary key.
	*
	* @param messageId the primary key of the p m message
	* @return the p m message
	* @throws PortalException if a p m message with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.dharma.model.PMMessage getPMMessage(long messageId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPMMessage(messageId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the p m messages.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of p m messages
	* @param end the upper bound of the range of p m messages (not inclusive)
	* @return the range of p m messages
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.dharma.model.PMMessage> getPMMessages(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getPMMessages(start, end);
	}

	/**
	* Returns the number of p m messages.
	*
	* @return the number of p m messages
	* @throws SystemException if a system exception occurred
	*/
	public static int getPMMessagesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getPMMessagesCount();
	}

	/**
	* Updates the p m message in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param pmMessage the p m message
	* @return the p m message that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.dharma.model.PMMessage updatePMMessage(
		com.dharma.model.PMMessage pmMessage)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updatePMMessage(pmMessage);
	}

	/**
	* Updates the p m message in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param pmMessage the p m message
	* @param merge whether to merge the p m message with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the p m message that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.dharma.model.PMMessage updatePMMessage(
		com.dharma.model.PMMessage pmMessage, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updatePMMessage(pmMessage, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static int getUnreadCount(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getUnreadCount(userId);
	}

	public static java.util.List<com.dharma.model.PMMessage> getInboxMessages(
		long userId) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getInboxMessages(userId);
	}

	public static java.util.List<com.dharma.model.PMMessage> getOutboxMessages(
		long ownerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getOutboxMessages(ownerId);
	}

	public static void clearService() {
		_service = null;
	}

	public static PMMessageLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					PMMessageLocalService.class.getName());

			if (invokableLocalService instanceof PMMessageLocalService) {
				_service = (PMMessageLocalService)invokableLocalService;
			}
			else {
				_service = new PMMessageLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(PMMessageLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated
	 */
	public void setService(PMMessageLocalService service) {
	}

	private static PMMessageLocalService _service;
}