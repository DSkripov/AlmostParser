package my_writer;

/**
 * This is exception for reader
 */
public class WriteException extends Exception {

    private  Exception _hidden;

    /**
     *
     * @param str is message about exception
     */
    public WriteException(final String str)
    {
        super(str);
    }

    /**
     *
     * @param str is message about exception
     * @param e is exception
     */
    public WriteException(final String str, final Exception e)
    {
        super(str);
        _hidden = e;
    }
}
