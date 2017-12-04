package sernanp.app.dao.query.domain; 

public class RpDescuentoJudicialQuery implements java.io.Serializable { 

private static final long serialVersionUID = 1L;

private Integer int_anio;
private Integer Int_id_periodo_mes;

private String descrip_periodo;
private Integer idpersonal; 
private String var_descripcion_descuento; 
private String var_numero_doc; 
private String nombre_completo; 

private String nombre_beneficiario_jud; 
private String var_numero_cuenta; 
private Integer idpersonanatural; 
private String numerodoc; 
private Integer srl_id_regimen_contractual; 
private String var_descripcion_regimen_contractual; 
private String c_meta; 
private String c_fte_fto; 

private String var_sigla;
private Double dec_monto_calculado; 
private Double total;

public Integer getIdpersonal() { 
  return idpersonal; 
} 
public void setIdpersonal(Integer idpersonal) { 
  this.idpersonal = idpersonal; 
} 
public String getVar_descripcion_descuento() { 
  return var_descripcion_descuento; 
} 
public void setVar_descripcion_descuento(String var_descripcion_descuento) { 
  this.var_descripcion_descuento = var_descripcion_descuento; 
} 
public String getVar_numero_doc() { 
  return var_numero_doc; 
} 
public void setVar_numero_doc(String var_numero_doc) { 
  this.var_numero_doc = var_numero_doc; 
} 
public String getNombre_completo() { 
  return nombre_completo; 
} 
public void setNombre_completo(String nombre_completo) { 
  this.nombre_completo = nombre_completo; 
} 
 
public String getNombre_beneficiario_jud() { 
  return nombre_beneficiario_jud; 
} 
public void setNombre_beneficiario_jud(String nombre_beneficiario_jud) { 
  this.nombre_beneficiario_jud = nombre_beneficiario_jud; 
} 
public String getVar_numero_cuenta() { 
  return var_numero_cuenta; 
} 
public void setVar_numero_cuenta(String var_numero_cuenta) { 
  this.var_numero_cuenta = var_numero_cuenta; 
} 
public Integer getIdpersonanatural() { 
  return idpersonanatural; 
} 
public void setIdpersonanatural(Integer idpersonanatural) { 
  this.idpersonanatural = idpersonanatural; 
} 
public String getNumerodoc() { 
  return numerodoc; 
} 
public void setNumerodoc(String numerodoc) { 
  this.numerodoc = numerodoc; 
} 
public Integer getSrl_id_regimen_contractual() { 
  return srl_id_regimen_contractual; 
} 
public void setSrl_id_regimen_contractual(Integer srl_id_regimen_contractual) { 
  this.srl_id_regimen_contractual = srl_id_regimen_contractual; 
} 
public String getVar_descripcion_regimen_contractual() { 
  return var_descripcion_regimen_contractual; 
} 
public void setVar_descripcion_regimen_contractual(String var_descripcion_regimen_contractual) { 
  this.var_descripcion_regimen_contractual = var_descripcion_regimen_contractual; 
} 
public String getC_meta() { 
  return c_meta; 
} 
public void setC_meta(String c_meta) { 
  this.c_meta = c_meta; 
} 
public String getC_fte_fto() { 
  return c_fte_fto; 
} 
public void setC_fte_fto(String c_fte_fto) { 
  this.c_fte_fto = c_fte_fto; 
} 
public Double getDec_monto_calculado() { 
  return dec_monto_calculado; 
} 
public void setDec_monto_calculado(Double dec_monto_calculado) { 
  this.dec_monto_calculado = dec_monto_calculado; 
}
public Double getTotal() {
	return total;
}
public void setTotal(Double total) {
	this.total = total;
}
public Integer getInt_anio() {
	return int_anio;
}
public void setInt_anio(Integer int_anio) {
	this.int_anio = int_anio;
}
public Integer getInt_id_periodo_mes() {
	return Int_id_periodo_mes;
}
public void setInt_id_periodo_mes(Integer int_id_periodo_mes) {
	Int_id_periodo_mes = int_id_periodo_mes;
}
public String getDescrip_periodo() {
	return descrip_periodo;
}
public void setDescrip_periodo(String descrip_periodo) {
	this.descrip_periodo = descrip_periodo;
}
public String getVar_sigla() {
	return var_sigla;
}
public void setVar_sigla(String var_sigla) {
	this.var_sigla = var_sigla;
} 

} 
