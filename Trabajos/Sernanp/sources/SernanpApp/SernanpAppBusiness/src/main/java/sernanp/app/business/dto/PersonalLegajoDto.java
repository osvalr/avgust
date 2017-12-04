package sernanp.app.business.dto;

import java.io.File;
import java.math.BigDecimal;

public class PersonalLegajoDto {

	private Integer idpersonanatural; 
	private Integer srl_id_persona_natural_legajo; 
	private Integer int_id_tipo_documento;
	private String var_nombre_documento; 
	private String var_asunto_documento; 
	private String var_descripcion_documento; 
	private String tsp_fecha_registro;
    private String var_nombre_archivo;
    private String var_tipo_archivo;
    private String var_archivo_ruta_almacen;
    private BigDecimal num_size_archivo;
    private File legajo_file;
    private Integer srl_id_contrato;
    
	
	public File getLegajo_file() {
		return legajo_file;
	}
	public void setLegajo_file(File legajo_file) {
		this.legajo_file = legajo_file;
	}
	public Integer getIdpersonanatural() {
		return idpersonanatural;
	}
	public void setIdpersonanatural(Integer idpersonanatural) {
		this.idpersonanatural = idpersonanatural;
	}
	public Integer getSrl_id_persona_natural_legajo() {
		return srl_id_persona_natural_legajo;
	}
	public void setSrl_id_persona_natural_legajo(
			Integer srl_id_persona_natural_legajo) {
		this.srl_id_persona_natural_legajo = srl_id_persona_natural_legajo;
	}
	public String getVar_nombre_documento() {
		return var_nombre_documento;
	}
	public void setVar_nombre_documento(String var_nombre_documento) {
		this.var_nombre_documento = var_nombre_documento;
	}
	public String getVar_asunto_documento() {
		return var_asunto_documento;
	}
	public void setVar_asunto_documento(String var_asunto_documento) {
		this.var_asunto_documento = var_asunto_documento;
	}
	public String getVar_descripcion_documento() {
		return var_descripcion_documento;
	}
	public void setVar_descripcion_documento(String var_descripcion_documento) {
		this.var_descripcion_documento = var_descripcion_documento;
	}
	public String getTsp_fecha_registro() {
		return tsp_fecha_registro;
	}
	public void setTsp_fecha_registro(String tsp_fecha_registro) {
		this.tsp_fecha_registro = tsp_fecha_registro;
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
	public BigDecimal getNum_size_archivo() {
		return num_size_archivo;
	}
	public void setNum_size_archivo(BigDecimal num_size_archivo) {
		this.num_size_archivo = num_size_archivo;
	}
	public Integer getInt_id_tipo_documento() {
		return int_id_tipo_documento;
	}
	public void setInt_id_tipo_documento(Integer int_id_tipo_documento) {
		this.int_id_tipo_documento = int_id_tipo_documento;
	}
	public Integer getSrl_id_contrato() {
		return srl_id_contrato;
	}
	public void setSrl_id_contrato(Integer srl_id_contrato) {
		this.srl_id_contrato = srl_id_contrato;
	}

	
}
