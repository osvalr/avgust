package sernanp.app.dao.query.domain;

import java.util.Date;

public class AdendaEntrePeriodoPorContratoQueryCriteria {

	private Integer srl_id_contrato_padre;
	private Integer srl_id_contrato;
	private Date dte_fec_inicio;
	private Date dte_fec_termino;

	public Integer getSrl_id_contrato_padre() {
		return srl_id_contrato_padre;
	}

	public void setSrl_id_contrato_padre(Integer srl_id_contrato_padre) {
		this.srl_id_contrato_padre = srl_id_contrato_padre;
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

	public Integer getSrl_id_contrato() {
		return srl_id_contrato;
	}

	public void setSrl_id_contrato(Integer srl_id_contrato) {
		this.srl_id_contrato = srl_id_contrato;
	}

}
