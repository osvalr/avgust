package sernanp.app.dao.query.domain;

public class ResponsablePlazaQuery implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer srl_id_conv_area_org;
	private Integer idpersonal;
	private Integer srl_id_convocatoria;
	private String var_num_convocatoria;
	private String var_codigo_postulacion;

	public Integer getSrl_id_conv_area_org() {
		return srl_id_conv_area_org;
	}

	public void setSrl_id_conv_area_org(Integer srl_id_conv_area_org) {
		this.srl_id_conv_area_org = srl_id_conv_area_org;
	}

	public Integer getIdpersonal() {
		return idpersonal;
	}

	public void setIdpersonal(Integer idpersonal) {
		this.idpersonal = idpersonal;
	}

	public Integer getSrl_id_convocatoria() {
		return srl_id_convocatoria;
	}

	public void setSrl_id_convocatoria(Integer srl_id_convocatoria) {
		this.srl_id_convocatoria = srl_id_convocatoria;
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

}
