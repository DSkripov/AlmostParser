import my_format.MyFormatter;
import my_format.FormatterException;
import my_reader.ReadException;
import my_reader.ReadFile;
import my_writer.WriteException;
import my_writer.WriteFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * This is the main class of the project
 */
public class BootStrap {
    final static Logger log = LoggerFactory.getLogger(BootStrap.class);
    static String path = "/home/a/IdeaProjects/ParserCode/";//BootStrap. class.getResource("").toString();
            //"/home/a/IdeaProjects/ParserCode/";
    static String name = "test.txt";
    static String name1 = "example.txt";

    /**
     * @param args is parameters of command line
     * @throws FormatterException
     */
    public static void main(String[] args) throws FormatterException {
        try {

            WriteFile output1 = new WriteFile(path, name);
            log.info("Open file stream for writing example to file");
            output1.write("import java.io.*;public class MyNew{public static void main(String[] args){}}");
            log.info("Writing in file");
            output1.close();
            log.info("Close first file stream");

            WriteFile output = new WriteFile(path, name1);
            ReadFile input = new ReadFile(path, name);
            MyFormatter red = new MyFormatter();
            red.redactor(input, output);

            int c = input.read();
            log.info("We read character from file input stream");
            String s = "";
            while (c != -1) {
                s += (char) c;
                c = input.read();
                log.info("We read character from file input stream");
            }

            System.out.println(s);
            log.info("Writing string at screen");

            input.close();
            output.close();
        } catch (WriteException e) {
            log.error("This is WriteException in BootStrap", e);
            throw new FormatterException("This is exception in main class", e);
        } catch (ReadException e) {
            log.error("This is ReadException in BootStrap", e);
            throw new FormatterException("This is exception in main class", e);
        }


    }
}