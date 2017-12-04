package pe.com.focus.sakerk.repository.custom.model;

public class RegistroPersonaJuridicaQuery implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id_persona_juridica;
	private Integer id_tipo_persona_juridica;
	private String razon_social;

	public Integer getId_persona_juridica() {
		return id_persona_juridica;
	}

	public void setId_persona_juridica(Integer id_persona_juridica) {
		this.id_persona_juridica = id_persona_juridica;
	}

	public Integer getId_tipo_persona_juridica() {
		return id_tipo_persona_juridica;
	}

	public void setId_tipo_persona_juridica(Integer id_tipo_persona_juridica) {
		this.id_tipo_persona_juridica = id_tipo_persona_juridica;
	}

	public String getRazon_social() {
		return razon_social;
	}

	public void setRazon_social(String razon_social) {
		this.razon_social = razon_social;
	}

}
