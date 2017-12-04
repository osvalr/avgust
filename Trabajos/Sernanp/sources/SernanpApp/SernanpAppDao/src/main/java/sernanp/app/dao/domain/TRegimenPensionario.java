package sernanp.app.dao.domain;

public class TRegimenPensionario extends TRegimenPensionarioKey {
    private Integer srl_id_regimen_contractual;

    private Integer int_cod_regimen_pensionario;

    private String var_descripcion_regimen_pensionario;

    public Integer getSrl_id_regimen_contractual() {
        return srl_id_regimen_contractual;
    }

    public void setSrl_id_regimen_contractual(Integer srl_id_regimen_contractual) {
        this.srl_id_regimen_contractual = srl_id_regimen_contractual;
    }

    public Integer getInt_cod_regimen_pensionario() {
        return int_cod_regimen_pensionario;
    }

    public void setInt_cod_regimen_pensionario(Integer int_cod_regimen_pensionario) {
        this.int_cod_regimen_pensionario = int_cod_regimen_pensionario;
    }

    public String getVar_descripcion_regimen_pensionario() {
        return var_descripcion_regimen_pensionario;
    }

    public void setVar_descripcion_regimen_pensionario(String var_descripcion_regimen_pensionario) {
        this.var_descripcion_regimen_pensionario = var_descripcion_regimen_pensionario;
    }
}