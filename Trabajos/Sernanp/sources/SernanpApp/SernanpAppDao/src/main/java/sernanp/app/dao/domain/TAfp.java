package sernanp.app.dao.domain;

import java.util.Date;

public class TAfp extends TAfpKey {
    private String var_cod_afp;

    private String var_nombre_afp;

    private Integer int_id_estado;

    private Date tsp_fecha_registro;

    public String getVar_cod_afp() {
        return var_cod_afp;
    }

    public void setVar_cod_afp(String var_cod_afp) {
        this.var_cod_afp = var_cod_afp;
    }

    public String getVar_nombre_afp() {
        return var_nombre_afp;
    }

    public void setVar_nombre_afp(String var_nombre_afp) {
        this.var_nombre_afp = var_nombre_afp;
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