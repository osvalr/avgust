package com.sakerk.generador.bean;

import java.util.ArrayList;
import java.util.List;

public class ConfigBean {
	
	private String nameConfig;
	
	private String pathProject;
	
	private String pathPackageModel;
	private String textPackageModel;
	private Integer indexPackageModel;
	
	private String pathPackageMapperInterface;
	private String textPackageMapperInterface;
	private Integer indexPackageMapperInterface;
	
	private String pathPackageMapperXML;
	private String textPackageMapperXML;
	private Integer indexPackageMapperXML;
	
	private String textEngine;
	private Integer indexEngine;
	private String driverClass;
	private String url;
	private String user;
	private String password;
	
	private List<QueryBean> listQueryBean = new ArrayList<QueryBean>();
	
	public String getPathProject() {
		return pathProject;
	}
	public void setPathProject(String pathProject) {
		this.pathProject = pathProject;
	}
	public String getPathPackageModel() {
		return pathPackageModel;
	}
	public void setPathPackageModel(String pathPackageModel) {
		this.pathPackageModel = pathPackageModel;
	}
	public String getTextPackageModel() {
		return textPackageModel;
	}
	public void setTextPackageModel(String textPackageModel) {
		this.textPackageModel = textPackageModel;
	}
	public Integer getIndexPackageModel() {
		return indexPackageModel;
	}
	public void setIndexPackageModel(Integer indexPackageModel) {
		this.indexPackageModel = indexPackageModel;
	}
	public String getPathPackageMapperInterface() {
		return pathPackageMapperInterface;
	}
	public void setPathPackageMapperInterface(String pathPackageMapperInterface) {
		this.pathPackageMapperInterface = pathPackageMapperInterface;
	}
	public String getTextPackageMapperInterface() {
		return textPackageMapperInterface;
	}
	public void setTextPackageMapperInterface(String textPackageMapperInterface) {
		this.textPackageMapperInterface = textPackageMapperInterface;
	}
	public Integer getIndexPackageMapperInterface() {
		return indexPackageMapperInterface;
	}
	public void setIndexPackageMapperInterface(Integer indexPackageMapperInterface) {
		this.indexPackageMapperInterface = indexPackageMapperInterface;
	}
	public String getPathPackageMapperXML() {
		return pathPackageMapperXML;
	}
	public void setPathPackageMapperXML(String pathPackageMapperXML) {
		this.pathPackageMapperXML = pathPackageMapperXML;
	}
	public String getTextPackageMapperXML() {
		return textPackageMapperXML;
	}
	public void setTextPackageMapperXML(String textPackageMapperXML) {
		this.textPackageMapperXML = textPackageMapperXML;
	}
	public Integer getIndexPackageMapperXML() {
		return indexPackageMapperXML;
	}
	public void setIndexPackageMapperXML(Integer indexPackageMapperXML) {
		this.indexPackageMapperXML = indexPackageMapperXML;
	}
	public String getDriverClass() {
		return driverClass;
	}
	public void setDriverClass(String driverClass) {
		this.driverClass = driverClass;
	}
	public Integer getIndexEngine() {
		return indexEngine;
	}
	public void setIndexEngine(Integer indexEngine) {
		this.indexEngine = indexEngine;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTextEngine() {
		return textEngine;
	}
	public void setTextEngine(String textEngine) {
		this.textEngine = textEngine;
	}
	@Override
	public String toString() {
		return "ConfigBean [pathProject=" + pathProject + ", pathPackageModel="
				+ pathPackageModel + ", textPackageModel=" + textPackageModel
				+ ", indexPackageModel=" + indexPackageModel
				+ ", pathPackageMapperInterface=" + pathPackageMapperInterface
				+ ", textPackageMapperInterface=" + textPackageMapperInterface
				+ ", indexPackageMapperInterface="
				+ indexPackageMapperInterface + ", pathPackageMapperXML="
				+ pathPackageMapperXML + ", textPackageMapperXML="
				+ textPackageMapperXML + ", indexPackageMapperXML="
				+ indexPackageMapperXML + ", textEngine=" + textEngine
				+ ", indexEngine=" + indexEngine + ", driverClass="
				+ driverClass + ", url=" + url + ", user=" + user
				+ ", password=" + password + "]";
	}
	public List<QueryBean> getListQueryBean() {
		return listQueryBean;
	}
	public void setListQueryBean(List<QueryBean> listQueryBean) {
		this.listQueryBean = listQueryBean;
	}
	public String getNameConfig() {
		return nameConfig;
	}
	public void setNameConfig(String nameConfig) {
		this.nameConfig = nameConfig;
	}
	
}
