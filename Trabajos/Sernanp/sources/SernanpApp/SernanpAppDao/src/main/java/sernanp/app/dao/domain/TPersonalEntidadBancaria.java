package sernanp.app.dao.domain;

public class TPersonalEntidadBancaria extends TPersonalEntidadBancariaKey {
    private Integer idpersonal;

    private Integer srl_id_entidad_bancaria;

    private String var_numero_cuenta_bancaria;

    public Integer getIdpersonal() {
        return idpersonal;
    }

    public void setIdpersonal(Integer idpersonal) {
        this.idpersonal = idpersonal;
    }

    public Integer getSrl_id_entidad_bancaria() {
        return srl_id_entidad_bancaria;
    }

    public void setSrl_id_entidad_bancaria(Integer srl_id_entidad_bancaria) {
        this.srl_id_entidad_bancaria = srl_id_entidad_bancaria;
    }

    public String getVar_numero_cuenta_bancaria() {
        return var_numero_cuenta_bancaria;
    }

    public void setVar_numero_cuenta_bancaria(String var_numero_cuenta_bancaria) {
        this.var_numero_cuenta_bancaria = var_numero_cuenta_bancaria;
    }
}