package sernanp.app.dao.domain;

import java.util.Date;

public class TPersonanaturalComposicionFamiliar extends TPersonanaturalComposicionFamiliarKey {
    private Integer idpersonanatural;

    private String var_datos_padre;

    private String var_datos_madre;

    private String var_datos_hijo;

    private String var_dni_hijo;

    private Date dte_fecha_nacimiento_hijo;

    public Integer getIdpersonanatural() {
        return idpersonanatural;
    }

    public void setIdpersonanatural(Integer idpersonanatural) {
        this.idpersonanatural = idpersonanatural;
    }

    public String getVar_datos_padre() {
        return var_datos_padre;
    }

    public void setVar_datos_padre(String var_datos_padre) {
        this.var_datos_padre = var_datos_padre;
    }

    public String getVar_datos_madre() {
        return var_datos_madre;
    }

    public void setVar_datos_madre(String var_datos_madre) {
        this.var_datos_madre = var_datos_madre;
    }

    public String getVar_datos_hijo() {
        return var_datos_hijo;
    }

    public void setVar_datos_hijo(String var_datos_hijo) {
        this.var_datos_hijo = var_datos_hijo;
    }

    public String getVar_dni_hijo() {
        return var_dni_hijo;
    }

    public void setVar_dni_hijo(String var_dni_hijo) {
        this.var_dni_hijo = var_dni_hijo;
    }

    public Date getDte_fecha_nacimiento_hijo() {
        return dte_fecha_nacimiento_hijo;
    }

    public void setDte_fecha_nacimiento_hijo(Date dte_fecha_nacimiento_hijo) {
        this.dte_fecha_nacimiento_hijo = dte_fecha_nacimiento_hijo;
    }
}