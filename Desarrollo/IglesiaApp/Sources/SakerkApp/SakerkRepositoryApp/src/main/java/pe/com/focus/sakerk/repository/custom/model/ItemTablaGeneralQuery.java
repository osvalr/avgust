package pe.com.focus.sakerk.repository.custom.model;

public class ItemTablaGeneralQuery implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id_tabla_general_detalle;
	private Integer id_tabla_general;
	private Integer valor_general;
	private String campo_a;

	public Integer getId_tabla_general_detalle() {
		return id_tabla_general_detalle;
	}

	public void setId_tabla_general_detalle(Integer id_tabla_general_detalle) {
		this.id_tabla_general_detalle = id_tabla_general_detalle;
	}

	public Integer getId_tabla_general() {
		return id_tabla_general;
	}

	public void setId_tabla_general(Integer id_tabla_general) {
		this.id_tabla_general = id_tabla_general;
	}

	public Integer getValor_general() {
		return valor_general;
	}

	public void setValor_general(Integer valor_general) {
		this.valor_general = valor_general;
	}

	public String getCampo_a() {
		return campo_a;
	}

	public void setCampo_a(String campo_a) {
		this.campo_a = campo_a;
	}

}
