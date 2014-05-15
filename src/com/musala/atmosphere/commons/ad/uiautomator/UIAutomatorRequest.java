package com.musala.atmosphere.commons.ad.uiautomator;

import com.musala.atmosphere.commons.ad.RequestType;
import com.musala.atmosphere.commons.gesture.Timeline;

/**
 * Enumerators that define the type of action that is requested from the ATMOSPHERE UIAutomator-based on-device
 * component.
 * 
 * @author yordan.petrov
 * 
 */
public enum UIAutomatorRequest implements RequestType {
    /**
     * Used in order to validate the bridge. The bridge should return this object back as a response.
     */
    VALIDATION,

    /**
     * Returned by the bridge when the the request does not require a particular response.
     */
    ANY_RESPONSE,

    /**
     * Plays the gesture, described in the passed {@link Timeline} list.
     */
    PLAY_GESTURE,
    /**
     * Used for UI element clearing.
     */
    CLEAR_FIELD,
    /**
     * Used for waiting a given UI element to appear on the screen.
     */
    WAIT_FOR_EXISTS,
    /**
     * Used for UI element swiping.
     */
    ELEMENT_SWIPE;

}
