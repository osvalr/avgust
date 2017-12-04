package proyecto.vo;

import java.io.Serializable;

public class AdministracionAreanatural  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idadministracionareanatural;
	private String nombreadministracionareanatural;
	private String siglasadministracionareanatural;
	
	
	public AdministracionAreanatural(){
		
	}


	public int getIdadministracionareanatural() {
		return idadministracionareanatural;
	}


	public void setIdadministracionareanatural(int idadministracionareanatural) {
		this.idadministracionareanatural = idadministracionareanatural;
	}


	public String getNombreadministracionareanatural() {
		return nombreadministracionareanatural;
	}


	public void setNombreadministracionareanatural(
			String nombreadministracionareanatural) {
		this.nombreadministracionareanatural = nombreadministracionareanatural;
	}


	public String getSiglasadministracionareanatural() {
		return siglasadministracionareanatural;
	}


	public void setSiglasadministracionareanatural(
			String siglasadministracionareanatural) {
		this.siglasadministracionareanatural = siglasadministracionareanatural;
	}
	
	
	
	
	
}
