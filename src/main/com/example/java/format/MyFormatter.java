package format;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reader.IRead;
import reader.ReadException;
import writer.IWrite;
import writer.WriteException;

import java.util.Stack;
import java.util.Properties;
/**
 * This is the main service class
 */
public class MyFormatter {
    /**
     *
     */
    static final Logger log = LoggerFactory.getLogger(MyFormatter.class);
    /**
     *
     * @param input is input stream
     * @param output is output stream
     * @throws FormatterException
     */
    public void redactor(final IRead input, final IWrite output) throws FormatterException {
        Properties property = new Properties();
        try {
            int c;
            int it = 0;
            Stack stack = new Stack();
            log.info("Create new stack of '{', '}'");
            String s = "";

            while ((c = input.read()) != -1) {
                log.info("Write character to output stream");
                switch ((char) c) {
                    case ';':
                        output.write(s);
                        output.write(";");
                        output.write(property.getProperty("db.nl"));
                        if (it > 0) {
                            for (int i = 0; i < it; i++) {
                                s += property.getProperty("db.tab");
                            }
                        }
                        s = "";
                        //output.write(s);
                        break;
                    case '{' :
                        output.write(s);
                        s = "";
                        //ch = Character((char) c);
                        stack.push((char) c);
                        log.info("Push '{' to stack");
                        it++;

                        if (it > 0) {
                            for (int i = 0; i < it; i++) {
                                s += property.getProperty("db.tab");
                            }
                        }

                        output.write(" {\n"); //need tabulation
                        break;
                    case '}' :
                        s = "";

                        if (it > 0) {
                            for (int i = 1; i < it; i++) {
                                output.write(property.getProperty("db.tab"));
                            }
                        }

                        if (stack.isEmpty() || (it < 0)) {
                            log.error("This is FormatterException in MyFormatter", new FormatterException("Stack is empty or it less then 0"));
                            throw new FormatterException("Stack is empty or it less then 0");
                        }
                        stack.pop();
                        log.info("Pop '{' from stack");
                        it--;
                        output.write("}");
                        output.write(property.getProperty("db.nl"));
                    default :
                        s += (char) c;
                        break;
                }

            }
        } catch (ReadException e) {
            log.error("This is ReadException in MyFormatter", e);
            throw new FormatterException("Can not use input stream for reading", e);
        } catch (WriteException e) {
            log.error("This is WriteException in MyFormatter", e);
            throw new FormatterException("Can not use output stream for writing", e);
        } catch (NullPointerException e) {
            log.error("This is NullPointerException in MyFormatter", e);
            throw new FormatterException("There are null input or output", e);
        }
    }
}
