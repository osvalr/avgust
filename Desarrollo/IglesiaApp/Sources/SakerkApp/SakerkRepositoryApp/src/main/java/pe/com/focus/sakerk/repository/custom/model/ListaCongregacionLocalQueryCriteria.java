package pe.com.focus.sakerk.repository.custom.model; 

public class ListaCongregacionLocalQueryCriteria { 

private String orderColumn;
private String orderDirecction;
private Integer id_congregacion_general; 

public ListaCongregacionLocalQueryCriteria() {
this.orderColumn = "1";
this.orderDirecction = "ASC";
}
public Integer getId_congregacion_general() { 
  return id_congregacion_general; 
} 
public void setId_congregacion_general(Integer id_congregacion_general) { 
  this.id_congregacion_general = id_congregacion_general; 
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
