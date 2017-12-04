package sernanp.app.dao.query.domain; 

public class LicenciasPersonalPorMesAnioActividadQueryCriteria { 

private String orderColumn;
private String orderDirecction;
private Integer int_anio; 
private Integer srl_id_per_activ; 
private Integer int_mes; 
private Integer idpersonal; 

public LicenciasPersonalPorMesAnioActividadQueryCriteria() {
this.orderColumn = "1";
this.orderDirecction = "ASC";
}
public Integer getInt_anio() { 
  return int_anio; 
} 
public void setInt_anio(Integer int_anio) { 
  this.int_anio = int_anio; 
} 
public Integer getSrl_id_per_activ() { 
  return srl_id_per_activ; 
} 
public void setSrl_id_per_activ(Integer srl_id_per_activ) { 
  this.srl_id_per_activ = srl_id_per_activ; 
} 
public Integer getInt_mes() { 
  return int_mes; 
} 
public void setInt_mes(Integer int_mes) { 
  this.int_mes = int_mes; 
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
