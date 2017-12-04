package sernanp.app.dao.domain;

import java.util.Date;

public class TDireccionDomicilioHistorial extends TDireccionDomicilioHistorialKey {
    private Integer idpersonanatural;

    private String var_direccion_domiciliaria;

    private Integer int_id_ubigeo;

    private Integer int_id_estado;

    private Date tsp_fecha_registro;

    public Integer getIdpersonanatural() {
        return idpersonanatural;
    }

    public void setIdpersonanatural(Integer idpersonanatural) {
        this.idpersonanatural = idpersonanatural;
    }

    public String getVar_direccion_domiciliaria() {
        return var_direccion_domiciliaria;
    }

    public void setVar_direccion_domiciliaria(String var_direccion_domiciliaria) {
        this.var_direccion_domiciliaria = var_direccion_domiciliaria;
    }

    public Integer getInt_id_ubigeo() {
        return int_id_ubigeo;
    }

    public void setInt_id_ubigeo(Integer int_id_ubigeo) {
        this.int_id_ubigeo = int_id_ubigeo;
    }

    public Integer getInt_id_estado() {
        return int_id_estado;
    }

    public void setInt_id_estado(Integer int_id_estado) {
        this.int_id_estado = int_id_estado;
    }

    public Date getTsp_fecha_registro() {
        return tsp_fecha_registro;
    }

    public void setTsp_fecha_registro(Date tsp_fecha_registro) {
        this.tsp_fecha_registro = tsp_fecha_registro;
    }
}