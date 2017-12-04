package sernanp.app.dao.query.domain; 

public class RptResumenPersonalAltasBajasQueryCriteria { 

private String orderColumn;
private String orderDirecction;
private String numerodoc; 
private String ruc; 
private Integer srl_id_regimen_contractual; 
private Integer idpersonal; 
private String nombre_completo; 
private Integer srl_id_cargo; 
private Integer int_estado; 
private Integer idtipodocumento; 

public RptResumenPersonalAltasBajasQueryCriteria() {
this.orderColumn = "1";
this.orderDirecction = "ASC";
}
public String getNumerodoc() { 
  return numerodoc; 
} 
public void setNumerodoc(String numerodoc) { 
  this.numerodoc = numerodoc; 
} 
public String getRuc() { 
  return ruc; 
} 
public void setRuc(String ruc) { 
  this.ruc = ruc; 
} 
public Integer getSrl_id_regimen_contractual() { 
  return srl_id_regimen_contractual; 
} 
public void setSrl_id_regimen_contractual(Integer srl_id_regimen_contractual) { 
  this.srl_id_regimen_contractual = srl_id_regimen_contractual; 
} 
public Integer getIdpersonal() { 
  return idpersonal; 
} 
public void setIdpersonal(Integer idpersonal) { 
  this.idpersonal = idpersonal; 
} 
public String getNombre_completo() { 
  return nombre_completo; 
} 
public void setNombre_completo(String nombre_completo) { 
  this.nombre_completo = nombre_completo; 
} 
public Integer getSrl_id_cargo() { 
  return srl_id_cargo; 
} 
public void setSrl_id_cargo(Integer srl_id_cargo) { 
  this.srl_id_cargo = srl_id_cargo; 
} 
public Integer getInt_estado() { 
  return int_estado; 
} 
public void setInt_estado(Integer int_estado) { 
  this.int_estado = int_estado; 
} 
public Integer getIdtipodocumento() { 
  return idtipodocumento; 
} 
public void setIdtipodocumento(Integer idtipodocumento) { 
  this.idtipodocumento = idtipodocumento; 
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
