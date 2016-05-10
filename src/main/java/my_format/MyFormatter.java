package my_format;

import my_reader.IRead;
import my_reader.ReadException;
import my_writer.IWrite;
import my_writer.WriteException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Stack;

/**
 * This is the main service class
 */
public class MyFormatter {

    /**
     *
     * @param input is input stream
     * @param output is output stream
     * @throws FormatterException
     */
    public void redactor(final IRead input, final IWrite output) throws FormatterException {

        try {
            int c;
            int it = 0;
            Stack stack = new Stack();

            String s = "";

            while ((c = input.read()) != -1) {
                switch ((char) c) {
                    case ';':
                        //        if it
                        output.write(s);
                        output.write(";\n");
                        //s = "";
                        if (it > 0) {
                            for (int i = 0; i < it; i++) {
                                s += "\t";
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
                        it++;

                        if (it > 0) {
                            for (int i = 0; i < it; i++) {
                                s += "\t";
                            }
                        }

                        output.write(" {\n"); //need tabulation
                        break;
                    case '}' :
                        s = "";

                        if (it > 0) {
                            for (int i = 1; i < it; i++) {
                                output.write("\t");
                            }
                        }

                        if (stack.isEmpty() || (it < 0)) {
                            throw new FormatterException("Stack is empty or it less then 0");
                        }
                        stack.pop();
                        it--;
                        output.write("}\n");
                    default :
                        //s = "";
                        //s += (char) c;

                        s += (char) c;

                        //output.write(s);
                        break;
                }

            }
        } catch (ReadException e) {
            throw new FormatterException("This is exception in redactor class", e);
        } catch (WriteException e) {
            throw new FormatterException("This is exception in redactor class", e);
        } catch (NullPointerException e) {
            throw new FormatterException("This is exception in redactor class", e);
        }
    }
}
