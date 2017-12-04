package sernanp.app.dao.query.domain; 

public class RpNominaDescuentosQuery implements java.io.Serializable { 

private static final long serialVersionUID = 1L;

public Integer idpersonal;
public String nombre_completo;
public String numerodoc;
public String var_descripcion_regimen_contractual;
public Integer int_anio;
public String descrip_periodo;
public Integer srl_id_regimen_pensionario;
public String var_descripcion_regimen_pensionario;
public Double dec_total_descuentos;
public String c_fte_fto;
public String c_meta;


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
public void setVar_descripcion_regimen_contractual(
		String var_descripcion_regimen_contractual) {
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
public Integer getSrl_id_regimen_pensionario() {
	return srl_id_regimen_pensionario;
}
public void setSrl_id_regimen_pensionario(Integer srl_id_regimen_pensionario) {
	this.srl_id_regimen_pensionario = srl_id_regimen_pensionario;
}
public String getVar_descripcion_regimen_pensionario() {
	return var_descripcion_regimen_pensionario;
}
public void setVar_descripcion_regimen_pensionario(
		String var_descripcion_regimen_pensionario) {
	this.var_descripcion_regimen_pensionario = var_descripcion_regimen_pensionario;
}
public Double getDec_total_descuentos() {
	return dec_total_descuentos;
}
public void setDec_total_descuentos(Double dec_total_descuentos) {
	this.dec_total_descuentos = dec_total_descuentos;
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



} 
