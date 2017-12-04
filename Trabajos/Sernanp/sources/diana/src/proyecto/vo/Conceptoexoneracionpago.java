package proyecto.vo;

import java.io.Serializable;


public class Conceptoexoneracionpago  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idconceptoexoneracionpago;
	private String desconceptoexoneracionpago;
	private int flagconceptomenor;
	public Conceptoexoneracionpago() {
		
	}

	public int getIdconceptoexoneracionpago() {
		return idconceptoexoneracionpago;
	}

	public void setIdconceptoexoneracionpago(int idconceptoexoneracionpago) {
		this.idconceptoexoneracionpago = idconceptoexoneracionpago;
	}

	public String getDesconceptoexoneracionpago() {
		return desconceptoexoneracionpago;
	}

	public void setDesconceptoexoneracionpago(String desconceptoexoneracionpago) {
		this.desconceptoexoneracionpago = desconceptoexoneracionpago;
	}

	public int getFlagconceptomenor() {
		return flagconceptomenor;
	}

	public void setFlagconceptomenor(int flagconceptomenor) {
		this.flagconceptomenor = flagconceptomenor;
	}

	
	
	
	
	
	
	
}
