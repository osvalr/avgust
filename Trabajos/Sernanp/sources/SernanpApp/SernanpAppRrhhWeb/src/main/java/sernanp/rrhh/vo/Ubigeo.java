package sernanp.rrhh.vo;

import java.io.Serializable;

public class Ubigeo implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idubigeo;
	private int idubigeodepartamento;
	private int idubigeoprovincia;
	private String coddepartamento;
	private String codprovincia;
	private String coddistrito;
	private String nombre;
	
	public Ubigeo(){
		
	}

	public int getIdubigeo() {
		return idubigeo;
	}

	public void setIdubigeo(int idubigeo) {
		this.idubigeo = idubigeo;
	}

	public String getCoddepartamento() {
		return coddepartamento;
	}

	public void setCoddepartamento(String coddepartamento) {
		this.coddepartamento = coddepartamento;
	}

	public String getCodprovincia() {
		return codprovincia;
	}

	public void setCodprovincia(String codprovincia) {
		this.codprovincia = codprovincia;
	}

	public String getCoddistrito() {
		return coddistrito;
	}

	public void setCoddistrito(String coddistrito) {
		this.coddistrito = coddistrito;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getIdubigeodepartamento() {
		return idubigeodepartamento;
	}

	public void setIdubigeodepartamento(int idubigeodepartamento) {
		this.idubigeodepartamento = idubigeodepartamento;
	}

	public int getIdubigeoprovincia() {
		return idubigeoprovincia;
	}

	public void setIdubigeoprovincia(int idubigeoprovincia) {
		this.idubigeoprovincia = idubigeoprovincia;
	}
	

	
	
	
	
}
