package my_format;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import my_reader.ReadException;
import my_reader.ReadFile;
import my_writer.WriteException;
import my_writer.WriteFile;
import org.junit.Before;
import org.junit.Test;
/**
 * this is test of the main service class
 */
public class TestMyFormatter {
    private MyFormatter red;
    private ReadFile reader1, reader2;
    private WriteFile writer1 ,writer2;

    @Before
    public void setUp() throws ReadException, FormatterException, WriteException {

            this.red = new MyFormatter();

    }

    @Test(expected = FormatterException.class)
    public void testFormatterException() throws FormatterException {
        this.red.redactor(this.reader1, this.writer2);

        fail();

    }


    @Test
    public void testReadFile() throws WriteException, ReadException, FormatterException {
        String path = "/home/a/IdeaProjects/ParserCode/";
        String name = "test1.txt";
        String name1 = "example1.txt";
        this.writer1 = new WriteFile(path, name);
        String s = "package abs;import abs.df;public class TestIt{public static void main(){}}";
        this.writer1.write(s);

        this.writer1.close();

        this.reader1 = new ReadFile(path, name);
        this.writer2 = new WriteFile(path, name1);

        this.red.redactor(this.reader1, this.writer2);


        this.reader1.close();
        this.writer2.close();

        this.reader2 = new ReadFile(path, name1);


        int c = this.reader2.read();

        String ss = "";

        while (c != -1) {
            //c = this.input1.read();
            ss += (char) c;
            c = this.reader2.read();
        }

        this.reader2.close();

        String s1 = "package abs;\nimport abs.df;\npublic class TestIt {\n\tpublic static void main() {\n\t}\n}\n";

        assertEquals(s1, ss);

    }

}
