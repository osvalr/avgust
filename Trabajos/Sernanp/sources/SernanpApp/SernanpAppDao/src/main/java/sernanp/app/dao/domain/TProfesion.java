package sernanp.app.dao.domain;

public class TProfesion extends TProfesionKey {
    private Integer srl_id_tipo_profesion;

    private Integer int_cod_profesion;

    private String var_descripcion_profesion;

    public Integer getSrl_id_tipo_profesion() {
        return srl_id_tipo_profesion;
    }

    public void setSrl_id_tipo_profesion(Integer srl_id_tipo_profesion) {
        this.srl_id_tipo_profesion = srl_id_tipo_profesion;
    }

    public Integer getInt_cod_profesion() {
        return int_cod_profesion;
    }

    public void setInt_cod_profesion(Integer int_cod_profesion) {
        this.int_cod_profesion = int_cod_profesion;
    }

    public String getVar_descripcion_profesion() {
        return var_descripcion_profesion;
    }

    public void setVar_descripcion_profesion(String var_descripcion_profesion) {
        this.var_descripcion_profesion = var_descripcion_profesion;
    }
}