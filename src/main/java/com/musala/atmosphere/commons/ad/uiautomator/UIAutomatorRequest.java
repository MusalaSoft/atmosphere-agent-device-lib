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
    VOID_RESPONSE,

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
     * Used for waiting a given UI element to disappear on the screen.
     */
    WAIT_UNTIL_GONE,

    /**
     * Used for sleeping the device until a screen update occurs or the request times out.
     */
    WAIT_FOR_WINDOW_UPDATE,

    /**
     * Used for UI element swiping.
     */
    ELEMENT_SWIPE,

    /**
     * Used for scrolling to end, beginning, forward and backward.
     */
    SCROLL_TO_DIRECTION,

    /**
     * Used for scrolling into view and in particular scrolling to text.
     */
    SCROLL_INTO_VIEW,

    /**
     * Used for opening the notification bar on the device.
     */
    OPEN_NOTIFICATION_BAR,

    /**
     * Used for opening the quick settings on the device.
     */
    OPEN_QUICK_SETTINGS,

    /**
     * Used to request XML dump of the current screen.
     */
    GET_UI_DUMP_XML,

    /**
     * Used to request building a tree representation of the current screen.
     */
    GET_UI_TREE,

    /**
     * Used to request all UI elements that are matching the given selector.
     */
    GET_UI_ELEMENTS,

    /**
     * Used to request the text of the last detected toast message.
     */
    GET_LAST_TOAST,

    /**
     * Used to stop the component running on the device.
     */
    STOP,

    /**
     * Used to request all child UI elements that are matching the given selector.
     */
    GET_CHILDREN,

    /**
     * Used to request validation of element presence on the screen.
     */
    CHECK_ELEMENT_PRESENCE,
    /**
     * Sends request for executing XPath queries when searching elements on the screen.
     */
    EXECUTE_XPATH_QUERY,
    /**
     * Sends request for executing XPath queries when searching element's children on the screen.
     */
    EXECUTE_XPATH_QUERY_ON_LOCAL_ROOT;
}