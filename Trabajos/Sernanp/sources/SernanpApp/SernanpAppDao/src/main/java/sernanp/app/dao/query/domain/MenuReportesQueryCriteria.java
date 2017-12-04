package sernanp.app.dao.query.domain; 

public class MenuReportesQueryCriteria { 

private String orderColumn;
private String orderDirecction;
private Integer niveldependemodulo; 

public MenuReportesQueryCriteria() {
this.orderColumn = "1";
this.orderDirecction = "ASC";
}
public Integer getNiveldependemodulo() { 
  return niveldependemodulo; 
} 
public void setNiveldependemodulo(Integer niveldependemodulo) { 
  this.niveldependemodulo = niveldependemodulo; 
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
