package pe.com.focus.sakerk.repository.custom.model; 

public class RegistroPersonaJuridicaQueryCriteria { 

private String orderColumn;
private String orderDirecction;
private Integer id_persona; 
private Integer id_persona_juridica; 
private Integer id_tipo_persona_juridica; 

public RegistroPersonaJuridicaQueryCriteria() {
this.orderColumn = "1";
this.orderDirecction = "ASC";
}
public Integer getId_persona() { 
  return id_persona; 
} 
public void setId_persona(Integer id_persona) { 
  this.id_persona = id_persona; 
} 
public Integer getId_persona_juridica() { 
  return id_persona_juridica; 
} 
public void setId_persona_juridica(Integer id_persona_juridica) { 
  this.id_persona_juridica = id_persona_juridica; 
} 
public Integer getId_tipo_persona_juridica() { 
  return id_tipo_persona_juridica; 
} 
public void setId_tipo_persona_juridica(Integer id_tipo_persona_juridica) { 
  this.id_tipo_persona_juridica = id_tipo_persona_juridica; 
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
