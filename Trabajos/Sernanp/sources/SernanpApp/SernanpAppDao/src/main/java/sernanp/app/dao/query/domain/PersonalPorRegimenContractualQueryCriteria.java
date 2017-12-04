package sernanp.app.dao.query.domain; 

public class PersonalPorRegimenContractualQueryCriteria { 

private String orderColumn;
private String orderDirecction;
private Integer idpersonanatural; 
private String dte_fec_inicio; 
private Integer srl_id_regimen_contractual; 
private Integer idpersona; 
private Integer idpersonal; 

public PersonalPorRegimenContractualQueryCriteria() {
this.orderColumn = "1";
this.orderDirecction = "ASC";
}
public Integer getIdpersonanatural() { 
  return idpersonanatural; 
} 
public void setIdpersonanatural(Integer idpersonanatural) { 
  this.idpersonanatural = idpersonanatural; 
} 
public String getDte_fec_inicio() { 
  return dte_fec_inicio; 
} 
public void setDte_fec_inicio(String dte_fec_inicio) { 
  this.dte_fec_inicio = dte_fec_inicio; 
} 
public Integer getSrl_id_regimen_contractual() { 
  return srl_id_regimen_contractual; 
} 
public void setSrl_id_regimen_contractual(Integer srl_id_regimen_contractual) { 
  this.srl_id_regimen_contractual = srl_id_regimen_contractual; 
} 
public Integer getIdpersona() { 
  return idpersona; 
} 
public void setIdpersona(Integer idpersona) { 
  this.idpersona = idpersona; 
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
