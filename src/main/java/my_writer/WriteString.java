package my_writer;

import java.io.*;

/**
 * this is string writer
 */
public class WriteString implements IWrite {

    private StringWriter stringWriter;

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
    public void write(String strS) {
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
            throw new WriteException("This is in writeString class", e);
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
