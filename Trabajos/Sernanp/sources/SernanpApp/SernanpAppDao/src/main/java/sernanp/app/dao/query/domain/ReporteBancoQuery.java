package sernanp.app.dao.query.domain; 

public class ReporteBancoQuery implements java.io.Serializable { 

private static final long serialVersionUID = 1L;
private Integer idpersonal; 
private String nombre_completo; 
private String nombre; 
private String apepat; 
private String apemat; 
private Integer int_anio; 
private String descrip_periodo; 
private String var_numero_cuenta_bancaria; 
private Integer idtipodocumento; 
private String numerodoc; 
private Double dec_total_neto; 
private String c_fte_fto; 
private String c_meta; 
private Integer srl_id_regimen_contractual;
private Integer int_id_estado;

public Integer getIdpersonal() { 
  return idpersonal; 
} 
public void setIdpersonal(Integer idpersonal) { 
  this.idpersonal = idpersonal; 
} 
public String getNombre_completo() { 
  return nombre_completo; 
} 
public void setNombre_completo(String nombre_completo) { 
  this.nombre_completo = nombre_completo; 
} 
public String getNombre() { 
  return nombre; 
} 
public void setNombre(String nombre) { 
  this.nombre = nombre; 
} 
public String getApepat() { 
  return apepat; 
} 
public void setApepat(String apepat) { 
  this.apepat = apepat; 
} 
public String getApemat() { 
  return apemat; 
} 
public void setApemat(String apemat) { 
  this.apemat = apemat; 
} 
public Integer getInt_anio() { 
  return int_anio; 
} 
public void setInt_anio(Integer int_anio) { 
  this.int_anio = int_anio; 
} 
public String getDescrip_periodo() { 
  return descrip_periodo; 
} 
public void setDescrip_periodo(String descrip_periodo) { 
  this.descrip_periodo = descrip_periodo; 
} 
public String getVar_numero_cuenta_bancaria() { 
  return var_numero_cuenta_bancaria; 
} 
public void setVar_numero_cuenta_bancaria(String var_numero_cuenta_bancaria) { 
  this.var_numero_cuenta_bancaria = var_numero_cuenta_bancaria; 
} 
public Integer getIdtipodocumento() { 
  return idtipodocumento; 
} 
public void setIdtipodocumento(Integer idtipodocumento) { 
  this.idtipodocumento = idtipodocumento; 
} 
public String getNumerodoc() { 
  return numerodoc; 
} 
public void setNumerodoc(String numerodoc) { 
  this.numerodoc = numerodoc; 
} 
public Double getDec_total_neto() { 
  return dec_total_neto; 
} 
public void setDec_total_neto(Double dec_total_neto) { 
  this.dec_total_neto = dec_total_neto; 
} 
public String getC_fte_fto() { 
  return c_fte_fto; 
} 
public void setC_fte_fto(String c_fte_fto) { 
  this.c_fte_fto = c_fte_fto; 
} 
public String getC_meta() { 
  return c_meta; 
} 
public void setC_meta(String c_meta) { 
  this.c_meta = c_meta; 
}
public Integer getSrl_id_regimen_contractual() {
	return srl_id_regimen_contractual;
}
public void setSrl_id_regimen_contractual(Integer srl_id_regimen_contractual) {
	this.srl_id_regimen_contractual = srl_id_regimen_contractual;
}
public Integer getInt_id_estado() {
	return int_id_estado;
}
public void setInt_id_estado(Integer int_id_estado) {
	this.int_id_estado = int_id_estado;
} 

} 
