package my_format;

/**
 * This is exception for MyFormatter and Redactor
 */
public class FormatterException extends Exception {

    private Exception _hidden;

    /**
     *
     * @param str
     */
    public FormatterException(String str)
    {
        super(str);
    }

    /**
     *
     * @param str
     * @param e
     */
    public FormatterException(String str, Exception e)
    {
        super(str);
        _hidden = e;
    }
}
