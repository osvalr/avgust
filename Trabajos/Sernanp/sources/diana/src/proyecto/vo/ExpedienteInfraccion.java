package proyecto.vo;

public class ExpedienteInfraccion {
	
	private Expediente expediente;
	private int reincidencia;
	private Infraccion infraccion;	
	
	public ExpedienteInfraccion() {
		expediente = new Expediente();
		infraccion = new Infraccion();
	}
	
	public Expediente getExpediente() {
		return expediente;
	}
	
	public void setExpediente(Expediente expediente) {
		this.expediente = expediente;
	}
	
	public Infraccion getInfraccion() {
		return infraccion;
	}
	
	public void setInfraccion(Infraccion infraccion) {
		this.infraccion = infraccion;
	}
	
	public int getReincidencia() {
		return reincidencia;
	}
	
	public void setReincidencia(int reincidencia) {
		this.reincidencia = reincidencia;
	}

}

//import java.util.ArrayList;
//import java.util.List;

//private List<ExpedienteInfraccion> listaEpediente;
//super();
//listaEpediente= new ArrayList<ExpedienteInfraccion>();
//
//public List<ExpedienteInfraccion> getListaEpediente() {
//	return listaEpediente;
//}
//
//
//
//public void setListaEpediente(List<ExpedienteInfraccion> listaEpediente) {
//	this.listaEpediente = listaEpediente;
//}

