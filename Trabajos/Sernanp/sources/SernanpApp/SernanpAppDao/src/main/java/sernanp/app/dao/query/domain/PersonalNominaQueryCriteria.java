package sernanp.app.dao.query.domain; 

public class PersonalNominaQueryCriteria { 

private String orderColumn;
private String orderDirecction;
private Integer idpersonanatural; 
private Integer int_estado; 
private Integer idpersona; 
private Integer idpersonal; 

public PersonalNominaQueryCriteria() {
this.orderColumn = "1";
this.orderDirecction = "ASC";
}
public Integer getIdpersonanatural() { 
  return idpersonanatural; 
} 
public void setIdpersonanatural(Integer idpersonanatural) { 
  this.idpersonanatural = idpersonanatural; 
} 
public Integer getInt_estado() { 
  return int_estado; 
} 
public void setInt_estado(Integer int_estado) { 
  this.int_estado = int_estado; 
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
