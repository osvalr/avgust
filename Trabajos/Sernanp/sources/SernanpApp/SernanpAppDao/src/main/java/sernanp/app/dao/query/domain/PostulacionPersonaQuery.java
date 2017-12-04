package sernanp.app.dao.query.domain;

public class PostulacionPersonaQuery implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer srl_id_postulante_conv_area_org;
	private Integer int_id_postulante;
	private Integer srl_id_convocatoria;
	private String var_num_convocatoria;
	private Integer srl_id_conv_area_org;
	private String var_codigo_postulacion;
	private Integer int_id_estado;
	private String var_nombre_estado;
	
	private Integer srl_id_archivo;
	private String var_nombre_archivo;
	private String var_tipo_archivo;
	private String var_archivo_ruta_almacen;
	private Double num_size_archivo;
	
	private String file_name_session;
	
	private String tsp_fecha_registro;

	public Integer getSrl_id_postulante_conv_area_org() {
		return srl_id_postulante_conv_area_org;
	}

	public void setSrl_id_postulante_conv_area_org(Integer srl_id_postulante_conv_area_org) {
		this.srl_id_postulante_conv_area_org = srl_id_postulante_conv_area_org;
	}

	public Integer getInt_id_postulante() {
		return int_id_postulante;
	}

	public void setInt_id_postulante(Integer int_id_postulante) {
		this.int_id_postulante = int_id_postulante;
	}

	public String getVar_num_convocatoria() {
		return var_num_convocatoria;
	}

	public void setVar_num_convocatoria(String var_num_convocatoria) {
		this.var_num_convocatoria = var_num_convocatoria;
	}

	public String getVar_codigo_postulacion() {
		return var_codigo_postulacion;
	}

	public void setVar_codigo_postulacion(String var_codigo_postulacion) {
		this.var_codigo_postulacion = var_codigo_postulacion;
	}

	public Integer getInt_id_estado() {
		return int_id_estado;
	}

	public void setInt_id_estado(Integer int_id_estado) {
		this.int_id_estado = int_id_estado;
	}

	public String getVar_nombre_estado() {
		return var_nombre_estado;
	}

	public void setVar_nombre_estado(String var_nombre_estado) {
		this.var_nombre_estado = var_nombre_estado;
	}

	public String getTsp_fecha_registro() {
		return tsp_fecha_registro;
	}

	public void setTsp_fecha_registro(String tsp_fecha_registro) {
		this.tsp_fecha_registro = tsp_fecha_registro;
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

	public Integer getSrl_id_archivo() {
		return srl_id_archivo;
	}

	public void setSrl_id_archivo(Integer srl_id_archivo) {
		this.srl_id_archivo = srl_id_archivo;
	}

	public String getVar_nombre_archivo() {
		return var_nombre_archivo;
	}

	public void setVar_nombre_archivo(String var_nombre_archivo) {
		this.var_nombre_archivo = var_nombre_archivo;
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

	public String getFile_name_session() {
		return file_name_session;
	}

	public void setFile_name_session(String file_name_session) {
		this.file_name_session = file_name_session;
	}

}
