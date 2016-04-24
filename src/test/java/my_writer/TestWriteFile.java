package my_writer;

import my_format.FormaterException;
import my_format.Redactor;
import my_reader.ReadException;
import my_reader.ReadFile;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * this is junit test for WriteFile class
 */
public class TestWriteFile {
    private ReadFile reader1, reader2;
    private WriteFile writer1, writer2;

    @Before
    public void setUp() throws ReadException, FormaterException, WriteException {


    }


    @Test(expected = WriteException.class)
    public void testWriteExepction() throws WriteException {
        this.writer1 = new WriteFile("","");

        fail();
    }

    @Test
    public void testWriteFile() throws WriteException, ReadException, FormaterException {
        String path = "/home/a/IdeaProjects/ParserCode/";
        String name = "test2.txt";
        this.writer1 = new WriteFile(path, name);
        String s = "abc";
        this.writer1.write(s);

        this.writer1.close();


        this.reader1 = new ReadFile(path, name);


        int c = this.reader1.read();

        String ss = "";

        while (c != -1) {
            //c = this.input1.read();
            ss += (char) c;
            c = this.reader1.read();
        }

        this.reader1.close();

        String s1 = "abc";

        assertEquals(s1, ss);

    }
}
