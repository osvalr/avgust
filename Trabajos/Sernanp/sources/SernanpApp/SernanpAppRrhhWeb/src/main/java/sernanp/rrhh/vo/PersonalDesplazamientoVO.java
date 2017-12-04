package sernanp.rrhh.vo;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

public class PersonalDesplazamientoVO {
	
	
	private int srl_id_desp;
	private Date dte_fec_sal_desp;
	private Time hor_hor_sal_desp;
	private Date dte_fec_ret_desp;
	private Time hor_hor_ret_desp;
	private String var_lug_desp;
	private Timestamp tsp_fec_sys_crea;
	private int int_usu_crea;
	private PersonalActividadVO personalActividad;
	private PersonalVO personal;
	private String tiempo_horas_diaReporte;
	private String inicioReporte;
	private String finReporte;
	
	public PersonalDesplazamientoVO(){
		personalActividad	= new PersonalActividadVO();
		personal 			= new PersonalVO();
		
	}
	
	
	
	public int getSrl_id_desp() {
		return srl_id_desp;
	}
	public void setSrl_id_desp(int srl_id_desp) {
		this.srl_id_desp = srl_id_desp;
	}
	public Date getDte_fec_sal_desp() {
		return dte_fec_sal_desp;
	}
	public void setDte_fec_sal_desp(Date dte_fec_sal_desp) {
		this.dte_fec_sal_desp = dte_fec_sal_desp;
	}
	public Time getHor_hor_sal_desp() {
		return hor_hor_sal_desp;
	}
	public void setHor_hor_sal_desp(Time hor_hor_sal_desp) {
		this.hor_hor_sal_desp = hor_hor_sal_desp;
	}
	public Date getDte_fec_ret_desp() {
		return dte_fec_ret_desp;
	}
	public void setDte_fec_ret_desp(Date dte_fec_ret_desp) {
		this.dte_fec_ret_desp = dte_fec_ret_desp;
	}
	public Time getHor_hor_ret_desp() {
		return hor_hor_ret_desp;
	}
	public void setHor_hor_ret_desp(Time hor_hor_ret_desp) {
		this.hor_hor_ret_desp = hor_hor_ret_desp;
	}
	public String getVar_lug_desp() {
		return var_lug_desp;
	}
	public void setVar_lug_desp(String var_lug_desp) {
		this.var_lug_desp = var_lug_desp;
	}
	public Timestamp getTsp_fec_sys_crea() {
		return tsp_fec_sys_crea;
	}
	public void setTsp_fec_sys_crea(Timestamp tsp_fec_sys_crea) {
		this.tsp_fec_sys_crea = tsp_fec_sys_crea;
	}
	public int getInt_usu_crea() {
		return int_usu_crea;
	}
	public void setInt_usu_crea(int int_usu_crea) {
		this.int_usu_crea = int_usu_crea;
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



	public String getTiempo_horas_diaReporte() {
		return tiempo_horas_diaReporte;
	}



	public void setTiempo_horas_diaReporte(String tiempo_horas_diaReporte) {
		this.tiempo_horas_diaReporte = tiempo_horas_diaReporte;
	}



	public String getInicioReporte() {
		return inicioReporte;
	}



	public void setInicioReporte(String inicioReporte) {
		this.inicioReporte = inicioReporte;
	}



	public String getFinReporte() {
		return finReporte;
	}



	public void setFinReporte(String finReporte) {
		this.finReporte = finReporte;
	}




	
	
	
	

}
