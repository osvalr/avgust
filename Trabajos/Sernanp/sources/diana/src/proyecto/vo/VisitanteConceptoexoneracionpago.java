package proyecto.vo;

import java.io.Serializable;


public class VisitanteConceptoexoneracionpago  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Visitante visitante;
	private Conceptoexoneracionpago conceptoexoneracionpago;
	
	public VisitanteConceptoexoneracionpago() {
		visitante=new Visitante();
		conceptoexoneracionpago=new Conceptoexoneracionpago();
	}

	public Visitante getVisitante() {
		return visitante;
	}

	public void setVisitante(Visitante visitante) {
		this.visitante = visitante;
	}

	public Conceptoexoneracionpago getConceptoexoneracionpago() {
		return conceptoexoneracionpago;
	}

	public void setConceptoexoneracionpago(
			Conceptoexoneracionpago conceptoexoneracionpago) {
		this.conceptoexoneracionpago = conceptoexoneracionpago;
	}

	

	
	
	
	
	
	
	
	
}
