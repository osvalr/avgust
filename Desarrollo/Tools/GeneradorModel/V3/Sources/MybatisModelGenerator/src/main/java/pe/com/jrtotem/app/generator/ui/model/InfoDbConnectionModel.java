package pe.com.jrtotem.app.generator.ui.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;

public class InfoDbConnectionModel {
	
	private IntegerProperty id_info_db_connection;

	private StringProperty name;
	
	private StringProperty engine;
	
    private StringProperty url;

    private StringProperty jdbc_class;

    private StringProperty name_user;

    private StringProperty password_user;

    private IntegerProperty state;

    private StringProperty date_record;

	public IntegerProperty getId_info_db_connection() {
		return id_info_db_connection;
	}

	public void setId_info_db_connection(IntegerProperty id_info_db_connection) {
		this.id_info_db_connection = id_info_db_connection;
	}

	public StringProperty getUrl() { 		
		return url;
	}

	public void setUrl(StringProperty url) {
		this.url = url;
	}

	public StringProperty getJdbc_class() {
		return jdbc_class;
	}

	public void setJdbc_class(StringProperty jdbc_class) {
		this.jdbc_class = jdbc_class;
	}

	public StringProperty getName_user() {
		return name_user;
	}

	public void setName_user(StringProperty name_user) {
		this.name_user = name_user;
	}

	public StringProperty getPassword_user() {
		return password_user;
	}

	public void setPassword_user(StringProperty password_user) {
		this.password_user = password_user;
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

	public StringProperty getEngine() {
		return engine;
	}

	public void setEngine(StringProperty engine) {
		this.engine = engine;
	}

	public StringProperty getName() {
		return name;
	}

	public void setName(StringProperty name) {
		this.name = name;
	}
    
}
