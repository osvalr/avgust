package sernanp.app.dao.query.domain; 

public class GestionarParametroPlanillaQuery implements java.io.Serializable { 

private static final long serialVersionUID = 1L;
private Integer srl_id_parametro_planilla; 
private String var_descrip_parametro; 
private Integer int_tipo_parametro; 
private String descrip_tipo_parametro; 
private Integer int_id_estado; 
private String descrip_estado; 
private String tsp_fecha_registro; 

public Integer getSrl_id_parametro_planilla() { 
  return srl_id_parametro_planilla; 
} 
public void setSrl_id_parametro_planilla(Integer srl_id_parametro_planilla) { 
  this.srl_id_parametro_planilla = srl_id_parametro_planilla; 
} 
public String getVar_descrip_parametro() { 
  return var_descrip_parametro; 
} 
public void setVar_descrip_parametro(String var_descrip_parametro) { 
  this.var_descrip_parametro = var_descrip_parametro; 
} 
public Integer getInt_tipo_parametro() { 
  return int_tipo_parametro; 
} 
public void setInt_tipo_parametro(Integer int_tipo_parametro) { 
  this.int_tipo_parametro = int_tipo_parametro; 
} 
public String getDescrip_tipo_parametro() { 
  return descrip_tipo_parametro; 
} 
public void setDescrip_tipo_parametro(String descrip_tipo_parametro) { 
  this.descrip_tipo_parametro = descrip_tipo_parametro; 
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
