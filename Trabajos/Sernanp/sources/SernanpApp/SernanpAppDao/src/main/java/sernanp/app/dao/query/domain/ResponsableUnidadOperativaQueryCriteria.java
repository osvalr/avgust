package sernanp.app.dao.query.domain;

import java.util.Date;

public class ResponsableUnidadOperativaQueryCriteria {

	private Integer idunidad;
	private Date tsp_fecha_corte;

	public Integer getIdunidad() {
		return idunidad;
	}

	public void setIdunidad(Integer idunidad) {
		this.idunidad = idunidad;
	}

	public Date getTsp_fecha_corte() {
		return tsp_fecha_corte;
	}

	public void setTsp_fecha_corte(Date tsp_fecha_corte) {
		this.tsp_fecha_corte = tsp_fecha_corte;
	}

}
