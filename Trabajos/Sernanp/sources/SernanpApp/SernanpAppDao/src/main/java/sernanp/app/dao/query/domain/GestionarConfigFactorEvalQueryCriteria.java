package sernanp.app.dao.query.domain; 

public class GestionarConfigFactorEvalQueryCriteria { 

private String orderColumn;
private String orderDirecction;
private Integer srl_id_configuracion_factor_evaluacion; 
private String var_descrip_configuracion; 
private Integer int_id_estado; 

public GestionarConfigFactorEvalQueryCriteria() {
this.orderColumn = "1";
this.orderDirecction = "ASC";
}
public Integer getSrl_id_configuracion_factor_evaluacion() { 
  return srl_id_configuracion_factor_evaluacion; 
} 
public void setSrl_id_configuracion_factor_evaluacion(Integer srl_id_configuracion_factor_evaluacion) { 
  this.srl_id_configuracion_factor_evaluacion = srl_id_configuracion_factor_evaluacion; 
} 
public String getVar_descrip_configuracion() { 
  return var_descrip_configuracion; 
} 
public void setVar_descrip_configuracion(String var_descrip_configuracion) { 
  this.var_descrip_configuracion = var_descrip_configuracion; 
} 
public Integer getInt_id_estado() { 
  return int_id_estado; 
} 
public void setInt_id_estado(Integer int_id_estado) { 
  this.int_id_estado = int_id_estado; 
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
