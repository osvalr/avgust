package sernanp.rrhh.vo;

import java.util.ArrayList;
import java.util.List;
import sernanp.rrhh.vo.PersonalContratoVO;

public class PersonalVO  extends Personanatural{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int 						idpersonal;
	private Personanatural 				personanatural;
	private Areaorganica 	 			areaorganica;
	private Cargo 						cargo;
	private String 						mailpersonal;
	private PersonalAsistenciaTurnoVO	turno;
	private int 						estado;
	private int							int_flag;
//	private PersonalContratoVO			personalContratoVO;
	
	private List<PersonalContratoVO> listapersonalcontrato;
	
	
	public PersonalVO() {
		personanatural			= new Personanatural();
		areaorganica			= new Areaorganica();
		turno					= new PersonalAsistenciaTurnoVO();
		cargo					= new Cargo();
//		personalContratoVO		= new PersonalContratoVO();
		listapersonalcontrato 	= new ArrayList<PersonalContratoVO>();
	}

	public PersonalVO(int idpersonal) {
		this();
		this.idpersonal=idpersonal;
	}

	
	
	
	
	public int getIdpersonal() {
		return idpersonal;
	}

	public void setIdpersonal(int idpersonal) {
		this.idpersonal = idpersonal;
	}

//	public PersonalContratoVO getPersonalContratoVO(){
//		return personalContratoVO;
//	}
//	
//	public void setPersonalContratoVO(PersonalContratoVO personalContratoVO) {
//		this.personalContratoVO = personalContratoVO;
//	}
	

	public Areaorganica getAreaorganica() {
		return areaorganica;
	}

	public void setAreaorganica(Areaorganica areaorganica) {
		this.areaorganica = areaorganica;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public String getMailpersonal() {
		return mailpersonal;
	}

	public void setMailpersonal(String mailpersonal) {
		this.mailpersonal = mailpersonal;
	}

	public Personanatural getPersonanatural() {
		return personanatural;
	}

	public void setPersonanatural(Personanatural personanatural) {
		this.personanatural = personanatural;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public List<PersonalContratoVO> getListapersonalcontrato() {
		return listapersonalcontrato;
	}

	public void setListapersonalcontrato(
			List<PersonalContratoVO> listapersonalcontrato) {
		this.listapersonalcontrato = listapersonalcontrato;
	}

	public PersonalAsistenciaTurnoVO getTurno() {
		return turno;
	}

	public void setTurno(PersonalAsistenciaTurnoVO turno) {
		this.turno = turno;
	}

	public int getInt_flag() {
		return int_flag;
	}

	public void setInt_flag(int int_flag) {
		this.int_flag = int_flag;
	}

	
	
	
}
