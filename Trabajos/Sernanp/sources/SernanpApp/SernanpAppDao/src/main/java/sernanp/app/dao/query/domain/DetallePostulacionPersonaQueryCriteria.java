package sernanp.app.dao.query.domain;

public class DetallePostulacionPersonaQueryCriteria {

	private Integer idpersona;
	private Integer idpersonanatural;
	private Integer int_id_postulante;
	private Integer idtipodocumento;
	private String numerodoc;
	private String ruc;
	private Integer int_id_estado;
	private Integer srl_id_postulante_conv_area_org;
	
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

	public Integer getInt_id_postulante() {
		return int_id_postulante;
	}

	public void setInt_id_postulante(Integer int_id_postulante) {
		this.int_id_postulante = int_id_postulante;
	}

	public Integer getIdtipodocumento() {
		return idtipodocumento;
	}

	public void setIdtipodocumento(Integer idtipodocumento) {
		this.idtipodocumento = idtipodocumento;
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

	public Integer getInt_id_estado() {
		return int_id_estado;
	}

	public void setInt_id_estado(Integer int_id_estado) {
		this.int_id_estado = int_id_estado;
	}

	public Integer getSrl_id_postulante_conv_area_org() {
		return srl_id_postulante_conv_area_org;
	}

	public void setSrl_id_postulante_conv_area_org(
			Integer srl_id_postulante_conv_area_org) {
		this.srl_id_postulante_conv_area_org = srl_id_postulante_conv_area_org;
	}

	@Override
	public String toString() {
		return "DetallePostulacionPersonaQueryCriteria [idpersona=" + idpersona
				+ ", idpersonanatural=" + idpersonanatural
				+ ", int_id_postulante=" + int_id_postulante
				+ ", idtipodocumento=" + idtipodocumento + ", numerodoc="
				+ numerodoc + ", ruc=" + ruc + ", int_id_estado="
				+ int_id_estado + ", srl_id_postulante_conv_area_org="
				+ srl_id_postulante_conv_area_org + "]";
	}

}
