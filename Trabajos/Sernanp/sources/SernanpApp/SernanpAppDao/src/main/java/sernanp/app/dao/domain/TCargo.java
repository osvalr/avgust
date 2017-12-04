package sernanp.app.dao.domain;

public class TCargo extends TCargoKey {
    private String var_nom_cargo;

    private Integer int_est_cargo;

    public String getVar_nom_cargo() {
        return var_nom_cargo;
    }

    public void setVar_nom_cargo(String var_nom_cargo) {
        this.var_nom_cargo = var_nom_cargo;
    }

    public Integer getInt_est_cargo() {
        return int_est_cargo;
    }

    public void setInt_est_cargo(Integer int_est_cargo) {
        this.int_est_cargo = int_est_cargo;
    }
}