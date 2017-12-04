package sernanp.app.dao.query.domain; 

public class RptREMDetalle implements java.io.Serializable { 

private static final long serialVersionUID = 1L;
private String idtipodocumento; 
private String numerodoc; 
private String var_cod_pdt_concepto;
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
public String getVar_cod_pdt_concepto() {
	return var_cod_pdt_concepto;
}
public void setVar_cod_pdt_concepto(String var_cod_pdt_concepto) {
	this.var_cod_pdt_concepto = var_cod_pdt_concepto;
}
public Double getDec_monto_calculado() {
	return dec_monto_calculado;
}
public void setDec_monto_calculado(Double dec_monto_calculado) {
	this.dec_monto_calculado = dec_monto_calculado;
} 


} 
