package sernanp.app.dao.domain;

import java.util.Date;

public class TPostulanteExperienciaLaboral extends TPostulanteExperienciaLaboralKey {
    private Integer int_id_postulante;

    private Integer int_id_institucion;

    private Integer int_id_cargo;

    private Integer int_id_tipo_experiencia;

    private Date dte_fecha_inicio;

    private Date dte_fecha_termino;

    private Integer int_cant_anio;

    private Integer int_cant_meses;

    private Integer int_cant_dias;

    private String var_descrip_institucion;

    private String var_descrip_funciones;

    private String var_motivo_cese;

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

    public Integer getInt_id_cargo() {
        return int_id_cargo;
    }

    public void setInt_id_cargo(Integer int_id_cargo) {
        this.int_id_cargo = int_id_cargo;
    }

    public Integer getInt_id_tipo_experiencia() {
        return int_id_tipo_experiencia;
    }

    public void setInt_id_tipo_experiencia(Integer int_id_tipo_experiencia) {
        this.int_id_tipo_experiencia = int_id_tipo_experiencia;
    }

    public Date getDte_fecha_inicio() {
        return dte_fecha_inicio;
    }

    public void setDte_fecha_inicio(Date dte_fecha_inicio) {
        this.dte_fecha_inicio = dte_fecha_inicio;
    }

    public Date getDte_fecha_termino() {
        return dte_fecha_termino;
    }

    public void setDte_fecha_termino(Date dte_fecha_termino) {
        this.dte_fecha_termino = dte_fecha_termino;
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

    public String getVar_descrip_institucion() {
        return var_descrip_institucion;
    }

    public void setVar_descrip_institucion(String var_descrip_institucion) {
        this.var_descrip_institucion = var_descrip_institucion;
    }

    public String getVar_descrip_funciones() {
        return var_descrip_funciones;
    }

    public void setVar_descrip_funciones(String var_descrip_funciones) {
        this.var_descrip_funciones = var_descrip_funciones;
    }

    public String getVar_motivo_cese() {
        return var_motivo_cese;
    }

    public void setVar_motivo_cese(String var_motivo_cese) {
        this.var_motivo_cese = var_motivo_cese;
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