package sernanp.app.dao.domain;

import java.util.Date;

public class TFrecuencia extends TFrecuenciaKey {
    private Integer int_id_mes;

    private Integer int_id_estado;

    private Date tsp_fecha_registro;
    
    private static final long serialVersionUID = 1L;

    public Integer getInt_id_mes() {
        return int_id_mes;
    }

    public void setInt_id_mes(Integer int_id_mes) {
        this.int_id_mes = int_id_mes;
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
        sb.append(", int_id_mes=").append(int_id_mes);
        sb.append(", int_id_estado=").append(int_id_estado);
        sb.append(", tsp_fecha_registro=").append(tsp_fecha_registro);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}