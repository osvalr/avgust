package sernanp.app.dao.query.domain; 

public class RpResumenAfpQuery implements java.io.Serializable { 

private static final long serialVersionUID = 1L;
private String var_descripcion_regimen_contractual; 
private Integer int_anio; 
private String descrip_periodo; 
private String c_fte_fto; 
private String c_meta; 
private String var_nombre_afp; 
private String var_codigo_afiliacion; 
private Integer idpersonanatural; 
private String nombre_completo; 
private Double sueldo; 
private Double dec_total_aportes; 
private Double seguro_invalidez; 
private Double comision_variable; 
private Double sub_total_retencion; 
private Double total; 
private Double dec_total_ingresos;

public String getVar_descripcion_regimen_contractual() { 
  return var_descripcion_regimen_contractual; 
} 
public void setVar_descripcion_regimen_contractual(String var_descripcion_regimen_contractual) { 
  this.var_descripcion_regimen_contractual = var_descripcion_regimen_contractual; 
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


public String getVar_nombre_afp() { 
  return var_nombre_afp; 
} 
public void setVar_nombre_afp(String var_nombre_afp) { 
  this.var_nombre_afp = var_nombre_afp; 
} 
public String getVar_codigo_afiliacion() { 
  return var_codigo_afiliacion; 
} 
public void setVar_codigo_afiliacion(String var_codigo_afiliacion) { 
  this.var_codigo_afiliacion = var_codigo_afiliacion; 
} 
public Integer getIdpersonanatural() { 
  return idpersonanatural; 
} 
public void setIdpersonanatural(Integer idpersonanatural) { 
  this.idpersonanatural = idpersonanatural; 
} 
public String getNombre_completo() { 
  return nombre_completo; 
} 
public void setNombre_completo(String nombre_completo) { 
  this.nombre_completo = nombre_completo; 
} 
public Double getSueldo() { 
  return sueldo; 
} 
public void setSueldo(Double sueldo) { 
  this.sueldo = sueldo; 
} 
public Double getDec_total_aportes() { 
  return dec_total_aportes; 
} 
public void setDec_total_aportes(Double dec_total_aportes) { 
  this.dec_total_aportes = dec_total_aportes; 
} 
public Double getSeguro_invalidez() { 
  return seguro_invalidez; 
} 
public void setSeguro_invalidez(Double seguro_invalidez) { 
  this.seguro_invalidez = seguro_invalidez; 
} 
public Double getComision_variable() { 
  return comision_variable; 
} 
public void setComision_variable(Double comision_variable) { 
  this.comision_variable = comision_variable; 
} 
public Double getSub_total_retencion() { 
  return sub_total_retencion; 
} 
public void setSub_total_retencion(Double sub_total_retencion) { 
  this.sub_total_retencion = sub_total_retencion; 
} 
public Double getTotal() { 
  return total; 
} 
public void setTotal(Double total) { 
  this.total = total; 
}
public Double getDec_total_ingresos() {
	return dec_total_ingresos;
}
public void setDec_total_ingresos(Double dec_total_ingresos) {
	this.dec_total_ingresos = dec_total_ingresos;
} 

} 
