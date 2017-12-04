package sernanp.app.dao.query.domain; 

public class EstadoQueryCriteria { 

private String orderColumn;
private String orderDirecction;
private String var_nombre_tabla; 

public EstadoQueryCriteria() {
this.orderColumn = "1";
this.orderDirecction = "ASC";
}
public String getVar_nombre_tabla() { 
  return var_nombre_tabla; 
} 
public void setVar_nombre_tabla(String var_nombre_tabla) { 
  this.var_nombre_tabla = var_nombre_tabla; 
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
