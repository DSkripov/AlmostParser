package writer;

import org.junit.Before;
import org.junit.Test;
import writer.WriteException;
import writer.WriteString;

import static org.junit.Assert.assertEquals;

/**
 * this is junit test for WriteString class (while is empty)
 */
public class TestWriteString {
    //ByteArrayOutputStream out;
    WriteString write;

    @Before
    public void setUp() throws WriteException {
        this.write = new WriteString();
        //out = new ByteArrayOutputStream();
        //System.setOut(new PrintStream(out));
    }


    @Test
    public void testWriteString() throws WriteException {
        this.write.write("abc");
        assertEquals("abc", this.write.toString());
        this.write.close();
    }

}
