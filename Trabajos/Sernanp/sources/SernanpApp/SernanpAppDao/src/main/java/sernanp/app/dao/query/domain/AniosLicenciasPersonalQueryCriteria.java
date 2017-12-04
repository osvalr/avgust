package sernanp.app.dao.query.domain; 

public class AniosLicenciasPersonalQueryCriteria { 

private String orderColumn;
private String orderDirecction;
private Integer int_anio; 

public AniosLicenciasPersonalQueryCriteria() {
this.orderColumn = "1";
this.orderDirecction = "DESC";
}
public Integer getInt_anio() { 
  return int_anio; 
} 
public void setInt_anio(Integer int_anio) { 
  this.int_anio = int_anio; 
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
