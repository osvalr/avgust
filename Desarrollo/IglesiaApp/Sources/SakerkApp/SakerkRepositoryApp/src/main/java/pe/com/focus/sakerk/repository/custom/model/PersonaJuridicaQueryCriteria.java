package pe.com.focus.sakerk.repository.custom.model; 

public class PersonaJuridicaQueryCriteria { 

private String orderColumn;
private String orderDirecction;
private Integer id_persona; 
private Integer id_persona_juridica; 
private String razon_social; 
private String numero_ruc; 
private Integer id_tipo_persona_juridica; 
private Integer id_pais; 
private Integer id_estado; 

public PersonaJuridicaQueryCriteria() {
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
public String getRazon_social() { 
  return razon_social; 
} 
public void setRazon_social(String razon_social) { 
  this.razon_social = razon_social; 
} 
public String getNumero_ruc() { 
  return numero_ruc; 
} 
public void setNumero_ruc(String numero_ruc) { 
  this.numero_ruc = numero_ruc; 
} 
public Integer getId_pais() { 
  return id_pais; 
} 
public void setId_pais(Integer id_pais) { 
  this.id_pais = id_pais; 
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
public Integer getId_tipo_persona_juridica() {
	return id_tipo_persona_juridica;
}
public void setId_tipo_persona_juridica(Integer id_tipo_persona_juridica) {
	this.id_tipo_persona_juridica = id_tipo_persona_juridica;
}

} 
