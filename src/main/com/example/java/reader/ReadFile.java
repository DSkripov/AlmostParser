package reader;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

/**
 * This is reader class for reading from file
 */

public class ReadFile implements IRead {

    private InputStream fileStream;
    private Reader fileReader;
    private String path;
    private String name;
    /**
     *
     */
    static final Logger log = LoggerFactory.getLogger(ReadFile.class);
    /**
     *
     * @param pathS is path to file
     * @throws ReadException
     */
    public ReadFile(final String pathS, final String nameS) throws ReadException {
        this.name = nameS;
        this.path = pathS;

        try {
            File file = new File(path.concat(name));
            this.fileStream = new FileInputStream(file);
            this.fileReader = new InputStreamReader(fileStream, "utf-8");
        } catch (IOException e) {
            log.error("This is IOException in ReadFile", new ReadException("Can not use file for reading", e));
            throw new ReadException("Can not use file for reading", e);
        }

    }

    /**
     * @return int variable
     * @throws ReadException
     */
    public int read() throws ReadException {

        try {
            return this.fileReader.read();
        } catch (IOException e) {
            log.error("This is IOException in ReadFile", new ReadException("Can not read from this file", e));
            throw new ReadException("Can not read from this file", e);
        }
    }

    /**
     *
     * @throws ReadException
     */
    public void close() throws ReadException {
        try {
            fileReader.close();
        } catch (IOException e) {
            log.info("This is IOException in ReadFile", new ReadException("Can not close this file", e));
            throw new ReadException("Can not close this file", e);
        }
    }

}