package my_format;

import my_reader.ReadException;
import my_reader.ReadFile;
import my_writer.WriteException;
import my_writer.WriteFile;

import java.io.File;
import java.io.IOException;
import java.util.Stack;

/**
 * This is the main class of the project
 */
public class MyFormater {

    //static String strR = "/home/a/Рабочий стол.test.txt";
    //static String strW = "example.txt";
    static String path = "/home/a/IdeaProjects/ParserCode/";
    static String name = "test.txt";
    static String name1 = "example.txt";

    /**
     *
     * @param args
     * @throws FormaterException
     */
    public static void main(String[] args) throws FormaterException {
        try {
            //File file = new File(path, name);
            //MyFormater.class.getResource("test.txt").getFile();
            //file.setReadable(true);
            WriteFile output1 = new WriteFile(path, name);
            output1.write("import java.io.*;public class MyNew{public static void main(String[] args){}}");
            output1.close();

            WriteFile output = new WriteFile(path, name1);
            ReadFile input = new ReadFile(path, name);

            Redactor red = new Redactor();

            red.redactor(input, output);

            int c = input.read();
            String s = "";
            //input.close();
            while ( c != -1) {
                s += (char) c;
                c = input.read();
            }

            System.out.println(s);
            //redactor(input, output);


            input.close();
            output.close();
        } catch (WriteException e) {
            throw new FormaterException();
        } catch (ReadException e) {
            throw new FormaterException();
        }


    }
/*
    public static void redactor(ReadFile input, WriteFile output) throws FormaterException {

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
        }
    }
*/
}
