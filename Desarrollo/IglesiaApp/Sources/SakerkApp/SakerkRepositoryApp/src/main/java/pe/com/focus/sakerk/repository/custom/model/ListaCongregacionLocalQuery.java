package pe.com.focus.sakerk.repository.custom.model; 

public class ListaCongregacionLocalQuery implements java.io.Serializable { 

private static final long serialVersionUID = 1L;
private Integer id_congregacion_local; 
private Integer id_congregacion_general; 
private String razon_social; 
private Integer id_tipo_persona_juridica; 

public Integer getId_congregacion_local() { 
  return id_congregacion_local; 
} 
public void setId_congregacion_local(Integer id_congregacion_local) { 
  this.id_congregacion_local = id_congregacion_local; 
} 
public Integer getId_congregacion_general() { 
  return id_congregacion_general; 
} 
public void setId_congregacion_general(Integer id_congregacion_general) { 
  this.id_congregacion_general = id_congregacion_general; 
} 
public String getRazon_social() { 
  return razon_social; 
} 
public void setRazon_social(String razon_social) { 
  this.razon_social = razon_social; 
} 
public Integer getId_tipo_persona_juridica() { 
  return id_tipo_persona_juridica; 
} 
public void setId_tipo_persona_juridica(Integer id_tipo_persona_juridica) { 
  this.id_tipo_persona_juridica = id_tipo_persona_juridica; 
} 

} 
