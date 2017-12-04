package sernanp.app.dao.domain;

import java.math.BigDecimal;
import java.util.Date;

public class TEstadoPersonal extends TEstadoPersonalKey {
    private String var_motivo;

    private Integer int_id_estado;

    private Integer int_id_tipificacion;

    private Date dte_fecha_estado;

    private Integer srl_id_contrato;

    private Integer int_anio;

    private Integer int_mes;

    private BigDecimal dec_dias_vac_truncas;

    private String c_meta;

    private String c_fte_fto;

    public String getVar_motivo() {
        return var_motivo;
    }

    public void setVar_motivo(String var_motivo) {
        this.var_motivo = var_motivo;
    }

    public Integer getInt_id_estado() {
        return int_id_estado;
    }

    public void setInt_id_estado(Integer int_id_estado) {
        this.int_id_estado = int_id_estado;
    }

    public Integer getInt_id_tipificacion() {
        return int_id_tipificacion;
    }

    public void setInt_id_tipificacion(Integer int_id_tipificacion) {
        this.int_id_tipificacion = int_id_tipificacion;
    }

    public Date getDte_fecha_estado() {
        return dte_fecha_estado;
    }

    public void setDte_fecha_estado(Date dte_fecha_estado) {
        this.dte_fecha_estado = dte_fecha_estado;
    }

    public Integer getSrl_id_contrato() {
        return srl_id_contrato;
    }

    public void setSrl_id_contrato(Integer srl_id_contrato) {
        this.srl_id_contrato = srl_id_contrato;
    }

    public Integer getInt_anio() {
        return int_anio;
    }

    public void setInt_anio(Integer int_anio) {
        this.int_anio = int_anio;
    }

    public Integer getInt_mes() {
        return int_mes;
    }

    public void setInt_mes(Integer int_mes) {
        this.int_mes = int_mes;
    }

    public BigDecimal getDec_dias_vac_truncas() {
        return dec_dias_vac_truncas;
    }

    public void setDec_dias_vac_truncas(BigDecimal dec_dias_vac_truncas) {
        this.dec_dias_vac_truncas = dec_dias_vac_truncas;
    }

    public String getC_meta() {
        return c_meta;
    }

    public void setC_meta(String c_meta) {
        this.c_meta = c_meta;
    }

    public String getC_fte_fto() {
        return c_fte_fto;
    }

    public void setC_fte_fto(String c_fte_fto) {
        this.c_fte_fto = c_fte_fto;
    }
}