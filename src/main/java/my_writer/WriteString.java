package my_writer;

import java.io.*;

/**
 * this is string writer
 */
public class WriteString implements IWrite {

    private OutputStream stringStream;
    private PrintStream printStream;
    //private InputStream in;
    private Writer stringWriter;
    private PrintWriter printWriter;
    private String str;

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
    public void write(final String strS) throws WriteException {

        //this.fileStream = new FileInputStream(new File(path));
        try {
            this.stringWriter.write(strS);
        } catch (IOException e) {
            throw new WriteException("This is in writeString class", e);
        }
    }

    /**
     *
     * @throws WriteException
     */
    public void close() throws WriteException {
        try {
            stringWriter.close();
        } catch (IOException e) {
            throw new WriteException("This is in writeString class", e);
        }
    }

}
