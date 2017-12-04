package pe.com.focus.sakerk.repository.custom.model; 

public class EstudioQueryCriteria { 

private String orderColumn;
private String orderDirecction;
private Integer id_estudio; 
private Integer id_categoria_estudio; 
private Integer nombre_estudio; 
private Integer id_estado; 

public EstudioQueryCriteria() {
this.orderColumn = "1";
this.orderDirecction = "ASC";
}
public Integer getId_estudio() { 
  return id_estudio; 
} 
public void setId_estudio(Integer id_estudio) { 
  this.id_estudio = id_estudio; 
} 
public Integer getId_categoria_estudio() { 
  return id_categoria_estudio; 
} 
public void setId_categoria_estudio(Integer id_categoria_estudio) { 
  this.id_categoria_estudio = id_categoria_estudio; 
} 
public Integer getNombre_estudio() { 
  return nombre_estudio; 
} 
public void setNombre_estudio(Integer nombre_estudio) { 
  this.nombre_estudio = nombre_estudio; 
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

} 
