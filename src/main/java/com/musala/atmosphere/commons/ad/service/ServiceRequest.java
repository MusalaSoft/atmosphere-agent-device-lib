// This file is part of the ATMOSPHERE mobile testing framework.
// Copyright (C) 2016 MusalaSoft
//
// ATMOSPHERE is free software: you can redistribute it and/or modify
// it under the terms of the GNU General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.
//
// ATMOSPHERE is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// GNU General Public License for more details.
//
// You should have received a copy of the GNU General Public License
// along with ATMOSPHERE.  If not, see <http://www.gnu.org/licenses/>.

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
     * Checks if any audio is currently playing on the device.
     */
    IS_AUDIO_PLAYING,
    /**
     * Used to check the GPS location state of the device.
     */
    IS_GPS_LOCATION_ENABLED,
    /**
     * Used to show the tap locations on the current device screen.
     */
    SHOW_TAP_LOCATION,
    /**
     * Used to stop a given background process.
     */
    STOP_BACKGROUND_PROCESS,
    /**
     * Used for retrieving token for the device from the Augmented Traffic Control tool.
     */
    RETRIEVE_TOKEN,
    /**
     * Used for modifying WiFi connection properties for the device from the Augmented Traffic Control tool.
     */
    SHAPE_DEVICE,
    /**
     * Used for restoring WiFi connection properties for the device from the Augmented Traffic Control tool.
     */
    UNSHAPE_DEVICE,
    /**
     * Used for getting the device's free disk space.
     */
    GET_AVAILABLE_DISK_SPACE,
    /**
     * Used for getting the external storage for this device which is set in the system environment.
     */
    GET_EXTERNAL_STORAGE,
    /**
     * Used to show a toast message on the device's screen.
     */
    SHOW_TOAST;
}
