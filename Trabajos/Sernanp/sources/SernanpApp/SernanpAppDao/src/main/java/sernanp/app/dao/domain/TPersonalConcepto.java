package sernanp.app.dao.domain;

import java.math.BigDecimal;
import java.util.Date;

public class TPersonalConcepto extends TPersonalConceptoKey {
    private Integer srl_id_beneficiario_descuento_judicial;

    private Integer idpersonal;

    private Integer srl_id_concepto_planilla;

    private BigDecimal dec_monto_concepto;

    private Integer int_id_tipo_monto_concepto;

    private Integer int_id_estado;

    private Date tsp_fecha_registro;

    private Integer int_aplica_afectos;

    private Integer int_aplica_frecuencias;

    private Integer srl_id_anio_planilla;

    private Integer idpersonanatural;

    public Integer getSrl_id_beneficiario_descuento_judicial() {
        return srl_id_beneficiario_descuento_judicial;
    }

    public void setSrl_id_beneficiario_descuento_judicial(Integer srl_id_beneficiario_descuento_judicial) {
        this.srl_id_beneficiario_descuento_judicial = srl_id_beneficiario_descuento_judicial;
    }

    public Integer getIdpersonal() {
        return idpersonal;
    }

    public void setIdpersonal(Integer idpersonal) {
        this.idpersonal = idpersonal;
    }

    public Integer getSrl_id_concepto_planilla() {
        return srl_id_concepto_planilla;
    }

    public void setSrl_id_concepto_planilla(Integer srl_id_concepto_planilla) {
        this.srl_id_concepto_planilla = srl_id_concepto_planilla;
    }

    public BigDecimal getDec_monto_concepto() {
        return dec_monto_concepto;
    }

    public void setDec_monto_concepto(BigDecimal dec_monto_concepto) {
        this.dec_monto_concepto = dec_monto_concepto;
    }

    public Integer getInt_id_tipo_monto_concepto() {
        return int_id_tipo_monto_concepto;
    }

    public void setInt_id_tipo_monto_concepto(Integer int_id_tipo_monto_concepto) {
        this.int_id_tipo_monto_concepto = int_id_tipo_monto_concepto;
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

    public Integer getInt_aplica_afectos() {
        return int_aplica_afectos;
    }

    public void setInt_aplica_afectos(Integer int_aplica_afectos) {
        this.int_aplica_afectos = int_aplica_afectos;
    }

    public Integer getInt_aplica_frecuencias() {
        return int_aplica_frecuencias;
    }

    public void setInt_aplica_frecuencias(Integer int_aplica_frecuencias) {
        this.int_aplica_frecuencias = int_aplica_frecuencias;
    }

    public Integer getSrl_id_anio_planilla() {
        return srl_id_anio_planilla;
    }

    public void setSrl_id_anio_planilla(Integer srl_id_anio_planilla) {
        this.srl_id_anio_planilla = srl_id_anio_planilla;
    }

    public Integer getIdpersonanatural() {
        return idpersonanatural;
    }

    public void setIdpersonanatural(Integer idpersonanatural) {
        this.idpersonanatural = idpersonanatural;
    }
}