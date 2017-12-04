package sernanp.app.dao.query.domain; 

public class RpOficioMintraQuery implements java.io.Serializable { 

private static final long serialVersionUID = 1L;
private Integer int_cantidad_requerida; 
private String var_denominacion_requerimiento; 
private Integer idarea_solicitante; 
private String desarea; 
private Integer idunidad_solicitante; 
private String nomunidad; 
private Integer int_id_estado; 
private String var_nombre_estado; 
private Integer srl_id_requerimiento_personal; 
private String tsp_fecha_registro; 

private String var_nombre_anio;

private String ultimo_lanzamiento;

private String flag_segunda_convocataria;

public Integer getInt_cantidad_requerida() { 
  return int_cantidad_requerida; 
} 
public void setInt_cantidad_requerida(Integer int_cantidad_requerida) { 
  this.int_cantidad_requerida = int_cantidad_requerida; 
} 
public String getVar_denominacion_requerimiento() { 
  return var_denominacion_requerimiento; 
} 
public void setVar_denominacion_requerimiento(String var_denominacion_requerimiento) { 
  this.var_denominacion_requerimiento = var_denominacion_requerimiento; 
} 
public Integer getIdarea_solicitante() { 
  return idarea_solicitante; 
} 
public void setIdarea_solicitante(Integer idarea_solicitante) { 
  this.idarea_solicitante = idarea_solicitante; 
} 
public String getDesarea() { 
  return desarea; 
} 
public void setDesarea(String desarea) { 
  this.desarea = desarea; 
} 
public Integer getIdunidad_solicitante() { 
  return idunidad_solicitante; 
} 
public void setIdunidad_solicitante(Integer idunidad_solicitante) { 
  this.idunidad_solicitante = idunidad_solicitante; 
} 
public String getNomunidad() { 
  return nomunidad; 
} 
public void setNomunidad(String nomunidad) { 
  this.nomunidad = nomunidad; 
} 
public Integer getInt_id_estado() { 
  return int_id_estado; 
} 
public void setInt_id_estado(Integer int_id_estado) { 
  this.int_id_estado = int_id_estado; 
} 
public String getVar_nombre_estado() { 
  return var_nombre_estado; 
} 
public void setVar_nombre_estado(String var_nombre_estado) { 
  this.var_nombre_estado = var_nombre_estado; 
} 
public Integer getSrl_id_requerimiento_personal() { 
  return srl_id_requerimiento_personal; 
} 
public void setSrl_id_requerimiento_personal(Integer srl_id_requerimiento_personal) { 
  this.srl_id_requerimiento_personal = srl_id_requerimiento_personal; 
} 
public String getTsp_fecha_registro() { 
  return tsp_fecha_registro; 
} 
public void setTsp_fecha_registro(String tsp_fecha_registro) { 
  this.tsp_fecha_registro = tsp_fecha_registro; 
}
public String getVar_nombre_anio() {
	return var_nombre_anio;
}
public void setVar_nombre_anio(String var_nombre_anio) {
	this.var_nombre_anio = var_nombre_anio;
}
public String getUltimo_lanzamiento() {
	return ultimo_lanzamiento;
}
public void setUltimo_lanzamiento(String ultimo_lanzamiento) {
	this.ultimo_lanzamiento = ultimo_lanzamiento;
}
public String getFlag_segunda_convocataria() {
	return flag_segunda_convocataria;
}
public void setFlag_segunda_convocataria(String flag_segunda_convocataria) {
	this.flag_segunda_convocataria = flag_segunda_convocataria;
} 

} 
