package sernanp.app.dao.query.domain; 

public class GestionarConfigFactorEvalQuery implements java.io.Serializable { 

private static final long serialVersionUID = 1L;
private Integer srl_id_configuracion_factor_evaluacion; 
private String var_descrip_configuracion; 
private Integer int_id_estado; 
private String descrip_estado; 
private String tsp_fecha_registro; 

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

} 
