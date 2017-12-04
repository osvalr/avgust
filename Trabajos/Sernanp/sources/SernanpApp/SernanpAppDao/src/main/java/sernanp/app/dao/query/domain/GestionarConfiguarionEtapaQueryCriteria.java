package sernanp.app.dao.query.domain; 

public class GestionarConfiguarionEtapaQueryCriteria { 

private String orderColumn;
private String orderDirecction;
private Integer int_id_estado; 
private String var_nombre_configuracion; 
private Integer srl_id_configuracion_evaluacion_personal; 

public GestionarConfiguarionEtapaQueryCriteria() {
this.orderColumn = "1";
this.orderDirecction = "ASC";
}
public Integer getInt_id_estado() { 
  return int_id_estado; 
} 
public void setInt_id_estado(Integer int_id_estado) { 
  this.int_id_estado = int_id_estado; 
} 
public String getVar_nombre_configuracion() { 
  return var_nombre_configuracion; 
} 
public void setVar_nombre_configuracion(String var_nombre_configuracion) { 
  this.var_nombre_configuracion = var_nombre_configuracion; 
} 
public Integer getSrl_id_configuracion_evaluacion_personal() { 
  return srl_id_configuracion_evaluacion_personal; 
} 
public void setSrl_id_configuracion_evaluacion_personal(Integer srl_id_configuracion_evaluacion_personal) { 
  this.srl_id_configuracion_evaluacion_personal = srl_id_configuracion_evaluacion_personal; 
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
