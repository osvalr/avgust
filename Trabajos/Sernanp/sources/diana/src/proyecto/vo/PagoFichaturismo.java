package proyecto.vo;

import java.io.Serializable;


public class PagoFichaturismo  implements Serializable{

	private static final long serialVersionUID = 1L;
	private int idpagofichaturismo;
	private int idfichaturismo;
	private double monto;
	private String numvoucher;
	private Tipo modalidadpago;
	private PagoBanco pagobanco;
	
	public PagoFichaturismo() {
		modalidadpago=new Tipo();
		pagobanco=new PagoBanco();
	}


	public int getIdpagofichaturismo() {
		return idpagofichaturismo;
	}


	public void setIdpagofichaturismo(int idpagofichaturismo) {
		this.idpagofichaturismo = idpagofichaturismo;
	}


	public int getIdfichaturismo() {
		return idfichaturismo;
	}


	public void setIdfichaturismo(int idfichaturismo) {
		this.idfichaturismo = idfichaturismo;
	}


	public double getMonto() {
		return monto;
	}


	public void setMonto(double monto) {
		this.monto = monto;
	}


	public String getNumvoucher() {
		return numvoucher;
	}


	public void setNumvoucher(String numvoucher) {
		this.numvoucher = numvoucher;
	}


	public Tipo getModalidadpago() {
		return modalidadpago;
	}


	public void setModalidadpago(Tipo modalidadpago) {
		this.modalidadpago = modalidadpago;
	}


	


	public PagoBanco getPagobanco() {
		return pagobanco;
	}


	public void setPagobanco(PagoBanco pagobanco) {
		this.pagobanco = pagobanco;
	}


	
	
	
	
	
	
}
