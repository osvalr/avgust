package proyecto.vo;

public class UsuarioRol implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	
	private Rol rol;
	private Usuario usuario;
	
	public UsuarioRol() {
		rol		= new Rol();
		usuario	= new Usuario();
	}
	
	public Rol getRol() {
		return rol;
	}
	
	public void setRol(Rol rol) {
		this.rol = rol;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}
