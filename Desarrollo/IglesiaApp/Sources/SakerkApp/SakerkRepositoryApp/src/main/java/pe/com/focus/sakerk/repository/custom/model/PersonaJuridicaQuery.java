package pe.com.focus.sakerk.repository.custom.model; 

public class PersonaJuridicaQuery { 

private Integer id_persona; 
private Integer id_persona_juridica;
private String razon_social; 
private String numero_ruc; 
private Integer id_tipo_persona_juridica; 
private String descrip_tipo_persona_juridica;
private String email; 
private Integer id_pais; 
private String nombre_pais; 
private Integer id_estado; 
private String descrip_estado; 
private String fecha_registro; 

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
public String getEmail() { 
  return email; 
} 
public void setEmail(String email) { 
  this.email = email; 
} 
public Integer getId_pais() { 
  return id_pais; 
} 
public void setId_pais(Integer id_pais) { 
  this.id_pais = id_pais; 
} 
public String getNombre_pais() { 
  return nombre_pais; 
} 
public void setNombre_pais(String nombre_pais) { 
  this.nombre_pais = nombre_pais; 
} 
public Integer getId_estado() { 
  return id_estado; 
} 
public void setId_estado(Integer id_estado) { 
  this.id_estado = id_estado; 
} 
public String getDescrip_estado() { 
  return descrip_estado; 
} 
public void setDescrip_estado(String descrip_estado) { 
  this.descrip_estado = descrip_estado; 
} 
public String getFecha_registro() { 
  return fecha_registro; 
} 
public void setFecha_registro(String fecha_registro) { 
  this.fecha_registro = fecha_registro; 
}
public Integer getId_tipo_persona_juridica() {
	return id_tipo_persona_juridica;
}
public void setId_tipo_persona_juridica(Integer id_tipo_persona_juridica) {
	this.id_tipo_persona_juridica = id_tipo_persona_juridica;
}
public String getDescrip_tipo_persona_juridica() {
	return descrip_tipo_persona_juridica;
}
public void setDescrip_tipo_persona_juridica(
		String descrip_tipo_persona_juridica) {
	this.descrip_tipo_persona_juridica = descrip_tipo_persona_juridica;
} 

} 
