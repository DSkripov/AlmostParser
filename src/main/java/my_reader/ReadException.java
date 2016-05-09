package my_reader;

/**
 * This is exception for reader
 */
public class ReadException extends Exception {

    private  Exception _hidden;

    /**
     *
     * @param str is message about exception
     */
    public ReadException(final String str)
    {
        super(str);
    }

    /**
     *
     * @param str is message about exception
     * @param e is exception
     */
    public ReadException(final String str, final Exception e)
    {
        super(str);
        _hidden = e;
    }
}
