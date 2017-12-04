package sernanp.app.dao.domain;

public class TConvocatoriaAreaOrgPersonal extends TConvocatoriaAreaOrgPersonalKey {
    private Integer srl_id_conv_area_org;

    private Integer idpersonal;

    private Integer idrol;

    public Integer getSrl_id_conv_area_org() {
        return srl_id_conv_area_org;
    }

    public void setSrl_id_conv_area_org(Integer srl_id_conv_area_org) {
        this.srl_id_conv_area_org = srl_id_conv_area_org;
    }

    public Integer getIdpersonal() {
        return idpersonal;
    }

    public void setIdpersonal(Integer idpersonal) {
        this.idpersonal = idpersonal;
    }

    public Integer getIdrol() {
        return idrol;
    }

    public void setIdrol(Integer idrol) {
        this.idrol = idrol;
    }
}