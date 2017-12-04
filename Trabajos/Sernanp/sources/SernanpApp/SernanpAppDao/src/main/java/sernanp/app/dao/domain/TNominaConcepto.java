package sernanp.app.dao.domain;

import java.io.Serializable;
import java.util.Date;

public class TNominaConcepto extends TNominaConceptoKey implements Serializable {
    private Integer srl_id_nomina_anio_periodo_personal;

    private Integer srl_id_concepto_planilla;

    private Integer srl_id_meta_fuente_generica;

    private Double dec_monto_calculado;

    private Integer int_id_estado;

    private Date tsp_fecha_registro;

    private static final long serialVersionUID = 1L;

    public Integer getSrl_id_nomina_anio_periodo_personal() {
        return srl_id_nomina_anio_periodo_personal;
    }

    public void setSrl_id_nomina_anio_periodo_personal(Integer srl_id_nomina_anio_periodo_personal) {
        this.srl_id_nomina_anio_periodo_personal = srl_id_nomina_anio_periodo_personal;
    }

    public Integer getSrl_id_concepto_planilla() {
        return srl_id_concepto_planilla;
    }

    public void setSrl_id_concepto_planilla(Integer srl_id_concepto_planilla) {
        this.srl_id_concepto_planilla = srl_id_concepto_planilla;
    }

    public Integer getSrl_id_meta_fuente_generica() {
        return srl_id_meta_fuente_generica;
    }

    public void setSrl_id_meta_fuente_generica(Integer srl_id_meta_fuente_generica) {
        this.srl_id_meta_fuente_generica = srl_id_meta_fuente_generica;
    }

    public Double getDec_monto_calculado() {
        return dec_monto_calculado;
    }

    public void setDec_monto_calculado(Double dec_monto_calculado) {
        this.dec_monto_calculado = dec_monto_calculado;
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
        sb.append(", srl_id_nomina_anio_periodo_personal=").append(srl_id_nomina_anio_periodo_personal);
        sb.append(", srl_id_concepto_planilla=").append(srl_id_concepto_planilla);
        sb.append(", srl_id_meta_fuente_generica=").append(srl_id_meta_fuente_generica);
        sb.append(", dec_monto_calculado=").append(dec_monto_calculado);
        sb.append(", int_id_estado=").append(int_id_estado);
        sb.append(", tsp_fecha_registro=").append(tsp_fecha_registro);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
