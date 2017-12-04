package sernanp.app.dao.domain;

import java.util.Date;

public class TEtapaProcesoSeleccion extends TEtapaProcesoSeleccionKey {
    private String var_nombre_etapa;

    private Integer int_id_estado;

    private Date tsp_fecha_registro;

    public String getVar_nombre_etapa() {
        return var_nombre_etapa;
    }

    public void setVar_nombre_etapa(String var_nombre_etapa) {
        this.var_nombre_etapa = var_nombre_etapa;
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