package com.musala.atmosphere.commons.ad;

/**
 * Interface that describes the layout of a handler for {@link Request} objects of specific {@link RequestType}.
 * 
 * @author georgi.gaydarov
 * 
 * @param <T>
 *        - the {@link RequestType} of the {@link Request} objects that this class will handle.
 */
public interface RequestHandler<T extends RequestType> {
    /**
     * Handles a {@link Request} object.
     * 
     * @param request
     *        - the request to be handled by this handler class.
     * @return the request handling result.
     */
    public Object handle(Request<T> request);
}
