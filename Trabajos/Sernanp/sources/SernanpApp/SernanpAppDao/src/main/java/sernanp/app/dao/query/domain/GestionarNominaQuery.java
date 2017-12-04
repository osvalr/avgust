package sernanp.app.dao.query.domain;

public class GestionarNominaQuery implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer srl_id_nomina_anio_periodo_personal;
	private Integer srl_id_anio_planilla;
	private Integer int_anio;
	private Integer srl_id_anio_periodo_planilla;
	private Integer int_id_periodo_mes;
	private String descrip_periodo;
	private Integer idpersona;
	private Integer idpersonanatural;
	private Integer idpersonal;
	private String nombre_completo;
	private String nombre;
	private String apepat;
	private String apemat;
	private Integer idtipodocumento;
	private String descrip_documento;
	private String numerodoc;
	private String ruc;
	private Integer srl_id_regimen_contractual;
	private String var_descripcion_regimen_contractual;
	private Integer srl_id_cargo;
	private String c_fte_fto;
	private String c_meta;
	private String var_nom_cargo;
	private Double dec_total_ingresos;
	private Double dec_total_descuentos;
	private Double dec_total_aportes;
	private Double dec_total_neto;
	private Integer int_id_estado;
	private String descrip_estado;
	private String tsp_fecha_registro;

	public Integer getSrl_id_nomina_anio_periodo_personal() {
		return srl_id_nomina_anio_periodo_personal;
	}

	public void setSrl_id_nomina_anio_periodo_personal(
			Integer srl_id_nomina_anio_periodo_personal) {
		this.srl_id_nomina_anio_periodo_personal = srl_id_nomina_anio_periodo_personal;
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

	public Integer getSrl_id_anio_periodo_planilla() {
		return srl_id_anio_periodo_planilla;
	}

	public void setSrl_id_anio_periodo_planilla(
			Integer srl_id_anio_periodo_planilla) {
		this.srl_id_anio_periodo_planilla = srl_id_anio_periodo_planilla;
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

	public Integer getIdpersona() {
		return idpersona;
	}

	public void setIdpersona(Integer idpersona) {
		this.idpersona = idpersona;
	}

	public Integer getIdpersonanatural() {
		return idpersonanatural;
	}

	public void setIdpersonanatural(Integer idpersonanatural) {
		this.idpersonanatural = idpersonanatural;
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

	public Integer getIdtipodocumento() {
		return idtipodocumento;
	}

	public void setIdtipodocumento(Integer idtipodocumento) {
		this.idtipodocumento = idtipodocumento;
	}

	public String getDescrip_documento() {
		return descrip_documento;
	}

	public void setDescrip_documento(String descrip_documento) {
		this.descrip_documento = descrip_documento;
	}

	public String getNumerodoc() {
		return numerodoc;
	}

	public void setNumerodoc(String numerodoc) {
		this.numerodoc = numerodoc;
	}

	public String getRuc() {
		return ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
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

	public Integer getSrl_id_cargo() {
		return srl_id_cargo;
	}

	public void setSrl_id_cargo(Integer srl_id_cargo) {
		this.srl_id_cargo = srl_id_cargo;
	}

	public String getVar_nom_cargo() {
		return var_nom_cargo;
	}

	public void setVar_nom_cargo(String var_nom_cargo) {
		this.var_nom_cargo = var_nom_cargo;
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

	public Double getDec_total_neto() {
		return dec_total_neto;
	}

	public void setDec_total_neto(Double dec_total_neto) {
		this.dec_total_neto = dec_total_neto;
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
