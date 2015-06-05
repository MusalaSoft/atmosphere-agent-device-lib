package com.musala.atmosphere.commons.ad.service;

import com.musala.atmosphere.commons.PowerProperties;
import com.musala.atmosphere.commons.ad.RequestType;

/**
 * Enumerators that define the type of action that is requested to the ATMOSPHERE Service.
 * 
 * @author yordan.petrov
 * 
 */
public enum ServiceRequest implements RequestType {
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

    /**
     * Sent to request the readings from the proximity sensor of the device.
     */
    GET_PROXIMITY_READINGS,

    /**
     * Sent to request the information telephony services on the device.
     */
    GET_TELEPHONY_INFORMATION,

    /**
     * Sent to request an application launch on the device.
     */
    START_APP,
    /**
     * Sent to request the awake status of the device.
     */
    GET_AWAKE_STATUS,
    /**
     * Used to check if the device has camera available.
     */
    GET_CAMERA_AVAILABILITY,
    /**
     * Used to request if process is running on the device
     */
    GET_PROCESS_RUNNING,
    /**
     * Used to request mocking of device's location.
     */
    MOCK_LOCATION,
    /**
     * Used to disable mocking location for a given provider.
     */
    DISABLE_MOCK_LOCATION,
    /**
     * Used to request disabling and re-enabling of the keyguard.
     */
    SET_KEYGUARD,
    /**
     * Used to request moving a given task to the foreground on the device.
     */
    BRING_TASK_TO_FRONT,
    /**
     * Used to request the ids of all running tasks on the device.
     */
    GET_RUNNING_TASK_IDS,
    /**
     * Used to wait and check if task on the device is successfully updated to given position.
     */
    WAIT_FOR_TASKS_UPDATE,
    /**
     * Used to broadcast an intent to all interested receivers on the device.
     */
    SEND_BROADCAST,
    /**
     * Used to request the total RAM of the device.
     */
    GET_TOTAL_RAM,
    /**
     * Used to check the lock state of the device.
     */
    IS_LOCKED,
    /**
     * Used to open the location settings activity of the device.
     */
    OPEN_LOCATION_SETTINGS,
    /**
     * Used to check the GPS location state of the device.
     */
    IS_GPS_LOCATION_ENABLED;
}
