package pe.com.focus.sakerk.repository.custom.model; 

public class PersonaNaturalRolQueryCriteria { 

private String orderColumn;
private String orderDirecction;
private Integer id_persona_natural_rol; 
private Integer id_persona_natural; 

public PersonaNaturalRolQueryCriteria() {
this.orderColumn = "1";
this.orderDirecction = "ASC";
}
public Integer getId_persona_natural_rol() { 
  return id_persona_natural_rol; 
} 
public void setId_persona_natural_rol(Integer id_persona_natural_rol) { 
  this.id_persona_natural_rol = id_persona_natural_rol; 
} 
public Integer getId_persona_natural() { 
  return id_persona_natural; 
} 
public void setId_persona_natural(Integer id_persona_natural) { 
  this.id_persona_natural = id_persona_natural; 
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
