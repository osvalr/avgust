package sernanp.app.dao.domain;

import java.util.Date;

public class TAnioPlanilla extends TAnioPlanillaKey {
    private Integer int_anio;

    private String var_cod_ejecutor;

    private String var_nombre_anio;

    private Date dte_fecha_inicio;

    private Date dte_fecha_fin;

    private Integer int_id_estado_vigencia;

    private Integer int_id_estado;

    private Date tsp_fecha_registro;

    public Integer getInt_anio() {
        return int_anio;
    }

    public void setInt_anio(Integer int_anio) {
        this.int_anio = int_anio;
    }

    public String getVar_cod_ejecutor() {
        return var_cod_ejecutor;
    }

    public void setVar_cod_ejecutor(String var_cod_ejecutor) {
        this.var_cod_ejecutor = var_cod_ejecutor;
    }

    public String getVar_nombre_anio() {
        return var_nombre_anio;
    }

    public void setVar_nombre_anio(String var_nombre_anio) {
        this.var_nombre_anio = var_nombre_anio;
    }

    public Date getDte_fecha_inicio() {
        return dte_fecha_inicio;
    }

    public void setDte_fecha_inicio(Date dte_fecha_inicio) {
        this.dte_fecha_inicio = dte_fecha_inicio;
    }

    public Date getDte_fecha_fin() {
        return dte_fecha_fin;
    }

    public void setDte_fecha_fin(Date dte_fecha_fin) {
        this.dte_fecha_fin = dte_fecha_fin;
    }

    public Integer getInt_id_estado_vigencia() {
        return int_id_estado_vigencia;
    }

    public void setInt_id_estado_vigencia(Integer int_id_estado_vigencia) {
        this.int_id_estado_vigencia = int_id_estado_vigencia;
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