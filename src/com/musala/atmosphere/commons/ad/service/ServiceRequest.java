package com.musala.atmosphere.commons.ad.service;

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
	 * Used to request information about the battery state of the device.
	 */
	GET_BATTERY_STATE,

	/**
	 * Used to request information about the battery level of the device.
	 */
	GET_BATTERY_LEVEL,

	/**
	 * Used to request information about the power state of the device.
	 */
	GET_POWER_STATE,

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
	GET_ORIENTATION_READINGS;
}
