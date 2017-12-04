package proyecto.vo;


public class Personal  extends Personanatural{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idpersonal;
	//private Personanatural personanatural;
	private Areaorganica areaorganica;
	private Cargo cargo;
	private String mailpersonal;
	
	
	public Personal() {
		//personanatural=new Personanatural();
		areaorganica=new Areaorganica();
		cargo=new Cargo();
	}

	public Personal(int idpersonal) {
		this();
		this.idpersonal=idpersonal;
	}

	public int getIdpersonal() {
		return idpersonal;
	}

	public void setIdpersonal(int idpersonal) {
		this.idpersonal = idpersonal;
	}

	

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
	
	
	
	
	
	
	
}
