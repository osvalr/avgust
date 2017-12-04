package sernanp.app.dao.domain;

public class TRequerimientoPersonalArchivo extends TRequerimientoPersonalArchivoKey {
    private Integer srl_id_requerimiento_personal;

    private String var_descripcion_archivo;

    public Integer getSrl_id_requerimiento_personal() {
        return srl_id_requerimiento_personal;
    }

    public void setSrl_id_requerimiento_personal(Integer srl_id_requerimiento_personal) {
        this.srl_id_requerimiento_personal = srl_id_requerimiento_personal;
    }

    public String getVar_descripcion_archivo() {
        return var_descripcion_archivo;
    }

    public void setVar_descripcion_archivo(String var_descripcion_archivo) {
        this.var_descripcion_archivo = var_descripcion_archivo;
    }
}