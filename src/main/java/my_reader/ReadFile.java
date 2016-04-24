package my_reader;

import java.io.*;

/**
 * This is reader class
 */

public class ReadFile implements IRead {

    private InputStream fileStream;
    //private InputStream in;
    private Reader fileReader;
    private BufferedReader reader;
    private String path;
    private String name;
    /**
     *
     * @param pathS
     * @throws ReadException
     */
    public ReadFile(String pathS, String nameS) throws ReadException {
        this.name = nameS;
        this.path = pathS;

        try {
            File file = new File(path, name);
            file.setReadable(true);
            //file.setWritable(true);
            this.fileStream = new FileInputStream(file);
            this.fileReader = new InputStreamReader(fileStream, "utf-8");
            //this.reader = new BufferedReader(fileReader);
        } catch (FileNotFoundException e) {
            throw new ReadException();
        } catch (UnsupportedEncodingException e) {
            throw new ReadException();
        } catch (NullPointerException e) {
            throw new ReadException();
        }

    }

    /**
     * @return
     * @throws ReadException
     */
    public int read() throws ReadException {

        //this.fileStream = new FileInputStream(new File(path));
        try {
            return this.fileReader.read();
            //return this.fileStream.read();
        } catch (IOException e) {
            throw new ReadException();
        }
    }

    public void close() throws ReadException {
        try {
            fileReader.close();
            //fileStream.close();
        } catch (IOException e) {
            throw new ReadException();
        }
    }

}