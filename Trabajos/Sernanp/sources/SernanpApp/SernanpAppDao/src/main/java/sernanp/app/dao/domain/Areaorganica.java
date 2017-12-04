package sernanp.app.dao.domain;

public class Areaorganica extends AreaorganicaKey {
    private String codarea;

    private String desarea;

    private Integer idtipoarea;

    private Integer telefonoareaorganica;

    private String direccionareaorganica;

    private Integer faxareaorganica;

    private Integer idsede;

    public String getCodarea() {
        return codarea;
    }

    public void setCodarea(String codarea) {
        this.codarea = codarea;
    }

    public String getDesarea() {
        return desarea;
    }

    public void setDesarea(String desarea) {
        this.desarea = desarea;
    }

    public Integer getIdtipoarea() {
        return idtipoarea;
    }

    public void setIdtipoarea(Integer idtipoarea) {
        this.idtipoarea = idtipoarea;
    }

    public Integer getTelefonoareaorganica() {
        return telefonoareaorganica;
    }

    public void setTelefonoareaorganica(Integer telefonoareaorganica) {
        this.telefonoareaorganica = telefonoareaorganica;
    }

    public String getDireccionareaorganica() {
        return direccionareaorganica;
    }

    public void setDireccionareaorganica(String direccionareaorganica) {
        this.direccionareaorganica = direccionareaorganica;
    }

    public Integer getFaxareaorganica() {
        return faxareaorganica;
    }

    public void setFaxareaorganica(Integer faxareaorganica) {
        this.faxareaorganica = faxareaorganica;
    }

    public Integer getIdsede() {
        return idsede;
    }

    public void setIdsede(Integer idsede) {
        this.idsede = idsede;
    }
}