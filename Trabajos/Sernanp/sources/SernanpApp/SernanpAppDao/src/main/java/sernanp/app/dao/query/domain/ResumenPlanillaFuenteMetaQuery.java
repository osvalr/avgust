package sernanp.app.dao.query.domain; 

public class ResumenPlanillaFuenteMetaQuery implements java.io.Serializable { 

private static final long serialVersionUID = 1L;
private Integer srl_id_regimen_contractual; 
private Integer int_anio; 
private String descrip_periodo; 
private Integer int_id_tipo_concepto; 
private String descrip_tipo_concepto; 
private Integer srl_id_concepto_planilla; 
private String var_descrip_corto_concepto; 
private String c_fte_fto; 
private String c_meta; 
private Double ingresos; 
private Double obligaciones; 
private Integer numero_trabajadores; 

public Integer getSrl_id_regimen_contractual() { 
  return srl_id_regimen_contractual; 
} 
public void setSrl_id_regimen_contractual(Integer srl_id_regimen_contractual) { 
  this.srl_id_regimen_contractual = srl_id_regimen_contractual; 
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
public Integer getInt_id_tipo_concepto() { 
  return int_id_tipo_concepto; 
} 
public void setInt_id_tipo_concepto(Integer int_id_tipo_concepto) { 
  this.int_id_tipo_concepto = int_id_tipo_concepto; 
} 
public String getDescrip_tipo_concepto() { 
  return descrip_tipo_concepto; 
} 
public void setDescrip_tipo_concepto(String descrip_tipo_concepto) { 
  this.descrip_tipo_concepto = descrip_tipo_concepto; 
} 
public Integer getSrl_id_concepto_planilla() { 
  return srl_id_concepto_planilla; 
} 
public void setSrl_id_concepto_planilla(Integer srl_id_concepto_planilla) { 
  this.srl_id_concepto_planilla = srl_id_concepto_planilla; 
} 
public String getVar_descrip_corto_concepto() { 
  return var_descrip_corto_concepto; 
} 
public void setVar_descrip_corto_concepto(String var_descrip_corto_concepto) { 
  this.var_descrip_corto_concepto = var_descrip_corto_concepto; 
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
public Double getIngresos() { 
  return ingresos; 
} 
public void setIngresos(Double ingresos) { 
  this.ingresos = ingresos; 
} 
public Double getObligaciones() { 
  return obligaciones; 
} 
public void setObligaciones(Double obligaciones) { 
  this.obligaciones = obligaciones; 
} 
public Integer getNumero_trabajadores() { 
  return numero_trabajadores; 
} 
public void setNumero_trabajadores(Integer numero_trabajadores) { 
  this.numero_trabajadores = numero_trabajadores; 
} 

} 
