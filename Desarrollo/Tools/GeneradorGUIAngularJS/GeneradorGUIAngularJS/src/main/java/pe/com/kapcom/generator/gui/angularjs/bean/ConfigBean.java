package pe.com.kapcom.generator.gui.angularjs.bean;

import java.util.ArrayList;
import java.util.List;

public class ConfigBean {
	
	private String titleCrud;
	private String nameCrud;
	private String constUrlApi;
	private boolean autoIdentityPrimaryKey;
	private String nameModelXml;
	private String pathSrc;
	private List<SubModelBean> subModels = new ArrayList<>();
	
	public String getTitleCrud() {
		return titleCrud;
	}
	public void setTitleCrud(String titleCrud) {
		this.titleCrud = titleCrud;
	}
	public String getNameCrud() {
		return nameCrud;
	}
	public void setNameCrud(String nameCrud) {
		this.nameCrud = nameCrud;
	}
	public String getConstUrlApi() {
		return constUrlApi;
	}
	public void setConstUrlApi(String constUrlApi) {
		this.constUrlApi = constUrlApi;
	}
	public boolean isAutoIdentityPrimaryKey() {
		return autoIdentityPrimaryKey;
	}
	public void setAutoIdentityPrimaryKey(boolean autoIdentityPrimaryKey) {
		this.autoIdentityPrimaryKey = autoIdentityPrimaryKey;
	}
	public String getNameModelXml() {
		return nameModelXml;
	}
	public void setNameModelXml(String nameModelXml) {
		this.nameModelXml = nameModelXml;
	}
	public String getPathSrc() {
		return pathSrc;
	}
	public void setPathSrc(String pathSrc) {
		this.pathSrc = pathSrc;
	}
	public List<SubModelBean> getSubModels() {
		return subModels;
	}
	public void setSubModels(List<SubModelBean> subModels) {
		this.subModels = subModels;
	}

}
