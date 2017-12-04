package sernanp.app.dao.query.domain;

public class ConvocatoriaPlazaQuery implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer srl_id_conv_area_org;
	private Integer srl_id_convocatoria;
	private Integer srl_id_configuracion_factor_evaluacion;
	private String var_descrip_configuracion;

	private Integer srl_id_configuracion_evaluacion_personal;
	private String var_nombre_configuracion;

	private Integer idarea_solicitante;
	private String descrip_area;
	private Integer idunidad_solicitante;
	private String descrip_unidad;
	private Integer srl_id_requerimiento_personal;
	private String var_numero_requerimiento;
	private String var_numero_requerimiento_corto;
	private String var_codigo_postulacion;
	private Integer int_cantidad_requerida;
	private Integer idpersonal;
	private String nombre;
	private String apepat;
	private String apemat;
	private String nombre_completo;
	private String var_lugar_prestacion;
	private Integer int_id_estado;
	private String descrip_estado;
	
	// ADD 27-01-2016 DAVID
	private String dte_fec_aprobacion_oa;
	
	// ADD 29-01-2016 DAVID 
	
	private String dte_fecha_inicio_contrato;
	private String dte_fecha_fin_contrato;
	
	

	public Integer getSrl_id_conv_area_org() {
		return srl_id_conv_area_org;
	}

	public void setSrl_id_conv_area_org(Integer srl_id_conv_area_org) {
		this.srl_id_conv_area_org = srl_id_conv_area_org;
	}

	public Integer getSrl_id_convocatoria() {
		return srl_id_convocatoria;
	}

	public void setSrl_id_convocatoria(Integer srl_id_convocatoria) {
		this.srl_id_convocatoria = srl_id_convocatoria;
	}

	public Integer getSrl_id_configuracion_factor_evaluacion() {
		return srl_id_configuracion_factor_evaluacion;
	}

	public void setSrl_id_configuracion_factor_evaluacion(
			Integer srl_id_configuracion_factor_evaluacion) {
		this.srl_id_configuracion_factor_evaluacion = srl_id_configuracion_factor_evaluacion;
	}

	public String getVar_descrip_configuracion() {
		return var_descrip_configuracion;
	}

	public void setVar_descrip_configuracion(String var_descrip_configuracion) {
		this.var_descrip_configuracion = var_descrip_configuracion;
	}

	public Integer getIdarea_solicitante() {
		return idarea_solicitante;
	}

	public void setIdarea_solicitante(Integer idarea_solicitante) {
		this.idarea_solicitante = idarea_solicitante;
	}

	public String getDescrip_area() {
		return descrip_area;
	}

	public void setDescrip_area(String descrip_area) {
		this.descrip_area = descrip_area;
	}

	public Integer getIdunidad_solicitante() {
		return idunidad_solicitante;
	}

	public void setIdunidad_solicitante(Integer idunidad_solicitante) {
		this.idunidad_solicitante = idunidad_solicitante;
	}

	public String getDescrip_unidad() {
		return descrip_unidad;
	}

	public void setDescrip_unidad(String descrip_unidad) {
		this.descrip_unidad = descrip_unidad;
	}

	public Integer getSrl_id_requerimiento_personal() {
		return srl_id_requerimiento_personal;
	}

	public void setSrl_id_requerimiento_personal(
			Integer srl_id_requerimiento_personal) {
		this.srl_id_requerimiento_personal = srl_id_requerimiento_personal;
	}

	public String getVar_numero_requerimiento() {
		return var_numero_requerimiento;
	}

	public void setVar_numero_requerimiento(String var_numero_requerimiento) {
		this.var_numero_requerimiento = var_numero_requerimiento;
	}

	public String getVar_numero_requerimiento_corto() {
		return var_numero_requerimiento_corto;
	}

	public void setVar_numero_requerimiento_corto(
			String var_numero_requerimiento_corto) {
		this.var_numero_requerimiento_corto = var_numero_requerimiento_corto;
	}

	public String getVar_codigo_postulacion() {
		return var_codigo_postulacion;
	}

	public void setVar_codigo_postulacion(String var_codigo_postulacion) {
		this.var_codigo_postulacion = var_codigo_postulacion;
	}

	public Integer getInt_cantidad_requerida() {
		return int_cantidad_requerida;
	}

	public void setInt_cantidad_requerida(Integer int_cantidad_requerida) {
		this.int_cantidad_requerida = int_cantidad_requerida;
	}

	public Integer getIdpersonal() {
		return idpersonal;
	}

	public void setIdpersonal(Integer idpersonal) {
		this.idpersonal = idpersonal;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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

	public String getNombre_completo() {
		return nombre_completo;
	}

	public void setNombre_completo(String nombre_completo) {
		this.nombre_completo = nombre_completo;
	}

	public String getVar_lugar_prestacion() {
		return var_lugar_prestacion;
	}

	public void setVar_lugar_prestacion(String var_lugar_prestacion) {
		this.var_lugar_prestacion = var_lugar_prestacion;
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

	public Integer getSrl_id_configuracion_evaluacion_personal() {
		return srl_id_configuracion_evaluacion_personal;
	}

	public void setSrl_id_configuracion_evaluacion_personal(
			Integer srl_id_configuracion_evaluacion_personal) {
		this.srl_id_configuracion_evaluacion_personal = srl_id_configuracion_evaluacion_personal;
	}

	public String getVar_nombre_configuracion() {
		return var_nombre_configuracion;
	}

	public void setVar_nombre_configuracion(String var_nombre_configuracion) {
		this.var_nombre_configuracion = var_nombre_configuracion;
	}

	public String getDte_fec_aprobacion_oa() {
		return dte_fec_aprobacion_oa;
	}

	public void setDte_fec_aprobacion_oa(String dte_fec_aprobacion_oa) {
		this.dte_fec_aprobacion_oa = dte_fec_aprobacion_oa;
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
