package sernanp.app.dao.domain;

public class Unidadoperativa extends UnidadoperativaKey {
    private String nomunidad;

    private Integer idarea;

    public String getNomunidad() {
        return nomunidad;
    }

    public void setNomunidad(String nomunidad) {
        this.nomunidad = nomunidad;
    }

    public Integer getIdarea() {
        return idarea;
    }

    public void setIdarea(Integer idarea) {
        this.idarea = idarea;
    }
}