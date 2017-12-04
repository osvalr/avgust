package sernanp.app.dao.query.domain;

public class PostulanteGanadorQueryCriteria {

	private String nombres;
	private Integer tipoDoc;
	private String numerodoc;
	private String numeroRuc;
	private Integer srl_id_convocatoria;
	private Integer srl_id_conv_area_org;
	private String int_id_estado;
	private Integer idarea;
	private Integer idunidad;

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public Integer getTipoDoc() {
		return tipoDoc;
	}

	public void setTipoDoc(Integer tipoDoc) {
		this.tipoDoc = tipoDoc;
	}

	public String getNumerodoc() {
		return numerodoc;
	}

	public void setNumerodoc(String numerodoc) {
		this.numerodoc = numerodoc;
	}

	public String getNumeroRuc() {
		return numeroRuc;
	}

	public void setNumeroRuc(String numeroRuc) {
		this.numeroRuc = numeroRuc;
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

	public String getInt_id_estado() {
		return int_id_estado;
	}

	public void setInt_id_estado(String int_id_estado) {
		this.int_id_estado = int_id_estado;
	}

	public Integer getIdarea() {
		return idarea;
	}

	public void setIdarea(Integer idarea) {
		this.idarea = idarea;
	}

	public Integer getIdunidad() {
		return idunidad;
	}

	public void setIdunidad(Integer idunidad) {
		this.idunidad = idunidad;
	}

	@Override
	public String toString() {
		return "ResumenPostulacionPersonaQueryCriteria [nombres=" + nombres
				+ ", tipoDoc=" + tipoDoc + ", numerodoc=" + numerodoc
				+ ", numeroRuc=" + numeroRuc + ", srl_id_convocatoria="
				+ srl_id_convocatoria + ", srl_id_conv_area_org="
				+ srl_id_conv_area_org + ", int_id_estado=" + int_id_estado
				+ ", idarea=" + idarea + ", idunidad=" + idunidad + "]";
	}

}
