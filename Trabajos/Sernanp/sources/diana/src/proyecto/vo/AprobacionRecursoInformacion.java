package proyecto.vo;

import java.util.Date;

public class AprobacionRecursoInformacion implements java.io.Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idaprobacionrecursoinformacion;
	private int idrecursoinformacion;
	private Personal personal;
	private Areaorganica areaorganica;
	private Date fechaaprobacion;
	
	
	public AprobacionRecursoInformacion(){
		personal=new Personal();
		areaorganica=new Areaorganica();
		
	}


	public int getIdaprobacionrecursoinformacion() {
		return idaprobacionrecursoinformacion;
	}


	public void setIdaprobacionrecursoinformacion(int idaprobacionrecursoinformacion) {
		this.idaprobacionrecursoinformacion = idaprobacionrecursoinformacion;
	}


	public Personal getPersonal() {
		return personal;
	}


	public void setPersonal(Personal personal) {
		this.personal = personal;
	}


	public Areaorganica getAreaorganica() {
		return areaorganica;
	}


	public void setAreaorganica(Areaorganica areaorganica) {
		this.areaorganica = areaorganica;
	}


	public Date getFechaaprobacion() {
		return fechaaprobacion;
	}


	public void setFechaaprobacion(Date fechaaprobacion) {
		this.fechaaprobacion = fechaaprobacion;
	}


	public int getIdrecursoinformacion() {
		return idrecursoinformacion;
	}


	public void setIdrecursoinformacion(int idrecursoinformacion) {
		this.idrecursoinformacion = idrecursoinformacion;
	}
	
	
	

}
