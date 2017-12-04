package sernanp.app.dao.domain;

public class Pais extends PaisKey {
    private String codpais;

    private String nompais;

    private String nacpais;

    public String getCodpais() {
        return codpais;
    }

    public void setCodpais(String codpais) {
        this.codpais = codpais;
    }

    public String getNompais() {
        return nompais;
    }

    public void setNompais(String nompais) {
        this.nompais = nompais;
    }

    public String getNacpais() {
        return nacpais;
    }

    public void setNacpais(String nacpais) {
        this.nacpais = nacpais;
    }
}