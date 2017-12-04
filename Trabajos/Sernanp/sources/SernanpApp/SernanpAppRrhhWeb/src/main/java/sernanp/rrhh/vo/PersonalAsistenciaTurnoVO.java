package sernanp.rrhh.vo;

import java.io.Serializable;
import java.sql.Time;

public class PersonalAsistenciaTurnoVO implements Serializable{
	
//	private static final long serialVersionUID = 1L;
	
	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int srl_id_asis_turno;
	  private String var_des_asis_turno;
	  private Time hor_hor_ingreso;
	  private Time hor_hor_salida;
	  private Time hor_hor_ini_refrig;
	  private Time hor_hor_fin_refrig;
	  private int int_can_horas;
	  
//	  public PersonalAsistenciaTurnoVO(){
//		  
//	  }
//	  
	  
	public int getSrl_id_asis_turno() {
		return srl_id_asis_turno;
	}
	public void setSrl_id_asis_turno(int srl_id_asis_turno) {
		this.srl_id_asis_turno = srl_id_asis_turno;
	}
	public String getVar_des_asis_turno() {
		return var_des_asis_turno;
	}
	public void setVar_des_asis_turno(String var_des_asis_turno) {
		this.var_des_asis_turno = var_des_asis_turno;
	}
	public Time getHor_hor_ingreso() {
		return hor_hor_ingreso;
	}
	public void setHor_hor_ingreso(Time hor_hor_ingreso) {
		this.hor_hor_ingreso = hor_hor_ingreso;
	}
	public Time getHor_hor_salida() {
		return hor_hor_salida;
	}
	public void setHor_hor_salida(Time hor_hor_salida) {
		this.hor_hor_salida = hor_hor_salida;
	}
	public Time getHor_hor_ini_refrig() {
		return hor_hor_ini_refrig;
	}
	public void setHor_hor_ini_refrig(Time hor_hor_ini_refrig) {
		this.hor_hor_ini_refrig = hor_hor_ini_refrig;
	}
	public Time getHor_hor_fin_refrig() {
		return hor_hor_fin_refrig;
	}
	public void setHor_hor_fin_refrig(Time hor_hor_fin_refrig) {
		this.hor_hor_fin_refrig = hor_hor_fin_refrig;
	}
	public int getInt_can_horas() {
		return int_can_horas;
	}
	public void setInt_can_horas(int int_can_horas) {
		this.int_can_horas = int_can_horas;
	}
	  

}
