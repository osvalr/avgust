package sernanp.app.dao.domain;

public class TGrupoOcupacional extends TGrupoOcupacionalKey {
    private String var_desc_grupo_ocupacional;

    private Integer int_cod_grupo_ocupacional;

    public String getVar_desc_grupo_ocupacional() {
        return var_desc_grupo_ocupacional;
    }

    public void setVar_desc_grupo_ocupacional(String var_desc_grupo_ocupacional) {
        this.var_desc_grupo_ocupacional = var_desc_grupo_ocupacional;
    }

    public Integer getInt_cod_grupo_ocupacional() {
        return int_cod_grupo_ocupacional;
    }

    public void setInt_cod_grupo_ocupacional(Integer int_cod_grupo_ocupacional) {
        this.int_cod_grupo_ocupacional = int_cod_grupo_ocupacional;
    }
}