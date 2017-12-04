package sernanp.app.dao.query.domain; 

public class ConceptoAfectoQueryCriteria { 

private String orderColumn;
private String orderDirecction;
private Integer srl_id_afecto_concepto; 
private Integer srl_id_concepto_planilla; 

public ConceptoAfectoQueryCriteria() {
this.orderColumn = "1";
this.orderDirecction = "ASC";
}
public Integer getSrl_id_afecto_concepto() { 
  return srl_id_afecto_concepto; 
} 
public void setSrl_id_afecto_concepto(Integer srl_id_afecto_concepto) { 
  this.srl_id_afecto_concepto = srl_id_afecto_concepto; 
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
