package sernanp.app.dao.domain;

import java.util.Date;

public class TConfiguracionFactorEvaluacion extends TConfiguracionFactorEvaluacionKey {
    private String var_descrip_configuracion;

    private Integer int_id_estado;

    private Date tsp_fecha_registro;

    public String getVar_descrip_configuracion() {
        return var_descrip_configuracion;
    }

    public void setVar_descrip_configuracion(String var_descrip_configuracion) {
        this.var_descrip_configuracion = var_descrip_configuracion;
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