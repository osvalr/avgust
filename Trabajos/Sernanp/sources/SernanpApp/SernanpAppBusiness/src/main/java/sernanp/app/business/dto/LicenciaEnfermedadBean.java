package sernanp.app.business.dto;

public class LicenciaEnfermedadBean {
	
	private boolean supera20Dias;
	private int diasNoLaboradosMes;
	private int totalDiasNoLaborados;
	
	public boolean isSupera20Dias() {
		return supera20Dias;
	}
	public void setSupera20Dias(boolean supera20Dias) {
		this.supera20Dias = supera20Dias;
	}
	public int getDiasNoLaboradosMes() {
		return diasNoLaboradosMes;
	}
	public void setDiasNoLaboradosMes(int diasNoLaboradosMes) {
		this.diasNoLaboradosMes = diasNoLaboradosMes;
	}
	public int getTotalDiasNoLaborados() {
		return totalDiasNoLaborados;
	}
	public void setTotalDiasNoLaborados(int totalDiasNoLaborados) {
		this.totalDiasNoLaborados = totalDiasNoLaborados;
	}

}
