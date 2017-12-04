package sernanp.app.dao.query.domain; 

public class FiltrarPersonalReporteQuery { 

private Integer idpersona; 
private Integer idpersonal; 
private Integer idpersonanatural; 
private String tipoDoc; 
private String numerodoc; 
private String nombre_completo; 
private Integer srl_id_cargo; 
private String var_nom_cargo; 
private String dte_fec_inicio; 
private String dte_fec_termino;
private String descategoriaanp; 
private String desareanatural;
private String desarea;
private String dessede;
private Integer int_estado; 
private String expediente; 
private String desc_estado;

public Integer getIdpersona() { 
  return idpersona; 
} 
public void setIdpersona(Integer idpersona) { 
  this.idpersona = idpersona; 
} 
public Integer getIdpersonal() { 
  return idpersonal; 
} 
public void setIdpersonal(Integer idpersonal) { 
  this.idpersonal = idpersonal; 
} 
public Integer getIdpersonanatural() { 
  return idpersonanatural; 
} 
public void setIdpersonanatural(Integer idpersonanatural) { 
  this.idpersonanatural = idpersonanatural; 
} 
public String getTipoDoc() { 
  return tipoDoc; 
} 
public void setTipoDoc(String tipoDoc) { 
  this.tipoDoc = tipoDoc; 
} 
public String getNumerodoc() { 
  return numerodoc; 
} 
public void setNumerodoc(String numerodoc) { 
  this.numerodoc = numerodoc; 
} 
public String getNombre_completo() { 
  return nombre_completo; 
} 
public void setNombre_completo(String nombre_completo) { 
  this.nombre_completo = nombre_completo; 
} 
public Integer getSrl_id_cargo() { 
  return srl_id_cargo; 
} 
public void setSrl_id_cargo(Integer srl_id_cargo) { 
  this.srl_id_cargo = srl_id_cargo; 
} 
public String getVar_nom_cargo() { 
  return var_nom_cargo; 
} 
public void setVar_nom_cargo(String var_nom_cargo) { 
  this.var_nom_cargo = var_nom_cargo; 
} 
public String getDte_fec_inicio() { 
  return dte_fec_inicio; 
} 
public void setDte_fec_inicio(String dte_fec_inicio) { 
  this.dte_fec_inicio = dte_fec_inicio; 
} 

public String getDescategoriaanp() { 
  return descategoriaanp; 
} 
public void setDescategoriaanp(String descategoriaanp) { 
  this.descategoriaanp = descategoriaanp; 
} 

public String getDesareanatural() { 
  return desareanatural; 
} 
public void setDesareanatural(String desareanatural) { 
  this.desareanatural = desareanatural; 
} 


public String getExpediente() { 
  return expediente; 
} 
public void setExpediente(String expediente) { 
  this.expediente = expediente; 
}
public String getDesarea() {
	return desarea;
}
public void setDesarea(String desarea) {
	this.desarea = desarea;
}
public String getDessede() {
	return dessede;
}
public void setDessede(String dessede) {
	this.dessede = dessede;
}
public String getDesc_estado() {
	return desc_estado;
}
public void setDesc_estado(String desc_estado) {
	this.desc_estado = desc_estado;
}
public Integer getInt_estado() {
	return int_estado;
}
public void setInt_estado(Integer int_estado) {
	this.int_estado = int_estado;
}
public String getDte_fec_termino() {
	return dte_fec_termino;
}
public void setDte_fec_termino(String dte_fec_termino) {
	this.dte_fec_termino = dte_fec_termino;
} 

} 
