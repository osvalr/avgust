package sernanp.app.dao.domain;

import java.io.Serializable;
import java.util.Date;

public class TSuspensionCuartaCategoria extends TSuspensionCuartaCategoriaKey implements Serializable {
    private Integer idpersonal;

    private String var_num_operacion;

    private Date dte_fecha_presentacion;

    private Integer int_id_estado;

    private Date tsp_fecha_registro;

    private static final long serialVersionUID = 1L;

    public Integer getIdpersonal() {
        return idpersonal;
    }

    public void setIdpersonal(Integer idpersonal) {
        this.idpersonal = idpersonal;
    }

    public String getVar_num_operacion() {
        return var_num_operacion;
    }

    public void setVar_num_operacion(String var_num_operacion) {
        this.var_num_operacion = var_num_operacion;
    }

    public Date getDte_fecha_presentacion() {
        return dte_fecha_presentacion;
    }

    public void setDte_fecha_presentacion(Date dte_fecha_presentacion) {
        this.dte_fecha_presentacion = dte_fecha_presentacion;
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
        sb.append(", idpersonal=").append(idpersonal);
        sb.append(", var_num_operacion=").append(var_num_operacion);
        sb.append(", dte_fecha_presentacion=").append(dte_fecha_presentacion);
        sb.append(", int_id_estado=").append(int_id_estado);
        sb.append(", tsp_fecha_registro=").append(tsp_fecha_registro);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}