package sernanp.app.dao.query.domain; 

public class AportePersonalQueryCriteria { 

private String orderColumn;
private String orderDirecction;
private Integer srl_id_personal_concepto; 
private Integer idpersonal; 

public AportePersonalQueryCriteria() {
this.orderColumn = "1";
this.orderDirecction = "ASC";
}
public Integer getSrl_id_personal_concepto() { 
  return srl_id_personal_concepto; 
} 
public void setSrl_id_personal_concepto(Integer srl_id_personal_concepto) { 
  this.srl_id_personal_concepto = srl_id_personal_concepto; 
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
