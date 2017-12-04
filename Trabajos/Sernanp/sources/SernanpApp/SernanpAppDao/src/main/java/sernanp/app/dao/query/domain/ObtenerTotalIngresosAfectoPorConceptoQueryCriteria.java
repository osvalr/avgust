package sernanp.app.dao.query.domain; 

public class ObtenerTotalIngresosAfectoPorConceptoQueryCriteria { 

private String orderColumn;
private String orderDirecction;
private Integer srl_id_concepto_planilla_afecto; 
private Integer srl_id_anio_planilla; 
private Integer idpersonal; 

public ObtenerTotalIngresosAfectoPorConceptoQueryCriteria() {
this.orderColumn = "1";
this.orderDirecction = "ASC";
}
public Integer getSrl_id_concepto_planilla_afecto() { 
  return srl_id_concepto_planilla_afecto; 
} 
public void setSrl_id_concepto_planilla_afecto(Integer srl_id_concepto_planilla_afecto) { 
  this.srl_id_concepto_planilla_afecto = srl_id_concepto_planilla_afecto; 
} 
public Integer getSrl_id_anio_planilla() { 
  return srl_id_anio_planilla; 
} 
public void setSrl_id_anio_planilla(Integer srl_id_anio_planilla) { 
  this.srl_id_anio_planilla = srl_id_anio_planilla; 
} 
public Integer getIdpersonal() { 
  return idpersonal; 
} 
public void setIdpersonal(Integer idpersonal) { 
  this.idpersonal = idpersonal; 
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
