package com.musala.atmosphere.commons.ad.gestureplayer;

import com.musala.atmosphere.commons.ad.RequestType;

/**
 * Enumerators that define the type of action that is requested to the ATMOSPHERE Gesture player.
 * 
 * @author yordan.petrov
 * 
 */
public enum GesturePlayerRequest implements RequestType
{
	/**
	 * Used in order to validate the ATMOSPHERE service. The service should return this object back as a response.
	 */
	VALIDATION,

	/**
	 * Returned by the service when the the request does not require a particular response.
	 */
	ANY_RESPONSE,

	/**
	 * Sent to request adding a {@link Timeline} instance that will be used for touch event generation.
	 */
	INSERT_TIMELINE,

	/**
	 * Sent to request marking this moment as the moment when the {@link #insertTimeline(Timeline) timelines} execution
	 * starts.
	 */
	MARK_TIMELINE_START,

	/**
	 * Calculates the pointer position on which each {@link Timeline} should be at the current moment and then sends
	 * adequate motion event to the device's input manager.
	 */
	ACT,

	/**
	 * Plays the inserted {@link Timeline} instances.
	 */
	PLAY_GESTURE;
}
