package sernanp.app.dao.query.domain;

public class InfoPersonalConstanciaQuery {

	private Integer idpersonal;
	private String nombre;
	private String apepat;
	private String apemat;
	private String numerodoc;
	private String var_descripcion_regimen_contractual;
	private String tipoDoc;

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

	public String getNumerodoc() {
		return numerodoc;
	}

	public void setNumerodoc(String numerodoc) {
		this.numerodoc = numerodoc;
	}

	public String getVar_descripcion_regimen_contractual() {
		return var_descripcion_regimen_contractual;
	}

	public void setVar_descripcion_regimen_contractual(
			String var_descripcion_regimen_contractual) {
		this.var_descripcion_regimen_contractual = var_descripcion_regimen_contractual;
	}

	public String getTipoDoc() {
		return tipoDoc;
	}

	public void setTipoDoc(String tipoDoc) {
		this.tipoDoc = tipoDoc;
	}

}
