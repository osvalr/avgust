package sernanp.app.dao.domain;

import java.math.BigDecimal;
import java.util.Date;

public class TRequerimientoPersonal extends TRequerimientoPersonalKey {
    private Integer idarea_solicitante;

    private Integer idunidad_solicitante;

    private Integer idarea_supervisora;

    private Integer idunidad_supervisora;

    private String var_numero_requerimiento;

    private Integer int_cantidad_requerida;

    private BigDecimal dec_honorario_personal;

    private Integer int_cantidad_tiempo;

    private Integer int_id_tipo_unidad_tiempo;

    private String var_experiencia_requerida;

    private String var_competencias_requeridas;

    private String var_formacion_academica;

    private String var_cursos_especializacion;

    private String var_requisitos_puesto;

    private String var_principales_funciones;

    private Integer int_requiere_evaluacion;

    private String var_lugar_prestacion;

    private Integer int_id_tipo_trabajador;

    private String var_denominacion_requerimiento;

    private Integer int_id_estado;

    private Date tsp_fecha_registro;

    private String c_fte_fto;

    private String c_meta;

    private Integer int_anio;

    private Integer id_sede_ubicacion;

    private Integer srl_id_sede_req_sel;

    private Date dte_fec_aprobacion_oa;

    public Integer getIdarea_solicitante() {
        return idarea_solicitante;
    }

    public void setIdarea_solicitante(Integer idarea_solicitante) {
        this.idarea_solicitante = idarea_solicitante;
    }

    public Integer getIdunidad_solicitante() {
        return idunidad_solicitante;
    }

    public void setIdunidad_solicitante(Integer idunidad_solicitante) {
        this.idunidad_solicitante = idunidad_solicitante;
    }

    public Integer getIdarea_supervisora() {
        return idarea_supervisora;
    }

    public void setIdarea_supervisora(Integer idarea_supervisora) {
        this.idarea_supervisora = idarea_supervisora;
    }

    public Integer getIdunidad_supervisora() {
        return idunidad_supervisora;
    }

    public void setIdunidad_supervisora(Integer idunidad_supervisora) {
        this.idunidad_supervisora = idunidad_supervisora;
    }

    public String getVar_numero_requerimiento() {
        return var_numero_requerimiento;
    }

    public void setVar_numero_requerimiento(String var_numero_requerimiento) {
        this.var_numero_requerimiento = var_numero_requerimiento;
    }

    public Integer getInt_cantidad_requerida() {
        return int_cantidad_requerida;
    }

    public void setInt_cantidad_requerida(Integer int_cantidad_requerida) {
        this.int_cantidad_requerida = int_cantidad_requerida;
    }

    public BigDecimal getDec_honorario_personal() {
        return dec_honorario_personal;
    }

    public void setDec_honorario_personal(BigDecimal dec_honorario_personal) {
        this.dec_honorario_personal = dec_honorario_personal;
    }

    public Integer getInt_cantidad_tiempo() {
        return int_cantidad_tiempo;
    }

    public void setInt_cantidad_tiempo(Integer int_cantidad_tiempo) {
        this.int_cantidad_tiempo = int_cantidad_tiempo;
    }

    public Integer getInt_id_tipo_unidad_tiempo() {
        return int_id_tipo_unidad_tiempo;
    }

    public void setInt_id_tipo_unidad_tiempo(Integer int_id_tipo_unidad_tiempo) {
        this.int_id_tipo_unidad_tiempo = int_id_tipo_unidad_tiempo;
    }

    public String getVar_experiencia_requerida() {
        return var_experiencia_requerida;
    }

    public void setVar_experiencia_requerida(String var_experiencia_requerida) {
        this.var_experiencia_requerida = var_experiencia_requerida;
    }

    public String getVar_competencias_requeridas() {
        return var_competencias_requeridas;
    }

    public void setVar_competencias_requeridas(String var_competencias_requeridas) {
        this.var_competencias_requeridas = var_competencias_requeridas;
    }

    public String getVar_formacion_academica() {
        return var_formacion_academica;
    }

    public void setVar_formacion_academica(String var_formacion_academica) {
        this.var_formacion_academica = var_formacion_academica;
    }

    public String getVar_cursos_especializacion() {
        return var_cursos_especializacion;
    }

    public void setVar_cursos_especializacion(String var_cursos_especializacion) {
        this.var_cursos_especializacion = var_cursos_especializacion;
    }

    public String getVar_requisitos_puesto() {
        return var_requisitos_puesto;
    }

    public void setVar_requisitos_puesto(String var_requisitos_puesto) {
        this.var_requisitos_puesto = var_requisitos_puesto;
    }

    public String getVar_principales_funciones() {
        return var_principales_funciones;
    }

    public void setVar_principales_funciones(String var_principales_funciones) {
        this.var_principales_funciones = var_principales_funciones;
    }

    public Integer getInt_requiere_evaluacion() {
        return int_requiere_evaluacion;
    }

    public void setInt_requiere_evaluacion(Integer int_requiere_evaluacion) {
        this.int_requiere_evaluacion = int_requiere_evaluacion;
    }

    public String getVar_lugar_prestacion() {
        return var_lugar_prestacion;
    }

    public void setVar_lugar_prestacion(String var_lugar_prestacion) {
        this.var_lugar_prestacion = var_lugar_prestacion;
    }

    public Integer getInt_id_tipo_trabajador() {
        return int_id_tipo_trabajador;
    }

    public void setInt_id_tipo_trabajador(Integer int_id_tipo_trabajador) {
        this.int_id_tipo_trabajador = int_id_tipo_trabajador;
    }

    public String getVar_denominacion_requerimiento() {
        return var_denominacion_requerimiento;
    }

    public void setVar_denominacion_requerimiento(String var_denominacion_requerimiento) {
        this.var_denominacion_requerimiento = var_denominacion_requerimiento;
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

    public String getC_fte_fto() {
        return c_fte_fto;
    }

    public void setC_fte_fto(String c_fte_fto) {
        this.c_fte_fto = c_fte_fto;
    }

    public String getC_meta() {
        return c_meta;
    }

    public void setC_meta(String c_meta) {
        this.c_meta = c_meta;
    }

    public Integer getInt_anio() {
        return int_anio;
    }

    public void setInt_anio(Integer int_anio) {
        this.int_anio = int_anio;
    }

    public Integer getId_sede_ubicacion() {
        return id_sede_ubicacion;
    }

    public void setId_sede_ubicacion(Integer id_sede_ubicacion) {
        this.id_sede_ubicacion = id_sede_ubicacion;
    }

    public Integer getSrl_id_sede_req_sel() {
        return srl_id_sede_req_sel;
    }

    public void setSrl_id_sede_req_sel(Integer srl_id_sede_req_sel) {
        this.srl_id_sede_req_sel = srl_id_sede_req_sel;
    }

    public Date getDte_fec_aprobacion_oa() {
        return dte_fec_aprobacion_oa;
    }

    public void setDte_fec_aprobacion_oa(Date dte_fec_aprobacion_oa) {
        this.dte_fec_aprobacion_oa = dte_fec_aprobacion_oa;
    }
}