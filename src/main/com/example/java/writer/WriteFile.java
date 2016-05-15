package writer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

/**
 * This is reader class
 */

public class WriteFile implements IWrite {

    private OutputStream fileStream;
    private Writer fileWriter;
    private String path;
    private String name;
    /**
     *
     */
    static final Logger log = LoggerFactory.getLogger(WriteFile.class);
    /**
     *
     * @param pathS is path to File
     * @param nameS is name of File
     * @throws WriteException
     */
    public WriteFile(final String pathS, final String nameS) throws WriteException {
        this.name = nameS;
        this.path = pathS;

        try {
            File file = new File(path, name);
            this.fileStream = new FileOutputStream(file);
            this.fileWriter = new OutputStreamWriter(fileStream, "utf-8");
        } catch (IOException e) {
            log.info("This is IOException in ReadFile", new WriteException("Can not use file for writing", e));
            throw new WriteException("Can not use file for writing", e);
        }

    }

    /**
     *
     * @param str is output string
     * @throws WriteException
     */
    public void write(final String str) throws WriteException {
        try {
            this.fileWriter.write(str);
        } catch (IOException e) {
            log.error("This is IOException in ReadFile", new WriteException("Can not write in this file", e));
            throw new WriteException("Can not write in this file", e);
        }
    }

    /**
     *
     * @throws WriteException
     */
    public void close() throws WriteException {
        try {
            fileWriter.close();
        } catch (IOException e) {
            log.error("This is IOException in WriteFile", new WriteException("Can not close this file which we used for writing", e));
            throw new WriteException("Can not close this file which we used for writing", e);
        }
    }


}