package proyecto.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import proyecto.param.BoletajeParam;

public class Fichaturismo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long idfichaturismo;
	private String codigoficha; 
	private int flagfichaturismo;
	private Areanatural areanatural;
	private Rutaturismo rutaturismo;
	private Tipoturismo tipoturismo;
	private Date fechaingreso;
	private Date fecharegistro;
	private Date fechapropuesta;
	private String fingreso;
	private String fregistro;
	private String fpropuesta;
	private int numfecharegistro;
	private int numareanatural;
	private List<GuiaFichaTurismo> listaGuiaFichaturismo;
	private Operadorturismo operadorturismo;
	private Operadorturismo empresaturismo;
	private List<Visitante> listaVisitante;
	private int[] actividades;
	private List<Actividadturismo> listaActividadturismo;
	private List<TipoturismoFichaturismo> listaTipoturismoFichaturismo;
	private List<BoletajeParam> listaBoletajeParam;
	private double montototal;
	private Tipo estadopagobanco;
	private PagoBanco pagoBanco;
	private int flagpagobanco;
	private int flagfichagenerada;
	private int flagregistro;
	private int idtiporolcreacion;
	private Tipo estadoficha;
	private FichaturismoBoletaje fichaturismoboletaje;
	private double montoboletajeadicional;
