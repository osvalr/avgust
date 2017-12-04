package sernanp.app.dao.domain;

public class TUnidadOperativa extends TUnidadOperativaKey {
    private String var_nom_unidad;

    private String var_ubicacion_fisica;

    public String getVar_nom_unidad() {
        return var_nom_unidad;
    }

    public void setVar_nom_unidad(String var_nom_unidad) {
        this.var_nom_unidad = var_nom_unidad;
    }

    public String getVar_ubicacion_fisica() {
        return var_ubicacion_fisica;
    }

    public void setVar_ubicacion_fisica(String var_ubicacion_fisica) {
        this.var_ubicacion_fisica = var_ubicacion_fisica;
    }
}