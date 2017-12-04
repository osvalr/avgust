package sernanp.app.dao.domain;

import java.util.Date;

public class Personanatural extends PersonanaturalKey {
    private Integer idpersona;

    private String nombre;

    private String apepat;

    private String apemat;

    private Integer idtipodocumento;

    private String numerodoc;

    private Date fechanacimiento;

    private Integer idsexo;

    private Integer idestadocivil;

    private Integer temporal;

    private String ruc;

    private String direccion;

    private Integer idubigeo;

    private String var_num_file;

    private String var_num_caja;

    private String var_numero_pasaporte;

    private String var_numero_brevete;

    public Integer getIdpersona() {
        return idpersona;
    }

    public void setIdpersona(Integer idpersona) {
        this.idpersona = idpersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApepat() {
        return apepat;
    }

    public void setApepat(String apepat) {
        this.apepat = apepat;
    }

    public String getApemat() {
        return apemat;
    }

    public void setApemat(String apemat) {
        this.apemat = apemat;
    }

    public Integer getIdtipodocumento() {
        return idtipodocumento;
    }

    public void setIdtipodocumento(Integer idtipodocumento) {
        this.idtipodocumento = idtipodocumento;
    }

    public String getNumerodoc() {
        return numerodoc;
    }

    public void setNumerodoc(String numerodoc) {
        this.numerodoc = numerodoc;
    }

    public Date getFechanacimiento() {
        return fechanacimiento;
    }

    public void setFechanacimiento(Date fechanacimiento) {
        this.fechanacimiento = fechanacimiento;
    }

    public Integer getIdsexo() {
        return idsexo;
    }

    public void setIdsexo(Integer idsexo) {
        this.idsexo = idsexo;
    }

    public Integer getIdestadocivil() {
        return idestadocivil;
    }

    public void setIdestadocivil(Integer idestadocivil) {
        this.idestadocivil = idestadocivil;
    }

    public Integer getTemporal() {
        return temporal;
    }

    public void setTemporal(Integer temporal) {
        this.temporal = temporal;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Integer getIdubigeo() {
        return idubigeo;
    }

    public void setIdubigeo(Integer idubigeo) {
        this.idubigeo = idubigeo;
    }

    public String getVar_num_file() {
        return var_num_file;
    }

    public void setVar_num_file(String var_num_file) {
        this.var_num_file = var_num_file;
    }

    public String getVar_num_caja() {
        return var_num_caja;
    }

    public void setVar_num_caja(String var_num_caja) {
        this.var_num_caja = var_num_caja;
    }

    public String getVar_numero_pasaporte() {
        return var_numero_pasaporte;
    }

    public void setVar_numero_pasaporte(String var_numero_pasaporte) {
        this.var_numero_pasaporte = var_numero_pasaporte;
    }

    public String getVar_numero_brevete() {
        return var_numero_brevete;
    }

    public void setVar_numero_brevete(String var_numero_brevete) {
        this.var_numero_brevete = var_numero_brevete;
    }
}