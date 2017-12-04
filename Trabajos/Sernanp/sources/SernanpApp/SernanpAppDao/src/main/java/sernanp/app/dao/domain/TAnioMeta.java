package sernanp.app.dao.domain;

import java.util.Date;

public class TAnioMeta extends TAnioMetaKey {
    private Integer srl_id_anio_planilla;

    private String cod_meta;

    private Integer idarea;

    private Integer idunidad;

    private Integer int_id_estado;

    private Date tsp_fecha_registro;

    public Integer getSrl_id_anio_planilla() {
        return srl_id_anio_planilla;
    }

    public void setSrl_id_anio_planilla(Integer srl_id_anio_planilla) {
        this.srl_id_anio_planilla = srl_id_anio_planilla;
    }

    public String getCod_meta() {
        return cod_meta;
    }

    public void setCod_meta(String cod_meta) {
        this.cod_meta = cod_meta;
    }

    public Integer getIdarea() {
        return idarea;
    }

    public void setIdarea(Integer idarea) {
        this.idarea = idarea;
    }

    public Integer getIdunidad() {
        return idunidad;
    }

    public void setIdunidad(Integer idunidad) {
        this.idunidad = idunidad;
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