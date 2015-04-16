package com.musala.atmosphere.commons.ad.socket;

import java.io.IOException;

import android.util.Log;

import com.musala.atmosphere.commons.ad.RequestHandler;
import com.musala.atmosphere.commons.ad.RequestType;

/**
 * A socket server that listens for sockets requests by the Agent, forwards them to a {@link RequestHandler} and returns
 * its response back to the Agent.
 * 
 * @author yordan.petrov
 * 
 */
public class OnDeviceSocketServer<T extends RequestType> {
    public static final String SOCKET_SERVER_TAG = OnDeviceSocketServer.class.getSimpleName();

    private static final int SOCKET_THREAD_KILL_TIMEOUT = 1000;

    private SocketConnectionHandler<T> connectionHandler;

    private Thread socketServerThread;

    /**
     * Creates an object that can start a socket server on the given port in a new thread. The socket server will listen
     * for and respond to requests from the agent using the given request handler.
     * 
     * @param requestHandler
     *        - the {@link RequestHandler} instance that will be used for request handling
     * @param port
     *        - port on which to open a socket server
     * @throws IOException
     *         - if the input or output stream initialization fails
     */
    public OnDeviceSocketServer(RequestHandler<T> requestHandler, int port) throws IOException {
        connectionHandler = new SocketConnectionHandler<T>(requestHandler, port);
    }

    /**
     * Checks whether the network thread is initialized and running.
     * 
     * @return <code>true</code> if the network thread is running, <code>false</code> otherwise
     */
    public boolean isNetworkThreadRunning() {
        boolean isSocketThreadInitialized = socketServerThread != null && socketServerThread.isAlive();
        boolean isSocketServerRunning = connectionHandler != null && connectionHandler.isRunning();

        return isSocketThreadInitialized && isSocketServerRunning;
    }

    /**
     * Initializes and starts the network thread.
     * 
     * @throws IOException
     *         - if network thread initialization fails
     */
    public void start() throws IOException {
        if (!isNetworkThreadRunning()) {
            socketServerThread = new Thread(connectionHandler);
            socketServerThread.start();
            Log.i(SOCKET_SERVER_TAG, "Started network thread.");
        } else {
            Log.e(SOCKET_SERVER_TAG, "Failed to start network thread.");
        }
    }

    /**
     * Terminates the work of the socket server.
     */
    public void terminate() {
        if (!isNetworkThreadRunning()) {
            Log.w(SOCKET_SERVER_TAG, "Could not terminate network thread. Network thread is not running.");
            return;
        }

        Log.wtf(SOCKET_SERVER_TAG, "Stopping socket server...");
        connectionHandler.terminate();

        try {
            socketServerThread.join(SOCKET_THREAD_KILL_TIMEOUT);
            Log.d(SOCKET_SERVER_TAG, "Network thread should be stopped now...");
        } catch (InterruptedException e) {
            Log.d(SOCKET_SERVER_TAG, "Error stopping network thread...", e);
        }

        try {
            connectionHandler.terminateSocketServer();
            Log.i(SOCKET_SERVER_TAG, "Socket connection stopped successfully!");
        } catch (IOException e) {
            Log.e(SOCKET_SERVER_TAG, "Could not close opened connection.");
        }
    }

}
