package sernanp.app.dao.query.domain; 

public class ObtenerDetalleLegajoPersonalQuery { 

private Integer idpersonanatural; 
private Integer srl_id_persona_natural_legajo; 
private Integer int_id_tipo_documento;
private String nombre; 
private String asunto; 
private String descripcion; 
private String nombre_archivo; 
private String fecha_registro; 
private String dte_fec_cese;
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
public String getNombre_archivo() { 
  return nombre_archivo; 
} 
public void setNombre_archivo(String nombre_archivo) { 
  this.nombre_archivo = nombre_archivo; 
} 
public String getFecha_registro() { 
  return fecha_registro; 
} 
public void setFecha_registro(String fecha_registro) { 
  this.fecha_registro = fecha_registro; 
}
public Integer getInt_id_tipo_documento() {
	return int_id_tipo_documento;
}
public void setInt_id_tipo_documento(Integer int_id_tipo_documento) {
	this.int_id_tipo_documento = int_id_tipo_documento;
}
public String getDte_fec_cese() {
	return dte_fec_cese;
}
public void setDte_fec_cese(String dte_fec_cese) {
	this.dte_fec_cese = dte_fec_cese;
}
public Integer getSrl_id_contrato() {
	return srl_id_contrato;
}
public void setSrl_id_contrato(Integer srl_id_contrato) {
	this.srl_id_contrato = srl_id_contrato;
} 

} 
