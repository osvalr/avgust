package pe.com.acme.util;

/**
 * Created by JRaffo on 23/11/16.
 */
public class AcmeException extends Exception {

    public AcmeException() {
    }

    public AcmeException(String message) {
        super(message);
    }

    public AcmeException(String message, Throwable cause) {
        super(message, cause);
    }

    public AcmeException(Throwable cause) {
        super(cause);
    }

    public AcmeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
