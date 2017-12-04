package sernanp.app.dao.query.domain; 

import java.util.Collection;
import java.util.List;
import java.util.Map;

public class ReporteProyeccionPlanillasFFQuery implements java.io.Serializable { 

	private static final long serialVersionUID = 1L;
	private Integer idpersonal;
	private String nombre_completo;
	private String apepat;
	private String apemat;
	private String nombre;
	private String numerodoc;
	private String dte_fec_inicio;
	private Integer srl_id_regimen_contractual;
	private String var_descripcion_fuente_financiamiento;
	private String var_descripcion_regimen_contractual;
	private Integer int_anio;
	private String descrip_periodo;
	private Integer int_id_tipo_concepto;
	private String descrip_tipo_concepto;
	private Integer srl_id_concepto_planilla;
	private String var_descrip_corto_concepto;
	private String c_fte_fto;
	private String c_meta;
	private Double dec_monto_calculado;
	private Double dec_total_ingresos;
	private Double dec_total_descuentos;
	private Double dec_total_aportes;
	private Double neto_pagar;
	private List<Map<Object, Object>> listDetalle;
	private Object listMapDetalle_DS;
	private String var_nom_cargo;
	private String ubicacion;
	
	
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
	public Double getDec_monto_calculado() {
		return dec_monto_calculado;
	}
	public void setDec_monto_calculado(Double dec_monto_calculado) {
		this.dec_monto_calculado = dec_monto_calculado;
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
	public Double getNeto_pagar() {
		return neto_pagar;
	}
	public void setNeto_pagar(Double neto_pagar) {
		this.neto_pagar = neto_pagar;
	}
	public String getVar_descripcion_fuente_financiamiento() {
		return var_descripcion_fuente_financiamiento;
	}
	public void setVar_descripcion_fuente_financiamiento(
			String var_descripcion_fuente_financiamiento) {
		this.var_descripcion_fuente_financiamiento = var_descripcion_fuente_financiamiento;
	}
	public Integer getSrl_id_regimen_contractual() {
		return srl_id_regimen_contractual;
	}
	public void setSrl_id_regimen_contractual(Integer srl_id_regimen_contractual) {
		this.srl_id_regimen_contractual = srl_id_regimen_contractual;
	}
	public String getDte_fec_inicio() {
		return dte_fec_inicio;
	}
	public void setDte_fec_inicio(String dte_fec_inicio) {
		this.dte_fec_inicio = dte_fec_inicio;
	}
	public List<Map<Object, Object>> getListDetalle() {
		return listDetalle;
	}
	public void setListDetalle(List<Map<Object, Object>> listDetalle) {
		this.listDetalle = listDetalle;
	}
	public Object getListMapDetalle_DS() {
		return listMapDetalle_DS;
	}
	public void setListMapDetalle_DS(Object listMapDetalle_DS) {
		this.listMapDetalle_DS = listMapDetalle_DS;
	}
	public String getVar_nom_cargo() {
		return var_nom_cargo;
	}
	public void setVar_nom_cargo(String var_nom_cargo) {
		this.var_nom_cargo = var_nom_cargo;
	}
	public String getUbicacion() {
		return ubicacion;
	}
	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}
//	public List<Map<Object, Object>> getListDetalleTotalPorMeta() {
//		return listDetalleTotalPorMeta;
//	}
//	public void setListDetalleTotalPorMeta(List<Map<Object, Object>> listDetalleTotalPorMeta) {
//		this.listDetalleTotalPorMeta = listDetalleTotalPorMeta;
//	}
	
} 
