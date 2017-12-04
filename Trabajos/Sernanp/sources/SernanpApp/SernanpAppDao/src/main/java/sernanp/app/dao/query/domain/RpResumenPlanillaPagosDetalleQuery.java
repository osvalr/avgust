package sernanp.app.dao.query.domain; 

public class RpResumenPlanillaPagosDetalleQuery implements java.io.Serializable { 

private static final long serialVersionUID = 1L;
private Integer srl_id_nomina_anio_periodo_personal; 
private Integer srl_id_nomina_concepto; 
private Integer srl_id_concepto_planilla; 
private Integer int_id_tipo_concepto; 
private String var_descrip_concepto; 
private Double dec_monto_calculado; 

public Integer getSrl_id_nomina_anio_periodo_personal() { 
  return srl_id_nomina_anio_periodo_personal; 
} 
public void setSrl_id_nomina_anio_periodo_personal(Integer srl_id_nomina_anio_periodo_personal) { 
  this.srl_id_nomina_anio_periodo_personal = srl_id_nomina_anio_periodo_personal; 
} 
public Integer getSrl_id_nomina_concepto() { 
  return srl_id_nomina_concepto; 
} 
public void setSrl_id_nomina_concepto(Integer srl_id_nomina_concepto) { 
  this.srl_id_nomina_concepto = srl_id_nomina_concepto; 
} 
public Integer getSrl_id_concepto_planilla() { 
  return srl_id_concepto_planilla; 
} 
public void setSrl_id_concepto_planilla(Integer srl_id_concepto_planilla) { 
  this.srl_id_concepto_planilla = srl_id_concepto_planilla; 
} 
public Integer getInt_id_tipo_concepto() { 
  return int_id_tipo_concepto; 
} 
public void setInt_id_tipo_concepto(Integer int_id_tipo_concepto) { 
  this.int_id_tipo_concepto = int_id_tipo_concepto; 
} 
public String getVar_descrip_concepto() { 
  return var_descrip_concepto; 
} 
public void setVar_descrip_concepto(String var_descrip_concepto) { 
  this.var_descrip_concepto = var_descrip_concepto; 
} 
public Double getDec_monto_calculado() { 
  return dec_monto_calculado; 
} 
public void setDec_monto_calculado(Double dec_monto_calculado) { 
  this.dec_monto_calculado = dec_monto_calculado; 
} 

} 
