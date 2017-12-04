package sernanp.app.dao.query.domain; 

public class ReporteConvocatoriaMintraObtenerFactorQuery implements java.io.Serializable { 

private static final long serialVersionUID = 1L;
private Integer srl_id_factor_evaluacion; 
private Integer srl_id_configuracion_factor_evaluacion; 
private Integer int_id_tipo_factor_padre; 
private String descrip_tipo_factor_padre; 
private Integer int_id_tipo_factor; 
private String descrip_tipo_factor; 
private Double dec_puntaje_min; 
private Double dec_puntaje_max; 
private Double dec_peso; 
private Integer int_id_estado; 
private String descrip_estado; 
private String tsp_fecha_registro; 

private Double puntajemintotal;

private Integer srl_id_requerimiento_personal;

public Integer getSrl_id_factor_evaluacion() { 
  return srl_id_factor_evaluacion; 
} 
public void setSrl_id_factor_evaluacion(Integer srl_id_factor_evaluacion) { 
  this.srl_id_factor_evaluacion = srl_id_factor_evaluacion; 
} 
public Integer getSrl_id_configuracion_factor_evaluacion() { 
  return srl_id_configuracion_factor_evaluacion; 
} 
public void setSrl_id_configuracion_factor_evaluacion(Integer srl_id_configuracion_factor_evaluacion) { 
  this.srl_id_configuracion_factor_evaluacion = srl_id_configuracion_factor_evaluacion; 
} 
public Integer getInt_id_tipo_factor_padre() { 
  return int_id_tipo_factor_padre; 
} 
public void setInt_id_tipo_factor_padre(Integer int_id_tipo_factor_padre) { 
  this.int_id_tipo_factor_padre = int_id_tipo_factor_padre; 
} 
public String getDescrip_tipo_factor_padre() { 
  return descrip_tipo_factor_padre; 
} 
public void setDescrip_tipo_factor_padre(String descrip_tipo_factor_padre) { 
  this.descrip_tipo_factor_padre = descrip_tipo_factor_padre; 
} 
public Integer getInt_id_tipo_factor() { 
  return int_id_tipo_factor; 
} 
public void setInt_id_tipo_factor(Integer int_id_tipo_factor) { 
  this.int_id_tipo_factor = int_id_tipo_factor; 
} 
public String getDescrip_tipo_factor() { 
  return descrip_tipo_factor; 
} 
public void setDescrip_tipo_factor(String descrip_tipo_factor) { 
  this.descrip_tipo_factor = descrip_tipo_factor; 
} 
public Double getDec_puntaje_min() { 
  return dec_puntaje_min; 
} 
public void setDec_puntaje_min(Double dec_puntaje_min) { 
  this.dec_puntaje_min = dec_puntaje_min; 
} 
public Double getDec_puntaje_max() { 
  return dec_puntaje_max; 
} 
public void setDec_puntaje_max(Double dec_puntaje_max) { 
  this.dec_puntaje_max = dec_puntaje_max; 
} 
public Double getDec_peso() { 
  return dec_peso; 
} 
public void setDec_peso(Double dec_peso) { 
  this.dec_peso = dec_peso; 
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
public String getTsp_fecha_registro() { 
  return tsp_fecha_registro; 
} 
public void setTsp_fecha_registro(String tsp_fecha_registro) { 
  this.tsp_fecha_registro = tsp_fecha_registro; 
}
public Integer getSrl_id_requerimiento_personal() {
	return srl_id_requerimiento_personal;
}
public void setSrl_id_requerimiento_personal(Integer srl_id_requerimiento_personal) {
	this.srl_id_requerimiento_personal = srl_id_requerimiento_personal;
}
public Double getPuntajemintotal() {
	return puntajemintotal;
}
public void setPuntajemintotal(Double puntajemintotal) {
	this.puntajemintotal = puntajemintotal;
} 

} 
