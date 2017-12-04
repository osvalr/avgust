package sernanp.rrhh.vo;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;


public class PersonalMarcacionVO {
	
	
	private int 		srl_id_personal_marcacion; 
	private Date 		dte_fec_marc;
	private Time 		hor_hor_marc;
	private Date 		dte_fec_marc1;
	private Date 		dte_fec_marc2;
	private Time 		hor_hor_marc1;
	private int 		idpersonal;
	private PersonalVO  personal;
	private Timestamp	tsp_fec_crea;
	private int			int_id_usu_crea;
	private Timestamp	tsp_fec_mod;
	private int			int_id_usu_mod;
	private int			idtablatipo;
	private Tipo		tipomarcacion;
	private int			srl_id_per_activ; 
	private String		var_descripcion;
	private int			int_flag;
	private PersonalActividadVO personalActividad;
	private PersonalAsistenciaTurnoVO personalAsistenciaTurno;
	
	//Para determinar si es hora de Ingreso o Salida en la tabla t_personal_asistencia.
	private int 			ingreso_o_salida;
	
	//Para determinar si es hora de Ingreso o Salida en la tabla t_personal_asistencia.
	private int			srl_id_papeleta;
	private int			hor_sal_o_ret_papeleta;
	
	//HORAS DE SALIDA Y RETORNO PARA EL REFRIGERIO
	private Time hor_hor_salida_ref;
	private Time hor_hor_retorno_ref;
	private int int_marc_refrigerio;
	
	private int val_temp;

	
	
	public PersonalMarcacionVO (){
		personal 				= new PersonalVO();
		tipomarcacion			= new Tipo();
		personalActividad		= new PersonalActividadVO();
		personalAsistenciaTurno = new PersonalAsistenciaTurnoVO();
	}
	
	
	public int getSrl_id_personal_marcacion() {
		return srl_id_personal_marcacion;
	}

	public void setSrl_id_personal_marcacion(int srl_id_personal_marcacion) {
		this.srl_id_personal_marcacion = srl_id_personal_marcacion;
	}

	public Date getDte_fec_marc() {
		return dte_fec_marc;
	}

	public void setDte_fec_marc(Date dte_fec_marc) {
		this.dte_fec_marc = dte_fec_marc;
	}

	public Time getHor_hor_marc() {
		return hor_hor_marc;
	}

	public void setHor_hor_marc(Time hor_hor_marc) {
		this.hor_hor_marc = hor_hor_marc;
	}

	public PersonalVO getPersonal() {
		return personal;
	}

	public void setPersonal(PersonalVO personal) {
		this.personal = personal;
	}

	public Timestamp getTsp_fec_crea() {
		return tsp_fec_crea;
	}

	public void setTsp_fec_crea(Timestamp tsp_fec_crea) {
		this.tsp_fec_crea = tsp_fec_crea;
	}

	public int getInt_id_usu_crea() {
		return int_id_usu_crea;
	}

	public void setInt_id_usu_crea(int int_id_usu_crea) {
		this.int_id_usu_crea = int_id_usu_crea;
	}

	public Timestamp getTsp_fec_mod() {
		return tsp_fec_mod;
	}

	public void setTsp_fec_mod(Timestamp tsp_fec_mod) {
		this.tsp_fec_mod = tsp_fec_mod;
	}

	public int getInt_id_usu_mod() {
		return int_id_usu_mod;
	}

	public void setInt_id_usu_mod(int int_id_usu_mod) {
		this.int_id_usu_mod = int_id_usu_mod;
	}

	public int getIdpersonal() {
		return idpersonal;
	}

	public void setIdpersonal(int idpersonal) {
		this.idpersonal = idpersonal;
	}


	public Tipo getTipomarcacion() {
		return tipomarcacion;
	}


	public void setTipomarcacion(Tipo tipomarcacion) {
		this.tipomarcacion = tipomarcacion;
	}


	public int getSrl_id_per_activ() {
		return srl_id_per_activ;
	}


	public void setSrl_id_per_activ(int srl_id_per_activ) {
		this.srl_id_per_activ = srl_id_per_activ;
	}


	public String getVar_descripcion() {
		return var_descripcion;
	}


	public void setVar_descripcion(String var_descripcion) {
		this.var_descripcion = var_descripcion;
	}


	public Date getDte_fec_marc1() {
		return dte_fec_marc1;
	}


	public void setDte_fec_marc1(Date dte_fec_marc1) {
		this.dte_fec_marc1 = dte_fec_marc1;
	}


	public Time getHor_hor_marc1() {
		return hor_hor_marc1;
	}


	public void setHor_hor_marc1(Time hor_hor_marc1) {
		this.hor_hor_marc1 = hor_hor_marc1;
	}


	public PersonalActividadVO getPersonalActividad() {
		return personalActividad;
	}


	public void setPersonalActividad(PersonalActividadVO personalActividad) {
		this.personalActividad = personalActividad;
	}


	public int getIdtablatipo() {
		return idtablatipo;
	}


	public void setIdtablatipo(int idtablatipo) {
		this.idtablatipo = idtablatipo;
	}
	
	public int getIngreso_o_salida() {
		return ingreso_o_salida;
	}

	public void setIngreso_o_salida(int ingreso_o_salida) {
		this.ingreso_o_salida = ingreso_o_salida;
	}

	public int getInt_flag() {
		return int_flag;
	}

	public void setInt_flag(int int_flag) {
		this.int_flag = int_flag;
	}


	public PersonalAsistenciaTurnoVO getPersonalAsistenciaTurno() {
		return personalAsistenciaTurno;
	}


	public void setPersonalAsistenciaTurno(
			PersonalAsistenciaTurnoVO personalAsistenciaTurno) {
		this.personalAsistenciaTurno = personalAsistenciaTurno;
	}


	public Date getDte_fec_marc2() {
		return dte_fec_marc2;
	}


	public void setDte_fec_marc2(Date dte_fec_marc2) {
		this.dte_fec_marc2 = dte_fec_marc2;
	}


	public int getHor_sal_o_ret_papeleta() {
		return hor_sal_o_ret_papeleta;
	}


	public void setHor_sal_o_ret_papeleta(int hor_sal_o_ret_papeleta) {
		this.hor_sal_o_ret_papeleta = hor_sal_o_ret_papeleta;
	}


	public int getSrl_id_papeleta() {
		return srl_id_papeleta;
	}


	public void setSrl_id_papeleta(int srl_id_papeleta) {
		this.srl_id_papeleta = srl_id_papeleta;
	}


	public Time getHor_hor_salida_ref() {
		return hor_hor_salida_ref;
	}


	public void setHor_hor_salida_ref(Time hor_hor_salida_ref) {
		this.hor_hor_salida_ref = hor_hor_salida_ref;
	}


	public Time getHor_hor_retorno_ref() {
		return hor_hor_retorno_ref;
	}


	public void setHor_hor_retorno_ref(Time hor_hor_retorno_ref) {
		this.hor_hor_retorno_ref = hor_hor_retorno_ref;
	}


	public int getInt_marc_refrigerio() {
		return int_marc_refrigerio;
	}


	public void setInt_marc_refrigerio(int int_marc_refrigerio) {
		this.int_marc_refrigerio = int_marc_refrigerio;
	}


	public int getVal_temp() {
		return val_temp;
	}


	public void setVal_temp(int val_temp) {
		this.val_temp = val_temp;
	}


	
	
	
}