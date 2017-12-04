package sernanp.app.dao.query.domain; 

public class ExisteFechaInPersonalAsistenciaQueryCriteria { 

private String orderColumn;
private String orderDirecction;
private java.util.Date dte_fecha; 

public ExisteFechaInPersonalAsistenciaQueryCriteria() {
this.orderColumn = "1";
this.orderDirecction = "ASC";
}
public java.util.Date getDte_fecha() { 
  return dte_fecha; 
} 
public void setDte_fecha(java.util.Date dte_fecha) { 
  this.dte_fecha = dte_fecha; 
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
