package writer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

/**
 * This is string writer
 */
public class WriteString implements IWrite {

    private StringWriter stringWriter;
    /**
     *
     */
    static final Logger log = LoggerFactory.getLogger(WriteString.class);
    /**
     * @throws WriteException
     */
    public WriteString() throws WriteException {

            this.stringWriter = new StringWriter();

    }

    /**
     *
     * @param strS this is message
     * @throws WriteException
     */
    public void write(final String strS) {
            log.error("Write to WriteString");
            this.stringWriter.write(strS);
    }

    /**
     *
     * @throws WriteException
     */
    public void close() throws WriteException {
        try {
            this.stringWriter.close();
        } catch (IOException e) {
            log.error("This is IOException in WriteString", new WriteException("Can not write to this string writer", e));
            throw new WriteException("Can not write to this string writer", e);
        }
    }

    /**
     *
     * @return String that is in StringWriter
     */
    public String toString() {
       return this.stringWriter.toString();
    }
}
