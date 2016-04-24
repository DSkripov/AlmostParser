package my_reader;

import static org.junit.Assert.assertEquals;

import my_reader.ReadException;
import my_reader.ReadFile;
import my_writer.WriteException;
import my_writer.WriteFile;
import my_writer.WriteString;
import org.junit.Before;
import org.junit.Test;
import org.junit.matchers.StringContains;
import org.xml.sax.SAXException;

import java.io.IOException;

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
