package sernanp.app.business.dto;

public class ResultRegistroConvocatoriaDto {
	
	private Integer idConvocatoria;
	private Integer idConvocatoriaAreaOrganica;

	public Integer getIdConvocatoria() {
		return idConvocatoria;
	}

	public void setIdConvocatoria(Integer idConvocatoria) {
		this.idConvocatoria = idConvocatoria;
	}

	public Integer getIdConvocatoriaAreaOrganica() {
		return idConvocatoriaAreaOrganica;
	}

	public void setIdConvocatoriaAreaOrganica(Integer idConvocatoriaAreaOrganica) {
		this.idConvocatoriaAreaOrganica = idConvocatoriaAreaOrganica;
	}

	@Override
	public String toString() {
		return "ResultRegistroConvocatoriaDto [idConvocatoria="
				+ idConvocatoria + ", idConvocatoriaAreaOrganica="
				+ idConvocatoriaAreaOrganica + "]";
	}

}
