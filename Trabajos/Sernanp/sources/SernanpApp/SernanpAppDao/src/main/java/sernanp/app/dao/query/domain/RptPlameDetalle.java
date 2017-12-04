package sernanp.app.dao.query.domain; 

public class RptPlameDetalle implements java.io.Serializable { 

private static final long serialVersionUID = 1L;
private String idtipodocumento; 
private String numerodoc; 
private String c_fte_fto; 
private Integer int_id_tipo_concepto; 
private String var_cod_siaf_concepto; 
private String var_descrip_concepto; 
private Double dec_monto_calculado; 

public String getIdtipodocumento() { 
  return idtipodocumento; 
} 
public void setIdtipodocumento(String idtipodocumento) { 
  this.idtipodocumento = idtipodocumento; 
} 
public String getNumerodoc() { 
  return numerodoc; 
} 
public void setNumerodoc(String numerodoc) { 
  this.numerodoc = numerodoc; 
} 
public String getC_fte_fto() { 
  return c_fte_fto; 
} 
public void setC_fte_fto(String c_fte_fto) { 
  this.c_fte_fto = c_fte_fto; 
} 
public Integer getInt_id_tipo_concepto() { 
  return int_id_tipo_concepto; 
} 
public void setInt_id_tipo_concepto(Integer int_id_tipo_concepto) { 
  this.int_id_tipo_concepto = int_id_tipo_concepto; 
} 
public String getVar_cod_siaf_concepto() { 
  return var_cod_siaf_concepto; 
} 
public void setVar_cod_siaf_concepto(String var_cod_siaf_concepto) { 
  this.var_cod_siaf_concepto = var_cod_siaf_concepto; 
} 
public String getVar_descrip_concepto() { 
  return var_descrip_concepto; 
} 
public void setVar_descrip_concepto(String var_descrip_concepto) { 
  this.var_descrip_concepto = var_descrip_concepto; 
} 
public Double getDec_monto_calculado() { 
  return dec_monto_calculado; 
} 
public void setDec_monto_calculado(Double dec_monto_calculado) { 
  this.dec_monto_calculado = dec_monto_calculado; 
} 

} 
