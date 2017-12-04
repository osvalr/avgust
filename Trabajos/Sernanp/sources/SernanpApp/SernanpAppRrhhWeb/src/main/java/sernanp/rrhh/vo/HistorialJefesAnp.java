package sernanp.rrhh.vo;

import java.sql.Timestamp;

public class HistorialJefesAnp {

	private int idhistorialjefesanp;
	private Areanatural areanatural;
	private PersonalVO personal;
	private int periodo;
	private Timestamp fechadesigna;
	
	
	
	public HistorialJefesAnp() {
		super();
	}	
	
	public int getIdhistorialjefesanp() {
		return idhistorialjefesanp;
	}
	public void setIdhistorialjefesanp(int idhistorialjefesanp) {
		this.idhistorialjefesanp = idhistorialjefesanp;
	}
	public Areanatural getAreanatural() {
		return areanatural;
	}
	public void setAreanatural(Areanatural areanatural) {
		this.areanatural = areanatural;
	}
	public PersonalVO getPersonal() {
		return personal;
	}
	public void setPersonal(PersonalVO personal) {
		this.personal = personal;
	}
	public int getPeriodo() {
		return periodo;
	}
	public void setPeriodo(int periodo) {
		this.periodo = periodo;
	}
	public Timestamp getFechadesigna() {
		return fechadesigna;
	}
	public void setFechadesigna(Timestamp fechadesigna) {
		this.fechadesigna = fechadesigna;
	}
	
	
}
