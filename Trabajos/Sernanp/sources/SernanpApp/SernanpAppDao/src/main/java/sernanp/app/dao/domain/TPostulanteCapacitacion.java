package sernanp.app.dao.domain;

import java.util.Date;

public class TPostulanteCapacitacion extends TPostulanteCapacitacionKey {
    private Integer int_id_postulante;

    private Integer int_id_institucion;

    private String var_descrip_programa;

    private Integer int_cant_anio;

    private Integer int_cant_meses;

    private Integer int_cant_dias;

    private Date dte_fecha_inicio;

    private Date dte_fecha_fin;

    private Integer int_id_tipo_nivel;

    private Integer int_id_estado;

    private Date tsp_fecha_registro;

    public Integer getInt_id_postulante() {
        return int_id_postulante;
    }

    public void setInt_id_postulante(Integer int_id_postulante) {
        this.int_id_postulante = int_id_postulante;
    }

    public Integer getInt_id_institucion() {
        return int_id_institucion;
    }

    public void setInt_id_institucion(Integer int_id_institucion) {
        this.int_id_institucion = int_id_institucion;
    }

    public String getVar_descrip_programa() {
        return var_descrip_programa;
    }

    public void setVar_descrip_programa(String var_descrip_programa) {
        this.var_descrip_programa = var_descrip_programa;
    }

    public Integer getInt_cant_anio() {
        return int_cant_anio;
    }

    public void setInt_cant_anio(Integer int_cant_anio) {
        this.int_cant_anio = int_cant_anio;
    }

    public Integer getInt_cant_meses() {
        return int_cant_meses;
    }

    public void setInt_cant_meses(Integer int_cant_meses) {
        this.int_cant_meses = int_cant_meses;
    }

    public Integer getInt_cant_dias() {
        return int_cant_dias;
    }

    public void setInt_cant_dias(Integer int_cant_dias) {
        this.int_cant_dias = int_cant_dias;
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

    public Integer getInt_id_tipo_nivel() {
        return int_id_tipo_nivel;
    }

    public void setInt_id_tipo_nivel(Integer int_id_tipo_nivel) {
        this.int_id_tipo_nivel = int_id_tipo_nivel;
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