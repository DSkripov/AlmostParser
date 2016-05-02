package my_writer;

/**
 * This is exception for reader
 */
public class WriteException extends Exception {

    private  Exception _hidden;

    /**
     *
     * @param str
     */
    public WriteException(String str)
    {
        super(str);
    }

    /**
     *
     * @param str
     * @param e
     */
    public WriteException(String str, Exception e)
    {
        super(str);
        _hidden = e;
    }
}
