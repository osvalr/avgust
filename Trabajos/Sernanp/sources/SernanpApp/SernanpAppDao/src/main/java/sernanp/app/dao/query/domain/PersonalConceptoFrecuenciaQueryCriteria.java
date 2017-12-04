package sernanp.app.dao.query.domain; 

public class PersonalConceptoFrecuenciaQueryCriteria { 

private String orderColumn;
private String orderDirecction;
private Integer srl_id_frecuencia; 
private Integer srl_id_personal_concepto; 
private Integer int_id_estado;

public PersonalConceptoFrecuenciaQueryCriteria() {
this.orderColumn = "1";
this.orderDirecction = "ASC";
}
public Integer getSrl_id_frecuencia() { 
  return srl_id_frecuencia; 
} 
public void setSrl_id_frecuencia(Integer srl_id_frecuencia) { 
  this.srl_id_frecuencia = srl_id_frecuencia; 
} 
public Integer getSrl_id_personal_concepto() { 
  return srl_id_personal_concepto; 
} 
public void setSrl_id_personal_concepto(Integer srl_id_personal_concepto) { 
  this.srl_id_personal_concepto = srl_id_personal_concepto; 
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
