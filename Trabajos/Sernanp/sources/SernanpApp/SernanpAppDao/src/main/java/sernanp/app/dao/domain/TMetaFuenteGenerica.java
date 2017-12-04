package sernanp.app.dao.domain;

import java.io.Serializable;
import java.util.Date;

public class TMetaFuenteGenerica extends TMetaFuenteGenericaKey implements Serializable {
    private Integer srl_id_fuente_financiamiento;

    private Integer srl_id_meta_presupuestaria;

    private Integer idarea;

    private Integer idunidad;

    private Integer srl_id_clasificador;

    private Integer srl_id_anio_planilla;

    private String var_cod_meta_anio;

    private Integer int_id_estado;

    private Date tsp_fecha_registro;

    private static final long serialVersionUID = 1L;

    public Integer getSrl_id_fuente_financiamiento() {
        return srl_id_fuente_financiamiento;
    }

    public void setSrl_id_fuente_financiamiento(Integer srl_id_fuente_financiamiento) {
        this.srl_id_fuente_financiamiento = srl_id_fuente_financiamiento;
    }

    public Integer getSrl_id_meta_presupuestaria() {
        return srl_id_meta_presupuestaria;
    }

    public void setSrl_id_meta_presupuestaria(Integer srl_id_meta_presupuestaria) {
        this.srl_id_meta_presupuestaria = srl_id_meta_presupuestaria;
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

    public Integer getSrl_id_clasificador() {
        return srl_id_clasificador;
    }

    public void setSrl_id_clasificador(Integer srl_id_clasificador) {
        this.srl_id_clasificador = srl_id_clasificador;
    }

    public Integer getSrl_id_anio_planilla() {
        return srl_id_anio_planilla;
    }

    public void setSrl_id_anio_planilla(Integer srl_id_anio_planilla) {
        this.srl_id_anio_planilla = srl_id_anio_planilla;
    }

    public String getVar_cod_meta_anio() {
        return var_cod_meta_anio;
    }

    public void setVar_cod_meta_anio(String var_cod_meta_anio) {
        this.var_cod_meta_anio = var_cod_meta_anio;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", srl_id_fuente_financiamiento=").append(srl_id_fuente_financiamiento);
        sb.append(", srl_id_meta_presupuestaria=").append(srl_id_meta_presupuestaria);
        sb.append(", idarea=").append(idarea);
        sb.append(", idunidad=").append(idunidad);
        sb.append(", srl_id_clasificador=").append(srl_id_clasificador);
        sb.append(", srl_id_anio_planilla=").append(srl_id_anio_planilla);
        sb.append(", var_cod_meta_anio=").append(var_cod_meta_anio);
        sb.append(", int_id_estado=").append(int_id_estado);
        sb.append(", tsp_fecha_registro=").append(tsp_fecha_registro);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}