package proyecto.param;

import java.io.Serializable;
import java.util.Date;

import proyecto.vo.Fichaturismo;

public class FichaTurismoParam implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Fichaturismo fichaturismo;
	private Date fechapropuestainicio;
	private Date fechapropuestafin;
	private String fpropuestainicio;
	private String fpropuestafin;
	private Date fecharegistroinicio;
	private Date fecharegistrofin;
	private String fregistroinicio;
	private String fregistrofin;
	private int idtipoconsulta;
	private int idtiporolcreacion;
	
	public FichaTurismoParam(){
		fichaturismo=new Fichaturismo();
		fpropuestainicio="";
		fpropuestafin="";
		fregistroinicio="";
		fregistrofin="";
	}


	public Fichaturismo getFichaturismo() {
		return fichaturismo;
	}


	public void setFichaturismo(Fichaturismo fichaturismo) {
		this.fichaturismo = fichaturismo;
	}


	public Date getFechapropuestainicio() {
		return fechapropuestainicio;
	}


	public void setFechapropuestainicio(Date fechapropuestainicio) {
		this.fechapropuestainicio = fechapropuestainicio;
	}


	public Date getFechapropuestafin() {
		return fechapropuestafin;
	}


	public void setFechapropuestafin(Date fechapropuestafin) {
		this.fechapropuestafin = fechapropuestafin;
	}


	public String getFpropuestainicio() {
		return fpropuestainicio;
	}


	public void setFpropuestainicio(String fpropuestainicio) {
		this.fpropuestainicio = fpropuestainicio;
	}


	public String getFpropuestafin() {
		return fpropuestafin;
	}


	public void setFpropuestafin(String fpropuestafin) {
		this.fpropuestafin = fpropuestafin;
	}


	public Date getFecharegistroinicio() {
		return fecharegistroinicio;
	}


	public void setFecharegistroinicio(Date fecharegistroinicio) {
		this.fecharegistroinicio = fecharegistroinicio;
	}


	public Date getFecharegistrofin() {
		return fecharegistrofin;
	}


	public void setFecharegistrofin(Date fecharegistrofin) {
		this.fecharegistrofin = fecharegistrofin;
	}


	public String getFregistroinicio() {
		return fregistroinicio;
	}


	public void setFregistroinicio(String fregistroinicio) {
		this.fregistroinicio = fregistroinicio;
	}


	public String getFregistrofin() {
		return fregistrofin;
	}


	public void setFregistrofin(String fregistrofin) {
		this.fregistrofin = fregistrofin;
	}


	public int getIdtipoconsulta() {
		return idtipoconsulta;
	}


	public void setIdtipoconsulta(int idtipoconsulta) {
		this.idtipoconsulta = idtipoconsulta;
	}


	public int getIdtiporolcreacion() {
		return idtiporolcreacion;
	}


	public void setIdtiporolcreacion(int idtiporolcreacion) {
		this.idtiporolcreacion = idtiporolcreacion;
	}
	
	
	
	
	
	
	

}
