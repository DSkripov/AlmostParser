package reader;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import reader.ReadException;
import reader.ReadFile;
import writer.WriteException;
import writer.WriteFile;
import org.junit.Before;
import org.junit.Test;

/**
 * This is junit test class for ReadFile class
 */
public class TestReadFile {
    private ReadFile input1;
    private WriteFile output1;

    private String path;
    private String name;

    @Before
    public void setUp() throws ReadException, WriteException {
        this.name = "test0.txt";
        this.path = "/home/a/IdeaProjects/ParserCode/";
        this.output1 = new WriteFile(path, name);
        this.input1 = new ReadFile(path, name);
    }

    @Test
    public void testMyReader() throws WriteException, ReadException {
            //this.output1 = new WriteFile(path, name);
            this.output1.write("abc");
            output1.close();

            int c = this.input1.read();

            String s = "";

            while (c != -1) {
                //c = this.input1.read();
                s += (char) c;
                c = this.input1.read();
            }

            assertEquals("abc", s);

        input1.close();

    }

    @Test(expected = ReadException.class)
    public void testReadException() throws ReadException {
        this.name = "ddd.txt";
        this.path = "/home/a/IdeaProjects/ParserCode/";

        this.input1 = new ReadFile(path, name);

        fail();
    }
}
