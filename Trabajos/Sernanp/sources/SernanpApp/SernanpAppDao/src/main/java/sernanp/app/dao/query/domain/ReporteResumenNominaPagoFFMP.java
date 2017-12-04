package sernanp.app.dao.query.domain; 

public class ReporteResumenNominaPagoFFMP implements java.io.Serializable { 

private static final long serialVersionUID = 1L;
private String var_nombre_afp; 
private String var_descrip_concepto; 
private Double dec_monto_calculado; 

public String getVar_nombre_afp() { 
  return var_nombre_afp; 
} 
public void setVar_nombre_afp(String var_nombre_afp) { 
  this.var_nombre_afp = var_nombre_afp; 
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
