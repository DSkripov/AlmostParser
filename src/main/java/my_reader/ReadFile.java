package my_reader;


import java.io.*;

/**
 * This is reader class
 */

public class ReadFile implements IRead {

    private InputStream fileStream;
    private Reader fileReader;
    private String path;
    private String name;
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
        } catch (FileNotFoundException e) {
            throw new ReadException("This is in readFile class", e);
        } catch (UnsupportedEncodingException e) {
            throw new ReadException("This is in readFile class", e);
        } catch (NullPointerException e) {
            throw new ReadException("This is in readFile class", e);
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
            throw new ReadException("This is in readFile class", e);
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
            throw new ReadException("This is in readFile class", e);
        }
    }

}