package com.musala.atmosphere.commons.ad.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

/**
 * A helper class that represents a socket server that specializes in object sending and receiving.
 *
 * @author georgi.gaydarov
 *
 */
class SocketObjectServer {
    private static final int SOCKET_SERVER_IDLE_TIMEOUT = 10000;

    private final ServerSocket serverSocket;

    private InputStream socketInputStream;

    private OutputStream socketOutputStream;

    private Socket clientSocket;

    /**
     * Starts a new server on a specified port and sets default timeout for <i>accept()</i> operation.
     *
     * @param onPort
     *        - the port on which the server will listen.
     * @throws IOException
     */
    public SocketObjectServer(int onPort) throws IOException {
        serverSocket = new ServerSocket(onPort);
        serverSocket.setSoTimeout(SOCKET_SERVER_IDLE_TIMEOUT);
    }

    /**
     * Blocks until a connection from a client is established or the
     * {@link SocketObjectServer#SOCKET_SERVER_IDLE_TIMEOUT} is reached.
     *
     * @throws IOException
     *         if an I/O exception has occurred.
     * @throws SocketTimeoutException
     *         when the default waiting timeout for accept() method is reached.
     */
    public void acceptConnection() throws IOException {
        clientSocket = serverSocket.accept();
        socketInputStream = clientSocket.getInputStream();
        socketOutputStream = clientSocket.getOutputStream();
    }

    /**
     * Fetches the next object that the client sends.
     *
     * @return an object that was sent by a connected client.
     * @throws IOException
     *         if an I/O exception has occurred.
     * @throws ClassNotFoundException
     *         thrown when an application fails to load in a class.
     */
    protected Object receiveObject() throws IOException, ClassNotFoundException {
        ObjectInputStream objectIn = new ObjectInputStream(socketInputStream);
        Object result = objectIn.readObject();
        return result;
    }

    /**
     * Sends an object to the client.
     *
     * @param toSend
     *        - serializable object to be sent to the client.
     * @throws IOException
     *         if an I/O exception has occurred.
     */
    protected void sendObject(Object toSend) throws IOException {
        ObjectOutputStream objectOut = new ObjectOutputStream(socketOutputStream);
        objectOut.writeObject(toSend);
    }

    /**
     * Closes the connection to the client.
     *
     * @throws IOException
     *         if an I/O exception has occurred.
     */
    public void endConnection() throws IOException {
        if (socketInputStream != null) {
            socketInputStream.close();
            socketInputStream = null;
        }
        if (socketOutputStream != null) {
            socketOutputStream.close();
            socketOutputStream = null;
        }
        if (clientSocket != null) {
            clientSocket.close();
        }
    }

    /**
     * Closes client connection and destroys all resources, allocated by the socket server.
     *
     * @throws IOException
     *         if an I/O exception has occurred.
     */
    public void stop() throws IOException {
        endConnection();

        if (serverSocket != null) {
            serverSocket.close();
        }
    }
}
