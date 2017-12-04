package sernanp.app.dao.query.domain; 

public class ReporteResumenNominaPagoFFMP_728Query implements java.io.Serializable { 

private static final long serialVersionUID = 1L;
private String var_descrip_concepto; 
private Double remuneracion; 
private Double obligaciones; 
private Double bonificacion;
private String descrip_periodo;
private String c_fte_fto;
private String c_meta;
private Integer int_anio;
private Double dec_monto_calculado;
private Double total_apertura;

public String getVar_descrip_concepto() { 
  return var_descrip_concepto; 
} 
public void setVar_descrip_concepto(String var_descrip_concepto) { 
  this.var_descrip_concepto = var_descrip_concepto; 
} 
public Double getRemuneracion() { 
  return remuneracion; 
} 
public void setRemuneracion(Double remuneracion) { 
  this.remuneracion = remuneracion; 
} 
public Double getObligaciones() { 
  return obligaciones; 
} 
public void setObligaciones(Double obligaciones) { 
  this.obligaciones = obligaciones; 
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
public Integer getInt_anio() {
	return int_anio;
}
public void setInt_anio(Integer int_anio) {
	this.int_anio = int_anio;
}
public Double getDec_monto_calculado() {
	return dec_monto_calculado;
}
public void setDec_monto_calculado(Double dec_monto_calculado) {
	this.dec_monto_calculado = dec_monto_calculado;
}
public Double getTotal_apertura() {
	return total_apertura;
}
public void setTotal_apertura(Double total_apertura) {
	this.total_apertura = total_apertura;
}
public Double getBonificacion() {
	return bonificacion;
}
public void setBonificacion(Double bonificacion) {
	this.bonificacion = bonificacion;
}



} 
