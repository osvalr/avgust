package sernanp.app.dao.domain;

public class THistorial extends THistorialKey {
    private String var_nombre_tabla;

    private String var_valor_json_actual;

    public String getVar_nombre_tabla() {
        return var_nombre_tabla;
    }

    public void setVar_nombre_tabla(String var_nombre_tabla) {
        this.var_nombre_tabla = var_nombre_tabla;
    }

    public String getVar_valor_json_actual() {
        return var_valor_json_actual;
    }

    public void setVar_valor_json_actual(String var_valor_json_actual) {
        this.var_valor_json_actual = var_valor_json_actual;
    }
}