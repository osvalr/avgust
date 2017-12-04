package pe.com.focus.sakerk.repository.custom.model; 

public class RegistroEstudioQueryCriteria { 

private String orderColumn;
private String orderDirecction;
private Integer id_estudio; 
private Integer id_categoria_estudio; 

public RegistroEstudioQueryCriteria() {
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
