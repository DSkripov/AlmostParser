package reader;

import static org.junit.Assert.assertEquals;

import reader.ReadException;
import reader.ReadString;
import writer.WriteException;
import writer.WriteString;
import org.junit.Before;
import org.junit.Test;

/**
 * This is junit test class for ReadingString class
 */
public class TestReadString {
    private ReadString input1;
    private WriteString output1;

    private String path;
    private String name;

    @Before
    public void setUp() throws ReadException, WriteException {
        //this.name = "test.txt";
        //this.path = "/home/a/IdeaProjects/ParserCode/";

        //this.input1 = new ReadString();
    }

    @Test
    public void testMyReader() throws WriteException, ReadException {
        String s1 = "abc1";
        this.input1 = new ReadString(s1);
        //this.output1.write("abc");
        //output1.close();

        int c = this.input1.read();

        String s = "";

        while (c != -1) {
            //c = this.input1.read();
            s += (char) c;
            c = this.input1.read();
        }

        assertEquals("abc1", s);

        input1.close();

    }
}
