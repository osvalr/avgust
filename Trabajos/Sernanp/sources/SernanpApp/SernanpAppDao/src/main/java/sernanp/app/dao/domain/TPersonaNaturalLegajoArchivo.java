package sernanp.app.dao.domain;

public class TPersonaNaturalLegajoArchivo extends TPersonaNaturalLegajoArchivoKey {
    private Integer srl_id_persona_natural_legajo;

    private Integer srl_id_archivo;

    private Integer int_num_version;

    private Integer srl_id_archivopadre;

    public Integer getSrl_id_persona_natural_legajo() {
        return srl_id_persona_natural_legajo;
    }

    public void setSrl_id_persona_natural_legajo(Integer srl_id_persona_natural_legajo) {
        this.srl_id_persona_natural_legajo = srl_id_persona_natural_legajo;
    }

    public Integer getSrl_id_archivo() {
        return srl_id_archivo;
    }

    public void setSrl_id_archivo(Integer srl_id_archivo) {
        this.srl_id_archivo = srl_id_archivo;
    }

    public Integer getInt_num_version() {
        return int_num_version;
    }

    public void setInt_num_version(Integer int_num_version) {
        this.int_num_version = int_num_version;
    }

    public Integer getSrl_id_archivopadre() {
        return srl_id_archivopadre;
    }

    public void setSrl_id_archivopadre(Integer srl_id_archivopadre) {
        this.srl_id_archivopadre = srl_id_archivopadre;
    }
}