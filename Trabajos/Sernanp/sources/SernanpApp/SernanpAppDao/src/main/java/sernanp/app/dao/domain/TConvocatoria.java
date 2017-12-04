package sernanp.app.dao.domain;

import java.io.Serializable;
import java.util.Date;

public class TConvocatoria extends TConvocatoriaKey implements Serializable {
    private String var_num_convocatoria;

    private Integer int_id_estado;

    private Date tsp_fecha_registro;

    private Integer int_num_activacion;

    private Date dte_fecha_aprobacion;

    private Date dte_fecha_inicio_publicacion;

    private Date dte_fecha_termino_publicacion;

    private static final long serialVersionUID = 1L;

    public String getVar_num_convocatoria() {
        return var_num_convocatoria;
    }

    public void setVar_num_convocatoria(String var_num_convocatoria) {
        this.var_num_convocatoria = var_num_convocatoria;
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

    public Integer getInt_num_activacion() {
        return int_num_activacion;
    }

    public void setInt_num_activacion(Integer int_num_activacion) {
        this.int_num_activacion = int_num_activacion;
    }

    public Date getDte_fecha_aprobacion() {
        return dte_fecha_aprobacion;
    }

    public void setDte_fecha_aprobacion(Date dte_fecha_aprobacion) {
        this.dte_fecha_aprobacion = dte_fecha_aprobacion;
    }

    public Date getDte_fecha_inicio_publicacion() {
        return dte_fecha_inicio_publicacion;
    }

    public void setDte_fecha_inicio_publicacion(Date dte_fecha_inicio_publicacion) {
        this.dte_fecha_inicio_publicacion = dte_fecha_inicio_publicacion;
    }

    public Date getDte_fecha_termino_publicacion() {
        return dte_fecha_termino_publicacion;
    }

    public void setDte_fecha_termino_publicacion(Date dte_fecha_termino_publicacion) {
        this.dte_fecha_termino_publicacion = dte_fecha_termino_publicacion;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", var_num_convocatoria=").append(var_num_convocatoria);
        sb.append(", int_id_estado=").append(int_id_estado);
        sb.append(", tsp_fecha_registro=").append(tsp_fecha_registro);
        sb.append(", int_num_activacion=").append(int_num_activacion);
        sb.append(", dte_fecha_aprobacion=").append(dte_fecha_aprobacion);
        sb.append(", dte_fecha_inicio_publicacion=").append(dte_fecha_inicio_publicacion);
        sb.append(", dte_fecha_termino_publicacion=").append(dte_fecha_termino_publicacion);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}