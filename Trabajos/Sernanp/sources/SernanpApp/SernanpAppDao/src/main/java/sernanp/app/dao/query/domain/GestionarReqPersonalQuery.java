package sernanp.app.dao.query.domain; 

public class GestionarReqPersonalQuery implements java.io.Serializable { 

private static final long serialVersionUID = 1L;
private Integer srl_id_requerimiento_personal; 
private String var_numero_requerimiento; 
private String var_numero_requerimiento_corto; 
private Integer idarea_solicitante; 
private String descrip_area_solicitante; 
private Integer idunidad_solicitante; 
private String descrip_unidad_solicitante; 
private Integer idarea_supervisora; 
private String descrip_area_supervisora; 
private Integer idunidad_supervisora; 
private String descrip_unidad_supervisora; 
private Integer idareanatural; 
private String desareanatural; 
private Integer idsede; 
private String dessede; 
private Integer idcategoriaanp; 
private String descategoriaanp; 
private Integer int_cantidad_requerida; 
private Double dec_honorario_personal; 
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
private String descrip_trabajador; 
private String var_denominacion_requerimiento; 
private Integer int_id_estado; 
private String descrip_estado; 
private String c_fte_fto; 
private String c_meta; 
private Integer int_anio; 
private Integer srl_id_anio_planilla; 
private String tsp_fecha_registro; 
private Integer id_sede_ubicacion; 
private String direccion_ubicacion_fisica; 
private String var_nomb_sede; 

private String path_files_requerimiento;

public Integer getSrl_id_requerimiento_personal() { 
  return srl_id_requerimiento_personal; 
} 
public void setSrl_id_requerimiento_personal(Integer srl_id_requerimiento_personal) { 
  this.srl_id_requerimiento_personal = srl_id_requerimiento_personal; 
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
public Integer getIdarea_solicitante() { 
  return idarea_solicitante; 
} 
public void setIdarea_solicitante(Integer idarea_solicitante) { 
  this.idarea_solicitante = idarea_solicitante; 
} 
public String getDescrip_area_solicitante() { 
  return descrip_area_solicitante; 
} 
public void setDescrip_area_solicitante(String descrip_area_solicitante) { 
  this.descrip_area_solicitante = descrip_area_solicitante; 
} 
public Integer getIdunidad_solicitante() { 
  return idunidad_solicitante; 
} 
public void setIdunidad_solicitante(Integer idunidad_solicitante) { 
  this.idunidad_solicitante = idunidad_solicitante; 
} 
public String getDescrip_unidad_solicitante() { 
  return descrip_unidad_solicitante; 
} 
public void setDescrip_unidad_solicitante(String descrip_unidad_solicitante) { 
  this.descrip_unidad_solicitante = descrip_unidad_solicitante; 
} 
public Integer getIdarea_supervisora() { 
  return idarea_supervisora; 
} 
public void setIdarea_supervisora(Integer idarea_supervisora) { 
  this.idarea_supervisora = idarea_supervisora; 
} 
public String getDescrip_area_supervisora() { 
  return descrip_area_supervisora; 
} 
public void setDescrip_area_supervisora(String descrip_area_supervisora) { 
  this.descrip_area_supervisora = descrip_area_supervisora; 
} 
public Integer getIdunidad_supervisora() { 
  return idunidad_supervisora; 
} 
public void setIdunidad_supervisora(Integer idunidad_supervisora) { 
  this.idunidad_supervisora = idunidad_supervisora; 
} 
public String getDescrip_unidad_supervisora() { 
  return descrip_unidad_supervisora; 
} 
public void setDescrip_unidad_supervisora(String descrip_unidad_supervisora) { 
  this.descrip_unidad_supervisora = descrip_unidad_supervisora; 
} 
public Integer getIdareanatural() { 
  return idareanatural; 
} 
public void setIdareanatural(Integer idareanatural) { 
  this.idareanatural = idareanatural; 
} 
public String getDesareanatural() { 
  return desareanatural; 
} 
public void setDesareanatural(String desareanatural) { 
  this.desareanatural = desareanatural; 
} 
public Integer getIdsede() { 
  return idsede; 
} 
public void setIdsede(Integer idsede) { 
  this.idsede = idsede; 
} 
public String getDessede() { 
  return dessede; 
} 
public void setDessede(String dessede) { 
  this.dessede = dessede; 
} 
public Integer getIdcategoriaanp() { 
  return idcategoriaanp; 
} 
public void setIdcategoriaanp(Integer idcategoriaanp) { 
  this.idcategoriaanp = idcategoriaanp; 
} 
public String getDescategoriaanp() { 
  return descategoriaanp; 
} 
public void setDescategoriaanp(String descategoriaanp) { 
  this.descategoriaanp = descategoriaanp; 
} 
public Integer getInt_cantidad_requerida() { 
  return int_cantidad_requerida; 
} 
public void setInt_cantidad_requerida(Integer int_cantidad_requerida) { 
  this.int_cantidad_requerida = int_cantidad_requerida; 
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
public String getDescrip_trabajador() { 
  return descrip_trabajador; 
} 
public void setDescrip_trabajador(String descrip_trabajador) { 
  this.descrip_trabajador = descrip_trabajador; 
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
public String getDescrip_estado() { 
  return descrip_estado; 
} 
public void setDescrip_estado(String descrip_estado) { 
  this.descrip_estado = descrip_estado; 
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
public Integer getSrl_id_anio_planilla() { 
  return srl_id_anio_planilla; 
} 
public void setSrl_id_anio_planilla(Integer srl_id_anio_planilla) { 
  this.srl_id_anio_planilla = srl_id_anio_planilla; 
} 
public String getTsp_fecha_registro() { 
  return tsp_fecha_registro; 
} 
public void setTsp_fecha_registro(String tsp_fecha_registro) { 
  this.tsp_fecha_registro = tsp_fecha_registro; 
} 
public Integer getId_sede_ubicacion() { 
  return id_sede_ubicacion; 
} 
public void setId_sede_ubicacion(Integer id_sede_ubicacion) { 
  this.id_sede_ubicacion = id_sede_ubicacion; 
} 
public String getDireccion_ubicacion_fisica() { 
  return direccion_ubicacion_fisica; 
} 
public void setDireccion_ubicacion_fisica(String direccion_ubicacion_fisica) { 
  this.direccion_ubicacion_fisica = direccion_ubicacion_fisica; 
} 
public String getVar_nomb_sede() { 
  return var_nomb_sede; 
} 
public void setVar_nomb_sede(String var_nomb_sede) { 
  this.var_nomb_sede = var_nomb_sede; 
}
public String getPath_files_requerimiento() {
	return path_files_requerimiento;
}
public void setPath_files_requerimiento(String path_files_requerimiento) {
	this.path_files_requerimiento = path_files_requerimiento;
} 

} 
