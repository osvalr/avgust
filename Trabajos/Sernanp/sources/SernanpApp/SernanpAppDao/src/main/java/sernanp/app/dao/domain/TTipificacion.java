package sernanp.app.dao.domain;

public class TTipificacion extends TTipificacionKey {
    private Integer int_id_tipificacion;

    private String var_descripcion_tipificacion;

    public Integer getInt_id_tipificacion() {
        return int_id_tipificacion;
    }

    public void setInt_id_tipificacion(Integer int_id_tipificacion) {
        this.int_id_tipificacion = int_id_tipificacion;
    }

    public String getVar_descripcion_tipificacion() {
        return var_descripcion_tipificacion;
    }

    public void setVar_descripcion_tipificacion(String var_descripcion_tipificacion) {
        this.var_descripcion_tipificacion = var_descripcion_tipificacion;
    }
}