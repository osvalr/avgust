package pe.com.focus.sakerk.repository.custom.model; 

public class TablaGeneralQueryCriteria { 

private String orderColumn;
private String orderDirecction;
private Integer id_tabla_general; 
private String nombre_tabla_general; 

public TablaGeneralQueryCriteria() {
this.orderColumn = "1";
this.orderDirecction = "ASC";
}
public Integer getId_tabla_general() { 
  return id_tabla_general; 
} 
public void setId_tabla_general(Integer id_tabla_general) { 
  this.id_tabla_general = id_tabla_general; 
} 
public String getNombre_tabla_general() { 
  return nombre_tabla_general; 
} 
public void setNombre_tabla_general(String nombre_tabla_general) { 
  this.nombre_tabla_general = nombre_tabla_general; 
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
