package sernanp.app.dao.query.domain;

public class CodigoPostulacionDisponibleQuery {

	private Integer srl_id_conv_area_org;
	private Integer idarea;
	private Integer srl_id_convocatoria;
	private String var_codigo_postulacion;

	public Integer getIdarea() {
		return idarea;
	}

	public void setIdarea(Integer idarea) {
		this.idarea = idarea;
	}

	public Integer getSrl_id_convocatoria() {
		return srl_id_convocatoria;
	}

	public void setSrl_id_convocatoria(Integer srl_id_convocatoria) {
		this.srl_id_convocatoria = srl_id_convocatoria;
	}

	public Integer getSrl_id_conv_area_org() {
		return srl_id_conv_area_org;
	}

	public void setSrl_id_conv_area_org(Integer srl_id_conv_area_org) {
		this.srl_id_conv_area_org = srl_id_conv_area_org;
	}

	public String getVar_codigo_postulacion() {
		return var_codigo_postulacion;
	}

	public void setVar_codigo_postulacion(String var_codigo_postulacion) {
		this.var_codigo_postulacion = var_codigo_postulacion;
	}

}
