package sernanp.app.dao.domain;

import java.math.BigDecimal;
import java.util.Date;

public class TPersonalContrato extends TPersonalContratoKey {
    private String var_num_contrato;

    private BigDecimal num_sueldo;

    private Integer idpersonal;

    private Date dte_fec_inicio;

    private Date dte_fec_termino;

    private Date dte_fec_suscrip;

    private Integer int_id_reg_lab;

    private Integer idarea;

    private Date dte_fec_cese;

    private Integer int_id_tab_tip;

    private Integer int_est_contrato;

    private Integer srl_id_cargo;

    private Integer srl_id_meta_presupuestaria;

    private Integer srl_id_regimen_contractual;

    private Integer srl_id_fuente_financiamiento;

    private Integer srl_id_postulante_conv_area_org;

    private Integer srl_id_sede_pres;

    private Integer srl_id_nivel_remunerativo;

    private Integer srl_id_contrato_padre;

    private Integer int_id_estado;

    private Integer int_id_tipo_trato;

    private Integer srl_id_resp_unid_oper;

    private Integer srl_id_plantilla_documento_archivo;

    private String var_num_resolucion;

    private Integer idunidad;

    private String var_lugar_prestacion;

    private String des_area_organica;

    private String des_unidad_operativa;

    private Integer srl_id_meta_fuente_generica;

    private String var_nivel_regimen_contractual;

    private String codmeta;

    private String codfuente;

    private String var_ubicacion_fisica;

    private Integer int_id_idubigeo;

    private String var_direccion_personal;

    public String getVar_num_contrato() {
        return var_num_contrato;
    }

    public void setVar_num_contrato(String var_num_contrato) {
        this.var_num_contrato = var_num_contrato;
    }

    public BigDecimal getNum_sueldo() {
        return num_sueldo;
    }

    public void setNum_sueldo(BigDecimal num_sueldo) {
        this.num_sueldo = num_sueldo;
    }

    public Integer getIdpersonal() {
        return idpersonal;
    }

    public void setIdpersonal(Integer idpersonal) {
        this.idpersonal = idpersonal;
    }

    public Date getDte_fec_inicio() {
        return dte_fec_inicio;
    }

    public void setDte_fec_inicio(Date dte_fec_inicio) {
        this.dte_fec_inicio = dte_fec_inicio;
    }

    public Date getDte_fec_termino() {
        return dte_fec_termino;
    }

    public void setDte_fec_termino(Date dte_fec_termino) {
        this.dte_fec_termino = dte_fec_termino;
    }

    public Date getDte_fec_suscrip() {
        return dte_fec_suscrip;
    }

    public void setDte_fec_suscrip(Date dte_fec_suscrip) {
        this.dte_fec_suscrip = dte_fec_suscrip;
    }

    public Integer getInt_id_reg_lab() {
        return int_id_reg_lab;
    }

    public void setInt_id_reg_lab(Integer int_id_reg_lab) {
        this.int_id_reg_lab = int_id_reg_lab;
    }

    public Integer getIdarea() {
        return idarea;
    }

    public void setIdarea(Integer idarea) {
        this.idarea = idarea;
    }

    public Date getDte_fec_cese() {
        return dte_fec_cese;
    }

    public void setDte_fec_cese(Date dte_fec_cese) {
        this.dte_fec_cese = dte_fec_cese;
    }

    public Integer getInt_id_tab_tip() {
        return int_id_tab_tip;
    }

    public void setInt_id_tab_tip(Integer int_id_tab_tip) {
        this.int_id_tab_tip = int_id_tab_tip;
    }

    public Integer getInt_est_contrato() {
        return int_est_contrato;
    }

    public void setInt_est_contrato(Integer int_est_contrato) {
        this.int_est_contrato = int_est_contrato;
    }

    public Integer getSrl_id_cargo() {
        return srl_id_cargo;
    }

    public void setSrl_id_cargo(Integer srl_id_cargo) {
        this.srl_id_cargo = srl_id_cargo;
    }

    public Integer getSrl_id_meta_presupuestaria() {
        return srl_id_meta_presupuestaria;
    }

    public void setSrl_id_meta_presupuestaria(Integer srl_id_meta_presupuestaria) {
        this.srl_id_meta_presupuestaria = srl_id_meta_presupuestaria;
    }

    public Integer getSrl_id_regimen_contractual() {
        return srl_id_regimen_contractual;
    }

    public void setSrl_id_regimen_contractual(Integer srl_id_regimen_contractual) {
        this.srl_id_regimen_contractual = srl_id_regimen_contractual;
    }

    public Integer getSrl_id_fuente_financiamiento() {
        return srl_id_fuente_financiamiento;
    }

    public void setSrl_id_fuente_financiamiento(Integer srl_id_fuente_financiamiento) {
        this.srl_id_fuente_financiamiento = srl_id_fuente_financiamiento;
    }

