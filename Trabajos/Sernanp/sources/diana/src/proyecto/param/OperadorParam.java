package proyecto.param;

import java.io.Serializable;

import proyecto.vo.Areanatural;
import proyecto.vo.Operadorturismo;
import proyecto.vo.Turismo;

public class OperadorParam implements Serializable{
	private Operadorturismo operadorturismo;
	private Turismo turismo;
	
	
	public OperadorParam(){
		operadorturismo=new Operadorturismo();
		turismo=new Turismo();
	}


	public Operadorturismo getOperadorturismo() {
		return operadorturismo;
	}


	public void setOperadorturismo(Operadorturismo operadorturismo) {
		this.operadorturismo = operadorturismo;
	}


	public Turismo getTurismo() {
		return turismo;
	}


	public void setTurismo(Turismo turismo) {
		this.turismo = turismo;
	}
	
	
	
	
	
	
	

}
