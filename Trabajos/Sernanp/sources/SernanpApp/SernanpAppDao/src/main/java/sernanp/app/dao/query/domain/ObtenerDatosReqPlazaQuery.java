package sernanp.app.dao.query.domain; 

public class ObtenerDatosReqPlazaQuery implements java.io.Serializable { 

private static final long serialVersionUID = 1L;
private Integer srl_id_requerimiento_personal; 
private Integer idarea_solicitante; 
private String desarea; 
private Integer idunidad_solicitante; 
private String nomunidad; 
private String var_numero_requerimiento; 
private String var_numero_requerimiento_corto; 
private Integer int_cantidad_requerida; 
private String var_lugar_prestacion; 
private Integer int_id_estado; 
private String descrip_estado; 
private String var_denominacion_requerimiento;

private String dte_fec_aprobacion_oa;

public Integer getSrl_id_requerimiento_personal() { 
  return srl_id_requerimiento_personal; 
} 
public void setSrl_id_requerimiento_personal(Integer srl_id_requerimiento_personal) { 
  this.srl_id_requerimiento_personal = srl_id_requerimiento_personal; 
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
public String getVar_lugar_prestacion() { 
  return var_lugar_prestacion; 
} 
public void setVar_lugar_prestacion(String var_lugar_prestacion) { 
  this.var_lugar_prestacion = var_lugar_prestacion; 
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
public String getVar_denominacion_requerimiento() {
	return var_denominacion_requerimiento;
}
public void setVar_denominacion_requerimiento(String var_denominacion_requerimiento) {
	this.var_denominacion_requerimiento = var_denominacion_requerimiento;
}
public String getDte_fec_aprobacion_oa() {
	return dte_fec_aprobacion_oa;
}
public void setDte_fec_aprobacion_oa(String dte_fec_aprobacion_oa) {
	this.dte_fec_aprobacion_oa = dte_fec_aprobacion_oa;
}

} 
