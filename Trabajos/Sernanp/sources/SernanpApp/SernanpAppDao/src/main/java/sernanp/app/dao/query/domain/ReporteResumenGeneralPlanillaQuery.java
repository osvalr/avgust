package sernanp.app.dao.query.domain; 

public class ReporteResumenGeneralPlanillaQuery implements java.io.Serializable { 

private static final long serialVersionUID = 1L;
private Integer idpersonal; 
private Integer idpersonanatural; 
private String nombre_completo; 
private String numerodoc; 
private String dte_fec_inicio; 
private Integer srl_id_regimen_contractual; 
private String var_descripcion_regimen_contractual; 
private Integer srl_id_anio_planilla; 
private Integer int_anio; 
private Integer int_id_periodo_mes; 
private String descrip_periodo; 
private String c_meta; 
private String c_fte_fto; 
private String var_descripcion_fuente_financiamiento;


public Integer getIdpersonal() {
	return idpersonal;
}
public void setIdpersonal(Integer idpersonal) {
	this.idpersonal = idpersonal;
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
public String getNumerodoc() {
	return numerodoc;
}
public void setNumerodoc(String numerodoc) {
	this.numerodoc = numerodoc;
}
public String getDte_fec_inicio() {
	return dte_fec_inicio;
}
public void setDte_fec_inicio(String dte_fec_inicio) {
	this.dte_fec_inicio = dte_fec_inicio;
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
public void setVar_descripcion_regimen_contractual(
		String var_descripcion_regimen_contractual) {
	this.var_descripcion_regimen_contractual = var_descripcion_regimen_contractual;
}
public Integer getSrl_id_anio_planilla() {
	return srl_id_anio_planilla;
}
public void setSrl_id_anio_planilla(Integer srl_id_anio_planilla) {
	this.srl_id_anio_planilla = srl_id_anio_planilla;
}
public Integer getInt_anio() {
	return int_anio;
}
public void setInt_anio(Integer int_anio) {
	this.int_anio = int_anio;
}
public Integer getInt_id_periodo_mes() {
	return int_id_periodo_mes;
}
public void setInt_id_periodo_mes(Integer int_id_periodo_mes) {
	this.int_id_periodo_mes = int_id_periodo_mes;
}
public String getDescrip_periodo() {
	return descrip_periodo;
}
public void setDescrip_periodo(String descrip_periodo) {
	this.descrip_periodo = descrip_periodo;
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
public String getVar_descripcion_fuente_financiamiento() {
	return var_descripcion_fuente_financiamiento;
}
public void setVar_descripcion_fuente_financiamiento(
		String var_descripcion_fuente_financiamiento) {
	this.var_descripcion_fuente_financiamiento = var_descripcion_fuente_financiamiento;
}



} 
