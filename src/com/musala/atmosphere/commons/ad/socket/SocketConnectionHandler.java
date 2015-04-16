package com.musala.atmosphere.commons.ad.socket;

import java.io.IOException;
import java.net.SocketException;

import android.util.Log;

import com.musala.atmosphere.commons.ad.Request;
import com.musala.atmosphere.commons.ad.RequestHandler;
import com.musala.atmosphere.commons.ad.RequestType;

/**
 * Class, responsible for receiving and handling agent requests while the Atmosphere on-device component is running.
 * 
 * @author yordan.petrov
 * 
 * @param <T>
 *        - the type of the requests to be handled
 */
public class SocketConnectionHandler<T extends RequestType> implements Runnable {
    public static final String SOCKET_SERVER_TAG = SocketConnectionHandler.class.getSimpleName();

    private DeviceSocketServer<T> socketServer;

    private volatile boolean isRunning;

    /**
     * Creates a socket server on the given port. The socket server receives and responds to agent requests using the
     * request handler.
     * 
     * @param requestHandler
     *        - the {@link RequestHandler} instance that will be used for request handling
     * @param port
     *        - port on which to open a socket server
     * @throws IOException
     *         - if the input or output stream initialization fails
     */
    public SocketConnectionHandler(RequestHandler<T> requestHandler, int port) throws IOException {
        socketServer = new DeviceSocketServer<T>(requestHandler, port);
        isRunning = false;
    }

    @Override
    public void run() {
        isRunning = true;

        while (isRunning) {
            try {
                Log.i(SOCKET_SERVER_TAG, "Waiting for connection.");
                socketServer.acceptConnection();

                Log.i(SOCKET_SERVER_TAG, "Connection accepted, receiving request.");
                Request<T> request = socketServer.handle();

                Log.i(SOCKET_SERVER_TAG, "Handled request '" + request.getType() + "'.");
            } catch (SocketException se) {
                Log.d(SOCKET_SERVER_TAG, "Error in connection : " + se.getMessage());
            } catch (IOException ioe) {
                Log.d(SOCKET_SERVER_TAG, "Error in I/O: " + ioe.getMessage());
            } catch (ClassNotFoundException e) {
                Log.d(SOCKET_SERVER_TAG, "Unsupported request sent.", e);
            }

            // Closing the connection in a separate block
            try {
                socketServer.endConnection();
                Log.i(SOCKET_SERVER_TAG, "Connection closed.");
            } catch (IOException e) {
                Log.d(SOCKET_SERVER_TAG, "Error in I/O: " + e.getMessage(), e);
            }
        }
    }

    /**
     * Terminates the work of the socket connection handler.
     */
    public void terminate() {
        isRunning = false;
    }

    /**
     * Checks whether the socket connection handler is running.
     * 
     * @return <code>true</code> if the socket server is running, <code>false</code> otherwise
     */
    public boolean isRunning() {
        return isRunning;
    }

    /**
     * Terminates the work of the socket server.
     * 
     * @throws IOException
     *         - if closing the input or output streams fails
     */
    public void terminateSocketServer() throws IOException {
        socketServer.stop();
    }
}
