package proyecto.vo;

public class HistoricoAreanatural {
	private Integer idhistoricoareanatural, idareanatural,idcategoriaanp,idadministracionareanatural,
		ideventoareanatural;
	private Double extension;
	private String fechahistoricoareanatural,siglasadministracionareanatural;       
	      
	public final Integer getIdhistoricoareanatural() {
		return idhistoricoareanatural; 
	}
	public final void setIdhistoricoareanatural(Integer idhistoricoareanatural) {
		this.idhistoricoareanatural = idhistoricoareanatural;
	}
	public final Integer getIdareanatural() {
		return idareanatural;
	}
	public final void setIdareanatural(Integer idareanatural) {
		this.idareanatural = idareanatural;
	}  
	public final Integer getIdcategoriaanp() {
		return idcategoriaanp;    
	}
	public final void setIdcategoriaanp(Integer idcategoriaanp) {
		this.idcategoriaanp = idcategoriaanp;
	}
	public final Double getExtension() {
		return extension;  
	}
	public final void setExtension(Double extension) {
		this.extension = extension;
	}
	public void setFechahistoricoareanatural(String fechahistoricoareanatural) {
		this.fechahistoricoareanatural = fechahistoricoareanatural;
	}
	public String getFechahistoricoareanatural() {
		return fechahistoricoareanatural;
	}
	public void setIdadministracionareanatural(
			Integer idadministracionareanatural) {
		this.idadministracionareanatural = idadministracionareanatural;
	}
	public Integer getIdadministracionareanatural() {
		return idadministracionareanatural;
	}
	public void setIdeventoareanatural(Integer ideventoareanatural) {
		this.ideventoareanatural = ideventoareanatural;
	}
	public Integer getIdeventoareanatural() {
		return ideventoareanatural;
	}
	public void setSiglasadministracionareanatural(
			String siglasadministracionareanatural) {
		this.siglasadministracionareanatural = siglasadministracionareanatural;
	}
	public String getSiglasadministracionareanatural() {
		return siglasadministracionareanatural;
	}
}
