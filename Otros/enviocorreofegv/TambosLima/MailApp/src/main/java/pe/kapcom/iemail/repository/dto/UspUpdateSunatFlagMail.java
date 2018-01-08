package pe.kapcom.iemail.repository.dto;

import java.io.Serializable;

/**
 * Created by JRaffo on 29/10/16.
 */
public class UspUpdateSunatFlagMail implements Serializable {

    private String p_tipdoc ;
    private String p_nrodoc ;
    private String p_status;

    public String getP_tipdoc() {
        return p_tipdoc;
    }

    public void setP_tipdoc(String p_tipdoc) {
        this.p_tipdoc = p_tipdoc;
    }

    public String getP_nrodoc() {
        return p_nrodoc;
    }

    public void setP_nrodoc(String p_nrodoc) {
        this.p_nrodoc = p_nrodoc;
    }

    public String getP_status() {
        return p_status;
    }

    public void setP_status(String p_status) {
        this.p_status = p_status;
    }
}
