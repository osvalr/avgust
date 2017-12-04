package sernanp.app.dao.query.domain;

import java.util.Date;

public class AdendaQueryCriteria {

	private Integer srl_id_contrato_padre;
	private Date dte_fec_suscrip;

	public Integer getSrl_id_contrato_padre() {
		return srl_id_contrato_padre;
	}

	public void setSrl_id_contrato_padre(Integer srl_id_contrato_padre) {
		this.srl_id_contrato_padre = srl_id_contrato_padre;
	}

	public Date getDte_fec_suscrip() {
		return dte_fec_suscrip;
	}

	public void setDte_fec_suscrip(Date dte_fec_suscrip) {
		this.dte_fec_suscrip = dte_fec_suscrip;
	}

}
