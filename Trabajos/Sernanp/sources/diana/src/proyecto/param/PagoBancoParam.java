package proyecto.param;

import java.io.Serializable;

import proyecto.vo.Areanatural;
import proyecto.vo.Operadorturismo;
import proyecto.vo.PagoBanco;

public class PagoBancoParam implements Serializable{
	private Operadorturismo operadorturismo;
	private PagoBanco pagobanco;
	private double saldo;
	private String codigoficha;
	private Areanatural areanatural;
	
	
	public PagoBancoParam(){
		operadorturismo=new Operadorturismo();
		pagobanco=new PagoBanco();
		areanatural=new Areanatural();
	}


	public Operadorturismo getOperadorturismo() {
		return operadorturismo;
	}


	public void setOperadorturismo(Operadorturismo operadorturismo) {
		this.operadorturismo = operadorturismo;
	}


	public PagoBanco getPagobanco() {
		return pagobanco;
	}


	public void setPagobanco(PagoBanco pagobanco) {
		this.pagobanco = pagobanco;
	}


	public double getSaldo() {
		return saldo;
	}


	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}


	public String getCodigoficha() {
		return codigoficha;
	}


	public void setCodigoficha(String codigoficha) {
		this.codigoficha = codigoficha;
	}


	public Areanatural getAreanatural() {
		return areanatural;
	}


	public void setAreanatural(Areanatural areanatural) {
		this.areanatural = areanatural;
	}


	
	
	
	
	
	
	

}
