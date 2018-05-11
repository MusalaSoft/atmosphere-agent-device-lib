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
     *         if an I/O exception of some sort has occurred.
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
     *         if an I/O exception of some sort has occurred.
     * @throws ClassNotFoundException
     *         thrown when an application fails to load in a class.
     */
    @SuppressWarnings("unchecked")
    public Request<T> handle() throws IOException, ClassNotFoundException {
        Request<T> request = (Request<T>) receiveObject();
        Object response = requestHandler.handle(request);
        sendObject(response);

        return request;
    }
}
