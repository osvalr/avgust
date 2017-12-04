package pe.com.jrtotem.app.generator.ui.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;

public class ModelInputModel {
	
	private IntegerProperty id_model_input;
	
	private IntegerProperty id_info_db_connection;
	
	private StringProperty name_connection;

    private StringProperty name_model;

    private StringProperty sql_text;

    private IntegerProperty state;

    private StringProperty date_record;

	public IntegerProperty getId_model_input() {
		return id_model_input;
	}

	public void setId_model_input(IntegerProperty id_model_input) {
		this.id_model_input = id_model_input;
	}

	public IntegerProperty getId_info_db_connection() {
		return id_info_db_connection;
	}

	public void setId_info_db_connection(IntegerProperty id_info_db_connection) {
		this.id_info_db_connection = id_info_db_connection;
	}

	public StringProperty getName_model() {
		return name_model;
	}

	public void setName_model(StringProperty name_model) {
		this.name_model = name_model;
	}

	public StringProperty getSql_text() {
		return sql_text;
	}

	public void setSql_text(StringProperty sql_text) {
		this.sql_text = sql_text;
	}

	public IntegerProperty getState() {
		return state;
	}

	public void setState(IntegerProperty state) {
		this.state = state;
	}

	public StringProperty getDate_record() {
		return date_record;
	}

	public void setDate_record(StringProperty date_record) {
		this.date_record = date_record;
	}

	public StringProperty getName_connection() {
		return name_connection;
	}

	public void setName_connection(StringProperty name_connection) {
		this.name_connection = name_connection;
	}
    
    
}
