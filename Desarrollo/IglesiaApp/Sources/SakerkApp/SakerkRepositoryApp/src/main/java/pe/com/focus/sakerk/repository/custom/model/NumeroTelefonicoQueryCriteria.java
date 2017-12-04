package pe.com.focus.sakerk.repository.custom.model; 

public class NumeroTelefonicoQueryCriteria { 

private String orderColumn;
private String orderDirecction;
private Integer id_numero_telefonico; 
private Integer id_persona; 

public NumeroTelefonicoQueryCriteria() {
this.orderColumn = "1";
this.orderDirecction = "ASC";
}
public Integer getId_numero_telefonico() { 
  return id_numero_telefonico; 
} 
public void setId_numero_telefonico(Integer id_numero_telefonico) { 
  this.id_numero_telefonico = id_numero_telefonico; 
} 
public Integer getId_persona() { 
  return id_persona; 
} 
public void setId_persona(Integer id_persona) { 
  this.id_persona = id_persona; 
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
