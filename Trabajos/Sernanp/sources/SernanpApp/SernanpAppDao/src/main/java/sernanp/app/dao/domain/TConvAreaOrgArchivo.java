package sernanp.app.dao.domain;

public class TConvAreaOrgArchivo extends TConvAreaOrgArchivoKey {
    private Integer srl_id_conv_area_org;

    private Integer srl_id_conv_area_org_etapa;

    private String var_descrip_archivo;

    public Integer getSrl_id_conv_area_org() {
        return srl_id_conv_area_org;
    }

    public void setSrl_id_conv_area_org(Integer srl_id_conv_area_org) {
        this.srl_id_conv_area_org = srl_id_conv_area_org;
    }

    public Integer getSrl_id_conv_area_org_etapa() {
        return srl_id_conv_area_org_etapa;
    }

    public void setSrl_id_conv_area_org_etapa(Integer srl_id_conv_area_org_etapa) {
        this.srl_id_conv_area_org_etapa = srl_id_conv_area_org_etapa;
    }

    public String getVar_descrip_archivo() {
        return var_descrip_archivo;
    }

    public void setVar_descrip_archivo(String var_descrip_archivo) {
        this.var_descrip_archivo = var_descrip_archivo;
    }
}