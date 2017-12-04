package sernanp.app.dao.domain;

public class TTipoProfesion extends TTipoProfesionKey {
    private Integer int_cod_tipo_profesion;

    private String var_descripcion_tipo_profesion;

    public Integer getInt_cod_tipo_profesion() {
        return int_cod_tipo_profesion;
    }

    public void setInt_cod_tipo_profesion(Integer int_cod_tipo_profesion) {
        this.int_cod_tipo_profesion = int_cod_tipo_profesion;
    }

    public String getVar_descripcion_tipo_profesion() {
        return var_descripcion_tipo_profesion;
    }

    public void setVar_descripcion_tipo_profesion(String var_descripcion_tipo_profesion) {
        this.var_descripcion_tipo_profesion = var_descripcion_tipo_profesion;
    }
}