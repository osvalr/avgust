package sernanp.app.dao.domain;

import java.util.Date;

public class TPlantillaDocumentoArchivo extends TPlantillaDocumentoArchivoKey {
    private Integer srl_id_plantilla_documento;

    private Date dte_fecha_validez;

    private Integer int_estado_plantilla_documento;

    public Integer getSrl_id_plantilla_documento() {
        return srl_id_plantilla_documento;
    }

    public void setSrl_id_plantilla_documento(Integer srl_id_plantilla_documento) {
        this.srl_id_plantilla_documento = srl_id_plantilla_documento;
    }

    public Date getDte_fecha_validez() {
        return dte_fecha_validez;
    }

    public void setDte_fecha_validez(Date dte_fecha_validez) {
        this.dte_fecha_validez = dte_fecha_validez;
    }

    public Integer getInt_estado_plantilla_documento() {
        return int_estado_plantilla_documento;
    }

    public void setInt_estado_plantilla_documento(Integer int_estado_plantilla_documento) {
        this.int_estado_plantilla_documento = int_estado_plantilla_documento;
    }
}