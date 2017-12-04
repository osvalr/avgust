package sernanp.app.dao.query.domain; 

public class PersonalInfoFormacionQueryCriteria { 

private String orderColumn;
private String orderDirecction;
private Integer idpersonal; 
private Integer srl_id_personanatural_formacion; 

public PersonalInfoFormacionQueryCriteria() {
this.orderColumn = "1";
this.orderDirecction = "ASC";
}
public Integer getIdpersonal() { 
  return idpersonal; 
} 
public void setIdpersonal(Integer idpersonal) { 
  this.idpersonal = idpersonal; 
} 
public Integer getSrl_id_personanatural_formacion() { 
  return srl_id_personanatural_formacion; 
} 
public void setSrl_id_personanatural_formacion(Integer srl_id_personanatural_formacion) { 
  this.srl_id_personanatural_formacion = srl_id_personanatural_formacion; 
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
