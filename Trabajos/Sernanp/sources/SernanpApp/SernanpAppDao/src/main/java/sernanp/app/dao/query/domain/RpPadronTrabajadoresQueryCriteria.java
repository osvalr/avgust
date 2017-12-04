package sernanp.app.dao.query.domain; 

public class RpPadronTrabajadoresQueryCriteria { 

private String orderColumn;
private String orderDirecction;
private Integer srl_id_contrato; 
private String c_fte_fto; 
private Integer srl_id_regimen_contractual; 
private Integer int_id_periodo_mes; 
private Integer idpersonal; 
private Integer int_id_estado; 
private String nombre_completo; 
private Integer int_anio; 
private Integer srl_id_contrato_padre; 
private String dte_fec_inicio; 
private Integer srl_id_nomina_anio_periodo_personal; 
private String var_descrip_concepto; 

public RpPadronTrabajadoresQueryCriteria() {
this.orderColumn = "1";
this.orderDirecction = "ASC";
}
public Integer getSrl_id_contrato() { 
  return srl_id_contrato; 
} 
public void setSrl_id_contrato(Integer srl_id_contrato) { 
  this.srl_id_contrato = srl_id_contrato; 
} 
public String getC_fte_fto() { 
  return c_fte_fto; 
} 
public void setC_fte_fto(String c_fte_fto) { 
  this.c_fte_fto = c_fte_fto; 
} 
public Integer getSrl_id_regimen_contractual() { 
  return srl_id_regimen_contractual; 
} 
public void setSrl_id_regimen_contractual(Integer srl_id_regimen_contractual) { 
  this.srl_id_regimen_contractual = srl_id_regimen_contractual; 
} 
public Integer getInt_id_periodo_mes() { 
  return int_id_periodo_mes; 
} 
public void setInt_id_periodo_mes(Integer int_id_periodo_mes) { 
  this.int_id_periodo_mes = int_id_periodo_mes; 
} 
public Integer getIdpersonal() { 
  return idpersonal; 
} 
public void setIdpersonal(Integer idpersonal) { 
  this.idpersonal = idpersonal; 
} 
public Integer getInt_id_estado() { 
  return int_id_estado; 
} 
public void setInt_id_estado(Integer int_id_estado) { 
  this.int_id_estado = int_id_estado; 
} 
public String getNombre_completo() { 
  return nombre_completo; 
} 
public void setNombre_completo(String nombre_completo) { 
  this.nombre_completo = nombre_completo; 
} 
public Integer getInt_anio() { 
  return int_anio; 
} 
public void setInt_anio(Integer int_anio) { 
  this.int_anio = int_anio; 
} 
public Integer getSrl_id_contrato_padre() { 
  return srl_id_contrato_padre; 
} 
public void setSrl_id_contrato_padre(Integer srl_id_contrato_padre) { 
  this.srl_id_contrato_padre = srl_id_contrato_padre; 
} 
public String getDte_fec_inicio() { 
  return dte_fec_inicio; 
} 
public void setDte_fec_inicio(String dte_fec_inicio) { 
  this.dte_fec_inicio = dte_fec_inicio; 
} 
public Integer getSrl_id_nomina_anio_periodo_personal() { 
  return srl_id_nomina_anio_periodo_personal; 
} 
public void setSrl_id_nomina_anio_periodo_personal(Integer srl_id_nomina_anio_periodo_personal) { 
  this.srl_id_nomina_anio_periodo_personal = srl_id_nomina_anio_periodo_personal; 
} 
public String getVar_descrip_concepto() { 
  return var_descrip_concepto; 
} 
public void setVar_descrip_concepto(String var_descrip_concepto) { 
  this.var_descrip_concepto = var_descrip_concepto; 
} 
public String getOrderColumn() {
return orderColumn;
}
public void setOrderColumn(String orderColumn) {
this.orderColumn = orderColumn;
}
public String getOrderDirecction() {
return orderDirecction;
}
public void setOrderDirecction(String orderDirecction) {
this.orderDirecction = orderDirecction;
}

} 
