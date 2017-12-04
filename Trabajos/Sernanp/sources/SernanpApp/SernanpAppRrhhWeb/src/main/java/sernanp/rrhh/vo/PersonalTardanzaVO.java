package sernanp.rrhh.vo;
import java.sql.Date;
public class PersonalTardanzaVO {
	
	
	  private int srl_id_pers_tard;
	  private Date dte_fec_pers_tard;
	  private int int_min_tard;
	  private PersonalVO personal;
	  private PersonalContratoVO personalContratoVO;  
	  
	  public PersonalTardanzaVO(){
		  personal				= new PersonalVO();
		  personalContratoVO	= new PersonalContratoVO();
	  }

	  
	  
	public PersonalContratoVO getPersonalContratoVO() {
		return personalContratoVO;
	}

	public void setPersonalContratoVO(PersonalContratoVO personalContratoVO) {
		this.personalContratoVO = personalContratoVO;
	}
		  
	  
	  
	public int getSrl_id_pers_tard() {
		return srl_id_pers_tard;
	}

	public void setSrl_id_pers_tard(int srl_id_pers_tard) {
		this.srl_id_pers_tard = srl_id_pers_tard;
	}

	public Date getDte_fec_pers_tard() {
		return dte_fec_pers_tard;
	}

	public void setDte_fec_pers_tard(Date dte_fec_pers_tard) {
		this.dte_fec_pers_tard = dte_fec_pers_tard;
	}

	public int getInt_min_tard() {
		return int_min_tard;
	}

	public void setInt_min_tard(int int_min_tard) {
		this.int_min_tard = int_min_tard;
	}

	public PersonalVO getPersonal() {
		return personal;
	}

	public void setPersonal(PersonalVO personal) {
		this.personal = personal;
	}
	  
	  
	  
	  

}
