package sernanp.app.dao.query.domain; 

public class PersonalContratoNominaQueryCriteria { 

private String orderColumn;
private String orderDirecction;
private Integer srl_id_contrato; 
private Integer idpersonanatural; 
private java.util.Date dte_fec_inicio; 
private Integer int_id_estado; 
private Integer idpersona; 
private String srl_id_contrato_padre; 
private Integer idpersonal; 
private Integer srl_id_regimen_contractual; 

public PersonalContratoNominaQueryCriteria() {
this.orderColumn = "1";
this.orderDirecction = "ASC";
}
public Integer getSrl_id_contrato() { 
  return srl_id_contrato; 
} 
public void setSrl_id_contrato(Integer srl_id_contrato) { 
  this.srl_id_contrato = srl_id_contrato; 
} 
public Integer getIdpersonanatural() { 
  return idpersonanatural; 
} 
public void setIdpersonanatural(Integer idpersonanatural) { 
  this.idpersonanatural = idpersonanatural; 
} 
public java.util.Date getDte_fec_inicio() { 
  return dte_fec_inicio; 
} 
public void setDte_fec_inicio(java.util.Date dte_fec_inicio) { 
  this.dte_fec_inicio = dte_fec_inicio; 
} 
public Integer getInt_id_estado() { 
  return int_id_estado; 
} 
public void setInt_id_estado(Integer int_id_estado) { 
  this.int_id_estado = int_id_estado; 
} 
public Integer getIdpersona() { 
  return idpersona; 
} 
public void setIdpersona(Integer idpersona) { 
  this.idpersona = idpersona; 
} 
public String getSrl_id_contrato_padre() { 
  return srl_id_contrato_padre; 
} 
public void setSrl_id_contrato_padre(String srl_id_contrato_padre) { 
  this.srl_id_contrato_padre = srl_id_contrato_padre; 
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
