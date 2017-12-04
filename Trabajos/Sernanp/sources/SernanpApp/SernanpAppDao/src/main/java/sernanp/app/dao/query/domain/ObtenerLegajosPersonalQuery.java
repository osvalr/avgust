package sernanp.app.dao.query.domain; 

public class ObtenerLegajosPersonalQuery { 

private Integer idpersonanatural; 
private Integer srl_id_persona_natural_legajo; 
private String nombre; 
private String asunto; 
private String descripcion; 
private String fecha_registro; 

//11-02-2015 DAVID
private Integer srl_id_contrato;

public Integer getIdpersonanatural() { 
  return idpersonanatural; 
} 
public void setIdpersonanatural(Integer idpersonanatural) { 
  this.idpersonanatural = idpersonanatural; 
} 
public Integer getSrl_id_persona_natural_legajo() { 
  return srl_id_persona_natural_legajo; 
} 
public void setSrl_id_persona_natural_legajo(Integer srl_id_persona_natural_legajo) { 
  this.srl_id_persona_natural_legajo = srl_id_persona_natural_legajo; 
} 
public String getNombre() { 
  return nombre; 
} 
public void setNombre(String nombre) { 
  this.nombre = nombre; 
} 
public String getAsunto() { 
  return asunto; 
} 
public void setAsunto(String asunto) { 
  this.asunto = asunto; 
} 
public String getDescripcion() { 
  return descripcion; 
} 
public void setDescripcion(String descripcion) { 
  this.descripcion = descripcion; 
} 
public String getFecha_registro() { 
  return fecha_registro; 
} 
public void setFecha_registro(String fecha_registro) { 
  this.fecha_registro = fecha_registro; 
}
public Integer getSrl_id_contrato() {
	return srl_id_contrato;
}
public void setSrl_id_contrato(Integer srl_id_contrato) {
	this.srl_id_contrato = srl_id_contrato;
}

} 
