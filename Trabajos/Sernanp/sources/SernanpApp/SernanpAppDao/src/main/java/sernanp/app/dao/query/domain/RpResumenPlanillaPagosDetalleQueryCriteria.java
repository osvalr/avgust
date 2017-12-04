package sernanp.app.dao.query.domain; 

public class RpResumenPlanillaPagosDetalleQueryCriteria { 

private String orderColumn;
private String orderDirecction;
private Integer srl_id_concepto_planilla; 
private Integer srl_id_nomina_anio_periodo_personal; 

public RpResumenPlanillaPagosDetalleQueryCriteria() {
this.orderColumn = "1";
this.orderDirecction = "ASC";
}
public Integer getSrl_id_concepto_planilla() { 
  return srl_id_concepto_planilla; 
} 
public void setSrl_id_concepto_planilla(Integer srl_id_concepto_planilla) { 
  this.srl_id_concepto_planilla = srl_id_concepto_planilla; 
} 
public Integer getSrl_id_nomina_anio_periodo_personal() { 
  return srl_id_nomina_anio_periodo_personal; 
} 
public void setSrl_id_nomina_anio_periodo_personal(Integer srl_id_nomina_anio_periodo_personal) { 
  this.srl_id_nomina_anio_periodo_personal = srl_id_nomina_anio_periodo_personal; 
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
