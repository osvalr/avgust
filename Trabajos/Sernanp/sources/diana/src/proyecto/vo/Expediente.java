package proyecto.vo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Expediente {

	private int idexpediente;
	private Infractor infractor;
	private Date fechaexpediente;
	private String fechaExpedienteString;
	private Resolucion resolucion;
	private Archivo archivo;
	
	private AnpxExpedientexAno anpxExpedientexano;

//	private Multa multa;

	private List<ExpedienteInfraccion> listaExpedienteInfraccion;
	private List<ExpedienteSancion> listaExpedienteSancion;
	
	private Areanatural areanatural;
	
	private int idareanatural;
	
	// JCEV 13-09.2012
	/*private int idAnpxExpedientexAno;
	private int correlAnpxExpedientexAno;
	private int anoAnpxExpedientexAno;*/
	
	private String datavariado;
	private String observacion;
	
	// JCEV
	private String morosidad;
	
	// JCEV - 21-10-2012
	private int estadoexpediente;
	private Date fechaestadoexpediente;
	private String usuario;
	private String obsestadoexpediente;
	
	private int flagestadopago;
	
	public Expediente(){
		areanatural = new Areanatural();
		
		infractor                 = new Infractor();
		resolucion                = new Resolucion();
		anpxExpedientexano        = new AnpxExpedientexAno();
//		multa                     = new Multa();
		listaExpedienteInfraccion = new ArrayList<ExpedienteInfraccion>();
		listaExpedienteSancion    = new ArrayList<ExpedienteSancion>();	
		
		archivo = new Archivo();
	}

	public List<ExpedienteInfraccion> getListaExpedienteInfraccion() {
		return listaExpedienteInfraccion;
	}

	public void setListaExpedienteInfraccion(List<ExpedienteInfraccion> listaExpedienteInfraccion) {
		this.listaExpedienteInfraccion = listaExpedienteInfraccion;
	}

	public List<ExpedienteSancion> getListaExpedienteSancion() {
		return listaExpedienteSancion;
	}

	public void setListaExpedienteSancion(List<ExpedienteSancion> listaExpedienteSancion) {
		this.listaExpedienteSancion = listaExpedienteSancion;
	}

	public int getIdexpediente() {
		return idexpediente;
	}
	
	public void setIdexpediente(int idexpediente) {
		this.idexpediente = idexpediente;
	}
	
	public Infractor getInfractor() {
		return infractor;
	}
	
	public void setInfractor(Infractor infractor) {
		this.infractor = infractor;
	}
	
	public Date getFechaexpediente() {
		return fechaexpediente;
	}
	
	public void setFechaexpediente(Date fechaexpediente) {
		this.fechaexpediente = fechaexpediente;
	}
	
	public Resolucion getResolucion() {
		return resolucion;
	}	

	public void setResolucion(Resolucion resolucion) {
		this.resolucion = resolucion;
	}
	
//	public Multa getMulta() {
//		return multa;
//	}
//	
//	public void setMulta(Multa multa) {
//		this.multa = multa;
//	}
	
	public String getFechaExpedienteString() {
		return fechaExpedienteString;
	}

	public void setFechaExpedienteString(String fechaExpedienteString) {
		this.fechaExpedienteString = fechaExpedienteString;
	}

	public int getIdareanatural() {
		return idareanatural;
	}

	public void setIdareanatural(int idareanatural) {
		this.idareanatural = idareanatural;
	}

	public String getDatavariado() {
		return datavariado;
	}

	public void setDatavariado(String datavariado) {
		this.datavariado = datavariado;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public AnpxExpedientexAno getAnpxExpedientexano() {
		return anpxExpedientexano;
	}

	public void setAnpxExpedientexano(AnpxExpedientexAno anpxExpedientexano) {
		this.anpxExpedientexano = anpxExpedientexano;
	}

	public String getMorosidad() {
		return morosidad;
	}

	public void setMorosidad(String morosidad) {
		this.morosidad = morosidad;
	}

	public int getEstadoexpediente() {
		return estadoexpediente;
	}

	public void setEstadoexpediente(int estadoexpediente) {
		this.estadoexpediente = estadoexpediente;
	}

	public Date getFechaestadoexpediente() {
		return fechaestadoexpediente;
	}

	public void setFechaestadoexpediente(Date fechaestadoexpediente) {
		this.fechaestadoexpediente = fechaestadoexpediente;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getObsestadoexpediente() {
		return obsestadoexpediente;
	}

	public void setObsestadoexpediente(String obsestadoexpediente) {
		this.obsestadoexpediente = obsestadoexpediente;
	}

	public int getFlagestadopago() {
		return flagestadopago;
	}

	public void setFlagestadopago(int flagestadopago) {
		this.flagestadopago = flagestadopago;
	}

	public Areanatural getAreanatural() {
		return areanatural;
	}

	public void setAreanatural(Areanatural areanatural) {
		this.areanatural = areanatural;
	}

	public Archivo getArchivo() {
		return archivo;
	}

	public void setArchivo(Archivo archivo) {
		this.archivo = archivo;
	}
	
	

}