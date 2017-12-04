package sernanp.app.dao.query.domain;

import java.util.List;

public class ConceptoPersonalQuery implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer srl_id_personal_concepto;
	private Integer idpersonal;
	private Integer int_id_tipo_concepto;
	private String descrip_tipo_concepto;
	private Integer int_id_sub_tipo_concepto;
	private String descrip_sub_tipo_concepto;
	private Integer srl_id_concepto_planilla;
	private String var_descrip_corto_concepto;
	private Integer int_id_tipo_monto_concepto;
	private String descrip_tipo_monto;
	private Double dec_monto_concepto;
	private Integer srl_id_beneficiario_descuento_judicial;
	private String var_descripcion_descuento;
	
	private Integer int_aplica_afectos;
	private String descrip_aplica_afectos;
	private Integer int_aplica_frecuencias;
	private String descrip_aplica_frecuencias;
	private Integer srl_id_anio_planilla;
	private Integer int_anio;
	
	private Integer int_id_estado;
	private String descrip_estado;
	private String tsp_fecha_registro;
	private List<PersonalConceptoFrecuenciaQuery> listPersonalConceptoFrecuenciaQuery;
	private List<PersonalConceptoAfectoQuery> listPersonalConceptoAfectoQuery;
	
	public Integer getSrl_id_personal_concepto() {
		return srl_id_personal_concepto;
	}

	public void setSrl_id_personal_concepto(Integer srl_id_personal_concepto) {
		this.srl_id_personal_concepto = srl_id_personal_concepto;
	}

	public Integer getIdpersonal() {
		return idpersonal;
	}

	public void setIdpersonal(Integer idpersonal) {
		this.idpersonal = idpersonal;
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

	public Integer getInt_id_sub_tipo_concepto() {
		return int_id_sub_tipo_concepto;
	}

	public void setInt_id_sub_tipo_concepto(Integer int_id_sub_tipo_concepto) {
		this.int_id_sub_tipo_concepto = int_id_sub_tipo_concepto;
	}

	public String getDescrip_sub_tipo_concepto() {
		return descrip_sub_tipo_concepto;
	}

	public void setDescrip_sub_tipo_concepto(String descrip_sub_tipo_concepto) {
		this.descrip_sub_tipo_concepto = descrip_sub_tipo_concepto;
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

	public Integer getInt_id_tipo_monto_concepto() {
		return int_id_tipo_monto_concepto;
	}

	public void setInt_id_tipo_monto_concepto(Integer int_id_tipo_monto_concepto) {
		this.int_id_tipo_monto_concepto = int_id_tipo_monto_concepto;
	}

	public String getDescrip_tipo_monto() {
		return descrip_tipo_monto;
	}

	public void setDescrip_tipo_monto(String descrip_tipo_monto) {
		this.descrip_tipo_monto = descrip_tipo_monto;
	}

	public Double getDec_monto_concepto() {
		return dec_monto_concepto;
	}

	public void setDec_monto_concepto(Double dec_monto_concepto) {
		this.dec_monto_concepto = dec_monto_concepto;
	}

	public Integer getSrl_id_beneficiario_descuento_judicial() {
		return srl_id_beneficiario_descuento_judicial;
	}

	public void setSrl_id_beneficiario_descuento_judicial(
			Integer srl_id_beneficiario_descuento_judicial) {
		this.srl_id_beneficiario_descuento_judicial = srl_id_beneficiario_descuento_judicial;
	}

	public String getVar_descripcion_descuento() {
		return var_descripcion_descuento;
	}

	public void setVar_descripcion_descuento(String var_descripcion_descuento) {
		this.var_descripcion_descuento = var_descripcion_descuento;
	}

	public Integer getInt_id_estado() {
		return int_id_estado;
	}

	public void setInt_id_estado(Integer int_id_estado) {
		this.int_id_estado = int_id_estado;
	}

	public String getDescrip_estado() {
		return descrip_estado;
	}

	public void setDescrip_estado(String descrip_estado) {
		this.descrip_estado = descrip_estado;
	}

	public String getTsp_fecha_registro() {
		return tsp_fecha_registro;
	}

	public void setTsp_fecha_registro(String tsp_fecha_registro) {
		this.tsp_fecha_registro = tsp_fecha_registro;
	}

	public List<PersonalConceptoFrecuenciaQuery> getListPersonalConceptoFrecuenciaQuery() {
		return listPersonalConceptoFrecuenciaQuery;
	}

	public void setListPersonalConceptoFrecuenciaQuery(
			List<PersonalConceptoFrecuenciaQuery> listPersonalConceptoFrecuenciaQuery) {
		this.listPersonalConceptoFrecuenciaQuery = listPersonalConceptoFrecuenciaQuery;
	}

	public List<PersonalConceptoAfectoQuery> getListPersonalConceptoAfectoQuery() {
		return listPersonalConceptoAfectoQuery;
	}

	public void setListPersonalConceptoAfectoQuery(
			List<PersonalConceptoAfectoQuery> listPersonalConceptoAfectoQuery) {
		this.listPersonalConceptoAfectoQuery = listPersonalConceptoAfectoQuery;
	}

	public Integer getInt_aplica_afectos() {
		return int_aplica_afectos;
	}

	public void setInt_aplica_afectos(Integer int_aplica_afectos) {
		this.int_aplica_afectos = int_aplica_afectos;
	}

	public String getDescrip_aplica_afectos() {
		return descrip_aplica_afectos;
	}

	public void setDescrip_aplica_afectos(String descrip_aplica_afectos) {
		this.descrip_aplica_afectos = descrip_aplica_afectos;
	}

	public Integer getInt_aplica_frecuencias() {
		return int_aplica_frecuencias;
	}

	public void setInt_aplica_frecuencias(Integer int_aplica_frecuencias) {
		this.int_aplica_frecuencias = int_aplica_frecuencias;
	}

	public String getDescrip_aplica_frecuencias() {
		return descrip_aplica_frecuencias;
	}

	public void setDescrip_aplica_frecuencias(String descrip_aplica_frecuencias) {
		this.descrip_aplica_frecuencias = descrip_aplica_frecuencias;
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

}
