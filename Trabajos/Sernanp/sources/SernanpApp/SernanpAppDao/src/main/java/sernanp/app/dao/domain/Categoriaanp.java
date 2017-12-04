package sernanp.app.dao.domain;

public class Categoriaanp extends CategoriaanpKey {
    private String codcategoriaanp;

    private String descategoriaanp;

    private Integer estado;

    private String siglascategoriaanp;

    public String getCodcategoriaanp() {
        return codcategoriaanp;
    }

    public void setCodcategoriaanp(String codcategoriaanp) {
        this.codcategoriaanp = codcategoriaanp;
    }

    public String getDescategoriaanp() {
        return descategoriaanp;
    }

    public void setDescategoriaanp(String descategoriaanp) {
        this.descategoriaanp = descategoriaanp;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public String getSiglascategoriaanp() {
        return siglascategoriaanp;
    }

    public void setSiglascategoriaanp(String siglascategoriaanp) {
        this.siglascategoriaanp = siglascategoriaanp;
    }
}