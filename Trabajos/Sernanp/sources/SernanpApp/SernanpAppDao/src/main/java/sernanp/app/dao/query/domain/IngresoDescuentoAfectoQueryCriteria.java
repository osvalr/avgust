package sernanp.app.dao.query.domain; 

public class IngresoDescuentoAfectoQueryCriteria { 

private String orderColumn;
private String orderDirecction;
private Integer srl_id_afecto_ingreso_descuento; 
private Integer srl_id_ingreso_descuento_planilla; 

public IngresoDescuentoAfectoQueryCriteria() {
this.orderColumn = "1";
this.orderDirecction = "ASC";
}
public Integer getSrl_id_afecto_ingreso_descuento() { 
  return srl_id_afecto_ingreso_descuento; 
} 
public void setSrl_id_afecto_ingreso_descuento(Integer srl_id_afecto_ingreso_descuento) { 
  this.srl_id_afecto_ingreso_descuento = srl_id_afecto_ingreso_descuento; 
} 
public Integer getSrl_id_ingreso_descuento_planilla() { 
  return srl_id_ingreso_descuento_planilla; 
} 
public void setSrl_id_ingreso_descuento_planilla(Integer srl_id_ingreso_descuento_planilla) { 
  this.srl_id_ingreso_descuento_planilla = srl_id_ingreso_descuento_planilla; 
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
