package sernanp.app.dao.query.domain;

public class ArchivoPostulanteQuery implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer srl_id_archivo;
	private Integer int_id_postulante;
	private String var_nombre_archivo;
	private String var_descripcion_archivo;
	private String var_tipo_archivo;
	private String var_archivo_ruta_almacen;
	private Double num_size_archivo;
	private String tsp_fecha_registro;
	private Integer int_id_tipo_documento;
	private String var_descrip_tipo_documento;
	private String file_name_session;

	public Integer getSrl_id_archivo() {
		return srl_id_archivo;
	}

	public void setSrl_id_archivo(Integer srl_id_archivo) {
		this.srl_id_archivo = srl_id_archivo;
	}

	public Integer getInt_id_postulante() {
		return int_id_postulante;
	}

	public void setInt_id_postulante(Integer int_id_postulante) {
		this.int_id_postulante = int_id_postulante;
	}

	public String getVar_nombre_archivo() {
		return var_nombre_archivo;
	}

	public void setVar_nombre_archivo(String var_nombre_archivo) {
		this.var_nombre_archivo = var_nombre_archivo;
	}

	public String getVar_descripcion_archivo() {
		return var_descripcion_archivo;
	}

	public void setVar_descripcion_archivo(String var_descripcion_archivo) {
		this.var_descripcion_archivo = var_descripcion_archivo;
	}

	public String getVar_tipo_archivo() {
		return var_tipo_archivo;
	}

	public void setVar_tipo_archivo(String var_tipo_archivo) {
		this.var_tipo_archivo = var_tipo_archivo;
	}

	public String getVar_archivo_ruta_almacen() {
		return var_archivo_ruta_almacen;
	}

	public void setVar_archivo_ruta_almacen(String var_archivo_ruta_almacen) {
		this.var_archivo_ruta_almacen = var_archivo_ruta_almacen;
	}

	public Double getNum_size_archivo() {
		return num_size_archivo;
	}

	public void setNum_size_archivo(Double num_size_archivo) {
		this.num_size_archivo = num_size_archivo;
	}

	public String getTsp_fecha_registro() {
		return tsp_fecha_registro;
	}

	public void setTsp_fecha_registro(String tsp_fecha_registro) {
		this.tsp_fecha_registro = tsp_fecha_registro;
	}

	public String getFile_name_session() {
		return file_name_session;
	}

	public void setFile_name_session(String file_name_session) {
		this.file_name_session = file_name_session;
	}

	public Integer getInt_id_tipo_documento() {
		return int_id_tipo_documento;
	}

	public void setInt_id_tipo_documento(Integer int_id_tipo_documento) {
		this.int_id_tipo_documento = int_id_tipo_documento;
	}

	public String getVar_descrip_tipo_documento() {
		return var_descrip_tipo_documento;
	}

	public void setVar_descrip_tipo_documento(String var_descrip_tipo_documento) {
		this.var_descrip_tipo_documento = var_descrip_tipo_documento;
	}

}
