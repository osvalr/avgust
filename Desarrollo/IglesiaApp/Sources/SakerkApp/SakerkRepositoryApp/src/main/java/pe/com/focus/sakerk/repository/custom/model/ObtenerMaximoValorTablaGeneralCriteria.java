package pe.com.focus.sakerk.repository.custom.model; 

public class ObtenerMaximoValorTablaGeneralCriteria { 

private String orderColumn;
private String orderDirecction;
private Integer id_tabla_general; 

public ObtenerMaximoValorTablaGeneralCriteria() {
this.orderColumn = "1";
this.orderDirecction = "ASC";
}
public Integer getId_tabla_general() { 
  return id_tabla_general; 
} 
public void setId_tabla_general(Integer id_tabla_general) { 
  this.id_tabla_general = id_tabla_general; 
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
