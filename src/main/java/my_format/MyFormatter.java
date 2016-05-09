package my_format;

import my_reader.ReadException;
import my_reader.ReadFile;
import my_writer.WriteException;
import my_writer.WriteFile;

/**
 * This is the main class of the project
 */
public class MyFormatter {

    static String path = MyFormatter. class.getResource("").toString();
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
            output1.write("import java.io.*;public class MyNew{public static void main(String[] args){}}");
            output1.close();

            WriteFile output = new WriteFile(path, name1);
            ReadFile input = new ReadFile(path, name);

            Redactor red = new Redactor();

            red.redactor(input, output);

            int c = input.read();
            String s = "";
            //input.close();
            while (c != -1) {
                s += (char) c;
                c = input.read();
            }

            System.out.println(s);
            //redactor(input, output);


            input.close();
            output.close();
        } catch (WriteException e) {
            throw new FormatterException("This is exception in main class", e);
        } catch (ReadException e) {
            throw new FormatterException("This is exception in main class", e);
        }


    }
}