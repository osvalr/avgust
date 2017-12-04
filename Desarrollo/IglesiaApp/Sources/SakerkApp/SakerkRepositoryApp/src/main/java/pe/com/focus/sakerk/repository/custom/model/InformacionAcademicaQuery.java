package pe.com.focus.sakerk.repository.custom.model;

public class InformacionAcademicaQuery implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id_informacion_academica;
	private Integer id_persona_natural;
	private Integer id_categoria_estudio;
	private String descrip_categoria_estudio;
	private Integer id_estudio;
	private String nombre_estudio;
	private Integer id_centro_estudio;
	private String razon_social;
	private Integer id_tipo_grado_instruccion;
	private String descrip_tipo_grado_instruccion;
	private String fecha_ingreso;
	private String fecha_egreso;
	private Integer flag_encurso;
	private String descrip_flag_encurso;
	private Integer id_estado;
	private String descrip_estado;
	private String fecha_registro;

	public Integer getId_informacion_academica() {
		return id_informacion_academica;
	}

	public void setId_informacion_academica(Integer id_informacion_academica) {
		this.id_informacion_academica = id_informacion_academica;
	}

	public Integer getId_persona_natural() {
		return id_persona_natural;
	}

	public void setId_persona_natural(Integer id_persona_natural) {
		this.id_persona_natural = id_persona_natural;
	}

	public Integer getId_categoria_estudio() {
		return id_categoria_estudio;
	}

	public void setId_categoria_estudio(Integer id_categoria_estudio) {
		this.id_categoria_estudio = id_categoria_estudio;
	}

	public String getDescrip_categoria_estudio() {
		return descrip_categoria_estudio;
	}

	public void setDescrip_categoria_estudio(String descrip_categoria_estudio) {
		this.descrip_categoria_estudio = descrip_categoria_estudio;
	}

	public Integer getId_estudio() {
		return id_estudio;
	}

	public void setId_estudio(Integer id_estudio) {
		this.id_estudio = id_estudio;
	}

	public String getNombre_estudio() {
		return nombre_estudio;
	}

	public void setNombre_estudio(String nombre_estudio) {
		this.nombre_estudio = nombre_estudio;
	}

	public String getRazon_social() {
		return razon_social;
	}

	public void setRazon_social(String razon_social) {
		this.razon_social = razon_social;
	}

	public Integer getId_tipo_grado_instruccion() {
		return id_tipo_grado_instruccion;
	}

	public void setId_tipo_grado_instruccion(Integer id_tipo_grado_instruccion) {
		this.id_tipo_grado_instruccion = id_tipo_grado_instruccion;
	}

	public String getDescrip_tipo_grado_instruccion() {
		return descrip_tipo_grado_instruccion;
	}

	public void setDescrip_tipo_grado_instruccion(
			String descrip_tipo_grado_instruccion) {
		this.descrip_tipo_grado_instruccion = descrip_tipo_grado_instruccion;
	}

	public String getFecha_ingreso() {
		return fecha_ingreso;
	}

	public void setFecha_ingreso(String fecha_ingreso) {
		this.fecha_ingreso = fecha_ingreso;
	}

	public String getFecha_egreso() {
		return fecha_egreso;
	}

	public void setFecha_egreso(String fecha_egreso) {
		this.fecha_egreso = fecha_egreso;
	}

	public Integer getFlag_encurso() {
		return flag_encurso;
	}

	public void setFlag_encurso(Integer flag_encurso) {
		this.flag_encurso = flag_encurso;
	}

	public String getDescrip_flag_encurso() {
		return descrip_flag_encurso;
	}

	public void setDescrip_flag_encurso(String descrip_flag_encurso) {
		this.descrip_flag_encurso = descrip_flag_encurso;
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

	public String getFecha_registro() {
		return fecha_registro;
	}

	public void setFecha_registro(String fecha_registro) {
		this.fecha_registro = fecha_registro;
	}

	public Integer getId_centro_estudio() {
		return id_centro_estudio;
	}

	public void setId_centro_estudio(Integer id_centro_estudio) {
		this.id_centro_estudio = id_centro_estudio;
	}

}
