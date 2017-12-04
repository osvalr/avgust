package sernanp.app.dao.domain;

import java.util.Date;

public class TDiasNoLaborables extends TDiasNoLaborablesKey {
    private Date dte_fec_no_laborable;

    private Integer int_estado;

    private Date tsp_fec_sys_reg;

    private Integer int_id_usu_crea;

    private Date tsp_fec_sys_anul;

    private Integer int_id_usu_anul;

    private String var_dia_no_lab_descripcion;

    private Integer int_anio;

    private Integer int_mes;

    public Date getDte_fec_no_laborable() {
        return dte_fec_no_laborable;
    }

    public void setDte_fec_no_laborable(Date dte_fec_no_laborable) {
        this.dte_fec_no_laborable = dte_fec_no_laborable;
    }

    public Integer getInt_estado() {
        return int_estado;
    }

    public void setInt_estado(Integer int_estado) {
        this.int_estado = int_estado;
    }

    public Date getTsp_fec_sys_reg() {
        return tsp_fec_sys_reg;
    }

    public void setTsp_fec_sys_reg(Date tsp_fec_sys_reg) {
        this.tsp_fec_sys_reg = tsp_fec_sys_reg;
    }

    public Integer getInt_id_usu_crea() {
        return int_id_usu_crea;
    }

    public void setInt_id_usu_crea(Integer int_id_usu_crea) {
        this.int_id_usu_crea = int_id_usu_crea;
    }

    public Date getTsp_fec_sys_anul() {
        return tsp_fec_sys_anul;
    }

    public void setTsp_fec_sys_anul(Date tsp_fec_sys_anul) {
        this.tsp_fec_sys_anul = tsp_fec_sys_anul;
    }

    public Integer getInt_id_usu_anul() {
        return int_id_usu_anul;
    }

    public void setInt_id_usu_anul(Integer int_id_usu_anul) {
        this.int_id_usu_anul = int_id_usu_anul;
    }

    public String getVar_dia_no_lab_descripcion() {
        return var_dia_no_lab_descripcion;
    }

    public void setVar_dia_no_lab_descripcion(String var_dia_no_lab_descripcion) {
        this.var_dia_no_lab_descripcion = var_dia_no_lab_descripcion;
    }

    public Integer getInt_anio() {
        return int_anio;
    }

    public void setInt_anio(Integer int_anio) {
        this.int_anio = int_anio;
    }

    public Integer getInt_mes() {
        return int_mes;
    }

    public void setInt_mes(Integer int_mes) {
        this.int_mes = int_mes;
    }
}