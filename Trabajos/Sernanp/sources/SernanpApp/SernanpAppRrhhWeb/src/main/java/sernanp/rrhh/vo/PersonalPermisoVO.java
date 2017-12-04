package sernanp.rrhh.vo;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

public class PersonalPermisoVO {
	
	private int srl_id_pers_perm;
	private Date dte_fec_pers_perm_sal;
	private Time hor_hor_salida;
	private Date dte_fec_pers_perm_ret;
	private Time hor_hor_retorno;
	private String var_desc_pers_perm;
	private int int_estado; 
	private Timestamp tsp_fec_sys_crea;
	private int int_id_usu_crea;
	private Timestamp tsp_fec_sys_anul;
	private int int_id_usu_anul;
	private Tipo tablatipo;
	private PersonalVO personal;
	private PersonalActividadVO personalActividad;
	
	
	public PersonalPermisoVO(){
		tablatipo			= new Tipo();
		personal			= new PersonalVO();
		personalActividad	= new PersonalActividadVO();
	}
	
	
	
	public int getSrl_id_pers_perm() {
		return srl_id_pers_perm;
	}
	public void setSrl_id_pers_perm(int srl_id_pers_perm) {
		this.srl_id_pers_perm = srl_id_pers_perm;
	}
	public Date getDte_fec_pers_perm_sal() {
		return dte_fec_pers_perm_sal;
	}
	public void setDte_fec_pers_perm_sal(Date dte_fec_pers_perm_sal) {
		this.dte_fec_pers_perm_sal = dte_fec_pers_perm_sal;
	}
	public Time getHor_hor_salida() {
		return hor_hor_salida;
	}
	public void setHor_hor_salida(Time hor_hor_salida) {
		this.hor_hor_salida = hor_hor_salida;
	}
	public Date getDte_fec_pers_perm_ret() {
		return dte_fec_pers_perm_ret;
	}
	public void setDte_fec_pers_perm_ret(Date dte_fec_pers_perm_ret) {
		this.dte_fec_pers_perm_ret = dte_fec_pers_perm_ret;
	}
	public Time getHor_hor_retorno() {
		return hor_hor_retorno;
	}
	public void setHor_hor_retorno(Time hor_hor_retorno) {
		this.hor_hor_retorno = hor_hor_retorno;
	}
	public String getVar_desc_pers_perm() {
		return var_desc_pers_perm;
	}
	public void setVar_desc_pers_perm(String var_desc_pers_perm) {
		this.var_desc_pers_perm = var_desc_pers_perm;
	}
	public Tipo getTablatipo() {
		return tablatipo;
	}
	public void setTablatipo(Tipo tablatipo) {
		this.tablatipo = tablatipo;
	}
	public int getInt_estado() {
		return int_estado;
	}
	public void setInt_estado(int int_estado) {
		this.int_estado = int_estado;
	}
	public Timestamp getTsp_fec_sys_crea() {
		return tsp_fec_sys_crea;
	}
	public void setTsp_fec_sys_crea(Timestamp tsp_fec_sys_crea) {
		this.tsp_fec_sys_crea = tsp_fec_sys_crea;
	}
	public int getInt_id_usu_crea() {
		return int_id_usu_crea;
	}
	public void setInt_id_usu_crea(int int_id_usu_crea) {
		this.int_id_usu_crea = int_id_usu_crea;
	}
	public Timestamp getTsp_fec_sys_anul() {
		return tsp_fec_sys_anul;
	}
	public void setTsp_fec_sys_anul(Timestamp tsp_fec_sys_anul) {
		this.tsp_fec_sys_anul = tsp_fec_sys_anul;
	}
	public int getInt_id_usu_anul() {
		return int_id_usu_anul;
	}
	public void setInt_id_usu_anul(int int_id_usu_anul) {
		this.int_id_usu_anul = int_id_usu_anul;
	}
	
	
	public PersonalVO getPersonal() {
		return personal;
	}
	public void setPersonal(PersonalVO personal) {
		this.personal = personal;
	}


	public PersonalActividadVO getPersonalActividad() {
		return personalActividad;
	}

	public void setPersonalActividad(PersonalActividadVO personalActividad) {
		this.personalActividad = personalActividad;
	}	
	

}
