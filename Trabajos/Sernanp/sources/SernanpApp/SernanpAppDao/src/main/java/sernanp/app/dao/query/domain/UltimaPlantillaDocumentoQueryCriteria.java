package sernanp.app.dao.query.domain;

import java.util.Date;

public class UltimaPlantillaDocumentoQueryCriteria {

	private String var_nombre_plantilla;
	private Date dte_fecha_validez;

	public String getVar_nombre_plantilla() {
		return var_nombre_plantilla;
	}

	public void setVar_nombre_plantilla(String var_nombre_plantilla) {
		this.var_nombre_plantilla = var_nombre_plantilla;
	}

	public Date getDte_fecha_validez() {
		return dte_fecha_validez;
	}

	public void setDte_fecha_validez(Date dte_fecha_validez) {
		this.dte_fecha_validez = dte_fecha_validez;
	}

}
