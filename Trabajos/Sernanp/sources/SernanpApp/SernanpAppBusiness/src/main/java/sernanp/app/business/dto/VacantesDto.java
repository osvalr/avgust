package sernanp.app.business.dto;

public class VacantesDto {
	
	private Integer cantidadVacantes;
	private Integer cantidadRegistros;
	private Integer cantidadDisponibles;
	private Integer ordenMerito;
	
	public Integer getCantidadVacantes() {
		return cantidadVacantes;
	}
	public void setCantidadVacantes(Integer cantidadVacantes) {
		this.cantidadVacantes = cantidadVacantes;
	}
	public Integer getCantidadRegistros() {
		return cantidadRegistros;
	}
	public void setCantidadRegistros(Integer cantidadRegistros) {
		this.cantidadRegistros = cantidadRegistros;
	}
	public Integer getCantidadDisponibles() {
		return cantidadDisponibles;
	}
	public void setCantidadDisponibles(Integer cantidadDisponibles) {
		this.cantidadDisponibles = cantidadDisponibles;
	}
	public Integer getOrdenMerito() {
		return ordenMerito;
	}
	public void setOrdenMerito(Integer ordenMerito) {
		this.ordenMerito = ordenMerito;
	}
	
}
