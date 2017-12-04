package pe.com.focus.sakerk.repository.custom.model; 

public class ItemTablaGeneralQueryCriteria { 

private String orderColumn;
private String orderDirecction;
private Integer id_tabla_general_detalle; 

public ItemTablaGeneralQueryCriteria() {
this.orderColumn = "1";
this.orderDirecction = "ASC";
}
public Integer getId_tabla_general_detalle() { 
  return id_tabla_general_detalle; 
} 
public void setId_tabla_general_detalle(Integer id_tabla_general_detalle) { 
  this.id_tabla_general_detalle = id_tabla_general_detalle; 
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
