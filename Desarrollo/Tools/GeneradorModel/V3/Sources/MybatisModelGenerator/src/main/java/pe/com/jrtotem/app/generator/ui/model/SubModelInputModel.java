package pe.com.jrtotem.app.generator.ui.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;

public class SubModelInputModel {
	
	private IntegerProperty id_sub_model_input;
	private IntegerProperty id_model_input_parent; 
	private IntegerProperty id_model_input_child; 
    private StringProperty name_model;

	public IntegerProperty getId_sub_model_input() {
		return id_sub_model_input;
	}

	public void setId_sub_model_input(IntegerProperty id_sub_model_input) {
		this.id_sub_model_input = id_sub_model_input;
	}

	public IntegerProperty getId_model_input_parent() {
		return id_model_input_parent;
	}

	public void setId_model_input_parent(IntegerProperty id_model_input_parent) {
		this.id_model_input_parent = id_model_input_parent;
	}

	public IntegerProperty getId_model_input_child() {
		return id_model_input_child;
	}

	public void setId_model_input_child(IntegerProperty id_model_input_child) {
		this.id_model_input_child = id_model_input_child;
	}

	public StringProperty getName_model() {
		return name_model;
	}

	public void setName_model(StringProperty name_model) {
		this.name_model = name_model;
	}

}
