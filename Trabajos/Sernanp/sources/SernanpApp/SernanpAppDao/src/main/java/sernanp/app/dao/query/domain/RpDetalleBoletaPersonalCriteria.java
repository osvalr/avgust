package sernanp.app.dao.query.domain; 

public class RpDetalleBoletaPersonalCriteria { 

private String orderColumn;
private String orderDirecction;
private String srl_id_nomina_anio_periodo_personal; 
private Integer idpersonal; 
private Integer srl_id_concepto_planilla; 

public RpDetalleBoletaPersonalCriteria() {
this.orderColumn = "1";
this.orderDirecction = "ASC";
}
public String getSrl_id_nomina_anio_periodo_personal() { 
  return srl_id_nomina_anio_periodo_personal; 
} 
public void setSrl_id_nomina_anio_periodo_personal(String srl_id_nomina_anio_periodo_personal) { 
  this.srl_id_nomina_anio_periodo_personal = srl_id_nomina_anio_periodo_personal; 
} 
public Integer getIdpersonal() { 
  return idpersonal; 
} 
public void setIdpersonal(Integer idpersonal) { 
  this.idpersonal = idpersonal; 
} 
public Integer getSrl_id_concepto_planilla() { 
  return srl_id_concepto_planilla; 
} 
public void setSrl_id_concepto_planilla(Integer srl_id_concepto_planilla) { 
  this.srl_id_concepto_planilla = srl_id_concepto_planilla; 
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
