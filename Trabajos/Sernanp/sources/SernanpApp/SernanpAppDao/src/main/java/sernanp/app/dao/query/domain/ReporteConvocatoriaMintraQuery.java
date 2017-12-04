package sernanp.app.dao.query.domain; 

import java.util.Date;
import java.util.List;

public class ReporteConvocatoriaMintraQuery implements java.io.Serializable { 

private static final long serialVersionUID = 1L;
private Integer srl_id_conv_area_org; 
private Integer srl_id_convocatoria; 
private String var_numero_convocatoria_corto; 
private String var_codigo_postulacion; 
private Integer idarea_solicitante; 
private String descrip_area; 
private Integer idunidad_solicitante; 
private String descrip_unidad; 
private String var_denominacion_requerimiento; 
private Integer idarea_supervisora; 
private Integer srl_id_configuracion_factor_evaluacion; 
private String var_descrip_configuracion; 
private Integer srl_id_configuracion_evaluacion_personal; 
private String var_nombre_configuracion; 
private String var_numero_requerimiento; 
private String var_numero_requerimiento_corto; 
private Integer int_cantidad_requerida; 
private Integer idpersonal; 
private String var_lugar_prestacion; 
private String var_formacion_academica; 
private String var_cursos_especializacion; 
private String var_requisitos_puesto; 
private String var_principales_funciones; 
private String var_competencias_requeridas; 
private String var_experiencia_requerida; 
private String dte_fecha_inicio; 
private String dte_fecha_termino; 
private Double dec_honorario_personal; 
private Integer int_cantidad_tiempo; 
private Date dte_fecha_aprobacion;
private String dte_fecha_cronograma;
private String descrip_area_supervisora;
private Integer srl_id_subetapa_proceso_seleccion;
private String var_descrip_subetapa;
private String var_detalle_subetapa;
private String descrip_area_responsable;
private Integer int_id_tipo_unidad_tiempo;
private String descrip_unidad_tiempo;
private String dte_fecha_termino_contrato;
private String dte_fecha_inicio_contrato;
private String dte_fecha_publicacion;
private Integer srl_id_etapa_proceso_seleccion;
private String var_nombre_etapa;

private Integer srl_id_requerimiento_personal;

private List<ReporteConvocatoriaMintraObtenerFactorQuery> listEvaluacion;

private List<ReporteSelectEtapasSeleccionQuery> listEtapas;


private String descrip_tipo_factor;
private double dec_puntaje_min;
private double dec_puntaje_max;
private double dec_peso;

private Integer int_num_activacion;



public Integer getSrl_id_conv_area_org() { 
  return srl_id_conv_area_org; 
} 
public void setSrl_id_conv_area_org(Integer srl_id_conv_area_org) { 
  this.srl_id_conv_area_org = srl_id_conv_area_org; 
} 
public Integer getSrl_id_convocatoria() { 
  return srl_id_convocatoria; 
} 
public void setSrl_id_convocatoria(Integer srl_id_convocatoria) { 
  this.srl_id_convocatoria = srl_id_convocatoria; 
} 
public String getVar_numero_convocatoria_corto() { 
  return var_numero_convocatoria_corto; 
} 
public void setVar_numero_convocatoria_corto(String var_numero_convocatoria_corto) { 
  this.var_numero_convocatoria_corto = var_numero_convocatoria_corto; 
} 
public String getVar_codigo_postulacion() { 
  return var_codigo_postulacion; 
} 
public void setVar_codigo_postulacion(String var_codigo_postulacion) { 
  this.var_codigo_postulacion = var_codigo_postulacion; 
} 
public Integer getIdarea_solicitante() { 
  return idarea_solicitante; 
} 
public void setIdarea_solicitante(Integer idarea_solicitante) { 
  this.idarea_solicitante = idarea_solicitante; 
} 
public String getDescrip_area() { 
  return descrip_area; 
} 
public void setDescrip_area(String descrip_area) { 
  this.descrip_area = descrip_area; 
} 
public Integer getIdunidad_solicitante() { 
  return idunidad_solicitante; 
} 
public void setIdunidad_solicitante(Integer idunidad_solicitante) { 
  this.idunidad_solicitante = idunidad_solicitante; 
} 
public String getDescrip_unidad() { 
  return descrip_unidad; 
} 
public void setDescrip_unidad(String descrip_unidad) { 
  this.descrip_unidad = descrip_unidad; 
} 
public String getVar_denominacion_requerimiento() { 
  return var_denominacion_requerimiento; 
} 
public void setVar_denominacion_requerimiento(String var_denominacion_requerimiento) { 
  this.var_denominacion_requerimiento = var_denominacion_requerimiento; 
} 
public Integer getIdarea_supervisora() { 
  return idarea_supervisora; 
} 
public void setIdarea_supervisora(Integer idarea_supervisora) { 
  this.idarea_supervisora = idarea_supervisora; 
} 
public Integer getSrl_id_configuracion_factor_evaluacion() { 
  return srl_id_configuracion_factor_evaluacion; 
} 
public void setSrl_id_configuracion_factor_evaluacion(Integer srl_id_configuracion_factor_evaluacion) { 
  this.srl_id_configuracion_factor_evaluacion = srl_id_configuracion_factor_evaluacion; 
} 
public String getVar_descrip_configuracion() { 
  return var_descrip_configuracion; 
} 
public void setVar_descrip_configuracion(String var_descrip_configuracion) { 
  this.var_descrip_configuracion = var_descrip_configuracion; 
} 
public Integer getSrl_id_configuracion_evaluacion_personal() { 
  return srl_id_configuracion_evaluacion_personal; 
} 
public void setSrl_id_configuracion_evaluacion_personal(Integer srl_id_configuracion_evaluacion_personal) { 
  this.srl_id_configuracion_evaluacion_personal = srl_id_configuracion_evaluacion_personal; 
} 
public String getVar_nombre_configuracion() { 
  return var_nombre_configuracion; 
} 
public void setVar_nombre_configuracion(String var_nombre_configuracion) { 
  this.var_nombre_configuracion = var_nombre_configuracion; 
} 
public String getVar_numero_requerimiento() { 
  return var_numero_requerimiento; 
} 
public void setVar_numero_requerimiento(String var_numero_requerimiento) { 
  this.var_numero_requerimiento = var_numero_requerimiento; 
} 
public String getVar_numero_requerimiento_corto() { 
  return var_numero_requerimiento_corto; 
} 
public void setVar_numero_requerimiento_corto(String var_numero_requerimiento_corto) { 
  this.var_numero_requerimiento_corto = var_numero_requerimiento_corto; 
} 
public Integer getInt_cantidad_requerida() { 
  return int_cantidad_requerida; 
} 
public void setInt_cantidad_requerida(Integer int_cantidad_requerida) { 
  this.int_cantidad_requerida = int_cantidad_requerida; 
} 
public Integer getIdpersonal() { 
  return idpersonal; 
} 
public void setIdpersonal(Integer idpersonal) { 
  this.idpersonal = idpersonal; 
} 
public String getVar_lugar_prestacion() { 
  return var_lugar_prestacion; 
} 
public void setVar_lugar_prestacion(String var_lugar_prestacion) { 
  this.var_lugar_prestacion = var_lugar_prestacion; 
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
public String getVar_competencias_requeridas() { 
  return var_competencias_requeridas; 
} 
public void setVar_competencias_requeridas(String var_competencias_requeridas) { 
  this.var_competencias_requeridas = var_competencias_requeridas; 
} 
public String getVar_experiencia_requerida() { 
  return var_experiencia_requerida; 
} 
public void setVar_experiencia_requerida(String var_experiencia_requerida) { 
  this.var_experiencia_requerida = var_experiencia_requerida; 
} 
public String getDte_fecha_inicio() { 
  return dte_fecha_inicio; 
} 
public void setDte_fecha_inicio(String dte_fecha_inicio) { 
  this.dte_fecha_inicio = dte_fecha_inicio; 
} 
public String getDte_fecha_termino() { 
  return dte_fecha_termino; 
} 
public void setDte_fecha_termino(String dte_fecha_termino) { 
  this.dte_fecha_termino = dte_fecha_termino; 
} 
public Double getDec_honorario_personal() { 
  return dec_honorario_personal; 
} 
public void setDec_honorario_personal(Double dec_honorario_personal) { 
  this.dec_honorario_personal = dec_honorario_personal; 
} 
public Integer getInt_cantidad_tiempo() { 
  return int_cantidad_tiempo; 
} 
public void setInt_cantidad_tiempo(Integer int_cantidad_tiempo) { 
  this.int_cantidad_tiempo = int_cantidad_tiempo; 
}

public String getDescrip_area_supervisora() {
	return descrip_area_supervisora;
}
public void setDescrip_area_supervisora(String descrip_area_supervisora) {
	this.descrip_area_supervisora = descrip_area_supervisora;
}
public Date getDte_fecha_aprobacion() {
	return dte_fecha_aprobacion;
}
public void setDte_fecha_aprobacion(Date dte_fecha_aprobacion) {
	this.dte_fecha_aprobacion = dte_fecha_aprobacion;
}
public String getDte_fecha_cronograma() {
	return dte_fecha_cronograma;
}
public void setDte_fecha_cronograma(String dte_fecha_cronograma) {
	this.dte_fecha_cronograma = dte_fecha_cronograma;
}
public Integer getSrl_id_subetapa_proceso_seleccion() {
	return srl_id_subetapa_proceso_seleccion;
}
public void setSrl_id_subetapa_proceso_seleccion(
		Integer srl_id_subetapa_proceso_seleccion) {
	this.srl_id_subetapa_proceso_seleccion = srl_id_subetapa_proceso_seleccion;
}
public String getVar_descrip_subetapa() {
	return var_descrip_subetapa;
}
public void setVar_descrip_subetapa(String var_descrip_subetapa) {
	this.var_descrip_subetapa = var_descrip_subetapa;
}
public String getVar_detalle_subetapa() {
	return var_detalle_subetapa;
}
public void setVar_detalle_subetapa(String var_detalle_subetapa) {
	this.var_detalle_subetapa = var_detalle_subetapa;
}
public String getDescrip_area_responsable() {
	return descrip_area_responsable;
}
public void setDescrip_area_responsable(String descrip_area_responsable) {
	this.descrip_area_responsable = descrip_area_responsable;
}
public Integer getInt_id_tipo_unidad_tiempo() {
	return int_id_tipo_unidad_tiempo;
}
public void setInt_id_tipo_unidad_tiempo(Integer int_id_tipo_unidad_tiempo) {
	this.int_id_tipo_unidad_tiempo = int_id_tipo_unidad_tiempo;
}
public String getDescrip_unidad_tiempo() {
	return descrip_unidad_tiempo;
}
public void setDescrip_unidad_tiempo(String descrip_unidad_tiempo) {
	this.descrip_unidad_tiempo = descrip_unidad_tiempo;
}

public String getDte_fecha_inicio_contrato() {
	return dte_fecha_inicio_contrato;
}
public void setDte_fecha_inicio_contrato(String dte_fecha_inicio_contrato) {
	this.dte_fecha_inicio_contrato = dte_fecha_inicio_contrato;
}
public String getDte_fecha_termino_contrato() {
	return dte_fecha_termino_contrato;
}
public void setDte_fecha_termino_contrato(String dte_fecha_termino_contrato) {
	this.dte_fecha_termino_contrato = dte_fecha_termino_contrato;
}
public String getDte_fecha_publicacion() {
	return dte_fecha_publicacion;
}
public void setDte_fecha_publicacion(String dte_fecha_publicacion) {
	this.dte_fecha_publicacion = dte_fecha_publicacion;
}
public Integer getSrl_id_etapa_proceso_seleccion() {
	return srl_id_etapa_proceso_seleccion;
}
public void setSrl_id_etapa_proceso_seleccion(Integer srl_id_etapa_proceso_seleccion) {
	this.srl_id_etapa_proceso_seleccion = srl_id_etapa_proceso_seleccion;
}
public String getVar_nombre_etapa() {
	return var_nombre_etapa;
}
public void setVar_nombre_etapa(String var_nombre_etapa) {
	this.var_nombre_etapa = var_nombre_etapa;
}

public String getDescrip_tipo_factor() {
	return descrip_tipo_factor;
}
public void setDescrip_tipo_factor(String descrip_tipo_factor) {
	this.descrip_tipo_factor = descrip_tipo_factor;
}
public double getDec_puntaje_min() {
	return dec_puntaje_min;
}
public void setDec_puntaje_min(double dec_puntaje_min) {
	this.dec_puntaje_min = dec_puntaje_min;
}
public double getDec_puntaje_max() {
	return dec_puntaje_max;
}
public void setDec_puntaje_max(double dec_puntaje_max) {
	this.dec_puntaje_max = dec_puntaje_max;
}
public double getDec_peso() {
	return dec_peso;
}
public void setDec_peso(double dec_peso) {
	this.dec_peso = dec_peso;
} 

public Integer getSrl_id_requerimiento_personal() {
	return srl_id_requerimiento_personal;
}
public void setSrl_id_requerimiento_personal(Integer srl_id_requerimiento_personal) {
	this.srl_id_requerimiento_personal = srl_id_requerimiento_personal;
}
public List<ReporteConvocatoriaMintraObtenerFactorQuery> getListEvaluacion() {
	return listEvaluacion;
}
public void setListEvaluacion(List<ReporteConvocatoriaMintraObtenerFactorQuery> listEvaluacion) {
	this.listEvaluacion = listEvaluacion;
}
public List<ReporteSelectEtapasSeleccionQuery> getListEtapas() {
	return listEtapas;
}
public void setListEtapas(List<ReporteSelectEtapasSeleccionQuery> listEtapas) {
	this.listEtapas = listEtapas;
}
public Integer getInt_num_activacion() {
	return int_num_activacion;
}
public void setInt_num_activacion(Integer int_num_activacion) {
	this.int_num_activacion = int_num_activacion;
}

} 
