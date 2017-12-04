package com.sakerk.generador.definition;

import java.util.ArrayList;
import java.util.List;

public class QueryGenerador {
	
	private String nombreQuery;
	private String queryFormat;
	private String rutaSalidaJava;
	private String rutaSalidaResources;
	private String packageDao;
	private String packageDto;
	private String packageMapper;
	private List<ParametrosGenerador> parametros = new ArrayList<ParametrosGenerador>();
	private String output;
	private String input;
	private String from;
	private Integer tipoQuery;
	
	public String getNombreQuery() {
		return nombreQuery;
	}
	public void setNombreQuery(String nombreQuery) {
		this.nombreQuery = nombreQuery;
	}
	public List<ParametrosGenerador> getParametros() {
		return parametros;
	}
	public void setParametros(List<ParametrosGenerador> parametros) {
		this.parametros = parametros;
	}
	public String getPackageDao() {
		return packageDao;
	}
	public void setPackageDao(String packageDao) {
		this.packageDao = packageDao;
	}
	public String getPackageDto() {
		return packageDto;
	}
	public void setPackageDto(String packageDto) {
		this.packageDto = packageDto;
	}
	public String getRutaSalidaJava() {
		return rutaSalidaJava;
	}
	public void setRutaSalidaJava(String rutaSalidaJava) {
		this.rutaSalidaJava = rutaSalidaJava;
	}
	public String getRutaSalidaResources() {
		return rutaSalidaResources;
	}
	public void setRutaSalidaResources(String rutaSalidaResources) {
		this.rutaSalidaResources = rutaSalidaResources;
	}
	public String getPackageMapper() {
		return packageMapper;
	}
	public void setPackageMapper(String packageMapper) {
		this.packageMapper = packageMapper;
	}
	public String getQueryFormat() {
		return queryFormat;
	}
	public void setQueryFormat(String queryFormat) {
		this.queryFormat = queryFormat;
	}
	public String getOutput() {
		return output;
	}
	public void setOutput(String output) {
		this.output = output;
	}
	public String getInput() {
		return input;
	}
	public void setInput(String input) {
		this.input = input;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public Integer getTipoQuery() {
		return tipoQuery;
	}
	public void setTipoQuery(Integer tipoQuery) {
		this.tipoQuery = tipoQuery;
	}

}
