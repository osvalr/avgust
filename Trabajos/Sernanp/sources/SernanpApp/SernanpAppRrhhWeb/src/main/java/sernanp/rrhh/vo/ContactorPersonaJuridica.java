package sernanp.rrhh.vo;

public class ContactorPersonaJuridica extends Persona {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idcontactopersonajuridica;
	private Personajuridica personajuridica;
		
	public ContactorPersonaJuridica() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdcontactopersonajuridica() {
		return idcontactopersonajuridica;
	}

	public void setIdcontactopersonajuridica(int idcontactopersonajuridica) {
		this.idcontactopersonajuridica = idcontactopersonajuridica;
	}

	public Personajuridica getPersonajuridica() {
		return personajuridica;
	}

	public void setPersonajuridica(Personajuridica personajuridica) {
		this.personajuridica = personajuridica;
	}

	
	
	
}
