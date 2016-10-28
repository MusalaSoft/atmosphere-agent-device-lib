package com.musala.atmosphere.commons.ad;

import java.io.Serializable;

/**
 * Describes a request of some {@link RequestType}. Sent to an on-device application in order to request a given action.
 * 
 * @author yordan.petrov
 * 
 */
public class Request<T extends RequestType> implements Serializable {
    private static final long serialVersionUID = -6559730035384903267L;

    private T requestType;

    private Object[] arguments;

    public Request(T requestType) {
        this.requestType = requestType;
    }

    /**
     * Gets the type of the request.
     * 
     * @return the type of the request.
     */
    public T getType() {
        return requestType;
    }

    /**
     * Sets the type of the request.
     * 
     * @param requestType
     *        - the desired request type.
     */
    public void setAction(T requestType) {
        this.requestType = requestType;
    }

    /**
     * Gets the arguments of the request.
     * 
     * @return the arguments of the request.
     */
    public Object[] getArguments() {
        return arguments;
    }

    /**
     * Sets the arguments of the request.
     * 
     * @param arguments
     *        - the desired request arguments.
     */
    public void setArguments(Object[] arguments) {
        this.arguments = arguments;
    }
}
