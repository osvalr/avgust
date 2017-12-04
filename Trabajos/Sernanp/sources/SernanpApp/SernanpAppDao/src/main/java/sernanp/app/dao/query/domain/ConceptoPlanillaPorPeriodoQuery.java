package sernanp.app.dao.query.domain;

public class ConceptoPlanillaPorPeriodoQuery implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private Integer srl_id_concepto_planilla;
	private String var_descrip_concepto;
	
	public Integer getSrl_id_concepto_planilla() {
		return srl_id_concepto_planilla;
	}
	public void setSrl_id_concepto_planilla(Integer srl_id_concepto_planilla) {
		this.srl_id_concepto_planilla = srl_id_concepto_planilla;
	}
	public String getVar_descrip_concepto() {
		return var_descrip_concepto;
	}
	public void setVar_descrip_concepto(String var_descrip_concepto) {
		this.var_descrip_concepto = var_descrip_concepto;
	}
	
}
