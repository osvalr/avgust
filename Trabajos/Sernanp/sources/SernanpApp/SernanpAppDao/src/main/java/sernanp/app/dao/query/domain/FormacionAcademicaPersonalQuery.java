package sernanp.app.dao.query.domain;

import java.io.Serializable;

public class FormacionAcademicaPersonalQuery implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4646687162190908391L;
	private Integer srl_id_personanatural_formacion;
	private Integer idpersonal;
	private Integer idpersona;
	private Integer idpersonanatural;
	private Integer srl_id_grupo_ocupacional;
	private String descrip_grupo_ocupacional;
	private Integer srl_id_nivel_estudio;
	private String descrip_nivel_estudio;
	private Integer srl_id_tipo_profesion;
	private String descrip_tipo_profesion;
	private Integer srl_id_profesion;
	private String descrip_profesion;
	private Integer int_tipo_formacion;
	private String destablatipo;
	private String var_descripcion_institucion;
	private Integer idpais;
	private String descrip_pais;
	private String dte_fecha_ingreso;
	private String dte_fecha_culminacion;
	private Integer int_sigue_estudios;
	
	private Integer flagEliminado;

	public Integer getIdpersonal() {
		return idpersonal;
	}

	public void setIdpersonal(Integer idpersonal) {
		this.idpersonal = idpersonal;
	}

	public Integer getIdpersona() {
		return idpersona;
	}

	public void setIdpersona(Integer idpersona) {
		this.idpersona = idpersona;
	}

	public Integer getIdpersonanatural() {
		return idpersonanatural;
	}

	public void setIdpersonanatural(Integer idpersonanatural) {
		this.idpersonanatural = idpersonanatural;
	}

	public Integer getSrl_id_grupo_ocupacional() {
		return srl_id_grupo_ocupacional;
	}

	public void setSrl_id_grupo_ocupacional(Integer srl_id_grupo_ocupacional) {
		this.srl_id_grupo_ocupacional = srl_id_grupo_ocupacional;
	}

	public String getDescrip_grupo_ocupacional() {
		return descrip_grupo_ocupacional;
	}

	public void setDescrip_grupo_ocupacional(String descrip_grupo_ocupacional) {
		this.descrip_grupo_ocupacional = descrip_grupo_ocupacional;
	}

	public Integer getSrl_id_nivel_estudio() {
		return srl_id_nivel_estudio;
	}

	public void setSrl_id_nivel_estudio(Integer srl_id_nivel_estudio) {
		this.srl_id_nivel_estudio = srl_id_nivel_estudio;
	}

	public String getDescrip_nivel_estudio() {
		return descrip_nivel_estudio;
	}

	public void setDescrip_nivel_estudio(String descrip_nivel_estudio) {
		this.descrip_nivel_estudio = descrip_nivel_estudio;
	}

	public Integer getSrl_id_tipo_profesion() {
		return srl_id_tipo_profesion;
	}

	public void setSrl_id_tipo_profesion(Integer srl_id_tipo_profesion) {
		this.srl_id_tipo_profesion = srl_id_tipo_profesion;
	}

	public String getDescrip_tipo_profesion() {
		return descrip_tipo_profesion;
	}

	public void setDescrip_tipo_profesion(String descrip_tipo_profesion) {
		this.descrip_tipo_profesion = descrip_tipo_profesion;
	}

	public Integer getSrl_id_profesion() {
		return srl_id_profesion;
	}

	public void setSrl_id_profesion(Integer srl_id_profesion) {
		this.srl_id_profesion = srl_id_profesion;
	}

	public String getDescrip_profesion() {
		return descrip_profesion;
	}

	public void setDescrip_profesion(String descrip_profesion) {
		this.descrip_profesion = descrip_profesion;
	}

	public Integer getInt_tipo_formacion() {
		return int_tipo_formacion;
	}

	public void setInt_tipo_formacion(Integer int_tipo_formacion) {
		this.int_tipo_formacion = int_tipo_formacion;
	}

	public String getDestablatipo() {
		return destablatipo;
	}

	public void setDestablatipo(String destablatipo) {
		this.destablatipo = destablatipo;
	}

	public String getVar_descripcion_institucion() {
		return var_descripcion_institucion;
	}

	public void setVar_descripcion_institucion(
			String var_descripcion_institucion) {
		this.var_descripcion_institucion = var_descripcion_institucion;
	}

	public Integer getIdpais() {
		return idpais;
	}

	public void setIdpais(Integer idpais) {
		this.idpais = idpais;
	}

	public String getDescrip_pais() {
		return descrip_pais;
	}

	public void setDescrip_pais(String descrip_pais) {
		this.descrip_pais = descrip_pais;
	}

	public Integer getSrl_id_personanatural_formacion() {
		return srl_id_personanatural_formacion;
	}

	public void setSrl_id_personanatural_formacion(
			Integer srl_id_personanatural_formacion) {
		this.srl_id_personanatural_formacion = srl_id_personanatural_formacion;
	}

	public Integer getFlagEliminado() {
		return flagEliminado;
	}

	public void setFlagEliminado(Integer flagEliminado) {
		this.flagEliminado = flagEliminado;
	}

	public String getDte_fecha_ingreso() {
		return dte_fecha_ingreso;
	}

	public void setDte_fecha_ingreso(String dte_fecha_ingreso) {
		this.dte_fecha_ingreso = dte_fecha_ingreso;
	}

	public String getDte_fecha_culminacion() {
		return dte_fecha_culminacion;
	}

	public void setDte_fecha_culminacion(String dte_fecha_culminacion) {
		this.dte_fecha_culminacion = dte_fecha_culminacion;
	}

	public Integer getInt_sigue_estudios() {
		return int_sigue_estudios;
	}

	public void setInt_sigue_estudios(Integer int_sigue_estudios) {
		this.int_sigue_estudios = int_sigue_estudios;
	}

}
