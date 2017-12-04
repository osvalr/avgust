package com.sakerk.generador.bean;

import java.util.ArrayList;
import java.util.List;

import com.sakerk.generador.definition.ParametrosGenerador;

public class QueryBean {
	
	private String nameQuery;
	private Integer indexType;
	private String descripType;
	private String sqlCode;
	private List<ParametrosGenerador> listParametros = new ArrayList<ParametrosGenerador>();
	
	public String getNameQuery() {
		return nameQuery;
	}
	public void setNameQuery(String nameQuery) {
		this.nameQuery = nameQuery;
	}
	public Integer getIndexType() {
		return indexType;
	}
	public void setIndexType(Integer indexType) {
		this.indexType = indexType;
	}
	public String getDescripType() {
		return descripType;
	}
	public void setDescripType(String descripType) {
		this.descripType = descripType;
	}
	public String getSqlCode() {
		return sqlCode;
	}
	public void setSqlCode(String sqlCode) {
		this.sqlCode = sqlCode;
	}
	public List<ParametrosGenerador> getListParametros() {
		return listParametros;
	}
	public void setListParametros(List<ParametrosGenerador> listParametros) {
		this.listParametros = listParametros;
	}
	
}
