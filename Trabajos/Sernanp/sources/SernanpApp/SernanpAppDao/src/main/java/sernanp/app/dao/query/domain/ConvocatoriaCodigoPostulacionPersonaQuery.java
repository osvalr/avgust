package sernanp.app.dao.query.domain;

import java.math.BigDecimal;

public class ConvocatoriaCodigoPostulacionPersonaQuery {

	private Integer srl_id_postulante_conv_area_org;
	private Integer int_id_postulante;
	private String var_num_convocatoria;
	private String var_codigo_postulacion;
	private String descrip_completa;
	private Integer idunidad;
	private String nomunidad;
	private Integer idsede;
	private String sede_direccion;
	private String nombre_dependencia;
	
	//ADD 01-02-2016  -- DAVID
	private BigDecimal dec_honorario_personal;
	private String dte_fecha_inicio_contrato;
	private String dte_fecha_fin_contrato; 

	public Integer getSrl_id_postulante_conv_area_org() {
		return srl_id_postulante_conv_area_org;
	}

	public void setSrl_id_postulante_conv_area_org(
			Integer srl_id_postulante_conv_area_org) {
		this.srl_id_postulante_conv_area_org = srl_id_postulante_conv_area_org;
	}

	public Integer getInt_id_postulante() {
		return int_id_postulante;
	}

	public void setInt_id_postulante(Integer int_id_postulante) {
		this.int_id_postulante = int_id_postulante;
	}

	public String getVar_num_convocatoria() {
		return var_num_convocatoria;
	}

	public void setVar_num_convocatoria(String var_num_convocatoria) {
		this.var_num_convocatoria = var_num_convocatoria;
	}

	public String getVar_codigo_postulacion() {
		return var_codigo_postulacion;
	}

	public void setVar_codigo_postulacion(String var_codigo_postulacion) {
		this.var_codigo_postulacion = var_codigo_postulacion;
	}

	@Override
	public String toString() {
		return "ConvocatoriaCodigoPostulacionPersonaQuery [srl_id_postulante_conv_area_org="
				+ srl_id_postulante_conv_area_org
				+ ", int_id_postulante="
				+ int_id_postulante
				+ ", var_num_convocatoria="
				+ var_num_convocatoria
				+ ", var_codigo_postulacion="
				+ var_codigo_postulacion + "]";
	}

	public String getDescrip_completa() {
		return descrip_completa;
	}

	public void setDescrip_completa(String descrip_completa) {
		this.descrip_completa = descrip_completa;
	}

	public Integer getIdunidad() {
		return idunidad;
	}

	public void setIdunidad(Integer idunidad) {
		this.idunidad = idunidad;
	}

	public String getNomunidad() {
		return nomunidad;
	}

	public void setNomunidad(String nomunidad) {
		this.nomunidad = nomunidad;
	}

	public Integer getIdsede() {
		return idsede;
	}

	public void setIdsede(Integer idsede) {
		this.idsede = idsede;
	}

	public String getSede_direccion() {
		return sede_direccion;
	}

	public void setSede_direccion(String sede_direccion) {
		this.sede_direccion = sede_direccion;
	}

	public String getNombre_dependencia() {
		return nombre_dependencia;
	}

	public void setNombre_dependencia(String nombre_dependencia) {
		this.nombre_dependencia = nombre_dependencia;
	}

	public BigDecimal getDec_honorario_personal() {
		return dec_honorario_personal;
	}

	public void setDec_honorario_personal(BigDecimal dec_honorario_personal) {
		this.dec_honorario_personal = dec_honorario_personal;
	}

	public String getDte_fecha_inicio_contrato() {
		return dte_fecha_inicio_contrato;
	}

	public void setDte_fecha_inicio_contrato(String dte_fecha_inicio_contrato) {
		this.dte_fecha_inicio_contrato = dte_fecha_inicio_contrato;
	}

	public String getDte_fecha_fin_contrato() {
		return dte_fecha_fin_contrato;
	}

	public void setDte_fecha_fin_contrato(String dte_fecha_fin_contrato) {
		this.dte_fecha_fin_contrato = dte_fecha_fin_contrato;
	}

}
