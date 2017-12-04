package pe.com.jrtotem.app.generator.dto;

import java.util.List;

public class ModelInputDto {
	
	private Integer id_model_input;
	
    private Integer id_info_db_connection;

    private String name_model;

    private String sql_text;
    
    private Integer id_model_output;
    
    private String outputs;

    private String inputs;

    private String froms;

    private Integer version;
    
    private String date_record;
    
    private boolean isNewOutput = false;
    
    private boolean isModifiedModelInput = false;
    
    private List<BuildSettingDto> listBuildSettingDtos;
    
    private List<PropertyDto> listPropertyDtos;
    
	public List<BuildSettingDto> getListBuildSettingDtos() {
		return listBuildSettingDtos;
	}

	public void setListBuildSettingDtos(List<BuildSettingDto> listBuildSettingDtos) {
		this.listBuildSettingDtos = listBuildSettingDtos;
	}

	public List<PropertyDto> getListPropertyDtos() {
		return listPropertyDtos;
	}

	public void setListPropertyDtos(List<PropertyDto> listPropertyDtos) {
		this.listPropertyDtos = listPropertyDtos;
	}

	public Integer getId_model_output() {
		return id_model_output;
	}

	public void setId_model_output(Integer id_model_output) {
		this.id_model_output = id_model_output;
	}

	public boolean isNewOutput() {
		return isNewOutput;
	}

	public void setNewOutput(boolean isNewOutput) {
		this.isNewOutput = isNewOutput;
	}

	public Integer getId_info_db_connection() {
		return id_info_db_connection;
	}

	public void setId_info_db_connection(Integer id_info_db_connection) {
		this.id_info_db_connection = id_info_db_connection;
	}

	public String getName_model() {
		return name_model;
	}

	public void setName_model(String name_model) {
		this.name_model = name_model;
	}

	public String getSql_text() {
		return sql_text;
	}

	public void setSql_text(String sql_text) {
		this.sql_text = sql_text;
	}

	public Integer getId_model_input() {
		return id_model_input;
	}

	public void setId_model_input(Integer id_model_input) {
		this.id_model_input = id_model_input;
	}

	public String getOutputs() {
		return outputs;
	}

	public void setOutputs(String outputs) {
		this.outputs = outputs;
	}

	public String getInputs() {
		return inputs;
	}

	public void setInputs(String inputs) {
		this.inputs = inputs;
	}

	public String getFroms() {
		return froms;
	}

	public void setFroms(String froms) {
		this.froms = froms;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public String getDate_record() {
		return date_record;
	}

	public void setDate_record(String date_record) {
		this.date_record = date_record;
	}

	public boolean isModifiedModelInput() {
		return isModifiedModelInput;
	}

	public void setModifiedModelInput(boolean isModifiedModelInput) {
		this.isModifiedModelInput = isModifiedModelInput;
	}
        
}
