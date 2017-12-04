package proyecto.param;

import java.io.Serializable;

import proyecto.vo.Areanatural;

public class TurismoParam implements Serializable{
	private Areanatural areanatural;
	private int periodo;
	
	
	public TurismoParam(){
		areanatural=new Areanatural();
	}
	
	public Areanatural getAreanatural() {
		return areanatural;
	}
	public void setAreanatural(Areanatural areanatural) {
		this.areanatural = areanatural;
	}
	public int getPeriodo() {
		return periodo;
	}
	public void setPeriodo(int periodo) {
		this.periodo = periodo;
	}
	
	
	
	
	

}
