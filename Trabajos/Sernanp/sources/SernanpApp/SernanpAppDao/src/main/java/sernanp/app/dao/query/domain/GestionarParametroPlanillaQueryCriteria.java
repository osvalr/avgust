package sernanp.app.dao.query.domain; 

public class GestionarParametroPlanillaQueryCriteria { 

private String orderColumn;
private String orderDirecction;
private Integer srl_id_parametro_planilla; 
private String var_descrip_parametro; 

private Integer int_tipo_parametro; 
private Integer int_id_estado; 


public GestionarParametroPlanillaQueryCriteria() {
this.orderColumn = "1";
this.orderDirecction = "ASC";
}
public Integer getSrl_id_parametro_planilla() { 
  return srl_id_parametro_planilla; 
} 
public void setSrl_id_parametro_planilla(Integer srl_id_parametro_planilla) { 
  this.srl_id_parametro_planilla = srl_id_parametro_planilla; 
} 
public Integer getInt_tipo_parametro() { 
  return int_tipo_parametro; 
} 
public void setInt_tipo_parametro(Integer int_tipo_parametro) { 
  this.int_tipo_parametro = int_tipo_parametro; 
} 
public Integer getInt_id_estado() { 
  return int_id_estado; 
} 
public void setInt_id_estado(Integer int_id_estado) { 
  this.int_id_estado = int_id_estado; 
} 
public String getVar_descrip_parametro() { 
  return var_descrip_parametro; 
} 
public void setVar_descrip_parametro(String var_descrip_parametro) { 
  this.var_descrip_parametro = var_descrip_parametro; 
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
