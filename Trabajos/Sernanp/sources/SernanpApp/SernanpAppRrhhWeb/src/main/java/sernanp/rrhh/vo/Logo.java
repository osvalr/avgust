package sernanp.rrhh.vo;

// Generated 14/10/2010 09:52:30 AM by Hibernate Tools 3.3.0.GA

import java.io.Serializable;
import java.sql.Timestamp;

public class Logo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idlogo;
	private String deslogo;
	private String nombrelogo;
	private String nombregeneradologo;
	private Timestamp fechauploadlogo;
	private int flaglogo;
	private Directorioarchivo directorioarchivo;
	private Areanatural areanatural;
	private Tipo tipologo;
	
	
	
	
	
	public Logo(){
		directorioarchivo=new Directorioarchivo();
		areanatural=new Areanatural();
		tipologo=new Tipo();
	}





	public int getIdlogo() {
		return idlogo;
	}





	public void setIdlogo(int idlogo) {
		this.idlogo = idlogo;
	}





	public String getDeslogo() {
		return deslogo;
	}





	public void setDeslogo(String deslogo) {
		this.deslogo = deslogo;
	}





	public String getNombrelogo() {
		return nombrelogo;
	}





	public void setNombrelogo(String nombrelogo) {
		this.nombrelogo = nombrelogo;
	}





	public String getNombregeneradologo() {
		return nombregeneradologo;
	}





	public void setNombregeneradologo(String nombregeneradologo) {
		this.nombregeneradologo = nombregeneradologo;
	}





	public Timestamp getFechauploadlogo() {
		return fechauploadlogo;
	}





	public void setFechauploadlogo(Timestamp fechauploadlogo) {
		this.fechauploadlogo = fechauploadlogo;
	}





	public int getFlaglogo() {
		return flaglogo;
	}





	public void setFlaglogo(int flaglogo) {
		this.flaglogo = flaglogo;
	}





	public Directorioarchivo getDirectorioarchivo() {
		return directorioarchivo;
	}





	public void setDirectorioarchivo(Directorioarchivo directorioarchivo) {
		this.directorioarchivo = directorioarchivo;
	}





	public Areanatural getAreanatural() {
		return areanatural;
	}





	public void setAreanatural(Areanatural areanatural) {
		this.areanatural = areanatural;
	}





	public Tipo getTipologo() {
		return tipologo;
	}





	public void setTipologo(Tipo tipologo) {
		this.tipologo = tipologo;
	}





	
	
	
	
	
	

}
