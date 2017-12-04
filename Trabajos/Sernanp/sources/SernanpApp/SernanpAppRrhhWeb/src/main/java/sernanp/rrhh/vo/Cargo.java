package sernanp.rrhh.vo;


public class Cargo  implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idcargo;
	private String nombrecargo;
	
	public Cargo() {
		super();
	}

	public Cargo(int idcargo) {
		this();
		this.idcargo=idcargo;
	}

	public int getIdcargo() {
		return idcargo;
	}

	public void setIdcargo(int idcargo) {
		this.idcargo = idcargo;
	}

	public String getNombrecargo() {
		return nombrecargo;
	}

	public void setNombrecargo(String nombrecargo) {
		this.nombrecargo = nombrecargo;
	}
	
	
	
	
	
	
	
}
