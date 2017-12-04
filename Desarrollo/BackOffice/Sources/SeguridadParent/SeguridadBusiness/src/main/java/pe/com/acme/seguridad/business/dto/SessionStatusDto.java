package pe.com.acme.seguridad.business.dto;

public class SessionStatusDto {
	
	private Integer id_usuario;
	private String id_session;
	private String message;
	private boolean statusLogin = false;
	private boolean success=true;
	
	public Integer getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(Integer id_usuario) {
		this.id_usuario = id_usuario;
	}
	public String getId_session() {
		return id_session;
	}
	public void setId_session(String id_session) {
		this.id_session = id_session;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public boolean isStatusLogin() {
		return statusLogin;
	}
	public void setStatusLogin(boolean statusLogin) {
		this.statusLogin = statusLogin;
	}
}
