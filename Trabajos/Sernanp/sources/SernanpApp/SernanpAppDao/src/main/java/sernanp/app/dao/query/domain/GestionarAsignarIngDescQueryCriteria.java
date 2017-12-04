package sernanp.app.dao.query.domain; 

public class GestionarAsignarIngDescQueryCriteria { 

private String orderColumn;
private String orderDirecction;

private Integer idpersona; 
private Integer idpersonanatural;
private Integer idpersonal; 
private String nombres_completos; 
private Integer idtipodocumento; 
private String numerodoc; 
private String ruc; 
private Integer srl_id_regimen_contractual; 
private Integer srl_id_cargo; 
private Integer int_estado; 

public GestionarAsignarIngDescQueryCriteria() {
this.orderColumn = "1";
this.orderDirecction = "ASC";
}
public String getRuc() { 
  return ruc; 
} 
public void setRuc(String ruc) { 
  this.ruc = ruc; 
} 
public Integer getIdpersonanatural() { 
  return idpersonanatural; 
} 
public void setIdpersonanatural(Integer idpersonanatural) { 
  this.idpersonanatural = idpersonanatural; 
} 
public Integer getIdtipodocumento() { 
  return idtipodocumento; 
} 
public void setIdtipodocumento(Integer idtipodocumento) { 
  this.idtipodocumento = idtipodocumento; 
} 
public Integer getIdpersona() { 
  return idpersona; 
} 
public void setIdpersona(Integer idpersona) { 
  this.idpersona = idpersona; 
} 
public Integer getSrl_id_cargo() { 
  return srl_id_cargo; 
} 
public void setSrl_id_cargo(Integer srl_id_cargo) { 
  this.srl_id_cargo = srl_id_cargo; 
} 
public String getNombres_completos() { 
  return nombres_completos; 
} 
public void setNombres_completos(String nombres_completos) { 
  this.nombres_completos = nombres_completos; 
} 
public String getNumerodoc() { 
  return numerodoc; 
} 
public void setNumerodoc(String numerodoc) { 
  this.numerodoc = numerodoc; 
} 
public Integer getSrl_id_regimen_contractual() { 
  return srl_id_regimen_contractual; 
} 
public void setSrl_id_regimen_contractual(Integer srl_id_regimen_contractual) { 
  this.srl_id_regimen_contractual = srl_id_regimen_contractual; 
} 
public Integer getInt_estado() { 
  return int_estado; 
} 
public void setInt_estado(Integer int_estado) { 
  this.int_estado = int_estado; 
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
