package sernanp.app.dao.query.domain; 

public class MesesLicenciasPersonalQueryCriteria { 

private String orderColumn;
private String orderDirecction;
private Integer int_mes; 

public MesesLicenciasPersonalQueryCriteria() {
this.orderColumn = "1";
this.orderDirecction = "ASC";
}
public Integer getInt_mes() { 
  return int_mes; 
} 
public void setInt_mes(Integer int_mes) { 
  this.int_mes = int_mes; 
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
