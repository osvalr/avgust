package sernanp.app.dao.query.domain; 

public class SubsidiosPersonalCriteria { 

private String orderColumn;
private String orderDirecction;
private Integer srl_id_per_activ; 
private Integer idpersonal; 
private Integer int_mes; 
private Integer int_anho; 

public SubsidiosPersonalCriteria() {
this.orderColumn = "1";
this.orderDirecction = "ASC";
}
public Integer getSrl_id_per_activ() { 
  return srl_id_per_activ; 
} 
public void setSrl_id_per_activ(Integer srl_id_per_activ) { 
  this.srl_id_per_activ = srl_id_per_activ; 
} 
public Integer getIdpersonal() { 
  return idpersonal; 
} 
public void setIdpersonal(Integer idpersonal) { 
  this.idpersonal = idpersonal; 
} 
public Integer getInt_mes() { 
  return int_mes; 
} 
public void setInt_mes(Integer int_mes) { 
  this.int_mes = int_mes; 
} 
public Integer getInt_anho() { 
  return int_anho; 
} 
public void setInt_anho(Integer int_anho) { 
  this.int_anho = int_anho; 
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
