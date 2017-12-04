package sernanp.app.dao.query.domain; 

public class GestionarAnioParametroPlanillaQuery implements java.io.Serializable { 

private static final long serialVersionUID = 1L;
private Integer srl_id_anio_parametro_planilla; 
private Integer srl_id_anio_planilla; 
private Integer srl_id_parametro_planilla; 
private String var_descrip_parametro; 
private Double dec_valor_parametro; 
private String dte_fecha_vigencia; 
private Integer int_id_estado; 
private String var_des_tipo_estado; 
private String tsp_fecha_registro; 

public Integer getSrl_id_anio_parametro_planilla() { 
  return srl_id_anio_parametro_planilla; 
} 
public void setSrl_id_anio_parametro_planilla(Integer srl_id_anio_parametro_planilla) { 
  this.srl_id_anio_parametro_planilla = srl_id_anio_parametro_planilla; 
} 
public Integer getSrl_id_anio_planilla() { 
  return srl_id_anio_planilla; 
} 
public void setSrl_id_anio_planilla(Integer srl_id_anio_planilla) { 
  this.srl_id_anio_planilla = srl_id_anio_planilla; 
} 
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
public Double getDec_valor_parametro() { 
  return dec_valor_parametro; 
} 
public void setDec_valor_parametro(Double dec_valor_parametro) { 
  this.dec_valor_parametro = dec_valor_parametro; 
} 
public String getDte_fecha_vigencia() { 
  return dte_fecha_vigencia; 
} 
public void setDte_fecha_vigencia(String dte_fecha_vigencia) { 
  this.dte_fecha_vigencia = dte_fecha_vigencia; 
} 
public Integer getInt_id_estado() { 
  return int_id_estado; 
} 
public void setInt_id_estado(Integer int_id_estado) { 
  this.int_id_estado = int_id_estado; 
} 
public String getVar_des_tipo_estado() { 
  return var_des_tipo_estado; 
} 
public void setVar_des_tipo_estado(String var_des_tipo_estado) { 
  this.var_des_tipo_estado = var_des_tipo_estado; 
} 
public String getTsp_fecha_registro() { 
  return tsp_fecha_registro; 
} 
public void setTsp_fecha_registro(String tsp_fecha_registro) { 
  this.tsp_fecha_registro = tsp_fecha_registro; 
} 

} 
