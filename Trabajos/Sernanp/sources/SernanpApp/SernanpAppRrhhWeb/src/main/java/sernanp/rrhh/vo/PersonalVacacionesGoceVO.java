package sernanp.rrhh.vo;

import java.sql.Date;
import java.sql.Timestamp;

public class PersonalVacacionesGoceVO {

	
	private int srl_id_pers_goce_vac;
	private int id_pers_vac;
	private int int_dias_goce_vac;
	private Date dte_fec_inicio_goc_vac;
	private Date dte_fec_fin_goc_vac;
	private int int_estado_goce_vac;
	private Timestamp tsp_fec_post_goce_vac;
	private String var_justificacion_post;
	
	private PersonalVacacionesVO personalVacaciones;
	
	public PersonalVacacionesGoceVO() {
		personalVacaciones = new PersonalVacacionesVO();
	}

		
	
	
	public int getSrl_id_pers_goce_vac() {
		return srl_id_pers_goce_vac;
	}

	public void setSrl_id_pers_goce_vac(int srl_id_pers_goce_vac) {
		this.srl_id_pers_goce_vac = srl_id_pers_goce_vac;
	}


	public int getId_pers_vac() {
		return id_pers_vac;
	}


	public void setId_pers_vac(int id_pers_vac) {
		this.id_pers_vac = id_pers_vac;
	}

	public int getInt_dias_goce_vac() {
		return int_dias_goce_vac;
	}

	public void setInt_dias_goce_vac(int int_dias_goce_vac) {
		this.int_dias_goce_vac = int_dias_goce_vac;
	}

	public Date getDte_fec_inicio_goc_vac() {
		return dte_fec_inicio_goc_vac;
	}

	public void setDte_fec_inicio_goc_vac(Date dte_fec_inicio_goc_vac) {
		this.dte_fec_inicio_goc_vac = dte_fec_inicio_goc_vac;
	}

	public Date getDte_fec_fin_goc_vac() {
		return dte_fec_fin_goc_vac;
	}

	public void setDte_fec_fin_goc_vac(Date dte_fec_fin_goc_vac) {
		this.dte_fec_fin_goc_vac = dte_fec_fin_goc_vac;
	}

	public int getInt_estado_goce_vac() {
		return int_estado_goce_vac;
	}

	public void setInt_estado_goce_vac(int int_estado_goce_vac) {
		this.int_estado_goce_vac = int_estado_goce_vac;
	}

	public Timestamp getTsp_fec_post_goce_vac() {
		return tsp_fec_post_goce_vac;
	}

	public void setTsp_fec_post_goce_vac(Timestamp tsp_fec_post_goce_vac) {
		this.tsp_fec_post_goce_vac = tsp_fec_post_goce_vac;
	}

	public String getVar_justificacion_post() {
		return var_justificacion_post;
	}

	public void setVar_justificacion_post(String var_justificacion_post) {
		this.var_justificacion_post = var_justificacion_post;
	}



	public PersonalVacacionesVO getPersonalVacaciones() {
		return personalVacaciones;
	}

	public void setPersonalVacaciones(PersonalVacacionesVO personalVacaciones) {
		this.personalVacaciones = personalVacaciones;
	}


	
	
	
//	srl_id_pers_goce_vac
//	srl_id_pers_vac integer NOT NULL,
//	int_dias_goce_vac integer NOT NULL,
//	dte_fec_inicio_goc_vac date NOT NULL,
//	dte_fec_fin_goc_vac date NOT NULL,
//	int_estado_goce_vac integer DEFAULT 0, -- 0: Utilizadas...
//	tsp_fec_post_goce_vac timestamp without time zone, -- Fecha cuando se registro la postergacion.
//	var_justificacion_post
	
	
}