//	private Tipo modalidadpago;
	private List<PagoFichaturismo> listaPagoFichaturismo;
	private double montopagado;
	private double montocalculadopagar;
	private List<HistFichaturismoAccion> listaHistorialaccion;
	
	public Fichaturismo(){
		areanatural=new Areanatural();
		rutaturismo=new Rutaturismo();
		tipoturismo=new Tipoturismo();
		listaGuiaFichaturismo=new ArrayList<GuiaFichaTurismo>();
		operadorturismo=new Operadorturismo();
		empresaturismo=new Operadorturismo();
		listaVisitante=new ArrayList<Visitante>();
		listaTipoturismoFichaturismo=new ArrayList<TipoturismoFichaturismo>();
		listaBoletajeParam=new ArrayList<BoletajeParam>();
		listaActividadturismo=new ArrayList<Actividadturismo>();
		estadopagobanco=new Tipo();
		pagoBanco=new PagoBanco();
		estadoficha=new Tipo();
		fichaturismoboletaje=new FichaturismoBoletaje();
		//modalidadpago=new Tipo();
		listaPagoFichaturismo=new ArrayList<PagoFichaturismo>();
		listaHistorialaccion=new ArrayList<HistFichaturismoAccion>();
	}
	
	public Fichaturismo(long idfichaturismo){
		this();
		this.idfichaturismo=idfichaturismo;
	}
	
	
	
	public int getNumfecharegistro() {
		return numfecharegistro;
	}





	public void setNumfecharegistro(int numfecharegistro) {
		this.numfecharegistro = numfecharegistro;
	}





	public int getNumareanatural() {
		return numareanatural;
	}





	public void setNumareanatural(int numareanatural) {
		this.numareanatural = numareanatural;
	}





	public String getFingreso() {
		return fingreso;
	}





	public void setFingreso(String fingreso) {
		this.fingreso = fingreso;
	}





	public String getFregistro() {
		return fregistro;
	}





	public void setFregistro(String fregistro) {
		this.fregistro = fregistro;
	}





	public String getFpropuesta() {
		return fpropuesta;
	}





	public void setFpropuesta(String fpropuesta) {
		this.fpropuesta = fpropuesta;
	}





	public long getIdfichaturismo() {
		return idfichaturismo;
	}





	public void setIdfichaturismo(long idfichaturismo) {
		this.idfichaturismo = idfichaturismo;
	}





	public String getCodigoficha() {
		return codigoficha;
	}
	public void setCodigoficha(String codigoficha) {
		this.codigoficha = codigoficha;
	}
	public int getFlagfichaturismo() {
		return flagfichaturismo;
	}
	public void setFlagfichaturismo(int flagfichaturismo) {
		this.flagfichaturismo = flagfichaturismo;
	}
	public Areanatural getAreanatural() {
		return areanatural;
	}
	public void setAreanatural(Areanatural areanatural) {
		this.areanatural = areanatural;
	}
	public Rutaturismo getRutaturismo() {
		return rutaturismo;
	}
	public void setRutaturismo(Rutaturismo rutaturismo) {
		this.rutaturismo = rutaturismo;
	}
	public Tipoturismo getTipoturismo() {
		return tipoturismo;
	}
	public void setTipoturismo(Tipoturismo tipoturismo) {
		this.tipoturismo = tipoturismo;
	}
	
	
	
	
	public Date getFechaingreso() {
		return fechaingreso;
	}





	public void setFechaingreso(Date fechaingreso) {
		this.fechaingreso = fechaingreso;
	}





	public Date getFecharegistro() {
		return fecharegistro;
	}





	public void setFecharegistro(Date fecharegistro) {
		this.fecharegistro = fecharegistro;
	}





	public Date getFechapropuesta() {
		return fechapropuesta;
	}





	public void setFechapropuesta(Date fechapropuesta) {
		this.fechapropuesta = fechapropuesta;
	}





	
	public Operadorturismo getOperadorturismo() {
		return operadorturismo;
	}
	public void setOperadorturismo(Operadorturismo operadorturismo) {
		this.operadorturismo = operadorturismo;
	}
	public Operadorturismo getEmpresaturismo() {
		return empresaturismo;
	}
	public void setEmpresaturismo(Operadorturismo empresaturismo) {
		this.empresaturismo = empresaturismo;
	}


	public List<Visitante> getListaVisitante() {
		return listaVisitante;
	}


	public void setListaVisitante(List<Visitante> listaVisitante) {
		this.listaVisitante = listaVisitante;
	}





	public int[] getActividades() {
		return actividades;
	}





	public void setActividades(int[] actividades) {
		this.actividades = actividades;
	}





	public List<GuiaFichaTurismo> getListaGuiaFichaturismo() {
		return listaGuiaFichaturismo;
	}





	public void setListaGuiaFichaturismo(
			List<GuiaFichaTurismo> listaGuiaFichaturismo) {
		this.listaGuiaFichaturismo = listaGuiaFichaturismo;
	}





	public List<TipoturismoFichaturismo> getListaTipoturismoFichaturismo() {
		return listaTipoturismoFichaturismo;
	}





	public void setListaTipoturismoFichaturismo(
			List<TipoturismoFichaturismo> listaTipoturismoFichaturismo) {
		this.listaTipoturismoFichaturismo = listaTipoturismoFichaturismo;
	}





	public List<BoletajeParam> getListaBoletajeParam() {
		return listaBoletajeParam;
	}





	public void setListaBoletajeParam(List<BoletajeParam> listaBoletajeParam) {
		this.listaBoletajeParam = listaBoletajeParam;
	}





	public List<Actividadturismo> getListaActividadturismo() {
		return listaActividadturismo;
	}





	public void setListaActividadturismo(
			List<Actividadturismo> listaActividadturismo) {
		this.listaActividadturismo = listaActividadturismo;
	}





	public double getMontototal() {
		return montototal;
	}





	public void setMontototal(double montototal) {
		this.montototal = montototal;
	}





	public Tipo getEstadopagobanco() {
		return estadopagobanco;
	}





	public void setEstadopagobanco(Tipo estadopagobanco) {
		this.estadopagobanco = estadopagobanco;
	}





	public PagoBanco getPagoBanco() {
		return pagoBanco;
	}





	public void setPagoBanco(PagoBanco pagoBanco) {
		this.pagoBanco = pagoBanco;
	}





	public int getFlagpagobanco() {
		return flagpagobanco;
	}





	public void setFlagpagobanco(int flagpagobanco) {
		this.flagpagobanco = flagpagobanco;
	}





	public int getFlagfichagenerada() {
		return flagfichagenerada;
	}





	public void setFlagfichagenerada(int flagfichagenerada) {
		this.flagfichagenerada = flagfichagenerada;
	}





	public int getFlagregistro() {
		return flagregistro;
	}





	public void setFlagregistro(int flagregistro) {
		this.flagregistro = flagregistro;
	}





	public int getIdtiporolcreacion() {
		return idtiporolcreacion;
	}





	public void setIdtiporolcreacion(int idtiporolcreacion) {
		this.idtiporolcreacion = idtiporolcreacion;
	}





	public Tipo getEstadoficha() {
		return estadoficha;
	}





	public void setEstadoficha(Tipo estadoficha) {
		this.estadoficha = estadoficha;
	}







	public List<PagoFichaturismo> getListaPagoFichaturismo() {
		return listaPagoFichaturismo;
	}

	public void setListaPagoFichaturismo(
			List<PagoFichaturismo> listaPagoFichaturismo) {
		this.listaPagoFichaturismo = listaPagoFichaturismo;
	}

	public double getMontoboletajeadicional() {
		return montoboletajeadicional;
	}

	public void setMontoboletajeadicional(double montoboletajeadicional) {
		this.montoboletajeadicional = montoboletajeadicional;
	}

	public FichaturismoBoletaje getFichaturismoboletaje() {
		return fichaturismoboletaje;
	}

	public void setFichaturismoboletaje(FichaturismoBoletaje fichaturismoboletaje) {
		this.fichaturismoboletaje = fichaturismoboletaje;
	}

	public double getMontopagado() {
		return montopagado;
	}

	public void setMontopagado(double montopagado) {
		this.montopagado = montopagado;
	}

	public double getMontocalculadopagar() {
		return montocalculadopagar;
	}

	public void setMontocalculadopagar(double montocalculadopagar) {
		this.montocalculadopagar = montocalculadopagar;
	}

	public List<HistFichaturismoAccion> getListaHistorialaccion() {
		return listaHistorialaccion;
	}

	public void setListaHistorialaccion(
			List<HistFichaturismoAccion> listaHistorialaccion) {
		this.listaHistorialaccion = listaHistorialaccion;
	}



	




	


	



	



	
	
	
	    
	
	
	
}
