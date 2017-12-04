package sernanp.app.dao.domain;

public class TSecuenciaDefinicion extends TSecuenciaDefinicionKey {
    private String var_nombre_tabla;

    private String var_prefijo_secuencia;

    private String var_descrip_prefijo;

    public String getVar_nombre_tabla() {
        return var_nombre_tabla;
    }

    public void setVar_nombre_tabla(String var_nombre_tabla) {
        this.var_nombre_tabla = var_nombre_tabla;
    }

    public String getVar_prefijo_secuencia() {
        return var_prefijo_secuencia;
    }

    public void setVar_prefijo_secuencia(String var_prefijo_secuencia) {
        this.var_prefijo_secuencia = var_prefijo_secuencia;
    }

    public String getVar_descrip_prefijo() {
        return var_descrip_prefijo;
    }

    public void setVar_descrip_prefijo(String var_descrip_prefijo) {
        this.var_descrip_prefijo = var_descrip_prefijo;
    }
}