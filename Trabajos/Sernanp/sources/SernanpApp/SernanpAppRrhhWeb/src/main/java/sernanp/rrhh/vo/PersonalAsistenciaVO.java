package sernanp.rrhh.vo;

import java.sql.Date;
import java.sql.Time;

public class PersonalAsistenciaVO {
	
//	private static final long serialVersionUID = 1L;
	
	private int 			srl_id_personal_asistencia;		
	private Date 			dte_fecha;
	private Time 			hor_hor_ingreso;
	private Time 			hor_hor_salida;
	private Time			minutostardanza;
	private int 			estado;
	private int				minutosExcedentes;
	private int				minutosTardanza;
	private int				numerodia;
	private String			descoficina;
	
	/*---- SE HA CREADO PARA DISTINGUIR DE OBSERVADO CON INASISTENCIA -------*/
	private int				estadoTmp;
	private String			incidencias;
	/* ---------- FIN ------------------*/
	
	
	/*----------AGREGADO 02/07/2014 PARA EFECTOS DE MOSTRAR SU ESTADO (VACACIONES O LICENCIA)--------------------*/
	private int int_vac_lic;

	/* ---------- FIN ------------------*/
	private String str_hor_ingreso;
	private String str_hor_salida;

	/*-----------Para el Reporte-------*/
	
	private Time	hor_antes_horario;
	private String	hor_antes_horario_total;
	private String	hor_despues_horario_tardanza;
	private String	hor_despues_horario_tardanza_total;
	private Time	hor_despues_horario;
	private String	hor_despues_horario_total;
	private Time	hor_fuera_horario;
	private String	hor_fuera_horario_total;
	
	/*------FIN-------*/
	
	
	private PersonalVO	personal;
	private PersonalContratoVO personalContrato;
	
	
	public PersonalAsistenciaVO (){
		personal 					= new PersonalVO();
		personalContrato 	= new PersonalContratoVO();
	}

	public PersonalVO getPersonal() {
		return personal;
	}
	
	
	

	public void setPersonal(PersonalVO personal) {
		this.personal = personal;
	}

	public int getSrl_id_personal_asistencia() {
		return srl_id_personal_asistencia;
	}

	public void setSrl_id_personal_asistencia(int srl_id_personal_asistencia) {
		this.srl_id_personal_asistencia = srl_id_personal_asistencia;
	}

	public Date getDte_fecha() {
		return dte_fecha;
	}

	public void setDte_fecha(Date dte_fecha) {
		this.dte_fecha = dte_fecha;
	}

	public Time getHor_hor_ingreso() {
		return hor_hor_ingreso;
	}

	public void setHor_hor_ingreso(Time hor_hor_ingreso) {
		this.hor_hor_ingreso = hor_hor_ingreso;
	}

	public Time getHor_hor_salida() {
		return hor_hor_salida;
	}

	public void setHor_hor_salida(Time hor_hor_salida) {
		this.hor_hor_salida = hor_hor_salida;
	}

	public Time getMinutostardanza() {
		return minutostardanza;
	}

	public void setMinutostardanza(Time minutostardanza) {
		this.minutostardanza = minutostardanza;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public int getEstadoTmp() {
		return estadoTmp;
	}

	public void setEstadoTmp(int estadoTmp) {
		this.estadoTmp = estadoTmp;
	}

	public String getIncidencias() {
		return incidencias;
	}

	public void setIncidencias(String incidencias) {
		this.incidencias = incidencias;
	}

	public int getInt_vac_lic() {
		return int_vac_lic;
	}

	public void setInt_vac_lic(int int_vac_lic) {
		this.int_vac_lic = int_vac_lic;
	}

	public int getMinutosExcedentes() {
		return minutosExcedentes;
	}

	public void setMinutosExcedentes(int minutosExcedentes) {
		this.minutosExcedentes = minutosExcedentes;
	}

	public int getMinutosTardanza() {
		return minutosTardanza;
	}

	public void setMinutosTardanza(int minutosTardanza) {
		this.minutosTardanza = minutosTardanza;
	}

	public int getNumerodia() {
		return numerodia;
	}

	public void setNumerodia(int numerodia) {
		this.numerodia = numerodia;
	}

	public String getStr_hor_ingreso() {
		return str_hor_ingreso;
	}

	public void setStr_hor_ingreso(String str_hor_ingreso) {
		this.str_hor_ingreso = str_hor_ingreso;
	}

	public String getStr_hor_salida() {
		return str_hor_salida;
	}

	public void setStr_hor_salida(String str_hor_salida) {
		this.str_hor_salida = str_hor_salida;
	}

	public String getDescoficina() {
		return descoficina;
	}

	public void setDescoficina(String descoficina) {
		this.descoficina = descoficina;
	}

	public Time getHor_antes_horario() {
		return hor_antes_horario;
	}

	public void setHor_antes_horario(Time hor_antes_horario) {
		this.hor_antes_horario = hor_antes_horario;
	}

	public Time getHor_despues_horario() {
		return hor_despues_horario;
	}

	public void setHor_despues_horario(Time hor_despues_horario) {
		this.hor_despues_horario = hor_despues_horario;
	}

	public Time getHor_fuera_horario() {
		return hor_fuera_horario;
	}

	public void setHor_fuera_horario(Time hor_fuera_horario) {
		this.hor_fuera_horario = hor_fuera_horario;
	}

	public String getHor_fuera_horario_total() {
		return hor_fuera_horario_total;
	}

	public void setHor_fuera_horario_total(String hor_fuera_horario_total) {
		this.hor_fuera_horario_total = hor_fuera_horario_total;
	}

	public String getHor_despues_horario_tardanza() {
		return hor_despues_horario_tardanza;
	}

	public void setHor_despues_horario_tardanza(String hor_despues_horario_tardanza) {
		this.hor_despues_horario_tardanza = hor_despues_horario_tardanza;
	}

	public String getHor_antes_horario_total() {
		return hor_antes_horario_total;
	}

	public void setHor_antes_horario_total(String hor_antes_horario_total) {
		this.hor_antes_horario_total = hor_antes_horario_total;
	}

	public String getHor_despues_horario_tardanza_total() {
		return hor_despues_horario_tardanza_total;
	}

	public void setHor_despues_horario_tardanza_total(
			String hor_despues_horario_tardanza_total) {
		this.hor_despues_horario_tardanza_total = hor_despues_horario_tardanza_total;
	}

	public String getHor_despues_horario_total() {
		return hor_despues_horario_total;
	}

	public void setHor_despues_horario_total(String hor_despues_horario_total) {
		this.hor_despues_horario_total = hor_despues_horario_total;
	}

	public PersonalContratoVO getPersonalContrato() {
		return personalContrato;
	}

	public void setPersonalContrato(PersonalContratoVO personalContrato) {
		this.personalContrato = personalContrato;
	}	
	
	
	
}