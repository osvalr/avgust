package com.sakerk.generador.bean;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import com.sakerk.generador.definition.ParametrosGenerador;

public class ModelBean {
	
	private DefaultTableModel defaultTableModel;
	private List<ParametrosGenerador> listParametrosGenerador = new ArrayList<ParametrosGenerador>();
	public DefaultTableModel getDefaultTableModel() {
		return defaultTableModel;
	}
	public void setDefaultTableModel(DefaultTableModel defaultTableModel) {
		this.defaultTableModel = defaultTableModel;
	}
	public List<ParametrosGenerador> getListParametrosGenerador() {
		return listParametrosGenerador;
	}
	public void setListParametrosGenerador(
			List<ParametrosGenerador> listParametrosGenerador) {
		this.listParametrosGenerador = listParametrosGenerador;
	}
	
	
	
}
