package sernanp.app.dao.query.domain;

public class AreaOrganicaQuery {

	private Integer idarea;
	private String descrip_dependencia;
	private String descrip_dependencia_alterno;

	public String getDescrip_dependencia() {
		return descrip_dependencia;
	}

	public void setDescrip_dependencia(String descrip_dependencia) {
		this.descrip_dependencia = descrip_dependencia;
	}

	public Integer getIdarea() {
		return idarea;
	}

	public void setIdarea(Integer idarea) {
		this.idarea = idarea;
	}

	public String getDescrip_dependencia_alterno() {
		return descrip_dependencia_alterno;
	}

	public void setDescrip_dependencia_alterno(
			String descrip_dependencia_alterno) {
		this.descrip_dependencia_alterno = descrip_dependencia_alterno;
	}
}
