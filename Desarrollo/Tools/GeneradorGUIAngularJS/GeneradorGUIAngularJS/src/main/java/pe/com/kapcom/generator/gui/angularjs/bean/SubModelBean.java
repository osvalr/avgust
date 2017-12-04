package pe.com.kapcom.generator.gui.angularjs.bean;

import java.util.List;

import pe.com.jrtotem.app.generator.jaxb.PropertyType;

public class SubModelBean {
	
	private String nameModel;
	private String nameCrud;
	private boolean autoIdentityPrimaryKey;
	private String propertyId;
	private List<PropertyType> inputs;
	private List<PropertyType> outputs;

	public String getNameCrud() {
		return nameCrud;
	}

	public void setNameCrud(String nameCrud) {
		this.nameCrud = nameCrud;
	}

	public boolean isAutoIdentityPrimaryKey() {
		return autoIdentityPrimaryKey;
	}

	public void setAutoIdentityPrimaryKey(boolean autoIdentityPrimaryKey) {
		this.autoIdentityPrimaryKey = autoIdentityPrimaryKey;
	}

	public String getPropertyId() {
		return propertyId;
	}

	public void setPropertyId(String propertyId) {
		this.propertyId = propertyId;
	}

	public List<PropertyType> getInputs() {
		return inputs;
	}

	public void setInputs(List<PropertyType> inputs) {
		this.inputs = inputs;
	}

	public List<PropertyType> getOutputs() {
		return outputs;
	}

	public void setOutputs(List<PropertyType> outputs) {
		this.outputs = outputs;
	}

	public String getNameModel() {
		return nameModel;
	}

	public void setNameModel(String nameModel) {
		this.nameModel = nameModel;
	}
}
