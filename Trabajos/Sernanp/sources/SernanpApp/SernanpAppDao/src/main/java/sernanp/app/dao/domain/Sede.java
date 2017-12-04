package sernanp.app.dao.domain;

public class Sede extends SedeKey {
    private String dessede;

    private String direccion;

    private Integer idareanatural;

    private Integer idsedeprincipal;

    private Integer idubigeo;

    private Integer int_sede_principal;

    public String getDessede() {
        return dessede;
    }

    public void setDessede(String dessede) {
        this.dessede = dessede;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Integer getIdareanatural() {
        return idareanatural;
    }

    public void setIdareanatural(Integer idareanatural) {
        this.idareanatural = idareanatural;
    }

    public Integer getIdsedeprincipal() {
        return idsedeprincipal;
    }

    public void setIdsedeprincipal(Integer idsedeprincipal) {
        this.idsedeprincipal = idsedeprincipal;
    }

    public Integer getIdubigeo() {
        return idubigeo;
    }

    public void setIdubigeo(Integer idubigeo) {
        this.idubigeo = idubigeo;
    }

    public Integer getInt_sede_principal() {
        return int_sede_principal;
    }

    public void setInt_sede_principal(Integer int_sede_principal) {
        this.int_sede_principal = int_sede_principal;
    }
}