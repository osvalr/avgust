package sernanp.rrhh.vo;

import java.sql.Date;
import java.sql.Timestamp;


public class PersonaldiasnolaborablesVO {
	
	private int srl_id_no_laborable;
	private Date dte_fec_no_laborable;
	private int int_estado;
	private Timestamp tsp_fec_sys_reg;
	private int int_id_usu_crea;
	private Timestamp tsp_fec_sys_anul;
	private int int_id_usu_anul;
	private int periodoanio;
		
		
	public int getSrl_id_no_laborable() {
		return srl_id_no_laborable;
	}
	public void setSrl_id_no_laborable(int srl_id_no_laborable) {
		this.srl_id_no_laborable = srl_id_no_laborable;
	}
	public Date getDte_fec_no_laborable() {
		return dte_fec_no_laborable;
	}
	public void setDte_fec_no_laborable(Date dte_fec_no_laborable) {
		this.dte_fec_no_laborable = dte_fec_no_laborable;
	}
	public int getInt_estado() {
		return int_estado;
	}
	public void setInt_estado(int int_estado) {
		this.int_estado = int_estado;
	}
	public Timestamp getTsp_fec_sys_reg() {
		return tsp_fec_sys_reg;
	}
	public void setTsp_fec_sys_reg(Timestamp tsp_fec_sys_reg) {
		this.tsp_fec_sys_reg = tsp_fec_sys_reg;
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
	public int getPeriodoanio() {
		return periodoanio;
	}
	public void setPeriodoanio(int periodoanio) {
		this.periodoanio = periodoanio;
	}
	
	

}
