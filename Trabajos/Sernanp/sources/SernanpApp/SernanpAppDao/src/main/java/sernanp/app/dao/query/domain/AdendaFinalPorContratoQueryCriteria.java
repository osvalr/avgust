package sernanp.app.dao.query.domain; 

public class AdendaFinalPorContratoQueryCriteria { 

private String orderColumn;
private String orderDirecction;
private Integer srl_id_contrato_padre; 

public AdendaFinalPorContratoQueryCriteria() {
this.orderColumn = "1";
this.orderDirecction = "ASC";
}
public Integer getSrl_id_contrato_padre() { 
  return srl_id_contrato_padre; 
} 
public void setSrl_id_contrato_padre(Integer srl_id_contrato_padre) { 
  this.srl_id_contrato_padre = srl_id_contrato_padre; 
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
