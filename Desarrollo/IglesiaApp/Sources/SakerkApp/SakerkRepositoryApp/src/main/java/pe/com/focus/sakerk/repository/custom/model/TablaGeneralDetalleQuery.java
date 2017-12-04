package pe.com.focus.sakerk.repository.custom.model;

public class TablaGeneralDetalleQuery implements java.io.Serializable {

	private static final long serialVersionUID = -8087445546045517246L;
	
	private Integer id_tabla_general_detalle;
	private Integer id_tabla_general;
	private Integer valor_general;
	private String campo_a;
	private String campo_b;
	private String campo_c;
	private String campo_d;
	private String campo_e;
	private Integer id_estado;
	private String descrip_estado;
	private Integer orden;
	private String fecha_registro;

	public Integer getId_tabla_general() {
		return id_tabla_general;
	}

	public void setId_tabla_general(Integer id_tabla_general) {
		this.id_tabla_general = id_tabla_general;
	}

	public Integer getId_tabla_general_detalle() {
		return id_tabla_general_detalle;
	}

	public void setId_tabla_general_detalle(Integer id_tabla_general_detalle) {
		this.id_tabla_general_detalle = id_tabla_general_detalle;
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

	public String getCampo_b() {
		return campo_b;
	}

	public void setCampo_b(String campo_b) {
		this.campo_b = campo_b;
	}

	public String getCampo_c() {
		return campo_c;
	}

	public void setCampo_c(String campo_c) {
		this.campo_c = campo_c;
	}

	public String getCampo_d() {
		return campo_d;
	}

	public void setCampo_d(String campo_d) {
		this.campo_d = campo_d;
	}

	public String getCampo_e() {
		return campo_e;
	}

	public void setCampo_e(String campo_e) {
		this.campo_e = campo_e;
	}

	public Integer getId_estado() {
		return id_estado;
	}

	public void setId_estado(Integer id_estado) {
		this.id_estado = id_estado;
	}

	public String getDescrip_estado() {
		return descrip_estado;
	}

	public void setDescrip_estado(String descrip_estado) {
		this.descrip_estado = descrip_estado;
	}

	public Integer getOrden() {
		return orden;
	}

	public void setOrden(Integer orden) {
		this.orden = orden;
	}

	public String getFecha_registro() {
		return fecha_registro;
	}

	public void setFecha_registro(String fecha_registro) {
		this.fecha_registro = fecha_registro;
	}

}
