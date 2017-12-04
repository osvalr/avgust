package sernanp.app.dao.domain;

import java.io.Serializable;

public class TPostulantePersonalArchivo extends TPostulantePersonalArchivoKey implements Serializable {
    private Integer int_id_postulante;

    private String var_descripcion_archivo;

    private Integer int_id_tipo_documento;

    private static final long serialVersionUID = 1L;

    public Integer getInt_id_postulante() {
        return int_id_postulante;
    }

    public void setInt_id_postulante(Integer int_id_postulante) {
        this.int_id_postulante = int_id_postulante;
    }

    public String getVar_descripcion_archivo() {
        return var_descripcion_archivo;
    }

    public void setVar_descripcion_archivo(String var_descripcion_archivo) {
        this.var_descripcion_archivo = var_descripcion_archivo;
    }

    public Integer getInt_id_tipo_documento() {
        return int_id_tipo_documento;
    }

    public void setInt_id_tipo_documento(Integer int_id_tipo_documento) {
        this.int_id_tipo_documento = int_id_tipo_documento;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", int_id_postulante=").append(int_id_postulante);
        sb.append(", var_descripcion_archivo=").append(var_descripcion_archivo);
        sb.append(", int_id_tipo_documento=").append(int_id_tipo_documento);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}