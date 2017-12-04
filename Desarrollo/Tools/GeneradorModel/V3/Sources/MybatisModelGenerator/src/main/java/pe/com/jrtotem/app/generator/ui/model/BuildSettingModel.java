package pe.com.jrtotem.app.generator.ui.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;

public class BuildSettingModel {
	
	private IntegerProperty id_build_setting;

    private StringProperty name_setting;

    private StringProperty main_path;

    private StringProperty model_path;

    private StringProperty criteria_path;

    private StringProperty mapper_path;

    private StringProperty xml_path;
    
    private StringProperty date_record;

	public IntegerProperty getId_build_setting() {
		return id_build_setting;
	}

	public void setId_build_setting(IntegerProperty id_build_setting) {
		this.id_build_setting = id_build_setting;
	}

	public StringProperty getName_setting() {
		return name_setting;
	}

	public void setName_setting(StringProperty name_setting) {
		this.name_setting = name_setting;
	}

	public StringProperty getMain_path() {
		return main_path;
	}

	public void setMain_path(StringProperty main_path) {
		this.main_path = main_path;
	}

	public StringProperty getModel_path() {
		return model_path;
	}

	public void setModel_path(StringProperty model_path) {
		this.model_path = model_path;
	}

	public StringProperty getCriteria_path() {
		return criteria_path;
	}

	public void setCriteria_path(StringProperty criteria_path) {
		this.criteria_path = criteria_path;
	}

	public StringProperty getMapper_path() {
		return mapper_path;
	}

	public void setMapper_path(StringProperty mapper_path) {
		this.mapper_path = mapper_path;
	}

	public StringProperty getXml_path() {
		return xml_path;
	}

	public void setXml_path(StringProperty xml_path) {
		this.xml_path = xml_path;
	}

	public StringProperty getDate_record() {
		return date_record;
	}

	public void setDate_record(StringProperty date_record) {
		this.date_record = date_record;
	}
        
}
