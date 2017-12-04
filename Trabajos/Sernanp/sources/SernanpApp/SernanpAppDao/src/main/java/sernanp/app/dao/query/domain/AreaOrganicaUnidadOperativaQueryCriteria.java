package sernanp.app.dao.query.domain; 

public class AreaOrganicaUnidadOperativaQueryCriteria { 

private String orderColumn;
private String orderDirecction;
private Integer idsede; 

public AreaOrganicaUnidadOperativaQueryCriteria() {
this.orderColumn = "1";
this.orderDirecction = "ASC";
}
public Integer getIdsede() { 
  return idsede; 
} 
public void setIdsede(Integer idsede) { 
  this.idsede = idsede; 
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