    public Integer getSrl_id_postulante_conv_area_org() {
        return srl_id_postulante_conv_area_org;
    }

    public void setSrl_id_postulante_conv_area_org(Integer srl_id_postulante_conv_area_org) {
        this.srl_id_postulante_conv_area_org = srl_id_postulante_conv_area_org;
    }

    public Integer getSrl_id_sede_pres() {
        return srl_id_sede_pres;
    }

    public void setSrl_id_sede_pres(Integer srl_id_sede_pres) {
        this.srl_id_sede_pres = srl_id_sede_pres;
    }

    public Integer getSrl_id_nivel_remunerativo() {
        return srl_id_nivel_remunerativo;
    }

    public void setSrl_id_nivel_remunerativo(Integer srl_id_nivel_remunerativo) {
        this.srl_id_nivel_remunerativo = srl_id_nivel_remunerativo;
    }

    public Integer getSrl_id_contrato_padre() {
        return srl_id_contrato_padre;
    }

    public void setSrl_id_contrato_padre(Integer srl_id_contrato_padre) {
        this.srl_id_contrato_padre = srl_id_contrato_padre;
    }

    public Integer getInt_id_estado() {
        return int_id_estado;
    }

    public void setInt_id_estado(Integer int_id_estado) {
        this.int_id_estado = int_id_estado;
    }

    public Integer getInt_id_tipo_trato() {
        return int_id_tipo_trato;
    }

    public void setInt_id_tipo_trato(Integer int_id_tipo_trato) {
        this.int_id_tipo_trato = int_id_tipo_trato;
    }

    public Integer getSrl_id_resp_unid_oper() {
        return srl_id_resp_unid_oper;
    }

    public void setSrl_id_resp_unid_oper(Integer srl_id_resp_unid_oper) {
        this.srl_id_resp_unid_oper = srl_id_resp_unid_oper;
    }

    public Integer getSrl_id_plantilla_documento_archivo() {
        return srl_id_plantilla_documento_archivo;
    }

    public void setSrl_id_plantilla_documento_archivo(Integer srl_id_plantilla_documento_archivo) {
        this.srl_id_plantilla_documento_archivo = srl_id_plantilla_documento_archivo;
    }

    public String getVar_num_resolucion() {
        return var_num_resolucion;
    }

    public void setVar_num_resolucion(String var_num_resolucion) {
        this.var_num_resolucion = var_num_resolucion;
    }

    public Integer getIdunidad() {
        return idunidad;
    }

    public void setIdunidad(Integer idunidad) {
        this.idunidad = idunidad;
    }

    public String getVar_lugar_prestacion() {
        return var_lugar_prestacion;
    }

    public void setVar_lugar_prestacion(String var_lugar_prestacion) {
        this.var_lugar_prestacion = var_lugar_prestacion;
    }

    public String getDes_area_organica() {
        return des_area_organica;
    }

    public void setDes_area_organica(String des_area_organica) {
        this.des_area_organica = des_area_organica;
    }

    public String getDes_unidad_operativa() {
        return des_unidad_operativa;
    }

    public void setDes_unidad_operativa(String des_unidad_operativa) {
        this.des_unidad_operativa = des_unidad_operativa;
    }

    public Integer getSrl_id_meta_fuente_generica() {
        return srl_id_meta_fuente_generica;
    }

    public void setSrl_id_meta_fuente_generica(Integer srl_id_meta_fuente_generica) {
        this.srl_id_meta_fuente_generica = srl_id_meta_fuente_generica;
    }

    public String getVar_nivel_regimen_contractual() {
        return var_nivel_regimen_contractual;
    }

    public void setVar_nivel_regimen_contractual(String var_nivel_regimen_contractual) {
        this.var_nivel_regimen_contractual = var_nivel_regimen_contractual;
    }

    public String getCodmeta() {
        return codmeta;
    }

    public void setCodmeta(String codmeta) {
        this.codmeta = codmeta;
    }

    public String getCodfuente() {
        return codfuente;
    }

    public void setCodfuente(String codfuente) {
        this.codfuente = codfuente;
    }

    public String getVar_ubicacion_fisica() {
        return var_ubicacion_fisica;
    }

    public void setVar_ubicacion_fisica(String var_ubicacion_fisica) {
        this.var_ubicacion_fisica = var_ubicacion_fisica;
    }

    public Integer getInt_id_idubigeo() {
        return int_id_idubigeo;
    }

    public void setInt_id_idubigeo(Integer int_id_idubigeo) {
        this.int_id_idubigeo = int_id_idubigeo;
    }

    public String getVar_direccion_personal() {
        return var_direccion_personal;
    }

    public void setVar_direccion_personal(String var_direccion_personal) {
        this.var_direccion_personal = var_direccion_personal;
    }
}