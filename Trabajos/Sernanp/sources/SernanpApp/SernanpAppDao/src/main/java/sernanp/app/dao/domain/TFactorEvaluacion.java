package sernanp.app.dao.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class TFactorEvaluacion extends TFactorEvaluacionKey implements Serializable {
    private Integer srl_id_configuracion_factor_evaluacion;

    private Integer int_id_tipo_factor;

    private BigDecimal dec_peso;

    private BigDecimal dec_puntaje_min;

    private BigDecimal dec_puntaje_max;

    private Integer int_id_estado;

    private Date tsp_fecha_registro;

    private Integer int_id_tipo_factor_padre;

    private static final long serialVersionUID = 1L;

    public Integer getSrl_id_configuracion_factor_evaluacion() {
        return srl_id_configuracion_factor_evaluacion;
    }

    public void setSrl_id_configuracion_factor_evaluacion(Integer srl_id_configuracion_factor_evaluacion) {
        this.srl_id_configuracion_factor_evaluacion = srl_id_configuracion_factor_evaluacion;
    }

    public Integer getInt_id_tipo_factor() {
        return int_id_tipo_factor;
    }

    public void setInt_id_tipo_factor(Integer int_id_tipo_factor) {
        this.int_id_tipo_factor = int_id_tipo_factor;
    }

    public BigDecimal getDec_peso() {
        return dec_peso;
    }

    public void setDec_peso(BigDecimal dec_peso) {
        this.dec_peso = dec_peso;
    }

    public BigDecimal getDec_puntaje_min() {
        return dec_puntaje_min;
    }

    public void setDec_puntaje_min(BigDecimal dec_puntaje_min) {
        this.dec_puntaje_min = dec_puntaje_min;
    }

    public BigDecimal getDec_puntaje_max() {
        return dec_puntaje_max;
    }

    public void setDec_puntaje_max(BigDecimal dec_puntaje_max) {
        this.dec_puntaje_max = dec_puntaje_max;
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

    public Integer getInt_id_tipo_factor_padre() {
        return int_id_tipo_factor_padre;
    }

    public void setInt_id_tipo_factor_padre(Integer int_id_tipo_factor_padre) {
        this.int_id_tipo_factor_padre = int_id_tipo_factor_padre;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", srl_id_configuracion_factor_evaluacion=").append(srl_id_configuracion_factor_evaluacion);
        sb.append(", int_id_tipo_factor=").append(int_id_tipo_factor);
        sb.append(", dec_peso=").append(dec_peso);
        sb.append(", dec_puntaje_min=").append(dec_puntaje_min);
        sb.append(", dec_puntaje_max=").append(dec_puntaje_max);
        sb.append(", int_id_estado=").append(int_id_estado);
        sb.append(", tsp_fecha_registro=").append(tsp_fecha_registro);
        sb.append(", int_id_tipo_factor_padre=").append(int_id_tipo_factor_padre);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}