package sernanp.rrhh.vo;

import java.sql.Date;

public class PersonalContratoVO extends PersonalVO {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String var_num_contrato;
	private double num_sueldo;
	private PersonalVO personalVO;
	private Date dte_fec_inicio;
	private Date dte_fec_termino;
	private Date dte_fec_suscrip;
	private int int_id_reg_lab;
	private int idarea;
	private Date dte_fec_cese;
	private int srl_id_lug_pres;
	private int int_id_tab_tip;
	private int int_est_contrato;
	private int srl_id_cargo;
	
	
	
	
	public PersonalContratoVO(){
		personalVO = new PersonalVO();
	}



	public String getVar_num_contrato() {
		return var_num_contrato;
	}



	public void setVar_num_contrato(String var_num_contrato) {
		this.var_num_contrato = var_num_contrato;
	}



	public double getNum_sueldo() {
		return num_sueldo;
	}



	public void setNum_sueldo(double num_sueldo) {
		this.num_sueldo = num_sueldo;
	}



	public PersonalVO getPersonalVO() {
		return personalVO;
	}



	public void setPersonalVO(PersonalVO personalVO) {
		this.personalVO = personalVO;
	}



	public Date getDte_fec_inicio() {
		return dte_fec_inicio;
	}



	public void setDte_fec_inicio(Date dte_fec_inicio) {
		this.dte_fec_inicio = dte_fec_inicio;
	}



	public Date getDte_fec_termino() {
		return dte_fec_termino;
	}



	public void setDte_fec_termino(Date dte_fec_termino) {
		this.dte_fec_termino = dte_fec_termino;
	}



	public Date getDte_fec_suscrip() {
		return dte_fec_suscrip;
	}



	public void setDte_fec_suscrip(Date dte_fec_suscrip) {
		this.dte_fec_suscrip = dte_fec_suscrip;
	}



	public int getInt_id_reg_lab() {
		return int_id_reg_lab;
	}



	public void setInt_id_reg_lab(int int_id_reg_lab) {
		this.int_id_reg_lab = int_id_reg_lab;
	}



	public int getIdarea() {
		return idarea;
	}



	public void setIdarea(int idarea) {
		this.idarea = idarea;
	}



	public Date getDte_fec_cese() {
		return dte_fec_cese;
	}



	public void setDte_fec_cese(Date dte_fec_cese) {
		this.dte_fec_cese = dte_fec_cese;
	}



	public int getSrl_id_lug_pres() {
		return srl_id_lug_pres;
	}



	public void setSrl_id_lug_pres(int srl_id_lug_pres) {
		this.srl_id_lug_pres = srl_id_lug_pres;
	}



	public int getInt_id_tab_tip() {
		return int_id_tab_tip;
	}



	public void setInt_id_tab_tip(int int_id_tab_tip) {
		this.int_id_tab_tip = int_id_tab_tip;
	}



	public int getInt_est_contrato() {
		return int_est_contrato;
	}



	public void setInt_est_contrato(int int_est_contrato) {
		this.int_est_contrato = int_est_contrato;
	}



	public int getSrl_id_cargo() {
		return srl_id_cargo;
	}



	public void setSrl_id_cargo(int srl_id_cargo) {
		this.srl_id_cargo = srl_id_cargo;
	}
	
	
	

}
