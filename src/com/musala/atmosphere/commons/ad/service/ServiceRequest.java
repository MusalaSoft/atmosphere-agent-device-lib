package com.musala.atmosphere.commons.ad.service;

import com.musala.atmosphere.commons.PowerProperties;
import com.musala.atmosphere.commons.ad.RequestType;

/**
 * Enumerators that define the type of action that is requested to the ATMOSPHERE Service.
 * 
 * @author yordan.petrov
 * 
 */
public enum ServiceRequest implements RequestType
{
	/**
	 * Used in order to validate the ATMOSPHERE service. The service should return this object back as a response.
	 */
	VALIDATION,

	/**
	 * Used to request a {@link PowerProperties} data container, describing the device power environment.
	 */
	GET_POWER_PROPERTIES,

	/**
	 * Used to request setting On the WiFi state of the device.
	 */
	SET_WIFI,

	/**
	 * Used to request information about the connection type of the device.
	 */
	GET_CONNECTION_TYPE,

	/**
	 * Returned by the service when the the request does not require a particular response.
	 */
	ANY_RESPONSE,

	/**
	 * Sent to request the readings from the orientation sensor of the device.
	 */
	GET_ORIENTATION_READINGS,

	/**
	 * Sent to request the readings from the acceleration sensor of the device.
	 */
	GET_ACCELERATION_READINGS,

	/*
	 * Sent to request the information telephony services on the device.
	 */
	GET_TELEPHONY_INFORMATION;
}
