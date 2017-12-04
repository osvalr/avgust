package sernanp.app.dao.domain;

import java.io.Serializable;
import java.util.Date;

public class TSubetapaProcesoSeleccion extends TSubetapaProcesoSeleccionKey implements Serializable {
    private Integer srl_id_etapa_proceso_seleccion;

    private Integer idarea;

    private Integer idunidad;

    private String var_descrip_subetapa;

    private Integer int_id_estado;

    private Date tsp_fecha_registro;

    private String var_detalle_subetapa;

    private static final long serialVersionUID = 1L;

    public Integer getSrl_id_etapa_proceso_seleccion() {
        return srl_id_etapa_proceso_seleccion;
    }

    public void setSrl_id_etapa_proceso_seleccion(Integer srl_id_etapa_proceso_seleccion) {
        this.srl_id_etapa_proceso_seleccion = srl_id_etapa_proceso_seleccion;
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

    public String getVar_descrip_subetapa() {
        return var_descrip_subetapa;
    }

    public void setVar_descrip_subetapa(String var_descrip_subetapa) {
        this.var_descrip_subetapa = var_descrip_subetapa;
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

    public String getVar_detalle_subetapa() {
        return var_detalle_subetapa;
    }

    public void setVar_detalle_subetapa(String var_detalle_subetapa) {
        this.var_detalle_subetapa = var_detalle_subetapa;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", srl_id_etapa_proceso_seleccion=").append(srl_id_etapa_proceso_seleccion);
        sb.append(", idarea=").append(idarea);
        sb.append(", idunidad=").append(idunidad);
        sb.append(", var_descrip_subetapa=").append(var_descrip_subetapa);
        sb.append(", int_id_estado=").append(int_id_estado);
        sb.append(", tsp_fecha_registro=").append(tsp_fecha_registro);
        sb.append(", var_detalle_subetapa=").append(var_detalle_subetapa);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}