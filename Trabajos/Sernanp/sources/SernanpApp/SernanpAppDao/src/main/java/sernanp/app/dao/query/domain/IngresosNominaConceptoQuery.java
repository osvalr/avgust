package sernanp.app.dao.query.domain; 

public class IngresosNominaConceptoQuery implements java.io.Serializable { 

private static final long serialVersionUID = 1L;
private Integer srl_id_nomina_concepto; 
private Integer srl_id_nomina_anio_periodo_personal; 
private Integer int_id_tipo_concepto; 
private String descrip_tipo_concepto; 
private Integer int_id_sub_tipo_concepto; 
private String descrip_sub_tipo_concepto; 
private Integer srl_id_concepto_planilla; 
private String var_descrip_corto_concepto; 
private Double dec_monto_calculado; 
private Integer int_id_estado; 
private String descrip_estado; 
private String tsp_fecha_registro; 

public Integer getSrl_id_nomina_concepto() { 
  return srl_id_nomina_concepto; 
} 
public void setSrl_id_nomina_concepto(Integer srl_id_nomina_concepto) { 
  this.srl_id_nomina_concepto = srl_id_nomina_concepto; 
} 
public Integer getSrl_id_nomina_anio_periodo_personal() { 
  return srl_id_nomina_anio_periodo_personal; 
} 
public void setSrl_id_nomina_anio_periodo_personal(Integer srl_id_nomina_anio_periodo_personal) { 
  this.srl_id_nomina_anio_periodo_personal = srl_id_nomina_anio_periodo_personal; 
} 
public Integer getInt_id_tipo_concepto() { 
  return int_id_tipo_concepto; 
} 
public void setInt_id_tipo_concepto(Integer int_id_tipo_concepto) { 
  this.int_id_tipo_concepto = int_id_tipo_concepto; 
} 
public String getDescrip_tipo_concepto() { 
  return descrip_tipo_concepto; 
} 
public void setDescrip_tipo_concepto(String descrip_tipo_concepto) { 
  this.descrip_tipo_concepto = descrip_tipo_concepto; 
} 
public Integer getInt_id_sub_tipo_concepto() { 
  return int_id_sub_tipo_concepto; 
} 
public void setInt_id_sub_tipo_concepto(Integer int_id_sub_tipo_concepto) { 
  this.int_id_sub_tipo_concepto = int_id_sub_tipo_concepto; 
} 
public String getDescrip_sub_tipo_concepto() { 
  return descrip_sub_tipo_concepto; 
} 
public void setDescrip_sub_tipo_concepto(String descrip_sub_tipo_concepto) { 
  this.descrip_sub_tipo_concepto = descrip_sub_tipo_concepto; 
} 
public Integer getSrl_id_concepto_planilla() { 
  return srl_id_concepto_planilla; 
} 
public void setSrl_id_concepto_planilla(Integer srl_id_concepto_planilla) { 
  this.srl_id_concepto_planilla = srl_id_concepto_planilla; 
} 
public String getVar_descrip_corto_concepto() { 
  return var_descrip_corto_concepto; 
} 
public void setVar_descrip_corto_concepto(String var_descrip_corto_concepto) { 
  this.var_descrip_corto_concepto = var_descrip_corto_concepto; 
} 
public Double getDec_monto_calculado() { 
  return dec_monto_calculado; 
} 
public void setDec_monto_calculado(Double dec_monto_calculado) { 
  this.dec_monto_calculado = dec_monto_calculado; 
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
