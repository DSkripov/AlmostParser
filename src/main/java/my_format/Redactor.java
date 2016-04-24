package my_format;

import my_reader.IRead;
import my_reader.ReadException;
import my_reader.ReadFile;
import my_writer.IWrite;
import my_writer.WriteException;
import my_writer.WriteFile;

import java.util.Stack;

/**
 * This is the main service class
 */
public class Redactor {

    public void redactor(IRead input, IWrite output) throws FormaterException {

        try {
            int c;
            //int it = 0;
            int iter = 0;
            //Character ch = new Character();
            Stack stack = new Stack();

            String s = "";

            while ((c = input.read()) != -1) {
                //  it++;
                switch ((char) c) {
                    case ';':
                        //        if it
                        output.write(s);
                        output.write(";\n");
                        //s = "";
                        if (iter > 0) {
                            for (int i = 0; i < iter; i++) {
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
                        iter++;

                        if (iter > 0) {
                            for (int i = 0; i < iter; i++) {
                                s += "\t";
                            }
                        }

                        output.write(" {\n"); //need tabulation
                        break;
                    case '}' :
                        s = "";

                        if (iter > 0) {
                            for (int i = 1; i < iter; i++) {
                                output.write("\t");
                            }
                        }

                        if (stack.isEmpty() || (iter < 0)) {
                            throw new FormaterException();
                        }
                        stack.pop();
                        iter--;
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
            throw new FormaterException();
        } catch (WriteException e) {
            throw new FormaterException();
        } catch (NullPointerException e) {
            throw new FormaterException();
        }
    }
}
