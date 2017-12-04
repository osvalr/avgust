package sernanp.rrhh.vo;

import java.sql.Date;
import java.sql.Timestamp;

import sernanp.rrhh.constants.RowMappersConstants.Personal;

public class PersonalLicenciasVO {
	
	private int srl_id_pers_lic;
	private Date dte_fec_inicio_lic;
	private Date dte_fec_fin_lic;
	private int int_dias_lic;
	private int int_est_lic;
	private String var_num_resol_autoriza_lic;
	private String var_descripcion_lic;
	private Timestamp tsp_fec_sys_crea;
	private Timestamp tsp_fec_sys_mod;
	private int idPersonallicencia;
	private PersonalActividadVO tipolicencia;
	
	
	public PersonalLicenciasVO() {
		tipolicencia = new PersonalActividadVO();

	}
	
	
	
	public int getSrl_id_pers_lic() {
		return srl_id_pers_lic;
	}
	public void setSrl_id_pers_lic(int srl_id_pers_lic) {
		this.srl_id_pers_lic = srl_id_pers_lic;
	}
	public Date getDte_fec_inicio_lic() {
		return dte_fec_inicio_lic;
	}
	public void setDte_fec_inicio_lic(Date dte_fec_inicio_lic) {
		this.dte_fec_inicio_lic = dte_fec_inicio_lic;
	}
	public Date getDte_fec_fin_lic() {
		return dte_fec_fin_lic;
	}
	public void setDte_fec_fin_lic(Date dte_fec_fin_lic) {
		this.dte_fec_fin_lic = dte_fec_fin_lic;
	}
	public int getInt_dias_lic() {
		return int_dias_lic;
	}
	public void setInt_dias_lic(int int_dias_lic) {
		this.int_dias_lic = int_dias_lic;
	}
	public int getInt_est_lic() {
		return int_est_lic;
	}
	public void setInt_est_lic(int int_est_lic) {
		this.int_est_lic = int_est_lic;
	}
	public String getVar_num_resol_autoriza_lic() {
		return var_num_resol_autoriza_lic;
	}
	public void setVar_num_resol_autoriza_lic(String var_num_resol_autoriza_lic) {
		this.var_num_resol_autoriza_lic = var_num_resol_autoriza_lic;
	}
	public String getVar_descripcion_lic() {
		return var_descripcion_lic;
	}
	public void setVar_descripcion_lic(String var_descripcion_lic) {
		this.var_descripcion_lic = var_descripcion_lic;
	}
	public Timestamp getTsp_fec_sys_crea() {
		return tsp_fec_sys_crea;
	}
	public void setTsp_fec_sys_crea(Timestamp tsp_fec_sys_crea) {
		this.tsp_fec_sys_crea = tsp_fec_sys_crea;
	}
	public Timestamp getTsp_fec_sys_mod() {
		return tsp_fec_sys_mod;
	}
	public void setTsp_fec_sys_mod(Timestamp tsp_fec_sys_mod) {
		this.tsp_fec_sys_mod = tsp_fec_sys_mod;
	}


	public int getIdPersonallicencia() {
		return idPersonallicencia;
	}



	public void setIdPersonallicencia(int idPersonallicencia) {
		this.idPersonallicencia = idPersonallicencia;
	}



	public PersonalActividadVO getTipolicencia() {
		return tipolicencia;
	}



	public void setTipolicencia(PersonalActividadVO tipolicencia) {
		this.tipolicencia = tipolicencia;
	}






	
	
	
	
	
	
	/*srl_id_pers_lic serial NOT NULL,
	  dte_fec_inicio_lic date, -- Fecha que iniciará su licencia del Personal
	  dte_fec_fin_lic date, -- Fecha fin de el goce de licencia del personal
	  int_dias_lic integer DEFAULT 0, -- N° de días de licencia
	  int_est_lic integer NOT NULL DEFAULT 1, -- 0: Utilizado completamente...
	  var_num_resol_autoriza_lic character varying(20), -- Numero de la resolución que autoriza la licencia del Personal
	  var_descripcion_lic character varying(200),
	  tsp_fec_sys_crea timestamp with time zone,
	  tsp_fec_sys_mod timestamp with time zone,
	  idpersonal integer NOT NULL,
	  idtablatipo integer NOT NULL,*/
	

}
