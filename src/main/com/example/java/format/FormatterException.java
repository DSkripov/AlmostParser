package format;

/**
 * This is exception for BootStrap and MyFormatter
 */
public class FormatterException extends Exception {

    private Exception _hidden;

    /**
     *
     * @param str is message about exception
     */
    public FormatterException(final String str)
    {
        super(str);
    }

    /**
     *
     * @param str is message about exception
     * @param e is exception
     */
    public FormatterException(final String str, final Exception e)
    {
        super(str);
        _hidden = e;
    }
}
