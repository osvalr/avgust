package proyecto.vo;

public class Tema implements java.io.Serializable  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idtema;
	private String nombretema;
	
	
	public Tema(){
		
	}


	public int getIdtema() {
		return idtema;
	}


	public void setIdtema(int idtema) {
		this.idtema = idtema;
	}


	public String getNombretema() {
		return nombretema;
	}


	public void setNombretema(String nombretema) {
		this.nombretema = nombretema;
	}
	
	

}
