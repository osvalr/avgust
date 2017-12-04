package sernanp.app.dao.domain;

import java.util.Date;

public class TNominaAnioPeriodoPersonal extends TNominaAnioPeriodoPersonalKey {
    private Integer idpersonal;

    private Integer srl_id_contrato;

    private Integer srl_id_anio_periodo_planilla;

    private Integer int_id_estado;

    private Double dec_total_ingresos;

    private Double dec_total_descuentos;

    private Double dec_total_aportes;

    private Double dec_total_neto;

    private Date tsp_fecha_registro;

    private String c_meta;

    private String c_fte_fto;

    private Integer srl_id_regimen_contractual;

    private Integer int_id_tipo_registro;

    private Integer idpersonanatural;

    private Integer srl_id_regimen_pensionario;

    private String var_ubicacion_fisica;

    private Integer srl_id_afp;

    private Integer int_id_tipo_comision;

    private Integer srl_id_entidad_bancaria;

    private String var_numero_cuenta_bancaria;

    public Integer getIdpersonal() {
        return idpersonal;
    }

    public void setIdpersonal(Integer idpersonal) {
        this.idpersonal = idpersonal;
    }

    public Integer getSrl_id_contrato() {
        return srl_id_contrato;
    }

    public void setSrl_id_contrato(Integer srl_id_contrato) {
        this.srl_id_contrato = srl_id_contrato;
    }

    public Integer getSrl_id_anio_periodo_planilla() {
        return srl_id_anio_periodo_planilla;
    }

    public void setSrl_id_anio_periodo_planilla(Integer srl_id_anio_periodo_planilla) {
        this.srl_id_anio_periodo_planilla = srl_id_anio_periodo_planilla;
    }

    public Integer getInt_id_estado() {
        return int_id_estado;
    }

    public void setInt_id_estado(Integer int_id_estado) {
        this.int_id_estado = int_id_estado;
    }

    public Double getDec_total_ingresos() {
        return dec_total_ingresos;
    }

    public void setDec_total_ingresos(Double dec_total_ingresos) {
        this.dec_total_ingresos = dec_total_ingresos;
    }

    public Double getDec_total_descuentos() {
        return dec_total_descuentos;
    }

    public void setDec_total_descuentos(Double dec_total_descuentos) {
        this.dec_total_descuentos = dec_total_descuentos;
    }

    public Double getDec_total_aportes() {
        return dec_total_aportes;
    }

    public void setDec_total_aportes(Double dec_total_aportes) {
        this.dec_total_aportes = dec_total_aportes;
    }

    public Double getDec_total_neto() {
        return dec_total_neto;
    }

    public void setDec_total_neto(Double dec_total_neto) {
        this.dec_total_neto = dec_total_neto;
    }

    public Date getTsp_fecha_registro() {
        return tsp_fecha_registro;
    }

    public void setTsp_fecha_registro(Date tsp_fecha_registro) {
        this.tsp_fecha_registro = tsp_fecha_registro;
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

    public Integer getSrl_id_regimen_contractual() {
        return srl_id_regimen_contractual;
    }

    public void setSrl_id_regimen_contractual(Integer srl_id_regimen_contractual) {
        this.srl_id_regimen_contractual = srl_id_regimen_contractual;
    }

    public Integer getInt_id_tipo_registro() {
        return int_id_tipo_registro;
    }

    public void setInt_id_tipo_registro(Integer int_id_tipo_registro) {
        this.int_id_tipo_registro = int_id_tipo_registro;
    }

    public Integer getIdpersonanatural() {
        return idpersonanatural;
    }

    public void setIdpersonanatural(Integer idpersonanatural) {
        this.idpersonanatural = idpersonanatural;
    }

    public Integer getSrl_id_regimen_pensionario() {
        return srl_id_regimen_pensionario;
    }

    public void setSrl_id_regimen_pensionario(Integer srl_id_regimen_pensionario) {
        this.srl_id_regimen_pensionario = srl_id_regimen_pensionario;
    }

    public String getVar_ubicacion_fisica() {
        return var_ubicacion_fisica;
    }

    public void setVar_ubicacion_fisica(String var_ubicacion_fisica) {
        this.var_ubicacion_fisica = var_ubicacion_fisica;
    }

    public Integer getSrl_id_afp() {
        return srl_id_afp;
    }

    public void setSrl_id_afp(Integer srl_id_afp) {
        this.srl_id_afp = srl_id_afp;
    }

    public Integer getInt_id_tipo_comision() {
        return int_id_tipo_comision;
    }

    public void setInt_id_tipo_comision(Integer int_id_tipo_comision) {
        this.int_id_tipo_comision = int_id_tipo_comision;
    }

    public Integer getSrl_id_entidad_bancaria() {
        return srl_id_entidad_bancaria;
    }

    public void setSrl_id_entidad_bancaria(Integer srl_id_entidad_bancaria) {
        this.srl_id_entidad_bancaria = srl_id_entidad_bancaria;
    }

    public String getVar_numero_cuenta_bancaria() {
        return var_numero_cuenta_bancaria;
    }

    public void setVar_numero_cuenta_bancaria(String var_numero_cuenta_bancaria) {
        this.var_numero_cuenta_bancaria = var_numero_cuenta_bancaria;
    }
}