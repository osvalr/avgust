package pe.com.jrtotem.app.generator.dto;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;

public class PropertyModel {
	
	private IntegerProperty id_property;
	private StringProperty name;
	private StringProperty data_type;
	
	public IntegerProperty getId_property() {
		return id_property;
	}
	public void setId_property(IntegerProperty id_property) {
		this.id_property = id_property;
	}
	public StringProperty getName() {
		return name;
	}
	public void setName(StringProperty name) {
		this.name = name;
	}
	public StringProperty getData_type() {
		return data_type;
	}
	public void setData_type(StringProperty data_type) {
		this.data_type = data_type;
	}
	
}
