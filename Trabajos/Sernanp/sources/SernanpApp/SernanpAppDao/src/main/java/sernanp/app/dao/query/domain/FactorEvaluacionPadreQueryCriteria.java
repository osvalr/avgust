package sernanp.app.dao.query.domain; 

public class FactorEvaluacionPadreQueryCriteria { 

private String orderColumn;
private String orderDirecction;
private Integer srl_id_factor_evaluacion; 

public FactorEvaluacionPadreQueryCriteria() {
this.orderColumn = "1";
this.orderDirecction = "ASC";
}
public Integer getSrl_id_factor_evaluacion() { 
  return srl_id_factor_evaluacion; 
} 
public void setSrl_id_factor_evaluacion(Integer srl_id_factor_evaluacion) { 
  this.srl_id_factor_evaluacion = srl_id_factor_evaluacion; 
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
