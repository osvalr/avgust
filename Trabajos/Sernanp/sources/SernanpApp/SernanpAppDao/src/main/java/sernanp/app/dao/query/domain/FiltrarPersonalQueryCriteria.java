package sernanp.app.dao.query.domain; 

public class FiltrarPersonalQueryCriteria { 

private String nombres; 
private Integer idtipodocumento; 
private Integer srl_id_regimen_contractual; 
private String ruc;
private Integer int_estado;
private Integer srl_id_cargo;
private String numerodoc;
private Integer idarea;
private Integer idcategoriaanp;
private Integer idareanatural;

public String getNombres() { 
  return nombres; 
} 
public void setNombres(String nombres) { 
  this.nombres = nombres; 
} 
public Integer getIdtipodocumento() { 
  return idtipodocumento; 
} 
public void setIdtipodocumento(Integer idtipodocumento) { 
  this.idtipodocumento = idtipodocumento; 
} 
public Integer getSrl_id_regimen_contractual() { 
  return srl_id_regimen_contractual; 
} 
public void setSrl_id_regimen_contractual(Integer srl_id_regimen_contractual) { 
  this.srl_id_regimen_contractual = srl_id_regimen_contractual; 
}
public String getRuc() {
	return ruc;
}
public void setRuc(String ruc) {
	this.ruc = ruc;
}
public Integer getInt_estado() {
	return int_estado;
}
public void setInt_estado(Integer int_estado) {
	this.int_estado = int_estado;
}
public Integer getSrl_id_cargo() {
	return srl_id_cargo;
}
public void setSrl_id_cargo(Integer srl_id_cargo) {
	this.srl_id_cargo = srl_id_cargo;
}
public String getNumerodoc() {
	return numerodoc;
}
public void setNumerodoc(String numerodoc) {
	this.numerodoc = numerodoc;
}
public Integer getIdarea() {
	return idarea;
}
public void setIdarea(Integer idarea) {
	this.idarea = idarea;
}
public Integer getIdcategoriaanp() {
	return idcategoriaanp;
}
public void setIdcategoriaanp(Integer idcategoriaanp) {
	this.idcategoriaanp = idcategoriaanp;
}
public Integer getIdareanatural() {
	return idareanatural;
}
public void setIdareanatural(Integer idareanatural) {
	this.idareanatural = idareanatural;
} 



} 
