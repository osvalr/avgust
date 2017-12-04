package sernanp.rrhh.vo;

import java.io.Serializable;
import java.sql.Date;

public class PersonalContratoAdendaVO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	 private int srl_id_adenda;
	 private int srl_id_contrato;
	 private Date dte_fec_inicio;
	 private Date dte_fec_termino;
	 private Date dte_fec_suscrip;
	 private String var_num_adenda;
	 private PersonalContratoVO personalContrato;
	  
	 
	 
		public PersonalContratoAdendaVO() {
			personalContrato = new PersonalContratoVO();
		}

		
		
		public int getSrl_id_adenda() {
			return srl_id_adenda;
		}



		public void setSrl_id_adenda(int srl_id_adenda) {
			this.srl_id_adenda = srl_id_adenda;
		}



		public int getSrl_id_contrato() {
			return srl_id_contrato;
		}



		public void setSrl_id_contrato(int srl_id_contrato) {
			this.srl_id_contrato = srl_id_contrato;
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



		public String getVar_num_adenda() {
			return var_num_adenda;
		}



		public void setVar_num_adenda(String var_num_adenda) {
			this.var_num_adenda = var_num_adenda;
		}



		public PersonalContratoVO getPersonalContrato() {
			return personalContrato;
		}



		public void setPersonalContrato(PersonalContratoVO personalContrato) {
			this.personalContrato = personalContrato;
		}
		
		
		
		
		
	  
	  /*srl_id_adenda serial NOT NULL,
	  srl_id_contrato integer NOT NULL,
	  dte_fec_inicio date NOT NULL,
	  dte_fec_termino date,
	  dte_fec_suscrip date NOT NULL,
	  var_num_adenda character varying(50) NOT NULL,*/
	



}
