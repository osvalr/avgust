package pe.kapcom.coravi.types;

/**
 * Created by JRaffo on 9/03/17.
 */

public class LoginRequestType {

    private String nombre_usuario;
    private String clave_usuario;

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getClave_usuario() {
        return clave_usuario;
    }

    public void setClave_usuario(String clave_usuario) {
        this.clave_usuario = clave_usuario;
    }
}
