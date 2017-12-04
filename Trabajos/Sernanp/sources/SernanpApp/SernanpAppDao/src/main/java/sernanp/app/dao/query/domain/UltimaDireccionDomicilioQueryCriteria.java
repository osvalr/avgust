package sernanp.app.dao.query.domain;

import java.util.Date;

public class UltimaDireccionDomicilioQueryCriteria {

	private Integer idpersonanatural;
	private Integer int_id_estado;
	private Date tsp_fecha_registro;

	public Integer getIdpersonanatural() {
		return idpersonanatural;
	}

	public void setIdpersonanatural(Integer idpersonanatural) {
		this.idpersonanatural = idpersonanatural;
	}

	public Integer getInt_id_estado() {
		return int_id_estado;
	}

	public void setInt_id_estado(Integer int_id_estado) {
		this.int_id_estado = int_id_estado;
	}

	public Date getTsp_fecha_registro() {
		return tsp_fecha_registro;
	}

	public void setTsp_fecha_registro(Date tsp_fecha_registro) {
		this.tsp_fecha_registro = tsp_fecha_registro;
	}

}
