package sernanp.app.dao.domain;

public class TSecuenciaNumero extends TSecuenciaNumeroKey {
    private Integer srl_id_secuencia;

    private String var_numero_secuencia;

    public Integer getSrl_id_secuencia() {
        return srl_id_secuencia;
    }

    public void setSrl_id_secuencia(Integer srl_id_secuencia) {
        this.srl_id_secuencia = srl_id_secuencia;
    }

    public String getVar_numero_secuencia() {
        return var_numero_secuencia;
    }

    public void setVar_numero_secuencia(String var_numero_secuencia) {
        this.var_numero_secuencia = var_numero_secuencia;
    }
}