package sernanp.app.dao.query.domain; 

public class RpResumenPlanillaPagosQuery implements java.io.Serializable { 

private static final long serialVersionUID = 1L;
private Integer idpersonal; 
private String nombre_completo; 
private String numerodoc; 
private String var_descripcion_regimen_contractual; 
private Double dec_total_ingresos; 
private Double dec_total_descuentos; 
private Double dec_total_aportes; 
private Double dec_total_neto; 
private String var_cod_meta_presupuestaria; 
private String var_rubro_fte_fto; 
private Integer int_anio; 
private Integer srl_id_nomina_anio_periodo_personal; 
private String tipo_doc; 

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
public String getNumerodoc() { 
  return numerodoc; 
} 
public void setNumerodoc(String numerodoc) { 
  this.numerodoc = numerodoc; 
} 
public String getVar_descripcion_regimen_contractual() { 
  return var_descripcion_regimen_contractual; 
} 
public void setVar_descripcion_regimen_contractual(String var_descripcion_regimen_contractual) { 
  this.var_descripcion_regimen_contractual = var_descripcion_regimen_contractual; 
} 
public Double getDec_total_ingresos() { 
  return dec_total_ingresos; 
} 
public void setDec_total_ingresos(Double dec_total_ingresos) { 
  this.dec_total_ingresos = dec_total_ingresos; 
} 
public Double getDec_total_descuentos() { 
  return dec_total_descuentos; 
} 
public void setDec_total_descuentos(Double dec_total_descuentos) { 
  this.dec_total_descuentos = dec_total_descuentos; 
} 
public Double getDec_total_aportes() { 
  return dec_total_aportes; 
} 
public void setDec_total_aportes(Double dec_total_aportes) { 
  this.dec_total_aportes = dec_total_aportes; 
} 
public Double getDec_total_neto() { 
  return dec_total_neto; 
} 
public void setDec_total_neto(Double dec_total_neto) { 
  this.dec_total_neto = dec_total_neto; 
} 
public String getVar_cod_meta_presupuestaria() { 
  return var_cod_meta_presupuestaria; 
} 
public void setVar_cod_meta_presupuestaria(String var_cod_meta_presupuestaria) { 
  this.var_cod_meta_presupuestaria = var_cod_meta_presupuestaria; 
} 
public String getVar_rubro_fte_fto() { 
  return var_rubro_fte_fto; 
} 
public void setVar_rubro_fte_fto(String var_rubro_fte_fto) { 
  this.var_rubro_fte_fto = var_rubro_fte_fto; 
} 
public Integer getInt_anio() { 
  return int_anio; 
} 
public void setInt_anio(Integer int_anio) { 
  this.int_anio = int_anio; 
} 
public Integer getSrl_id_nomina_anio_periodo_personal() { 
  return srl_id_nomina_anio_periodo_personal; 
} 
public void setSrl_id_nomina_anio_periodo_personal(Integer srl_id_nomina_anio_periodo_personal) { 
  this.srl_id_nomina_anio_periodo_personal = srl_id_nomina_anio_periodo_personal; 
} 
public String getTipo_doc() { 
  return tipo_doc; 
} 
public void setTipo_doc(String tipo_doc) { 
  this.tipo_doc = tipo_doc; 
} 

} 
