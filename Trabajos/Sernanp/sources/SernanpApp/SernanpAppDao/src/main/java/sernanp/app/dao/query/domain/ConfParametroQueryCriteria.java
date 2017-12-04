package sernanp.app.dao.query.domain; 

public class ConfParametroQueryCriteria { 

private String orderColumn;
private String orderDirecction;
private java.util.Date tsp_fecha_registro; 

public ConfParametroQueryCriteria() {
this.orderColumn = "1";
this.orderDirecction = "ASC";
}
public java.util.Date getTsp_fecha_registro() { 
  return tsp_fecha_registro; 
} 
public void setTsp_fecha_registro(java.util.Date tsp_fecha_registro) { 
  this.tsp_fecha_registro = tsp_fecha_registro; 
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
