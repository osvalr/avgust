package sernanp.app.dao.query.domain; 

public class ConceptoFrecuenciaQueryCriteria { 

private String orderColumn;
private String orderDirecction;
private Integer srl_id_frecuencia; 
private Integer srl_id_concepto_planilla; 
private Integer int_id_estado;

public ConceptoFrecuenciaQueryCriteria() {
this.orderColumn = "1";
this.orderDirecction = "ASC";
}
public Integer getSrl_id_frecuencia() { 
  return srl_id_frecuencia; 
} 
public void setSrl_id_frecuencia(Integer srl_id_frecuencia) { 
  this.srl_id_frecuencia = srl_id_frecuencia; 
} 
public Integer getSrl_id_concepto_planilla() { 
  return srl_id_concepto_planilla; 
} 
public void setSrl_id_concepto_planilla(Integer srl_id_concepto_planilla) { 
  this.srl_id_concepto_planilla = srl_id_concepto_planilla; 
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
public Integer getInt_id_estado() {
	return int_id_estado;
}
public void setInt_id_estado(Integer int_id_estado) {
	this.int_id_estado = int_id_estado;
}

} 
