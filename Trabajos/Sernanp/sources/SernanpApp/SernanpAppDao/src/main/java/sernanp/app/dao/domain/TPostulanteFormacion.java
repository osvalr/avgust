package sernanp.app.dao.domain;

import java.util.Date;

public class TPostulanteFormacion extends TPostulanteFormacionKey {
    private Integer int_id_postulante;

    private Integer srl_id_nivel_estudio;

    private Integer int_id_carrera;

    private Integer int_id_nivel_formacion;

    private Integer int_id_institucion;

    private Date dte_fecha_inicio;

    private Date dte_fecha_fin;

    private Integer int_id_estado;

    private Date tsp_fecha_registro;

    public Integer getInt_id_postulante() {
        return int_id_postulante;
    }

    public void setInt_id_postulante(Integer int_id_postulante) {
        this.int_id_postulante = int_id_postulante;
    }

    public Integer getSrl_id_nivel_estudio() {
        return srl_id_nivel_estudio;
    }

    public void setSrl_id_nivel_estudio(Integer srl_id_nivel_estudio) {
        this.srl_id_nivel_estudio = srl_id_nivel_estudio;
    }

    public Integer getInt_id_carrera() {
        return int_id_carrera;
    }

    public void setInt_id_carrera(Integer int_id_carrera) {
        this.int_id_carrera = int_id_carrera;
    }

    public Integer getInt_id_nivel_formacion() {
        return int_id_nivel_formacion;
    }

    public void setInt_id_nivel_formacion(Integer int_id_nivel_formacion) {
        this.int_id_nivel_formacion = int_id_nivel_formacion;
    }

    public Integer getInt_id_institucion() {
        return int_id_institucion;
    }

    public void setInt_id_institucion(Integer int_id_institucion) {
        this.int_id_institucion = int_id_institucion;
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