package sernanp.app.dao.query.domain; 

public class RpSeleccionPostulantesFichaPostulacionQuery implements java.io.Serializable { 

private static final long serialVersionUID = 1L;
private Integer idpersona; 
private Integer idpersonanatural; 
private Integer int_id_postulante; 
private String nombre_completo; 
private Integer idtipodocumento; 
private String tipodocumento;
private String numerodoc; 
private Integer srl_id_convocatoria; 
private String var_num_convocatoria; 
private Integer estado_convocatoria; 
private Integer srl_id_conv_area_org; 
private String var_codigo_postulacion; 
private Integer int_id_tipo_factor;
private String evaluacion;

private Integer int_id_estado_asistencia; 
private Double dec_puntaje_obtenido; 
private Double dec_puntaje_total;
private Integer int_id_estado_clasificacion; 
private String des_estado_postulante_cnv_area_org;
private String estado_clasificacion;
private Integer srl_id_unidad_operativa; 
private String var_nom_unidad;

/*ADD TO FILTER FOR UNIDAD OPERATIVA*/
private Integer srl_id_sede_req_sel;
private String var_nomb_sede;
/*END*/


public Integer getIdpersona() { 
  return idpersona; 
} 
public void setIdpersona(Integer idpersona) { 
  this.idpersona = idpersona; 
} 
public Integer getIdpersonanatural() { 
  return idpersonanatural; 
} 
public void setIdpersonanatural(Integer idpersonanatural) { 
  this.idpersonanatural = idpersonanatural; 
} 
public Integer getInt_id_postulante() { 
  return int_id_postulante; 
} 
public void setInt_id_postulante(Integer int_id_postulante) { 
  this.int_id_postulante = int_id_postulante; 
} 
public String getNombre_completo() { 
  return nombre_completo; 
} 
public void setNombre_completo(String nombre_completo) { 
  this.nombre_completo = nombre_completo; 
} 
public Integer getIdtipodocumento() { 
  return idtipodocumento; 
} 
public void setIdtipodocumento(Integer idtipodocumento) { 
  this.idtipodocumento = idtipodocumento; 
} 
public String getNumerodoc() { 
  return numerodoc; 
} 
public void setNumerodoc(String numerodoc) { 
  this.numerodoc = numerodoc; 
} 
public Integer getSrl_id_convocatoria() { 
  return srl_id_convocatoria; 
} 
public void setSrl_id_convocatoria(Integer srl_id_convocatoria) { 
  this.srl_id_convocatoria = srl_id_convocatoria; 
} 
public String getVar_num_convocatoria() { 
  return var_num_convocatoria; 
} 
public void setVar_num_convocatoria(String var_num_convocatoria) { 
  this.var_num_convocatoria = var_num_convocatoria; 
} 
public Integer getEstado_convocatoria() { 
  return estado_convocatoria; 
} 
public void setEstado_convocatoria(Integer estado_convocatoria) { 
  this.estado_convocatoria = estado_convocatoria; 
} 
public Integer getSrl_id_conv_area_org() { 
  return srl_id_conv_area_org; 
} 
public void setSrl_id_conv_area_org(Integer srl_id_conv_area_org) { 
  this.srl_id_conv_area_org = srl_id_conv_area_org; 
} 
public String getVar_codigo_postulacion() { 
  return var_codigo_postulacion; 
} 
public void setVar_codigo_postulacion(String var_codigo_postulacion) { 
  this.var_codigo_postulacion = var_codigo_postulacion; 
} 
 
public Integer getInt_id_estado_asistencia() { 
  return int_id_estado_asistencia; 
} 
public void setInt_id_estado_asistencia(Integer int_id_estado_asistencia) { 
  this.int_id_estado_asistencia = int_id_estado_asistencia; 
} 
public Double getDec_puntaje_obtenido() { 
  return dec_puntaje_obtenido; 
} 
public void setDec_puntaje_obtenido(Double dec_puntaje_obtenido) { 
  this.dec_puntaje_obtenido = dec_puntaje_obtenido; 
} 
public Integer getInt_id_estado_clasificacion() { 
  return int_id_estado_clasificacion; 
} 
public void setInt_id_estado_clasificacion(Integer int_id_estado_clasificacion) { 
  this.int_id_estado_clasificacion = int_id_estado_clasificacion; 
}
public String getTipodocumento() {
	return tipodocumento;
}
public void setTipodocumento(String tipodocumento) {
	this.tipodocumento = tipodocumento;
}
public String getDes_estado_postulante_cnv_area_org() {
	return des_estado_postulante_cnv_area_org;
}
public void setDes_estado_postulante_cnv_area_org(
		String des_estado_postulante_cnv_area_org) {
	this.des_estado_postulante_cnv_area_org = des_estado_postulante_cnv_area_org;
}
public Integer getInt_id_tipo_factor() {
	return int_id_tipo_factor;
}
public void setInt_id_tipo_factor(Integer int_id_tipo_factor) {
	this.int_id_tipo_factor = int_id_tipo_factor;
}
public String getEvaluacion() {
	return evaluacion;
}
public void setEvaluacion(String evaluacion) {
	this.evaluacion = evaluacion;
}
public Double getDec_puntaje_total() {
	return dec_puntaje_total;
}
public void setDec_puntaje_total(Double dec_puntaje_total) {
	this.dec_puntaje_total = dec_puntaje_total;
}
public String getEstado_clasificacion() {
	return estado_clasificacion;
}
public void setEstado_clasificacion(String estado_clasificacion) {
	this.estado_clasificacion = estado_clasificacion;
}
public Integer getSrl_id_unidad_operativa() {
	return srl_id_unidad_operativa;
}
public void setSrl_id_unidad_operativa(Integer srl_id_unidad_operativa) {
	this.srl_id_unidad_operativa = srl_id_unidad_operativa;
}
public String getVar_nom_unidad() {
	return var_nom_unidad;
}
public void setVar_nom_unidad(String var_nom_unidad) {
	this.var_nom_unidad = var_nom_unidad;
}
public String getVar_nomb_sede() {
	return var_nomb_sede;
}
public void setVar_nomb_sede(String var_nomb_sede) {
	this.var_nomb_sede = var_nomb_sede;
}
public Integer getSrl_id_sede_req_sel() {
	return srl_id_sede_req_sel;
}
public void setSrl_id_sede_req_sel(Integer srl_id_sede_req_sel) {
	this.srl_id_sede_req_sel = srl_id_sede_req_sel;
}


} 
