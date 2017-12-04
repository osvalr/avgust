package proyecto.vo;

public class Infraccion {
	
	private int idinfraccion;
	private String descripcioninfraccion;
	private String codigoinfraccion;
	
	private int reincidencia;
	private int checkeado;
	
	public int getIdinfraccion() {
		return idinfraccion;
	}
	
	public void setIdinfraccion(int idinfraccion) {
		this.idinfraccion = idinfraccion;
	}
	
	public String getDescripcioninfraccion() {
		return descripcioninfraccion;
	}
	
	public void setDescripcioninfraccion(String descripcioninfraccion) {
		this.descripcioninfraccion = descripcioninfraccion;
	}
	
	public String getCodigoinfraccion() {
		return codigoinfraccion;
	}
	
	public void setCodigoinfraccion(String codigoinfraccion) {
		this.codigoinfraccion = codigoinfraccion;
	}
	
	public int getReincidencia() {
		return reincidencia;
	}
	
	public void setReincidencia(int reincidencia) {
		this.reincidencia = reincidencia;
	}
	
	public int getCheckeado() {
		return checkeado;
	}

	public void setCheckeado(int checkeado) {
		this.checkeado = checkeado;
	}

}