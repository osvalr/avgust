package sernanp.app.dao.query.domain;


public class GestionarIngresoDescuentoQuery implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer srl_id_ingreso_descuento_planilla;
	private Integer int_id_tipo_ingreso_descuento;
	private String descrip_tipo_ingreso_descuento;
	private Integer int_id_subtipo_ingreso_descuento;
	private String descrip_subtipo_ingreso_descuento;
	private String var_cod_ingreso_descuento;
	private String var_descrip_corto_ingreso_descuento;
	private String var_descrip_ingreso_descuento;
	private String var_cod_pdt;
	private String var_cod_mef;
	private Integer srl_id_afp;
	private String var_cod_afp;
	private String var_nombre_afp;
	private Integer int_id_tipo_monto;
	private String descrip_tipo_monto;
	private Double dec_monto_ingreso_descuento;
	private Integer int_id_estado;
	private String descrip_estado;
	private String tsp_fecha_registro;

	public Integer getInt_id_subtipo_ingreso_descuento() {
		return int_id_subtipo_ingreso_descuento;
	}

	public void setInt_id_subtipo_ingreso_descuento(
			Integer int_id_subtipo_ingreso_descuento) {
		this.int_id_subtipo_ingreso_descuento = int_id_subtipo_ingreso_descuento;
	}

	public String getDescrip_subtipo_ingreso_descuento() {
		return descrip_subtipo_ingreso_descuento;
	}

	public void setDescrip_subtipo_ingreso_descuento(
			String descrip_subtipo_ingreso_descuento) {
		this.descrip_subtipo_ingreso_descuento = descrip_subtipo_ingreso_descuento;
	}

	public Integer getSrl_id_ingreso_descuento_planilla() {
		return srl_id_ingreso_descuento_planilla;
	}

	public void setSrl_id_ingreso_descuento_planilla(
			Integer srl_id_ingreso_descuento_planilla) {
		this.srl_id_ingreso_descuento_planilla = srl_id_ingreso_descuento_planilla;
	}

	public String getVar_cod_ingreso_descuento() {
		return var_cod_ingreso_descuento;
	}

	public void setVar_cod_ingreso_descuento(String var_cod_ingreso_descuento) {
		this.var_cod_ingreso_descuento = var_cod_ingreso_descuento;
	}

	public String getVar_descrip_ingreso_descuento() {
		return var_descrip_ingreso_descuento;
	}

	public void setVar_descrip_ingreso_descuento(
			String var_descrip_ingreso_descuento) {
		this.var_descrip_ingreso_descuento = var_descrip_ingreso_descuento;
	}

	public String getVar_descrip_corto_ingreso_descuento() {
		return var_descrip_corto_ingreso_descuento;
	}

	public void setVar_descrip_corto_ingreso_descuento(
			String var_descrip_corto_ingreso_descuento) {
		this.var_descrip_corto_ingreso_descuento = var_descrip_corto_ingreso_descuento;
	}

	public String getVar_cod_pdt() {
		return var_cod_pdt;
	}

	public void setVar_cod_pdt(String var_cod_pdt) {
		this.var_cod_pdt = var_cod_pdt;
	}

	public String getVar_cod_mef() {
		return var_cod_mef;
	}

	public void setVar_cod_mef(String var_cod_mef) {
		this.var_cod_mef = var_cod_mef;
	}

	public Integer getSrl_id_afp() {
		return srl_id_afp;
	}

	public void setSrl_id_afp(Integer srl_id_afp) {
		this.srl_id_afp = srl_id_afp;
	}

	public String getVar_cod_afp() {
		return var_cod_afp;
	}

	public void setVar_cod_afp(String var_cod_afp) {
		this.var_cod_afp = var_cod_afp;
	}

	public String getVar_nombre_afp() {
		return var_nombre_afp;
	}

	public void setVar_nombre_afp(String var_nombre_afp) {
		this.var_nombre_afp = var_nombre_afp;
	}

	public Integer getInt_id_tipo_ingreso_descuento() {
		return int_id_tipo_ingreso_descuento;
	}

	public void setInt_id_tipo_ingreso_descuento(
			Integer int_id_tipo_ingreso_descuento) {
		this.int_id_tipo_ingreso_descuento = int_id_tipo_ingreso_descuento;
	}

	public String getDescrip_tipo_ingreso_descuento() {
		return descrip_tipo_ingreso_descuento;
	}

	public void setDescrip_tipo_ingreso_descuento(
			String descrip_tipo_ingreso_descuento) {
		this.descrip_tipo_ingreso_descuento = descrip_tipo_ingreso_descuento;
	}

	public Integer getInt_id_tipo_monto() {
		return int_id_tipo_monto;
	}

	public void setInt_id_tipo_monto(Integer int_id_tipo_monto) {
		this.int_id_tipo_monto = int_id_tipo_monto;
	}

	public String getDescrip_tipo_monto() {
		return descrip_tipo_monto;
	}

	public void setDescrip_tipo_monto(String descrip_tipo_monto) {
		this.descrip_tipo_monto = descrip_tipo_monto;
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

	public Double getDec_monto_ingreso_descuento() {
		return dec_monto_ingreso_descuento;
	}

	public void setDec_monto_ingreso_descuento(
			Double dec_monto_ingreso_descuento) {
		this.dec_monto_ingreso_descuento = dec_monto_ingreso_descuento;
	}

	public String getTsp_fecha_registro() {
		return tsp_fecha_registro;
	}

	public void setTsp_fecha_registro(String tsp_fecha_registro) {
		this.tsp_fecha_registro = tsp_fecha_registro;
	}

}
