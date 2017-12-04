package sernanp.app.dao.query.domain; 

public class IngresosPersonalQueryCriteria { 

private String orderColumn;
private String orderDirecction;
private Integer srl_id_personal_ingreso_descuento; 
private Integer idpersonal; 

public IngresosPersonalQueryCriteria() {
this.orderColumn = "1";
this.orderDirecction = "ASC";
}
public Integer getSrl_id_personal_ingreso_descuento() { 
  return srl_id_personal_ingreso_descuento; 
} 
public void setSrl_id_personal_ingreso_descuento(Integer srl_id_personal_ingreso_descuento) { 
  this.srl_id_personal_ingreso_descuento = srl_id_personal_ingreso_descuento; 
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
