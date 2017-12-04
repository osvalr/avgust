package sernanp.app.util;

import java.util.HashMap;
import java.util.Map;

public class TransaccionUtil {
	
	private Integer estadoTransaccion;
	private Map<String,String> mensajes = new HashMap<String,String>();
	private String mensaje;
	
	public Integer getEstadoTransaccion() {
		return estadoTransaccion;
	}
	public void setEstadoTransaccion(Integer estadoTransaccion) {
		this.estadoTransaccion = estadoTransaccion;
	}
	public Map<String, String> getMensajes() {
		return mensajes;
	}
	public void setMensajes(Map<String, String> mensajes) {
		this.mensajes = mensajes;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
}
