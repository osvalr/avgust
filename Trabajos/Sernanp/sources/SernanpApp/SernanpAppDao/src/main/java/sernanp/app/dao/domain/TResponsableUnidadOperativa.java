package sernanp.app.dao.domain;

import java.util.Date;

public class TResponsableUnidadOperativa extends TResponsableUnidadOperativaKey {
    private Integer idunidad;

    private Integer idpersonal;

    private Integer int_id_tipo_responsable;

    private Integer int_id_estado;

    private Date tsp_fecha_inicio_ejercicio;

    private Date tsp_fecha_fin_ejercicio;

    public Integer getIdunidad() {
        return idunidad;
    }

    public void setIdunidad(Integer idunidad) {
        this.idunidad = idunidad;
    }

    public Integer getIdpersonal() {
        return idpersonal;
    }

    public void setIdpersonal(Integer idpersonal) {
        this.idpersonal = idpersonal;
    }

    public Integer getInt_id_tipo_responsable() {
        return int_id_tipo_responsable;
    }

    public void setInt_id_tipo_responsable(Integer int_id_tipo_responsable) {
        this.int_id_tipo_responsable = int_id_tipo_responsable;
    }

    public Integer getInt_id_estado() {
        return int_id_estado;
    }

    public void setInt_id_estado(Integer int_id_estado) {
        this.int_id_estado = int_id_estado;
    }

    public Date getTsp_fecha_inicio_ejercicio() {
        return tsp_fecha_inicio_ejercicio;
    }

    public void setTsp_fecha_inicio_ejercicio(Date tsp_fecha_inicio_ejercicio) {
        this.tsp_fecha_inicio_ejercicio = tsp_fecha_inicio_ejercicio;
    }

    public Date getTsp_fecha_fin_ejercicio() {
        return tsp_fecha_fin_ejercicio;
    }

    public void setTsp_fecha_fin_ejercicio(Date tsp_fecha_fin_ejercicio) {
        this.tsp_fecha_fin_ejercicio = tsp_fecha_fin_ejercicio;
    }
}