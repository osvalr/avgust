package sernanp.app.dao.query.domain; 

public class RpCertificadoQuintaCategoriaCriteria { 

private String orderColumn;
private String orderDirecction;
private String nombres_completos; 
private String numerodoc; 
private String var_descrip_corto_concepto; 
private Integer srl_id_concepto_planilla; 
private Integer idpersonal; 
private Integer srl_id_regimen_contractual; 
private Integer srl_id_nomina_anio_periodo_personal; 
private Integer srl_id_anio_periodo_planilla; 

public RpCertificadoQuintaCategoriaCriteria() {
this.orderColumn = "1";
this.orderDirecction = "ASC";
}
public String getNombres_completos() { 
  return nombres_completos; 
} 
public void setNombres_completos(String nombres_completos) { 
  this.nombres_completos = nombres_completos; 
} 
public String getNumerodoc() { 
  return numerodoc; 
} 
public void setNumerodoc(String numerodoc) { 
  this.numerodoc = numerodoc; 
} 
public String getVar_descrip_corto_concepto() { 
  return var_descrip_corto_concepto; 
} 
public void setVar_descrip_corto_concepto(String var_descrip_corto_concepto) { 
  this.var_descrip_corto_concepto = var_descrip_corto_concepto; 
} 
public Integer getSrl_id_concepto_planilla() { 
  return srl_id_concepto_planilla; 
} 
public void setSrl_id_concepto_planilla(Integer srl_id_concepto_planilla) { 
  this.srl_id_concepto_planilla = srl_id_concepto_planilla; 
} 
public Integer getIdpersonal() { 
  return idpersonal; 
} 
public void setIdpersonal(Integer idpersonal) { 
  this.idpersonal = idpersonal; 
} 
public Integer getSrl_id_regimen_contractual() { 
  return srl_id_regimen_contractual; 
} 
public void setSrl_id_regimen_contractual(Integer srl_id_regimen_contractual) { 
  this.srl_id_regimen_contractual = srl_id_regimen_contractual; 
} 
public Integer getSrl_id_nomina_anio_periodo_personal() { 
  return srl_id_nomina_anio_periodo_personal; 
} 
public void setSrl_id_nomina_anio_periodo_personal(Integer srl_id_nomina_anio_periodo_personal) { 
  this.srl_id_nomina_anio_periodo_personal = srl_id_nomina_anio_periodo_personal; 
} 
public Integer getSrl_id_anio_periodo_planilla() { 
  return srl_id_anio_periodo_planilla; 
} 
public void setSrl_id_anio_periodo_planilla(Integer srl_id_anio_periodo_planilla) { 
  this.srl_id_anio_periodo_planilla = srl_id_anio_periodo_planilla; 
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
