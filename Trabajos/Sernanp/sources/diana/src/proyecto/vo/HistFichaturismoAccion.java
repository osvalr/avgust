package proyecto.vo;

import java.sql.Timestamp;


public class HistFichaturismoAccion implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idhistfichaturismoaccion;
	private long idfichaturismo;
	private Tipo tipoaccionficha;
	private Timestamp fecha;
	private Usuario usuario;
	
	public HistFichaturismoAccion() {
		tipoaccionficha=new Tipo();
		usuario=new Usuario();
	}

	public int getIdhistfichaturismoaccion() {
		return idhistfichaturismoaccion;
	}

	public void setIdhistfichaturismoaccion(int idhistfichaturismoaccion) {
		this.idhistfichaturismoaccion = idhistfichaturismoaccion;
	}

	
	public Tipo getTipoaccionficha() {
		return tipoaccionficha;
	}

	public void setTipoaccionficha(Tipo tipoaccionficha) {
		this.tipoaccionficha = tipoaccionficha;
	}

	public Timestamp getFecha() {
		return fecha;
	}

	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}

	public long getIdfichaturismo() {
		return idfichaturismo;
	}

	public void setIdfichaturismo(long idfichaturismo) {
		this.idfichaturismo = idfichaturismo;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	
	
	
	
	
	

}
