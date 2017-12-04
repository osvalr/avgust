package pe.com.focus.sakerk.repository.custom.model; 

public class InformacionEclesiasticaQuery implements java.io.Serializable { 

private static final long serialVersionUID = 1L;
private Integer id_info_eclesiastica; 
private Integer id_persona_natural; 
private Integer id_congregacion; 
private String razon_social; 
private String fecha_evento; 
private Integer id_tipo_evento; 
private String descrip_tipo_evento_eclesiastico; 
private Integer id_estado; 
private String descrip_estado; 
private String fecha_registro; 

public Integer getId_info_eclesiastica() { 
  return id_info_eclesiastica; 
} 
public void setId_info_eclesiastica(Integer id_info_eclesiastica) { 
  this.id_info_eclesiastica = id_info_eclesiastica; 
} 
public Integer getId_persona_natural() { 
  return id_persona_natural; 
} 
public void setId_persona_natural(Integer id_persona_natural) { 
  this.id_persona_natural = id_persona_natural; 
} 
public Integer getId_congregacion() { 
  return id_congregacion; 
} 
public void setId_congregacion(Integer id_congregacion) { 
  this.id_congregacion = id_congregacion; 
} 
public String getRazon_social() { 
  return razon_social; 
} 
public void setRazon_social(String razon_social) { 
  this.razon_social = razon_social; 
} 
public String getFecha_evento() { 
  return fecha_evento; 
} 
public void setFecha_evento(String fecha_evento) { 
  this.fecha_evento = fecha_evento; 
} 
public Integer getId_tipo_evento() { 
  return id_tipo_evento; 
} 
public void setId_tipo_evento(Integer id_tipo_evento) { 
  this.id_tipo_evento = id_tipo_evento; 
} 
public String getDescrip_tipo_evento_eclesiastico() { 
  return descrip_tipo_evento_eclesiastico; 
} 
public void setDescrip_tipo_evento_eclesiastico(String descrip_tipo_evento_eclesiastico) { 
  this.descrip_tipo_evento_eclesiastico = descrip_tipo_evento_eclesiastico; 
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

} 
