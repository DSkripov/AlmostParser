package reader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

/**
 * This is reader class for reading from string
 */
public class ReadString implements IRead {

    private Reader stringReader;
    private String str;
    /**
     *
     */
    static final Logger log = LoggerFactory.getLogger(ReadString.class);
    /**
     *
     * @param strS
     * @throws ReadException
     */
    public ReadString(final String strS) throws ReadException {

            this.str = strS;
            this.stringReader = new StringReader(this.str);


    }

    /**
     * @return int read element of input stream
     * @throws ReadException
     */
    public int read() throws ReadException {

        try {
            return this.stringReader.read();
        } catch (IOException e) {
            log.error("This is IOException in ReadString", new ReadException("Can not read from this string", e));
            throw new ReadException("Can not read from this string", e);
        }
    }

    /**
     *
     * @throws ReadException
     */
    public void close() throws ReadException {
        try {
            stringReader.close();
        } catch (IOException e) {
            log.error("This is IOException in ReadString", new ReadException("Can not close this string reader", e));
            throw new ReadException("Can not close this string reader", e);
        }
    }

}
