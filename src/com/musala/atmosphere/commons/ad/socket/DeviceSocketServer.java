package com.musala.atmosphere.commons.ad.socket;

import java.io.IOException;

import com.musala.atmosphere.commons.ad.Request;
import com.musala.atmosphere.commons.ad.RequestHandler;
import com.musala.atmosphere.commons.ad.RequestType;

/**
 * Class for starting a local socket server that will handle requests of some {@link RequestType}.
 * 
 * @author georgi.gaydarov
 * 
 */
public class DeviceSocketServer<T extends RequestType> extends SocketObjectServer {
    private RequestHandler<T> requestHandler;

    /**
     * Creates a new socket server that handles requests with a specific {@link RequestHandler} on a given port.
     * 
     * @param requestHandler
     *        - the {@link RequestHandler} that will be used for request handling.
     * @param port
     *        - port on which to open a socket server.
     * @throws IOException
     */
    public DeviceSocketServer(RequestHandler<T> requestHandler, int port) throws IOException {
        super(port);
        this.requestHandler = requestHandler;
    }

    /**
     * Handles the next request sent by the client using the {@link RequestHandler} that was specified when this class
     * was created.
     * 
     * @return the {@link Request} that was handled.
     * @throws IOException
     * @throws ClassNotFoundException
     */
    @SuppressWarnings("unchecked")
    public Request<T> handle() throws IOException, ClassNotFoundException {
        Request<T> request = (Request<T>) receiveObject();
        Object response = requestHandler.handle(request);
        sendObject(response);

        return request;
    }
}
