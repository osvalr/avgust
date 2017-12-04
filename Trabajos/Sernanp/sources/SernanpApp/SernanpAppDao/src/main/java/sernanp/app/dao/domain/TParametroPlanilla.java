package sernanp.app.dao.domain;

import java.util.Date;

public class TParametroPlanilla extends TParametroPlanillaKey {
    private String var_descrip_parametro;

    private Integer int_tipo_parametro;

    private Integer int_id_estado;

    private Date tsp_fecha_registro;

    public String getVar_descrip_parametro() {
        return var_descrip_parametro;
    }

    public void setVar_descrip_parametro(String var_descrip_parametro) {
        this.var_descrip_parametro = var_descrip_parametro;
    }

    public Integer getInt_tipo_parametro() {
        return int_tipo_parametro;
    }

    public void setInt_tipo_parametro(Integer int_tipo_parametro) {
        this.int_tipo_parametro = int_tipo_parametro;
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