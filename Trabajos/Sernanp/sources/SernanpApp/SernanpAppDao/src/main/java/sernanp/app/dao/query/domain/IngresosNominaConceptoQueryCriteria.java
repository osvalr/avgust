package sernanp.app.dao.query.domain; 

public class IngresosNominaConceptoQueryCriteria { 

private String orderColumn;
private String orderDirecction;
private Integer srl_id_nomina_anio_periodo_personal; 
private Integer srl_id_nomina_concepto; 

public IngresosNominaConceptoQueryCriteria() {
this.orderColumn = "1";
this.orderDirecction = "ASC";
}
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
