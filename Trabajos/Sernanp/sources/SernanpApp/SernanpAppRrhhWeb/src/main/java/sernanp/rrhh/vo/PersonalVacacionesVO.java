package sernanp.rrhh.vo;

import java.sql.Date;
import java.sql.Timestamp;

public class PersonalVacacionesVO {
	
	private	int srl_id_pers_vac;
	private int int_periodo_vac;
	private Date dte_fec_inicio_programacion_vac;
	private int int_est_vacaciones;
//	private Date dte_fec_vac_aprobadas;
	private Timestamp tsp_fec_sys_crea;
	private Timestamp tsp_fec_sys_mod;
	private int	int_dias_vac_corresponde;
	private int int_dias_vac_goce;
	private int int_dias_vac_pendientes;
	private int int_dias_vac_truncas;
	private double double_dias_vac_truncas;
	private int vac_pendientes_periodos_ant;//SE AGREGO PARA SABER SI TIENE VACACIONES PENDIENTES DE PERIODOS ANTERIORES AL QUE SE CONSULTA
	private int anios_servicio;
	private int meses_servicio;
	private int dias_servicio;
	private int int_cant_dias_laborados_truncos;
	private PersonalVO personal;
	private PersonalContratoAdendaVO personalContratoAdenda;
	
	public PersonalVacacionesVO(){
		personal 				= new PersonalVO();
		personalContratoAdenda	= new PersonalContratoAdendaVO();
	}

	public int getSrl_id_pers_vac() {
		return srl_id_pers_vac;
	}

	public void setSrl_id_pers_vac(int srl_id_pers_vac) {
		this.srl_id_pers_vac = srl_id_pers_vac;
	}

	public int getInt_periodo_vac() {
		return int_periodo_vac;
	}

	public void setInt_periodo_vac(int int_periodo_vac) {
		this.int_periodo_vac = int_periodo_vac;
	}

	public Date getDte_fec_inicio_programacion_vac() {
		return dte_fec_inicio_programacion_vac;
	}

	public void setDte_fec_inicio_programacion_vac(
			Date dte_fec_inicio_programacion_vac) {
		this.dte_fec_inicio_programacion_vac = dte_fec_inicio_programacion_vac;
	}

	public int getInt_est_vacaciones() {
		return int_est_vacaciones;
	}

	public void setInt_est_vacaciones(int int_est_vacaciones) {
		this.int_est_vacaciones = int_est_vacaciones;
	}

//	public Date getDte_fec_vac_aprobadas() {
//		return dte_fec_vac_aprobadas;
//	}
//
//	public void setDte_fec_vac_aprobadas(Date dte_fec_vac_aprobadas) {
//		this.dte_fec_vac_aprobadas = dte_fec_vac_aprobadas;
//	}

	public Timestamp getTsp_fec_sys_crea() {
		return tsp_fec_sys_crea;
	}

	public void setTsp_fec_sys_crea(Timestamp tsp_fec_sys_crea) {
		this.tsp_fec_sys_crea = tsp_fec_sys_crea;
	}

	public Timestamp getTsp_fec_sys_mod() {
		return tsp_fec_sys_mod;
	}

	public void setTsp_fec_sys_mod(Timestamp tsp_fec_sys_mod) {
		this.tsp_fec_sys_mod = tsp_fec_sys_mod;
	}


	public PersonalVO getPersonal() {
		return personal;
	}

	public void setPersonal(PersonalVO personal) {
		this.personal = personal;
	}

	
	

	public PersonalContratoAdendaVO getPersonalContratoAdenda() {
		return personalContratoAdenda;
	}

	public void setPersonalContratoAdenda(
			PersonalContratoAdendaVO personalContratoAdenda) {
		this.personalContratoAdenda = personalContratoAdenda;
	}
	
	
	

	public int getInt_dias_vac_corresponde() {
		return int_dias_vac_corresponde;
	}

	public void setInt_dias_vac_corresponde(int int_dias_vac_corresponde) {
		this.int_dias_vac_corresponde = int_dias_vac_corresponde;
	}

	public int getInt_dias_vac_goce() {
		return int_dias_vac_goce;
	}

	public void setInt_dias_vac_goce(int int_dias_vac_goce) {
		this.int_dias_vac_goce = int_dias_vac_goce;
	}

	public int getInt_dias_vac_pendientes() {
		return int_dias_vac_pendientes;
	}

	public void setInt_dias_vac_pendientes(int int_dias_vac_pendientes) {
		this.int_dias_vac_pendientes = int_dias_vac_pendientes;
	}

	public int getInt_dias_vac_truncas() {
		return int_dias_vac_truncas;
	}

	public void setInt_dias_vac_truncas(int int_dias_vac_truncas) {
		this.int_dias_vac_truncas = int_dias_vac_truncas;
	}

	public int getVac_pendientes_periodos_ant() {
		return vac_pendientes_periodos_ant;
	}

	public void setVac_pendientes_periodos_ant(int vac_pendientes_periodos_ant) {
		this.vac_pendientes_periodos_ant = vac_pendientes_periodos_ant;
	}

	public double getDouble_dias_vac_truncas() {
		return double_dias_vac_truncas;
	}

	public void setDouble_dias_vac_truncas(double double_dias_vac_truncas) {
		this.double_dias_vac_truncas = double_dias_vac_truncas;
	}

	public int getInt_cant_dias_laborados_truncos() {
		return int_cant_dias_laborados_truncos;
	}

	public void setInt_cant_dias_laborados_truncos(int int_cant_dias_laborados_truncos) {
		this.int_cant_dias_laborados_truncos = int_cant_dias_laborados_truncos;
	}

	public int getMeses_servicio() {
		return meses_servicio;
	}

	public void setMeses_servicio(int meses_servicio) {
		this.meses_servicio = meses_servicio;
	}

	public int getAnios_servicio() {
		return anios_servicio;
	}

	public void setAnios_servicio(int anios_servicio) {
		this.anios_servicio = anios_servicio;
	}

	public int getDias_servicio() {
		return dias_servicio;
	}

	public void setDias_servicio(int dias_servicio) {
		this.dias_servicio = dias_servicio;
	}
	
	
	
	
	
//	  srl_id_pers_vac serial NOT NULL,
//	  int_periodo_vac integer NOT NULL,
//	  dte_fec_inicio_programacion_vac date NOT NULL, -- Fecha iniciará a tomar sus vacaciones el Personal
//	  int_est_vacaciones integer NOT NULL DEFAULT 2, -- 0: Goce completo...
//	  dte_fec_vac_aprobadas date, -- Fecha en que se aprueba por OA, despues de haber realizado las coordinaciones con las Areas.
//	  tsp_fec_sys_crea timestamp with time zone,
//	  tsp_fec_sys_mod timestamp with time zone,
//	  int_dias_vac_uso
//	  int_dias_vac_goce
//	  int_dias_vac_pendientes -----------No esta en la tabla
//	int_dias_vac_truncas
	
}
