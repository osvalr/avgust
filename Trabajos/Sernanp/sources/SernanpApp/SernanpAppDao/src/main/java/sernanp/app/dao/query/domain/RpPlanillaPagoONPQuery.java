package sernanp.app.dao.query.domain; 

public class RpPlanillaPagoONPQuery implements java.io.Serializable { 

private static final long serialVersionUID = 1L;

private Integer int_anio;
private Integer int_id_periodo_mes;
private String descrip_periodo;
private String nombre_completo;
private String apepat;
private String apemat;
private String nombre;
private String c_meta;
private String c_fte_fto;
private Integer srl_id_regimen_contractual;
private String var_descripcion_regimen_contractual;
private Double fondo_pension;
private Double sueldo;
private String numerodoc;

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
public String getNombre_completo() {
	return nombre_completo;
}
public void setNombre_completo(String nombre_completo) {
	this.nombre_completo = nombre_completo;
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
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
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
public Double getFondo_pension() {
	return fondo_pension;
}
public void setFondo_pension(Double fondo_pension) {
	this.fondo_pension = fondo_pension;
}
public Double getSueldo() {
	return sueldo;
}
public void setSueldo(Double sueldo) {
	this.sueldo = sueldo;
}
public String getNumerodoc() {
	return numerodoc;
}
public void setNumerodoc(String numerodoc) {
	this.numerodoc = numerodoc;
}



} 
