package pe.com.focus.sakerk.repository.custom.model; 

public class PersonaNaturalParentescoQueryCriteria { 

private String orderColumn;
private String orderDirecction;
private Integer id_persona_parentesco; 
private Integer id_persona_natural; 

public PersonaNaturalParentescoQueryCriteria() {
this.orderColumn = "1";
this.orderDirecction = "ASC";
}
public Integer getId_persona_parentesco() { 
  return id_persona_parentesco; 
} 
public void setId_persona_parentesco(Integer id_persona_parentesco) { 
  this.id_persona_parentesco = id_persona_parentesco; 
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
