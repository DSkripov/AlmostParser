import format.MyFormatter;
import format.FormatterException;
import reader.ReadException;
import reader.ReadFile;
import writer.WriteException;
import writer.WriteFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * This is the main class of the project
 */
public final class BootStrap {
    /**
     * This is logger for exceptions and some moments in execution
     */
    static final Logger log = LoggerFactory.getLogger(BootStrap.class);
    /**
     * This is the path to test file
     */
    static String path = "/home/a/IdeaProjects/ParserCode/";
    /**
     * This is the name of test file
     */
    static String name = "test.txt";
    /**
     * This is the name of example file which show us how works MyFormatter
     */
    static String name1 = "example.txt";

    private BootStrap() {

    }

    /**
     * @param args is parameters of command line
     * @throws FormatterException
     */
    public static void main(final String[] args) throws FormatterException {
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
        } catch (ReadException e) {
            log.error("This is ReadException in BootStrap", e);
        } catch (FormatterException e) {
            log.error("This is FormatterException in BootStrap", e);
        }


    }
}