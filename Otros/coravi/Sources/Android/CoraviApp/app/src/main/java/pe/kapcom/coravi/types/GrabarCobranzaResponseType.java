package pe.kapcom.coravi.types;

/**
 * Created by JRaffo on 15/03/17.
 */

public class GrabarCobranzaResponseType {

    private boolean success;
    private String message;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
