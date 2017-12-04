package pe.com.focus.sakerk.repository.custom.model; 

public class CongregacionQueryCriteria { 

private String orderColumn;
private String orderDirecction;
private Integer id_congregacion_general; 
private Integer id_congregacion_padre; 
private String nombre_congregacion; 
private Integer id_estado;

public CongregacionQueryCriteria() {
this.orderColumn = "1";
this.orderDirecction = "ASC";
}

public String getNombre_congregacion() { 
  return nombre_congregacion; 
} 
public void setNombre_congregacion(String nombre_congregacion) { 
  this.nombre_congregacion = nombre_congregacion; 
} 
public Integer getId_estado() { 
  return id_estado; 
} 
public void setId_estado(Integer id_estado) { 
  this.id_estado = id_estado; 
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

public Integer getId_congregacion_general() {
	return id_congregacion_general;
}

public void setId_congregacion_general(Integer id_congregacion_general) {
	this.id_congregacion_general = id_congregacion_general;
}

public Integer getId_congregacion_padre() {
	return id_congregacion_padre;
}

public void setId_congregacion_padre(Integer id_congregacion_padre) {
	this.id_congregacion_padre = id_congregacion_padre;
}

} 
