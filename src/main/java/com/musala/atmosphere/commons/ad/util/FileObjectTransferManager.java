package com.musala.atmosphere.commons.ad.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

/**
 * Class for putting object in a file and getting object from a file.
 *
 * @author yavor.stankov
 *
 */

public class FileObjectTransferManager {

    /**
     * Puts a given object in a file.
     *
     * @param object
     *        - the object to put in the file.
     * @param pathToFile
     *        - the path to the place where the new file will be created.
     * @throws IOException
     *         if an I/O exception of some sort has occurred.
     */
    public void writeObjectToFile(Object object, String pathToFile) throws IOException {

        OutputStream buffer = new BufferedOutputStream(new FileOutputStream(pathToFile));
        ObjectOutput output = new ObjectOutputStream(buffer);
        output.writeObject(object);
        output.close();
        buffer.close();
    }

    /**
     * Gets an object from a given file and deletes the file afterwards.
     *
     * @param requestFile
     *        - the name of the file from which we'll get the object.
     * @throws FileNotFoundException
     *         when the passed argument does not denote already existing and writable file or such can not be created
     *         for some reason
     * @throws IOException
     *         if an I/O exception of some sort has occurred.
     * @throws ClassNotFoundException
     *         thrown when an application fails to load in a class
     * @return - the object from the file.
     */
    public Object readObjectFromFile(String requestFile)
        throws FileNotFoundException,
            IOException,
            ClassNotFoundException {
        InputStream buffer = new BufferedInputStream(new FileInputStream(requestFile));
        ObjectInput input = new ObjectInputStream(buffer);
        Object result = input.readObject();
        input.close();
        File resultFile = new File(requestFile);
        resultFile.delete();
        return result;
    }

}
