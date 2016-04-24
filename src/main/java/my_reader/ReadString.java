package my_reader;

import java.io.*;

/**
 * Created by a on 23.04.16.
 */
public class ReadString implements IRead {

    private InputStream stringStream;
    //private InputStream in;
    private Reader stringReader;
    private BufferedReader reader;
    private String str;

    /**
     *
     * @param strS
     * @throws ReadException
     */
    public ReadString(String strS) throws ReadException {

            this.str = strS;

            //this.stringStream = new StringBufferInputStream();
            this.stringReader = new StringReader(this.str);
            //this.reader = new BufferedReader(fileReader);
         /*catch (FileNotFoundException e) {
            throw new ReadException();
        } catch (UnsupportedEncodingException e) {
            throw new ReadException();
        }*/

    }

    /**
     * @return
     * @throws ReadException
     */
    public int read() throws ReadException {

        //this.fileStream = new FileInputStream(new File(path));
        try {
            return this.stringReader.read();
        } catch (IOException e) {
            throw new ReadException();
        }
    }

    public void close() throws ReadException {
        try {
            stringReader.close();
        } catch (IOException e) {
            throw new ReadException();
        }
    }

}
