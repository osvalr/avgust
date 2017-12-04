package sernanp.app.dao.domain;

import java.util.Date;

public class TExpedientePersonal extends TExpedientePersonalKey {
    private Integer idpersonanatural;

    private String var_num_expediente;

    private Date tsp_fecha_registro;

    private Integer int_id_estado;

    private String var_num_file;

    private String var_num_caja;

    public Integer getIdpersonanatural() {
        return idpersonanatural;
    }

    public void setIdpersonanatural(Integer idpersonanatural) {
        this.idpersonanatural = idpersonanatural;
    }

    public String getVar_num_expediente() {
        return var_num_expediente;
    }

    public void setVar_num_expediente(String var_num_expediente) {
        this.var_num_expediente = var_num_expediente;
    }

    public Date getTsp_fecha_registro() {
        return tsp_fecha_registro;
    }

    public void setTsp_fecha_registro(Date tsp_fecha_registro) {
        this.tsp_fecha_registro = tsp_fecha_registro;
    }

    public Integer getInt_id_estado() {
        return int_id_estado;
    }

    public void setInt_id_estado(Integer int_id_estado) {
        this.int_id_estado = int_id_estado;
    }

    public String getVar_num_file() {
        return var_num_file;
    }

    public void setVar_num_file(String var_num_file) {
        this.var_num_file = var_num_file;
    }

    public String getVar_num_caja() {
        return var_num_caja;
    }

    public void setVar_num_caja(String var_num_caja) {
        this.var_num_caja = var_num_caja;
    }
}