package proyecto.excepcion;

public class DAOException extends Exception {

	private static final long serialVersionUID = 1L;
	private String mensaje;

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public DAOException(Exception e) {
		super("Error en DAO: " + e);
	}

	public DAOException() {

	}

	public DAOException(String mensaje) {
		super(mensaje);
		this.mensaje = mensaje;
	}
}
