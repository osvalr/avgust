package com.sakerk.generador.definition;

public class ParametrosGenerador {
	
	private String nombreParametro;
	private String tipoDato;
	private String tipoEntradaSalida;
	private String testValue;
	
	public String getTipoEntradaSalida() {
		return tipoEntradaSalida;
	}
	public void setTipoEntradaSalida(String tipoEntradaSalida) {
		this.tipoEntradaSalida = tipoEntradaSalida;
	}
	public String getNombreParametro() {
		return nombreParametro;
	}
	public void setNombreParametro(String nombreParametro) {
		this.nombreParametro = nombreParametro;
	}
	public String getTipoDato() {
		return tipoDato;
	}
	public void setTipoDato(String tipoDato) {
		this.tipoDato = tipoDato;
	}
	@Override
	public String toString() {
		return "ParametrosGenerador [nombreParametro=" + nombreParametro
				+ ", tipoDato=" + tipoDato + ", tipoEntradaSalida="
				+ tipoEntradaSalida + "]";
	}
	public String getTestValue() {
		return testValue;
	}
	public void setTestValue(String testValue) {
		this.testValue = testValue;
	}
	
}
