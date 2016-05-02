package my_reader;

/**
 * This is exception for reader
 */
public class ReadException extends Exception {

    private  Exception _hidden;

    /**
     *
     * @param str
     */
    public ReadException(String str)
    {
        super(str);
    }

    /**
     *
     * @param str
     * @param e
     */
    public ReadException(String str, Exception e)
    {
        super(str);
        _hidden = e;
    }
}
