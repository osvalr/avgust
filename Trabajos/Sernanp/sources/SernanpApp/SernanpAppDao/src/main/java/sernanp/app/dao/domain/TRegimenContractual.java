package sernanp.app.dao.domain;

public class TRegimenContractual extends TRegimenContractualKey {
    private String var_descripcion_regimen_contractual;

    private Integer int_cod_regimen_contractual;

    public String getVar_descripcion_regimen_contractual() {
        return var_descripcion_regimen_contractual;
    }

    public void setVar_descripcion_regimen_contractual(String var_descripcion_regimen_contractual) {
        this.var_descripcion_regimen_contractual = var_descripcion_regimen_contractual;
    }

    public Integer getInt_cod_regimen_contractual() {
        return int_cod_regimen_contractual;
    }

    public void setInt_cod_regimen_contractual(Integer int_cod_regimen_contractual) {
        this.int_cod_regimen_contractual = int_cod_regimen_contractual;
    }
}