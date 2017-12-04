package sernanp.app.dao.query.domain; 

public class FactorEvaluacionQueryCriteria { 

private String orderColumn;
private String orderDirecction;
private Integer srl_id_factor_evaluacion; 
private Integer srl_id_configuracion_factor_evaluacion; 
private Integer int_id_tipo_factor; 
private Integer int_id_estado; 

public FactorEvaluacionQueryCriteria() {
this.orderColumn = "1";
this.orderDirecction = "ASC";
}
public Integer getSrl_id_factor_evaluacion() { 
  return srl_id_factor_evaluacion; 
} 
public void setSrl_id_factor_evaluacion(Integer srl_id_factor_evaluacion) { 
  this.srl_id_factor_evaluacion = srl_id_factor_evaluacion; 
} 
public Integer getSrl_id_configuracion_factor_evaluacion() { 
  return srl_id_configuracion_factor_evaluacion; 
} 
public void setSrl_id_configuracion_factor_evaluacion(Integer srl_id_configuracion_factor_evaluacion) { 
  this.srl_id_configuracion_factor_evaluacion = srl_id_configuracion_factor_evaluacion; 
} 
public Integer getInt_id_tipo_factor() { 
  return int_id_tipo_factor; 
} 
public void setInt_id_tipo_factor(Integer int_id_tipo_factor) { 
  this.int_id_tipo_factor = int_id_tipo_factor; 
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
