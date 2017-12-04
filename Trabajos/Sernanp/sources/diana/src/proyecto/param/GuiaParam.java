package proyecto.param;

import java.io.Serializable;

import proyecto.vo.Areanatural;
import proyecto.vo.Guia;
import proyecto.vo.Operadorturismo;
import proyecto.vo.Turismo;

public class GuiaParam implements Serializable{
	private Guia guia;
	private Turismo turismo;
	
	
	public GuiaParam(){
		guia=new Guia();
		turismo=new Turismo();
	}




	public Turismo getTurismo() {
		return turismo;
	}


	public void setTurismo(Turismo turismo) {
		this.turismo = turismo;
	}




	public Guia getGuia() {
		return guia;
	}




	public void setGuia(Guia guia) {
		this.guia = guia;
	}
	
	
	
	
	
	
	

}
