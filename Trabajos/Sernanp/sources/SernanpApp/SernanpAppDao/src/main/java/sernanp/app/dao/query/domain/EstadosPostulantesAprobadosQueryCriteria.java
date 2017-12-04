package sernanp.app.dao.query.domain; 

public class EstadosPostulantesAprobadosQueryCriteria { 

private String orderColumn;
private String orderDirecction;
private Integer var_cod_estado; 

public EstadosPostulantesAprobadosQueryCriteria() {
this.orderColumn = "1";
this.orderDirecction = "ASC";
}
public Integer getVar_cod_estado() { 
  return var_cod_estado; 
} 
public void setVar_cod_estado(Integer var_cod_estado) { 
  this.var_cod_estado = var_cod_estado; 
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
