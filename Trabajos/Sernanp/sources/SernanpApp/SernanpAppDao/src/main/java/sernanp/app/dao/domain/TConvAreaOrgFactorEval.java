package sernanp.app.dao.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class TConvAreaOrgFactorEval extends TConvAreaOrgFactorEvalKey implements Serializable {
    private Integer srl_id_conv_area_org;

    private Integer srl_id_postulante_conv_area_org;

    private Integer srl_id_factor_evaluacion;

    private Integer int_id_estado_asistencia;

    private BigDecimal dec_puntaje_obtenido;

    private BigDecimal dec_puntaje_calculado;

    private Integer int_id_estado_clasificacion;

    private Integer int_id_estado;

    private Date tsp_fecha_registro;

    private static final long serialVersionUID = 1L;

    public Integer getSrl_id_conv_area_org() {
        return srl_id_conv_area_org;
    }

    public void setSrl_id_conv_area_org(Integer srl_id_conv_area_org) {
        this.srl_id_conv_area_org = srl_id_conv_area_org;
    }

    public Integer getSrl_id_postulante_conv_area_org() {
        return srl_id_postulante_conv_area_org;
    }

    public void setSrl_id_postulante_conv_area_org(Integer srl_id_postulante_conv_area_org) {
        this.srl_id_postulante_conv_area_org = srl_id_postulante_conv_area_org;
    }

    public Integer getSrl_id_factor_evaluacion() {
        return srl_id_factor_evaluacion;
    }

    public void setSrl_id_factor_evaluacion(Integer srl_id_factor_evaluacion) {
        this.srl_id_factor_evaluacion = srl_id_factor_evaluacion;
    }

    public Integer getInt_id_estado_asistencia() {
        return int_id_estado_asistencia;
    }

    public void setInt_id_estado_asistencia(Integer int_id_estado_asistencia) {
        this.int_id_estado_asistencia = int_id_estado_asistencia;
    }

    public BigDecimal getDec_puntaje_obtenido() {
        return dec_puntaje_obtenido;
    }

    public void setDec_puntaje_obtenido(BigDecimal dec_puntaje_obtenido) {
        this.dec_puntaje_obtenido = dec_puntaje_obtenido;
    }

    public BigDecimal getDec_puntaje_calculado() {
        return dec_puntaje_calculado;
    }

    public void setDec_puntaje_calculado(BigDecimal dec_puntaje_calculado) {
        this.dec_puntaje_calculado = dec_puntaje_calculado;
    }

    public Integer getInt_id_estado_clasificacion() {
        return int_id_estado_clasificacion;
    }

    public void setInt_id_estado_clasificacion(Integer int_id_estado_clasificacion) {
        this.int_id_estado_clasificacion = int_id_estado_clasificacion;
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
        sb.append(", srl_id_conv_area_org=").append(srl_id_conv_area_org);
        sb.append(", srl_id_postulante_conv_area_org=").append(srl_id_postulante_conv_area_org);
        sb.append(", srl_id_factor_evaluacion=").append(srl_id_factor_evaluacion);
        sb.append(", int_id_estado_asistencia=").append(int_id_estado_asistencia);
        sb.append(", dec_puntaje_obtenido=").append(dec_puntaje_obtenido);
        sb.append(", dec_puntaje_calculado=").append(dec_puntaje_calculado);
        sb.append(", int_id_estado_clasificacion=").append(int_id_estado_clasificacion);
        sb.append(", int_id_estado=").append(int_id_estado);
        sb.append(", tsp_fecha_registro=").append(tsp_fecha_registro);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}