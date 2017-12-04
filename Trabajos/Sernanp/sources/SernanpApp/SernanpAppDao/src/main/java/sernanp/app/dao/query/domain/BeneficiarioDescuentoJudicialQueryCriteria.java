package sernanp.app.dao.query.domain; 

public class BeneficiarioDescuentoJudicialQueryCriteria { 

private String orderColumn;
private String orderDirecction;
private Integer srl_id_beneficiario_descuento_judicial; 
private Integer idpersonal; 

public BeneficiarioDescuentoJudicialQueryCriteria() {
this.orderColumn = "1";
this.orderDirecction = "ASC";
}
public Integer getSrl_id_beneficiario_descuento_judicial() { 
  return srl_id_beneficiario_descuento_judicial; 
} 
public void setSrl_id_beneficiario_descuento_judicial(Integer srl_id_beneficiario_descuento_judicial) { 
  this.srl_id_beneficiario_descuento_judicial = srl_id_beneficiario_descuento_judicial; 
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
