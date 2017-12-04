#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};

/**
 * Created by JRaffo on 9/10/15.
 */
public abstract class DataTranferObject {

    private Integer id_user;
    private String fec_reg;
    private Integer id_user_mod;
    private String fec_mod;
    private Integer id_estado;

    public Integer getId_user() {
        return id_user;
    }

    public void setId_user(Integer id_user) {
        this.id_user = id_user;
    }

    public String getFec_reg() {
        return fec_reg;
    }

    public void setFec_reg(String fec_reg) {
        this.fec_reg = fec_reg;
    }

    public Integer getId_user_mod() {
        return id_user_mod;
    }

    public void setId_user_mod(Integer id_user_mod) {
        this.id_user_mod = id_user_mod;
    }

    public String getFec_mod() {
        return fec_mod;
    }

    public void setFec_mod(String fec_mod) {
        this.fec_mod = fec_mod;
    }

    public Integer getId_estado() {
        return id_estado;
    }

    public void setId_estado(Integer id_estado) {
        this.id_estado = id_estado;
    }
}
